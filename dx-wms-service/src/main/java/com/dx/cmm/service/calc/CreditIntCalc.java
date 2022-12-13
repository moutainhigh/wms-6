package com.dx.cmm.service.calc;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 债权利息运算
 *
 * @author tony
 */
@Service("creditIntCalc")
public class CreditIntCalc extends IntCalc<CreditIntParamCalc> {

    @Override
    public BigDecimal calc(CreditIntParamCalc param) {
        CreditorPool pool = param.getPool();
        MatchResult result = param.getResult();
        if ((Assert.checkParam(param.getFund()) && Assert.checkParam(param.getFund().getLastTotalUndoAmount()))
                || Assert.checkParam(pool.getCurrentUndoAmount())) {
            return result.getTransferTotalAmount().multiply(pool.getRateMonth()).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        BigDecimal interest = Assert.checkParam(param.getFund()) ? param.getFund().getLastRepaymentInterestAmount()
                : pool.interest();
        List<MatchResult> results = param.getResults();
        for (MatchResult tmp : results) {
            if (!Assert.equals(tmp.getMatchResultId(), result.getMatchResultId())) {
                interest = interest.subtract(tmp.getTransferEaInterestAmount());
            }
        }
        return interest;
    }

}
