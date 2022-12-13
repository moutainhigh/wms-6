package com.dx.cmm.service.trans;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.ViewAbs;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.google.gson.Gson;

public class TransGateway extends ViewAbs implements IMatchTransService {

    private static final String STAT_SQL = "transView.statQuery";

    private static final String DETAIL_SQL = "transView.detailQuery";

    private static final String DETAIL_KEY = "trans:stat:";

    @Autowired
    private ICacheService<TransStatDetailResult> cacheService;

    @Override
    public PaginationResult<List<TransStatResult>> queryStat(TransStatParam param, Pagination page) {
        LOG.info("Stat query param is [{}]", new Gson().toJson(MapUtils.obj2Map(param)));
        return dalClient.queryForList(STAT_SQL, MapUtils.obj2Map(param), TransStatResult.class, page);
    }

    @Override
    public List<TransStatDetailResult> queryDetail(Date date) {
        String key = cacheService.initKey(DETAIL_KEY, DateUtils.formatForDay(date));
        List<TransStatDetailResult> results = cacheService.getArray(key, TransStatDetailResult.class);
        if (Assert.checkParam(results)) {
            return results;
        }
        Map<String, Object> param = MapUtils.getParamMap("createDateBegin", DateUtils.formatForBegin(date));
        param.put("createDateEnd", DateUtils.formatForEnd(date));
        results = dalClient.queryForList(DETAIL_SQL, param, TransStatDetailResult.class);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        if (date.before(DateUtils.parseForBegin(DateUtils.formatForBegin(new Date())))) {
            cacheService.set(key, results);
        }
        return results;
    }

}
