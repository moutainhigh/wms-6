/*
 * Copyright (C), 2013-2013, 达信财富投资管理（上海）有限公司
 * FileName: BaseDao.java
 * Author:   v_caidengy
 * Date:     2013年11月21日 下午2:37:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.common;

import java.io.Serializable;
import java.util.List;

/**
 * DAO基类接口: <br>
 * 为所有Dao层提供通用CRUD接口<br>
 * 比如insert,update,remove,queryById等
 * 
 * @author v_caidengy
 * @param <T> 泛型
 * @see com.saic.am.common.dao.impl.BaseDaoImpl
 * @since V1.0
 */
public interface IBaseDao<T extends Serializable> {

    /**
     * 功能描述: <br>
     * 新增实体
     * 
     * @param entity 实体信息
     * @return 返回主健ID
     * @since V1.0
     */
    long insert(T entity);

    /**
     * 功能描述:<br>
     * 更新实体
     * 
     * @param entity 实体信息
     * @return 返回结果
     * @since V1.0
     */
    boolean update(T entity);

    /**
     * 功能描述: <br>
     * 删除单一实体
     * 
     * @param entityclass 实体信息
     * @param id 实体信息
     * @return 返回结果
     * @since V1.0
     */
    boolean removeById(Class<T> entityclass, long id);

    /**
     * 功能描述: <br>
     * 查询操作，传入对象id，对象class
     * 
     * @param entityClass 对象class
     * @param id 对象主键
     * @param <T> 泛型
     * @return 返回结果
     * @since V1.0
     */
    <T> T queryById(Class<T> entityClass, long id);

    /**
     * 功能描述:<br>
     * 查询所有实体
     * 
     * @param entityClass 对象class
     * @param <T> 泛型
     * @return 返回结果
     * @since V1.0
     */
   <T> List<T> queryAll(Class<T> entityClass);

}
