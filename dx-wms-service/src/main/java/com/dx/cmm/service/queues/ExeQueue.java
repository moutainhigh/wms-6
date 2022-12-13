package com.dx.cmm.service.queues;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 队列执行Dto<br>
 * 队列执行Dto
 *
 * @author tony
 */
public class ExeQueue implements Serializable {

    /**
     */
    private static final long serialVersionUID = 7046898846588584327L;

    /**
     * 结果
     */
    private Boolean result = true;

    /**
     * 总数记录数
     */
    private Integer totalNum = 0;

    /**
     * 成功记录数
     */
    private Integer successNum = 0;

    /**
     * 失败记录数
     */
    private Integer errorNum = 0;

    /**
     * 总金额
     */
    private BigDecimal totalAmount = BigDecimal.ZERO;

    /**
     * 成功金额
     */
    private BigDecimal successAmount = BigDecimal.ZERO;

    /**
     * 失败金额
     */
    private BigDecimal errorAmount = BigDecimal.ZERO;

    public ExeQueue() {
        setResult(false);
    }

    public ExeQueue(Integer size) {
        setTotalNum(size);
    }

    public void total(ResultQueue item) {
        setTotalAmount(getTotalAmount().add(item.getInitTotalAmount()));
    }

    public void success(ResultQueue item) {
        setSuccessNum(getSuccessNum() + 1);
        setSuccessAmount(getSuccessAmount().add(item.getInitTotalAmount()));
    }

    public void error(ResultQueue item) {
        setErrorNum(getErrorNum() + 1);
        setErrorAmount(getErrorAmount().add(item.getInitTotalAmount()));
        setResult(false);
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(BigDecimal successAmount) {
        this.successAmount = successAmount;
    }

    public BigDecimal getErrorAmount() {
        return errorAmount;
    }

    public void setErrorAmount(BigDecimal errorAmount) {
        this.errorAmount = errorAmount;
    }

}
