/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchRuleGroupDetail.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午9:31:12
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
 * 债权匹配管理-匹配规则分组明细对象
 *
 * @author 朱道灵
 */
@Entity(name = "t_match_rule_group_detail")
public class MatchRuleGroupDetail extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = 8932252060845536627L;

    /**
     * 匹配规则分组明细-编号
     */
    private Long matchRuleGroupDetailId;

    /**
     * 匹配规则分组-编号
     */
    private Long matchRuleGroupId;

    /**
     * 匹配规则明细-编号
     */
    private Long matchRuleDetailId;

    /**
     * 符号-标示
     */
    private String mathSignKey;

    /**
     * 返回标示
     */
    private String returnKey;

    /**
     * 依赖标示
     */
    private String dependKey;

    /**
     * 引用结果顺位
     */
    private Integer resultIndex;

    /**
     * 匹配规则分组明细-顺位
     */
    private Integer detailIndex;

    /**
     * 是否输出值
     */
    private Integer isOutput;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "match_rule_group_detail_id")
    public Long getMatchRuleGroupDetailId() {
        return matchRuleGroupDetailId;
    }

    public void setMatchRuleGroupDetailId(Long matchRuleGroupDetailId) {
        this.matchRuleGroupDetailId = matchRuleGroupDetailId;
    }

    @Column(name = "match_rule_group_id")
    public Long getMatchRuleGroupId() {
        return matchRuleGroupId;
    }

    public void setMatchRuleGroupId(Long matchRuleGroupId) {
        this.matchRuleGroupId = matchRuleGroupId;
    }

    @Column(name = "match_rule_detail_id")
    public Long getMatchRuleDetailId() {
        return matchRuleDetailId;
    }

    public void setMatchRuleDetailId(Long matchRuleDetailId) {
        this.matchRuleDetailId = matchRuleDetailId;
    }

    @Column(name = "math_sign_key")
    public String getMathSignKey() {
        return mathSignKey;
    }

    public void setMathSignKey(String mathSignKey) {
        this.mathSignKey = mathSignKey;
    }

    @Column(name = "return_key")
    public String getReturnKey() {
        return returnKey;
    }

    public void setReturnKey(String returnKey) {
        this.returnKey = returnKey;
    }

    @Column(name = "depend_key")
    public String getDependKey() {
        return dependKey;
    }

    public void setDependKey(String dependKey) {
        this.dependKey = dependKey;
    }

    @Column(name = "result_index")
    public Integer getResultIndex() {
        return resultIndex;
    }

    public void setResultIndex(Integer resultIndex) {
        this.resultIndex = resultIndex;
    }

    @Column(name = "detail_index")
    public Integer getDetailIndex() {
        return detailIndex;
    }

    public void setDetailIndex(Integer detailIndex) {
        this.detailIndex = detailIndex;
    }

    @Column(name = "is_output")
    public Integer getIsOutput() {
        return isOutput;
    }

    public void setIsOutput(Integer isOutput) {
        this.isOutput = isOutput;
    }
}
