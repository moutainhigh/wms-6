package com.dx.wms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LenderManagermentDataDto implements Serializable {
    /**
     */
    private static final long serialVersionUID = 7831783562725553541L;

    /** 客户账户-编号 */
    private Long custAccountId;

    /** 理财-客户-编码 */
    private String lenderCustCode;
    
    /** 客户编号 */
    private String custCode;
    
    /** 客户-姓名 */
    private String custName;

    /** 客户-姓名-拼音 */
    private String custNameSpell;

    /** 性别 */
    private Integer sex;

    /** 国籍 */
    private String nationality;

    /** 常用语言 */
    private Integer commonLanguage;

    /** 婚姻状况 */
    private Integer maritalStatus;

    /** 证件类型 */
    private Integer idType;

    /** 证件号码 */
    private String idCard;

    /** 出生日期 */
    private Date birthDate;

    /** 移动电话 */
    private String mobile;

    /** 最高学历 */
    private Integer education;

    /** 接受文件方式 */
    private Integer msgWay;

    /** 客户来源 */
    private Integer custSource;

    /** 客户来源-其他 */
    private String custSourceOther;

    /** 开户日期 */
    private Date openDate;

    /** 客户分类 */
    private Integer custCategory;

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

    /** 营业部编号 */
    private Long orgId;
    /** 团队编号 */
    private Long teamId;
    
    /** 开户日期 */
    private Date accountTime;

    /** 出借申请编号 主键 */
    private Long lenderApplyId;

    /** 出借编号-规则 */
    private String lenderCode;


    /** 合同编号 */
    private String contractCode;

    /** 出借方式 */
    private Long productId;

    /** 预计出借日期-起 */
    private Date expectLenderDateBegin;

    /** 预计出借日期-止 */
    private Date expectLenderDateEnd;

    /** 支付方式-编号 */
    private Long payWayId;

    /** 出借金额 */
    private BigDecimal lenderAmount;

    /** 客户金融-编号 */
    private Long custFinanceId;

    /** 签单日期 */
    private Date signDate;

    /** 到账日 */
    private Date settlementDate;

    /**账单日 */
    private Integer statementDate;
    
    /**匹配日期 */
    private Date matchDate;
    
    /** 签约手机 */
    private String signMobile;

    /** 理财申请单状态*/
    private Long formStatus;

    /** 续投原理财ID*/
    private Long flagId;

    /**　到期日*/
    private Date dueDate;
    
    /** 流程实例ID */
    private String procInsId;
    
    /**
     * 回收方式
     * */
    private Integer recovery;
    
    /**
     * @return the custAccountId
     */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * @param custAccountId the custAccountId to set
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /**
     * @return the lenderCustCode
     */
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    /**
     * @param lenderCustCode the lenderCustCode to set
     */
    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    /**
     * @return the custCode
     */
    public String getCustCode() {
        return custCode;
    }

    /**
     * @param custCode the custCode to set
     */
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the custNameSpell
     */
    public String getCustNameSpell() {
        return custNameSpell;
    }

    /**
     * @param custNameSpell the custNameSpell to set
     */
    public void setCustNameSpell(String custNameSpell) {
        this.custNameSpell = custNameSpell;
    }

    /**
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the commonLanguage
     */
    public Integer getCommonLanguage() {
        return commonLanguage;
    }

    /**
     * @param commonLanguage the commonLanguage to set
     */
    public void setCommonLanguage(Integer commonLanguage) {
        this.commonLanguage = commonLanguage;
    }

    /**
     * @return the maritalStatus
     */
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the idType
     */
    public Integer getIdType() {
        return idType;
    }

    /**
     * @param idType the idType to set
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /**
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the education
     */
    public Integer getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(Integer education) {
        this.education = education;
    }

    /**
     * @return the msgWay
     */
    public Integer getMsgWay() {
        return msgWay;
    }

    /**
     * @param msgWay the msgWay to set
     */
    public void setMsgWay(Integer msgWay) {
        this.msgWay = msgWay;
    }

    /**
     * @return the custSource
     */
    public Integer getCustSource() {
        return custSource;
    }

    /**
     * @param custSource the custSource to set
     */
    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    /**
     * @return the custSourceOther
     */
    public String getCustSourceOther() {
        return custSourceOther;
    }

    /**
     * @param custSourceOther the custSourceOther to set
     */
    public void setCustSourceOther(String custSourceOther) {
        this.custSourceOther = custSourceOther;
    }

    /**
     * @return the openDate
     */
    public Date getOpenDate() {
        return openDate;
    }

    /**
     * @param openDate the openDate to set
     */
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    /**
     * @return the custCategory
     */
    public Integer getCustCategory() {
        return custCategory;
    }

    /**
     * @param custCategory the custCategory to set
     */
    public void setCustCategory(Integer custCategory) {
        this.custCategory = custCategory;
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

    /**
     * @return the orgId
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the teamId
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the accountTime
     */
    public Date getAccountTime() {
        return accountTime;
    }

    /**
     * @param accountTime the accountTime to set
     */
    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
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
     * @return the contractCode
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * @param contractCode the contractCode to set
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * @return the productId
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return the expectLenderDateBegin
     */
    public Date getExpectLenderDateBegin() {
        return expectLenderDateBegin;
    }

    /**
     * @param expectLenderDateBegin the expectLenderDateBegin to set
     */
    public void setExpectLenderDateBegin(Date expectLenderDateBegin) {
        this.expectLenderDateBegin = expectLenderDateBegin;
    }

    /**
     * @return the expectLenderDateEnd
     */
    public Date getExpectLenderDateEnd() {
        return expectLenderDateEnd;
    }

    /**
     * @param expectLenderDateEnd the expectLenderDateEnd to set
     */
    public void setExpectLenderDateEnd(Date expectLenderDateEnd) {
        this.expectLenderDateEnd = expectLenderDateEnd;
    }

    /**
     * @return the payWayId
     */
    public Long getPayWayId() {
        return payWayId;
    }

    /**
     * @param payWayId the payWayId to set
     */
    public void setPayWayId(Long payWayId) {
        this.payWayId = payWayId;
    }

    /**
     * @return the lenderAmount
     */
    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    /**
     * @param lenderAmount the lenderAmount to set
     */
    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    /**
     * @return the custFinanceId
     */
    public Long getCustFinanceId() {
        return custFinanceId;
    }

    /**
     * @param custFinanceId the custFinanceId to set
     */
    public void setCustFinanceId(Long custFinanceId) {
        this.custFinanceId = custFinanceId;
    }

    /**
     * @return the signDate
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * @param signDate the signDate to set
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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
     * @return the statementDate
     */
    public Integer getStatementDate() {
        return statementDate;
    }

    /**
     * @param statementDate the statementDate to set
     */
    public void setStatementDate(Integer statementDate) {
        this.statementDate = statementDate;
    }

    /**
     * @return the matchDate
     */
    public Date getMatchDate() {
        return matchDate;
    }

    /**
     * @param matchDate the matchDate to set
     */
    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    /**
     * @return the signMobile
     */
    public String getSignMobile() {
        return signMobile;
    }

    /**
     * @param signMobile the signMobile to set
     */
    public void setSignMobile(String signMobile) {
        this.signMobile = signMobile;
    }

    /**
     * @return the formStatus
     */
    public Long getFormStatus() {
        return formStatus;
    }

    /**
     * @param formStatus the formStatus to set
     */
    public void setFormStatus(Long formStatus) {
        this.formStatus = formStatus;
    }

    /**
     * @return the flagId
     */
    public Long getFlagId() {
        return flagId;
    }

    /**
     * @param flagId the flagId to set
     */
    public void setFlagId(Long flagId) {
        this.flagId = flagId;
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

    /**
     * @return the procInsId
     */
    public String getProcInsId() {
        return procInsId;
    }

    /**
     * @param procInsId the procInsId to set
     */
    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    /**
     * @return the recovery
     */
    public Integer getRecovery() {
        return recovery;
    }

    /**
     * @param recovery the recovery to set
     */
    public void setRecovery(Integer recovery) {
        this.recovery = recovery;
    }
}
