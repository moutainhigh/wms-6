/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyLogResultVo.java
 * Author:   黄健
 * Date:     2015年7月31日 下午9:27:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.cla.web.vo;

import org.springframework.beans.BeanUtils;

import com.dx.wms.service.log.LogResultDto;

/**
 * 出借申请日志vo
 *
 * @author huangjian
 */
public class LogResultVo {

    /**
     * 日志主键
     */
    private Long lenderApplyLogId;

    /**
     * 出借 主键
     */
    private Long lenderApplyId;

    /**
     * 审核人
     */
    private String createUser;

    /**
     * 审批时间
     */
    private String createTime;

    /**
     * 当前环节:{"草稿","质检","投资审核","重新提交"}
     */
    private String currentStep;

    /**
     * 当前行为:{1:"同意",2:"拒绝"}
     */
    private String currentAction;

    /**
     * 审批内容
     */
    private String approveComment;

    public LogResultVo() {

    }

    public LogResultVo(LogResultDto log) {
        BeanUtils.copyProperties(log, this);
    }

    /**
     * @return 日志主键
     */
    public Long getLenderApplyLogId() {
        return lenderApplyLogId;
    }

    /**
     * @param lenderApplyLogId 日志主键
     */
    public void setLenderApplyLogId(Long lenderApplyLogId) {
        this.lenderApplyLogId = lenderApplyLogId;
    }

    /**
     * @return 出借 主键
     */
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * @param lenderApplyId 出借 主键
     */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * @return 审核人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser 审核人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return 审批时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 审批时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 当前环节:{"草稿","质检","投资审核","重新提交"}
     */
    public String getCurrentStep() {
        return currentStep;
    }

    /**
     * @param currentStep 当前环节:{"草稿","质检","投资审核","重新提交"}
     */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    /**
     * @return 当前行为:{1:"同意",2:"拒绝"}
     */
    public String getCurrentAction() {
        return currentAction;
    }

    /**
     * @param currentAction 当前行为:{1:"同意",2:"拒绝"}
     */
    public void setCurrentAction(String currentAction) {
        this.currentAction = currentAction;
    }

    /**
     * @return 审批内容
     */
    public String getApproveComment() {
        return approveComment;
    }

    /**
     * @param approveComment 审批内容
     */
    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }
}
