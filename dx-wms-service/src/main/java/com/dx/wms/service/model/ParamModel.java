package com.dx.wms.service.model;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * 参数模型
 *
 * @author tony
 */
public class ParamModel implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4887561997291381296L;

    /**
     * 模型行为
     */
    private ModelAction action;

    /**
     * 模型业务
     */
    private ModelType type;

    /**
     * 参数对象
     */
    private Map<String, Object> param;

    public ParamModel() {

    }

    public ParamModel(ModelAction action, ModelType type, Map<String, Object> param) {
        setAction(action);
        setType(type);
        setParam(param);
    }

    public ParamModel(ModelType type, Map<String, Object> param) {
        setType(type);
        setParam(param);
    }

    public ModelAction getAction() {
        return action;
    }

    public void setAction(ModelAction action) {
        this.action = action;
    }

    public ModelType getType() {
        return type;
    }

    public void setType(ModelType type) {
        this.type = type;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }

}
