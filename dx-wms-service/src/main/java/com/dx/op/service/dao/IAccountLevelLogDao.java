package com.dx.op.service.dao;

import com.dx.cmm.exception.SaveException;
import com.dx.op.service.entity.AccountLevelLog;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IAccountLevelLogDao extends IBaseDao<AccountLevelLog> {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param log
     * @throws SaveException 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void save(AccountLevelLog log) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param custCode
     * @param isCurrent
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    AccountLevelLog queryByParam(String custCode, Boolean isCurrent);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param log
     * @param isCurrent
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean update(AccountLevelLog log, Boolean isCurrent);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @throws SaveException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void update() throws SaveException;
}
