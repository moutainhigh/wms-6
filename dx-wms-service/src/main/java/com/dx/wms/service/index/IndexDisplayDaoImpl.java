/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IndexDisplayDaoImpl.java
 * Author:   黄健
 * Date:     2015年7月26日 下午2:58:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;

/**
 * 首页功能显示 dao实现
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class IndexDisplayDaoImpl implements IIndexDisplayDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(IndexDisplayDaoImpl.class);

    @Autowired
    private PaginationDalClient dalClient;

    @Override
    public Integer queryCustAccountNumByCreateUser(Long createUser) {
        Assert.notNull("**queryCustAccountNumByCreateUser() createUser can not be null**", createUser);
        LOG.info("**queryCustAccountNumByCreateUser() createUser={}**", createUser);
        return dalClient.queryForObject("indexPage.queryCustAccountNumByCreateUser",
                MapUtils.getParamMap("createUser", createUser), Integer.class);
    }

    @Override
    public Integer queryCustAccountNumByOrgId(Long orgId) {
        Assert.notNull("**queryCustAccountNumByOrgId() orgId can not be null**", orgId);
        LOG.info("**queryCustAccountNumByOrgId() orgId={}**", orgId);
        return dalClient.queryForObject("indexPage.queryCustAccountNumByOrgId",
                MapUtils.getParamMap("orgId", orgId), Integer.class);
    }

    @Override
    public Integer queryForCustNumberByCreateUser(Long createUser) {
        Assert.notNull("**queryForCustNumberByCreateUser() createUser can not be null**", createUser);
        LOG.info("**queryForCustNumberByCreateUser() createUser={}**", createUser);
        return dalClient.queryForObject("indexPage.queryForCustNumberByCreateUser",
                MapUtils.getParamMap("createUser", createUser), Integer.class);
    }

    @Override
    public Integer querySuccessApplyNum() {
        LOG.info("** start **querySuccessApplyNum() **");
        return dalClient.queryForObject("indexPage.querySuccessApplyNum",null, Integer.class);
    }

    @Override
    public Integer queryForRefusedApplyNum(Long createUser, Long orgId) {
        LOG.info("**queryForRefusedApplyNum() orgId={},createUser={}**", orgId, createUser);
        if(Assert.checkParam(createUser)) {
            return dalClient.queryForObject("indexPage.queryForRefusedApplyNum",
                    MapUtils.getParamMap("createUser", createUser), Integer.class);
        } else if(Assert.checkParam(orgId)) {
            return dalClient.queryForObject("indexPage.queryForRefusedApplyNum",
                    MapUtils.getParamMap("orgId", orgId), Integer.class);
        }
        return dalClient.queryForObject("indexPage.queryForRefusedApplyNum", null, Integer.class);
    }

    @Override
    public Integer queryForPendingQualityNum(Long orgId) {
        Assert.notNull("**queryForPendingQualityNum() orgId can not be null**", orgId);
        LOG.info("**queryForPendingQualityNum() orgId={}**", orgId);
        return dalClient.queryForObject("indexPage.queryForPendingQualityNum",
                MapUtils.getParamMap("orgId", orgId), Integer.class);
    }

    @Override
    public Integer queryForPendingCheckNum() {
        LOG.info("** start **queryForPendingCheckNum() **");
        return dalClient.queryForObject("indexPage.queryForPendingCheckNum",null, Integer.class);
    }

    @Override
    public BigDecimal queryForSumByCreateUser(Long createUser) {
        Assert.notNull("**queryForSumByCreateUser() createUser can not be null**", createUser);
        LOG.info("**queryForSumByCreateUser() createUser={}**", createUser);
        return dalClient.queryForObject("indexPage.queryForSumByCreateUser",
                MapUtils.getParamMap("createUser", createUser), BigDecimal.class);
    }

    @Override
    public BigDecimal queryForSumByOrgId(Long orgId) {
        Assert.notNull("**queryForSumByOrgId() orgId can not be null**", orgId);
        LOG.info("**queryForSumByOrgId() orgId={}**", orgId);
        return dalClient.queryForObject("indexPage.queryForSumByOrgId",
                MapUtils.getParamMap("orgId", orgId), BigDecimal.class);
    }

    @Override
    public BigDecimal queryForSum() {
        LOG.info("** start **queryForSum() **");
        return dalClient.queryForObject("indexPage.queryForSum",null, BigDecimal.class);
    }

    @Override
    public Integer queryForCustNumberByOrgId(List<Long> createUsers) {
        Assert.notNull("**queryForCustNumberByOrgId() createUsers can not be null**", createUsers);
        LOG.info("**queryForCustNumberByOrgId() createUsers={}**", createUsers);
        return dalClient.queryForObject("indexPage.queryForCustNumberByOrgId",
                MapUtils.getParamMap("createUsers", createUsers), Integer.class);
    }
}
