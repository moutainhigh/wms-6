package com.dx.cmm.service.reports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.dto.ViewCreditDetailDto;
import com.dx.cmm.dto.ViewInvestDetailDto;
import com.dx.cmm.enums.ReportType;
import com.dx.cmm.exception.ViewException;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;

/**
 * 
 * 首期债权转让及受让协议
 *
 * @author tony
 */
@Service
public class FirstReport extends ReportRegister<ResultFirstReport> {

    private static final String QUERY = "view.firstMatchReport";

    private static final String QUERY_DETAIL = "view.firstMatchReportDetail";

    @Autowired
    private ICacheService<ResultFirstReport> cacheService;

    @Override
    public Boolean supports(ParamReport param) {
        return Assert.equals(param.getType(), ReportType.FISRT_REPORT);
    }

    @Override
    public ResultFirstReport query(ParamReport p) {
        String key = cacheService.initKey(ReportType.FISRT_REPORT.toString(), ":", p.getBizCode());
        ResultFirstReport dto = cacheService.getObject(key, ResultFirstReport.class);
        return Assert.checkParam(dto) ? dto : queryForDB(p, key);
    }

    private ResultFirstReport queryForDB(ParamReport p, String key) {
        ResultFirstReport dto = queryMain(p);
        if (Assert.checkParam(dto)) {
            return dto;
        }
        put(dto, p);
        cacheService.set(key, dto);
        return dto;
    }

    private void put(ResultFirstReport dto, ParamReport p) {
        ViewInvestDetailDto invest = dalClient.queryForObject(QUERY, MapUtils.obj2Map(dto), ViewInvestDetailDto.class);
        invest.first();
        Assert.notNull(new ViewException("no find dto"), dto);
    }

    private List<ViewCreditDetailDto> get(Long poolId) {
        Assert.notNull(new ViewException("no find pool"), poolId);
        List<ViewCreditDetailDto> dtos = dalClient.queryForList(QUERY_DETAIL, MapUtils.getParamMap("poolId", poolId),
                ViewCreditDetailDto.class);
        for (ViewCreditDetailDto dto : dtos) {
            // dto.put();
        }
        return dtos;
    }

    private ResultFirstReport queryMain(ParamReport param) {
        ResultFirstReport dto = dalClient.queryForObject("view.queryParam", MapUtils.obj2Map(param),
                ResultFirstReport.class);
        return dto;
    }

    @Override
    public List<ResultFirstReport> queryList(ParamReport param) {
        // TODO Auto-generated method stub
        return null;
    }

}
