package com.dx.cmm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.dx.common.service.utils.Assert;

/**
 * 
 * 推送数据
 *
 * @author tony
 */
public class PushData implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6752844354610047667L;

    /**
     * 业务编号:{理财:lenderCode,信贷:contractCode}
     */
    private String bizCode;

    /**
     * 业务客户编号
     */
    private String bizCustCode;

    /**
     * 生效日期:{理财:投资生效日期,到期支付日期}
     */
    private Date validDate;

    /**
     * 债权集合
     */
    private Set<Long> creditIds;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 初始出借金额
     */
    private BigDecimal initAmount;

    /**
     * 账户管理费
     */
    private BigDecimal managerAmount;

    /**
     * 收益
     */
    private BigDecimal incomeAmount;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 当前期数
     */
    private Integer currentPeriod;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 当前资产价值
     */
    private BigDecimal currentAmount;

    /**
     * 业务基础对象
     */
    private BizBase bizBase;

    /**
     * 交易时间
     */
    private Date tradeTime;

    /**
     * 交易结果
     */
    private Boolean tradeResult;

    /**
     * 交易信息
     */
    private String tradeMsg;

    /**
     * 是否续投
     */
    private Boolean isContinue;

    public PushData() {

    }

    /**
     * 客户信息变更
     * @param bizCustCode
     */
    public PushData(String bizCustCode) {
        setBizCustCode(bizCustCode);
    }

    /**
     * 投资生效
     * 
     * @param bizCode
     * @param validDate
     */
    public PushData(String bizCode, Date validDate) {
        setBizCode(bizCode);
        setValidDate(validDate);
    }

    /**
     * 重新匹配
     * 
     * @param bizCode
     * @param creditIds
     */
    public PushData(String bizCode, Set<Long> creditIds) {
        setBizCode(bizCode);
        setCreditIds(creditIds);
    }

    public PushData(String bizCustCode, String bizCode) {
        setBizCustCode(bizCustCode);
        setBizCode(bizCode);
    }

    /**
     * 投资及债权新增
     * 
     * @param bizCode
     * @param base
     */
    public PushData(String bizCode, BizBase base) {
        setBizCode(bizCode);
        setBizBase(base);
    }

    /**
     * 续投
     * 
     * @param bizCode
     * @param base
     * @param isContinue
     */
    public PushData(String bizCode, BizBase base, Boolean isContinue) {
        setBizCode(bizCode);
        setBizBase(base);
        setIsContinue(isContinue);
    }

    public BizBase getBizBase() {
        return bizBase;
    }

    public void setBizBase(BizBase bizBase) {
        this.bizBase = bizBase;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Set<Long> getCreditIds() {
        return creditIds;
    }

    public void setCreditIds(Set<Long> creditsIds) {
        this.creditIds = creditsIds;
    }

    public String getBizCustCode() {
        return bizCustCode;
    }

    public void setBizCustCode(String bizCustCode) {
        this.bizCustCode = bizCustCode;
    }

    @Override
    public int hashCode() {
        return Assert.checkParam(bizCode) ? bizCode.hashCode() : bizCustCode.hashCode();
    }

    @Override
    public boolean equals(Object arg0) {
        if (arg0 instanceof PushData) {
            return Assert.equals(this.getBizCode(), ((PushData) arg0).getBizCode());
        }
        return false;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
    }

    public BigDecimal getManagerAmount() {
        return managerAmount;
    }

    public void setManagerAmount(BigDecimal managerAmount) {
        this.managerAmount = managerAmount;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Boolean getTradeResult() {
        return tradeResult;
    }

    public void setTradeResult(Boolean tradeResult) {
        this.tradeResult = tradeResult;
    }

    public String getTradeMsg() {
        return tradeMsg;
    }

    public void setTradeMsg(String tradeMsg) {
        this.tradeMsg = tradeMsg;
    }

    public Boolean getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Boolean isContinue) {
        this.isContinue = isContinue;
    }

}
