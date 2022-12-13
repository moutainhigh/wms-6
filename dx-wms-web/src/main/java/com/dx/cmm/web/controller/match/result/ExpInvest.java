package com.dx.cmm.web.controller.match.result;

import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.match.result.ExpInvestResult;

public class ExpInvest extends PartInvest {

    /**
     */
    private static final long serialVersionUID = 3330659172596908933L;

    /**
     * 退回债权数
     */
    private Integer count;

    public ExpInvest(ExpInvestResult invest, Map<Long, String> product) {
        BeanUtils.copyProperties(invest, this);
        setDateView().setInitAmountView().setProductView(product).setUndoAmountView();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
