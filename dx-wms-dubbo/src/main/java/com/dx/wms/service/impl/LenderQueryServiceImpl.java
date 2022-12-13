/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: WMSBizServiceImpl.java
 * Author:   FlaTa
 * Date:     2016年4月5日 上午10:26:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.dto.QueryResultDto;
import com.dx.common.service.utils.Assert;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.dao.ILenderQueryDao;
import com.dx.wms.dto.LenderQueryDto;
import com.dx.wms.dto.LenderResultDto;
import com.dx.wms.enums.MsgWay;
import com.dx.wms.enums.PayWay;
import com.dx.wms.service.ILenderQueryService;
import com.google.gson.Gson;

/**
 * 〈一句话功能简述〉理财业务数据查询Service<br>
 * 〈功能详细描述〉
 *
 * @author 蒋玉涛
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LenderQueryServiceImpl implements ILenderQueryService {
	
	/**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(LenderQueryServiceImpl.class);

    @Autowired
    private ILenderQueryDao dao;

    @Autowired
    private IRegionNewService regionService;

    @Override
    public PaginationResult<List<LenderResultDto>> queryResultByDueDate(LenderQueryDto queryDto) {
        return dao.queryResultByDueDate(queryDto);
    }

    @Override
    public BigDecimal queryAmountsByDueDate(LenderQueryDto queryDto) {
        return dao.queryWMSBizAmountsByStatus(queryDto);
    }

    @Override
    public QueryResultDto queryLenderCode(String lenderCode) {
        QueryResultDto dto = dao.queryLenderInfoByCode(lenderCode);
        put(dto);
        return dto;
    }

    private void put(QueryResultDto dto) {
        String province = Assert.checkParam(dto.getProvinceRegionCode())
                ? regionService.getRegionNameByCode(dto.getProvinceRegionCode()) : "";
        String city = Assert.checkParam(dto.getCityRegionCode())
                ? regionService.getRegionNameByCode(dto.getCityRegionCode()) : "";
        String district = Assert.checkParam(dto.getDistrictRegionCode())
                ? regionService.getRegionNameByCode(dto.getDistrictRegionCode()) : "";
        dto.setCustAddress(province + city + district + dto.getStreetInfo());
        dto.setPayWay(Assert.checkParam(dto.getPayWayId()) ? PayWay.getInfo(dto.getPayWayId(), true) : "");
        dto.setMsgWayView(Assert.checkParam(dto.getMsgWay()) ? MsgWay.getInfo(dto.getMsgWay(), true) : "");
    }

    @Override
    public QueryResultDto queryApplyId(Long applyId) {
        QueryResultDto dto = dao.queryLenderInfoById(applyId);
        LOG.info("****ILenderQueryDao.queryApplyId****"+new Gson().toJson(dto));
        put(dto);
        return dto;
    }
}
