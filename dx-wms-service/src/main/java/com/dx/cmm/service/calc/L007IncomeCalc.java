/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: L007IncomeCalc.java
 * Author:   caidengyong
 * Date:     2016年10月27日 下午9:03:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cmm.service.calc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.common.service.utils.Assert;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author caidengyong
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("l007IncomeCalc")
public class L007IncomeCalc extends CalcAbs<InvestmentPool, BigDecimal> {

    @Autowired
    private Calc<DateParamCalc, DateResultCalc> dateCalc;

    /*
     * (non-Javadoc)
     * @see com.dx.cmm.service.calc.Calc#calc(java.lang.Object)
     */
    @Override
    public BigDecimal calc(InvestmentPool param) throws CalcException {
        BigDecimal rate = param.getInitTotalAmount().compareTo(new BigDecimal("500000")) >= 0 ? new BigDecimal("0.0095")
                : new BigDecimal("0.0090");
        if (Assert.equals(param.getCurrentPeriod(), 1)) {
            DateResultCalc result = dateCalc.calc(new DateParamCalc(param.getInterestBeginTime(), param.getBillDay()));
            rate = rate.multiply(result.getSufRate());
        }
        return param.getInitTotalAmount().multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
