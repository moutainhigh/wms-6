/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: UsualResult.java
 * Author:   朱道灵
 * Date:     2016年5月9日 下午1:46:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.web.controller.back;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.ccs.service.IAMService;
import com.dx.cmm.enums.AccountLevel;
import com.dx.cmm.service.back.BackUsualResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.service.apply.LenderApplyDto;

/**
 * 往期回款查询结果
 *
 * @author 朱道灵
 */
public class UsualResult extends BaseResult {

    /**
     */
    private static final long serialVersionUID = -7417637414308573617L;

    /**
     * 本报告日出借人实际回收利息
     */
    private BigDecimal lenderIncomeAmount;

    /**
     * 本报告日出借人实际回收利息视图
     */
    private String lenderIncomeAmountView;

    /**
     * 账户级别编号
     */
    private Integer accountLevelId;

    /**
     * 账户级别视图
     */
    private String levelView;

    /**
     * 营业部Id
     */
    private Long orgId;

    /**
     * 营业部视图
     */
    private String orgView;

    /**
     * 期数
     */
    private Integer currentPeriod;

    public UsualResult() {

    }

    public UsualResult(BackUsualResult result, ILenderApplyService lenderApplyService, IAMService amService,
            final Map<Long, String> product) {
        BeanUtils.copyProperties(result, this);
        incomeAmountView();
        product(product);
        setLevelView(Assert.checkParam(getAccountLevelId()) ? AccountLevel.getInfo(getAccountLevelId()) : "财富账户");
        setBillDayView(Assert.checkParam(getBillDay()) ? String.valueOf(getBillDay()) : "-");
        LenderApplyDto apply = lenderApplyService.query(result.getLenderCode());
        if (Assert.checkParam(apply)) {
            BeanUtils.copyProperties(apply, this);
            setOrgView(amService.queryOrgById(getOrgId()).getName());
            setBackBankView(MessageFormat.format("{0}{1}", BankCategery.getInfo(getBackBank()), getBackSubBank()));
        }
    }

    public BigDecimal getLenderIncomeAmount() {
        return lenderIncomeAmount;
    }

    public void setLenderIncomeAmount(BigDecimal lenderIncomeAmount) {
        this.lenderIncomeAmount = lenderIncomeAmount;
    }

    public String getLenderIncomeAmountView() {
        return lenderIncomeAmountView;
    }

    public void setLenderIncomeAmountView(String lenderIncomeAmountView) {
        this.lenderIncomeAmountView = lenderIncomeAmountView;
    }

    public void incomeAmountView() {
        setLenderIncomeAmountView(AmountUtils.format(getLenderIncomeAmount(), "0.00"));
    }

    public Integer getAccountLevelId() {
        return accountLevelId;
    }

    public void setAccountLevelId(Integer accountLevelId) {
        this.accountLevelId = accountLevelId;
    }

    public String getLevelView() {
        return levelView;
    }

    public void setLevelView(String levelView) {
        this.levelView = levelView;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgView() {
        return orgView;
    }

    public void setOrgView(String orgView) {
        this.orgView = orgView;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

}
