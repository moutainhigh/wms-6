/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: MathSignTypeDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月28日 下午10:07:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.math.service.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.MapUtils;
import com.dx.framework.exception.BaseException;
import com.dx.math.service.dao.IMathSignTypeDao;
import com.dx.math.service.entity.MathSignType;
import com.dx.wms.common.BaseDaoImpl;

/**
 * 债权匹配管理-符号类型对象 dao层 接口实现
 *
 * @author 朱道灵
 */
@Service
public class MathSignTypeDaoImpl extends BaseDaoImpl<MathSignType> implements IMathSignTypeDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(MathSignTypeDaoImpl.class);

    
    @Override
    public MathSignType getBySignKey(String signKey) {
        if (StringUtils.isBlank(signKey)) {
            LOG.error("getBySignKey() signKey is null");
            throw new BaseException("signKey is null");
        }
        return dalClient.queryForObject("mathSignType.getBySignKey", MapUtils.getParamMap("signKey", signKey),
                MathSignType.class);
    }

}
