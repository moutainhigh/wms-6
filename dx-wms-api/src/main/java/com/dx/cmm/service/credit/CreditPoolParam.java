package com.dx.cmm.service.credit;

public class CreditPoolParam extends CreditBaseParam {

    /**
     */
    private static final long serialVersionUID = 2785804940749036948L;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 还款日
     */
    private Integer repayDay;

    /**
     * 姓名
     */
    private String custName;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getRepayDay() {
        return repayDay;
    }

    public void setRepayDay(Integer repayDay) {
        this.repayDay = repayDay;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

}
