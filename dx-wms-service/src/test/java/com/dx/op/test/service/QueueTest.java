package com.dx.op.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.enums.BizCategory;
import com.dx.cmm.service.queues.ParamQueue;
import com.dx.cmm.service.queues.QueueObserver;
import com.dx.cmm.service.queues.ResultQueue;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.common.test.BaseTest;
import com.google.gson.Gson;

public class QueueTest extends BaseTest {

    @Autowired
    private QueueObserver queue;

    @Test
    public void lender() {
        ParamQueue matchQueueQueryDto = new ParamQueue();
        matchQueueQueryDto.setType(BizCategory.INVEST.getCode());
        Pagination pagination = new Pagination(10, 1);
        PaginationResult<List<ResultQueue>> results = queue.query(matchQueueQueryDto, pagination);
        List<ResultQueue> matchQueueResultDtos = results.getR();
        for (ResultQueue matchQueueResultDto : matchQueueResultDtos) {
            System.out.println(new Gson().toJson(matchQueueResultDto));
        }

    }

    @Test
    public void join() {
        List<ResultQueue> items = new ArrayList<ResultQueue>();
        for (int i = 62; i <= 70; i++) {
            ResultQueue item = new ResultQueue();
            item.setCreateUser(-1L);
            item.setUpdateUser(-1L);
            item.setMatchBizBaseId(new Long(i));
            items.add(item);
        }
        System.out.println(new Gson().toJson(queue.join(new ParamQueue("invest"), items)));
    }

}
