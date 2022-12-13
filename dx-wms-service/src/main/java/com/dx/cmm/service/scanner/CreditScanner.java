package com.dx.cmm.service.scanner;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.funds.CreditorFund;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

@Service("creditScanner")
public class CreditScanner extends ScannerAbs {

    @Override
    public void scanner() {
        List<CreditorPool> pools = creditPool.queryAll();
        for (CreditorPool pool : pools) {
            List<CreditorFund> funds = creditFund.queryArray(pool.getCreditorPoolId());
            if (!Assert.equals(pool.getInitPeriod() - pool.getRemainPeriod(), funds.size())) {
                LOG.error("Pool id[] fund condition error", pool.getCreditorPoolId());
                throw new BaseException();
            }
            Integer currentPeriod = 1;
            BigDecimal totalAmount = pool.getInitTotalAmount();
            for (CreditorFund fund : funds) {
                if (!Assert.equals(currentPeriod, fund.getCurrentPeriod())) {
                    LOG.error("Pool id[{}] miss period[{}]", pool.getCreditorPoolId(), currentPeriod);
                    throw new BaseException();
                }
                if (!Assert.equals(totalAmount, fund.getLastTotalAmount())) {
                    LOG.error("Pool id[{}][{}] , fund id[{}][{}] total amount error [{}]", pool.getCreditorPoolId(),
                            totalAmount, fund.getCreditorFundId(), fund.getLastTotalAmount(),
                            totalAmount.subtract(fund.getLastTotalAmount()));
                    throw new BaseException();
                }
                if (!Assert.equals(pool.getInitEaBillAmount(), fund.getLastRepaymentAmount())) {
                    LOG.error("Pool id[{}][{}], fund id[{}][{}] bill error", pool.getCreditorPoolId(),
                            pool.getInitEaBillAmount(), fund.getCreditorFundId(), fund.getLastRepaymentAmount());
                    throw new BaseException();
                }
                BigDecimal interest = pool.getRateMonth().multiply(fund.getLastTotalAmount()).setScale(2,
                        BigDecimal.ROUND_HALF_UP);
                if (!Assert.equals(interest, fund.getLastRepaymentInterestAmount())) {
                    LOG.error("Pool id[{}][{}] , fund id[{}][{}] interest error [{}]", pool.getCreditorPoolId(),
                            interest, fund.getCreditorFundId(), fund.getLastRepaymentInterestAmount(),
                            interest.subtract(fund.getLastRepaymentInterestAmount()));
                    throw new BaseException();
                }
                BigDecimal princal = pool.getInitEaBillAmount().subtract(interest);
                if (!Assert.equals(princal, fund.getLastRepaymentPrincalAmount())) {
                    LOG.error("Pool id[{}][{}] , fund id[{}][{}] interest error [{}]", pool.getCreditorPoolId(),
                            princal, fund.getCreditorFundId(), fund.getLastRepaymentPrincalAmount(),
                            princal.subtract(fund.getLastRepaymentPrincalAmount()));
                    throw new BaseException();
                }
                if (!Assert.equals(pool.getInitEaBillAmount(),
                        fund.getLastRepaymentInterestAmount().add(fund.getLastRepaymentPrincalAmount()))) {
                    LOG.error("Pool id[{}][{}], fund id[{}][{}]+[{}]=[{}] bill error", pool.getCreditorPoolId(),
                            pool.getInitEaBillAmount(), fund.getCreditorFundId(), fund.getLastRepaymentInterestAmount(),
                            fund.getLastRepaymentPrincalAmount(),
                            fund.getLastRepaymentInterestAmount().add(fund.getLastRepaymentPrincalAmount()));
                    throw new BaseException();
                }
                totalAmount = totalAmount.subtract(fund.getLastRepaymentPrincalAmount());
                currentPeriod++;
            }
        }
    }

}
