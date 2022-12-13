package com.dx.wms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 〈一句话功能简述〉理财管理-数据调用记录表
 *
 * @author 王蕊 
 */
@Entity(name = "t_invoke_log")
public class InvokeLog implements Serializable {

    /** Serial UID */
    private static final long serialVersionUID = 1L;

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

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "invoke_log_id")
    public Long getInvokeLogId() {
        return invokeLogId;
    }

    public void setInvokeLogId(Long invokeLogId) {
        this.invokeLogId = invokeLogId;
    }

    /**
     * @return the invokeLogCode
     */
    @Column(name = "invoke_log_code")
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
     * @return the lenderCode
     */
    @Column(name = "lender_code")
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
    @Column(name = "invoke_result")
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
    @Column(name = "invoke_comment")
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
    @Column(name = "create_time")
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
    @Column(name = "create_user")
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
    @Column(name = "update_time")
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
    @Column(name = "update_user")
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
    @Column(name = "data_status")
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
     * @return the lenderApplyId
     */
    @Column(name = "lender_apply_id")
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * @param lenderApplyId the lenderApplyId to set
     */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }
}
