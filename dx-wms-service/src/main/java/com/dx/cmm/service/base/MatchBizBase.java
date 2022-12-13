package com.dx.cmm.service.base;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.dto.CreditAttr;
import com.dx.cmm.dto.InvestAttr;
import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.service.entitys.BaseEntity;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 债权匹配管理-匹配业务基础
 *
 * @author tony
 */
@Entity(name = "t_match_biz_base")
public class MatchBizBase extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 3475724266439758547L;

    private static final Integer DO_EXE = 0;

    /**
     * 匹配业务基础-编号
     */
    private Long matchBizBaseId;

    /**
     * 业务-编号:{"信贷申请编号","出借申请编号"}
     */
    private Long bizId;

    /**
     * 业务-编码:{"借款编号","出借编号"}
     */
    private String bizCode;

    /**
     * 业务-客户编码:{"借款端-客户编号","理财端-客户编号"}
     */
    private String bizCustCode;

    /**
     * 业务-合同编号
     */
    private String bizContractCode;

    /**
     * 业务-类别:{1:"信贷".2:"理财"}
     */
    private Integer bizCategory;

    /**
     * 客户姓名
     */
    public String custName;

    /**
     * 客户编号
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
    private BigDecimal bizTotalAmount;

    /**
     * 业务金额:{"每期还款金额"}
     */
    private BigDecimal bizAmount;

    /**
     * 业务产品编号
     */
    private Long bizProductId;

    /**
     * 业务周期
     */
    private Integer bizPeriod;

    /**
     * 业务日期-起:{"还款日-起","预计出借日期-起"}
     */
    private Date bizDateBegin;

    /**
     * 业务日期-止:{"还款日-止","预计出借日期-止"}
     */
    private Date bizDateEnd;

    /**
     * 业务账单日
     */
    private Integer bizBillDay;

    /**
     * 客户分类:{1:"客户分类",2:"公司员工"}
     */
    private Integer custCategory;

    /**
     * 营业部
     */
    private Long orgId;

    /**
     * 签约日期
     */
    private Date signDate;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 客户来源:{1:"内部",2:"委外"}
     */
    private Integer custSource;

    /**
     * 业务属性:{"接受文件方式","支付方式","职业情况","借款用途","月利率","预计债权收益率（年）"}
     */
    private String bizAttr;

    /**
     * 顺位
     */
    private Integer dataIndex;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_biz_base_id")
    public Long getMatchBizBaseId() {
        return matchBizBaseId;
    }

    public void setMatchBizBaseId(Long matchBizBaseId) {
        this.matchBizBaseId = matchBizBaseId;
    }

    @Column(name = "biz_id")
    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    @Column(name = "biz_code")
    public String getBizCode() {
        return bizCode;
    }

    public MatchBizBase setBizCode(String bizCode) {
        this.bizCode = bizCode;
        return this;
    }

    @Column(name = "biz_cust_code")
    public String getBizCustCode() {
        return bizCustCode;
    }

    public void setBizCustCode(String bizCustCode) {
        this.bizCustCode = bizCustCode;
    }

    @Column(name = "biz_contract_code")
    public String getBizContractCode() {
        return bizContractCode;
    }

    public MatchBizBase setBizContractCode(String bizContractCode) {
        this.bizContractCode = bizContractCode;
        return this;
    }

    @Column(name = "biz_category")
    public Integer getBizCategory() {
        return bizCategory;
    }

    public void setBizCategory(Integer bizCategory) {
        this.bizCategory = bizCategory;
    }

    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public MatchBizBase setCustName(String custName) {
        this.custName = custName;
        return this;
    }

    @Column(name = "cust_code")
    public String getCustCode() {
        return custCode;
    }

    public MatchBizBase setCustCode(String custCode) {
        this.custCode = custCode;
        return this;
    }

    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public MatchBizBase setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    @Column(name = "cust_address")
    public String getCustAddress() {
        return custAddress;
    }

    public MatchBizBase setCustAddress(String custAddress) {
        this.custAddress = custAddress;
        return this;
    }

    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public MatchBizBase setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public MatchBizBase setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public MatchBizBase setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    @Column(name = "biz_total_amount")
    public BigDecimal getBizTotalAmount() {
        return bizTotalAmount;
    }

    public void setBizTotalAmount(BigDecimal bizTotalAmount) {
        this.bizTotalAmount = bizTotalAmount;
    }

    @Column(name = "biz_amount")
    public BigDecimal getBizAmount() {
        return bizAmount;
    }

    public MatchBizBase setBizAmount(BigDecimal bizAmount) {
        this.bizAmount = bizAmount;
        return this;
    }

    @Column(name = "biz_product_id")
    public Long getBizProductId() {
        return bizProductId;
    }

    public MatchBizBase setBizProductId(Long bizProductId) {
        this.bizProductId = bizProductId;
        return this;
    }

    @Column(name = "biz_period")
    public Integer getBizPeriod() {
        return bizPeriod;
    }

    public void setBizPeriod(Integer bizPeriod) {
        this.bizPeriod = bizPeriod;
    }

    @Column(name = "biz_date_begin")
    public Date getBizDateBegin() {
        return bizDateBegin;
    }

    public MatchBizBase setBizDateBegin(Date bizDateBegin) {
        this.bizDateBegin = bizDateBegin;
        return this;
    }

    @Column(name = "biz_date_end")
    public Date getBizDateEnd() {
        return bizDateEnd;
    }

    public MatchBizBase setBizDateEnd(Date bizDateEnd) {
        this.bizDateEnd = bizDateEnd;
        return this;
    }

    @Column(name = "biz_bill_day")
    public Integer getBizBillDay() {
        return bizBillDay;
    }

    public void setBizBillDay(Integer bizBillDay) {
        this.bizBillDay = bizBillDay;
    }

    @Column(name = "cust_category")
    public Integer getCustCategory() {
        return custCategory;
    }

    public MatchBizBase setCustCategory(Integer custCategory) {
        this.custCategory = custCategory;
        return this;
    }

    @Column(name = "org_id")
    public Long getOrgId() {
        return orgId;
    }

    public MatchBizBase setOrgId(Long orgId) {
        this.orgId = orgId;
        return this;
    }

    @Column(name = "sign_date")
    public Date getSignDate() {
        return signDate;
    }

    public MatchBizBase setSignDate(Date signDate) {
        this.signDate = signDate;
        return this;
    }

    @Column(name = "apply_date")
    public Date getApplyDate() {
        return applyDate;
    }

    public MatchBizBase setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
        return this;
    }

    @Column(name = "cust_source")
    public Integer getCustSource() {
        return custSource;
    }

    public MatchBizBase setCustSource(Integer custSource) {
        this.custSource = custSource;
        return this;
    }

    @Column(name = "biz_attr")
    public String getBizAttr() {
        return bizAttr;
    }

    public void setBizAttr(String bizAttr) {
        this.bizAttr = bizAttr;
    }

    @Column(name = "data_index")
    public Integer getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(Integer dataIndex) {
        this.dataIndex = dataIndex;
    }

    /**
     * 
     * 获取投资属性
     *
     * @return
     */
    public InvestAttr invest() {
        return Assert.checkParam(getBizAttr()) ? JSON.parseObject(getBizAttr(), InvestAttr.class) : new InvestAttr();
    }

    /**
     * 
     * 获取债权属性
     *
     * @return
     */
    public CreditAttr credit() {
        return Assert.checkParam(getBizAttr()) ? JSON.parseObject(getBizAttr(), CreditAttr.class) : new CreditAttr();
    }

    public void exe(BizBaseStatus status) {
        setDataStatus(status.getCode());
        exe();
    }

    public void exe() {
        setDataIndex(DO_EXE);
        setUpdateTime();
    }
    
}
