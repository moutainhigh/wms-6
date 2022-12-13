package com.dx.wms.service.log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.common.BaseEntity;

/**
 * 
 * 数据调用记录表
 *
 * @author 王蕊
 */
@Entity(name = "t_invoke_log")
public class InvokeLog extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -5748284577481398762L;

    /**
     * 调用
     */
    private Long invokeLogId;

    /**
     * 调用流水号
     */
    private String invokeLogCode;

    /**
     * 理财编号ID
     */
    private Long lenderApplyId;

    /**
     * 支付方式-编号
     */
    private Long payWayId;

    /**
     * 理财编号
     */
    private String lenderCode;

    /**
     * 调用结果
     */
    private Integer invokeResult;

    /**
     * 备注
     */
    private String invokeComment;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "invoke_log_id")
    public Long getInvokeLogId() {
        return invokeLogId;
    }

    public void setInvokeLogId(Long invokeLogId) {
        this.invokeLogId = invokeLogId;
    }

    @Column(name = "invoke_log_code")
    public String getInvokeLogCode() {
        return invokeLogCode;
    }

    public void setInvokeLogCode(String invokeLogCode) {
        this.invokeLogCode = invokeLogCode;
    }

    @Column(name = "lender_code")
    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    @Column(name = "invoke_result")
    public Integer getInvokeResult() {
        return invokeResult;
    }

    public void setInvokeResult(Integer invokeResult) {
        this.invokeResult = invokeResult;
    }

    @Column(name = "invoke_comment")
    public String getInvokeComment() {
        return invokeComment;
    }

    public void setInvokeComment(String invokeComment) {
        this.invokeComment = invokeComment;
    }

    @Column(name = "lender_apply_id")
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    @Column(name = "pay_way_id")
    public Long getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(Long payWayId) {
        this.payWayId = payWayId;
    }
}
