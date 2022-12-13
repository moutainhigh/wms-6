package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 匹配视图查询vo<br>
 * 匹配视图查询vo
 *
 * @author tony
 */
public class MatchViewQueryVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4700152385795126440L;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 匹配日期（起）
     */
    private Date matchDateBegin;

    /**
     * 匹配日期（止）
     */
    private Date matchDateEnd;

    /**
     * 首次匹配日期（起）
     */
    private Date initMatchDateBegin;

    /**
     * 首次匹配日期（止）
     */
    private Date initMatchDateEnd;

    /**
     * 转让日期（起）
     */
    private Date transDateBegin;

    /**
     * 转让日期（止）
     */
    private Date transDateEnd;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public Date getMatchDateBegin() {
        return matchDateBegin;
    }

    public void setMatchDateBegin(Date matchDateBegin) {
        this.matchDateBegin = matchDateBegin;
    }

    public Date getMatchDateEnd() {
        return matchDateEnd;
    }

    public void setMatchDateEnd(Date matchDateEnd) {
        this.matchDateEnd = matchDateEnd;
    }

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

    public Date getTransDateBegin() {
        return transDateBegin;
    }

    public void setTransDateBegin(Date transDateBegin) {
        this.transDateBegin = transDateBegin;
    }

    public Date getTransDateEnd() {
        return transDateEnd;
    }

    public void setTransDateEnd(Date transDateEnd) {
        this.transDateEnd = transDateEnd;
    }

}
