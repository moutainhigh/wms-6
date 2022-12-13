package com.dx.cmm.service.queues;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.enums.BizCategory;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.credit.Credit;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.users.MatchUser;
import com.dx.cmm.service.users.User;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.annotation.Transactional;

@Service
public class CreditQueue extends QueueRegister {

    @Autowired
    private Pools<CreditorPool> creditPool;

    @Autowired
    private User<CreditorPool> creditUser;

    @Autowired
    private Calc<CreditorPool, Boolean> creditRemainCalc;

    @Override
    public String init(ParamQueue param, Model model) {
        model.addAttribute("products", productService.getProductByApp(Credit.APP));
        return "/match_queue/credit_list";
    }

    @Override
    public Boolean supports(ParamQueue param) {
        return Assert.equals(param.getBiz(), BizCategory.CREDIT);
    }

    @Override
    public ExeQueue join(List<ResultQueue> items) {
        if (!Assert.checkParam(items)) {
            return new ExeQueue();
        }
        ExeQueue exe = new ExeQueue(items.size());
        for (ResultQueue item : items) {
            try {
                exe.total(item);
                execute(new CreditorPool());
                exe.success(item);
            } catch (QueueException e) {
                LOG.error("exception:{}", e);
                exe.error(item);
            }
        }
        return exe;
    }

    @Transactional
    private void execute(CreditorPool pool) throws QueueException {
        // if (!creditPool.exist(pool.getMatchBizBaseId())) {
        // MatchUser user = creditUser.query(pool);
        // pool.setMatchUserId(user.getMatchUserId());
        // pool.insert(ruler);
        creditPool.save(pool);
        creditRemainCalc.calc(pool);
        matchBizBaseService.save(pool.getMatchBizBaseId(), BizBaseStatus.CREATED);
        // }
    }

    @Override
    public PaginationResult<List<ResultQueue>> query(ParamQueue param, Pagination page) {
        return dalClient.queryForList("queue.queryParamPage", MapUtils.obj2Map(param), ResultQueue.class, page);
    }

}
