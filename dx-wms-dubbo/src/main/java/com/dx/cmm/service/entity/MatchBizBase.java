/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: matchBizBase.java
 * Author:   蔡登勇
 * Date:     2015年7月26日 上午11:39:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.CreditAttr;
import com.dx.cmm.dto.InvestAttr;
import com.dx.cmm.enums.BizCategory;
import com.dx.common.service.utils.Assert;

/**
 * 债券匹配管理-匹配业务基础表实体
 *
 * @author tony
 */
@Entity(name = "t_match_biz_base")
public class MatchBizBase implements Serializable {

    /**
     */
    private static final long serialVersionUID = 7350015897085857063L;

    /**
     * 异常
     */
    private static final String EXCEPTION = "E";

    /**
     * 失败
     */
    private static final String FAIL = "F";

    /**
     * 生效
     */
    private static final String SUCCESS = "S";

    /**
     * 重新匹配
     */
    private static final String REPEAT = "N";

    /**
     * 初始
     */
    private static final String INIT = "A";

    /**
     * 删除
     */
    private static final String DEL = "D";

    /**
     * 续投
     */
    private static final String CONTINUE = "G";

    /**
     * 到期
     */
    private static final String TRANS = "T";

    /**
     * 已请求
     */
    private static final Integer IS_EXE = 1;

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
    private String custName;

    /**
     * 业务客户编号
     */
    private String bizCustCode;

    /**
     * 客户编号:{"借款端-客户编号","理财端-客户编号"}
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
     * 顺位
     */
    private Integer dataIndex = 0;

    /**
     * 业务属性:{"接受文件方式","支付方式","职业情况","借款用途","月利率","预计债权收益率（年）"}
     */
    private String bizAttr;

    /**
     * 客户来源 1：内部业务 2：委外业务
     */
    private Integer custSource;

    /**
     * 创建者:{"-1":"系统"}
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者:{"-1":"系统"}
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 数据状态
     */
    private String dataStatus;

    public MatchBizBase() {

    }

    public MatchBizBase(BizBase base) {
        BeanUtils.copyProperties(base, this);
        setCreateUser(base).setUpdateUser(base).init();
    }

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

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    @Column(name = "biz_category")
    public Integer getBizCategory() {
        return bizCategory;
    }

    public void setBizCategory(Integer bizCategory) {
        this.bizCategory = bizCategory;
    }

    public void setBizCategory(BizCategory category) {
        setBizCategory(category.getCode());
    }

    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    private MatchBizBase setCustName(BizBase base) {
        setCustName(base.getCustName());
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

    public void setIdCard(String idCard) {
        this.idCard = idCard;

    }

    private MatchBizBase setIdCard(BizBase base) {
        setIdCard(base.getIdCard());
        return this;
    }

    @Column(name = "cust_address")
    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    private MatchBizBase setCustAddress(BizBase base) {
        setCustAddress(base.getCustAddress());
        return this;
    }

    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    private MatchBizBase setZipCode(BizBase base) {
        setZipCode(base.getZipCode());
        return this;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    private MatchBizBase setEmail(BizBase base) {
        setEmail(base.getEmail());
        return this;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private MatchBizBase setMobile(BizBase base) {
        setMobile(base.getMobile());
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

    public void setBizAmount(BigDecimal bizAmount) {
        this.bizAmount = bizAmount;
    }

    @Column(name = "biz_product_id")
    public Long getBizProductId() {
        return bizProductId;
    }

    public void setBizProductId(Long bizProductId) {
        this.bizProductId = bizProductId;
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

    public void setBizDateBegin(Date bizDateBegin) {
        this.bizDateBegin = bizDateBegin;
    }

    @Column(name = "biz_date_end")
    public Date getBizDateEnd() {
        return bizDateEnd;
    }

    public void setBizDateEnd(Date bizDateEnd) {
        this.bizDateEnd = bizDateEnd;
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

    public void setCustCategory(Integer custCategory) {
        this.custCategory = custCategory;
    }

    public MatchBizBase setCustCategory(BizBase base) {
        setCustCategory(base.getCustCategory());
        return this;
    }

    @Column(name = "org_id")
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Column(name = "sign_date")
    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Column(name = "apply_date")
    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    @Column(name = "data_index")
    public Integer getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(Integer dataIndex) {
        this.dataIndex = dataIndex;
    }

    @Column(name = "biz_attr")
    public String getBizAttr() {
        return bizAttr;
    }

    public MatchBizBase setBizAttr(String bizAttr) {
        this.bizAttr = bizAttr;
        return this;
    }

    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    private MatchBizBase setCreateUser(BizBase base) {
        setCreateUser(base.getActionUser());
        return this;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateTime() {
        setCreateTime(new Date());
    }

    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public MatchBizBase setUpdateUser(BizBase base) {
        setUpdateUser(base.getActionUser());
        return this;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public MatchBizBase setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    private MatchBizBase setUpdateTime() {
        return setUpdateTime(new Date());
    }

    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public MatchBizBase setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
        return this;
    }

    @Column(name = "cust_source")
    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    @Column(name = "biz_contract_code")
    public String getBizContractCode() {
        return bizContractCode;
    }

    public void setBizContractCode(String bizContractCode) {
        this.bizContractCode = bizContractCode;
    }

    public MatchBizBase setBizContractCode(BizBase base) {
        setBizContractCode(base.getBizContractCode());
        return this;
    }

    @Column(name = "biz_cust_code")
    public String getBizCustCode() {
        return bizCustCode;
    }

    public void setBizCustCode(String bizCustCode) {
        this.bizCustCode = bizCustCode;
    }

    public void exception() {
        setDataIndex(IS_EXE);
        setDataStatus(EXCEPTION).setUpdateTime();
    }

    public void fail() {
        setDataIndex(IS_EXE);
        setDataStatus(FAIL).setUpdateTime();
    }

    public void repeat(Set<Long> creditIds) {
        InvestAttr attr = invest();
        attr.setCreditIds(creditIds);
        setBizAttr(Assert.checkParam(attr) ? JSON.toJSONString(attr) : "");
        setDataIndex(IS_EXE);
        setDataStatus(REPEAT).setUpdateTime();
    }

    public void init() {
        setDataStatus(INIT).setUpdateTime().setCreateTime();
    }

    public void del() {
        setDataIndex(IS_EXE);
        setDataStatus(DEL).setUpdateTime();
    }

    public void success(Date valiDate) {
        InvestAttr attr = invest();
        attr.setInterestBeginTime(valiDate);
        setBizAttr(Assert.checkParam(attr) ? JSON.toJSONString(attr) : "");
        setDataIndex(IS_EXE);
        setDataStatus(SUCCESS).setUpdateTime();
    }

    public void trans(Date payTime) {
        InvestAttr attr = invest();
        attr.setPayTime(payTime);
        setBizAttr(Assert.checkParam(attr) ? JSON.toJSONString(attr) : "");
        setDataIndex(IS_EXE);
        setDataStatus(TRANS).setUpdateTime();
    }

    public void doContinue() {
        setDataStatus(CONTINUE).setUpdateTime().setCreateTime();
    }

    public void account(BizBase base) {
        setCustName(base).setIdCard(base).setCustAddress(base).setZipCode(base).setEmail(base).setMobile(base)
                .setCustCategory(base).setUpdateUser(base).setUpdateTime();
    }

    public InvestAttr invest() {
        return Assert.checkParam(getBizAttr()) ? JSON.parseObject(getBizAttr(), InvestAttr.class) : new InvestAttr();
    }

    public CreditAttr credit() {
        return Assert.checkParam(getBizAttr()) ? JSON.parseObject(getBizAttr(), CreditAttr.class) : new CreditAttr();
    }

    public void apply(BizBase base) {
        setBizContractCode(base).setUpdateTime().setUpdateUser(base);
    }

    public Boolean isInit() {
        return Assert.equals(getDataStatus(), INIT);
    }

    public Boolean isExe() {
        return Assert.equals(getDataIndex(), IS_EXE);
    }

}
