package com.dx.wms.common;

import java.io.Serializable;
import java.util.List;

import com.dx.hr.service.dto.EmployeeEntryDto;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.apply.entity.LenderCondition;

/**
 * 
 * 基础实体Dto
 *
 * @author tony
 */
public class BaseEntitys implements Serializable {

    /**
     */
    private static final long serialVersionUID = 8686931794235815974L;

    /**
     * 账户信息
     */
    protected CustAccount account;

    /**
     * 联系信息
     */
    protected CustComm comm;

    /**
     * 联系人信息
     */
    protected CustLinkman linkman;

    /**
     * 职业信息
     */
    protected CustProfession profession;

    /**
     * 申请信息
     */
    protected LenderApply apply;

    /**
     * 特殊情况
     */
    protected List<LenderCondition> conditions;

    /**
     * 金融信息
     */
    protected List<CustFinance> finances;

    /**
     * 员工信息
     */
    protected EmployeeEntryDto employeeEntryDto;

    /**
     * 原申请单ID
     */
    protected Long initApplyId;
    
    public CustAccount getAccount() {
        return account;
    }

    public BaseEntitys setAccount(CustAccount account) {
        this.account = account;
        return this;
    }

    public CustComm getComm() {
        return comm;
    }

    public BaseEntitys setComm(CustComm comm) {
        this.comm = comm;
        return this;
    }

    public BaseEntitys setComm() {
        return setComm(new CustComm());
    }

    public CustLinkman getLinkman() {
        return linkman;
    }

    public BaseEntitys setLinkman(CustLinkman linkman) {
        this.linkman = linkman;
        return this;
    }

    public BaseEntitys setLinkman() {
        return setLinkman(new CustLinkman());
    }

    public CustProfession getProfession() {
        return profession;
    }

    public BaseEntitys setProfession(CustProfession profession) {
        this.profession = profession;
        return this;
    }

    public BaseEntitys setProfession() {
        return setProfession(new CustProfession());
    }

    public LenderApply getApply() {
        return apply;
    }

    public BaseEntitys setApply(LenderApply apply) {
        this.apply = apply;
        return this;
    }

    public BaseEntitys setApply(Long accountId, String custCode) {
        return setApply(new LenderApply(accountId, custCode));
    }

    public List<LenderCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<LenderCondition> conditions) {
        this.conditions = conditions;
    }

    public List<CustFinance> getFinances() {
        return finances;
    }

    public void setFinances(List<CustFinance> finances) {
        this.finances = finances;
    }

    public EmployeeEntryDto getEmployeeEntryDto() {
        return employeeEntryDto;
    }

    public void setEmployeeEntryDto(EmployeeEntryDto employeeEntryDto) {
        this.employeeEntryDto = employeeEntryDto;
    }

    public Long getInitApplyId() {
        return initApplyId;
    }

    public void setInitApplyId(Long initApplyId) {
        this.initApplyId = initApplyId;
    }

    
}
