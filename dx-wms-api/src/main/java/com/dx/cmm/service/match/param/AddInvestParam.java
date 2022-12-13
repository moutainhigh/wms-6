package com.dx.cmm.service.match.param;

import java.util.Date;

public class AddInvestParam extends InvestParam {

    /**
     */
    private static final long serialVersionUID = -6147336364667847616L;

    /**
     * 进件日期-起
     */
    private Date createDateBegin;

    /**
     * 进件日期-止
     */
    private Date createDateEnd;

    /**
     * 客户分类
     */
    private Integer category;

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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

}
