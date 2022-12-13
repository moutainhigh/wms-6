package com.dx.cmm.service.funds;

import java.util.List;

import com.dx.wms.common.IBaseDao;

/**
 * 
 * 投资资金Dao
 *
 * @author tony
 */
public interface IInvestmentFundDao extends IBaseDao<InvestmentFund> {

    /**
     * 
     * 保存
     *
     * @param fund
     * @return
     */
    Boolean save(InvestmentFund fund);

    /**
     * 
     * 更新
     *
     * @param fund
     * @param isCurrent
     * @return
     */
    Boolean update(InvestmentFund fund, Boolean isCurrent);

    /**
     * 
     * 查询
     *
     * @param poolId
     * @param isCurrent
     * @return
     */
    InvestmentFund query(Long poolId);

    /**
     * 
     * 查询
     *
     * @param poolId
     * @param period
     * @return
     */
    InvestmentFund query(Long poolId, Integer period);

    /**
     * 
     * 查询
     *
     * @param sqlId
     * @return
     */
    List<InvestmentFund> queryArray(String sqlId);

    /**
     * 
     * 查询
     *
     * @param poolId
     * @return
     */
    List<InvestmentFund> queryArray(Long poolId);
}
