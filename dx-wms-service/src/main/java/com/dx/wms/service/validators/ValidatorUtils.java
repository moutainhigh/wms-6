package com.dx.wms.service.validators;

import org.springframework.validation.Validator;

import com.dx.common.service.utils.Assert;
/**
 * 
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author tony
 */
public abstract class ValidatorUtils {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param validator
     * @param obj
     */
    public static void validate(Validator validator, Object obj) {
        Assert.notNull(validator, "Validator must not be null");
        Assert.notNull(obj, "Obj must not be null");
        if (obj != null && !validator.supports(obj.getClass())) {
            throw new IllegalArgumentException(
                    "Validator [" + validator.getClass() + "] does not support [" + obj.getClass() + "]");
        }
        validator.validate(obj, null);
    };
}
