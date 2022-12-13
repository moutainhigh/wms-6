/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: sss.java
 * Author:   王蕊
 * Date:     2015年7月14日 下午5:21:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class CustBaseDaoImpl extends BaseDaoImpl<CustBase> implements ICustBaseDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustBaseDaoImpl.class);

    @Override
    public CustBase queryByParam(String code) {
        Assert.notNull("Code must not be null", code);
        LOG.info("Code[{}]", code);
        return dalClient.queryForObject("custBase.queryByCustCode", MapUtils.getParamMap("custCode", code),
                CustBase.class);
    }

    @Override
    public Boolean update(Long id, String status) {
        Assert.notNull("Id or status must not be null", id, status);
        LOG.info("Id[{}],status[{}]", id, status);
        CustBase base = queryById(CustBase.class, id);
        base.setDataStatus(status);
        return update(base);
    }

    @Override
    public PaginationResult<List<ResultView>> queryForPage(ParamView param, Pagination page) {
        return dalClient.queryForList("custBase.queryForPage", MapUtils.obj2Map(param), ResultView.class, page);

    }

}
