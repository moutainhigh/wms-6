package com.dx.cmm.web.controller.match.result;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.service.match.result.AddInvestResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;

public class AllInvest extends InvestView {

    /**
     */
    private static final long serialVersionUID = -8260262530068962162L;

    /**
     * 客户分类
     */
    private Integer category;

    /**
     * 客户分类
     */
    private String categoryView;
    
    /**
     * 原出借编号
     */
    private String upLenderCode;
    
    /**
     * 原出借金额
     */
    private String upLenderAmountView;
    
    /**
     * 原申请单到期日
     */
    private String upDueDateView;

    public AllInvest(AddInvestResult invest, Map<Long, String> product, Map<String, String> category) {
        BeanUtils.copyProperties(invest, this);
        setCategoryView(category).setDateView().setInitAmountView().setProductView(product).setUndoAmountView();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCategoryView() {
        return categoryView;
    }

    public void setCategoryView(String categoryView) {
        this.categoryView = categoryView;
    }
    
    public String getUpLenderCode() {
		return upLenderCode;
	}

	public void setUpLenderCode(String upLenderCode) {
		this.upLenderCode = upLenderCode;
	}
	
	public AllInvest setUpLenderCodeView(String upLenderCode){
		setUpLenderCode(upLenderCode);
		return this;
	}
	
	public String getUpLenderAmountView() {
		return upLenderAmountView;
	}

	public void setUpLenderAmountView(String upLenderAmountView) {
		this.upLenderAmountView = upLenderAmountView;
	}
	
	public AllInvest setUpLenderAmountView(BigDecimal upLenderAmount){
		setUpLenderAmountView(AmountUtils.format(upLenderAmount, ZERO));
		return this;
	}
	
	public String getUpDueDateView() {
		return upDueDateView;
	}

	public void setUpDueDateView(String upDueDateView) {
		this.upDueDateView = upDueDateView;
	}
	
	public AllInvest setUpDueDateView(Date upDueDate){
		setUpDueDateView(DateUtils.formatForDay(upDueDate));
		return this;
	} 
	
	public AllInvest setCategoryView(Map<String, String> category) {
        if (Assert.checkParam(getCategory())) {
            setCategoryView(category.get(String.valueOf(getCategory())));
        }
        return this;
    }
	
	public AllInvest upSet(String lenderCode,BigDecimal upLenderAmount,Date upDueDate){
		setUpLenderCodeView(lenderCode).setUpLenderAmountView(upLenderAmount).setUpDueDateView(upDueDate);
		return this;
	}
}
