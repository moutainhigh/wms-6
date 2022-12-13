package com.dx.wms.dao;

import com.dx.wms.base.IBaseDao;
import com.dx.wms.bean.CustBase;

public interface ICustBaseDao extends IBaseDao<CustBase> {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param custCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    CustBase query(String custCode);
}
