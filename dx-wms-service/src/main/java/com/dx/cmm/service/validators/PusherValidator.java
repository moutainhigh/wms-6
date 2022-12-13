package com.dx.cmm.service.validators;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.common.service.utils.Assert;

@Service
public class PusherValidator extends ValidatorRegister {

    @Override
    public Boolean supports(Object param) {
        return PushData.class.equals(param.getClass());
    }

    @Override
    public void validate(Object param) {
        PushData push = (PushData) param;
        Assert.notNull(error("Biz code must not be null"), push.getBizCode());
    }

}
