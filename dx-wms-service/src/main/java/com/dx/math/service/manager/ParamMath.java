package com.dx.math.service.manager;

import java.io.Serializable;
import java.util.Map;

import com.dx.math.service.enums.MathSignType;
import com.dx.math.service.enums.MathType;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ParamMath implements Serializable {

    /**
     */
    private static final long serialVersionUID = 2387043159516018828L;

    /**
     * 符号标示
     */
    private String signKey;

    /**
     * 符号类型标示
     */
    private MathSignType mathSignType;

    private Map<String, Object> params;

    private MathType paramType;

    private String returnKey;

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public MathSignType getMathSignType() {
        return mathSignType;
    }

    public void setMathSignType(MathSignType mathSignType) {
        this.mathSignType = mathSignType;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public MathType getParamType() {
        return paramType;
    }

    public void setParamType(MathType paramType) {
        this.paramType = paramType;
    }

    public String getReturnKey() {
        return returnKey;
    }

    public void setReturnKey(String returnKey) {
        this.returnKey = returnKey;
    }

}
