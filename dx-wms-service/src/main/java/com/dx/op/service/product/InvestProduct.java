package com.dx.op.service.product;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.invest.Invest;
import com.dx.cmm.service.pools.InvestmentPool;

@Service("investProduct")
public class InvestProduct extends ProductAbs<InvestmentPool> implements Invest<InvestmentPool> {

    @Override
    public Boolean isFix(InvestmentPool pool) {
        return productService.isFix(pool.getProductId());
    }

}
