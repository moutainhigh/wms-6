package com.dx.cmm.service.queues;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.enums.BizCategory;
import com.dx.cmm.service.invest.Invest;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.users.MatchUser;
import com.dx.cmm.service.users.User;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.annotation.Transactional;

@Service
public class InvestQueue extends QueueRegister implements Invest<InvestmentPool> {

    @Autowired
    private Pools<InvestmentPool> investPool;

    @Autowired
    private User<InvestmentPool> investUser;

    @Override
    public String init(ParamQueue param, Model model) {
        model.addAttribute("products", productService.getProductByApp(Invest.APP));
        return "/match_queue/invest_list";
    }

    @Override
    public Boolean supports(ParamQueue param) {
        return Assert.equals(param.getBiz(), BizCategory.INVEST);
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
                execute(new InvestmentPool());
                exe.success(item);
            } catch (QueueException e) {
                LOG.error("exception:{}", e.getMessage());
                exe.error(item);
            }
        }
        return exe;
    }

    @Transactional
    private void execute(InvestmentPool pool) throws QueueException {
        // if (!investPool.exist(pool.getMatchBizBaseId())) {
        // MatchUser user = investUser.query(pool);
        // pool.setMatchUserId(user.getMatchUserId());
        // pool.insert(ruler);
        investPool.save(pool);
        matchBizBaseService.save(pool.getMatchBizBaseId(), BizBaseStatus.CREATED);
        // }
    }

    @Override
    public PaginationResult<List<ResultQueue>> query(ParamQueue param, Pagination page) {
        return dalClient.queryForList("queue.queryParamPage", MapUtils.obj2Map(param), ResultQueue.class, page);
    }

}
