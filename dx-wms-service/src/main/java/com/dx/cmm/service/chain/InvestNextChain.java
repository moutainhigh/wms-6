package com.dx.cmm.service.chain;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.funds.Funds;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.income.Incomes;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.template.CallBackTemplate;

@Service("investNextChain")
public class InvestNextChain extends BatchChain {

    @Autowired
    private Pools<InvestmentPool> investPool;

    @Autowired
    private Funds<InvestmentFund> investFund;

    @Autowired
    private Calc<InvestmentFund, BigDecimal> investIncomeCalc;

    @Autowired
    private Calc<InvestmentPool, BigDecimal> accountFeeCalc;

    @Autowired
    private Incomes<InvestmentFund> acountFeeIncome;

    @Autowired
    private Calc<InvestmentFund, BigDecimal> totalTransCalc;

    @Override
    public void next(Integer port) throws ChainExecption {
        LOG.info("Invest next chain[{}] startup", port);
        final List<InvestmentPool> pools = investPool.queryArray(port, MatchStatus.SUCCESS);
        LOG.info("Invests[{}] need to next", pools.size());
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                for (InvestmentPool pool : pools) {
                    if (!Assert.checkParam(pool.getProductId())) {
                        throw new ChainExecption("Pool[{0}] must has product", pool.getInvestmentPoolId());
                    }
                    LOG.info("Pool[{}] product[{}] execute next", pool.getInvestmentPoolId(), pool.getProductId());
                    InvestmentFund fund = investFund.query(pool.getInvestmentPoolId());
                    if (!Assert.checkParam(fund)) {
                        throw new ChainExecption("Pool[{0}] not found fund", pool.getInvestmentPoolId());
                    }
                    BigDecimal accountFee = accountFeeCalc.calc(pool);
                    fund.setProductId(pool.getProductId());
                    fund.setAccountManagementFee(accountFee);
                    acountFeeIncome.inject(fund);
                    BigDecimal income = investIncomeCalc.calc(fund);
                    fund.setLenderIncomeAmount(income);
                    investFund.save(fund);
                    fund.nextCurrentPeriod();
                    pool.next(fund.getNextTransferTotalAmount(), accountFee, income, totalTransCalc.calc(fund));
                    investPool.save(pool);
                }
                return true;
            }
        });

        if (Assert.checkParam(getNext())) {
            getNext().next(port);
        }
    }

}
