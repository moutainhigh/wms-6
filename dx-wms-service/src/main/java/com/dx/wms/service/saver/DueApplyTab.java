/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: CustApplyTab.java
 * Author:   taocheng
 * Date:     2016年3月29日 下午2:11:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.saver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author taocheng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum DueApplyTab {
    
    ACCOUNT("tab_account", "active", "账户信息", "save/account_view.ftl", 1),

    APPLY("tab_apply", "", "投资信息", "save/dueApply_edit.ftl", 2),

    VIDEO("tab_video", "", "影像信息", "save/video_edit.ftl", 3);

    /**
     * 板块编号
     */
    private String tabId;

    /**
     * 板块样式
     */
    private String tabClass;

    /**
     * 板块标题
     */
    private String tabTitle;

    /**
     * 板块渲染地址
     */
    private String tabUrl;

    /**
     * 顺序
     */
    private Integer index;

    DueApplyTab(String tabId, String tabClass, String tabTitle, String tabUrl, Integer index) {
        this.tabId = tabId;
        this.tabClass = tabClass;
        this.tabTitle = tabTitle;
        this.tabUrl = tabUrl;
        this.index = index;
    }

    protected String getTabId() {
        return tabId;
    }

    protected void setTabId(String tabId) {
        this.tabId = tabId;
    }

    protected String getTabClass() {
        return tabClass;
    }

    protected void setTabClass(String tabClass) {
        this.tabClass = tabClass;
    }

    protected String getTabTitle() {
        return tabTitle;
    }

    protected void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    protected String getTabUrl() {
        return tabUrl;
    }

    protected void setTabUrl(String tabUrl) {
        this.tabUrl = tabUrl;
    }

    protected Integer getIndex() {
        return index;
    }

    protected void setIndex(Integer index) {
        this.index = index;
    }

    protected static List<TabSaver> geTabs() {
        List<TabSaver> tabs = new ArrayList<>();
        for (DueApplyTab tab : DueApplyTab.values()) {
            tabs.add(new TabSaver(tab));
        }
        Collections.sort(tabs, new TabComparator());
        return tabs;
    }
}
