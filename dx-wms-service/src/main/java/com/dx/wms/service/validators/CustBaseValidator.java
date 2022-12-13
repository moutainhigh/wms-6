/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: CustBaseValidator.java
 * Author:   yangbao
 * Date:     2016年1月6日 上午11:51:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.validators;

import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.base.CustBase;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustBaseValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustBase.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustBase cb = (CustBase) target;
        if (!Assert.checkParam(cb.getCustName())) {
            throw error("custName must be not null");
        }
        if (!Assert.checkParam(cb.getMobile())) {
            throw error("mobile must be not null");
        }
        if (!Assert.checkParam(cb.getCustSource())) {
            throw error("custSource must be not null");
        }
        if (Assert.equals(cb.getCustSource(), 20) && !Assert.checkParam(cb.getCustSourceOther())) {
            throw error("custSourceOther must be not null");
        }
        if (!Assert.checkParam(cb.getCustCode())) {
            throw error("custCode must be not null");
        }
        if (!Assert.checkParam(cb.getCreateUser())) {
            throw error("createUser must be not null");
        }
        if (!Assert.checkParam(cb.getDataStatus())) {
            throw error("dataStatus must be not null");
        }

    }

}
