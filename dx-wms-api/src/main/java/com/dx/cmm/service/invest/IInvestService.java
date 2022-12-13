package com.dx.cmm.service.invest;

import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.exception.UpdateException;

/**
 * 
 * 投资服务
 *
 * @author tony
 */
public interface IInvestService {

    /**
     * 
     * 功能描述: <br>
     * 根据出借编号筛选
     *
     * @param lenderCode
     * @return
     */
    InvestResult query(String lenderCode);

    /**
     * 
     * 功能描述: <br>
     * 根据身份证、出借编号及首次匹配日期筛选
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<InvestResult>> queryPool(InvestPoolParam param, Pagination page);
    
    /**
     * 
     * 功能描述: <br>
     * 根据身份证、出借编号及匹配日期筛选查询匹配生效
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<InvestResult>> queryMatching(InvestPoolParam param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 根据统计条件筛选
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<InvestStatResult>> queryStat(InvestStatParam param, Pagination page);
    
    /**
     * 
     * 功能描述: 根据产品信息筛选
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<InvestUpdateResult>> queryProduct(InvestUpdateParam param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号变更产品
     *
     * @param poolId
     * @throws UpdateException
     */
    void updateProduct(Long poolId) throws UpdateException;

}
