package com.dx.cmm.service.credit;

import java.util.Date;
import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface ICreditService {

    /**
     * 
     * 功能描述: <br>
     * 根据日期筛选
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<CreditStatResult>> queryStat(CreditStatParam param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 根据姓名、身份证、合同编号、还款日及日期筛选
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<CreditPoolResult>> queryPool(CreditPoolParam param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 根据出借编号筛选
     *
     * @param lenderCode
     * @return
     */
    List<CreditMatchResult> queryLenderFirst(String lenderCode);

    /**
     * 
     * 功能描述: <br>
     * 根据出借编号及当前期限筛选
     *
     * @param lenderCode
     * @param currentPeriod
     * @return
     */
    List<CreditMatchResult> queryLender(String lenderCode, Integer currentPeriod);

    /**
     * 
     * 功能描述: <br>
     * 根据端口筛选异常债权
     *
     * @param port
     * @return
     */
    List<CreditExpResult> queryExp(Integer port);

    /**
     * 
     * 功能描述: <br>
     * 根据还款日统计
     *
     * @return
     */
    List<CreditStatDetailResult> queryCurrent();

    /**
     * 
     * 功能描述: <br>
     * 根据日期统计
     *
     * @param date
     * @return
     */
    List<CreditStatDetailResult> queryDetail(Date date);
}
