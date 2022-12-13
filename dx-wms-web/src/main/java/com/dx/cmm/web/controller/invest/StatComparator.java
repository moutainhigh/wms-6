package com.dx.cmm.web.controller.invest;

import java.util.Comparator;

public class StatComparator implements Comparator<StatResult> {

    @Override
    public int compare(StatResult arg1, StatResult arg2) {
        return arg2.getDate().compareTo(arg1.getDate());
    }

}
