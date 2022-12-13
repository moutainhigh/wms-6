/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderConditionDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年8月12日 下午9:59:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.apply.entity.LenderCondition;

/**
 * 出借特殊情况表 dao层接口实现
 *
 * @author 朱道灵
 */
@Component
public class LenderConditionDaoImpl extends BaseDaoImpl<LenderCondition> implements ILenderConditionDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderConditionDaoImpl.class);

    @Override
    public List<LenderCondition> queryByParam(Long applyId) {
        Assert.notNull("Apply id must not be null", applyId);
        LOG.info("Apply id[{}]", applyId);
        return dalClient.queryForList("lenderCondition.queryByApply", MapUtils.getParamMap("applyId", applyId),
                LenderCondition.class);
    }

    @Override
    public void del(Long id) {
        update(id, null, WMSConstants.DELETED);
    }

    @Override
    public void del(Long di, Integer category) {
        update(di, category, WMSConstants.DELETED);
    }

    @Override
    public void update(Long id, Integer category, String status) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("lenderApplyId", id);
        param.put("dataStatus", status);
        param.put("lenderConditionCategory", category);
//        Assert.notNull("Update condition error",
                dalClient.execute("lenderCondition.setDataStatusByLenderApplyId", param);
    }

}
