package com.dx.wms.web.process.vo;

import java.util.List;

import com.dx.wms.web.vo.ParamVo;

/**
 * 业务明细质检 数据查询Vo
 * 
 * @author yangbao
 *
 */
public class ProcessParamVo extends ParamVo {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 4523019218691275072L;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 签单日期起
     */
    private String signDateBegin;

    /**
     * 签单日期止
     */
    private String signDateEnd;

    /**
     * 生效日期起
     */
    private String settlementDateBegin;

    /**
     * 生效日期止
     */
    private String settlementDateEnd;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 出借金额区间
     */
    private Integer lenderAmountArea;

    /**
     * 状态
     */
    private Integer currentStep;

    /**
     * 账单日
     */
    private Integer bizBillDay;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 流程实例ID
     */
    private List<String> proIns;
    /**
     * 理财申请主键
     */
    private Long lenderApplyId;

    /**
     * 理财用户编号
     */
    private Long custAccountId;

    /**
     * 质检审核结果
     */
    private String approveComment;

    /**
     * 当前审核结果
     */
    private Integer currentAction;

    /**
     * 申请编号
     */
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * 申请编号
     */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * 客户账户编号
     */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * 客户账户编号
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /**
     * 质检审核结果
     */
    public String getApproveComment() {
        return approveComment;
    }

    /**
     * 质检审核结果
     */
    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    /**
     * 当前审核结果
     */
    public Integer getCurrentAction() {
        return currentAction;
    }

    /**
     * 当前审核结果
     */
    public void setCurrentAction(Integer currentAction) {
        this.currentAction = currentAction;
    }

    /**
     * 出借方式
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 出借方式
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 签单日期起
     */
    public String getSignDateBegin() {
        return signDateBegin;
    }

    /**
     * 签单日期起
     */
    public void setSignDateBegin(String signDateBegin) {
        this.signDateBegin = signDateBegin;
    }

    /**
     * 签单日期止
     */
    public String getSignDateEnd() {
        return signDateEnd;
    }

    /**
     * 签单日期止
     */
    public void setSignDateEnd(String signDateEnd) {
        this.signDateEnd = signDateEnd;
    }

    /**
     * 出借编号
     */
    public String getLenderCode() {
        return lenderCode;
    }

    /**
     * 出借编号
     */
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    /**
     * 出借金额区间
     */
    public Integer getLenderAmountArea() {
        return lenderAmountArea;
    }

    /**
     * 出借金额区间
     */
    public void setLenderAmountArea(Integer lenderAmountArea) {
        this.lenderAmountArea = lenderAmountArea;
    }

    /**
     * 当前行为
     */
    public Integer getCurrentStep() {
        return currentStep;
    }

    /**
     * 当前行为
     */
    public void setCurrentStep(Integer currentStep) {
        this.currentStep = currentStep;
    }

    /**
     * 账单日
     */
    public Integer getBizBillDay() {
        return bizBillDay;
    }

    /**
     * 账单日
     */
    public void setBizBillDay(Integer bizBillDay) {
        this.bizBillDay = bizBillDay;
    }

    /**
     * 流程Id
     */
    public List<String> getProIns() {
        return proIns;
    }

    /**
     * 流程Id
     */
    public void setProIns(List<String> proIns) {
        this.proIns = proIns;
    }

    /**
     * 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    public String getSettlementDateBegin() {
        return settlementDateBegin;
    }

    public void setSettlementDateBegin(String settlementDateBegin) {
        this.settlementDateBegin = settlementDateBegin;
    }

    public String getSettlementDateEnd() {
        return settlementDateEnd;
    }

    public void setSettlementDateEnd(String settlementDateEnd) {
        this.settlementDateEnd = settlementDateEnd;
    }

}
