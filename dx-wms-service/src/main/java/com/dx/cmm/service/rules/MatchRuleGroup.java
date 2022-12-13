package com.dx.cmm.service.rules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 债权匹配管理-匹配规则分组对象
 *
 *
 * @author 朱道灵
 */
@Entity(name = "t_match_rule_group")
public class MatchRuleGroup extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 2889292147204464477L;

    /**
     * 匹配规则分组-编号 主键
     */
    private Long matchRuleGroupId;

    /**
     * 匹配规则分组-名称
     */
    private String matchRuleGroupName;

    /**
     * 匹配规则类别-编号
     */
    private Long matchRuleCategoryId;

    /**
     * 匹配规则分组-对应编号
     */
    private Long matchRuleGroupMappingId;

    /**
     * 匹配规则-编号
     */
    private Long matchRuleId;

    /**
     * 匹配规则-标示
     */
    private String matchRuleKey;

    /**
     * 匹配规则分组-顺位
     */
    private Integer groupIndex;

    /**
     * 表达式
     */
    private String exp;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_rule_group_id")
    public Long getMatchRuleGroupId() {
        return matchRuleGroupId;
    }

    public void setMatchRuleGroupId(Long matchRuleGroupId) {
        this.matchRuleGroupId = matchRuleGroupId;
    }

    @Column(name = "match_rule_group_name")
    public String getMatchRuleGroupName() {
        return matchRuleGroupName;
    }

    public void setMatchRuleGroupName(String matchRuleGroupName) {
        this.matchRuleGroupName = matchRuleGroupName;
    }

    @Column(name = "match_rule_category_id")
    public Long getMatchRuleCategoryId() {
        return matchRuleCategoryId;
    }

    public void setMatchRuleCategoryId(Long matchRuleCategoryId) {
        this.matchRuleCategoryId = matchRuleCategoryId;
    }

    @Column(name = "match_rule_group__mapping_id")
    public Long getMatchRuleGroupMappingId() {
        return matchRuleGroupMappingId;
    }

    public void setMatchRuleGroupMappingId(Long matchRuleGroupMappingId) {
        this.matchRuleGroupMappingId = matchRuleGroupMappingId;
    }

    @Column(name = "match_rule_id")
    public Long getMatchRuleId() {
        return matchRuleId;
    }

    public void setMatchRuleId(Long matchRuleId) {
        this.matchRuleId = matchRuleId;
    }

    @Column(name = "match_rule_key")
    public String getMatchRuleKey() {
        return matchRuleKey;
    }

    public void setMatchRuleKey(String matchRuleKey) {
        this.matchRuleKey = matchRuleKey;
    }

    @Column(name = "group_index")
    public Integer getGroupIndex() {
        return groupIndex;
    }

    public void setGroupIndex(Integer groupIndex) {
        this.groupIndex = groupIndex;
    }

    @Column(name = "exp")
    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

}
