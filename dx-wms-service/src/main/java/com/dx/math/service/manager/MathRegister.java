package com.dx.math.service.manager;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MathRegister implements Math<ParamMath, ResultMath> {

    /**
     * 日志组件
     */
    public static final Logger LOG = LoggerFactory.getLogger(MathRegister.class);

    @Autowired
    private MathObserver<Math<ParamMath, ResultMath>, ParamMath, ResultMath> mathExecutor;

    @Override
    @PostConstruct
    public void join() {
        mathExecutor.regist(this);
    }

    public Boolean checkDto(ParamMath p) {
        if (p == null) {
            return false;
        }
        if (p.getMathSignType() == null) {
            return false;
        }
        return true;
    }

}
