package com.dx.cmm.service.chain;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.base.BizBase;
import com.dx.cmm.service.base.IMatchBizBaseDao;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.calc.InvestIntParamCalc;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.common.service.utils.Assert;
import com.dx.op.service.intf.IProductService;
import com.dx.wms.dto.MatchBizBaseDto;

@Service("transTimeChain")
public class TransTimeChain extends Chain {
	
	public static final Long L007 = 34L ;
	
    @Autowired
    private IProductService productService;

    @Autowired
    private Pools<InvestmentPool> investPool;
    
    @Autowired
    private Calc<InvestmentPool, BigDecimal> l007IncomeCalc;
    
    @Autowired
    protected IMatchBizBaseDao matchBizBaseDao;
    
    @Override
    public void next(Object condition) {
        if (Assert.checkParam(condition) && condition instanceof InvestmentPool) {
            InvestmentPool pool = (InvestmentPool) condition;
            MatchBizBaseDto base = matchBizBaseDao.queryById(MatchBizBaseDto.class, pool.getMatchBizBaseId());
            BigDecimal rateMonth = productService.getRateMonth(pool.getProductId(), base.getApplyDate(),pool.getInitTotalAmount());
            BigDecimal rateYear = productService.getRateYear(pool.getProductId(), base.getApplyDate(),pool.getInitTotalAmount());
            BigDecimal firstIncome = BigDecimal.ZERO;
            if(Assert.equals(L007, pool.getProductId())){
            	firstIncome = l007IncomeCalc.calc(pool);
            }
            if (productService.isFix(pool.getProductId())) {
                pool.transFix(rateMonth, rateYear,firstIncome);
            }
            pool.setUpdateTime();
            investPool.save(pool);
        }
        if (Assert.checkParam(getNext())) {
            getNext().next(condition);
        }
    }

}
