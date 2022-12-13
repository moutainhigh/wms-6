package com.dx.math.service.utils;

import java.math.BigDecimal;

import com.dx.math.service.enums.MathArithmeticSign;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class MathArithmeticUtils {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param arg0
     * @param arg1
     * @param mathArithmeticSign
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static BigDecimal calculate(BigDecimal arg0, BigDecimal arg1, MathArithmeticSign mathArithmeticSign) {
        BigDecimal result = BigDecimal.ZERO;
        switch (mathArithmeticSign) {
            case MULTIPLY:// *
                return (arg0.multiply(arg1).setScale(2, BigDecimal.ROUND_HALF_UP));
            case ADD:// +
                return (arg0.add(arg1));
            case DIVIDE:// /
                return (arg0.divide(arg1, 2, BigDecimal.ROUND_HALF_UP));
            case SUBTRACT:// -
                return (arg0.subtract(arg1));
            case REM:// %
                BigDecimal[] values = arg0.divideAndRemainder(arg1);
                return values[0];
            case DECREASE:// --
                arg0 = arg0.subtract(arg1);
                return arg0;
            case INCREASE:// ++
                arg0 = arg0.add(arg1);
                return arg0;
            default:
                return result;

        }

    }

}
