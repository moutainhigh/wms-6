/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BackGatway.java
 * Author:   朱道灵
 * Date:     2016年5月9日 下午1:15:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.back;

import java.util.List;

import com.dx.cmm.service.ViewAbs;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 回款服务
 *
 * @author 朱道灵
 */
public class BackGateway extends ViewAbs implements IMatchBackService {

    @Override
    public PaginationResult<List<BackUsualResult>> queryUsual(BackUsualParam param, Pagination page) {
        if (!Assert.checkParam(param)) {
            LOG.error("Param must not be null");
            return new PaginationResult<List<BackUsualResult>>();
        }
        return dalClient.queryForList("matchBack.queryUsual", MapUtils.obj2Map(param), BackUsualResult.class, page);
    }

    @Override
    public PaginationResult<List<BackTransResult>> queryTrans(BackTransParam param, Pagination page) {
        if (!Assert.checkParam(param)) {
            LOG.error("Param must not be null");
            return new PaginationResult<List<BackTransResult>>();
        }
        return dalClient.queryForList("matchBack.queryTrans", MapUtils.obj2Map(param), BackTransResult.class, page);
    }
}