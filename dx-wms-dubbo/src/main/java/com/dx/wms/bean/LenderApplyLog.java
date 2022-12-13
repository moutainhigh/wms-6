/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyLog.java
 * Author:   朱道灵
 * Date:     2015年7月24日 下午4:13:59
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;

/**
 * 出借申请日志表
 *
 * @author 朱道灵
 */
@Entity(name = "t_lender_apply_log")
public class LenderApplyLog implements Serializable {

    /**
     */
    private static final long serialVersionUID = 7189550450420758834L;

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
     * 创建者:{"-1":"系统"}
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者:{"-1":"系统"}
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 数据状态:{"A":"已生效","D":"已删除"}；
     */
    private String dataStatus;

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

    /**
     * 功能描述: 创建者:{"-1":"系统"} <br>
     *
     * @return the createUser
     */
    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 功能描述: 创建者:{"-1":"系统"} <br>
     *
     * @param createUser the createUser to set.
     */

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 功能描述: 创建时间 <br>
     *
     * @return the createTime
     */
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 功能描述: 创建时间 <br>
     *
     * @param createTime the createTime to set.
     */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 功能描述: 更新者:{"-1":"系统"}<br>
     *
     * @return the updateUser
     */
    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 功能描述: 更新者:{"-1":"系统"} <br>
     *
     * @param updateUser the updateUser to set.
     */

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 功能描述: updateTime 更新时间 <br>
     *
     * @return the updateTime
     */

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 功能描述: 更新时间 <br>
     *
     * @param updateTime the updateTime to set.
     */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 功能描述: 数据状态:{"A":"已生效","D":"已删除"}；<br>
     *
     * @return the dataStatus
     */
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * 功能描述: 数据状态:{"A":"已生效","D":"已删除"}<br>
     *
     * @param dataStatus the dataStatus to set.
     */

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public LenderApplyLog(Long userId, Long lenderApplyId) {
        this.fromUser = userId;
        this.createUser = userId;
        this.updateUser = userId;
        this.lenderApplyId = lenderApplyId;
        this.isCurrent = 1;
        this.dataStatus = "A";
        this.updateTime = new Date();
    }

    public LenderApplyLog() {

    }

    public void update(Long to, Integer currentAction, String approveComment) {
        setUpdateUser(to);
        setToUser(to);
        setIsCurrent(0);
        setCurrentAction(currentAction);
        setApproveComment(Assert.checkParam(approveComment) ? approveComment : WMSConstants.EMPTY);
        setUpdateTime(new Date());
    }

    public void add(String currentStep, String currentStepKey, Long to, Integer lastAction, String lastStepKey,
            Integer currentAction) {
        setCurrentStep(currentStep);
        setCurrentStepKey(currentStepKey);
        setToUser(to);
        setLastAction(lastAction);
        setLastStepKey(lastStepKey);
        setCurrentAction(currentAction);
        setUpdateTime(new Date());
    }
}
