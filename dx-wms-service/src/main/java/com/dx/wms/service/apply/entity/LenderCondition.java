package com.dx.wms.service.apply.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dx.wms.common.BaseEntity;

/**
 * 出借特殊情况表
 *
 * @author 朱道灵
 */
@Entity(name = "t_lender_condition")
public class LenderCondition extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -5493897591318603739L;

    /**
     * 特殊情况-编号 主键
     */
    private Long lenderConditionId;

    /**
     * 出借申请-编号
     */
    private Long lenderApplyId;

    /**
     * 特殊情况-值
     */
    private String lenderConditionVal;

    /**
     * 特殊情况-备注
     */
    private String lenderConditionRemark;

    /**
     * 特殊情况-类型 1:"收益",2:"超额"
     */
    private Integer lenderConditionCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "lender_condition_id")
    public Long getLenderConditionId() {
        return lenderConditionId;
    }

    public void setLenderConditionId(Long lenderConditionId) {
        this.lenderConditionId = lenderConditionId;
    }

    @Column(name = "lender_apply_id")
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    @Column(name = "lender_condition_val")
    public String getLenderConditionVal() {
        return lenderConditionVal;
    }

    public void setLenderConditionVal(String lenderConditionVal) {
        this.lenderConditionVal = lenderConditionVal;
    }

    @Column(name = "lender_condition_remark")
    public String getLenderConditionRemark() {
        return lenderConditionRemark;
    }

    public void setLenderConditionRemark(String lenderConditionRemark) {
        this.lenderConditionRemark = lenderConditionRemark;
    }

    @Column(name = "lender_condition_category")
    public Integer getLenderConditionCategory() {
        return lenderConditionCategory;
    }

    public void setLenderConditionCategory(Integer lenderConditionCategory) {
        this.lenderConditionCategory = lenderConditionCategory;
    }

}
