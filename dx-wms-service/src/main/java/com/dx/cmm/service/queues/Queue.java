package com.dx.cmm.service.queues;

import java.util.List;
import java.util.Map;

import com.dx.cmm.service.common.QueryService;
import com.dx.cmm.service.stats.Stat;

/**
 * 
 * 队列器
 *
 * @author tony
 */
public interface Queue extends QueryService<ParamQueue, ResultQueue>, Stat<Map<String,Object>> {

    /**
     * 
     * 加入队列
     *
     * @param items
     * @return
     */
    ExeQueue join(List<ResultQueue> items);

}
