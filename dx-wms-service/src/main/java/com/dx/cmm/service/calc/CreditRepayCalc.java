package com.dx.cmm.service.calc;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;

@Service("creditRepayCalc")
public class CreditRepayCalc extends RepayCalc<RepayParamCalc> {

    @Override
    public BigDecimal calc(RepayParamCalc param) {
        CreditorPool pool = param.getPool();
        MatchResult result = param.getResult();
        if (Assert.checkParam(pool.getCurrentUndoAmount())) {
            return result.getCreditorRate().multiply(pool.getInitEaBillAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        BigDecimal repay = pool.getInitEaBillAmount();
        List<MatchResult> results = param.getResults();
        for (MatchResult tmp : results) {
            if (!Assert.equals(tmp.getMatchResultId(), result.getMatchResultId())) {
                repay = repay.subtract(tmp.getTransferEaAmount());
            }
        }
        return repay;
    }

}
