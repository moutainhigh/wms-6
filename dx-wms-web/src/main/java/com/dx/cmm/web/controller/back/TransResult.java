package com.dx.cmm.web.controller.back;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.back.BackTransResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.service.apply.LenderApplyDto;

public class TransResult extends BaseResult {
    private static final String ZERO = "0.00";
    /**
     */
    private static final long serialVersionUID = -6046108843033150887L;
    
    /**
     * 账单日
     */
    private Integer billDay;
    
    /**
     * 邮编
     */
    private String zipCode;
    /**
     * 地址
     */
    private String custAddress;
    /**
     * 初始出借金额
     */
    private BigDecimal initTotalAmount;
    /**
     * 初始出借金额视图
     */
    private String totalAmountView;

    /**
     * 初始出借日期
     */
    private Date interestBeginTime;
    /**
     * 初始出借日期视图
     */
    private String interestBeginTimeView;
    /**
     * 转让日期
     */
    private Date transTime;
    /**
     * 转让日期视图
     */
    private String transTimeView;
    
    /**
     * 支付日期
     */
    private Date payTime;
    
    /**
     * 支付日期视图
     */
    private String payTimeView;
    /**
     * 转让日债权价值
     */
    private BigDecimal transCreditorAmount;
    /**
     * 转让日债权价值视图
     */
    private String transCreditorAmountView;
    /**
     * 转让对价
     */
    private BigDecimal transTotalAmount;
    /**
     * 转让对价视图
     */
    private String transTotalAmountView;
    /**
     * 转让服务费
     */
    private BigDecimal transServiceFee;
    /**
     * 转让服务费
     */
    private String transServiceFeeView;
    /**
     * 账户管理费
     */
    private BigDecimal accountManagementFee;
    /**
     * 账户管理费视图
     */
    private String accountManagementFeeView; 
    /**
     * 付款金额
     */
    private BigDecimal payTotalAmount;
    
    /**
     * 付款金额视图
     */
    private String payTotalAmountView;
    

    public TransResult() {

    }

    public TransResult(BackTransResult result, ILenderApplyService lenderApplyService,
            final Map<Long, String> product) {
        BeanUtils.copyProperties(result, this);
        product(product);
        interestBeginTimeView();
        totalAmountView();
        if (Assert.equals(getProductId(), 11L, 12L)) {
            accountManagementFeeView();
            setTransServiceFeeView("-");
        } else {
            setAccountManagementFeeView("-");
            setTransServiceFeeView();
        }
        transCreditorAmountView();
        transTimeView();
        if(Assert.equals(DateUtils.formatForDay(getTransTime()), "2017-01-20")){
        	setPayTimeView("2017-01-22");
        }else
        if(Assert.equals(DateUtils.formatForDay(getTransTime()), "2017-01-22")){
        	setPayTimeView("2017-01-23");
        }else
        if(Assert.equals(DateUtils.formatForDay(getTransTime()), "2017-01-26")){
        	setPayTimeView("2017-02-03");
        }else
        if(Assert.equals(DateUtils.formatForDay(getTransTime()), "2017-02-03")){
        	setPayTimeView("2017-02-04");
        }else{
        	PayTimeView();
        }
        transTotalAmountView();
        payTotalAmountView();
        LenderApplyDto apply = lenderApplyService.query(result.getLenderCode());
        if (Assert.checkParam(apply)) {
            BeanUtils.copyProperties(apply, this);
            setBackBankView(MessageFormat.format("{0}{1}", BankCategery.getInfo(getBackBank()), getBackSubBank()));
        }
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getTotalAmountView() {
        return totalAmountView;
    }

    public void setTotalAmountView(String totalAmountView) {
        this.totalAmountView = totalAmountView;
    }

    public void totalAmountView() {
        setTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
    }

    public Date getInterestBeginTime() {
        return interestBeginTime;
    }

    public void setInterestBeginTime(Date interestBeginTime) {
        this.interestBeginTime = interestBeginTime;
    }

    public String getInterestBeginTimeView() {
        return interestBeginTimeView;
    }

    public void setInterestBeginTimeView(String interestBeginTimeView) {
        this.interestBeginTimeView = interestBeginTimeView;
    }

    public void interestBeginTimeView() {
        setInterestBeginTimeView(DateUtils.formatForDay(getInterestBeginTime()));
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public String getTransTimeView() {
        return transTimeView;
    }

    public void setTransTimeView(String transTimeView) {
        this.transTimeView = transTimeView;
    }

    public void transTimeView() {
        setTransTimeView(DateUtils.formatForDay(getTransTime()));
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

    public void transCreditorAmountView() {
        setTransCreditorAmountView(AmountUtils.format(getTransCreditorAmount(), ZERO));
    }

    public BigDecimal getTransTotalAmount() {
        return transTotalAmount;
    }

    public void setTransTotalAmount(BigDecimal transTotalAmount) {
        this.transTotalAmount = transTotalAmount;
    }

    public String getTransTotalAmountView() {
        return transTotalAmountView;
    }

    public void setTransTotalAmountView(String transTotalAmountView) {
        this.transTotalAmountView = transTotalAmountView;
    }

    public void transTotalAmountView() {
        setTransTotalAmountView(AmountUtils.format(getTransTotalAmount(), ZERO));
    }

    public BigDecimal getTransServiceFee() {
        return transServiceFee;
    }

    public void setTransServiceFee(BigDecimal transServiceFee) {
        this.transServiceFee = transServiceFee;
    }

    public String getTransServiceFeeView() {
        return transServiceFeeView;
    }

    public void setTransServiceFeeView(String transServiceFeeView) {
        this.transServiceFeeView = transServiceFeeView;
    }

    public void setTransServiceFeeView() {
        setTransServiceFeeView(AmountUtils.format(getTransServiceFee(), ZERO));
    }

    public BigDecimal getAccountManagementFee() {
        return accountManagementFee;
    }

    public void setAccountManagementFee(BigDecimal accountManagementFee) {
        this.accountManagementFee = accountManagementFee;
    }

    public String getAccountManagementFeeView() {
        return accountManagementFeeView;
    }

    public void setAccountManagementFeeView(String accountManagementFeeView) {
        this.accountManagementFeeView = accountManagementFeeView;
    }

    public void accountManagementFeeView() {
        setAccountManagementFeeView(AmountUtils.format(getAccountManagementFee(), ZERO));
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

	public BigDecimal getPayTotalAmount() {
		return payTotalAmount;
	}

	public void setPayTotalAmount(BigDecimal payTotalAmount) {
		this.payTotalAmount = payTotalAmount;
	}

	public String getPayTotalAmountView() {
		return payTotalAmountView;
	}

	public void setPayTotalAmountView(String payTotalAmountView) {
		this.payTotalAmountView = payTotalAmountView;
	}

    public void payTotalAmountView() {
    	setPayTotalAmountView(AmountUtils.format(getPayTotalAmount(), ZERO));
    }
    
    
    public Integer getBillDay() {
		return billDay;
	}

	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getPayTimeView() {
		return payTimeView;
	}

	public void setPayTimeView(String payTimeView) {
		this.payTimeView = payTimeView;
	}
    
	public void PayTimeView() {
		Date tansTimeDate = this.getTransTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(tansTimeDate);
		cal.add(Calendar.DATE, 1);
		if(DateUtils.isHoliday(cal.getTime())){
			cal.setTime(DateUtils.getNextWorkday(cal.getTime()));
		}
		setPayTimeView(DateUtils.formatForDay(cal.getTime()));
    }
	
}
