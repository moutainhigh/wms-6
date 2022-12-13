package com.dx.cmm.service.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 债券匹配管理-匹配业务基础账户
 * 
 * @author tony
 */
@Entity(name = "t_match_biz_base_account")
public class MatchBizBaseAccount extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 58338762045069051L;

    /**
     * 匹配业务基础账户-编号 主键
     */
    private Long matchBizBaseAccountId;

    /**
     * 匹配业务基础-编号
     */
    private Long matchBizBaseId;

    /**
     * 匹配业务基础账户-户名
     */
    private String baseAccountName;

    /**
     * 匹配业务基础账户-开户行
     */
    private String baseAccountBank;

    /**
     * 匹配业务基础账户-开户行支行
     */
    private String baseAccountBankSub;

    /**
     * 匹配业务基础账户-账号
     */
    private String baseAccount;

    /**
     * 账号类别:{1:"汇款",2:"回款",3:"支付",4:"其他"}
     */
    private Integer baseAccountCategory;

    public MatchBizBaseAccount() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_biz_base_account_id")
    public Long getMatchBizBaseAccountId() {
        return matchBizBaseAccountId;
    }

    public void setMatchBizBaseAccountId(Long matchBizBaseAccountId) {
        this.matchBizBaseAccountId = matchBizBaseAccountId;
    }

    @Column(name = "match_biz_base_id")
    public Long getMatchBizBaseId() {
        return matchBizBaseId;
    }

    public void setMatchBizBaseId(Long matchBizBaseId) {
        this.matchBizBaseId = matchBizBaseId;
    }

    @Column(name = "base_account_name")
    public String getBaseAccountName() {
        return baseAccountName;
    }

    public void setBaseAccountName(String baseAccountName) {
        this.baseAccountName = baseAccountName;
    }

    @Column(name = "base_account_bank")
    public String getBaseAccountBank() {
        return baseAccountBank;
    }

    public void setBaseAccountBank(String baseAccountBank) {
        this.baseAccountBank = baseAccountBank;
    }

    @Column(name = "base_account_bank_sub")
    public String getBaseAccountBankSub() {
        return baseAccountBankSub;
    }

    public void setBaseAccountBankSub(String baseAccountBankSub) {
        this.baseAccountBankSub = baseAccountBankSub;
    }

    @Column(name = "base_account")
    public String getBaseAccount() {
        return baseAccount;
    }

    public void setBaseAccount(String baseAccount) {
        this.baseAccount = baseAccount;
    }

    @Column(name = "base_account_category")
    public Integer getBaseAccountCategory() {
        return baseAccountCategory;
    }

    public void setBaseAccountCategory(Integer baseAccountCategory) {
        this.baseAccountCategory = baseAccountCategory;
    }
}
