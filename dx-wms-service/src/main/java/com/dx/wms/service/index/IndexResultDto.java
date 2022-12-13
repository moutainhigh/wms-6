package com.dx.wms.service.index;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IndexResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -8507154036329334124L;

    /** 客户基数 */
    private Integer custNumber;

    /** 当前投资申请总数 */
    private Integer applyNumber;

    /** 被拒绝的单数 */
    private Integer refusedApplyNumber;

    /** 待完善申请单数 */
    private Integer bePerfectApplyNumber;

    /** 待质检申请单数(销售客服)/待投资审核申请单数(执委会) */
    private Integer pendingQualityApplyNumber;

    /** 已开户客户数 */
    private Integer customerNumber;

    /** 当前行为:{1:"同意",2:"拒绝"} */
    private Integer currentAction;

    /** 客户经理 */
    private Long createUser;

    /** 营业部 */
    private Long orgId;

    /** 出借方式投资比例 */
    private List<IndexDisplayResultDto> lenderProportion;

    /** 审核结果比例 */
    private List<IndexDisplayResultDto> checkResultProportion;

    /** 出借总额 */
    private BigDecimal sumLenderAmount;

    public Integer getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(Integer custNumber) {
        this.custNumber = custNumber;
    }

    public Integer getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(Integer applyNumber) {
        this.applyNumber = applyNumber;
    }

    public Integer getRefusedApplyNumber() {
        return refusedApplyNumber;
    }

    public void setRefusedApplyNumber(Integer refusedApplyNumber) {
        this.refusedApplyNumber = refusedApplyNumber;
    }

    public Integer getBePerfectApplyNumber() {
        return bePerfectApplyNumber;
    }

    public void setBePerfectApplyNumber(Integer bePerfectApplyNumber) {
        this.bePerfectApplyNumber = bePerfectApplyNumber;
    }

    public Integer getPendingQualityApplyNumber() {
        return pendingQualityApplyNumber;
    }

    public void setPendingQualityApplyNumber(Integer pendingQualityApplyNumber) {
        this.pendingQualityApplyNumber = pendingQualityApplyNumber;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Integer getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Integer currentAction) {
        this.currentAction = currentAction;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public List<IndexDisplayResultDto> getLenderProportion() {
        return lenderProportion;
    }

    public void setLenderProportion(List<IndexDisplayResultDto> lenderProportion) {
        this.lenderProportion = lenderProportion;
    }

    public List<IndexDisplayResultDto> getCheckResultProportion() {
        return checkResultProportion;
    }

    public void setCheckResultProportion(List<IndexDisplayResultDto> checkResultProportion) {
        this.checkResultProportion = checkResultProportion;
    }

    public BigDecimal getSumLenderAmount() {
        return sumLenderAmount;
    }

    public void setSumLenderAmount(BigDecimal sumLenderAmount) {
        this.sumLenderAmount = sumLenderAmount;
    }

}
