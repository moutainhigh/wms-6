/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustTransferLog.java
 * Author:   朱道灵
 * Date:     2015年10月29日 下午1:10:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.common.BaseEntity;

/**
 * 客户转移日志 实体
 *
 * @author 朱道灵
 */
@Entity(name = "t_cust_transfer_log")
public class CustTransferLog extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 2499715424947731638L;

    /**
     * 客户转移-编号
     */
    private Long custTransferLogId;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 主键编号
     */
    private Long pkId;

    /**
     * 客户编号或者客户理财编号
     */
    private String pkCode;

    /**
     * 客户编号或者客户理财编号
     */
    private Long fromOrgId;

    /**
     * 来源团队
     */
    private Long fromTeamId;

    /**
     * 来源客户经理
     */
    private Long fromUser;

    /**
     * 目标营业部
     */
    private Long toOrgId;

    /**
     * 目标团队
     */
    private Long toTeamId;

    /**
     * 目标客户经理
     */
    private Long toUser;

    /**
     * @return the custTransferLogId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_transfer_log_id")
    public Long getCustTransferLogId() {
        return custTransferLogId;
    }

    /**
     * @param custTransferLogId the custTransferLogId to set
     */
    public void setCustTransferLogId(Long custTransferLogId) {
        this.custTransferLogId = custTransferLogId;
    }

    /**
     * @return the tableName
     */
    @Column(name = "table_name")
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the pkId
     */
    @Column(name = "pk_id")
    public Long getPkId() {
        return pkId;
    }

    /**
     * @param pkId the pkId to set
     */
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    /**
     * @return the pkCode
     */
    @Column(name = "pk_code")
    public String getPkCode() {
        return pkCode;
    }

    /**
     * @param pkCode the pkCode to set
     */
    public void setPkCode(String pkCode) {
        this.pkCode = pkCode;
    }

    /**
     * @return the fromOrgId
     */
    @Column(name = "from_org_id")
    public Long getFromOrgId() {
        return fromOrgId;
    }

    /**
     * @param fromOrgId the fromOrgId to set
     */
    public void setFromOrgId(Long fromOrgId) {
        this.fromOrgId = fromOrgId;
    }

    /**
     * @return the fromTeamId
     */
    @Column(name = "from_team_id")
    public Long getFromTeamId() {
        return fromTeamId;
    }

    /**
     * @param fromTeamId the fromTeamId to set
     */
    public void setFromTeamId(Long fromTeamId) {
        this.fromTeamId = fromTeamId;
    }

    /**
     * @return the fromUser
     */
    @Column(name = "from_user")
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
     * @return the toOrgId
     */
    @Column(name = "to_org_id")
    public Long getToOrgId() {
        return toOrgId;
    }

    /**
     * @param toOrgId the toOrgId to set
     */
    public void setToOrgId(Long toOrgId) {
        this.toOrgId = toOrgId;
    }

    /**
     * @return the toTeamId
     */
    @Column(name = "to_team_id")
    public Long getToTeamId() {
        return toTeamId;
    }

    /**
     * @param toTeamId the toTeamId to set
     */
    public void setToTeamId(Long toTeamId) {
        this.toTeamId = toTeamId;
    }

    /**
     * @return the toUser
     */
    @Column(name = "to_user")
    public Long getToUser() {
        return toUser;
    }

    /**
     * @param toUser the toUser to set
     */
    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

}
