package com.dx.op.web.vo;

import java.io.Serializable;
import java.util.Date;

public class BlackListQueryVo implements Serializable {
	/**
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 姓名 
     */
    private String name;

    /**
     * 身份证
     */
    private String idCard;
    /**
     * 营业部
     */
    private Long salesDepartment;

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
    private Date applyTimeBegin;

    /**
     * 申请时间 止
     */
    private Date applyTimeEnd;

    public Long getSalesDepartment() {
        return salesDepartment;
    }

    public void setSalesDepartment(Long salesDepartment) {
        this.salesDepartment = salesDepartment;
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

    public Date getApplyTimeBegin() {
        return applyTimeBegin;
    }

    public void setApplyTimeBegin(Date applyTimeBegin) {
        this.applyTimeBegin = applyTimeBegin;
    }

    public Date getApplyTimeEnd() {
        return applyTimeEnd;
    }

    public void setApplyTimeEnd(Date applyTimeEnd) {
        this.applyTimeEnd = applyTimeEnd;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


}
