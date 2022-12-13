package com.dx.cmm.service.trans;

import java.io.Serializable;
import java.util.Date;

class TransBaseParam implements Serializable {

    /**
     */
    private static final long serialVersionUID = -1449354677142268077L;

    /**
     * 开始日期
     */
    Date createDateBegin;

    /**
     * 截止日期
     */
    Date createDateEnd;

    public Date getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(Date createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

}
