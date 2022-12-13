package com.dx.cmm.service.back;

import java.util.List;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 匹配回款服务
 *
 * @author tony
 */
public interface IMatchBackService {
    
    /**
     * 
     * 功能描述:往期回款查询
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<BackUsualResult>> queryUsual(BackUsualParam param, Pagination page);

    

    /**
     * 
     * 功能描述:到期回款查询
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<BackTransResult>> queryTrans(BackTransParam param, Pagination page);

    
}
