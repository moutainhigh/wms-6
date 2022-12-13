package com.dx.cmm.service.invest;

import java.util.List;

/**
 * 匹配参数
 *
 * @author 朱道灵
 */
public class InvestPoolParam extends InvestBaseParam {

    /**
     */
    private static final long serialVersionUID = 3706523522639264428L;

    /**
     * 身份证
     */
    private String idCard;
    
	/*
	 * 出借编号集合
	 */
	private List<String> lenderCodes;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

	public List<String> getLenderCodes() {
		return lenderCodes;
	}

	public void setLenderCodes(List<String> lenderCodes) {
		this.lenderCodes = lenderCodes;
	}
}
