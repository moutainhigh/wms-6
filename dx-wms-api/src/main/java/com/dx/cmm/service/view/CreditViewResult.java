package com.dx.cmm.service.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.dx.cmm.dto.CreditAttr;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.PerUtils;

/**
 * 
 * 债权视图
 *
 * @author tony
 */
public class CreditViewResult implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4191012121940656652L;

    private static final String ZERO = "0.00";

    /**
     * 序号
     */
    private Integer index;

    /**
     * 借款人姓名
     */
    private String custName;

    /**
     * 借款人身份证号码
     */
    private String idCard;

    /**
     * 本次转让债权价值
     */
    private BigDecimal transAmount;

    /**
     * 本次转让债权价值
     */
    private String transAmountView;

    /**
     * 需支付对价
     */
    private BigDecimal payAmount;

    /**
     * 需支付对价
     */
    private String payAmountView;

    /**
     * 属性
     */
    private String attr;

    /**
     * 借款人职业情况
     */
    private String profession;

    /**
     * 借款人借款用途
     */
    private String purpose;

    /**
     * 还款起始日期
     */
    private Date repayDate;

    /**
     * 还款起始日期
     */
    private String repayDateView;

    /**
     * 还款期限（月）
     */
    private Integer initPeriod;

    /**
     * 剩余还款月数
     */
    private Integer remainPeriod;

    /**
     * 预计债权收益率（年）
     */
    private BigDecimal rateYear;

    /**
     * 预计债权收益率（年）
     */
    private String rateYearView;

    /**
     * 转让利息
     */
    private BigDecimal transInterest;

    /**
     * 转让本金
     */
    private BigDecimal transCapital;
    
    /*
     * 转让日债权价值
     */
    private BigDecimal transCreditorAmount;
    
    /*
     * 转让日债权价值预览
     */
    private String transCreditorAmountView;
    
    /*
     * 转让日期
     */
    private Date transDate;
    
    /*
     * 转让日期预览
     */
    private String transDateView;
    
    /*
     *	初始借款金额 
     */
    private BigDecimal initTotalAmount;
    
    /*
     * 初始借款金额view
     */
    private String initTotalAmountView;
    

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransAmountView() {
        return transAmountView;
    }

    public void setTransAmountView(String transAmountView) {
        this.transAmountView = transAmountView;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayAmountView() {
        return payAmountView;
    }

    public void setPayAmountView(String payAmountView) {
        this.payAmountView = payAmountView;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public String getRepayDateView() {
        return repayDateView;
    }

    public void setRepayDateView(String repayDateView) {
        this.repayDateView = repayDateView;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public Integer getRemainPeriod() {
        return remainPeriod;
    }

    public void setRemainPeriod(Integer remainPeriod) {
        this.remainPeriod = remainPeriod;
    }

    public BigDecimal getRateYear() {
        return rateYear;
    }

    public void setRateYear(BigDecimal rateYear) {
        this.rateYear = rateYear;
    }

    public String getRateYearView() {
        return rateYearView;
    }

    public void setRateYearView(String rateYearView) {
        this.rateYearView = rateYearView;
    }

    public BigDecimal getTransInterest() {
        return transInterest;
    }

    public void setTransInterest(BigDecimal transInterest) {
        this.transInterest = transInterest;
    }

    public BigDecimal getTransCapital() {
        return transCapital;
    }

    public void setTransCapital(BigDecimal transCapital) {
        this.transCapital = transCapital;
    }

    public BigDecimal getTransCreditorAmount() {
		return transCreditorAmount;
	}

	public void setTransCreditorAmount(BigDecimal transCreditorAmount) {
		this.transCreditorAmount = transCreditorAmount;
	}

	public String getTransCreditorAmountView() {
		return transCreditorAmountView;
	}

	public void setTransCreditorAmountView(String transCreditorAmountView) {
		this.transCreditorAmountView = transCreditorAmountView;
	}

	public void parse(Integer index, CreditAttr attr, Integer months) {
        setIndex(index);
        setTransAmountView(AmountUtils.format(getTransAmount(), ZERO));
        setPayAmountView(AmountUtils.format(getPayAmount(), ZERO));
        setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
        setProfession(attr.getWorkSituationCn());
        setPurpose(attr.getLoanTypeCn());
        setRepayDateView(DateUtils.formatForDay(getRepayDate()));
        setRateYearView(PerUtils.format(getRateYear()));
        setRemainPeriod(getInitPeriod() - months);
    }
	public void parse(CreditAttr attr, Integer months) {
        setTransAmountView(AmountUtils.format(getTransAmount(), ZERO));
        setPayAmountView(AmountUtils.format(getPayAmount(), ZERO));
        setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
        setProfession(attr.getWorkSituationCn());
        setPurpose(attr.getLoanTypeCn());
        setRepayDateView(DateUtils.formatForDay(getRepayDate()));
        setRateYearView(PerUtils.format(getRateYear()));
        setRemainPeriod(getInitPeriod() - months);
    }
	
	public void parse(Integer index, CreditAttr attr) {
        setIndex(index);
        setTransAmountView(AmountUtils.format(getTransAmount(), ZERO));
        setPayAmountView(AmountUtils.format(getPayAmount(), ZERO));
        setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
        setProfession(attr.getWorkSituationCn());
        setPurpose(attr.getLoanTypeCn());
        setRepayDateView(DateUtils.formatForDay(getRepayDate()));
        setRateYearView(PerUtils.format(getRateYear()));
    }
	
	public void parse(CreditAttr attr) {
        setTransAmountView(AmountUtils.format(getTransAmount(), ZERO));
        setPayAmountView(AmountUtils.format(getPayAmount(), ZERO));
        setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
        setProfession(attr.getWorkSituationCn());
        setPurpose(attr.getLoanTypeCn());
        setRepayDateView(DateUtils.formatForDay(getRepayDate()));
        setRateYearView(PerUtils.format(getRateYear()));
    }

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getTransDateView() {
		return transDateView;
	}

	public void setTransDateView(String transDateView) {
		this.transDateView = transDateView;
	}

	public BigDecimal getInitTotalAmount() {
		return initTotalAmount;
	}

	public void setInitTotalAmount(BigDecimal initTotalAmount) {
		this.initTotalAmount = initTotalAmount;
	}

	public String getInitTotalAmountView() {
		return initTotalAmountView;
	}

	public void setInitTotalAmountView(String initTotalAmountView) {
		this.initTotalAmountView = initTotalAmountView;
	}
	
	
}
