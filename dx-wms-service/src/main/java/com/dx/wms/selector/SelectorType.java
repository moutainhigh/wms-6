package com.dx.wms.selector;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.exception.ObjectNotFoundException;

/**
 * 
 * 选择器类型
 *
 * @author tony
 */
public enum SelectorType {

    /**
     * 客户视图
     */
    VIEW("view", "selector.view"),

    /**
     * 理财账户
     */
    ACCOUNT("account", "selector.account");

    private String info;

    private String sqlId;

    SelectorType(String info, String sqlId) {
        this.info = info;
        this.sqlId = sqlId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public static SelectorType get(String info) {
        Assert.checkParam("Info must not be null", info);
        for (SelectorType selector : SelectorType.values()) {
            if (Assert.equals(selector.getInfo(), info)) {
                return selector;
            }
        }
        throw new ObjectNotFoundException("Detail info:[{0}] not found", info);
    }
}
