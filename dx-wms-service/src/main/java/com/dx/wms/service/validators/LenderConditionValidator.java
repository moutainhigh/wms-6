/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: LenderConditionValidator.java
 * Author:   yangbao
 * Date:     2016年1月6日 上午11:23:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.validators;

import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.entity.LenderCondition;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LenderConditionValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LenderCondition.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LenderCondition lc = (LenderCondition)target;
        if(Assert.equals(lc.getLenderConditionCategory(), 1)&&!Assert.checkParam(lc.getLenderConditionVal())){
            throw error("specialBen's lenderConditionVal must be not null");
        }
        if(Assert.equals(lc.getLenderConditionCategory(), 1)&&!Assert.checkParam(lc.getLenderConditionRemark())){
            throw error("specialBen's lenderConditionRemark must be not null");
        }
        if(Assert.equals(lc.getLenderConditionCategory(), 2)&&!Assert.checkParam(lc.getLenderConditionVal())){
            throw error("specialLimit's lenderConditionVal must be not null");
        }
        if(Assert.equals(lc.getLenderConditionCategory(), 2)&&!Assert.checkParam(lc.getLenderConditionRemark())){
            throw error("specialLimit's lenderConditionRemark must be not null");
        }
        if(!Assert.checkParam(lc.getLenderApplyId())){
            throw error("lenderCondition's lenderApplyId must be not null");
        }
        if(!Assert.checkParam(lc.getCreateUser())){
            throw error("lenderCondition's createUser must be not null");
        }
        if(!Assert.checkParam(lc.getDataStatus())){
            throw error("lenderCondition's dataStatus must be not null");
        }

    }

}
