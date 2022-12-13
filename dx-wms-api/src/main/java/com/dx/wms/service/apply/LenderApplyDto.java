package com.dx.wms.service.apply;

import java.math.BigDecimal;
import java.util.Date;

public class LenderApplyDto extends LenderApplyBase{

    /**
     */
    private static final long serialVersionUID = 1530626003677828772L;
    
    /**
     * 申请日
     */
    private Date signDate;
    
    /**
     * 客户姓名
     */
    private String custName;
    
    /**
     * 出借编号
     */
    private String lenderCode;
    
    /**
     * 申请单编号
     */
    private Long lenderApplyId;
    
    /**
     * 性别
     */
    private Integer sex;
    
    /**
     * 身份证
     */
    private String idCard;
    
    
    private Integer idType;
    
    /**
     * 出借产品
     */
    private Integer productId;
    
    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;
    
    /**
     * 客户分类
     */
    private Integer custCategory;
    
    /**
     * 预计出借日期起
     */
    private Date lenderDateBegin;
    
    /**
     * 预计出借日期止
     */
    private Date lenderDateEnd;
    
    /**
     * 营业部id
     */
    private Long orgId;
    
    /**
     * 团队主管
     */
    private Long teamId;
    
    /**
     * 客户经理id
     */
    private Long managerId;
    
    /**
     * 回款姓名
     */
    private String backAccountName;
    
    /**
     * 回款银行
     */
    private Integer backBank;
    
    /**
     * 回款支行
     */
    private String backSubBank;
    
    /**
     * 回款帐户
     */
    private String backAccountNum;
    
    /**
     * 接受文件方式
     */
    private Integer msgWay;
    
    /**
     * 手机号
     */
    private String mobile;
    
    /**
     * 合同编号
     */
    private String contractCode;
    
    /**
     * 原单子出借编号
     */
    private Long parentId;
    
    /**
     * 城市编码
     */
    private String cityCode;
    
    /**
     * 
     */
    private String provinceRegionCode;

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public Integer getCustCategory() {
        return custCategory;
    }

    public void setCustCategory(Integer custCategory) {
        this.custCategory = custCategory;
    }

    public Date getLenderDateBegin() {
        return lenderDateBegin;
    }

    public void setLenderDateBegin(Date lenderDateBegin) {
        this.lenderDateBegin = lenderDateBegin;
    }

    public Date getLenderDateEnd() {
        return lenderDateEnd;
    }

    public void setLenderDateEnd(Date lenderDateEnd) {
        this.lenderDateEnd = lenderDateEnd;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
   
    public String getBackAccountName() {
        return backAccountName;
    }

    public void setBackAccountName(String backAccountName) {
        this.backAccountName = backAccountName;
    }

    
    public String getBackSubBank() {
        return backSubBank;
    }

    public void setBackSubBank(String backSubBank) {
        this.backSubBank = backSubBank;
    }

    public String getBackAccountNum() {
        return backAccountNum;
    }

    public void setBackAccountNum(String backAccountNum) {
        this.backAccountNum = backAccountNum;
    }

    public Integer getMsgWay() {
        return msgWay;
    }

    public void setMsgWay(Integer msgWay) {
        this.msgWay = msgWay;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

  
    /**
     * @return the backBank
     */
    public Integer getBackBank() {
        return backBank;
    }

    /**
     * @param backBank the backBank to set
     */
    public void setBackBank(Integer backBank) {
        this.backBank = backBank;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * @return the cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode the cityCode to set
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * @return the provinceRegionCode
     */
    public String getProvinceRegionCode() {
        return provinceRegionCode;
    }

    /**
     * @param provinceRegionCode the provinceRegionCode to set
     */
    public void setProvinceRegionCode(String provinceRegionCode) {
        this.provinceRegionCode = provinceRegionCode;
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
    
}
