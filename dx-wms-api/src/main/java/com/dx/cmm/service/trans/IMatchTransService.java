package com.dx.cmm.service.trans;

import java.util.Date;
import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface IMatchTransService {
    /**
     * 
     * 功能描述: <br>
     * 根据日期筛选
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<TransStatResult>> queryStat(TransStatParam param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 根据日期统计
     *
     * @param date
     * @return
     */
    List<TransStatDetailResult> queryDetail(Date date);
}
