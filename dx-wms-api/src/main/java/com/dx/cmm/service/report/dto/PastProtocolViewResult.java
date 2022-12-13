package com.dx.cmm.service.report.dto;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.dx.cmm.service.invest.InvestResult;
import com.dx.cmm.service.view.CreditViewResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;

public class PastProtocolViewResult extends InvestResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8725801062950063002L;
	
	private static final String ZERO = "0.00";

    /**
     * 下一个报告日
     */
    private Date initBillDate;

    /**
     * 下一个报告日
     */
    private String initBillDateView;


    /**
     * 初始出借日期
     */
    private String initMatchTimeView;

    /**
     * 账户管理费
     */
    private String accountAmountView = ZERO;

    /**
     * 出借金额
     */
    private String initTotalAmountView;

    /**
     * 出借金额大写
     */
    private String initTotalAmountChsView;

    /**
     * 下一个报告期借款人应还款额
     */
    private BigDecimal repay;

    /**
     * 下一个报告期借款人应还款额
     */
    private String repayView;

    /**
     * 预计下一个报告日您的资产总额
     */
    private BigDecimal nextTotalAmount;

    /**
     * 预计下一个报告日您的资产总额
     */
    private String nextTotalAmountView;

    /**
     * 资金出借及回收方式
     */
    private String productView;

    /**
     * 匹配债权
     */
    private List<CreditViewResult> results;
    
    /****协议文件名称******/
    private String protocolFileName;
    
    /*
     * 是否预览
     */
    private Boolean isView;
    
    /*
     * 文件名
     */
    private String fileName;
    
    /*
     * 报告日
     */
    private Date reportDay;
    
    /**
     * 转让价值
     */
    private String transferTotalAmountView;

    /*
     * 报告日View
     */
    private String reportDayView;

    private String transferTotalAmountChsView;
    
    
    public Date getInitBillDate() {
        return initBillDate;
    }

    public void setInitBillDate(Date initBillDate) {
        this.initBillDate = initBillDate;
    }

    public String getAccountAmountView() {
        return accountAmountView;
    }

    public void setAccountAmountView(String accountAmountView) {
        this.accountAmountView = accountAmountView;
    }

    public String getInitBillDateView() {
        return initBillDateView;
    }

    public void setInitBillDateView(String initBillDateView) {
        this.initBillDateView = initBillDateView;
    }

    public String getInitMatchTimeView() {
        return initMatchTimeView;
    }

    public void setInitMatchTimeView(String initMatchTimeView) {
        this.initMatchTimeView = initMatchTimeView;
    }

    public String getInitTotalAmountView() {
        return initTotalAmountView;
    }

    public void setInitTotalAmountView(String initTotalAmountView) {
        this.initTotalAmountView = initTotalAmountView;
    }

    public String getInitTotalAmountChsView() {
        return initTotalAmountChsView;
    }

    public void setInitTotalAmountChsView(String initTotalAmountChsView) {
        this.initTotalAmountChsView = initTotalAmountChsView;
    }

    public BigDecimal getRepay() {
        return repay;
    }

    public void setRepay(BigDecimal repay) {
        this.repay = repay;
    }

    public String getRepayView() {
        return repayView;
    }

    public void setRepayView(String repayView) {
        this.repayView = repayView;
    }

    public BigDecimal getNextTotalAmount() {
        return nextTotalAmount;
    }

    public void setNextTotalAmount(BigDecimal nextTotalAmount) {
        this.nextTotalAmount = nextTotalAmount;
    }

    public String getNextTotalAmountView() {
        return nextTotalAmountView;
    }

    public void setNextTotalAmountView(String nextTotalAmountView) {
        this.nextTotalAmountView = nextTotalAmountView;
    }

    public String getProductView() {
        return productView;
    }

    public void setProductView(String productView) {
        this.productView = productView;
    }

    public List<CreditViewResult> getResults() {
        return results;
    }

    public void setResults(List<CreditViewResult> results) {
        this.results = results;
    }

    public String getProtocolFileName() {
		return protocolFileName;
	}

	public void setProtocolFileName(String protocolFileName) {
		this.protocolFileName = protocolFileName;
	}

	public void matchTime() {
		if(!Assert.checkParam(getInitMatchTime())){
			setInitMatchTime(DateUtils.getNextWorkday(getInitMatchTime()));
		}
    }
	
	public String getTransferTotalAmountView() {
		return transferTotalAmountView;
	}

	public void setTransferTotalAmountView(String transferTotalAmountView) {
		this.transferTotalAmountView = transferTotalAmountView;
	}

	public Boolean getIsView() {
		return isView;
	}

	public void setIsView(Boolean isView) {
		this.isView = isView;
	}
	
	public String getTransferTotalAmountChsView() {
		return transferTotalAmountChsView;
	}

	public void setTransferTotalAmountChsView(String transferTotalAmountChsView) {
		this.transferTotalAmountChsView = transferTotalAmountChsView;
	}

	public void parse(BigDecimal capital, BigDecimal interest, Map<String,String> productMap,
            List<CreditViewResult> results,BigDecimal transTotalAmount) {
        setInitMatchTimeView(DateUtils.formatForDay(getInitMatchTime()));
        //report day减少1个月
        Calendar cal=Calendar.getInstance();
        cal.setTime(getReportDay());
        cal.add(GregorianCalendar.MONTH, -1);
        setReportDayView(DateUtils.formatForDay(cal.getTime()));
        
        setInitBillDateView(DateUtils.formatForDay(getInitBillDate()));
        setRepay(capital.add(interest));
        setRepayView(AmountUtils.format(getRepay(), ZERO));
        setInitTotalAmountView(AmountUtils.format(getInitTotalAmount(), ZERO));
        setInitTotalAmountChsView(
                MessageFormat.format("{0}整", AmountUtils.toChinese(String.valueOf(getInitTotalAmount()))));
        setNextTotalAmount(getInitTotalAmount().add(interest));
        setNextTotalAmountView(AmountUtils.format(getNextTotalAmount(), ZERO));
        setProductView(productMap.get(getProductId()));
        setTransferTotalAmountView(AmountUtils.format(transTotalAmount, ZERO));
        setTransferTotalAmountChsView(MessageFormat.format("{0}整", AmountUtils.toChinese(String.valueOf(transTotalAmount))));
        setResults(results);
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getReportDay() {
		return reportDay;
	}

	public void setReportDay(Date reportDay) {
		this.reportDay = reportDay;
	}

	public String getReportDayView() {
		return reportDayView;
	}

	public void setReportDayView(String reportDayView) {
		this.reportDayView = reportDayView;
	}
	
}
