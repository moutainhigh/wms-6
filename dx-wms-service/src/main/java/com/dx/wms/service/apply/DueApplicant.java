package com.dx.wms.service.apply;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.enums.ApplyBiz;
import com.dx.wms.service.apply.dto.ParamApplicant;
import com.dx.wms.service.apply.dto.ResultApplicant;
import com.google.gson.Gson;

@Service
public class DueApplicant extends ApplicantRegister {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(DueApplicant.class);

    @Override
    public String init(ParamApplicant param) {
        return "custApply/dueList";
    }

    @Override
    public PaginationResult<List<ResultApplicant>> query(ParamApplicant param, Pagination page) {
        Assert.notNull("Param must not be null", param);
        LOG.info("Param[{}]", new Gson().toJson(param));
        Date date = DateUtils.getNextWorkday(new Date(), 6);
        param.setBorderDate(date);
        return dalClient.queryForList("custApply.queryDueListForPage", MapUtils.obj2Map(param), ResultApplicant.class,
                page);
    }

    @Override
    public Boolean supports(ParamApplicant param) {
        return Assert.equals(param.getBiz(), ApplyBiz.DUE);
    }

}
