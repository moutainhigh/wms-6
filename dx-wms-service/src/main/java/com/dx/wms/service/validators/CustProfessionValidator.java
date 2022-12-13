/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: CustProfessionValidator.java
 * Author:   yangbao
 * Date:     2016年1月5日 下午6:10:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.validators;

import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.account.entity.CustProfession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustProfessionValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustProfession.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustProfession cp = (CustProfession)target;
        if(!Assert.checkParam(cp.getCompanyName())){
            throw error("companyName must be not null");
        }
        if(!Assert.checkParam(cp.getCreateUser())){
            throw error("custProfession createUser must be not null");
        }
        if(!Assert.checkParam(cp.getCustAccountId())){
            throw error("custProfession custAccountId must be not null");
        }
        if(!Assert.checkParam(cp.getDataStatus())){
            throw error("custProfession dataStatus must be not null");
        }

    }

}
