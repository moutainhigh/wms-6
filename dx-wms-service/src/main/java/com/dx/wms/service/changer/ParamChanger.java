package com.dx.wms.service.changer;

import java.util.Date;

import com.dx.wms.enums.ApplyBiz;
import com.dx.wms.service.account.dto.CustAccountApplyDto;

/**
 * 变更查询dto
 * 
 * @author yangbao
 *
 */
public class ParamChanger extends BaseChanger {
    /**
     */
    private static final long serialVersionUID = 6533326493300339047L;

    /**
     * 注册日期起
     */
    private String openDateBegin;

    /**
     * 注册日期止
     */
    private String openDateEnd;

    /**
     * 客户经理
     */
    private Long createUser;

    /**
     * 账户状态
     */
    private String accountStatus;

    /**
     * 变更日志主键编号
     */
    private Long pkId;

    /**
     * 签单日期起
     */
    private Date signDateBegin;

    /**
     * 签单日期止
     */
    private Date signDateEnd;

    /**
     * 出借金额区间
     */
    private Integer lenderAmountArea;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 申请单状态
     */
    private String currentStep;

    /**
     * 申请单状态编号
     */
    private Integer currentStepCode;

    /**
     * 1申请 2到期
     */
    private Integer type;

    /**
     * 到期日
     */
    private Date borderDate;

    /**
     * 理财业务类型
     */
    private ApplyBiz biz;

    /**
     * 客户账户申请DTO
     */
    private CustAccountApplyDto custAccountApplyDto;

    /**
     * 变更的Id
     */
    private Long changeId;

    public ParamChanger(String biz) {
        setBiz(ApplyBiz.getEunm(biz));
    }

    public ParamChanger(String biz, ParamChanger infoChangeQueryDto) {
        setBiz(ApplyBiz.getEunm(biz));
        setCustAccountApplyDto(infoChangeQueryDto.getCustAccountApplyDto());
    }

    public ParamChanger() {
    }

    public ParamChanger(String biz, Long changeId) {
        setBiz(ApplyBiz.getEunm(biz));
        setChangeId(changeId);
    }

    public ParamChanger(String biz, CustAccountApplyDto applyDto, Long userId) {
        setBiz(ApplyBiz.getEunm(biz));
        setCustAccountApplyDto(applyDto);
        setCreateUser(userId);
    }

    /**
     * 变更的Id
     */
    public Long getChangeId() {
        return changeId;
    }

    /**
     * 变更的Id
     */
    public void setChangeId(Long changeId) {
        this.changeId = changeId;
    }

    /**
     * 客户账户申请DTO
     */
    public CustAccountApplyDto getCustAccountApplyDto() {
        return custAccountApplyDto;
    }

    /**
     * 客户账户申请DTO
     */
    public void setCustAccountApplyDto(CustAccountApplyDto custAccountApplyDto) {
        this.custAccountApplyDto = custAccountApplyDto;
    }

    /**
     * 注册日期起
     */
    public String getOpenDateBegin() {
        return openDateBegin;
    }

    /**
     * 注册日期起
     */
    public void setOpenDateBegin(String openDateBegin) {
        this.openDateBegin = openDateBegin;
    }

    /**
     * 注册日期止
     */
    public String getOpenDateEnd() {
        return openDateEnd;
    }

    /**
     * 注册日期止
     */
    public void setOpenDateEnd(String openDateEnd) {
        this.openDateEnd = openDateEnd;
    }

    /**
     * 创建人
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 账户状态
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * 账户状态
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 变更日志编号
     */
    public Long getPkId() {
        return pkId;
    }

    /**
     * 变更日志编号
     */
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    /**
     * 签单日期起
     */
    public Date getSignDateBegin() {
        return signDateBegin;
    }

    /**
     * 签单日期起
     */
    public void setSignDateBegin(Date signDateBegin) {
        this.signDateBegin = signDateBegin;
    }

    /**
     * 签单日期止
     */
    public Date getSignDateEnd() {
        return signDateEnd;
    }

    /**
     * 签单日期止
     */
    public void setSignDateEnd(Date signDateEnd) {
        this.signDateEnd = signDateEnd;
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
     * 组织编号
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 组织编号
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 申请单状态
     */
    public String getCurrentStep() {
        return currentStep;
    }

    /**
     * 申请单状态
     */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    /**
     * 申请单状态编号
     */
    public Integer getCurrentStepCode() {
        return currentStepCode;
    }

    /**
     * 申请单状态编号
     */
    public void setCurrentStepCode(Integer currentStepCode) {
        this.currentStepCode = currentStepCode;
    }

    /**
     * 1申请 2到期
     */
    public Integer getType() {
        return type;
    }

    /**
     * 1申请 2到期
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 到期日
     */
    public Date getBorderDate() {
        return borderDate;
    }

    /**
     * 到期日
     */
    public void setBorderDate(Date borderDate) {
        this.borderDate = borderDate;
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

}
