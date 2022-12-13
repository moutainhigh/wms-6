/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchRuleCategory.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午8:52:27
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
 * 债权匹配管理-匹配规则类别对象
 *
 * @author 朱道灵
 */
@Entity(name = "t_match_rule_category")
public class MatchRuleCategory extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -5476733610027111470L;

    /**
     * 匹配规则类别-编号 主键
     */
    private Long matchRuleCategoryId;

    /**
     * 匹配规则类别-名称
     */
    private String matchRuleCategoryName;

    /**
     * 匹配规则类别-标示
     */
    private String matchRuleCategoryKey;

    /**
     * 匹配规则类别-描述
     */
    private String matchRuleCategoryDesc;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_rule_category_id")
    public Long getMatchRuleCategoryId() {
        return matchRuleCategoryId;
    }

    public void setMatchRuleCategoryId(Long matchRuleCategoryId) {
        this.matchRuleCategoryId = matchRuleCategoryId;
    }

    @Column(name = "match_rule_category_name")
    public String getMatchRuleCategoryName() {
        return matchRuleCategoryName;
    }

    public void setMatchRuleCategoryName(String matchRuleCategoryName) {
        this.matchRuleCategoryName = matchRuleCategoryName;
    }

    @Column(name = "match_rule_category_key")
    public String getMatchRuleCategoryKey() {
        return matchRuleCategoryKey;
    }

    public void setMatchRuleCategoryKey(String matchRuleCategoryKey) {
        this.matchRuleCategoryKey = matchRuleCategoryKey;
    }

    @Column(name = "match_rule_category_desc")
    public String getMatchRuleCategoryDesc() {
        return matchRuleCategoryDesc;
    }

    public void setMatchRuleCategoryDesc(String matchRuleCategoryDesc) {
        this.matchRuleCategoryDesc = matchRuleCategoryDesc;
    }
}
