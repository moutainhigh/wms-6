package com.dx.cmm.service.sync;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;

@Service("resultReportDaySync")
public class ResultReportDaySync extends SyncAbs {

    @Override
    public void sync() {
        List<MatchResult> results = investResult.queryAll();
        Integer error = 0;
        for (MatchResult result : results) {
            if (!Assert.checkParam(result.getInvestReportDay())) {
                LOG.error("Result id[{}] invest report date is null", result.getMatchResultId());
                error++;
                continue;
            }
            result.setReportDate(result.getInvestReportDay());
            LOG.info("Report date[{}]", result.getReportDate());
            investResult.save(result);
        }
        LOG.info("Error[{}]", error);
    }

}
