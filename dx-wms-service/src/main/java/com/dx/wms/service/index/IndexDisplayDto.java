/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountDto.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午3:52:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.index;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 首页显示 dto
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IndexDisplayDto implements Serializable {
    
    /**
     */
    private static final long serialVersionUID = 1L;

    /** 客户基数 */
    private Integer custNum;
    
    /** 被拒绝的单数 */
    private Integer refusedApplyNum;
    
    /** 开户基数 */
    private Integer custAccountNum;
    
    /** 出借总额  */
    private BigDecimal sumLenderAmount;
    
    /** 客户经理 */
    private Long createUser;
    
    /** 营业部 */
    private Long orgId;
    
    /** 待质检申请单数(销售客服) */
    private Integer pendingQualityApplyNum;
    
    /** 待投资审核申请单数(执委会) */
    private Integer pendingCheckApplyNum;
    
    /** 生效投资数 */
    private Integer effectiveApplyNum;
    
    /**
     * @return 客户经理
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser 客户经理
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * @return 出借总额
     */
    public BigDecimal getSumLenderAmount() {
        return sumLenderAmount;
    }

    /**
     * @param sumLenderAmount 出借总额
     */
    public void setSumLenderAmount(BigDecimal sumLenderAmount) {
        this.sumLenderAmount = sumLenderAmount;
    }

    /**
     * @return 营业部
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId 营业部
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * @return 客户基数
     */
    public Integer getCustNum() {
        return custNum;
    }

    /**
     * @param custNum 客户基数
     */
    public void setCustNum(Integer custNum) {
        this.custNum = custNum;
    }

    /**
     * @return 被拒绝的单数
     */
    public Integer getRefusedApplyNum() {
        return refusedApplyNum;
    }

    /**
     * @param refusedApplyNum 被拒绝的单数
     */
    public void setRefusedApplyNum(Integer refusedApplyNum) {
        this.refusedApplyNum = refusedApplyNum;
    }

    /**
     * @return 开户基数
     */
    public Integer getCustAccountNum() {
        return custAccountNum;
    }

    /**
     * @param custAccountNum 开户基数
     */
    public void setCustAccountNum(Integer custAccountNum) {
        this.custAccountNum = custAccountNum;
    }

    /**
     * @return 待质检申请单数(销售客服)
     */
    public Integer getPendingQualityApplyNum() {
        return pendingQualityApplyNum;
    }

    /**
     * @param pendingQualityApplyNum 待质检申请单数(销售客服)
     */
    public void setPendingQualityApplyNum(Integer pendingQualityApplyNum) {
        this.pendingQualityApplyNum = pendingQualityApplyNum;
    }

    /**
     * @return 待投资审核申请单数(执委会)
     */
    public Integer getPendingCheckApplyNum() {
        return pendingCheckApplyNum;
    }

    /**
     * @param pendingCheckApplyNum 待投资审核申请单数(执委会)
     */
    public void setPendingCheckApplyNum(Integer pendingCheckApplyNum) {
        this.pendingCheckApplyNum = pendingCheckApplyNum;
    }

    /**
     * @return 生效投资数
     */
    public Integer getEffectiveApplyNum() {
        return effectiveApplyNum;
    }

    /**
     * @param effectiveApplyNum 生效投资数
     */
    public void setEffectiveApplyNum(Integer effectiveApplyNum) {
        this.effectiveApplyNum = effectiveApplyNum;
    }
    
}
