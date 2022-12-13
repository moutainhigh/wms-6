package com.dx.cmm.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MatchExcelDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -196029186515508950L;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 封闭期（月）
     */
    private Integer initPeriod;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 支付方式
     */
    private String payway;

    /**
     * 划扣银行
     */
    private String bank;

    private String subbank;

    /**
     * 划扣账号
     */
    private String account;

    /**
     * 付款日期
     */
    private Date payDate;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getSubbank() {
        return subbank;
    }

    public void setSubbank(String subbank) {
        this.subbank = subbank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

}
