package com.dx.cmm.web.controller.match.result;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.match.result.Match;

public class MoreMatchResult implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5706047098997857597L;

    /**
     * 投资池编号
     */
    private Long investPoolId;

    /**
     * 投资客户
     */
    private String investName;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 债权池编号
     */
    private Long creditPoolId;

    /**
     * 债权客户
     */
    private String creditName;

    /**
     * 匹配金额
     */
    private BigDecimal matchAmount = BigDecimal.ZERO;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    public MoreMatchResult(Match match) {
        BeanUtils.copyProperties(match, this);
    }

    public Long getInvestPoolId() {
        return investPoolId;
    }

    public void setInvestPoolId(Long investPoolId) {
        this.investPoolId = investPoolId;
    }

    public String getInvestName() {
        return investName;
    }

    public void setInvestName(String investName) {
        this.investName = investName;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Long getCreditPoolId() {
        return creditPoolId;
    }

    public void setCreditPoolId(Long creditPoolId) {
        this.creditPoolId = creditPoolId;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public BigDecimal getMatchAmount() {
        return matchAmount;
    }

    public void setMatchAmount(BigDecimal matchAmount) {
        this.matchAmount = matchAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

}
