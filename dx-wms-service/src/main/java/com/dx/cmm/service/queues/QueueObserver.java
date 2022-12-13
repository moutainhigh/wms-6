package com.dx.cmm.service.queues;

import java.util.List;
import java.util.Map;

import com.dx.cmm.service.observer.QueryObserver;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 队列观察者
 *
 * @author tony
 */
public interface QueueObserver extends QueryObserver<Queue, ParamQueue, ResultQueue> {

    /**
     * 
     * 加入队列
     *
     * @param param
     * @param items
     * @return
     */
    ExeQueue join(ParamQueue param, List<ResultQueue> items);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param param
     * @param page
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<Map<String, Object>>> stat(ParamQueue param, Pagination page);

}
