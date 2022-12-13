package com.dx.wms.service.log;

import java.io.Serializable;
import java.util.Date;

public class ApplyLog  implements Serializable{

    /**
     */
    private static final long serialVersionUID = 5580874403605581186L;
    
    /** 出借申请日志-编号 主键 */
    private Long lenderApplyLogId;
    
    /** 出借申请-编号 */
    private Long lenderApplyId;
    
    /** 来源-操作人*/
    private Long fromUser;
    
    /** 目标-操作人*/
    private Long toUser;
    
    /** 是否当前环节*/
    private Integer  isCurrent;
    
    /** 当前环节*/
    private String  currentStep;
    
    /** 当前环节-标示*/
    private String  currentStepKey;
    
    /** 前一环节-标示*/
    private String lastStepKey;
    
    /** 当前行为*/
    private Integer currentAction;
    
    /** 前一行为*/
    private Integer lastAction;
    
    /** 创建者:{"-1":"系统"} */
    private Long createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新者:{"-1":"系统"} */
    private Long updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 数据状态:{"A":"已生效","D":"已删除"}； */
    private String dataStatus;
    
    /** 审批内容 */
    private String approveComment;

    /**
     * @return the lenderApplyLogId
     */
    public Long getLenderApplyLogId() {
        return lenderApplyLogId;
    }

    /**
     * @param lenderApplyLogId the lenderApplyLogId to set
     */
    public void setLenderApplyLogId(Long lenderApplyLogId) {
        this.lenderApplyLogId = lenderApplyLogId;
    }

    /**
     * @return the lenderApplyId
     */
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * @param lenderApplyId the lenderApplyId to set
     */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * @return the fromUser
     */
    public Long getFromUser() {
        return fromUser;
    }

    /**
     * @param fromUser the fromUser to set
     */
    public void setFromUser(Long fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * @return the toUser
     */
    public Long getToUser() {
        return toUser;
    }

    /**
     * @param toUser the toUser to set
     */
    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    /**
     * @return the isCurrent
     */
    public Integer getIsCurrent() {
        return isCurrent;
    }

    /**
     * @param isCurrent the isCurrent to set
     */
    public void setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
    }

    /**
     * @return the currentStep
     */
    public String getCurrentStep() {
        return currentStep;
    }

    /**
     * @param currentStep the currentStep to set
     */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    /**
     * @return the currentStepKey
     */
    public String getCurrentStepKey() {
        return currentStepKey;
    }

    /**
     * @param currentStepKey the currentStepKey to set
     */
    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    /**
     * @return the lastStepKey
     */
    public String getLastStepKey() {
        return lastStepKey;
    }

    /**
     * @param lastStepKey the lastStepKey to set
     */
    public void setLastStepKey(String lastStepKey) {
        this.lastStepKey = lastStepKey;
    }

    /**
     * @return the currentAction
     */
    public Integer getCurrentAction() {
        return currentAction;
    }

    /**
     * @param currentAction the currentAction to set
     */
    public void setCurrentAction(Integer currentAction) {
        this.currentAction = currentAction;
    }

    /**
     * @return the lastAction
     */
    public Integer getLastAction() {
        return lastAction;
    }

    /**
     * @param lastAction the lastAction to set
     */
    public void setLastAction(Integer lastAction) {
        this.lastAction = lastAction;
    }

    /**
     * @return the createUser
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser the createUser to set
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the updateUser
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the dataStatus
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * @param dataStatus the dataStatus to set
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * @return the approveComment
     */
    public String getApproveComment() {
        return approveComment;
    }

    /**
     * @param approveComment the approveComment to set
     */
    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }
    
}
