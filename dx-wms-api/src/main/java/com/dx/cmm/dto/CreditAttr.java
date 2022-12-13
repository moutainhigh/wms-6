package com.dx.cmm.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 债权属性
 *
 * @author tony
 */
public class CreditAttr implements Serializable {
    /**
     */
    private static final long serialVersionUID = 2228774745861592162L;

    /**
     * 职业情况 工薪1/自营2/学生3/白领4
     */
    private String workSituation;

    /**
     * 职业情况 工薪1/自营2/学生3/白领4
     */
    private String workSituationCn;

    /**
     * 借款用途 资金周转1；扩大经营2；购买（生活用品、原材料、设备）3；教育支出4；医疗5；旅游6；其他7；
     */
    private String loanType;

    /**
     * 借款用途 资金周转1；扩大经营2；购买（生活用品、原材料、设备）3；教育支出4；医疗5；旅游6；其他7；
     */
    private String loanTypeCn;

    /**
     * 借款类型其他
     */
    private String loanTypeOther;

    /**
     * 月利率
     */
    private BigDecimal rate;

    /**
     * 年划收益率
     */
    private BigDecimal annualReRate;

    public String getWorkSituation() {
        return workSituation;
    }

    public void setWorkSituation(String workSituation) {
        this.workSituation = workSituation;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanTypeOther() {
        return loanTypeOther;
    }

    public void setLoanTypeOther(String loanTypeOther) {
        this.loanTypeOther = loanTypeOther;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getAnnualReRate() {
        return annualReRate;
    }

    public void setAnnualReRate(BigDecimal annualReRate) {
        this.annualReRate = annualReRate;
    }

    public String getWorkSituationCn() {
        return workSituationCn;
    }

    public void setWorkSituationCn(String workSituationCn) {
        this.workSituationCn = workSituationCn;
    }

    public String getLoanTypeCn() {
        return loanTypeCn;
    }

    public void setLoanTypeCn(String loanTypeCn) {
        this.loanTypeCn = loanTypeCn;
    }

}
