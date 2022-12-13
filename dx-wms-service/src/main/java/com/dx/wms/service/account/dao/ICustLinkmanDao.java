package com.dx.wms.service.account.dao;

import com.dx.wms.common.IBaseDao;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.exception.SaveException;

/**
 * 
 * 联系人信息Dao
 *
 * @author tony
 */
public interface ICustLinkmanDao extends IBaseDao<CustLinkman> {

    /**
     * 
     * 根据账户编号查询
     *
     * @param accountId
     * @return
     */
    CustLinkman queryByParam(Long accountId);

    /**
     * 
     * 保存
     *
     * @param entity
     * @return
     */
    CustLinkman save(CustLinkman entity) throws SaveException;

}
