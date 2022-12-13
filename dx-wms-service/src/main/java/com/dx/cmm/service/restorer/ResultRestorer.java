package com.dx.cmm.service.restorer;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.results.IMatchResultDao;
import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;

@Service("resultRestorer")
public class ResultRestorer extends RestorerAbs<List<MatchResult>> {

    @Autowired
    private IMatchResultDao matchResultDao;

    @Override
    @Transactional
    public void repair(List<MatchResult> results) throws RepairException {
        CreditorPool pool = null;
        BigDecimal currentTotalAmount = BigDecimal.ZERO;
        BigDecimal totalInterest = BigDecimal.ZERO;
        BigDecimal totalCapital = BigDecimal.ZERO;
        BigDecimal totalRepay = BigDecimal.ZERO;
        BigDecimal interest = BigDecimal.ZERO;
        BigDecimal capital = BigDecimal.ZERO;
        BigDecimal rate = BigDecimal.ZERO;
        Integer index = 0;
        for (MatchResult result : results) {
            if (!Assert.checkParam(pool)) {
                pool = creditPool.query(result.getCreditorPoolId());
                interest = pool.getCurrentTotalAmount().multiply(pool.getRateMonth()).setScale(2,
                        BigDecimal.ROUND_HALF_UP);
                capital = pool.getInitEaBillAmount().subtract(interest);
            }
            if (Assert.checkParam(result.getCreateUser())) {
                if (Assert.equals(index, results.size() - 1)
                        && Assert.equals(pool.getCurrentUndoAmount(), BigDecimal.ZERO)) {
                    result.setTransferEaInterestAmount(interest.subtract(totalInterest));
                    result.setCreditorRate(BigDecimal.ONE.subtract(rate));
                    result.setTransferEaAmount(pool.getInitEaBillAmount().subtract(totalRepay));
                    result.setTransferEaCapitalAmount(capital.subtract(totalCapital));
                } else {
                    result.setTransferEaInterestAmount(result.getTransferTotalAmount().multiply(pool.getRateMonth())
                            .setScale(2, BigDecimal.ROUND_HALF_UP));
                    result.setCreditorRate(result.getTransferTotalAmount().divide(pool.getCurrentTotalAmount(), 15,
                            BigDecimal.ROUND_HALF_UP));
                    result.setTransferEaAmount(pool.getInitEaBillAmount().multiply(result.getCreditorRate()).setScale(2,
                            BigDecimal.ROUND_HALF_UP));
                    result.setTransferEaCapitalAmount(
                            result.getTransferEaAmount().subtract(result.getTransferEaInterestAmount()));
                }
                result.setUpdateTime();
                if (!matchResultDao.update(result)) {
                    throw new RepairException("Pool id[{}],result id[{}] update error", pool.getCreditorPoolId(),
                            result.getMatchResultId());
                }
            }
            rate = rate.add(result.getCreditorRate());
            currentTotalAmount = currentTotalAmount.add(result.getTransferTotalAmount());
            totalInterest = totalInterest.add(result.getTransferEaInterestAmount());
            totalCapital = totalCapital.add(result.getTransferEaCapitalAmount());
            totalRepay = totalRepay.add(result.getTransferEaAmount());
            index++;
        }

    }

}
