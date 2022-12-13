package com.dx.cmm.service.queues;

import java.text.MessageFormat;

public class CreditStat extends StatQueue {

    /**
     */
    private static final long serialVersionUID = 8910574399571259989L;

    private Integer billDay;

    Integer getBillDay() {
        return billDay;
    }

    void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    void trans(Integer index) {
        setTotalAmountView().setIndex(index).setStatName(MessageFormat.format("{0}号端", getBillDay()));
    }

}
