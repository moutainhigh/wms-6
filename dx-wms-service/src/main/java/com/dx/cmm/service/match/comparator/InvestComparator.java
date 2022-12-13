package com.dx.cmm.service.match.comparator;

import java.util.Comparator;

import com.dx.cmm.service.match.result.InvestResult;

public class InvestComparator implements Comparator<InvestResult> {

    @Override
    public int compare(InvestResult arg0, InvestResult arg1) {
        return arg0.getUndoAmount().compareTo(arg1.getUndoAmount());
    }

}
