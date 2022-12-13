package com.dx.wms.service.detail;

import com.dx.wms.common.BaseTab;

/**
 * 
 * 板块详情<br>
 * 板块详情
 *
 * @author tony
 */
public class TabDetail extends BaseTab {

    /**
     */
    private static final long serialVersionUID = -1133500271980514034L;

    public TabDetail() {

    }

    public TabDetail(ApplyTab tab) {
        setTabId(tab.getTabId());
        setTabUrl(tab.getTabUrl());
        setTabClass(tab.getTabClass());
        setTabTitle(tab.getTabTitle());
        setIndex(tab.getIndex());
    }

    public TabDetail(AccountTab tab) {
        setTabId(tab.getTabId());
        setTabUrl(tab.getTabUrl());
        setTabClass(tab.getTabClass());
        setTabTitle(tab.getTabTitle());
        setIndex(tab.getIndex());
    }
    
    public TabDetail(EntryTab tab) {
        setTabId(tab.getTabId());
        setTabUrl(tab.getTabUrl());
        setTabClass(tab.getTabClass());
        setTabTitle(tab.getTabTitle());
        setIndex(tab.getIndex());
    }
    
    public TabDetail(SynthesizeTab tab) {
        setTabId(tab.getTabId());
        setTabUrl(tab.getTabUrl());
        setTabClass(tab.getTabClass());
        setTabTitle(tab.getTabTitle());
        setIndex(tab.getIndex());
    }
}
