package com.dx.wms.service.model;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.exception.ObjectNotFoundException;

/**
 * 
 * 模型业务
 *
 * @author tony
 */
public enum ModelType {

    VIEW("view"),

    ACCOUNT("account"),

    APPLY("apply"),

    DUEAPPLY("dueApply");

    /**
     * 类型
     */
    private String type;

    ModelType(String type) {
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ModelType get(String type) {
        Assert.checkParam("Type must not be null", type);
        for (ModelType model : ModelType.values()) {
            if (Assert.equals(model.getType(), type)) {
                return model;
            }
        }
        throw new ObjectNotFoundException("Type type[{0}] not found", type);
    }

}
