package com.dx.cmm.service.funds;

import java.util.Date;
import java.util.List;

import com.dx.cmm.exception.SaveException;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 债权资金Dao
 *
 * @author tony
 */
public interface ICreditorFundDao extends IBaseDao<CreditorFund> {

    /**
     * 
     * 功能描述: <br>
     * 保存
     *
     * @param fund
     */
    void save(CreditorFund fund) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 更新
     *
     * @param fund
     * @param isCurrent
     * @return
     */
    Boolean update(CreditorFund fund, Boolean isCurrent);

    /**
     * 
     * 功能描述: <br>
     * 根据债权池编号筛选
     * 
     * @param poolId
     * @return
     */
    List<CreditorFund> queryArray(Long poolId);

    /**
     * 
     * 功能描述: <br>
     * 根据债权池编号及当前期数筛选
     *
     * @param poolId
     */
    CreditorFund query(Long poolId, Integer currentPeriod);

    /**
     * 
     * 功能描述: <br>
     * 根据债权池编号及报告日筛选
     *
     * @param poolId
     * @param reportDay
     * @return
     */
    CreditorFund query(Long poolId, Date reportDay);

    /**
     * 功能描述: <br>
     * 根据债权池编号筛选最新资金
     *
     * @param poolId
     */
    CreditorFund query(Long poolId);

}
