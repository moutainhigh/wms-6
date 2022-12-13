package com.dx.cmm.service.match.result;

import java.math.BigDecimal;
import java.util.Date;

import com.dx.cmm.service.match.MatchBase;

class MatchResult extends MatchBase {

    /**
     */
    private static final long serialVersionUID = 2291104338234534914L;

    /**
     * 日期
     */
    private Date date;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 未匹配金额
     */
    private BigDecimal undoAmount;

    /**
     * 资金池编号
     */
    private Long poolId;

    /**
     * 端口日
     */
    private Integer portDay;

    /**
     * 端口日
     */
    private Date portDate;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public BigDecimal getUndoAmount() {
        return undoAmount;
    }

    public void setUndoAmount(BigDecimal undoAmount) {
        this.undoAmount = undoAmount;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Integer getPortDay() {
        return portDay;
    }

    public void setPortDay(Integer portDay) {
        this.portDay = portDay;
    }

    public Date getPortDate() {
        return portDate;
    }

    public void setPortDate(Date portDate) {
        this.portDate = portDate;
    }

    @Override
    public int hashCode() {
        return 31 * 1 + ((int) (getPoolId() ^ (getPoolId() >>> 32)));
    }
}
