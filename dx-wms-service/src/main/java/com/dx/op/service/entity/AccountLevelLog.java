package com.dx.op.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.enums.BizCategory;
import com.dx.cmm.service.tasks.AccountParamTask;

/**
 * 
 * 运营管理-账户级别日志表<br>
 * 运营管理-账户级别日志表
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Entity(name = "t_account_level_log")
public class AccountLevelLog implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4101508145112217645L;

    private static final String INIT = "A";

    private static final Integer TRUE = 1;

    private static final Integer FALSE = 0;
    /**
     * 运营管理-账户级别日志编号
     */
    private Long accountLevelLogId;

    /**
     * 运营管理-账户级别编号
     */
    private Long accountLevelId;

    /**
     * 运营管理-业务类别:{1:"信贷".2:"理财"}
     */
    private Integer bizCategory;

    /**
     * 运营管理-客户编号:{"借款端-客户编号","理财端-客户编号"}
     */
    private String custCode;

    /**
     * 运营管理-当前账户金额
     */
    private BigDecimal accountCurrentAmount;

    /**
     * 运营管理-当前状态:{1:"是",0:"否"}
     */
    private Integer isCurrent;

    /**
     * 创建者:{"-1":"系统"}
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 更新者:{"-1":"系统"}
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 数据状态:{"A":"已生效","D":"已删除"}
     */
    private String dataStatus = INIT;

    public AccountLevelLog() {

    }

    public AccountLevelLog(AccountParamTask user, AccountLevel level) {
        setIsCurrent(TRUE);
        setAccountCurrentAmount(user.getAccountAmount());
        setCustCode(user.getCustCode());
        setAccountLevelId(level.getAccountLevelId());
        setBizCategory(BizCategory.INVEST.getCode());
    }

    public void put() {
        setIsCurrent(FALSE);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "account_level_log_id")
    public Long getAccountLevelLogId() {
        return accountLevelLogId;
    }

    public void setAccountLevelLogId(Long accountLevelLogId) {
        this.accountLevelLogId = accountLevelLogId;
    }

    @Column(name = "account_level_id")
    public Long getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(Long accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    @Column(name = "biz_category")
    public Integer getBizCategory() {
        return bizCategory;
    }

    public void setBizCategory(Integer bizCategory) {
        this.bizCategory = bizCategory;
    }

    @Column(name = "cust_code")
    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    @Column(name = "account_current_amount")
    public BigDecimal getAccountCurrentAmount() {
        return accountCurrentAmount;
    }

    public void setAccountCurrentAmount(BigDecimal accountCurrentAmount) {
        this.accountCurrentAmount = accountCurrentAmount;
    }

    @Column(name = "is_current")
    public Integer getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
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

}
