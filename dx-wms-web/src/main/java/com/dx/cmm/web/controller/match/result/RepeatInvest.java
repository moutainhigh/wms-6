package com.dx.cmm.web.controller.match.result;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.match.result.RepeatInvestResult;
import com.dx.common.service.utils.AmountUtils;

public class RepeatInvest extends PartInvest {

    /**
     */
    private static final long serialVersionUID = 7114012355377285871L;

    /**
     * 退回债权数
     */
    private Integer count;

    /**
     * 已匹配金额
     */
    private BigDecimal matchAmount;

    /**
     * 已匹配金额
     */
    private String matchAmountView;

    public RepeatInvest(RepeatInvestResult invest, Map<Long, String> product) {
        BeanUtils.copyProperties(invest, this);
        setMatchAmountView().setPortDateView().setDateView().setInitAmountView().setProductView(product)
                .setUndoAmountView();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMatchAmount() {
        return matchAmount;
    }

    public void setMatchAmount(BigDecimal matchAmount) {
        this.matchAmount = matchAmount;
    }

    public String getMatchAmountView() {
        return matchAmountView;
    }

    public void setMatchAmountView(String matchAmountView) {
        this.matchAmountView = matchAmountView;
    }

    public RepeatInvest setMatchAmountView() {
        setMatchAmountView(AmountUtils.format(getMatchAmount(), ZERO));
        return this;
    }

}
