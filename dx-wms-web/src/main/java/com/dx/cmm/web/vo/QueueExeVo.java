package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.cmm.service.queues.ExeQueue;
import com.dx.common.service.utils.AmountUtils;

/**
 * 
 * 队列执行Vo<br>
 * 队列执行Vo
 *
 * @author tony
 */
public class QueueExeVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4284894718231201076L;

    /**
     * 结果
     */
    private Boolean result;

    /**
     * 总数记录数
     */
    private Integer totalNum;

    /**
     * 成功记录数
     */
    private Integer successNum;

    /**
     * 失败记录数
     */
    private Integer errorNum;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 总金额
     */
    private String totalAmountView;

    /**
     * 成功金额
     */
    private BigDecimal successAmount;

    /**
     * 成功金额
     */
    private String successAmountView;

    /**
     * 失败金额
     */
    private BigDecimal errorAmount;

    /**
     * 失败金额
     */
    private String errorAmountView;

    public QueueExeVo() {

    }

    public QueueExeVo(ExeQueue exe) {
        try {
            PropertyUtils.copyProperties(this, exe);
            setTotalAmountView(AmountUtils.format(getTotalAmount(), "0.00"));
            setSuccessAmountView(AmountUtils.format(getSuccessAmount(), "0.00"));
            setErrorAmountView(AmountUtils.format(getErrorAmount(), "0.00"));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
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

    public String getTotalAmountView() {
        return totalAmountView;
    }

    public void setTotalAmountView(String totalAmountView) {
        this.totalAmountView = totalAmountView;
    }

    public String getSuccessAmountView() {
        return successAmountView;
    }

    public void setSuccessAmountView(String successAmountView) {
        this.successAmountView = successAmountView;
    }

    public String getErrorAmountView() {
        return errorAmountView;
    }

    public void setErrorAmountView(String errorAmountView) {
        this.errorAmountView = errorAmountView;
    }

}
