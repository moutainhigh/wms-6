/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchBizBaseDaoImpl.java
 * Author:   蔡登勇
 * Date:     2015年7月26日 下午12:35:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.base.impl.BaseDaoImpl;

@Service
public class MatchBizBaseDaoImpl extends BaseDaoImpl<MatchBizBase> implements IMatchBizBaseDao {

    @Override
    public MatchBizBase query(String bizCode) {
        if (!Assert.checkParam(bizCode)) {
            LOG.error("Biz code must not be null");
            return null;
        }
        return dalClient.queryForObject("matchBizBase.query", MapUtils.getParamMap("bizCode", bizCode),
                MatchBizBase.class);
    }

    @Override
    public List<MatchBizBase> queryArray(String bizCustCode) {
        if (!Assert.checkParam(bizCustCode)) {
            LOG.error("Biz cust code must not be null");
            return null;
        }
        return dalClient.queryForList("matchBizBase.query", MapUtils.getParamMap("bizCustCode", bizCustCode),
                MatchBizBase.class);
    }

    @Override
    public MatchBizBase query(Long poolId) {
        if (!Assert.checkParam(poolId)) {
            LOG.error("Pool id must not be null");
            return null;
        }
        return dalClient.queryForObject("matchBizBase.queryProduct", MapUtils.getParamMap("poolId", poolId),
                MatchBizBase.class);
    }

}
