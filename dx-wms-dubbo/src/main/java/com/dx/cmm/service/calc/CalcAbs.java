package com.dx.cmm.service.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class CalcAbs<T, R> implements Calc<T, R> {

    static final Logger LOG = LoggerFactory.getLogger("calc");

    CalcException error(String msg, Object... args) {
        return new CalcException(msg, args);
    }

    CalcException error(String msg) {
        return new CalcException(msg);
    }
}
