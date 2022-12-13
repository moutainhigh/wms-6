/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICustAccountDao.java
 * Author:   王蕊
 * Date:     2015年7月20日 下午7:18:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.account.dao;

import com.dx.wms.common.IBaseDao;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.detail.DetailType;
import com.dx.wms.service.exception.SaveException;

/**
 * 
 * 账户信息Dao
 *
 * @author tony
 */
public interface ICustAccountDao extends IBaseDao<CustAccount> {

    /**
     * 
     * 根据编号更新客户编号及状态
     *
     * @param id
     * @param code
     * @param status
     * @return
     */
    Boolean update(Long id, String code, String status);

    /**
     * 
     * 保存
     *
     * @param entity
     * @return
     */
    CustAccount save(CustAccount entity) throws SaveException;

    /**
     * 
     * 根据客户编号查询
     *
     * @param code
     * @return
     */
    CustAccount queryByParam(String code);
    
    /**
     * 
     * 根据客户编号查询
     *
     * @param code
     * @return
     */
    CustAccount queryByCode(String CustCode);

    /**
     * 
     * 根据编号查询
     *
     * @param param
     * @return
     */
    CustAccount queryByParam(Long id, DetailType detail);

}
