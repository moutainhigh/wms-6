package com.dx.cmm.service.match.param;

public class BackInvestParam extends MatchParam {

    /**
     */
    private static final long serialVersionUID = -3833745184932934011L;

    /**
     * 端口日
     */
    private Integer portDay;
    
    private String lenderCode;
    

    public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}

	public Integer getPortDay() {
        return portDay;
    }

    public void setPortDay(Integer portDay) {
        this.portDay = portDay;
    }

}
