package com.dx.math.service.utils;

import java.math.BigDecimal;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class MathFunctionUtils {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param arg0
     * @param arg1
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static BigDecimal round(BigDecimal arg0, Integer arg1) {
        return arg0.setScale(arg1, BigDecimal.ROUND_UP);
    }

}
