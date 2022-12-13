package com.dx.cmm.service.rules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.cmm.service.entitys.BaseEntity;

/**
 * 债权匹配管理-匹配规则明细对象
 *
 * @author 朱道灵
 */
@Entity(name = "t_match_rule_detail_id")
public class MatchRuleDetail extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 8894545534884275268L;

    /**
     * 匹配规则明细-编号 主键
     */
    private Long matchRuleDetailId;

    /**
     * 匹配规则明细-名称
     */
    private String matchRuleDetailName;

    /**
     * 类型-标示
     */
    private String mathTypeKey;

    /**
     * 匹配规则明细-标示
     */
    private String matchRuleDetailKey;

    /**
     * 匹配规则明细-存值
     */
    private String matchRuleDetailVal;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_rule_detail_id")
    public Long getMatchRuleDetailId() {
        return matchRuleDetailId;
    }

    public void setMatchRuleDetailId(Long matchRuleDetailId) {
        this.matchRuleDetailId = matchRuleDetailId;
    }

    @Column(name = "math_type_key")
    public String getMathTypeKey() {
        return mathTypeKey;
    }

    public void setMathTypeKey(String mathTypeKey) {
        this.mathTypeKey = mathTypeKey;
    }

    @Column(name = "match_rule_detail_name")
    public String getMatchRuleDetailName() {
        return matchRuleDetailName;
    }

    public void setMatchRuleDetailName(String matchRuleDetailName) {
        this.matchRuleDetailName = matchRuleDetailName;
    }

    @Column(name = "match_rule_detail_key")
    public String getMatchRuleDetailKey() {
        return matchRuleDetailKey;
    }

    public void setMatchRuleDetailKey(String matchRuleDetailKey) {
        this.matchRuleDetailKey = matchRuleDetailKey;
    }

    @Column(name = "match_rule_detail_val")
    public String getMatchRuleDetailVal() {
        return matchRuleDetailVal;
    }

    public void setMatchRuleDetailVal(String matchRuleDetailVal) {
        this.matchRuleDetailVal = matchRuleDetailVal;
    }
}
