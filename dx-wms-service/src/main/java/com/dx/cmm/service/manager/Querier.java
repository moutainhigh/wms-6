package com.dx.cmm.service.manager;

import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 查询器
 *
 * @author tony
 */
public interface Querier<P, R> {
    /**
     * 
     * 查询
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<R>> query(P param, Pagination page);
}
