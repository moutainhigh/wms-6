/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchBizBaseDto.java
 * Author:   蔡登勇
 * Date:     2015年7月26日 下午12:51:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.MatchBizConstant;
import com.dx.wms.enums.BizCategery;
import com.dx.wms.enums.CustCategery;
import com.dx.wms.service.exception.MatchBizIPIsErrorException;

/**
 * 匹配业务基础Dto
 *
 * @author 蔡登勇
 */
public class MatchBizBaseDto implements Serializable {
    /**
     */
    private static final long serialVersionUID = -6897473488663090025L;

    /** 匹配业务基础-编号 */
    private Long matchBizBaseId;

    /** 业务-编号:{"信贷申请编号","出借申请编号"} */
    private Long bizId;

    /** 业务-编码:{"借款编号","出借编号"} */
    private String bizCode;

    /** 业务-合同编号 */
    private String bizContractCode;

    /** 业务-类别:{1:"信贷".2:"理财"} */
    private Integer bizCategory;

    /** 客户姓名 */
    private String custName;

    /** 客户编号:{"借款端-客户编号","理财端-客户编号"} */
    private String custCode;

    /** 客户身份证 */
    private String idCard;

    /** 客户地址 */
    private String custAddress;

    /** 客户邮编 */
    private String zipCode;

    /** 客户电子邮箱:{"TT@TT.TT"} */
    private String email;

    /** 客户手机号 */
    private String mobile;

    /** 业务总金额:{"合同金额","出借金额"} */
    private BigDecimal bizTotalAmount;

    /** 业务金额:{"每期还款金额"} */
    private BigDecimal bizAmount;

    /** 业务产品编号 */
    private Long bizProductId;

    /** 业务周期 */
    private Integer bizPeriod;

    /** 业务日期-起:{"还款日-起","预计出借日期-起"} */
    private Date bizDateBegin;

    /** 业务日期-止:{"还款日-止","预计出借日期-止"} */
    private Date bizDateEnd;

    /** 业务账单日 */
    private Integer bizBillDay;

    /** 客户分类:{1:"客户分类",2:"公司员工"} */
    private Integer custCategory;

    /** 营业部 */
    private Long orgId;

    /** 签约日期 */
    private Date signDate;

    /** 申请日期 */
    private Date applyDate;

    /** 业务属性:{"接受文件方式","支付方式","职业情况","借款用途","月利率","预计债权收益率（年）"} */
    private String bizAttr;

    /** 创建者:{"-1":"系统"} */
    private Long createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新者:{"-1":"系统"} */
    private Long updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 数据状态:{"A":"已生效","D":"已删除"}； */
    private String dataStatus;

    /** 操作人 */
    private Long actionUser;

    /** 客户来源 1:内部业务 2：委外业务 */
    private Integer custSource;

    /** 银行账户 */
    private List<MatchBizBaseAccountDto> matchBizBaseAccountDtos;

    public List<MatchBizBaseAccountDto> getMatchBizBaseAccountDtos() {
        return matchBizBaseAccountDtos;
    }

    public void setMatchBizBaseAccountDtos(List<MatchBizBaseAccountDto> matchBizBaseAccountDtos) {
        this.matchBizBaseAccountDtos = matchBizBaseAccountDtos;
    }

    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    public Long getMatchBizBaseId() {
        return matchBizBaseId;
    }

    public void setMatchBizBaseId(Long matchBizBaseId) {
        this.matchBizBaseId = matchBizBaseId;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public Integer getBizCategory() {
        return bizCategory;
    }

    public void setBizCategory(Integer bizCategory) {
        this.bizCategory = bizCategory;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
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

    public BigDecimal getBizTotalAmount() {
        return bizTotalAmount;
    }

    public void setBizTotalAmount(BigDecimal bizTotalAmount) {
        this.bizTotalAmount = bizTotalAmount;
    }

    public BigDecimal getBizAmount() {
        return bizAmount;
    }

    public void setBizAmount(BigDecimal bizAmount) {
        this.bizAmount = bizAmount;
    }

    public Long getBizProductId() {
        return bizProductId;
    }

    public void setBizProductId(Long bizProductId) {
        this.bizProductId = bizProductId;
    }

    public Integer getBizPeriod() {
        return bizPeriod;
    }

    public void setBizPeriod(Integer bizPeriod) {
        this.bizPeriod = bizPeriod;
    }

    public Date getBizDateBegin() {
        return bizDateBegin;
    }

    public void setBizDateBegin(Date bizDateBegin) {
        this.bizDateBegin = bizDateBegin;
    }

    public Date getBizDateEnd() {
        return bizDateEnd;
    }

    public void setBizDateEnd(Date bizDateEnd) {
        this.bizDateEnd = bizDateEnd;
    }

    public Integer getBizBillDay() {
        return bizBillDay;
    }

    public void setBizBillDay(Integer bizBillDay) {
        this.bizBillDay = bizBillDay;
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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getBizAttr() {
        return bizAttr;
    }

    public void setBizAttr(String bizAttr) {
        this.bizAttr = bizAttr;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Long getActionUser() {
        return actionUser;
    }

    public void setActionUser(Long actionUser) {
        this.actionUser = actionUser;
    }

    public String getBizContractCode() {
        return bizContractCode;
    }

    public void setBizContractCode(String bizContractCode) {
        this.bizContractCode = bizContractCode;
    }

    public static MatchBizBaseDto checkMatchBizBaseDto(MatchBizBaseDto matchBizBaseDto) {
        Assert.notNull("业务编码不能为空", matchBizBaseDto.getBizCode());
        if ("-".equals(BizCategery.getInfo(matchBizBaseDto.getBizCategory()))) {
            throw new MatchBizIPIsErrorException("业务类别值错误 1:‘信贷’.2:‘理财’");
        }
        Assert.notNull("客户姓名不能为空", matchBizBaseDto.getCustName());
        if (matchBizBaseDto.getBizCategory() == MatchBizConstant.WMS_SYSTEM
                && StringUtils.isBlank(matchBizBaseDto.getCustCode())) {
            throw new MatchBizIPIsErrorException("客户编号不能为空");
        }
        Assert.notNull("客户身份证号不能为空", matchBizBaseDto.getIdCard());
        Assert.notNull("业务总金额不能为空", matchBizBaseDto.getBizTotalAmount());
        if (matchBizBaseDto.getBizCategory() == MatchBizConstant.CCS_SYSTEM
                && !Assert.checkParam(matchBizBaseDto.getBizAmount())) {
            throw new MatchBizIPIsErrorException("业务金额不能为空");
        }
        Assert.notNull("业务产品编号不能为空", matchBizBaseDto.getBizProductId());
        Assert.notNull("业务周期 不能为空", matchBizBaseDto.getBizPeriod());
        Assert.notNull("还款起止日不能为空", matchBizBaseDto.getBizDateBegin(), matchBizBaseDto.getBizDateEnd());
        Assert.notNull("签约日期不能为空", matchBizBaseDto.getSignDate());
        if (Assert.equals(CustCategery.getInfo(matchBizBaseDto.getCustCategory(), false), "-")) {
            throw new MatchBizIPIsErrorException("客户分类值错误:{1:'客户分类',2:'公司员工'}");
        }
        Assert.notNull("营业部编号不能为空", matchBizBaseDto.getOrgId());
        Assert.notNull("操作人不能为空", matchBizBaseDto.getActionUser());
        return matchBizBaseDto;
    }

}
