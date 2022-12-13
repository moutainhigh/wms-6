package com.dx.cmm.service.match.param;

public class RepeatInvestParam extends MatchParam{

    /**
     */
    private static final long serialVersionUID = 7724490012319563790L;

    /**
     * 出借编号
     */
    private String lenderCode;

	public String getLenderCode() {
		return lenderCode;
	}

	public void setLenderCode(String lenderCode) {
		this.lenderCode = lenderCode;
	}
}
