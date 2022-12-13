package com.dx.wms.service.saver;

import java.util.Comparator;

/**
 * 
 * 板块排序器
 *
 * @author tony
 */
public class TabComparator implements Comparator<TabSaver> {

    @Override
    public int compare(TabSaver arg0, TabSaver arg1) {
        return arg0.getIndex().compareTo(arg1.getIndex());
    }

}
