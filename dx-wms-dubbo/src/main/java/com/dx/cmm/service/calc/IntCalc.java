package com.dx.cmm.service.calc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 利息运算
 *
 * @author tony
 */
abstract class IntCalc<T> extends CalcAbs<T, BigDecimal> {

    @Autowired
    Calc<DateParamCalc, DateResultCalc> dateCalc;
}
