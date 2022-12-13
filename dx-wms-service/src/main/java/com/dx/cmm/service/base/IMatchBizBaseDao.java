/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: IMatchBizBaseDao.java
 * Author:   蔡登勇
 * Date:     2015年7月26日 下午12:33:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.base;

import java.util.List;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 匹配业务基础Dao<br>
 * 匹配业务基础Dao
 *
 * @author tony
 */
public interface IMatchBizBaseDao extends IBaseDao<MatchBizBase> {

    /**
     * 
     * 功能描述: <br>
     * 根据业务编号及类型筛选
     *
     * @param bizId
     * @param type
     * @return
     */
    MatchBizBase query(Long bizId, Class<?> type);

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
     * 根据状态筛选
     *
     * @param status
     * @return
     */
    List<MatchBizBase> queryArray(BizBaseStatus... status);

    /**
     * 
     * 功能描述: <br>
     * 根据端口及状态筛选
     *
     * @param port
     * @param isExe
     * @param status
     * @return
     */
    List<MatchBizBase> queryArray(Integer port, Boolean isExe, BizBaseStatus... status);

    /**
     * 
     * 功能描述: <br>
     * 根据类型、执行及状态筛选
     *
     * @param type
     * @param isExe
     * @param status
     * @return
     */
    List<MatchBizBase> queryArray(Class<?> type, Boolean isExe, BizBaseStatus... status);

}
