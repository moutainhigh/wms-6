package com.dx.wms.service.detail;

import java.util.Comparator;

/**
 * 
 * 板块排序器
 *
 * @author tony
 */
public class TabComparator implements Comparator<TabDetail> {

    @Override
    public int compare(TabDetail arg0, TabDetail arg1) {
        return arg0.getIndex().compareTo(arg1.getIndex());
    }

}
