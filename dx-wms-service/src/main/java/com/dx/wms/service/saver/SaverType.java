package com.dx.wms.service.saver;

import java.util.List;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.exception.ObjectNotFoundException;

/**
 * 
 * 业务类型
 *
 * @author tony
 */
public enum SaverType {

    /**
     * 账户
     */
    ACCOUNT("account", "开户申请", AccountTab.geTabs()),

    /**
     * 申请
     */
    APPLY("apply", "理财申请", ApplyTab.geTabs()),
    
    /**
     * 续投
     */
    DUEAPPLY("dueApply", "续投申请", DueApplyTab.geTabs());

    SaverType(String type, String title, List<TabSaver> tabs) {
        setType(type);
        setTitle(title);
        setTabs(tabs);
    }

    /**
     * 类型
     */
    private String type;

    /**
     * 标题
     */
    private String title;

    /**
     * 板块
     */
    private List<TabSaver> tabs;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TabSaver> getTabs() {
        return tabs;
    }

    public void setTabs(List<TabSaver> tabs) {
        this.tabs = tabs;
    }

    public static SaverType get(String type) {
        Assert.checkParam("Type must not be null", type);
        for (SaverType saver : SaverType.values()) {
            if (Assert.equals(saver.getType(), type)) {
                return saver;
            }
        }
        throw new ObjectNotFoundException("Type type[{0}] not found", type);
    }
}
