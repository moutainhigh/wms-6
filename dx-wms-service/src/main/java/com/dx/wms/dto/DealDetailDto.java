package com.dx.wms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DealDetailDto implements Serializable {
    /**
     */
    private static final long serialVersionUID = 1L;

    /** tradeCommitTime 交易提交时间*/
    private String tradeCommitTime;

    /** tradeAmount 交易金额 */
    private BigDecimal tradeAmount;

    /** tradeResult 单笔交易结果 */
    private String tradeResult;

    /** remark 备注 */
    private String remark;

    /**
     * @return the tradeAmount
     */
    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    /**
     * @param tradeAmount the tradeAmount to set
     */
    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the tradeResult
     */
    public String getTradeResult() {
        return tradeResult;
    }

    /**
     * @param tradeResult the tradeResult to set
     */
    public void setTradeResult(String tradeResult) {
        this.tradeResult = tradeResult;
    }

    /**
     * @return the tradeCommitTime
     */
    public String getTradeCommitTime() {
        return tradeCommitTime;
    }

    /**
     * @param tradeCommitTime the tradeCommitTime to set
     */
    public void setTradeCommitTime(String tradeCommitTime) {
        this.tradeCommitTime = tradeCommitTime;
    }
}
