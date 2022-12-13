package com.dx.math.service.manager;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.math.service.enums.MathConstants;
import com.dx.math.service.enums.MathFunctionSign;
import com.dx.math.service.enums.MathSignType;
import com.dx.math.service.utils.MathFunctionUtils;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class FunctionMath extends MathRegister {

    @Override
    public ResultMath parse(ParamMath p) {
        Map<String, Object> params = p.getParams();
        MathFunctionSign functionSign = MathFunctionSign.getEunm(p.getSignKey());
        Object arg0 = params.get(MathConstants.PARAM.toString());
        Object arg1 = params.get(p.getReturnKey());
        Map<String, Object> returnValue = new HashMap<String, Object>();
        switch (functionSign) {
            case ROUND:
                returnValue.put(p.getReturnKey(), MathFunctionUtils.round((BigDecimal) arg0, (Integer) arg1));
                return new ResultMath(p.getReturnKey(), returnValue);
            default:
                returnValue.put(p.getReturnKey(), Boolean.FALSE);
                return new ResultMath(p.getReturnKey(), returnValue);
        }
    }

    @Override
    public Boolean supports(ParamMath p) {
        if (p.getMathSignType().equals(MathSignType.FUNCTION)) {
            return true;
        }
        return false;
    }

}
