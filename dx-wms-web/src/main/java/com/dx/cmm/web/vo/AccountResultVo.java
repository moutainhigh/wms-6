package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.cmm.dto.AccountResultDto;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.PerUtils;

public class AccountResultVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6006721519276525606L;

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
     * 当前账户金额
     */
    private String currentAmountView;

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

    /**
     * 服务费率
     */
    private String serviceRateView;

    private Long matchUserId;

    public AccountResultVo() {

    }

    public AccountResultVo(AccountResultDto dto) {
        try {
            PropertyUtils.copyProperties(this, dto);
            setCurrentAmountView(AmountUtils.format(getCurrentAmount(), "-"));
            setServiceRateView(PerUtils.format(getServiceRate()));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
    }

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

    public String getServiceRateView() {
        return serviceRateView;
    }

    public void setServiceRateView(String serviceRateView) {
        this.serviceRateView = serviceRateView;
    }

    public String getCurrentAmountView() {
        return currentAmountView;
    }

    public void setCurrentAmountView(String currentAmountView) {
        this.currentAmountView = currentAmountView;
    }

    public Long getMatchUserId() {
        return matchUserId;
    }

    public void setMatchUserId(Long matchUserId) {
        this.matchUserId = matchUserId;
    }

}
