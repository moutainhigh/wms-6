package com.dx.wms.service.log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.common.BaseEntity;
import com.dx.wms.constant.WMSConstants;

/**
 * 出借申请日志表
 *
 * @author 朱道灵
 */
@Entity(name = "t_lender_apply_log")
public class LenderApplyLog extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 963638087372395177L;

    /**
     * 出借申请日志-编号 主键
     */
    private Long lenderApplyLogId;

    /**
     * 出借申请-编号
     */
    private Long lenderApplyId;

    /**
     * 来源-操作人
     */
    private Long fromUser;

    /**
     * 目标-操作人
     */
    private Long toUser;

    /**
     * 是否当前环节
     */
    private Integer isCurrent;

    /**
     * 当前环节
     */
    private String currentStep;

    /**
     * 当前环节-标示
     */
    private String currentStepKey;

    /**
     * 前一环节-标示
     */
    private String lastStepKey;

    /**
     * 当前行为
     */
    private Integer currentAction;

    /**
     * 前一行为
     */
    private Integer lastAction;

    /**
     * 审批内容
     */
    private String approveComment;

    /**
     * @return 前一环节-标示
     */
    @Column(name = "last_step_key")
    public String getLastStepKey() {
        return lastStepKey;
    }

    /**
     * @param lastStepKey 前一环节-标示
     */
    public void setLastStepKey(String lastStepKey) {
        this.lastStepKey = lastStepKey;
    }

    /**
     * @return 前一行为
     */
    @Column(name = "last_action")
    public Integer getLastAction() {
        return lastAction;
    }

    /**
     * @param lastAction 前一行为
     */
    public void setLastAction(Integer lastAction) {
        this.lastAction = lastAction;
    }

    /**
     * @return 审批内容
     */
    @Column(name = "approve_comment")
    public String getApproveComment() {
        return approveComment;
    }

    /**
     * @param approveComment 审批内容
     */
    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    /**
     * 功能描述: 出借申请日志-编号 主键<br>
     * 
     * @return the lenderApplyLogId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "lender_apply_log_id")
    public Long getLenderApplyLogId() {
        return lenderApplyLogId;
    }

    /**
     * 出借申请日志-编号 主键
     * 
     * @param lenderApplyLogId the lenderApplyLogId to set
     */
    public void setLenderApplyLogId(Long lenderApplyLogId) {
        this.lenderApplyLogId = lenderApplyLogId;
    }

    /**
     * 出借申请-编号
     * 
     * @return the lenderApplyId
     */
    @Column(name = "lender_apply_id")
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * 出借申请-编号
     * 
     * @param lenderApplyId the lenderApplyId to set
     */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * 来源-操作人
     * 
     * @return the fromUser
     */
    @Column(name = "from_user")
    public Long getFromUser() {
        return fromUser;
    }

    /**
     * 来源-操作人
     * 
     * @param fromUser the fromUser to set
     */
    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * 目标-操作人
     * 
     * @return the toUser
     */
    @Column(name = "to_user")
    public Long getToUser() {
        return toUser;
    }

    /**
     * 目标-操作人
     * 
     * @param toUser the toUser to set
     */
    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    /**
     * 是否当前环节
     * 
     * @return the isCurrent
     */
    @Column(name = "is_current")
    public Integer getIsCurrent() {
        return isCurrent;
    }

    /**
     * 是否当前环节
     * 
     * @param isCurrent the isCurrent to set
     */
    public void setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
    }

    /**
     * 当前环节
     * 
     * @return the currentStep
     */
    @Column(name = "current_step")
    public String getCurrentStep() {
        return currentStep;
    }

    /**
     * 当前环节
     * 
     * @param currentStep the currentStep to set
     */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    /**
     * 当前环节-标示
     * 
     * @return the currentStepKey
     */
    @Column(name = "current_step_key")
    public String getCurrentStepKey() {
        return currentStepKey;
    }

    /**
     * 当前环节-标示
     * 
     * @param currentStepKey the currentStepKey to set
     */
    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    /**
     * 当前行为
     * 
     * @return the currentAction
     */
    @Column(name = "current_action")
    public Integer getCurrentAction() {
        return currentAction;
    }

    /**
     * 当前行为
     * 
     * @param currentAction the currentAction to set
     */
    public void setCurrentAction(Integer currentAction) {
        this.currentAction = currentAction;
    }

    public LenderApplyLog(Long userId, Long lenderApplyId) {
        this.fromUser = userId;
        this.createUser = userId;
        this.updateUser = userId;
        this.lenderApplyId = lenderApplyId;
        this.isCurrent = 1;
        this.dataStatus = WMSConstants.DATE_STATUS_A;
    }

    public LenderApplyLog() {
    }
}
