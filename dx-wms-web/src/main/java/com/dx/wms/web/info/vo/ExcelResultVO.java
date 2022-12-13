package com.dx.wms.web.info.vo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;


public class ExcelResultVO {
	
	/**
     * 出借编号
     */
    private String lenderCode;
    /**
     * 客户姓名
     */
    protected String custName;
    /**
     * 证件号码
     */
    protected String idCard;
    /**
     * 出借方式
     */
    private String productView;
    /**
     * 出借金额
     */
    private String lenderAmountView;
    /**
     * 签单日期
     */
    private String signDateView;
    /**
     * 生效时间
     */
    private String settleDateView;
    /**
     * 到期时间
     */
    private String dueDateView;   
    /**
     * 账单日
     */
    private String statementDateView;
    /**
     * 营业部
     */
    private String orgView;
    /**
     * 大团
     */
    private String clusterView;
    /**
     * 团队
     */
    private String teamView;
    /**
     * 客户经理
     */
    private String managerView;
    /**
     * 理财申请单状态
     */
    private String formStatusView;
    
    
	public String getLenderCode() {
		return lenderCode;
	}
	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
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
	public String getProductView() {
		return productView;
	}
	public void setProductView(String productView) {
		this.productView = productView;
	}
	public String getLenderAmountView() {
		return lenderAmountView;
	}
	public void setLenderAmountView(String lenderAmountView) {
		this.lenderAmountView = lenderAmountView;
	}
	public String getSignDateView() {
		return signDateView;
	}
	public void setSignDateView(String signDateView) {
		this.signDateView = signDateView;
	}
	public String getSettleDateView() {
		return settleDateView;
	}
	public void setSettleDateView(String settleDateView) {
		this.settleDateView = settleDateView;
	}
	public String getDueDateView() {
		return dueDateView;
	}
	public void setDueDateView(String dueDateView) {
		this.dueDateView = dueDateView;
	}
	public String getStatementDateView() {
		return statementDateView;
	}
	public void setStatementDateView(String statementDateView) {
		this.statementDateView = statementDateView;
	}
	public String getOrgView() {
		return orgView;
	}
	public void setOrgView(String orgView) {
		this.orgView = orgView;
	}
	public String getClusterView() {
		return clusterView;
	}
	public void setClusterView(String clusterView) {
		this.clusterView = clusterView;
	}
	public String getTeamView() {
		return teamView;
	}
	public void setTeamView(String teamView) {
		this.teamView = teamView;
	}
	public String getManagerView() {
		return managerView;
	}
	public void setManagerView(String managerView) {
		this.managerView = managerView;
	}
	public String getFormStatusView() {
		return formStatusView;
	}
	public void setFormStatusView(String formStatusView) {
		this.formStatusView = formStatusView;
	}
    
	public ExcelResultVO(ResultInfoVo dto){
		try {
			PropertyUtils.copyProperties(this, dto);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
