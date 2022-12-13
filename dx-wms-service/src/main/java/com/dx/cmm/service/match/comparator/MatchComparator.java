package com.dx.cmm.service.match.comparator;

import java.util.Comparator;

import com.dx.cmm.service.match.result.Match;

public class MatchComparator implements Comparator<Match> {

    @Override
    public int compare(Match arg0, Match arg1) {
        return arg0.getTotalAmount().compareTo(arg1.getTotalAmount());
    }

}
