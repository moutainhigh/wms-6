package com.dx.wms.service.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.google.gson.Gson;

public class AccountSaveValidator extends BaseValidator {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(AccountSaveValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return CustAccountApplyDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustAccountApplyDto dto = (CustAccountApplyDto) target;
        if (!Assert.checkParam(dto)) {
            throw error("dto must not be null");
        }
        if (!Assert.checkParam(dto.getActionUserId())) {
            throw error("userId must not be null");
        }
        if (!Assert.checkParam(dto.getCustAccount())) {
            throw error("custAccount must not be null");
        }

        ValidatorUtils.validate(new CustAccountValidator(), dto.getCustAccount());
        LOG.info("**save() custAccountApplyDto={}**", new Gson().toJson(dto));

    }

}
