package com.dx.cmm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 账户结果dto<br>
 * 账户结果dto
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AccountResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 2897654533396214843L;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 投资生效日
     */
    private Date validDate;

    /**
     * 当前账户金额
     */
    private BigDecimal currentAmount;

    /**
     * 投资数
     */
    private Integer investNum;

    /**
     * 账户级别
     */
    private Long accountLevelId;

    /**
     * 账户级别
     */
    private String accountLevelName;

    /**
     * 服务费率
     */
    private BigDecimal serviceRate;

    private Long matchUserId;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Integer getInvestNum() {
        return investNum;
    }

    public void setInvestNum(Integer investNum) {
        this.investNum = investNum;
    }

    public Long getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(Long accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    public String getAccountLevelName() {
        return accountLevelName;
    }

    public void setAccountLevelName(String accountLevelName) {
        this.accountLevelName = accountLevelName;
    }

    public BigDecimal getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(BigDecimal serviceRate) {
        this.serviceRate = serviceRate;
    }

    public Long getMatchUserId() {
        return matchUserId;
    }

    public void setMatchUserId(Long matchUserId) {
        this.matchUserId = matchUserId;
    }

}
