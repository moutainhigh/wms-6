/*
 * Copyright (C), 2013-2013, 达信财富投资管理（上海）有限公司
 * FileName: BaseDaoImpl.java
 * Author:   v_caidengy
 * Date:     2013年11月21日 下午2:38:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.common;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dx.cmm.service.manager.Router;
import com.dx.common.service.utils.MapUtils;

/**
 * DAO基类<br>
 * 提供各模块DAO的CRUD的基本实现
 * 
 * @author v_caidengy
 * @param <T> 泛型
 * @see com.saic.am.common.dao.IBaseDao
 * @since v1.0
 */
@Repository
public class BaseDaoImpl<T extends Serializable> extends Router<T> implements IBaseDao<T> {

    /**
     * 日志组件
     */
    protected static final Logger LOG = LoggerFactory.getLogger(BaseDaoImpl.class);

    @Override
    public long insert(T entity) {
        return dalClient.persist(entity).longValue();
    }

    @Override
    public boolean update(T entity) {
        return dalClient.merge(entity) == 1 ? true : false;
    }

    @Override
    public boolean removeById(Class<T> entityclass, long id) {
        T entity = (T) queryById(entityclass, id);
        if (entity == null) {
            return false;
        }
        return dalClient.remove(entity) == 1 ? true : false;
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T queryById(Class<T> entityClass, long id) {
        String sclass = entityClass.getSimpleName();
        String classname = sclass.substring(0, 1).toLowerCase() + sclass.substring(1);
        return dalClient.queryForObject(classname + ".queryById", MapUtils.getParamMap("id", id), entityClass);
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> List<T> queryAll(Class<T> entityClass) {
        String sclass = entityClass.getSimpleName();
        String classname = sclass.substring(0, 1).toLowerCase() + sclass.substring(1);
        return dalClient.queryForList(classname + ".queryAll", null, entityClass);
    }
}
