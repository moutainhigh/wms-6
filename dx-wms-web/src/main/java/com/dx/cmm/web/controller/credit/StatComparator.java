package com.dx.cmm.web.controller.credit;

import java.util.Comparator;

/**
 * 
 * 排序工具
 *
 * @author tony
 */
public class StatComparator implements Comparator<StatResult> {

    @Override
    public int compare(StatResult arg1, StatResult arg2) {
        return arg2.getDate().compareTo(arg1.getDate());
    }

}
