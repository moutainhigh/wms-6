package com.dx.wms.service.saver;

import com.dx.wms.common.BaseTab;

/**
 * 
 * 板块保存器
 *
 * @author tony
 */
public class TabSaver extends BaseTab {

    /**
     */
    private static final long serialVersionUID = -1620056783992989679L;

    public TabSaver() {

    }

    public TabSaver(ApplyTab tab) {
        setTabId(tab.getTabId());
        setTabUrl(tab.getTabUrl());
        setTabClass(tab.getTabClass());
        setTabTitle(tab.getTabTitle());
        setIndex(tab.getIndex());
    }

    public TabSaver(AccountTab tab) {
        setTabId(tab.getTabId());
        setTabUrl(tab.getTabUrl());
        setTabClass(tab.getTabClass());
        setTabTitle(tab.getTabTitle());
        setIndex(tab.getIndex());
    }
    
    public TabSaver(DueApplyTab tab) {
        setTabId(tab.getTabId());
        setTabUrl(tab.getTabUrl());
        setTabClass(tab.getTabClass());
        setTabTitle(tab.getTabTitle());
        setIndex(tab.getIndex());
    }
}
