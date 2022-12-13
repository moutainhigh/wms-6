/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustApplyServiceImpl.java
 * Author:   朱道灵
 * Date:     2015年7月31日 下午3:46:24
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.PushData;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.account.ICustAccountService;
import com.dx.wms.service.account.dao.ICustAccountDao;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.apply.dao.ICustFinanceDao;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.dao.ILenderConditionDao;
import com.dx.wms.service.apply.dto.ParamApplicant;
import com.dx.wms.service.apply.dto.ResultApplicant;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.base.CustBase;
import com.dx.wms.service.base.ICustBaseDao;
import com.dx.wms.service.log.ILenderApplyLogDao;
import com.dx.wms.service.log.LenderApplyLog;
import com.google.gson.Gson;

/**
 * 客户管理申请 service层 接口 实现
 *
 * @author 朱道灵
 */
@Service
public class CustLenderApplyServiceImpl implements ICustLenderApplyService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustLenderApplyServiceImpl.class);

    /**
     * dalClient
     */
    @Autowired
    public PaginationDalClient dalClient;

    /**
     * 理财申请Dao层
     */
    @Autowired
    private ILenderApplyDao lenderApplyDao;

    /**
     * 客户金融表Dao层
     */
    @Autowired
    private ICustFinanceDao custFinanceDao;

    /**
     * 客户账户服务
     */
    @Autowired
    private ICustAccountDao accountDao;

    /**
     * 理财申请日志
     */
    @Autowired
    private ILenderApplyLogDao lenderApplyLogDao;

    /**
     * 理财申请特殊情况
     */
    @Autowired
    private ILenderConditionDao lenderConditionDao;

    /**
     * 客户基础信息表
     */
    @Autowired
    private ICustBaseDao custBaseDao;

    /**
     * 客户开户服务
     */
    @Autowired
    private ICustAccountService custAccountService;

    @Override
    public String getCurrentStepKeyByLenderApplyId(Long lenderApplyId) {
        LenderApplyLog lenderApplyLog = lenderApplyLogDao.queryByParam(lenderApplyId);
        Assert.notNull("**getCurrentStepKeyByLenderApplyId() lenderApplyLog not found", lenderApplyLog);
        return lenderApplyLog.getCurrentStepKey();
    }

    @Override
    public void update(LenderApply apply) {
        Assert.notNull("Apply must not be null", apply);
        Long accountId = apply.getCustAccountId();
        CustAccount account = accountDao.queryById(CustAccount.class, accountId);
        Assert.notNull("Account must not be null", account);
        CustBase base = custBaseDao.queryByParam(account.getCustCode());
        Assert.notNull("Base must not be null", base);
        Assert.notEquals("Base status not equals account status", base.getDataStatus(), account.getDataStatus());
        if (Assert.equals(base.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)
                && Assert.equals(account.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)) {
            return;
        }
        String status = getStatus(accountId);
        if (!accountDao.update(accountId, null, status) || !custBaseDao.update(base.getCustId(), status)) {
            throw new BaseException("Update account or base error");
        }
    }

    private String getStatus(Long custAccountId) {
        String status = "";
        switch (custAccountService.getAccountStatusByCustAccountId(custAccountId)) {
            case 1:
                status = WMSConstants.ACCOUNT_UNAUTHERIZED;
                break;
            case 2:
                status = WMSConstants.ACCOUNT_CHECKING;
                break;
            case 3:
            case 4:
                status = WMSConstants.ACCOUNT_CHECK_FAIL;
                break;
            case 5:
                status = WMSConstants.ACCOUNT_CHECK_SUCCEED;
                break;
            default:
                status = WMSConstants.ACCOUNT_UNAUTHERIZED;
                break;
        }
        return status;
    }

    @Override
    public CustAccountApplyDto getCustAccountApplyDto(Long custAccountId, Long lenderApplyId) {
        Assert.notNull("**getCustAccountApplyDto() custAccountId can be not null**", custAccountId);
        LOG.info("**getCustAccountApplyDto() custAccountId={},lenderApplyId={}**", custAccountId, lenderApplyId);
        CustAccountApplyDto custAccountApplyDto = new CustAccountApplyDto();
        if (Assert.checkParam(custAccountId)) {
            // 获取开户申请表对象
            custAccountApplyDto = custAccountService.queryCustAccountDtoById(custAccountId);
            if (Assert.checkParam(lenderApplyId)) {
                LenderApply lenderApply = lenderApplyDao.queryById(LenderApply.class, lenderApplyId);
                Assert.notNull("**getCustAccountApplyDto() lenderApply not found**", lenderApply);
                custAccountApplyDto.setCustFinances(custFinanceDao.queryByApply(lenderApplyId));
                // 查询是否有特殊收益
                custAccountApplyDto.setLenderConditions(lenderConditionDao.queryByParam(lenderApplyId));
                custAccountApplyDto.setLenderApply(lenderApply);
                // 查询理财申请单的最新状态
                custAccountApplyDto.setCurrentStepKey(getCurrentStepKeyByLenderApplyId(lenderApplyId));
            }
        }
        return custAccountApplyDto;

    }

    @Override
    public PaginationResult<List<ResultApplicant>> queryInvestForPage(ParamApplicant param, Pagination page) {
        Assert.notNull("Param or page must be not null", param, page);
        LOG.info("Param[{}],page[{}]", new Gson().toJson(param), new Gson().toJson(page));
        return dalClient.queryForList("custApply.queryInvestForPage", MapUtils.obj2Map(param), ResultApplicant.class,
                page);
    }

    /**
     * 投资信息变更数据匹配推送
     */
    @Override
    public PushData getPushDataDto(LenderApply apply,String contractCode) {
        Assert.notNull("Apply id must not be null", apply);
        Assert.notNull("contractCode must not be null", contractCode);
        LOG.info("Apply id[{}]", apply);
        if (apply.getFormStatus() >= 14) {
            PushData pushData = new PushData();
            pushData.setBizCode(apply.getLenderCode());
            pushData.setBizBase(new BizBase(contractCode));
            return pushData;
        }
        return null;
    }

}
