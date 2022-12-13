package com.dx.wms.service.account.dao;

import com.dx.wms.common.IBaseDao;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.exception.SaveException;

/**
 * 客户通讯表 dao 层 接口
 * 
 * @author 王蕊
 */
public interface ICustCommDao extends IBaseDao<CustComm> {
    /**
     * 
     * 根据账户编号查询
     *
     * @param accountId
     */
    CustComm queryByParam(Long accountId);

    /**
     * 
     * 保存
     *
     * @param entity
     * @return
     */
    CustComm save(CustComm entity) throws SaveException;

}
