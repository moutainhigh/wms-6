/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountApplyDto.java
 * Author:   王蕊
 * Date:     2015年7月20日 下午5:34:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.account.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.apply.entity.LenderCondition;
import com.dx.wms.service.changer.ChangeLog;

/**
 * 客户账户申请DTO
 *
 * @author 王蕊
 */
public class CustAccountApplyDto implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 7301980375335576835L;

    /**
     * 客户账户表 实体类
     */
    private CustAccount custAccount;

    /**
     * 客户职业表 实体表
     */
    private CustProfession custProfession;

    /**
     * 客户通讯表 实体表
     */
    private CustComm custComm;

    /**
     * 客户联系人 实体表
     */
    private CustLinkman custLinkman;

    /**
     * 客户金融表 实体表 汇款
     */
    private List<CustFinance> custFinances;

    /**
     * 理财申请特殊情况表
     */
    private List<LenderCondition> lenderConditions;

    /**
     * 操作人ID 
     */
    private Long actionUserId;

    /**
     * 理财申请 
     */
    private LenderApply lenderApply;

    /**
     * 是否有特殊收益
     */
    private Integer isIncome;

    /**
     *  最新状态
     */
    private String currentStepKey;

    /**
     * 日志
     */
    private List<ChangeLog> logs;
    
    /**
     * 支行状态
     */
    private Integer subBankStatus;
    
    public CustAccountApplyDto() {
        super();
        this.custAccount = new CustAccount();
        this.custComm = new CustComm();
        this.custLinkman = new CustLinkman();
        this.custProfession = new CustProfession();
        this.lenderApply = new LenderApply();
        this.lenderConditions = new ArrayList<LenderCondition>();
        this.custFinances = new ArrayList<CustFinance>();
    }

    public CustAccountApplyDto(CustAccount custAccount, CustProfession custProfession, CustComm custComm,
            CustLinkman custLinkman, Long actionUserId, List<CustFinance> custFinances, LenderApply lenderApply,
            Integer isIncome, List<LenderCondition> lenderConditions) {
        super();
        this.setCustAccount(custAccount);
        this.setCustProfession(custProfession);
        this.setCustComm(custComm);
        this.setCustLinkman(custLinkman);
        this.actionUserId = actionUserId;
        this.lenderApply = lenderApply;
        this.isIncome = isIncome;
        this.custFinances = custFinances;
        this.lenderConditions = lenderConditions;
    }

    /** 
     * 操作人ID
     */
    public Long getActionUserId() {
        return actionUserId;
    }

    /** 
     * 操作人ID
     */
    public void setActionUserId(Long actionUserId) {
        this.actionUserId = actionUserId;
    }

    /**
     * 客户账户
     */
    public CustAccount getCustAccount() {
        return custAccount;
    }

    /**
     * 客户账户
     */
    public void setCustAccount(CustAccount custAccount) {
        this.custAccount = custAccount;
    }

    /**
     * 职业
     */
    public CustProfession getCustProfession() {
        return custProfession;
    }

    /**
     * 职业
     */
    public void setCustProfession(CustProfession custProfession) {
        this.custProfession = custProfession;
    }

    /**
     * 客户通讯表
     */
    public CustComm getCustComm() {
        return custComm;
    }

    /**
     * 客户通讯表
     */
    public void setCustComm(CustComm custComm) {
        this.custComm = custComm;
    }

    /**
     * 紧急联系人
     */
    public CustLinkman getCustLinkman() {
        return custLinkman;
    }

    /**
     * 紧急联系人
     */
    public void setCustLinkman(CustLinkman custLinkman) {
        this.custLinkman = custLinkman;
    }

    /**
     * 申请单表
     */
    public LenderApply getLenderApply() {
        return lenderApply;
    }

    /**
     * 申请单表
     */
    public void setLenderApply(LenderApply lenderApply) {
        this.lenderApply = lenderApply;
    }

    /**
     * 是否有特殊收益
     */
    public Integer getIsIncome() {
        return isIncome;
    }

    /**
     *是否有特殊收益
     */
    public void setIsIncome(Integer isIncome) {
        this.isIncome = isIncome;
    }

    /**
     * 当前行为标示
     */
    public String getCurrentStepKey() {
        return currentStepKey;
    }

    /**
     * 当前行为标示
     */
    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    /**
     * 客户金融表
     */
    public List<CustFinance> getCustFinances() {
        return custFinances;
    }

    /**
     * 客户金融表
     */
    public void setCustFinances(List<CustFinance> custFinances) {
        this.custFinances = custFinances;
    }

    /**
     * 理财申请特殊情况表
     */
    public List<LenderCondition> getLenderConditions() {
        return lenderConditions;
    }

    /**
     * 理财申请特殊情况表
     */
    public void setLenderConditions(List<LenderCondition> lenderConditions) {
        this.lenderConditions = lenderConditions;
    }

    /**
     * 日志
     */
    public List<ChangeLog> getLogs() {
        return logs;
    }

    /**
     * 日志
     */
    public void setLogs(List<ChangeLog> logs) {
        this.logs = logs;
    }

    /**
     * 支行状态
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public Integer getSubBankStatus() {
		return subBankStatus;
	}

	public void setSubBankStatus(Integer subBankStatus) {
		this.subBankStatus = subBankStatus;
	}
}
