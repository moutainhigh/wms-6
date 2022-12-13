package com.dx.cmm.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dx.common.service.utils.Assert;

/**
 * 
 * 报告结果
 *
 * @author tony
 */
public class ResultReport implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5049882579778849101L;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 地址
     */
    private String address;

    /**
     * 省市区
     */
    private String addressPre;

    /**
     * 地址
     */
    private String addressSuf;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 客户编号
     */
    private String custCode;

    /**
     * 账户级别
     */
    private Long accountLevelId;

    /**
     * 账户级别
     */
    private String accountLevelName;

    /**
     * 收账编号
     */
    private Long matchBizBaseId;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 匹配日期
     */
    private Date matchDate;

    /**
     * 投资视图详情集合
     */
    private List<ViewInvestDetailDto> detailDtos;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressPre() {
        return addressPre;
    }

    public void setAddressPre(String addressPre) {
        this.addressPre = addressPre;
    }

    public String getAddressSuf() {
        return addressSuf;
    }

    public void setAddressSuf(String addressSuf) {
        this.addressSuf = addressSuf;
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

    public Long getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(Long accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    public String getAccountLevelName() {
        return accountLevelName;
    }

    public void setAccountLevelName(String accountLevelName) {
        this.accountLevelName = accountLevelName;
    }

    public List<ViewInvestDetailDto> getDetailDtos() {
        return detailDtos;
    }

    public void setDetailDtos(List<ViewInvestDetailDto> detailDtos) {
        this.detailDtos = detailDtos;
    }

    public Long getMatchBizBaseId() {
        return matchBizBaseId;
    }

    public void setMatchBizBaseId(Long matchBizBaseId) {
        this.matchBizBaseId = matchBizBaseId;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public void put(String bizCode) {
        if (Assert.checkParam(bizCode) && bizCode.contains("-")) {
            setCustCode(bizCode.substring(0, bizCode.indexOf("-")));
        }
    }
}
