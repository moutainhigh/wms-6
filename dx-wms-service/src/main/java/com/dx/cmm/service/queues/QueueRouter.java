package com.dx.cmm.service.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dx.cmm.service.observer.ObserverUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

@Service
public class QueueRouter implements QueueObserver {

    private List<Queue> queues = new ArrayList<Queue>();

    @Override
    public void regist(Queue queue) {
        queues.add(queue);
    }

    @Override
    public PaginationResult<List<ResultQueue>> query(ParamQueue param, Pagination page) {
        for (Queue queue : queues) {
            if (queue.supports(param)) {
                return queue.query(param, page);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public String init(ParamQueue param, Model model) {
        for (Queue queue : queues) {
            if (queue.supports(param)) {
                return queue.init(param, model);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public ExeQueue join(ParamQueue param, List<ResultQueue> items) {
        for (Queue queue : queues) {
            if (queue.supports(param)) {
                synchronized (items) {
                    return queue.join(items);
                }
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public PaginationResult<List<Map<String, Object>>> stat(ParamQueue param, Pagination page) {
        for (Queue queue : queues) {
            if (queue.supports(param)) {
                return queue.stat(page);
            }
        }
        throw ObserverUtils.error();
    }

}
