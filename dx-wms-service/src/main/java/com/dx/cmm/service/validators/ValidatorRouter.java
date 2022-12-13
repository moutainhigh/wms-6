package com.dx.cmm.service.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.beust.jcommander.ParameterException;
import com.dx.cmm.service.observer.ObserverUtils;

@Service
public class ValidatorRouter<P> implements ValidatorObserver<Validator<P>, P> {

    private List<Validator<P>> validators = new ArrayList<>();

    @Override
    public void regist(Validator<P> validator) {
        validators.add(validator);
    }

    @Override
    public void validate(P param) throws ParameterException {
        for (Validator<P> validator : validators) {
            if (validator.supports(param)) {
                validator.validate(param);
                return;
            }
        }
        throw ObserverUtils.error();
    }

}
