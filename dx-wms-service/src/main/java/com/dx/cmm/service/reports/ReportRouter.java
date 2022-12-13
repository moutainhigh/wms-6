package com.dx.cmm.service.reports;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.observer.ObserverUtils;

@Service
public class ReportRouter<P, R> implements ReportObserver<Report<P, R>, P, R> {

    private List<Report<P, R>> reports = new ArrayList<Report<P, R>>();

    @Override
    public void regist(Report<P, R> report) {
        reports.add(report);
    }

    @Override
    public R query(P param) {
        for (Report<P, R> report : reports) {
            if (report.supports(param)) {
                return report.query(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public List<R> queryList(P param) {
        for (Report<P, R> report : reports) {
            if (report.supports(param)) {
                return report.queryList(param);
            }
        }
        throw ObserverUtils.error();
    }

}
