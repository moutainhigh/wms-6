package com.dx.cmm.service.reports;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.framework.dal.client.support.PaginationDalClient;

public abstract class ReportRegister<R> implements Report<ParamReport, R> {

    @Autowired
    public PaginationDalClient dalClient;

    @Autowired
    private ReportObserver<Report<ParamReport, R>, ParamReport, R> report;

    @Override
    @PostConstruct
    public void join() {
        report.regist(this);
    }

}
