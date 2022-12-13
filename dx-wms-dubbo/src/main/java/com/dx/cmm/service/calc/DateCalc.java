package com.dx.cmm.service.calc;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;

@Service("dateCalc")
public class DateCalc extends CalcAbs<DateParamCalc, DateResultCalc> {

    private Calendar init(Date refDate, Integer refDay) {
        Calendar calendar = Calendar.getInstance();
        if (Assert.checkParam(refDate)) {
            calendar.setTime(refDate);
        }
        if (Assert.checkParam(refDay)) {
            calendar.set(Calendar.DAY_OF_MONTH, refDay);
        }
        return calendar;
    }

    @Override
    public DateResultCalc calc(DateParamCalc param) {
        Calendar ref = init(param.getRefDate(), null), pre = init(param.getRefDate(), param.getRefDay()),
                suf = init(param.getRefDate(), param.getRefDay());
        Integer totalDays = 0, preDays = 0, sufDays = 0;
        if (ref.get(Calendar.DAY_OF_MONTH) > param.getRefDay()) {
            suf.add(Calendar.MONTH, 1);
            totalDays = pre.getActualMaximum(Calendar.DAY_OF_MONTH);
            preDays = ref.get(Calendar.DAY_OF_MONTH) - pre.get(Calendar.DAY_OF_MONTH);
            sufDays = totalDays - preDays;
        } else {
            pre.add(Calendar.MONTH, -1);
            totalDays = pre.getActualMaximum(Calendar.DAY_OF_MONTH);
            sufDays = suf.get(Calendar.DAY_OF_MONTH) - ref.get(Calendar.DAY_OF_MONTH);
            preDays = totalDays - sufDays;
        }
        BigDecimal preRate = new BigDecimal(preDays.toString()).divide(new BigDecimal(totalDays.toString()), 15,
                BigDecimal.ROUND_HALF_UP);
        BigDecimal sufRate = BigDecimal.ONE.subtract(preRate);
        return new DateResultCalc(totalDays, preDays, preRate, sufDays, sufRate);
    }

}
