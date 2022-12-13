/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyLogResultDto.java
 * Author:   黄健
 * Date:     2015年9月14日 下午4:44:33
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.log;

import java.util.Date;
import java.util.Map;

import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.enums.CurrentAction;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 */
public class LogResultDto {

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

    public LogResultDto() {

    }

    public LogResultDto(LenderApplyLog log, LenderApply apply, Map<Long, UserVo> userMap) {
        setLenderApplyLogId(log.getLenderApplyId());
        setLenderApplyId(log.getLenderApplyId());
        UserVo user = userMap.get(log.getUpdateUser());
        if (Assert.equals(log.getCurrentStepKey(), "investmentConfirm")) {
            user = userMap.get(log.getCreateUser());
        }
        setCreateUser(Assert.checkParam(user.getName()) ? user.getName() : "系统");
        Date actionTime = Assert.checkParam(apply.getSettlementDate())
                && Assert.equals(log.getCurrentStepKey(), "success") ? apply.getSettlementDate() : log.getUpdateTime();
        setCreateTime(DateUtils.formatForFull(actionTime, "-"));
        setCurrentStep(log.getCurrentStep());
        setCurrentAction(CurrentAction.getInfo(log.getCurrentAction()));
        setApproveComment(Assert.checkParam(log.getApproveComment()) ? log.getApproveComment() : "");
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
