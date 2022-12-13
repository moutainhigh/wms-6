/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: IMatchBizBaseDao.java
 * Author:   蔡登勇
 * Date:     2015年7月26日 下午12:33:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.dao;

import java.util.List;

import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.wms.base.IBaseDao;

/**
 * 匹配业务基础表Dao
 *
 * @author 蔡登勇
 */
public interface IMatchBizBaseDao extends IBaseDao<MatchBizBase> {

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号筛选
     *
     * @param poolId
     * @return
     */
    MatchBizBase query(Long poolId);

    /**
     * 
     * 功能描述: <br>
     * 根据业务编号筛选
     *
     * @param bizCode
     * @return
     */
    MatchBizBase query(String bizCode);

    /**
     * 
     * 功能描述: <br>
     * 根据业务客户编号筛选
     *
     * @param bizCustCode
     * @return
     */
    List<MatchBizBase> queryArray(String bizCustCode);

}
