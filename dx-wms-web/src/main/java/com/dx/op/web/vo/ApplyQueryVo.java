package com.dx.op.web.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ApplyQueryVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    /**
     * 借贷部
     */
    private Long loanId;
    /**
     * 区域
     */
    private Long areaId;
    /**
     * 营业部
     */
    private Long salesDepartmentId;

    /**
     * 客户经理
     */
    private String customerManagerId;

    /**
     * 申请产品类型
     */
    private Integer prodType;

    /**
     * 申请时间起
     */
    private Date createTimeBegin;

    /**
     * 申请时间 止
     */
    private Date createTimeEnd;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getSalesDepartmentId() {
        return salesDepartmentId;
    }

    public void setSalesDepartmentId(Long salesDepartmentId) {
        this.salesDepartmentId = salesDepartmentId;
    }

    public String getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(String customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    public Integer getProdType() {
        return prodType;
    }

    public void setProdType(Integer prodType) {
        this.prodType = prodType;
    }

    /**
     * @return the createTimeBegin
     */
    public Date getCreateTimeBegin() {
        return createTimeBegin;
    }

    /**
     * @param createTimeBegin the createTimeBegin to set
     */
    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    /**
     * @return the createTimeEnd
     */
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    /**
     * @param createTimeEnd the createTimeEnd to set
     */
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

}
