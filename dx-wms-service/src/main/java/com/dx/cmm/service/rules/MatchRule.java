/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchRule.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午8:42:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.rules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 债权匹配管理--匹配规则
 *
 * @author 朱道灵
 */
@Entity(name = "t_match_rule")
public class MatchRule extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -7385118747777104561L;

    /**
     * 匹配规则-编号
     */
    private Long matchRuleId;

    /**
     * 匹配规则-名称
     */
    private String matchRuleName;

    /**
     * 匹配规则-描述
     */
    private String matchRuleKey;

    /**
     * 匹配规则-标示
     */
    private String matchRuleDesc;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_rule_id")
    public Long getMatchRuleId() {
        return matchRuleId;
    }

    public void setMatchRuleId(Long matchRuleId) {
        this.matchRuleId = matchRuleId;
    }

    @Column(name = "match_rule_name")
    public String getMatchRuleName() {
        return matchRuleName;
    }

    public void setMatchRuleName(String matchRuleName) {
        this.matchRuleName = matchRuleName;
    }

    @Column(name = "match_rule_key")
    public String getMatchRuleKey() {
        return matchRuleKey;
    }

    public void setMatchRuleKey(String matchRuleKey) {
        this.matchRuleKey = matchRuleKey;
    }

    @Column(name = "match_rule_desc")
    public String getMatchRuleDesc() {
        return matchRuleDesc;
    }

    public void setMatchRuleDesc(String matchRuleDesc) {
        this.matchRuleDesc = matchRuleDesc;
    }
}
