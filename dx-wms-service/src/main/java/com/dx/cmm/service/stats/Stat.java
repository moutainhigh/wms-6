package com.dx.cmm.service.stats;

import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 统计
 *
 * @author tony
 */
public interface Stat<R> {

    /**
     * 
     * 统计
     *
     * @return
     */
    List<R> stat();

    /**
     * 
     * 统计
     *
     * @param page
     * @return
     */
    PaginationResult<List<R>> stat(Pagination page);
}
