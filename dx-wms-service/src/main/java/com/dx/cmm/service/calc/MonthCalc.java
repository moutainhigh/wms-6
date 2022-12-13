package com.dx.cmm.service.calc;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;

@Service("monthCalc")
public class MonthCalc extends CalcAbs<MonthParamCalc, Integer> {

    @Override
    public Integer calc(MonthParamCalc param) throws CalcException {
        if (!Assert.checkParam(param)) {
            LOG.error("Param must not be null");
            throw error("Param must not be null");
        }
        if (!Assert.checkParam(param.getArg0()) || !Assert.checkParam(param.getArg1())) {
            LOG.error("Param attr must not be null");
            throw error("Param attr must not be null");
        }
        Calendar arg0 = Calendar.getInstance();
        arg0.setTime(param.getArg0());
        Calendar arg1 = Calendar.getInstance();
        arg1.setTime(param.getArg1());
        return (arg1.get(Calendar.YEAR) - arg0.get(Calendar.YEAR)) * 12
                + (arg1.get(Calendar.MONTH) - arg0.get(Calendar.MONTH)) + 1;
    }
    
    public static void main(String[] args) {
        Calendar arg0 = Calendar.getInstance();
        arg0.setTime(DateUtils.parse("2016-01-01", "yyyy-MM-dd"));
        Calendar arg1 = Calendar.getInstance();
        arg1.setTime(DateUtils.parse("2016-11-01", "yyyy-MM-dd"));
        System.out.println((arg1.get(Calendar.YEAR) - arg0.get(Calendar.YEAR)) * 12
                + (arg1.get(Calendar.MONTH) - arg0.get(Calendar.MONTH)) + 1); 
    }
}
