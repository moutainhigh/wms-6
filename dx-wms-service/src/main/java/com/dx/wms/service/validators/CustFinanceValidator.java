/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: CustFinanceValidator.java
 * Author:   yangbao
 * Date:     2016年1月6日 上午10:51:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.validators;

import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.entity.CustFinance;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustFinanceValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustFinance.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustFinance cf = (CustFinance) target;
//        if (Assert.equals(cf.getAccountCategory(), 1) && !Assert.checkParam(cf.getProvinceRegionCode())) {
//            throw error("payAccount's provinceRegionCode must be not null");
//        }
//        if (Assert.equals(cf.getAccountCategory(), 1) && !Assert.checkParam(cf.getCityRegionCode())) {
//            throw error("payAccount's cityRegionCode must be not null");
//        }
//        if (Assert.equals(cf.getAccountCategory(), 1) && !Assert.checkParam(cf.getBankCategory())) {
//            throw error("payAccount's bankCategory must be not null");
//        }
//        if (Assert.equals(cf.getAccountCategory(), 1) && !Assert.checkParam(cf.getSubBank())) {
//            throw error("payAccount's subBank must be not null");
//        }
//        if (Assert.equals(cf.getAccountCategory(), 1) && !Assert.checkParam(cf.getAccountName())) {
//            throw error("payAccount's accountName must be not null");
//        }
//        if (Assert.equals(cf.getAccountCategory(), 1) && !Assert.checkParam(cf.getAccountNum())) {
//            throw error("payAccount's accountNum must be not null");
//        }
        if (Assert.equals(cf.getAccountCategory(), 2) && !Assert.checkParam(cf.getProvinceRegionCode())) {
            throw error("refundAccount's provinceRegionCode must be not null");
        }
        if (Assert.equals(cf.getAccountCategory(), 2) && !Assert.checkParam(cf.getCityRegionCode())) {
            throw error("refundAccount's cityRegionCode must be not null");
        }
        if (Assert.equals(cf.getAccountCategory(), 2) && !Assert.checkParam(cf.getBankCategory())) {
            throw error("refundAccount's bankCategory must be not null");
        }
        if (Assert.equals(cf.getAccountCategory(), 2) && !Assert.checkParam(cf.getSubBank())) {
            throw error("refundAccount's subBank must be not null");
        }
        if (Assert.equals(cf.getAccountCategory(), 2) && !Assert.checkParam(cf.getAccountName())) {
            throw error("refundAccount's accountName must be not null");
        }
        if (Assert.equals(cf.getAccountCategory(), 2) && !Assert.checkParam(cf.getAccountNum())) {
            throw error("refundAccount's accountNum must be not null");
        }
        if (!Assert.checkParam(cf.getLenderApplyId())) {
            throw error("custFinace lenderApplyId  must be not null");
        }
        if (!Assert.checkParam(cf.getCustAccountId())) {
            throw error("custFinace custAccountId  must be not null");
        }
        if (!Assert.checkParam(cf.getCreateUser())) {
            throw error("custFinace createUser  must be not null");
        }
        if (!Assert.checkParam(cf.getDataStatus())) {
            throw error("custFinace dataStatus  must be not null");
        }

    }

}
