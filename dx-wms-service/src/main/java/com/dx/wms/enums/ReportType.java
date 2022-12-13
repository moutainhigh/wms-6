package com.dx.wms.enums;

import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

public enum ReportType {
	
	/*
	 * 首期
	 */
	FIRST(1,"first"),
	/*
	 * 生效首期
	 */
	EFFECTFIRST(2,"effectFirst"),
	
	
	PAST(3,"past");
	
	private Integer code;
	
	private String info;

	
	public Integer getCode() {
		return code;
	}

	public String getInfo() {
		return info;
	}

	private ReportType(Integer code, String info) {
		this.code = code;
		this.info = info;
	}

	public static ReportType getSingleEnum(Integer code){
		if(!Assert.checkParam(code)){
			throw new BaseException("not found code");
		}
		for(ReportType report : ReportType.values()){
			if(report.getCode().equals(code)){
				return report;
			}
		}
		throw new BaseException("not found code");
	}
	
	public static String getValue(Integer code){
		return getSingleEnum(code).getInfo();
	}
}
