package com.dx.cmm.web.vo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.cmm.service.dto.MatchViewResultDto;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;

/**
 * 
 * 匹配视图结果vo<br>
 * 匹配视图结果vo
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MatchViewResultVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -8975469886828611983L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 出借金额
     */
    private BigDecimal initTotalAmount;

    /**
     * 出借金额
     */
    private String initTotalAmountView;

    /**
     * 当前总资金
     */
    private BigDecimal currentTotalAmount;

    /**
     * 匹配日期
     */
    private Date matchDate;

    /**
     * 匹配日期
     */
    private String matchDateView;

    /**
     * 状态
     */
    private String dataStatus;

    /**
     * 投资池编号
     */
    private Long poolId;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 业务编号
     */
    private Long bizId;

    /**
     * 产品编号
     */
    private Long productId;

    /**
     * 产品
     */
    private String productView;
    /**
     * 当前期数
     */
    private Integer currentPeriod;

    /**
     * 收益
     */
    private BigDecimal totalIncome;

    /**
     * 下个报告日资产总价值
     */
    private BigDecimal nextReportAmount;

    /**
     * 下个报告日资产总价值
     */
    private String nextReportAmountView;

    /**
     * 生效日期
     */
    private Date interestBeginTime;

    /**
     * 生效日期
     */
    private String interestBeginTimeView;

    /**
     * 首次匹配日期
     */
    private Date initMatchTime;

    /**
     * 首次匹配日期
     */
    private String initMatchTimeView;

    /**
     * 转让日期
     */
    private Date transTime;

    /**
     * 转让日期
     */
    private String transTimeView;

    /**
     * 转让对价
     */
    private BigDecimal transTotalAmount;

    /**
     * 转让对价
     */
    private String transTotalAmountView;

    /**
     * 转让日债权价值
     */
    private BigDecimal transCreditorAmount;

    /**
     * 转让日债权价值
     */
    private String transCreditorAmountView;

    public MatchViewResultVo() {

    }

    public MatchViewResultVo(MatchViewResultDto dto, Map<String, String> productMap) {
        try {
            PropertyUtils.copyProperties(this, dto);
            setInitTotalAmountView((AmountUtils.format(dto.getInitTotalAmount(), "-")));
            setProductView(productMap.get(dto.getProductId().toString()));
            setNextReportAmount(dto.getCurrentTotalAmount().add(getIncome(dto)));
            setNextReportAmountView(AmountUtils.format(getNextReportAmount(), "-"));
            setMatchDateView(DateUtils.formatForDay(getMatchDate(), "-"));
            setInterestBeginTimeView(DateUtils.formatForDay(getInterestBeginTime(), "-"));
            setInitMatchTimeView(DateUtils.formatForDay(getInitMatchTime(), "-"));
            setTransTimeView(DateUtils.formatForDay(getTransTime(), "-"));
            setTransTotalAmountView(AmountUtils.format(getTransTotalAmount(), "-"));
            setTransCreditorAmountView(AmountUtils.format(getTransCreditorAmount(), "-"));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        }
    }

    private BigDecimal getIncome(MatchViewResultDto dto) {
        BigDecimal totalIncome = BigDecimal.ZERO;
        if (Assert.equals(dto.getCurrentPeriod(), 1)) {
            Date matchDay = Assert.checkParam(dto.getInterestBeginTime()) ? dto.getInterestBeginTime()
                    : DateUtils.getNextWorkday(dto.getMatchDate());
            Integer full = DateUtils.getDays(DateUtils.getBeginDay(matchDay, dto.getBillDay()),
                    DateUtils.getLastDay(matchDay, dto.getBillDay()));
            Integer part = DateUtils.getDays(matchDay, DateUtils.getLastDay(matchDay, dto.getBillDay()));
            totalIncome = getTotalIncome()
                    .multiply(
                            new BigDecimal(part.toString()).divide(new BigDecimal(full), 15, BigDecimal.ROUND_HALF_UP))
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return totalIncome;
    }

    public Date getInterestBeginTime() {
        return interestBeginTime;
    }

    public void setInterestBeginTime(Date interestBeginTime) {
        this.interestBeginTime = interestBeginTime;
    }

    public String getInterestBeginTimeView() {
        return interestBeginTimeView;
    }

    public void setInterestBeginTimeView(String interestBeginTimeView) {
        this.interestBeginTimeView = interestBeginTimeView;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public BigDecimal getCurrentTotalAmount() {
        return currentTotalAmount;
    }

    public void setCurrentTotalAmount(BigDecimal currentTotalAmount) {
        this.currentTotalAmount = currentTotalAmount;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getInitTotalAmountView() {
        return initTotalAmountView;
    }

    public void setInitTotalAmountView(String initTotalAmountView) {
        this.initTotalAmountView = initTotalAmountView;
    }

    public String getMatchDateView() {
        return matchDateView;
    }

    public void setMatchDateView(String matchDateView) {
        this.matchDateView = matchDateView;
    }

    public String getProductView() {
        return productView;
    }

    public void setProductView(String productView) {
        this.productView = productView;
    }

    public BigDecimal getNextReportAmount() {
        return nextReportAmount;
    }

    public void setNextReportAmount(BigDecimal nextReportAmount) {
        this.nextReportAmount = nextReportAmount;
    }

    public String getNextReportAmountView() {
        return nextReportAmountView;
    }

    public void setNextReportAmountView(String nextReportAmountView) {
        this.nextReportAmountView = nextReportAmountView;
    }

    public Date getInitMatchTime() {
        return initMatchTime;
    }

    public void setInitMatchTime(Date initMatchTime) {
        this.initMatchTime = initMatchTime;
    }

    public String getInitMatchTimeView() {
        return initMatchTimeView;
    }

    public void setInitMatchTimeView(String initMatchTimeView) {
        this.initMatchTimeView = initMatchTimeView;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public String getTransTimeView() {
        return transTimeView;
    }

    public void setTransTimeView(String transTimeView) {
        this.transTimeView = transTimeView;
    }

    public BigDecimal getTransTotalAmount() {
        return transTotalAmount;
    }

    public void setTransTotalAmount(BigDecimal transTotalAmount) {
        this.transTotalAmount = transTotalAmount;
    }

    public String getTransTotalAmountView() {
        return transTotalAmountView;
    }

    public void setTransTotalAmountView(String transTotalAmountView) {
        this.transTotalAmountView = transTotalAmountView;
    }

    public BigDecimal getTransCreditorAmount() {
        return transCreditorAmount;
    }

    public void setTransCreditorAmount(BigDecimal transCreditorAmount) {
        this.transCreditorAmount = transCreditorAmount;
    }

    public String getTransCreditorAmountView() {
        return transCreditorAmountView;
    }

    public void setTransCreditorAmountView(String transCreditorAmountView) {
        this.transCreditorAmountView = transCreditorAmountView;
    }

}
