package com.dx.wms.dto;


public class ParamConvertDto<P, R> extends ReportBaseDto<P, R>{
	
    /**
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 出借编号
     */
    private String lenderCode;
    
    /*
     * 协议文件名称
     */
    private String protocolFileName;

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public String getProtocolFileName() {
		return protocolFileName;
	}

	public void setProtocolFileName(String protocolFileName) {
		this.protocolFileName = protocolFileName;
	}
    
    
}
