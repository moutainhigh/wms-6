package com.dx.math.service.manager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.math.service.enums.MathSignType;

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
public class AssignmentMath extends MathRegister {

    @Override
    public ResultMath parse(ParamMath p) {
        Object arg0 = p.getParams().get(p.getReturnKey());
        Map<String, Object> returnValue = new HashMap<String, Object>();
        returnValue.put(p.getReturnKey(), arg0);
        return new ResultMath(p.getReturnKey(), returnValue);
    }

    @Override
    public Boolean supports(ParamMath p) {
        return Assert.equals(p.getMathSignType(), MathSignType.ASSIGNMENT);
    }

}
