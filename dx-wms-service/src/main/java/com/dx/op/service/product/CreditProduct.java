package com.dx.op.service.product;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.credit.Credit;
import com.dx.cmm.service.pools.CreditorPool;

@Service("creditProduct")
public class CreditProduct extends ProductAbs<CreditorPool> implements Credit<CreditorPool> {

    private static final String APP = "ccs";

}
