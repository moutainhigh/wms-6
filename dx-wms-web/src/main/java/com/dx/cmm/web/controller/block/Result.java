package com.dx.cmm.web.controller.block;

import java.io.Serializable;
import java.math.BigDecimal;

public class Result implements Serializable{

    /**
     */
    private static final long serialVersionUID = -3916772702140971163L;
    
    private String leaderCode;
    
    private String custName;
    
    private String idCard;
    
    private BigDecimal lenderAmount;

    public String getLeaderCode() {
        return leaderCode;
    }

    public void setLeaderCode(String leaderCode) {
        this.leaderCode = leaderCode;
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

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }
    
    

}
