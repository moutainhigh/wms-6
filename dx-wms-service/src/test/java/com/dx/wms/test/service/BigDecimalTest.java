package com.dx.wms.test.service;

import java.math.BigDecimal;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.CalculatorUtils;
import com.dx.wms.service.exception.CalculatorIPIsErrorException;

/**
 * 随机生成中文姓名，性别，Email，手机号，住址
 * 
 * @author X-rapido
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal creditorRatio = CalculatorUtils.getCreditorRatio(new BigDecimal("10000"), new BigDecimal("10000"));
        System.out.println(creditorRatio);
        BigDecimal eachRefundPrincipalCreditor = CalculatorUtils.getEachRefundAmountCreditor(creditorRatio,
                new BigDecimal("10000"));
        System.out.println(eachRefundPrincipalCreditor);
        // RepaymentDto i = new RepaymentDto();
        // i = CalculatorUtils.getInterestAndPrincipal(new BigDecimal("10000"), creditorRatio, new
        // BigDecimal("0.011204"), eachRefundPrincipalCreditor);
        // System.out.println(i.getInterest());
        // System.out.println(i.getPrincipal());

        BigDecimal d = CalculatorUtils.getRate(new BigDecimal("82764.89"), 36);
        System.out.println(d);
    }

    /**
     * 实际利率法
     * 
     * @author Bean(mailto)
     * @param a 现值
     * @param b 年金
     * @param c 期数
     * @param cnt 运算次数
     * @param ina 误差位数
     * @return 利率
     */
    public static double rate(double a, double b, double c, int cnt, int ina) {
        double rate = 1, x, jd = 0.1, side = 0.1, i = 1;
        do {
            BigDecimal aB1 = BigDecimal.valueOf(a);
            BigDecimal bB1 = aB1.divide(BigDecimal.valueOf(b), 15, 4);
            x = Double.valueOf(bB1 + "") - (Math.pow(1 + rate, c) - 1) / (Math.pow(rate + 1, c) * rate);
            if (x * side > 0) {
                side = -side;
                jd *= 10;
            }
            rate += side / jd;
        } while (i++ < cnt && Math.abs(x) >= 1 / Math.pow(10, ina));
        if (i > cnt)
            return Double.NaN;
        return rate;
    }

    public static BigDecimal rate(BigDecimal cash, BigDecimal annuity, Integer period, Integer calculateTimes,
            Integer errorDigit) {
        BigDecimal rate = BigDecimal.ONE;
        BigDecimal i = BigDecimal.ONE;
        BigDecimal x = new BigDecimal("0.1");
        BigDecimal jd = new BigDecimal("0.1");
        BigDecimal side = new BigDecimal("0.1");
        do {
            BigDecimal temp = rate.add(BigDecimal.ONE);
            BigDecimal cashTemp = cash.divide(annuity, 8, BigDecimal.ROUND_HALF_UP);
            BigDecimal powerTemp = temp.pow(period).setScale(8, BigDecimal.ROUND_HALF_UP);
            BigDecimal rateTempPower = powerTemp.multiply(rate).setScale(8, BigDecimal.ROUND_HALF_UP);
            BigDecimal rateTemp = BigDecimal.ONE.divide(rateTempPower, 8, BigDecimal.ROUND_HALF_UP);
            BigDecimal powerTmep = temp.pow(period).setScale(8, BigDecimal.ROUND_HALF_UP).subtract(rateTemp);
            x = cashTemp.subtract(powerTmep);
            if (x.multiply(side).compareTo(BigDecimal.ZERO) > 0) {
                side = new BigDecimal("-" + side.toString());
                jd = jd.multiply(BigDecimal.TEN);
            }
            rate = rate.add(side.divide(jd));
        } while (i.add(BigDecimal.ONE).compareTo(BigDecimal.valueOf(calculateTimes)) < 0
                && x.abs().compareTo((BigDecimal.ONE.divide(BigDecimal.TEN.pow(calculateTimes)))) >= 0);
        if (i.compareTo(BigDecimal.valueOf(calculateTimes)) > 0) {
            return BigDecimal.ZERO;
        }
        return rate;

    }

    /**
     * 
     * power函数 次方
     *
     * @param a
     * @param b
     * @return
     */
    public static double power(double a, double b) {
        double pow = Math.pow(a, b);
        return pow;
    }

    /**
     * 
     * 四省五入
     *
     * @param v 需要精确的值
     * @param scale 精确位数
     * @return 精确后的值
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    // /**
    // *
    // * 功能描述:获取实际利率
    // *
    // * @param contractAmount 合同金额
    // * @param calculatePeriod 期限
    // * @return 实际利率
    // */
    // public static BigDecimal getRate(BigDecimal contractAmount, Integer calculatePeriod) {
    // // 实际利率（月）
    // checkRateInParam(contractAmount, calculatePeriod);
    // BigDecimal eachRefundAmount = getEachRefundAmount(contractAmount, calculatePeriod);
    // return rate(contractAmount, eachRefundAmount, calculatePeriod, 200, 12);
    // }

    // /**
    // *
    // * 功能描述:获取实际利率
    // *
    // * @param contractAmount 合同金额
    // * @param eachRefundAmount 每月还款金额
    // * @param calculatePeriod 期限
    // * @return 实际利率
    // */
    // public static BigDecimal getRate(BigDecimal contractAmount, BigDecimal eachRefundAmount, Integer calculatePeriod)
    // {
    // // 实际利率（月）
    // checkRateInParam(contractAmount, calculatePeriod);
    // return CalculatorUtils.rate(contractAmount, eachRefundAmount, calculatePeriod, 200, 12);
    // }

    private static Boolean checkRateInParam(BigDecimal contractAmount, Integer calculatePeriod) {
        boolean flag = false;
        if (!Assert.checkParam(contractAmount)) {
            throw new CalculatorIPIsErrorException("Rate计算： 合同金额入参异常");
        }
        if (!Assert.checkParam(calculatePeriod)) {
            throw new CalculatorIPIsErrorException("Rate计算： 期限入参异常");
        }
        return flag;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据合同金额和期数获取每期还款金额
     *
     * @param contractAmount 合同金额
     * @param periodNum 期数
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static BigDecimal getEachRefundAmount(BigDecimal contractAmount, Integer periodNum) {
        final BigDecimal rate = new BigDecimal("0.0061");
        return (contractAmount.divide(new BigDecimal(periodNum.toString()), 8, BigDecimal.ROUND_HALF_UP)).add(
                contractAmount.multiply(rate)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}