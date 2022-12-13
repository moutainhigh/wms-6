package com.dx.cmm.web.controller.match.result;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.match.result.InvestResult;

/**
 * 投资列表
 * 
 * @author 朱道灵
 */
public class Invest extends MatchView {

    /**
     */
    private static final long serialVersionUID = 4061692562660554333L;

    /**
     * 出借编号
     */
    private String lenderCode;

    public Invest() {

    }

    public Invest(InvestResult invest) {
        BeanUtils.copyProperties(invest, this);
        setUndoAmountView();
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

}
