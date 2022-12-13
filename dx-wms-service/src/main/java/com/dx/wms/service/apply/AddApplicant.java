package com.dx.wms.service.apply;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.enums.ApplyBiz;
import com.dx.wms.service.apply.dto.ParamApplicant;
import com.dx.wms.service.apply.dto.ResultApplicant;

@Service
public class AddApplicant extends ApplicantRegister {

    @Override
    public String init(ParamApplicant param) {
        return "custApply/list";
    }

    @Override
    public PaginationResult<List<ResultApplicant>> query(ParamApplicant param, Pagination page) {
        return dalClient.queryForList("custApply.queryForPage", MapUtils.obj2Map(param), ResultApplicant.class, page);
    }

    @Override
    public Boolean supports(ParamApplicant param) {
        return Assert.equals(param.getBiz(), ApplyBiz.ADD);
    }

}
