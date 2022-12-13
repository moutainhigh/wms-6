package com.dx.cms.enums;

public enum HrFile {
	
	IDCARD("身份证"),
	HKB("户口本"),
	TJBG("体检报告"),
	XLZM("学历证明"),
	LZZM("离职证明");
	
	private String info;
	
	HrFile(String info){
		this.info=info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
