/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CreditorDetailServiceImpl.java
 * Author:   蔡登勇
 * Date:     2015年8月4日 下午10:32:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.dto.CreditDetailDto;
import com.dx.cmm.service.intf.ICreditorDetailService;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.dto.CCSBizAttrDto;
import com.dx.wms.vo.CreditorDetailVo;
import com.google.gson.Gson;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("creditDetailService")
public class CreditDetailServiceImpl implements ICreditorDetailService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CreditDetailServiceImpl.class);

    @Autowired
    private PaginationDalClient dalClient;

    @Override
    public List<CreditorDetailVo> getByInvestmentId(Long investmentId, Integer currentPeriod, Date matchDate) {
        Map<String, Object> param = MapUtils.getParamMap("investmentId", investmentId);
        param.put("currentPeriod", currentPeriod);
        List<CreditDetailDto> dtos = dalClient.queryForList("matchResult.getCreditDetailByInvestmentId", param,
                CreditDetailDto.class);
        List<CreditorDetailVo> vos = new ArrayList<CreditorDetailVo>();
        try {
            for (CreditDetailDto dto : dtos) {
                CreditorDetailVo vo = new CreditorDetailVo();
                PropertyUtils.copyProperties(vo, dto);
                vo.setCreditorAmountView(AmountUtils.format(vo.getCreditorAmount(), "0.00"));
                vo.setPayConsiderationView(AmountUtils.format(vo.getPayConsideration(), "0.00"));
                CCSBizAttrDto attr = new Gson().fromJson(dto.getBizAttr(), CCSBizAttrDto.class);
                vo.setLoanCustWorkSituationView(attr.getWorkSituationCn());
                vo.setLoanPurposeView(attr.getLoanTypeCn() + attr.getLoanTypeOther());
                vo.setBizStartDateView(DateUtils.formatForDay(dto.getBizStartDate(), ""));
                vo.setPeriod(dto.getPeriod());
                Date tmp = DateUtils.nextMonthFirstDate(matchDate, dto.getBillDay());
                vo.setRemainingPeriod(dto.getPeriod() - DateUtils.getMonths(tmp, dto.getBizStartDate()));
                vo.setAnnualReRateView(
                        attr.getAnnualReRate().multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP)
                                + "%");
                vos.add(vo);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOG.error("getByInvestmentId() exception({})", e);
        }

        return vos;
    }

}
