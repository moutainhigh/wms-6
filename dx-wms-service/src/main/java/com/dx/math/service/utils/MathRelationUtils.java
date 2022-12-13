package com.dx.math.service.utils;

import java.math.BigDecimal;

import com.dx.math.service.enums.MathRelationSign;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class MathRelationUtils {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param arg0
     * @param arg1
     * @param mathSignType
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Boolean calculate(BigDecimal arg0, BigDecimal arg1, MathRelationSign mathRelationSign) {
        int calculateResult = arg0.compareTo(arg1);
        switch (mathRelationSign) {
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
                return Boolean.FALSE;
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param arg0
     * @param arg1
     * @param mathRelationSign
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Boolean calculate(Integer arg0, Integer arg1, MathRelationSign mathRelationSign) {
        int calculateResult = arg0.compareTo(arg1);
        switch (mathRelationSign) {
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
                return Boolean.FALSE;
        }
    }

}
