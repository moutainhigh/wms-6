package com.dx.wms.web.detail.vo;

import java.io.Serializable;
import java.text.MessageFormat;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.ConditionCategory;
import com.dx.wms.service.apply.entity.LenderCondition;

/**
 * 
 * 特殊情况
 * 
 * @author tony
 */
public class LenderConditionVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -8763120151075915175L;
    
    /**
     * 特殊情况-编号
     */
    private Long conditionId;

    /**
     * 特殊情况-值
     */
    private String condition;

    /**
     * 特殊情况-备注
     */
    private String remark;

    /**
     * 特殊情况-类型 1:"收益",2:"超额"
     */
    private String category;

    public LenderConditionVo() {

    }

    public LenderConditionVo(LenderCondition base) {
    	setConditionId(base.getLenderConditionId());
        Integer category = base.getLenderConditionCategory();
        setCategory(MessageFormat.format("{0}信息", ConditionCategory.getInfo(category, true)));
        setRemark(Assert.checkParam(base.getLenderConditionRemark()) ? base.getLenderConditionRemark()
                : WMSConstants.NULL);
        String condition = Assert.checkParam(base.getLenderConditionVal()) ? MessageFormat.format("{0} {1}",
                base.getLenderConditionVal(), ConditionCategory.getUnit(category, true)) : WMSConstants.NULL;
        setCondition(condition);
    }
    
    

    public Long getConditionId() {
		return conditionId;
	}

	public void setConditionId(Long conditionId) {
		this.conditionId = conditionId;
	}

	public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
