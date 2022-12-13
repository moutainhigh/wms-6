package com.dx.cmm.web.controller.match.result;

import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.match.result.BackInvestResult;

public class BackInvest extends PartInvest {

    /**
     */
    private static final long serialVersionUID = -8384245981120309262L;

    public BackInvest(BackInvestResult invest, Map<Long, String> product) {
        BeanUtils.copyProperties(invest, this);
        setPortDateView().setDateView().setInitAmountView().setProductView(product).setUndoAmountView();
    }

}
