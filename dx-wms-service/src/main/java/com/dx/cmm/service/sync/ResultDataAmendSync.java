package com.dx.cmm.service.sync;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.results.MatchResult;

@Service("resultDataAmendSync")
public class ResultDataAmendSync extends SyncAbs {

    @Override
    public void sync() {
        List<MatchResult> results = dalClient.queryForList("matchResult.queryError", null, MatchResult.class);
        for (MatchResult result : results) {

        }
    }

}
