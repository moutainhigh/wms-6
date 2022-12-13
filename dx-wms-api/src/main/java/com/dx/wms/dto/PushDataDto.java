package com.dx.wms.dto;

import java.io.Serializable;
import java.util.Date;

public class PushDataDto implements Serializable {

    /**
     * Serial UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 业务ID
     */
    private Long bizId;

    /**
     * bizCode 业务流水号
     */
    private String bizCode;

    /**
     * dataType 数据类型 1.出资 2.到帐
     */
    private Integer dataType;

    /**
     * 出资结果 (0:成功 1:失败 2：部分划扣)
     */
    private Integer result;

    /**
     * 备注
     */
    private String remark;

    /**
     * 资金到账日
     */
    private Date settlementDate;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 理财编号
     */
    private String lenderCode;

    /**
     * 到期日
     */
    private Date dueDate;

    /**
     * 账单日
     */
    private Integer statementDate;

    /**
     * 匹配日期
     */
    private Date matchDate;

    public PushDataDto() {
    }

    public PushDataDto(String lenderCode) {
        setLenderCode(lenderCode);
    }

    public void match(Long createUser, String lenderCode, Integer statementDate, Date matchDate) {
        setCreateUser(createUser);
        setLenderCode(lenderCode);
        setStatementDate(statementDate);
        setMatchDate(matchDate);
    }

    public void giveUp(Long userId, String lenderCode) {
        setCreateUser(userId);
        setLenderCode(lenderCode);
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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
     * @return the bizId
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * @param bizId the bizId to set
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * @return the settlementDate
     */
    public Date getSettlementDate() {
        return settlementDate;
    }

    /**
     * @param settlementDate the settlementDate to set
     */
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * @return the dataType
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
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
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Integer statementDate) {
        this.statementDate = statementDate;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

}
