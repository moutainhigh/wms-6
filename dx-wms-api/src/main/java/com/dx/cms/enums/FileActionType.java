package com.dx.cms.enums;

public enum FileActionType {
	
	CREATE_ACCOUNT("createUserAccount"),
	SALES_ACTION("submitToSalesService"),
	PAYMENT_ACTION("uploadPaymentVouchers");
	
	String info;

	private FileActionType(String info) {
		this.info = info;
	}

	
	
}