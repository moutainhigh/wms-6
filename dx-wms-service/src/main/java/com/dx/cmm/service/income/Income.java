package com.dx.cmm.service.income;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.dx.cmm.enums.IncomeCategory;
import com.dx.cmm.enums.IncomeType;
import com.dx.cmm.exception.ParamException;
import com.dx.cmm.service.entitys.BaseEntity;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.CreditorPool;
import com.dx.cmm.service.results.MatchResult;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 债权匹配管理-收益表
 *
 * @author tony
 */
@Entity(name = "t_income")
public class Income extends BaseEntity {

    /**
     */
    private static final long serialVersionUID = -5617740424106614024L;

    /**
     * 初始化
     */
    public static final String INIT = "A";

    /**
     * 收益-编号
     */
    private Long incomeId;

    /**
     * 投资池-编号
     */
    private Long investmentPoolId;

    /**
     * 债权池-编号
     */
    private Long creditorPoolId;

    /**
     * 收益-金额
     */
    private BigDecimal incomeAmount;

    /**
     * 收益-账单日:{1,16}
     */
    private Integer incomeDay;

    /**
     * 收益-类别:{1:"债权",2:"服务费",3:"管理费",4:"到期收益"}
     */
    private Integer incomeCategory;

    /**
     * 收益-类型:{1:"居间人",2:"公司"}
     */
    private Integer incomeType;

    public Income() {

    }

    public Income(BigDecimal amount, IncomeCategory category, IncomeType type) {
        setIncomeType(type.getCode()).setIncomeCategory(category.getCode()).setIncomeAmount(amount).setCreateTime()
                .setCreateUser().setUpdateTime().setUpdateUser().setDataStatus();

    }

    public Income(MatchResult result) throws ParamException {
        Assert.notNull(new ParamException("param must not be null"), result);
        BeanUtils.copyProperties(result, this);
        //setIncomeDay(result.getIncome().getBillDay());
        //setIncomeAmount(result.getIncome().getIncomeAmount());
        setIncomeCategory(IncomeCategory.CREDITOR.getCode());
        setIncomeType(IncomeType.INTERMEDIARY.getCode());
    }

    public Income(CreditorPool pool) throws ParamException {
        Assert.notNull(new ParamException("param is null"), pool);
        BeanUtils.copyProperties(pool, this);
        setIncomeCategory(IncomeCategory.CREDITOR.getCode());
        setIncomeType(IncomeType.INTERMEDIARY.getCode());
        setIncomeDay(pool.getMatchDay());
    }

    public Income(InvestmentFund fund) throws ParamException {
        Assert.notNull(new ParamException("fund is null"), fund);
        BeanUtils.copyProperties(fund, this);
        setIncomeCategory(IncomeCategory.MANAGER_FEE.getCode());
        setIncomeType(IncomeType.COMPANY.getCode());
        setIncomeAmount(fund.getAccountManagementFee());
        setIncomeDay(fund.getInvestmentFundDay());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "income_id")
    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    @Column(name = "investment_pool_id")
    public Long getInvestmentPoolId() {
        return investmentPoolId;
    }

    public Income setInvestmentPoolId(Long investmentPoolId) {
        this.investmentPoolId = investmentPoolId;
        return this;
    }

    @Column(name = "creditor_pool_id")
    public Long getCreditorPoolId() {
        return creditorPoolId;
    }

    public Income setCreditorPoolId(Long creditorPoolId) {
        this.creditorPoolId = creditorPoolId;
        return this;
    }

    @Column(name = "income_amount")
    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public Income setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
        return this;
    }

    @Column(name = "income_day")
    public Integer getIncomeDay() {
        return incomeDay;
    }

    public void setIncomeDay(Integer incomeDay) {
        this.incomeDay = incomeDay;
    }

    @Column(name = "income_category")
    public Integer getIncomeCategory() {
        return incomeCategory;
    }

    public Income setIncomeCategory(Integer incomeCategory) {
        this.incomeCategory = incomeCategory;
        return this;
    }

    @Column(name = "income_type")
    public Integer getIncomeType() {
        return incomeType;
    }

    public Income setIncomeType(Integer incomeType) {
        this.incomeType = incomeType;
        return this;
    }

}
