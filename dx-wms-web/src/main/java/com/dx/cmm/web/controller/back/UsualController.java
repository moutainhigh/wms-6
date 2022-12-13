/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: UsualController.java
 * Author:   朱道灵
 * Date:     2016年5月9日 下午1:37:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.web.controller.back;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.back.BackUsualParam;
import com.dx.cmm.service.back.BackUsualResult;
import com.dx.cmm.service.base.BizBase;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.funds.IInvestmentFundDao;
import com.dx.cmm.service.funds.InvestmentFund;
import com.dx.cmm.service.pools.IInvestmentPoolDao;
import com.dx.cmm.service.pools.InvestmentPool;
import com.dx.cmm.service.ports.Port;
import com.dx.cmm.service.trans.TransDataResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.exception.BaseException;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.service.apply.ILenderApplyQuery;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;
import com.google.gson.Gson;

import cn.creditrest.finance.api.model.DealRecordModel;
import cn.creditrest.finance.api.model.ProcessResultModel;

/**
 * 往期回款跳转
 *
 * @author 朱道灵
 * @param <T>
 */
@Controller("backUsualController")
@RequestMapping("/back/usual")
public class UsualController<T> extends BackController {

    private static final String FTL = "/back/usual/list";
    
    private static final String[] USUAL_DATA_HEAD={"客户姓名","身份证","出借编号",
    	"出借方式","本报告日出借人实际回收利息","账单日","账户级别","开户行",
    	"账户名","账号","营业部"};
    
    @Autowired
    private ILenderApplyQuery lenderApplyQuery;
    
    @Autowired
    private BizBase<T> investBizBase ; 
    
    @Autowired
    private IInvestmentPoolDao investmentPoolDao;
    
    @Autowired
    private IInvestmentFundDao iInvestmentFundDao;

    @RequestMapping("/list.htm")
    public String init(Model model) {
        model.addAttribute(PORT, Port.PORT);
        model.addAttribute("productsForBackUsul", productService.getUsualProductByApp(INVEST));
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<UsualResult> init(BackUsualParam param, DataTableObj dTable) {
        return parse(matchBackService.queryUsual(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<UsualResult> parse(PaginationResult<List<BackUsualResult>> page, DataTableObj dTable) {
        List<UsualResult> results = new ArrayList<UsualResult>();
        Map<Long, String> product = productService.query(INVEST);
        for (BackUsualResult result : page.getR()) {
            results.add(new UsualResult(result, lenderApplyService, amService, product));
        }
        return new AjaxDataTableObj<UsualResult>(dTable,
                new PaginationResult<List<UsualResult>>(results, page.getPagination()));
    }

    @RequestMapping("/push.json")
    @ResponseBody
    public Map<String, Object> push(@RequestBody List<UsualResult> results) {
        Map<String, Object> result = result();
        List<DealRecordModel> records = new ArrayList<DealRecordModel>();
        try {
            for (UsualResult usual : results) {
                records.add(parse(usual));
            }
            Map<String, ProcessResultModel> trade = financeDataProcessRestService.receive(records);
            Integer success = 0;
            Integer error = 0;
            for (UsualResult usual : results) {
                if (trade.containsKey(usual.getLenderCode())) {
                    if (Assert.checkParam(trade.get(usual.getLenderCode()).getIsSuccess())) {
                        investFund.exe(usual.getFundId());
                        success++;
                        continue;
                    }
                    LOG.error("Lender code[{}] push error[{}]", usual.getLenderCode(),
                            new Gson().toJson(trade.get(usual.getLenderCode())));

                }
                error++;
            }
            if (Assert.checkParam(error)) {
                error(result, MessageFormat.format("推送完成,成功[{0}]条,失败[{1}]条", success, error));
            }
        } catch (BaseException e) {
            LOG.error("Push error[{}]", e.getMessage());
            error(result, e);
        }

        return result;
    }

    @RequestMapping("excelExport.json")
    public void excelExport(HttpServletRequest request, HttpServletResponse response){
    	Pagination pagination = new Pagination();
        pagination.setCurrentPage(0);
        pagination.setPagesize(-1);
        PaginationResult <List<BackUsualResult>> page = matchBackService.queryUsual(trans2Query(request), pagination);
        List<ExportUsualExcelResult> excelResult = new ArrayList<ExportUsualExcelResult>();
        Map<Long, String> product = productService.query(INVEST);
        for(BackUsualResult result : page.getR()){
        	UsualResult ur = new UsualResult(result, lenderApplyService,amService, product);
        	excelResult.add(new ExportUsualExcelResult(ur));
        }
        List<String> requirements = new ArrayList<String>();
        ExportExcelUtil.excelExoprt(requirements, USUAL_DATA_HEAD, null, excelResult, null, "到期回款数据导出", response,
                "yyyy-mm-dd");
    }
    private BackUsualParam trans2Query(HttpServletRequest request) {
        BackUsualParam param = new BackUsualParam();
        String lenderCode = request.getParameter("lenderCode");
        param.setLenderCode(Assert.checkParam(lenderCode) ? lenderCode : null);
        String billDay = request.getParameter("billDay");
        param.setBillDay(Assert.checkParam(billDay) ? Integer.parseInt(billDay) : null);
        String productId =  request.getParameter("productId");
        param.setProductId(Assert.checkParam(productId) ? Long.parseLong(productId) : null);
        return  param;
    }
    
    private DealRecordModel parse(UsualResult result) {
    	DealRecordModel record = new DealRecordModel();
        record.setBizId(result.getFundId().intValue());
        record.setOrderNo(result.getLenderCode());
        record.setSubOrderNo(result.getLenderCode());
        record.setBizSource(1);
        record.setBizType(2);
        record.setSubBizType(18);
        record.setTradeType(2);
        record.setCustName(result.getCustName());
        record.setCertType(1);
        record.setCertNo(result.getIdCard());
        record.setMobileNo(result.getMobile());
        record.setTradeAmount(result.getLenderIncomeAmount());
        record.setBankCode(BankCategery.get(result.getBackBank()));
        record.setSubBank(result.getBackSubBank());
        record.setBankAccount(result.getBackAccountNum());
        record.setProvinceCode(result.getProvinceRegionCode());
        record.setCityCode(result.getCityCode());
        LenderApply dto = lenderApplyQuery.queryByLenderCode(result.getLenderCode());
        TransDataResult dataResult = getData(result);
        record.setCertifyDataObject(JSON.toJSONString(dataResult));
        if(Assert.checkParam(dto.getOrgId())){
        	record.setOrgId(dto.getOrgId().intValue());
        }
        return record;
    }
    
    private TransDataResult getData(UsualResult result){
    	TransDataResult dataResult = new TransDataResult();
    	dataResult.setLenderCode(result.getLenderCode());
    	dataResult.setProduct(result.getProductId());
    	MatchBizBase base = investBizBase.query(result.getLenderCode());
    	dataResult.setInitTotalAmount(base.getBizTotalAmount());
    	InvestmentPool pool = investmentPoolDao.query(base.getMatchBizBaseId());
    	dataResult.setInitLendDate(DateUtils.formatForFull(pool.getInterestBeginTime()));
    	dataResult.setIsContinue(Boolean.FALSE);
    	dataResult.setPaymentAmount(result.getLenderIncomeAmount());
    	dataResult.setPredictPaymentDate(DateUtils.formatForFull(getPaymentDate(result.getPoolId(), result.getCurrentPeriod()-1)));
    	dataResult.setBillDay(pool.getBillDay());
    	return dataResult;
    }
    
    private Date getPaymentDate(Long poolId , Integer period){
    	InvestmentFund fund = iInvestmentFundDao.query(poolId, period);
    	return DateUtils.getNextWorkday(fund.getReportDay());
    }
}
