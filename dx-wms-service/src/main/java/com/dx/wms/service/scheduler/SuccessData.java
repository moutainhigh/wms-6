package com.dx.wms.service.scheduler;

import java.io.Serializable;
import java.util.Date;

public class SuccessData implements Serializable {

    /**
     */
    private static final long serialVersionUID = 2709162852212045510L;

    /**
     * 出借主键
     */
    private Long applyId;

    /**
     * 到账日
     */
    private Date settlementDate;

    /**
     * 出借编号
     */
    private String lenderCode;

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

}
