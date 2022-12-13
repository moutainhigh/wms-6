package com.dx.cmm.service.view;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.dto.CreditAttr;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.MonthParamCalc;
import com.dx.cmm.service.calc.ResultIntParamCalc;
import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;

@Service("firstTransView")
public class FirstTransView extends ViewAbs<FirstViewResult> {

    private static final String INVEST = "firstView.queryInvest";

    private static final String CREDIT = "firstView.queryCredit";

    private static final String KEY = "match:view:first:";
    @Autowired
    private Calc<ResultIntParamCalc, BigDecimal> resultIntSuccessCalc;

    @Autowired
    private Calc<MonthParamCalc, Integer> monthCalc;

    @Autowired
    private ICacheService<FirstViewResult> cacheService;

    @Override
    public FirstViewResult query(String lenderCode, Boolean isEffect) {
        if (!Assert.checkParam(lenderCode)) {
            LOG.error("Lender code must not be null");
            return new FirstViewResult();
        }
        LOG.info("Lender code[{}] first request", lenderCode);
        String key = isEffect ? cacheService.initKey(KEY, "effect:", lenderCode) : cacheService.initKey(KEY, lenderCode);
        FirstViewResult result = cacheService.getObject(key, FirstViewResult.class);
        if (Assert.checkParam(result)) {
            return result;
        }
        result = dalClient.queryForObject(INVEST, MapUtils.getParamMap("lenderCode", lenderCode),
                FirstViewResult.class);
        result.matchTime();
        if(isEffect){
        	result.setInitMatchTime(result.getEffectTime());
        }
        List<CreditViewResult> results = dalClient.queryForList(CREDIT,
                MapUtils.getParamMap("poolId", result.getPoolId()), CreditViewResult.class);
        BigDecimal interest = BigDecimal.ZERO;
        BigDecimal capital = BigDecimal.ZERO;
        Integer index = 1;
        for (CreditViewResult credit : results) {
            interest = interest
                    .add(resultIntSuccessCalc.calc(new ResultIntParamCalc(new MatchResult(1, credit.getTransInterest()),
                            isEffect ? result.getEffectTime() : result.getInitMatchTime(), result.getBillDay())));
            capital = capital.add(credit.getTransCapital());
            CreditAttr attr = credit(credit.getAttr());
            Integer months = monthCalc.calc(new MonthParamCalc(credit.getRepayDate(), result.getInitBillDate())) - 1;
            credit.parse(index, attr, months);
            index++;
        }
        result.parse(capital, interest, productService, results);
        cacheService.set(key, result);
        return result;
    }

    private CreditAttr credit(String attr) {
        return Assert.checkParam(attr) ? JSON.parseObject(attr, CreditAttr.class) : new CreditAttr();
    }

}
