package com.dx.cmm.service.sync;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.base.IMatchBizBaseDao;
import com.dx.cmm.service.calc.Calc;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.template.CallBackTemplate;
import com.dx.wms.dto.MatchBizBaseDto;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.enums.PushCode;
import com.dx.wms.service.push.ILenderPushService;

@Service("transTimeSync")
public class TransTimeSync extends SyncAbs {
	
	public static final Long L007 = 34L ;
	
    @Autowired
    private ILenderPushService lenderPushService;
    
    @Autowired
    private Calc<InvestmentPool, BigDecimal> l007IncomeCalc;
    
    @Autowired
    protected IMatchBizBaseDao matchBizBaseDao;
    
    @Override
    public void sync() {
        LOG.info("Trans startup");
        dalClient.getTransactionTemplate().execute(new CallBackTemplate<Boolean>() {
            @Override
            public Boolean invoke() {
                List<InvestmentPool> pools = dalClient.queryForList("batchSync.syncTrans", null, InvestmentPool.class);
                LOG.info("Trans startup [{}] pools", pools.size());
                for (InvestmentPool pool : pools) {
                    MatchBizBaseDto base = matchBizBaseDao.queryById(MatchBizBaseDto.class, pool.getMatchBizBaseId());
                    BigDecimal rateMonth = productService.getRateMonth(pool.getProductId(),
                    		base.getApplyDate(),pool.getInitTotalAmount());
                    BigDecimal rateYear = productService.getRateYear(pool.getProductId(), base.getApplyDate(),pool.getInitTotalAmount());
                    BigDecimal firstIncome = BigDecimal.ZERO;
                    if(Assert.equals(L007, pool.getProductId())){
                    	firstIncome = l007IncomeCalc.calc(pool);
                    }
                    pool.transFix(rateMonth, rateYear,firstIncome);
                    LOG.info("Push [{}] to invest", pool.getLenderCode());
                    PushDataDto data = new PushDataDto();
                    data.setLenderCode(pool.getLenderCode());
                    data.setDueDate(pool.getTransTime());
                    data.setSettlementDate(pool.getInterestBeginTime());
                    lenderPushService.push(PushCode.DUE_DATE, data);
                    investPool.save(pool);
                }
                return true;
            }
        });

    }

}
