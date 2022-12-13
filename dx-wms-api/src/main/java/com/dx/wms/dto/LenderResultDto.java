/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: WMSBizTotalResultDto.java
 * Author:   FlaTa
 * Date:     2016年4月6日 上午10:46:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈一句话功能简述〉理财业务查询结果Dto<br>
 * 〈功能详细描述〉
 *
 * @author 蒋玉涛
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LenderResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6825158193209632106L;

    /**
     * 理财申请Id 
     */
    private Long lenderApplyId;
    
    /**
     * 账单日
     */
    private Integer statementDate;

    /**
     * 姓名
     */
    private String custName;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件号
     */
    private String idCard;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 营业部Id
     */
    private Long orgId;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 开户行
     */
    private Integer bankCategory;

    /**
     * 银行账号
     */
    private String accountNum;

    /**
     * 状态
     */
    private Long formStatus;

    /**
     * 出借日期
     */
    private Date settlementDate;

    /**
     * 转让日期
     */
    private Date dueDate;

    /**
     * 预计付款日
     */
    private Date expectPayDate;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 更新时间
     */
    private Date updateTime;

    
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public Integer getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Integer statementDate) {
        this.statementDate = statementDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public Integer getBankCategory() {
        return bankCategory;
    }

    public void setBankCategory(Integer bankCategory) {
        this.bankCategory = bankCategory;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public Long getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(Long formStatus) {
        this.formStatus = formStatus;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getExpectPayDate() {
        return expectPayDate;
    }

    public void setExpectPayDate(Date expectPayDate) {
        this.expectPayDate = expectPayDate;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
