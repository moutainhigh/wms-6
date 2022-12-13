package com.dx.wms.service.process;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.dx.wms.enums.ApplyBiz;

/**
 * 业务明细质检 数据库查询Dto
 * 
 * @author yangbao
 *
 */
public class ParamProcess {

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 出借金额区间
     */
    private Integer lenderAmountArea;

    /**
     * 最小出借金额范围
     */
    private BigDecimal minAmountArea;

    /**
     * 最大出借金额范围
     */
    private BigDecimal maxAmountArea;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 移动电话
     */
    private String mobile;

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
     * 组织Id
     */
    private Long orgId;

    /**
     * 状态
     */
    private Integer currentStep;

    /**
     * 账单日
     */
    private Integer bizBillDay;

    /**
     * 流程实例集
     */
    private List<String> proIns;

    /**
     * 类型
     */
    private Integer type;
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
     * 理财业务类型
     */
    private ApplyBiz biz;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 可以续投的申请ID 
     */
    private List<Long> dueApplyIds;
    
    public ParamProcess() {

    }

    public ParamProcess(String biz) {
        setBiz(ApplyBiz.getEunm(biz));
    }

    public ParamProcess(String biz, Long userId) {
        setBiz(ApplyBiz.getEunm(biz));
        setUserId(userId);
    }

    public void put(ParamProcess dto, Integer lenderAmountArea) {
        switch (lenderAmountArea) {
            case 1:
                dto.setMinAmountArea(new BigDecimal(50000));
                dto.setMaxAmountArea(new BigDecimal(100000));
                break;
            case 2:
                dto.setMinAmountArea(new BigDecimal(100001));
                dto.setMaxAmountArea(new BigDecimal(200000));
                break;
            case 3:
                dto.setMinAmountArea(new BigDecimal(200001));
                dto.setMaxAmountArea(new BigDecimal(500000));
                break;
            case 4:
                dto.setMinAmountArea(new BigDecimal(500001));
                dto.setMaxAmountArea(new BigDecimal(1000000));
                break;
            case 5:
                dto.setMinAmountArea(new BigDecimal(1000001));
                dto.setMaxAmountArea(new BigDecimal(999999999));
                break;
        }
    }

    /**
     * 理财申请编号
     */
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * 理财申请编号
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
     * 客户姓名
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 客户姓名
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public BigDecimal getMinAmountArea() {
        return minAmountArea;
    }

    public void setMinAmountArea(BigDecimal minAmountArea) {
        this.minAmountArea = minAmountArea;
    }

    public BigDecimal getMaxAmountArea() {
        return maxAmountArea;
    }

    public void setMaxAmountArea(BigDecimal maxAmountArea) {
        this.maxAmountArea = maxAmountArea;
    }

    /**
     * 证件号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 证件号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
        if (StringUtils.isBlank(signDateBegin)) {
            this.signDateBegin = signDateBegin;
        } else {
            this.signDateBegin = signDateBegin + " 00:00:00";
        }
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
        if (StringUtils.isBlank(signDateEnd)) {
            this.signDateEnd = signDateEnd;
        } else {
            this.signDateEnd = signDateEnd + " 23:59:59";
        }
    }

    /**
     * 营业部编号
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 营业部编号
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
     * 流程实例集
     */
    public List<String> getProIns() {
        return proIns;
    }

    /**
     * 流程实例集
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

    /**
     * 理财业务类型
     */
    public ApplyBiz getBiz() {
        return biz;
    }

    /**
     * 理财业务类型
     */
    public void setBiz(ApplyBiz biz) {
        this.biz = biz;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 签单日期起
     */
    public String getSettlementDateBegin() {
        return settlementDateBegin;
    }

    /**
     * 签单日期起
     */
    public void setSettlementDateBegin(String settlementDateBegin) {
        this.settlementDateBegin = settlementDateBegin;
    }

    /**
     * 签单日期止
     */
    public String getSettlementDateEnd() {
        return settlementDateEnd;
    }

    /**
     * 签单日期止
     */
    public void setSettlementDateEnd(String settlementDateEnd) {
        this.settlementDateEnd = settlementDateEnd;
    }

    public List<Long> getDueApplyIds() {
        return dueApplyIds;
    }

    public void setDueApplyIds(List<Long> dueApplyIds) {
        this.dueApplyIds = dueApplyIds;
    }


}
