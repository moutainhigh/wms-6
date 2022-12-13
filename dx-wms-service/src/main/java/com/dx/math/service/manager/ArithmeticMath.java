package com.dx.math.service.manager;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.math.service.enums.MathArithmeticSign;
import com.dx.math.service.enums.MathConstants;
import com.dx.math.service.enums.MathSignType;
import com.dx.math.service.enums.MathType;
import com.dx.math.service.utils.MathArithmeticUtils;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
@Service
public class ArithmeticMath extends MathRegister {

    @Override
    public ResultMath parse(ParamMath p) {
        MathType paramType = p.getParamType();
        Map<String, Object> params = p.getParams();
        Object arg0 = params.get(MathConstants.PARAM.toString());
        Object arg1 = params.get(p.getReturnKey());
        MathArithmeticSign mathArithmeticSign = MathArithmeticSign.getEunm(p.getSignKey());
        Map<String, Object> returnValue = new HashMap<String, Object>();
        switch (paramType) {
            case BIG_DECIMAL:
                returnValue.put(p.getReturnKey(),
                        MathArithmeticUtils.calculate((BigDecimal) arg0, (BigDecimal) arg1, mathArithmeticSign));
                return new ResultMath(p.getReturnKey(), returnValue);
            default:
                returnValue.put(p.getReturnKey(), Boolean.FALSE);
                return new ResultMath(p.getReturnKey(), returnValue);
        }
    }

    @Override
    public Boolean supports(ParamMath p) {
        return Assert.equals(p.getMathSignType(), MathSignType.ARITHMETIC);
    }

}
