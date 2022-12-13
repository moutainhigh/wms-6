package com.dx.cmm.service.scanner;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.restorer.RepairException;
import com.dx.cmm.service.restorer.Restorer;
import com.dx.cmm.service.results.MatchResult;

@Service("resultScanner")
public class ResultScanner extends ScannerAbs {

    @Autowired
    private Restorer<List<MatchResult>> resultRestorer;

    @Override
    public void scanner() {
        List<Map<String, Object>> results = dalClient.queryForList("matchResult.queryCreditError", null);
        Integer error = 0;
        Integer repair = 0;
        for (Map<String, Object> result : results) {
            List<MatchResult> matches = creditResult.queryArray(Long.valueOf(result.get("creditorPoolId").toString()),
                    (Date) result.get("reportDate"));
            LOG.info("Pool id[{}] report date[{}] size[{}]", result.get("creditorPoolId"), result.get("reportDate"),
                    matches.size());
            error++;
            try {
                resultRestorer.repair(matches);
                repair++;
            } catch (RepairException e) {
                LOG.error("Repair pool id[{}] results[{}] error[{}]", result.get("creditorPoolId"), matches.size(),
                        e.getMessage());
            }
        }
        LOG.info("Error[{}],repair[{}]", error, repair);
    }

}
