package com.dx.wms.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.selector.ParamSelector;
import com.dx.wms.selector.ResultSelector;
import com.dx.wms.selector.Selector;
import com.dx.wms.selector.SelectorObserver;
import com.google.gson.Gson;

public class SelectorTests extends BaseTest {

    @Autowired
    private SelectorObserver<Selector<ParamSelector, ResultSelector>, ParamSelector, ResultSelector> selector;

    @Test
    public void query() {
        Pagination page = new Pagination(15, 1);
        ParamSelector param = new ParamSelector("view", 392L);
        PaginationResult<List<ResultSelector>> result = selector.query(param, page);
        System.out.println(new Gson().toJson(result));
        System.out.println(new Gson().toJson(result.getR()));
    }
}
