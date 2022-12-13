/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyValidator.java
 * Author:   yangbao
 * Date:     2016年1月6日 上午10:22:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.validators;

import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LenderApplyValidator extends BaseValidator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LenderApply.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LenderApply la = (LenderApply) target;
        if (!Assert.checkParam(la.getContractCode())) {
            throw error("contractCode must be not null");
        }
        if (!Assert.checkParam(la.getProductId())) {
            throw error("productId must be not null");
        }
        if (!Assert.checkParam(la.getExpectLenderDateBegin())) {
            throw error("expectLenderDateBegin must be not null");
        }
        if (!Assert.checkParam(la.getExpectLenderDateEnd())) {
            throw error("expectLenderDateEnd must be not null");
        }
        if (!Assert.checkParam(la.getLenderAmount())) {
            throw error("lenderAmount must be not null");
        }
//         if (!Assert.checkParam(la.getPayWayId())) {
//         throw error("payWayId must be not null");
//         }
        if (!Assert.checkParam(la.getSignDate())) {
            throw error("signDate must be not null");
        }
        if (!Assert.checkParam(la.getRecovery())) {
            throw error("recovery must be not null");
        }

        if (Assert.checkParam(la.getPayWayId()) && Assert.equals(la.getPayWayId(), 3l)
                && !Assert.checkParam(la.getSignMobile())) {
            throw error("signMobile must be not null");
        }
        if (!Assert.checkParam(la.getCustAccountId())) {
            throw error("lenderApply custAccountId must be not null");
        }
        if (!Assert.checkParam(la.getLenderCustCode())) {
            throw error("lenderApply lenderCustCode must be not null");
        }
        if (!Assert.checkParam(la.getOrgId())) {
            throw error("lenderApply orgId must be not null");
        }
        if (!Assert.checkParam(la.getTeamId())) {
            throw error("lenderApply teamId must be not null");
        }
        if (!Assert.checkParam(la.getCreateUser())) {
            throw error("lenderApply createUser must be not null");
        }
        if (!Assert.checkParam(la.getDataStatus())) {
            throw error("lenderApply dataStatus must be not null");
        }

    }

}
