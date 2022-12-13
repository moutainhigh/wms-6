package com.dx.wms.service.account.dao;

import com.dx.wms.common.IBaseDao;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.exception.SaveException;

/**
 * 
 * 职业信息Dao
 *
 * @author tony
 */
public interface ICustProfessionDao extends IBaseDao<CustProfession> {

    /**
     * 
     * 根据账户编号查询
     *
     * @param accountId
     * @return
     */
    CustProfession queryByParam(Long accountId);

    /**
     * 
     * 保存
     *
     * @param entity
     * @return
     */
    CustProfession save(CustProfession entity) throws SaveException;
}
