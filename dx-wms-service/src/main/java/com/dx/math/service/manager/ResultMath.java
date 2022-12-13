package com.dx.math.service.manager;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ResultMath implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7127987324742311429L;

    private String key;

    private Map<String, Object> returnValue;

    public ResultMath(String key, Map<String, Object> returnValue) {
        this.returnValue = returnValue;
    }

    public Map<String, Object> getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(Map<String, Object> returnValue) {
        this.returnValue = returnValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
