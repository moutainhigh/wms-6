package com.dx.wms.service.biz.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dx.cmm.enums.RuleSign;

public final class MatchUtils {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param from
     * @param to
     * @param sign
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Boolean calculate(BigDecimal from, BigDecimal to, RuleSign sign) {
        Integer calculateResult = from.compareTo(to);
        switch (sign) {
            case MORE_EQUAL:// from >= to
                return calculateResult >= 0;
            case LESS:// from < to
                return calculateResult < 0;
            case EQUAL:// from == to
                return calculateResult == 0;
            case MORE:// from > to
                return calculateResult > 0;
            case LESS_EQUAL:// from <= to
                return calculateResult <= 0;
            default:
                return false;
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source
     * @param step
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<BigDecimal> split(BigDecimal source, Integer step) {
        BigDecimal[] values = source.divideAndRemainder(new BigDecimal(step));
        List<BigDecimal> results = new ArrayList<BigDecimal>();
        results.add(values[0]);
        results.add(values[0].add(values[1]));
        return results;
    }
}
