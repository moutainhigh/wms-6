package com.dx.wms.service.validators;

import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.account.entity.CustAccount;

public class CustAccountValidator extends BaseValidator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CustAccount.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustAccount ca = (CustAccount) target;
        if (!Assert.checkParam(ca.getCustName())) {
            throw error("custName must not be null");
        }
        if (!Assert.checkParam(ca.getCustNameSpell())) {
            throw error("custNameSpell must not be null");
        }
        if (!Assert.checkParam(ca.getSex())) {
            throw error("sex must not be null");
        }
        if (!Assert.checkParam(ca.getNationality())) {
            throw error("nationality must not be null");
        }
        if (!Assert.checkParam(ca.getCommonLanguage())) {
            throw error("commonLanguage must not be null");
        }
        if (!Assert.checkParam(ca.getIdType())) {
            throw error("idType must not be null");
        }
        if (!Assert.checkParam(ca.getIdCard())) {
            throw error("idCard must not be null");
        }
        if (!Assert.checkParam(ca.getBirthDate())) {
            throw error("birthDate must not be null");
        }
        if (!Assert.checkParam(ca.getMobile())) {
            throw error("mobile must not be null");
        }
        if (!Assert.checkParam(ca.getMsgWay())) {
            throw error("msgWay must not be null");
        }
        if (!Assert.checkParam(ca.getCustSource())) {
            throw error("custSource must not be null");
        }
        if (ca.getCustSource().equals(20) && !Assert.checkParam(ca.getCustSourceOther())) {
            throw error("custSourceOther must not be null");
        }
        if (!Assert.checkParam(ca.getOpenDate())) {
            throw error("openDate must not be null");
        }
        if (!Assert.checkParam(ca.getCustCategory())) {
            throw error("custCategory must not be null");
        }
        if (!Assert.checkParam(ca.getOrgId())) {
            throw error("orgId must not be null");
        }
        if (!Assert.checkParam(ca.getTeamId())) {
            throw error("teamId must not be null");
        }
        if (!Assert.checkParam(ca.getCreateUser())) {
            throw error("custAccount createUser must not be null");
        }
        if (!Assert.checkParam(ca.getDataStatus())) {
            throw error("custAccount dataStatus must not be null");
        }
    }
}
