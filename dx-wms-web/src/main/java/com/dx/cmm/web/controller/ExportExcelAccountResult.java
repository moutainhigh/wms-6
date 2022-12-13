package com.dx.cmm.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.cmm.dto.AccountResultDto;


public class ExportExcelAccountResult {
	/**
     * 客户姓名
     */
    private String custName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 当前账户金额
     */
    private BigDecimal currentAmount;

    /**
     * 投资数
     */
    private Integer investNum;


    /**
     * 账户级别
     */
    private String accountLevelName;

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


	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public Integer getInvestNum() {
		return investNum;
	}

	public void setInvestNum(Integer investNum) {
		this.investNum = investNum;
	}


	public String getAccountLevelName() {
		return accountLevelName;
	}

	public void setAccountLevelName(String accountLevelName) {
		this.accountLevelName = accountLevelName;
	}
    public ExportExcelAccountResult(){
    	
    }
    public ExportExcelAccountResult(AccountResultDto dto){
    	try {
    		PropertyUtils.copyProperties(this, dto);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
    }
    
}
