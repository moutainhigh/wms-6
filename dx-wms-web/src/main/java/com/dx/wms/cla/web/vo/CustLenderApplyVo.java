/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustApplyVo.java
 * Author:   朱道灵
 * Date:     2015年7月31日 下午1:59:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.cla.web.vo;

import java.io.Serializable;

import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 开户申请管理 VO 接口
 *
 * @author 朱道灵
 */
public class CustLenderApplyVo implements Serializable{

    /**
     * 序列号
     */
    private static final long serialVersionUID = -341837154051595916L;
    
    /**
     * 客户账户表 实体类
     */
    private CustAccount custAccount;
    
    /**
     * 客户出借表 实体类
     */
    private LenderApply lenderApply;
    
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
    private CustFinance remitCustFinance;
    
    /** 汇款*/
    private CustFinance refundCustFinance;
    
    private Long  actionUserId;
    
    public CustLenderApplyVo(CustAccount custAccount,CustProfession custProfession
            ,CustComm custComm,CustLinkman custLinkman,CustFinance remitCustFinance,CustFinance refundCustFinance
            ,LenderApply lenderApply,Long  actionUserId){
        super();
        this.setCustAccount(custAccount);
        this.setCustProfession(custProfession);
        this.setLenderApply(lenderApply);
        this.setCustComm(custComm);
        this.setCustLinkman(custLinkman);
        this.setRemitCustFinance(remitCustFinance);
        this.setRefundCustFinance(refundCustFinance);
        this.setActionUserId(actionUserId);
    }

    /**
     * @return the custAccount
     */
    public CustAccount getCustAccount() {
        return custAccount;
    }

    /**
     * @param custAccount the custAccount to set
     */
    public void setCustAccount(CustAccount custAccount) {
        this.custAccount = custAccount;
    }

    /**
     * @return the custProfession
     */
    public CustProfession getCustProfession() {
        return custProfession;
    }

    /**
     * @param custProfession the custProfession to set
     */
    public void setCustProfession(CustProfession custProfession) {
        this.custProfession = custProfession;
    }

    /**
     * @return the custComm
     */
    public CustComm getCustComm() {
        return custComm;
    }

    /**
     * @param custComm the custComm to set
     */
    public void setCustComm(CustComm custComm) {
        this.custComm = custComm;
    }

    /**
     * @return the custLinkman
     */
    public CustLinkman getCustLinkman() {
        return custLinkman;
    }

    /**
     * @param custLinkman the custLinkman to set
     */
    public void setCustLinkman(CustLinkman custLinkman) {
        this.custLinkman = custLinkman;
    }

    /**
     * @return the remitCustFinance
     */
    public CustFinance getRemitCustFinance() {
        return remitCustFinance;
    }

    /**
     * @param remitCustFinance the remitCustFinance to set
     */
    public void setRemitCustFinance(CustFinance remitCustFinance) {
        this.remitCustFinance = remitCustFinance;
    }

    /**
     * @return the refundCustFinance
     */
    public CustFinance getRefundCustFinance() {
        return refundCustFinance;
    }

    /**
     * @param refundCustFinance the refundCustFinance to set
     */
    public void setRefundCustFinance(CustFinance refundCustFinance) {
        this.refundCustFinance = refundCustFinance;
    }

    
    /**
     * @return the actionUserId
     */
    public Long getActionUserId() {
        return actionUserId;
    }

    /**
     * @param actionUserId the actionUserId to set
     */
    public void setActionUserId(Long actionUserId) {
        this.actionUserId = actionUserId;
    }

    /**
     * @return the lenderApply
     */
    public LenderApply getLenderApply() {
        return lenderApply;
    }

    /**
     * @param lenderApply the lenderApply to set
     */
    public void setLenderApply(LenderApply lenderApply) {
        this.lenderApply = lenderApply;
    }

}
