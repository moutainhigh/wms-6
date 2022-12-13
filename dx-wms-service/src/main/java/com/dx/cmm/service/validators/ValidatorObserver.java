package com.dx.cmm.service.validators;

import com.beust.jcommander.ParameterException;
import com.dx.cmm.service.observer.DataObserver;

/**
 * 
 * 校验观察者
 *
 * @author tony
 */
public interface ValidatorObserver<S, P> extends DataObserver<S> {

    /**
     * 
     * 校验
     *
     * @param param
     * @throws ParameterException
     */
    void validate(P param) throws ParameterException;
}
