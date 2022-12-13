package com.dx.cmm.service.match.comparator;

import java.util.Comparator;

import com.dx.cmm.service.match.result.CreditResult;

public class CreditComparator implements Comparator<CreditResult> {

    @Override
    public int compare(CreditResult arg0, CreditResult arg1) {
        return arg1.getUndoAmount().compareTo(arg0.getUndoAmount());
    }

}
