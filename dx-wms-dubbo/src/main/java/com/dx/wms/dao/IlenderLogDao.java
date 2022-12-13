package com.dx.wms.dao;

import java.util.List;

import com.dx.wms.base.IBaseDao;
import com.dx.wms.bean.LenderApplyLog;
import com.dx.wms.service.exception.UpdateException;

public interface IlenderLogDao extends IBaseDao<LenderApplyLog> {

    /**
     * 功能描述: <br>
     * 根据申请编号和环节获取日志
     *
     * @param applyId
     * @param step
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApplyLog queryByParam(Long applyId, String step);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param applyId
     * @param step
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApplyLog queryByStep(Long applyId, String step);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param accountId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<LenderApplyLog> query(Long accountId);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param applyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApplyLog queryCurrent(Long applyId);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param applyId
     * @param step
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApplyLog queryCurrent(Long applyId, String step);

    LenderApplyLog queryLast(Long applyId);

    void save(LenderApplyLog current, LenderApplyLog next) throws UpdateException;
}
