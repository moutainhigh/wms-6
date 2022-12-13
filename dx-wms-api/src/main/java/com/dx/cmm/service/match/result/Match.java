package com.dx.cmm.service.match.result;

import java.math.BigDecimal;
import java.util.Date;

import com.dx.cmm.service.match.MatchBase;
import com.dx.common.service.utils.Assert;

public class Match extends MatchBase {

    /**
     */
    private static final long serialVersionUID = 1494479639061938773L;

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

    /**
     * 端口日
     */
    private Date portDate;

    public Long getInvestPoolId() {
        return investPoolId;
    }

    public void setInvestPoolId(Long investPoolId) {
        this.investPoolId = investPoolId;
    }

    public Long getCreditPoolId() {
        return creditPoolId;
    }

    public void setCreditPoolId(Long creditPoolId) {
        this.creditPoolId = creditPoolId;
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

    public Date getPortDate() {
        return portDate;
    }

    public void setPortDate(Date portDate) {
        this.portDate = portDate;
    }

    public String getInvestName() {
        return investName;
    }

    public void setInvestName(String investName) {
        this.investName = investName;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    @Override
    public int hashCode() {
        return 31 * 1
                + ((int) (getCreditPoolId() * getInvestPoolId() ^ (getCreditPoolId() * getInvestPoolId() >>> 32)));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Match) {
            if (Assert.equals(this.investPoolId, ((Match) obj).getInvestPoolId())
                    && Assert.equals(this.creditPoolId, ((Match) obj).getCreditPoolId())) {
                return true;
            }
        }
        return false;
    }
}
