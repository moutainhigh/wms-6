package com.dx.cmm.service.calc;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service("reportDateCalc")
public class ReportDateCalc extends CalcAbs<Integer, Date> {

    @Override
    public Date calc(Integer param) {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

}
