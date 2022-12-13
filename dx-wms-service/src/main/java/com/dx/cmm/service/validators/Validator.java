package com.dx.cmm.service.validators;

import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.common.DataService;

/**
 * 
 * 校验器
 *
 * @author tony
 */
public interface Validator<P> extends DataService<P> {

    /**
     * 
     * 校验
     *
     * @param param
     * @throws ParamException
     */
    void validate(P param) throws ParamException;

}
