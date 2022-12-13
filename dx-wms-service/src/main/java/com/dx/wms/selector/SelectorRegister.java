package com.dx.wms.selector;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.google.gson.Gson;

public abstract class SelectorRegister implements Selector<ParamSelector, ResultSelector> {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(SelectorRegister.class);

    @Autowired
    private SelectorObserver<Selector<ParamSelector, ResultSelector>, ParamSelector, ResultSelector> selector;

    @Autowired
    private PaginationDalClient dalClient;

    @Override
    @PostConstruct
    public void join() {
        selector.regist(this);
    }

    @Override
    public String init(ParamSelector param) {
        return "/select/select";
    }
    
    private void check(ParamSelector param) {
        Assert.notNull("Param must not be null", param);
        Assert.notNull("Current user must not be null", param.getUserId());
        LOG.debug("Param[{}]", new Gson().toJson(param));
    }

    @Override
    public PaginationResult<List<ResultSelector>> query(ParamSelector param, Pagination page) {
        check(param);
        return dalClient.queryForList(param.getType().getSqlId(), MapUtils.obj2Map(param), ResultSelector.class, page);
    }
}
