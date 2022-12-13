package com.dx.cmm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class QueryResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    private Long custCommId;

    /**
     * 业务-编号:{"出借申请编号"}
     */
    private Long lenderApplyId;

    /**
     * 业务-编码:{"出借编号"}
     */
    private String lenderCode;

    /**
     * 业务-合同编号
     */
    private String ContractCode;

    /**
     * 理财客户编号
     */
    private String lenderCustCode;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 客户编号:{"理财端-客户编号"}
     */
    private String custCode;

    /**
     * 客户身份证
     */
    private String idCard;

    /**
     * 客户地址
     */
    private String custAddress;

    /**
     * 通讯地址-省区域-编码:{"NNNNNN"}
     */
    private String provinceRegionCode;

    /**
     * 通讯地址-市区域-编码:{"NNNNNN"}
     */
    private String cityRegionCode;

    /**
     * 通讯地址-区区域-编码:{"NNNNNN"}
     */
    private String districtRegionCode;

    /**
     * 通讯地址-街道信息
     */
    private String streetInfo;
    /**
     * 客户邮编
     */
    private String zipCode;

    /**
     * 客户电子邮箱:{"TT@TT.TT"}
     */
    private String email;

    /**
     * 客户手机号
     */
    private String mobile;

    /**
     * 业务总金额:{"合同金额","出借金额"}
     */
    private BigDecimal lenderAmount;

    /**
     * 业务产品编号
     */
    private Long productId;

    /**
     * 业务日期-起:{"还款日-起","预计出借日期-起"}
     */
    private Date expectLenderDateBegin;

    /**
     * 业务日期-止:{"还款日-止","预计出借日期-止"}
     */
    private Date expectLenderDateEnd;

    /**
     * 业务账单日
     */
    private Date settlementDate;

    /**
     * 业务到账日
     */
    private Integer statementDate;

    /**
     * 客户分类:{1:"客户分类",2:"公司员工"}
     */
    private Integer custCategory;

    /**
     * 营业部
     */
    private Long orgId;

    /**
     * 签单日期
     */
    private Date signDate;

    /**
     * 支付方式
     */
    private Integer payWayId;

    private String payWay;

    /**
     * 接受文件方式
     */
    private Integer msgWay;

    private String msgWayView;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 原申请编号
     */
    private Long parentId;
    /**
     * 职业情况 工薪1/自营2/学生3/白领4
     */
    private String profession;

    /**
     * 客户来源 1:内部业务 2：委外业务
     */
    private Integer custSource;

    public Long getCustCommId() {
        return custCommId;
    }

    public void setCustCommId(Long custCommId) {
        this.custCommId = custCommId;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getContractCode() {
        return ContractCode;
    }

    public void setContractCode(String contractCode) {
        ContractCode = contractCode;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getProvinceRegionCode() {
        return provinceRegionCode;
    }

    public void setProvinceRegionCode(String provinceRegionCode) {
        this.provinceRegionCode = provinceRegionCode;
    }

    public String getCityRegionCode() {
        return cityRegionCode;
    }

    public void setCityRegionCode(String cityRegionCode) {
        this.cityRegionCode = cityRegionCode;
    }

    public String getDistrictRegionCode() {
        return districtRegionCode;
    }

    public void setDistrictRegionCode(String districtRegionCode) {
        this.districtRegionCode = districtRegionCode;
    }

    public String getStreetInfo() {
        return streetInfo;
    }

    public void setStreetInfo(String streetInfo) {
        this.streetInfo = streetInfo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getExpectLenderDateBegin() {
        return expectLenderDateBegin;
    }

    public void setExpectLenderDateBegin(Date expectLenderDateBegin) {
        this.expectLenderDateBegin = expectLenderDateBegin;
    }

    public Date getExpectLenderDateEnd() {
        return expectLenderDateEnd;
    }

    public void setExpectLenderDateEnd(Date expectLenderDateEnd) {
        this.expectLenderDateEnd = expectLenderDateEnd;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Integer getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Integer statementDate) {
        this.statementDate = statementDate;
    }

    public Integer getCustCategory() {
        return custCategory;
    }

    public void setCustCategory(Integer custCategory) {
        this.custCategory = custCategory;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Integer getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(Integer payWayId) {
        this.payWayId = payWayId;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getMsgWay() {
        return msgWay;
    }

    public void setMsgWay(Integer msgWay) {
        this.msgWay = msgWay;
    }

    public String getMsgWayView() {
        return msgWayView;
    }

    public void setMsgWayView(String msgWayView) {
        this.msgWayView = msgWayView;
    }

}
