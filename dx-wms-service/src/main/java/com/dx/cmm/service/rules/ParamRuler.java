package com.dx.cmm.service.rules;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.dx.cmm.enums.Rule;
import com.dx.cmm.enums.RuleCategory;
import com.dx.cmm.service.tasks.AccountParamTask;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 规则参数Dto<br>
 * 规则参数Dto
 *
 * @author tony
 */
public class ParamRuler implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4450520327238513801L;

    /**
     * 
     */
    private String appCode;

    /**
     * 规则id
     */
    private Long ruleId;

    /**
     * 规则标示
     */
    private String ruleKey;

    /**
     * 规则类别
     */
    private Long ruleCategory;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

    /**
     * 参数对象
     */
    private Object paramVal;

    /**
     * 匹配规则
     */
    private Rule rule;

    /**
     * 规则分组编号
     */
    private Long groupId;

    public ParamRuler() {

    }

    public ParamRuler(AccountParamTask account) {
        setParamVal(account.getAccountAmount());
        setRule(Rule.LENDER_ACCOUNT_RULE);
        setRuleKey(getRule().getCode());
    }

    public ParamRuler(BigDecimal initTotalAmount, Rule rule) {
        setParamVal(initTotalAmount);
        setRuleKey(rule.getCode());
        setRule(rule);
    }

    public ParamRuler(Rule rule) {
        Assert.notEquals(new IllegalArgumentException("Rule must in back or bill"), Rule.BACK_MATCH_RULE,
                Rule.BILL_PORT_RULE);
        setParamVal(new Date());
        setRule(rule);
        setRuleKey(getRule().getCode());
    }

    public ParamRuler(Date val, Rule rule) {
        Assert.notEquals(new IllegalArgumentException("Rule must in back or bill"), Rule.BACK_MATCH_RULE,
                Rule.BILL_PORT_RULE);
        setParamVal(val);
        setRule(rule);
        setRuleKey(rule.getCode());
    }

    public ParamRuler(Object paramVal, String ruleKey, String appCode) {
        this.paramVal = paramVal;
        this.ruleKey = ruleKey;
        this.appCode = appCode;
    }

    public Object getParamVal() {
        return paramVal;
    }

    public void setParamVal(Object paramVal) {
        this.paramVal = paramVal;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public Long getRuleCategory() {
        return ruleCategory;
    }

    public void setRuleCategory(Long ruleCategory) {
        this.ruleCategory = ruleCategory;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setInput() {
        setRuleCategory(RuleCategory.INPUT.getCode());
    }

    public void setOutput() {
        setRuleCategory(RuleCategory.OUTPUT.getCode());
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

}
