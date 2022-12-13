package com.dx.cmm.service.credit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.dto.CreditAttr;
import com.dx.cmm.service.ViewAbs;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.google.gson.Gson;

public class CreditGateway extends ViewAbs implements ICreditService {

    private static final String STAT_SQL = "creditView.statQuery";

    private static final String POOL_SQL = "creditView.poolQuery";

    private static final String MATCH_SQL = "creditView.matchQuery";

    private static final String EXP_SQL = "creditView.expQuery";

    private static final String CUR_SQL = "creditView.currentQuery";

    private static final String DETAIL_SQL = "creditView.detailQuery";

    private static final String DETAIL_KEY = "credit:stat:";

    @Autowired
    private ICacheService<CreditStatDetailResult> cacheService;

    @Override
    public PaginationResult<List<CreditStatResult>> queryStat(CreditStatParam param, Pagination page) {
        LOG.info("Stat query param is [{}]", new Gson().toJson(MapUtils.obj2Map(param)));
        return dalClient.queryForList(STAT_SQL, MapUtils.obj2Map(param), CreditStatResult.class, page);
    }

    @Override
    public PaginationResult<List<CreditPoolResult>> queryPool(CreditPoolParam param, Pagination page) {
        LOG.info("Pool query param is [{}]", new Gson().toJson(param));
        return dalClient.queryForList(POOL_SQL, MapUtils.obj2Map(param), CreditPoolResult.class, page);
    }

    @Override
    public List<CreditMatchResult> queryLenderFirst(String lenderCode) {
        return queryLender(lenderCode, 1);
    }

    @Override
    public List<CreditMatchResult> queryLender(String lenderCode, Integer currentPeriod) {
        if (!Assert.checkParam(lenderCode) || !Assert.checkParam(currentPeriod)) {
            return new ArrayList<>();
        }
        Map<String, Object> param = MapUtils.getParamMap("lenderCode", lenderCode);
        param.put("currentPeriod", currentPeriod);
        List<CreditMatchResult> results = dalClient.queryForList(MATCH_SQL, param, CreditMatchResult.class);
        for (CreditMatchResult result : results) {
            CreditAttr attr = Assert.checkParam(result.getBizAttr())
                    ? JSON.parseObject(result.getBizAttr(), CreditAttr.class) : new CreditAttr();
            result.setLoanType(attr.getLoanTypeCn());
            result.setWorkState(attr.getWorkSituationCn());
        }
        return results;
    }

    @Override
    public List<CreditExpResult> queryExp(Integer port) {
        if (!Assert.checkParam(port)) {
            return new ArrayList<CreditExpResult>();
        }
        return dalClient.queryForList(EXP_SQL, MapUtils.getParamMap("port", port), CreditExpResult.class);
    }

    @Override
    public List<CreditStatDetailResult> queryCurrent() {
        return dalClient.queryForList(CUR_SQL, null, CreditStatDetailResult.class);
    }

    @Override
    public List<CreditStatDetailResult> queryDetail(Date date) {
        String key = cacheService.initKey(DETAIL_KEY, DateUtils.formatForDay(date));
        List<CreditStatDetailResult> results = cacheService.getArray(key, CreditStatDetailResult.class);
        if (Assert.checkParam(results)) {
            return results;
        }
        Map<String, Object> param = MapUtils.getParamMap("createDateBegin", DateUtils.formatForBegin(date));
        param.put("createDateEnd", DateUtils.formatForEnd(date));
        results = dalClient.queryForList(DETAIL_SQL, param, CreditStatDetailResult.class);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        if (date.before(DateUtils.parseForBegin(DateUtils.formatForBegin(new Date())))) {
            cacheService.set(key, results);
        }
        return results;
    }

}
