/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: BillViewDto.java
 * Author:   蔡登勇
 * Date:     2015年8月1日 下午1:47:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dx.wms.vo.CreditorDetailVo;
import com.dx.wms.vo.LenderDetailVo;

/**
 * 账单视图Dto
 *
 * @author 蔡登勇
 */
public class BillViewDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 414424042585080741L;

    /** 视图Code */
    private String billViewCode;

    /** 视图名称 */
    private String billViewName;

    /** 客户编号 */
    private String lenderCustCode;

    /** 出借单编号 */
    private String lenderCode;

    /** 转让编号 */
    private String assignmentCode;

    /** 出借人地址 */
    private String lenderCustAddress;

    /** 出借人邮编 */
    private String lenderCustZip;

    /** 出借人姓名 */
    private String lenderCustName;

    /** 出借人身份证 */
    private String lenderCustIdCard;

    /** 确认日期 */
    private String applyDate;

    /** 出借金额 */
    private BigDecimal lenderAmount;

    private String lenderAmountView;

    /** 出借金额大写 */
    private String lenderAmountCn;

    /** 债权编号 */
    private String creditCode;

    /** 报告周期 */
    private String reportCycle;

    /** 报告日 */
    private Integer reportDay;

    /** 账户级别 */
    private Integer accountLevel;

    /** 代偿倍数 */
    private BigDecimal compensarAmount;

    /** 未代偿倍数 */
    private BigDecimal uncompensarAmount;

    /** 打印日期 */
    private String printDate;
    /** 户名 */
    private String accountName;

    /** 开户银行 */
    private String bankCategory;

    /** 支行 */
    private String subBank;

    /** 账号 */
    private String accountNum;

    /** 出借明细Dto集合 */
    private List<LenderDetailVo> lenderDetailVos;

    /** 债权明细Dto集合 */
    private List<CreditorDetailVo> creditorDetailVos;

    /** 合计转让债权价值 */
    private String totalCreditorAmount;

    /** 合计需支付对价 */
    private String totalPayConsideration;

    /**
     * 匹配日期
     */
    private Date matchDate;

    public String getTotalCreditorAmount() {
        return totalCreditorAmount;
    }

    public void setTotalCreditorAmount(String totalCreditorAmount) {
        this.totalCreditorAmount = totalCreditorAmount;
    }

    public String getTotalPayConsideration() {
        return totalPayConsideration;
    }

    public void setTotalPayConsideration(String totalPayConsideration) {
        this.totalPayConsideration = totalPayConsideration;
    }

    public String getAccountName() {
        return accountName;
    }

    public List<LenderDetailVo> getLenderDetailVos() {
        return lenderDetailVos;
    }

    public void setLenderDetailVos(List<LenderDetailVo> lenderDetailVos) {
        this.lenderDetailVos = lenderDetailVos;
    }

    public List<CreditorDetailVo> getCreditorDetailVos() {
        return creditorDetailVos;
    }

    public void setCreditorDetailVos(List<CreditorDetailVo> creditorDetailVos) {
        this.creditorDetailVos = creditorDetailVos;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankCategory() {
        return bankCategory;
    }

    public void setBankCategory(String bankCategory) {
        this.bankCategory = bankCategory;
    }

    public String getSubBank() {
        return subBank;
    }

    public void setSubBank(String subBank) {
        this.subBank = subBank;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode;
    }

    public BigDecimal getCompensarAmount() {
        return compensarAmount;
    }

    public void setCompensarAmount(BigDecimal compensarAmount) {
        this.compensarAmount = compensarAmount;
    }

    public BigDecimal getUncompensarAmount() {
        return uncompensarAmount;
    }

    public void setUncompensarAmount(BigDecimal uncompensarAmount) {
        this.uncompensarAmount = uncompensarAmount;
    }

    public String getPrintDate() {
        return printDate;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getBillViewCode() {
        return billViewCode;
    }

    public void setBillViewCode(String billViewCode) {
        this.billViewCode = billViewCode;
    }

    public String getBillViewName() {
        return billViewName;
    }

    public void setBillViewName(String billViewName) {
        this.billViewName = billViewName;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getLenderCustAddress() {
        return lenderCustAddress;
    }

    public void setLenderCustAddress(String lenderCustAddress) {
        this.lenderCustAddress = lenderCustAddress;
    }

    public String getLenderCustZip() {
        return lenderCustZip;
    }

    public void setLenderCustZip(String lenderCustZip) {
        this.lenderCustZip = lenderCustZip;
    }

    public String getLenderCustName() {
        return lenderCustName;
    }

    public void setLenderCustName(String lenderCustName) {
        this.lenderCustName = lenderCustName;
    }

    public String getLenderCustIdCard() {
        return lenderCustIdCard;
    }

    public void setLenderCustIdCard(String lenderCustIdCard) {
        this.lenderCustIdCard = lenderCustIdCard;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public String getLenderAmountCn() {
        return lenderAmountCn;
    }

    public void setLenderAmountCn(String lenderAmountCn) {
        this.lenderAmountCn = lenderAmountCn;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getReportCycle() {
        return reportCycle;
    }

    public void setReportCycle(String reportCycle) {
        this.reportCycle = reportCycle;
    }

    public Integer getReportDay() {
        return reportDay;
    }

    public void setReportDay(Integer reportDay) {
        this.reportDay = reportDay;
    }

    public Integer getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getLenderAmountView() {
        return lenderAmountView;
    }

    public void setLenderAmountView(String lenderAmountView) {
        this.lenderAmountView = lenderAmountView;
    }

}
