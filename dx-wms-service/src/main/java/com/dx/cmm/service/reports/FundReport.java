package com.dx.cmm.service.reports;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.ReportType;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;

/**
 * 客户资金出借情况报告
 * 
 * @author tony
 */
@Service
public class FundReport extends ReportRegister<ResultFundReport> {

    @Override
    public ResultFundReport query(ParamReport param) {
        return dalClient.queryForObject(param.getType().getSqlId(), MapUtils.obj2Map(param), ResultFundReport.class);
    }

    @Override
    public Boolean supports(ParamReport param) {
        return Assert.equals(param.getType(), ReportType.FUND_REPORT);
    }

    @Override
    public List<ResultFundReport> queryList(ParamReport param) {
        return dalClient.queryForList(param.getType().getSqlId(), MapUtils.obj2Map(param), ResultFundReport.class);
    }
}
