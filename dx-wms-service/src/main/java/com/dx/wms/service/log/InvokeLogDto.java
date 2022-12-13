package com.dx.wms.service.log;

import java.io.Serializable;
import java.util.Date;

public class InvokeLogDto implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = -9090927565009506671L;

    /** 调用 */
    private Long invokeLogId;
    
    /** 调用流水号 */
    private String invokeLogCode;
    
    /** 理财编号ID */
    private Long lenderApplyId;
    
    /** 理财编号 */
    private String lenderCode;
    
    /** 调用结果　 */
    private Integer invokeResult;
    
    /** 备注 */
    private String invokeComment;
    
    /** 创建时间 */
    private Date createTime;

    /** 创建人 */
    private Long createUser;

    /** 更新时间 */
    private Date updateTime;

    /** 更新人 */
    private Long updateUser;

    /** 数据状态 */
    private String dataStatus;

    /**
     * @return the invokeLogId
     */
    public Long getInvokeLogId() {
        return invokeLogId;
    }

    /**
     * @param invokeLogId the invokeLogId to set
     */
    public void setInvokeLogId(Long invokeLogId) {
        this.invokeLogId = invokeLogId;
    }

    /**
     * @return the invokeLogCode
     */
    public String getInvokeLogCode() {
        return invokeLogCode;
    }

    /**
     * @param invokeLogCode the invokeLogCode to set
     */
    public void setInvokeLogCode(String invokeLogCode) {
        this.invokeLogCode = invokeLogCode;
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
     * @return the lenderCode
     */
    public String getLenderCode() {
        return lenderCode;
    }

    /**
     * @param lenderCode the lenderCode to set
     */
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    /**
     * @return the invokeResult
     */
    public Integer getInvokeResult() {
        return invokeResult;
    }

    /**
     * @param invokeResult the invokeResult to set
     */
    public void setInvokeResult(Integer invokeResult) {
        this.invokeResult = invokeResult;
    }

    /**
     * @return the invokeComment
     */
    public String getInvokeComment() {
        return invokeComment;
    }

    /**
     * @param invokeComment the invokeComment to set
     */
    public void setInvokeComment(String invokeComment) {
        this.invokeComment = invokeComment;
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
}
