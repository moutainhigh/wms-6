/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CCSBizAttrDto.java
 * Author:   蔡登勇
 * Date:     2015年7月30日 上午11:50:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 借贷系统业务属性Dto
 *
 * @author 蔡登勇
 */
public class CCSBizAttrDto implements Serializable {
    /**
     */
    private static final long serialVersionUID = 2228774745861592162L;

    // "借款用途","月利率","预计债权收益率（年）"}
    /** 职业情况 中文 */
    private String workSituationCn;

    /** 职业情况 工薪1/自营2/学生3/白领4 */
    private Integer workSituation;

    /** 借款用途 中文 */
    private String loanTypeCn;

    /** 借款用途 资金周转1；扩大经营2；购买（生活用品、原材料、设备）3；教育支出4；医疗5；旅游6；其他7； */
    private Integer loanType;

    /** 借款类型其他 */
    private String loanTypeOther;

    /** 月利率 */
    private BigDecimal rate;

    /** 年划收益率 */
    private BigDecimal annualReRate;

    public String getWorkSituationCn() {
        return workSituationCn;
    }

    public void setWorkSituationCn(String workSituationCn) {
        this.workSituationCn = workSituationCn;
    }

    public Integer getWorkSituation() {
        return workSituation;
    }

    public void setWorkSituation(Integer workSituation) {
        this.workSituation = workSituation;
    }

    public String getLoanTypeCn() {
        return loanTypeCn;
    }

    public void setLoanTypeCn(String loanTypeCn) {
        this.loanTypeCn = loanTypeCn;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
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

}
