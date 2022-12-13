/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: WMSBizDaoImpl.java
 * Author:   FlaTa
 * Date:     2016年4月5日 上午10:05:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dx.cmm.dto.QueryResultDto;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.dao.ILenderQueryDao;
import com.dx.wms.dto.LenderQueryDto;
import com.dx.wms.dto.LenderResultDto;
import com.google.gson.Gson;

/**
 * 〈一句话功能简述〉理财业务数据查询Dao<br>
 * 〈功能详细描述〉
 *
 * @author 蒋玉涛
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class LenderQueryDaoImpl implements ILenderQueryDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderQueryDaoImpl.class);

    /**
     * dalClient
     */
    @Autowired
    PaginationDalClient dalClient;

    @Override
    public PaginationResult<List<LenderResultDto>> queryResultByDueDate(LenderQueryDto queryDto) {
        Assert.notNull("**queryWMSBizByFormStatus() queryDto can not be null**", queryDto);
        Assert.notNull("**queryWMSBizByFormStatus() 到期日起 can not be null**", queryDto.getDueDateBegin());
        Assert.notNull("**queryWMSBizByFormStatus() 到期日止 can not be null**", queryDto.getDueDateEnd());
        LOG.info("**queryWMSBizByFormStatus() queryDto={} **", new Gson().toJson(queryDto));
        return dalClient.queryForList("lenderQuery.queryByDueDate", MapUtils.obj2Map(queryDto), LenderResultDto.class,
                queryDto.getPagination());
    }

    @Override
    public BigDecimal queryWMSBizAmountsByStatus(LenderQueryDto queryDto) {
        Assert.notNull("**queryWMSBizAmountsByStatus() queryDto can not be null**", queryDto);
        Assert.notNull("**queryWMSBizAmountsByStatus() formStatus can not be null**", queryDto.getFormStatus());
        Assert.notNull("**queryWMSBizAmountsByStatus() dueDateBegin can not be null**", queryDto.getDueDateBegin());
        Assert.notNull("**queryWMSBizAmountsByStatus() dueDateEnd can not be null**", queryDto.getDueDateEnd());
        LOG.info("**queryWMSBizAmountsByStatus() queryDto={} **", new Gson().toJson(queryDto));
        return dalClient.queryForObject("lenderQuery.queryAmountsByFormStatus", MapUtils.obj2Map(queryDto),
                BigDecimal.class);
    }

    @Override
    public QueryResultDto queryLenderInfoByCode(String lenderCode) {
        Assert.notNull("Lender code must not be null", lenderCode);
        LOG.info("Lender code[{}]", new Gson().toJson(lenderCode));
        return dalClient.queryForObject("lenderQuery.query", MapUtils.getParamMap("lenderCode", lenderCode),
                QueryResultDto.class);
    }

    @Override
    public QueryResultDto queryLenderInfoById(Long applyId) {
        Assert.notNull("Apply id must not be null", applyId);
        LOG.info("Apply id[{}]", new Gson().toJson(applyId));
        return dalClient.queryForObject("lenderQuery.query", MapUtils.getParamMap("applyId", applyId),
                QueryResultDto.class);
    }

}
