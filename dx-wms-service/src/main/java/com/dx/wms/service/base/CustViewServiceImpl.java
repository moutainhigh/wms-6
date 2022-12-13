/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: sss.java
 * Author:   王蕊
 * Date:     2015年7月14日 下午5:21:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.base;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.vo.RoleVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.Trans2PinYin;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.CodeRuleType;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.account.dao.ICustAccountDao;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.checker.Checker;
import com.dx.wms.service.checker.ParamChecker;
import com.dx.wms.service.exception.SaveException;

/**
 * 
 * 客户视图信息Service接口实现
 * 
 * @author 王蕊
 *
 */
@Service
public class CustViewServiceImpl implements ICustViewService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustViewServiceImpl.class);

    /**
     * 客户基本信息Dao层
     */
    @Autowired
    private ICustBaseDao custBaseDao;

    /**
     * 客户信息校验服务
     */
    @Autowired
    private Checker checkInfoService;

    /**
     * 通用服务
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 客户帐户表Dao层
     */
    @Autowired
    private ICustAccountDao custAccountDao;

    @Override
    public void save(CustBase base, Long userId) throws SaveException {
        Assert.notNull(new SaveException("Base or user id must not be null"), base, userId);
        // 判断证件号码和手机号是否重复
        if (!checkInfoService.check(new ParamChecker(base.getCustId(), base.getMobile(), false))) {
            throw new SaveException("移动电话已存在", base.getMobile());
        }
        if (!checkInfoService.check(new ParamChecker(base.getCustId(), base.getIdCard(), true))) {
            throw new SaveException("证件号码已存在", base.getIdCard());
        }
        // 更新操作人
        base.setUpdateUser(userId);

        if (!Assert.checkParam(base.getCustId())) {
            // 开户
            String custCode = commonService.getCode(CodeRuleType.CUST_CODE.getInfo(),
                    commonService.getOrgInfo(userId).getOrgId(), null);
            if (!Assert.checkParam(custCode)) {
                throw new SaveException("Cust name[{0}],mobile[{1}] init cust code error", base.getCustName(),
                        base.getMobile());
            }
            base.setCustCode(custCode);
            base.setCreateUser(userId);
            base.setCreateTime(new Date());
            Assert.notNull(
                    new SaveException("Cust name[{0}],mobile[{1}] save error", base.getCustName(), base.getMobile()),
                    custBaseDao.insert(base));
        } else {
            // 更新
            updateAccount(base,userId);
            if (!custBaseDao.update(base)) {
                throw new SaveException("Cust name[{0}],mobile[{1}] save error", base.getCustName(), base.getMobile());
            }
        }
    }

    // 判断该潜客 是否已经开户 如果开户 需要同时更新t_cust_account表
    private void updateAccount(CustBase custBase,Long userId) {
        Assert.notNull("update() custBase.getCustCode can not be null", custBase.getCustCode());
        CustAccount account = custAccountDao.queryByCode(custBase.getCustCode());
        if (Assert.checkParam(account)) {
            BeanUtils.copyProperties(custBase, account);
            account.setCustNameSpell(Trans2PinYin.getPinYin(custBase.getCustName()));
            if (!Assert.checkParam(custBase.getIdType())) {
                throw new SaveException("已开户的潜客，证件类型不能为空", custBase.getIdType());
            }
            if (!Assert.checkParam(custBase.getIdCard())) {
                throw new SaveException("已开户的潜客，证件号码不能为空", custBase.getIdCard());
            }
            if (!Assert.checkParam(custBase.getSex())) {
                throw new SaveException("已开户的潜客，性别不能为空", custBase.getSex());
            }
            
            if(compareDataStatus(account.getCustAccountId(),userId)){
            	if (!custAccountDao.update(account)) {
                    throw new SaveException("Cust custAccount update error", account);
                }
            }else{
            	 throw new SaveException("当前客户的信息正在认证中或已认证，无法进行编辑");
            }
            
        }
    }
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 比较当前客户的dataStatus与'C'、'S',从而判断是否进行修改信息
     * @param custAccountId
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
 	public boolean compareDataStatus(Long custAccountId,Long userId) {
 		List<RoleVo> roleList = commonService.findRolesByUserId(userId);
		if(commonService.hasRoleExist(roleList,RoleConstant.ZWH)){
			return true;
		}
		 CustAccount custAccount = custAccountDao.queryById(CustAccount.class, custAccountId);
	        if(!Assert.equals(custAccount.getDataStatus(), WMSConstants.ACCOUNT_CHECKING)
	        		&& !Assert.equals(custAccount.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)){
	        	return true;
	        }else{
	        	return false;
	        }
 	}

    @Override
    public CustBase queryById(Long id) {
        if (!Assert.checkParam(id)) {
            return new CustBase();
        }
        LOG.info("Cust id[{}]", id);
        return custBaseDao.queryById(CustBase.class, id);
    }

    @Override
    public PaginationResult<List<ResultView>> queryForPage(ParamView param, Pagination page) {
        return custBaseDao.queryForPage(param, page);

    }

    @Override
    public CustViewDto queryByCustCode(String custCode) {
        return new CustViewDto(custBaseDao.queryByParam(custCode));
    }

}