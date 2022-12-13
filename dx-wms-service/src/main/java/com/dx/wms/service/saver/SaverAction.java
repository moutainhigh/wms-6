package com.dx.wms.service.saver;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.exception.ObjectNotFoundException;

/**
 * 
 * 业务行为
 *
 * @author tony
 */
public enum SaverAction {
    /**
     * 创建
     */
    CREATE("create"),

    /**
     * 编辑
     */
    EDIT("edit");
    /**
     * 行为
     */
    private String action;

    SaverAction(String action) {
        setAction(action);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public static SaverAction get(String action) {
        Assert.checkParam("Action must not be null", action);
        for (SaverAction saver : SaverAction.values()) {
            if (Assert.equals(saver.getAction(), action)) {
                return saver;
            }
        }
        throw new ObjectNotFoundException("Action type[{0}] not found", action);
    }

}
