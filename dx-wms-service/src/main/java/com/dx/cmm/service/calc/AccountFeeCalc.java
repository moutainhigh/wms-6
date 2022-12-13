package com.dx.cmm.service.calc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.Funds;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.users.MatchUser;
import com.dx.cmm.service.users.User;
import com.dx.common.service.utils.Assert;
import com.dx.op.dto.AccountInfoDto;
import com.dx.op.service.IAccountInfoService;
import com.dx.op.service.product.Product;
import com.google.gson.Gson;

/**
 * 
 * 账户管理费运算
 *
 * @author tony
 */
@Service("accountFeeCalc")
public class AccountFeeCalc extends CalcAbs<InvestmentPool, BigDecimal> {

    private static final Integer ONE = 1;

    private static final Long L007 = 34L;
    @Autowired
    private Calc<InvestmentPool, BigDecimal> l007IncomeCalc;
    
    @Autowired
    private IAccountInfoService accountInfoService;

    @Autowired
    private Product<InvestmentPool> investProduct;

    @Autowired
    private User<InvestmentPool> investUser;
    
    @Autowired
    private Funds<InvestmentFund> investFund;

    @Override
    public BigDecimal calc(InvestmentPool pool) throws CalcException {
        if (!Assert.checkParam(pool)) {
            LOG.error("Pool must not be null");
            throw new CalcException("Pool must not be null");
        }
        if (!Assert.checkParam(pool.getMatchUserId()) || !Assert.checkParam(pool.getProductId())
                || !Assert.checkParam(pool.getCurrentTotalAmount()) || !Assert.checkParam(pool.getCurrentPeriod())) {
            LOG.error("Pool[{}] user[{}] or product[{}] or current total[{}] or current period[{}] must not be null",
                    pool.getInvestmentPoolId(), pool.getMatchUserId(), pool.getProductId(),
                    pool.getCurrentTotalAmount(), pool.getCurrentPeriod());
        }

        if (Assert.equals(pool.getProductId(), L007)) {
        	InvestmentFund fund = investFund.query(pool.getInvestmentPoolId());
            return fund.getNextInterestTotalAmount().subtract(l007IncomeCalc.calc(pool));
        }
        if (investProduct.isFix(pool) || Assert.equals(pool.getCurrentPeriod(), ONE)) {
            return BigDecimal.ZERO;
        }
        MatchUser user = investUser.query(pool.getMatchUserId());
        if (!Assert.checkParam(user)) {
            throw new CalcException("Pool[{0}] user[{1}] not found user", pool.getInvestmentPoolId(),
                    pool.getMatchUserId());
        }
        AccountInfoDto account = accountInfoService.query(user.getMatchCustCode(), pool.getVersionKey());
        if (!Assert.checkParam(account)) {
            throw new CalcException("User[{0}] not found account", user.getMatchCustCode());
        }
        LOG.info("Pool[{}],account[{}]", new Gson().toJson(pool), new Gson().toJson(account));
        return pool.getCurrentTotalAmount().multiply(account.getRate()).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
