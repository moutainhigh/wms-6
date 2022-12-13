/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IndexForCustomerManageServiceImpl.java
 * Author:   黄健
 * Date:     2015年7月27日 下午5:00:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;
import com.google.gson.Gson;

/**
 * 销售客服首页数据查询service实现
 *
 * @author huangjian
 */
@Service
@Transactional
public class CustomerServiceIndex extends IndexRegister<IndexDisplayDto> {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceIndex.class);
    
    @Autowired
    private IIndexDisplayDao indexDisplayDao;
    
    @Autowired
    private IAMService amService;
    @Autowired
    ILenderApplyDao lenderApplyDao;
    
    @Override
    public boolean isNeedAction(Map<String, Object> param) {
        if(super.isNeedAction(param) && "customerService".equalsIgnoreCase((String)param.get("indexQuery"))) {
            return true;
        }
        return false;
    }
    
    @Override
    public IndexDisplayDto execute(Map<String, Object> param) {
        LOG.info(" start ** execute() param = {}",new Gson().toJson(param));
        Long orgId = (Long)param.get("orgId");
        Assert.notNull("** execute() orgId can not be null",orgId);
        IndexDisplayDto dto = new IndexDisplayDto();
        // 营业部
        dto.setOrgId(orgId);
        //  客户基数
        List<OrgVo> orgVoes = amService.queryOrgsByParentRecursion(orgId);
        List<Long> orgIds = null;
        if(Assert.checkParam(orgVoes)) {
            orgIds = new ArrayList<Long>();
            for(OrgVo orgVo : orgVoes) {
                orgIds.add(orgVo.getOrgId());
            }
            List<UserVo> userVoes = amService.queryUsersByOrgAndRole(orgIds, RoleConstant.KHJL);
            Assert.notNull("同营业部下的客户经理未查询得到",userVoes);
            List<Long> userIds = new ArrayList<Long>();
            for(UserVo userVo : userVoes) {
                userIds.add(userVo.getUserId());
            }
            dto.setCustNum(indexDisplayDao.queryForCustNumberByOrgId(userIds));
        } else {
            dto.setCustNum(0);
        }
        LenderApply lenderApply = new LenderApply();
        lenderApply.setOrgId(orgId);
        // 被拒绝申请单数
        List<Long> formStatus = new ArrayList<Long>();
        dto.setRefusedApplyNum(getRefusedApplyNum(formStatus, lenderApply));
        // 待质检申请单数
        dto.setPendingQualityApplyNum(getPendingQualityApplyNum(formStatus, lenderApply));
        // 开户基数
        dto.setCustAccountNum(indexDisplayDao.queryCustAccountNumByOrgId(orgId));
        // 投资总额
        dto.setSumLenderAmount(getSumLenderAmount(formStatus, lenderApply));
        // 营业部业绩明细
        
        return dto;
    }
    //待质检申请单数
    public Integer getPendingQualityApplyNum(List<Long> formStatus,LenderApply lenderApply){
        formStatus.clear();
        formStatus.add(10L);
        List<LenderApply>lenderApplys = lenderApplyDao.queryByStatus(formStatus,lenderApply);
        Integer pendingQualityApplyNum = 0;
        if(Assert.checkParam(lenderApplys)){
            pendingQualityApplyNum = lenderApplys.size();
        }
        return pendingQualityApplyNum;
    }
    //投资总额
    public BigDecimal getSumLenderAmount(List<Long> formStatus,LenderApply lenderApply){
        formStatus.clear();
        formStatus.add(21L);
        formStatus.add(22L);
        formStatus.add(23L);
        BigDecimal lenderAmount = BigDecimal.ZERO;
        List<LenderApply> lenderApplys = getLenderApplys(formStatus,lenderApply);
        if(Assert.checkParam(lenderApplys)){
            for(LenderApply custServicelenderApply:lenderApplys){
                lenderAmount=lenderAmount.add(custServicelenderApply.getLenderAmount());
            }
        }
        return lenderAmount;
    }
    //被拒绝申请单数
    public Integer getRefusedApplyNum(List<Long> formStatus,LenderApply lenderApply){
        formStatus.add(11L);
        formStatus.add(13L);
        List<LenderApply> lenderApplys = getLenderApplys(formStatus,lenderApply);
        Integer refusedApplyNum = 0;
        if(Assert.checkParam(lenderApplys)){
            refusedApplyNum = lenderApplys.size();
        }
        return refusedApplyNum;
    }
    //根据条件获取申请单数
    public List<LenderApply> getLenderApplys(List<Long> formStatus,LenderApply lenderApply){
        return lenderApplyDao.queryByStatus(formStatus,lenderApply);
    }
}
