package com.dx.cmm.service.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.dto.ResultReport;
import com.dx.cmm.enums.ReportType;
import com.dx.cmm.exception.ViewException;
import com.dx.cmm.service.IBillViewService;
import com.dx.common.service.utils.Assert;

@Service
public class ReportGateway implements IBillViewService {

    @Autowired
    private ReportObserver<Report<ParamReport, ResultReport>, ParamReport, ResultReport> report;

    @Override
    public ResultReport query(String bizCode, ReportType code) {
        Assert.notNull(new ViewException("param is null"), bizCode, code);
        return report.query(new ParamReport(bizCode, code));
    }

}
