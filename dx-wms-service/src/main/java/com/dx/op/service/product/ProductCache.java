package com.dx.op.service.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductCache implements Serializable {

    /**
     */
    private static final long serialVersionUID = 2744748933970991570L;

    /**
     * 产品编号
     */
    private Long productId;

    /**
     * 参考日期
     */
    private Date refDate;

    /**
     * 月利率
     */
    private BigDecimal rateMonth;

    /**
     * 年利率
     */
    private BigDecimal rateYear;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getRefDate() {
        return refDate;
    }

    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }

    public BigDecimal getRateMonth() {
        return rateMonth;
    }

    public void setRateMonth(BigDecimal rateMonth) {
        this.rateMonth = rateMonth;
    }

    public BigDecimal getRateYear() {
        return rateYear;
    }

    public void setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
    }

    
}
