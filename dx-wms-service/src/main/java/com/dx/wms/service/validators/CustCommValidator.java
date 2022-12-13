/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: CustCommValidator.java
 * Author:   yangbao
 * Date:     2016年1月5日 下午6:15:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.validators;

import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.account.entity.CustComm;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustCommValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustComm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustComm cc = (CustComm)target;
        if(!Assert.checkParam(cc.getProvinceRegionCode())){
            throw error("provinceRegionCode must be not null");
        }
        if(!Assert.checkParam(cc.getCityRegionCode())){
            throw error("cityRegionCode must be not null");
        }
        if(!Assert.checkParam(cc.getDistrictRegionCode())){
            throw error("districtRegionCode must be not null");
        }
        if(!Assert.checkParam(cc.getStreetInfo())){
            throw error("streetInfo must be not null");
        }
        if(!Assert.checkParam(cc.getZipCode())){
            throw error("zipCode must be not null");
        }
        if(!Assert.checkParam(cc.getEmail())){
            throw error("email must be not null");
        }
        if(!Assert.checkParam(cc.getCustAccountId())){
            throw error("custComm custAccountId must be not null");
        }
        if(!Assert.checkParam(cc.getCreateUser())){
            throw error("custComm createUser must be not null");
        }
        if(!Assert.checkParam(cc.getDataStatus())){
            throw error("custComm dataStatus must be not null");
        }

    }

}
