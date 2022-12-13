package com.dx.math.service.manager;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.math.service.enums.MathConstants;
import com.dx.math.service.enums.MathRelationSign;
import com.dx.math.service.enums.MathSignType;
import com.dx.math.service.enums.MathType;
import com.dx.math.service.utils.MathRelationUtils;

/**
 * 
 * 关系操作符服务<br>
 * 关系操作符服务
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RelationMath extends MathRegister {

    @Override
    public ResultMath parse(ParamMath p) {
        MathType paramType = p.getParamType();
        Map<String, Object> params = p.getParams();
        Object arg0 = params.get(MathConstants.PARAM.toString());
        Object arg1 = params.get(p.getReturnKey());
        MathRelationSign mathRelationSign = MathRelationSign.getEunm(p.getSignKey());
        Map<String, Object> returnValue = new HashMap<String, Object>();
        switch (paramType) {
            case BIG_DECIMAL:
                returnValue.put(p.getReturnKey(),
                        MathRelationUtils.calculate((BigDecimal) arg0, (BigDecimal) arg1, mathRelationSign));
                return new ResultMath(p.getReturnKey(), returnValue);
            case INTEGER:
                returnValue.put(p.getReturnKey(),
                        MathRelationUtils.calculate((Integer) arg0, (Integer) arg1, mathRelationSign));
                return new ResultMath(p.getReturnKey(), returnValue);
            default:
                returnValue.put(p.getReturnKey(), Boolean.FALSE);
                return new ResultMath(p.getReturnKey(), returnValue);
        }
    }

    @Override
    public Boolean supports(ParamMath p) {
        if (p.getMathSignType().equals(MathSignType.RELATION)) {
            return true;
        }
        return false;
    }

}
