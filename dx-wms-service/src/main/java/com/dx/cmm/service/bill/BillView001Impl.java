/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: BV001Impl.java
 * Author:   蔡登勇
 * Date:     2015年8月1日 下午7:36:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.bill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.base.IMatchBizBaseDao;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.dto.BillViewDto;
import com.dx.cmm.service.dto.TransferTotalDto;
import com.dx.cmm.service.intf.ICreditorDetailService;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.pools.Pools;
import com.dx.cmm.service.results.IMatchResultDao;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.common.service.utils.MathUtils;
import com.dx.wms.constant.ProductConstant;
import com.dx.wms.service.IProductService;
import com.dx.wms.vo.CreditorDetailVo;
import com.dx.wms.vo.LenderDetailVo;

/**
 * 首期债权转让及受让协议
 *
 * @author 蔡登勇
 */
@Service
public class BillView001Impl extends BillViewService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(BillView001Impl.class);

    /**
     * 匹配业务基础表Dao
     */
    @Autowired
    private IMatchBizBaseDao matchBizBaseDao;

    /**
     * 匹配结果表Dao
     */
    @Autowired
    private IMatchResultDao matchResultDao;

    /**
     * 产品服务（内部）
     */
    @Autowired
    private IProductService productService;

    /**
     * 债权池服务
     */
    @Autowired
    private ICreditorDetailService creditorDetailService;

    @Autowired
    private Pools<InvestmentPool> investPool;

    @Override
    public String init(Map<String, Object> param) {
        return "match_view/first_transfer_view";
    }

    @Override
    public BillViewDto doQuery(Map<String, Object> param) {
        LOG.info("doQuery() param:{}", param);
        Long matchBizBaseId = (Long) param.get(BillViewConstant.MATCH_BIZ_BASE_ID);
        Assert.notNull("匹配业务基础Id异常", matchBizBaseId);
        MatchBizBase matchBizBase = matchBizBaseDao.queryById(MatchBizBase.class, matchBizBaseId);
        Assert.notNull("匹配业务基础对象获取失败", matchBizBase, matchBizBase.getMatchBizBaseId());
        InvestmentPool investmentPool = investPool.query(matchBizBase);
        Assert.notNull("投资池对象获取失败", investmentPool, investmentPool.getInvestmentPoolId());
        Assert.notNull("匹配日期获取失败", investmentPool.getInitMatchTime());
        TransferTotalDto eaDto = matchResultDao.getTotalIncome(investmentPool.getInvestmentPoolId(), 1);
        Assert.notNull("返回对象为空", eaDto);
        Date matchDate = DateUtils.getNextWorkday(investmentPool.getInitMatchTime());
        eaDto.calculate(matchDate, investmentPool.getBillDay());
        List<CreditorDetailVo> vos = creditorDetailService.getByInvestmentId(investmentPool.getInvestmentPoolId(), 1,
                matchDate);
        Map<String, Object> totalAmount = getTotalAmount(vos);
        BillViewDto billViewDto = new BillViewDto();
        billViewDto.setMatchDate(matchDate);
        billViewDto.setLenderCustName(matchBizBase.getCustName());
        billViewDto.setLenderCustAddress(matchBizBase.getCustAddress());
        billViewDto.setLenderCustZip(matchBizBase.getZipCode().replaceAll("\\w(?=\\w)", "$0 "));
        billViewDto.setLenderCode(matchBizBase.getBizCode());
        billViewDto.setLenderCustIdCard(matchBizBase.getIdCard());
        billViewDto.setLenderDetailVos(getLenderDetailDtos(eaDto, matchBizBase, investmentPool));
        String cnAmount = AmountUtils.toChinese(investmentPool.getInitTotalAmount().toString());
        billViewDto.setLenderAmountCn(
                cnAmount.lastIndexOf("元") == (cnAmount.length() - 1) ? cnAmount.concat("整") : cnAmount);
        billViewDto.setLenderAmountView(AmountUtils.format(investmentPool.getInitTotalAmount(), "0.00"));
        billViewDto.setPrintDate(DateUtils.formatForDay(matchDate, ""));
        billViewDto.setTotalCreditorAmount(totalAmount.get(BillViewConstant.CA).toString());
        billViewDto.setTotalPayConsideration(totalAmount.get(BillViewConstant.PC).toString());
        billViewDto.setCreditorDetailVos(vos);
        return billViewDto;
    }

    @Override
    public boolean supports(Map<String, Object> param) {
        return BillViewConstant.BV001.equals(MapUtils.getValue(param, BillViewConstant.BILL_VIEW_CODE));
    }

    private List<LenderDetailVo> getLenderDetailDtos(TransferTotalDto dto, MatchBizBase matchBizBase,
            InvestmentPool pool) {
        List<LenderDetailVo> vos = new ArrayList<LenderDetailVo>();
        LenderDetailVo vo = new LenderDetailVo();
        vo.setLenderCode(matchBizBase.getBizCode());
        vo.setProductName(productService.queryByProductId(ProductConstant.WMS_SYSTEM, matchBizBase.getBizProductId())
                .getProductName());
        vo.setNextRepRepayAmount(AmountUtils.format(dto.getIncomeRepayAmount(), "0.00"));
        vo.setAccountManagerAmount(AmountUtils.format(BigDecimal.ZERO, "0.00"));
        vo.setNextRepAssetAmount(
                AmountUtils.format(pool.getInitTotalAmount().add(dto.getIncomeInterestAmount()), "0.00"));
        vo.setBizStartDate(DateUtils.formatForDay(pool.getCreateTime(), ""));
        vo.setNextReportDate(
                DateUtils.formatForDay(DateUtils.nextMonthFirstDate(pool.getInitMatchTime(), pool.getBillDay()), ""));
        vo.setLenderAmount(AmountUtils.format(pool.getInitTotalAmount().setScale(2, BigDecimal.ROUND_HALF_UP), "0.00"));
        vos.add(vo);
        return vos;
    }

    /**
     * 
     * 功能描述: 传入债权列表获取 合计转让债权价值 合计需支付对价
     *
     * @param vos
     * @return
     */
    private Map<String, Object> getTotalAmount(List<CreditorDetailVo> vos) {
        Map<String, Object> tmpMap = new HashMap<String, Object>();
        BigDecimal arg0 = BigDecimal.ZERO;
        BigDecimal arg1 = BigDecimal.ZERO;
        for (CreditorDetailVo vo : vos) {
            arg0 = MathUtils.add(arg0, vo.getCreditorAmount());
            arg1 = MathUtils.add(arg1, vo.getPayConsideration());
        }
        tmpMap.put(BillViewConstant.CA, AmountUtils.format(arg0.setScale(2, BigDecimal.ROUND_HALF_UP), "0.00"));
        tmpMap.put(BillViewConstant.PC, AmountUtils.format(arg1.setScale(2, BigDecimal.ROUND_HALF_UP), "0.00"));
        tmpMap.put("cdvs", vos);
        return tmpMap;
    }
}
