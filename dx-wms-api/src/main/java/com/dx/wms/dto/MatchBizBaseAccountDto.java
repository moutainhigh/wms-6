/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchBizBaseAccount.java
 * Author:   朱道灵
 * Date:     2015年7月27日 下午3:04:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dto;

import java.io.Serializable;

/**
 * 债券匹配管理-匹配业务基础账户实体
 * 
 * @author 朱道灵
 */

public class MatchBizBaseAccountDto implements Serializable {

    /**
     * serial UID
     */
    private static final long serialVersionUID = 1L;

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
     * 回款是公司打钱到客户账户
     * 支付是客户打钱给公司
     */
    private Integer baseAccountCategory;

    /**
     * 数据状态:{"A":"已生效","D":"已删除"}
     */
    private String dataStatus;

    public Long getMatchBizBaseAccountId() {
        return matchBizBaseAccountId;
    }

    public void setMatchBizBaseAccountId(Long matchBizBaseAccountId) {
        this.matchBizBaseAccountId = matchBizBaseAccountId;
    }

    public Long getMatchBizBaseId() {
        return matchBizBaseId;
    }

    public void setMatchBizBaseId(Long matchBizBaseId) {
        this.matchBizBaseId = matchBizBaseId;
    }

    public String getBaseAccountName() {
        return baseAccountName;
    }

    public void setBaseAccountName(String baseAccountName) {
        this.baseAccountName = baseAccountName;
    }

    public String getBaseAccountBank() {
        return baseAccountBank;
    }

    public void setBaseAccountBank(String baseAccountBank) {
        this.baseAccountBank = baseAccountBank;
    }

    public String getBaseAccountBankSub() {
        return baseAccountBankSub;
    }

    public void setBaseAccountBankSub(String baseAccountBankSub) {
        this.baseAccountBankSub = baseAccountBankSub;
    }

    public String getBaseAccount() {
        return baseAccount;
    }

    public void setBaseAccount(String baseAccount) {
        this.baseAccount = baseAccount;
    }

    public Integer getBaseAccountCategory() {
        return baseAccountCategory;
    }

    public void setBaseAccountCategory(Integer baseAccountCategory) {
        this.baseAccountCategory = baseAccountCategory;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    
}
