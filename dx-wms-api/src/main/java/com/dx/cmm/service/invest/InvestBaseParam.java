package com.dx.cmm.service.invest;

import java.util.Date;

class InvestBaseParam extends InvestBase {

    /**
     */
    private static final long serialVersionUID = -718903576651702662L;

    /**
     * 首次匹配日期-起
     */
    private Date initMatchDateBegin;

    /**
     * 首次匹配日期-止
     */
    private Date initMatchDateEnd;
    
    /**
     * 出借编号
     */
    private String lenderCode;

    public Date getInitMatchDateBegin() {
        return initMatchDateBegin;
    }

    public void setInitMatchDateBegin(Date initMatchDateBegin) {
        this.initMatchDateBegin = initMatchDateBegin;
    }

    public Date getInitMatchDateEnd() {
        return initMatchDateEnd;
    }

    public void setInitMatchDateEnd(Date initMatchDateEnd) {
        this.initMatchDateEnd = initMatchDateEnd;
    }

  
    public String getLenderCode() {
        return lenderCode;
    }

 
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

}
