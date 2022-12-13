package com.dx.cmm.service.scanner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.restorer.RepairException;
import com.dx.cmm.service.restorer.Restorer;
import com.dx.cmm.service.results.MatchResult;

@Service("resultErrorScanner")
public class ResultErrorScanner extends ScannerAbs {

    @Autowired
    private Restorer<MatchResult> resultErrorRestorer;

    @Override
    public void scanner() {
        List<MatchResult> results = creditResult.queryArray(MatchResult.ERROR);
        Integer error = 0;
        Integer repair = 0;
        for (MatchResult result : results) {
            error++;
            try {
                resultErrorRestorer.repair(result);
                repair++;
            } catch (RepairException e) {
                LOG.error(e.getMessage());
            }

        }
    }

}
