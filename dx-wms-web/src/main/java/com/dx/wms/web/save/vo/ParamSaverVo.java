package com.dx.wms.web.save.vo;

import java.io.Serializable;
import java.util.List;

import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.apply.entity.LenderCondition;
import com.dx.wms.service.saver.SaverAction;
import com.dx.wms.service.saver.SaverType;

public class ParamSaverVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2838840115496857719L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 业务类型
     */
    private SaverType type;

    /**
     * 业务行为
     */
    private SaverAction action;

    /**
     * 账户信息
     */
    private CustAccount account;

    /**
     * 联系信息
     */
    private CustComm comm;

    /**
     * 联系人信息
     */
    private CustLinkman linkman;

    /**
     * 职业信息
     */
    private CustProfession profession;

    /**
     * 申请信息
     */
    private LenderApply apply;

    /**
     * 特殊情况
     */
    private List<LenderCondition> conditions;

    /**
     * 金融信息
     */
    private List<CustFinance> finances;

    private Integer indexId;
    
    public ParamSaverVo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SaverType getType() {
        return type;
    }

    public void setType(SaverType type) {
        this.type = type;
    }

    public SaverAction getAction() {
        return action;
    }

    public void setAction(SaverAction action) {
        this.action = action;
    }

    public CustAccount getAccount() {
        return account;
    }

    public void setAccount(CustAccount account) {
        this.account = account;
    }

    public CustComm getComm() {
        return comm;
    }

    public void setComm(CustComm comm) {
        this.comm = comm;
    }

    public CustLinkman getLinkman() {
        return linkman;
    }

    public void setLinkman(CustLinkman linkman) {
        this.linkman = linkman;
    }

    public CustProfession getProfession() {
        return profession;
    }

    public void setProfession(CustProfession profession) {
        this.profession = profession;
    }

    public LenderApply getApply() {
        return apply;
    }

    public void setApply(LenderApply apply) {
        this.apply = apply;
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

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    
}
