/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: WealthManagementInfoVo.java
 * Author:   朱道灵
 * Date:     2015年7月26日 下午3:51:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.info.vo;


/**
 * 理财信息管理 实体类 VO
 * 
 * @author 朱道灵
 */
public class WealthManagementInfoVo {

    /** 客户账户-编号 */
    private Long custAccountId;

    /** 客户-姓名 */
    private String custName;

    /** 证件号码 */
    private String idCard;

    /** 移动电话 */
    private String mobile;

    /** 出借编号 */
    private String lenderApplyId;

    /** 出借方式 */
    private String productId;

    /** 签单日期 */
    private String signDate;
    
    /**团队-编号 */
    private String teamId;
    
    /**营业部-编号 */
    private String orgId;
    
    /**出借金额 */
    private String lenderAmount;
    

    /**
     * @return the custAccountId
     */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * @param custAccountId the custAccountId to set
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the lenderApplyId
     */
    public String getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * @param lenderApplyId the lenderApplyId to set
     */
    public void setLenderApplyId(String lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return the signDate
     */
    public String getSignDate() {
        return signDate;
    }

    /**
     * @param signDate the signDate to set
     */
    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    /**
     * @return the teamId
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the orgId
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the lenderAmount
     */
    public String getLenderAmount() {
        return lenderAmount;
    }

    /**
     * @param lenderAmount the lenderAmount to set
     */
    public void setLenderAmount(String lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

}
