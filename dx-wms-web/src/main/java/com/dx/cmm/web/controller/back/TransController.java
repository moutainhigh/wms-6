package com.dx.cmm.web.controller.back;

import java.math.BigDecimal;
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
import com.dx.cmm.service.back.BackTransParam;
import com.dx.cmm.service.back.BackTransResult;
import com.dx.cmm.service.base.BizBase;
import com.dx.cmm.service.base.MatchBizBase;
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
import com.dx.wms.service.apply.dao.LenderApplyDaoImpl;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;
import com.google.gson.Gson;

import cn.creditrest.finance.api.model.DealRecordModel;
import cn.creditrest.finance.api.model.ProcessResultModel;

/**
 * 到期回款跳转
 * @param <T>
 * @param <T>
 * 
 */
@Controller("backTransController")
@RequestMapping("/back/trans")
public class TransController<T> extends BackController {

    private static final String FTL = "/back/trans/list";
    
    /*
	 * 导出数据excel表头
	 */
	private static final String[] TANS_DATA_HEAD ={"账单日","客户姓名","身份证",
		"出借编号","出借方式","初始出借金额","初始出借日期","转让日期","转让对价",
		"付款日期（T+1）","付款金额","开户行","账户名","账号"};
    @Autowired
    private ILenderApplyQuery lenderApplyQuery;
    
    @Autowired
    private BizBase<T> investBizBase ; 
    
    @Autowired
    private IInvestmentPoolDao investmentPoolDao;
    
    @Autowired
    private LenderApplyDaoImpl lenderApplyDaoImpl;

    @RequestMapping("/list.htm")
    public String init(Model model) {
        model.addAttribute(PORT, Port.PORT);
        model.addAttribute("products", productService.getTransProductByApp(INVEST));
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<TransResult> init(BackTransParam param, DataTableObj dTable) {
        return parse(matchBackService.queryTrans(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<TransResult> parse(PaginationResult<List<BackTransResult>> page, DataTableObj dTable) {
        List<TransResult> results = new ArrayList<TransResult>();
        Map<Long, String> product = productService.query(INVEST);
        for (BackTransResult result : page.getR()) {
            results.add(new TransResult(result, lenderApplyService, product));
        }
        return new AjaxDataTableObj<TransResult>(dTable,
                new PaginationResult<List<TransResult>>(results, page.getPagination()));
    }

    @RequestMapping("/push.json")
    @ResponseBody
    public Map<String, Object> push(@RequestBody List<TransResult> results, HttpServletRequest request) {
        Map<String, Object> result = result();
        List<DealRecordModel> records = new ArrayList<DealRecordModel>();
        try {
            for (TransResult trans : results) {
                records.add(parse(trans));
            }
            Map<String, ProcessResultModel> trade = financeDataProcessRestService.receive(records);
            Integer success = 0;
            Integer error = 0;
            for (TransResult trans : results) {
                if (trade.containsKey(trans.getLenderCode())) {
                    if (Assert.checkParam(trade.get(trans.getLenderCode()).getIsSuccess())) {
                        investFund.exe(trans.getFundId());
                        success++;
                        continue;
                    }
                    LOG.error("Lender code[{}] push error[{}]", trans.getLenderCode(),
                            new Gson().toJson(trade.get(trans.getLenderCode())));

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
        PaginationResult <List<BackTransResult>> page = matchBackService.queryTrans(trans2Query(request), pagination);
        List<ExportExcelResult> excelResult = new ArrayList<ExportExcelResult>();
        Map<Long, String> product = productService.query(INVEST);
        for(BackTransResult result : page.getR()){
        	TransResult tr = new TransResult(result, lenderApplyService, product);
        	excelResult.add(new ExportExcelResult(tr));
        }
        List<String> requirements = new ArrayList<String>();
        ExportExcelUtil.excelExoprt(requirements, TANS_DATA_HEAD, null, excelResult, null, "到期回款数据导出", response,
                "yyyy-mm-dd");
    }
    private BackTransParam trans2Query(HttpServletRequest request) {
    	BackTransParam param = new BackTransParam();
        String lenderCode = request.getParameter("lenderCode");
        param.setLenderCode(Assert.checkParam(lenderCode) ? lenderCode : null);
        String BillDay = request.getParameter("BillDay");
        param.setBillDay(Assert.checkParam(BillDay) ? Integer.parseInt(BillDay) : null);
        String productId =  request.getParameter("productId");
        param.setProductId(Assert.checkParam(productId) ? Long.parseLong(productId) : null);
        String transTimeBegin = request.getParameter("transTimeBegin");
        param.setTransTimeBegin(Assert.checkParam(transTimeBegin) ? DateUtils.parseForDay(transTimeBegin) : null);
        String transTimeEnd = request.getParameter("transTimeEnd");
        param.setTransTimeEnd(Assert.checkParam(transTimeEnd) ? DateUtils.parseForDay(transTimeEnd) : null);
        return  param;
    }
    private DealRecordModel parse(TransResult result) {
    	DealRecordModel record = new DealRecordModel();
        record.setBizId(result.getFundId().intValue());
        record.setOrderNo(result.getLenderCode());
        record.setSubOrderNo(result.getLenderCode());
        record.setBizSource(1);
        record.setBizType(2);
        record.setSubBizType(19);
        record.setTradeType(2);	
        record.setCustName(result.getCustName());
        record.setCertType(1);
        record.setCertNo(result.getIdCard());
        record.setMobileNo(result.getMobile());
        record.setTradeAmount(result.getTransTotalAmount());
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
    
    private TransDataResult getData(TransResult result){
    	TransDataResult dataResult = new TransDataResult();
    	LenderApply apply = lenderApplyQuery.queryByLenderCode(result.getLenderCode());
    	dataResult.setLenderCode(result.getLenderCode());
    	dataResult.setProduct(result.getProductId());
    	MatchBizBase base = investBizBase.query(result.getLenderCode());
    	dataResult.setInitTotalAmount(Assert.checkParam(base.getBizTotalAmount()) ? base.getBizTotalAmount() : BigDecimal.ZERO);
    	InvestmentPool pool = investmentPoolDao.query(base.getMatchBizBaseId());
    	dataResult.setInitLendDate(DateUtils.formatForFull(pool.getInterestBeginTime()));
    	dataResult.setTransDate(DateUtils.formatForFull(pool.getTransTime()));
    	dataResult.setTransCreditorAmount(Assert.checkParam(pool.getTransCreditorAmount()) ? pool.getTransCreditorAmount() : BigDecimal.ZERO);
    	dataResult.setTransTotalAmount(Assert.checkParam(pool.getTransTotalAmount()) ? pool.getTransTotalAmount() : BigDecimal.ZERO);
    	dataResult.setIsContinue(Boolean.FALSE);
    	dataResult.setPaymentAmount(Assert.checkParam(pool.getTransTotalAmount()) ? pool.getTransTotalAmount() : BigDecimal.ZERO );
    	dataResult.setPredictPaymentDate(DateUtils.formatForFull(getPaymentDate(pool.getTransTime())));
    	dataResult.setBillDay(pool.getBillDay());
    	setContinue(dataResult,apply.getLenderApplyId());
    	return dataResult;
    }
    
    private Date getPaymentDate(Date transDate){
    	return DateUtils.getNextWorkday(transDate);
    }
    
    private void setContinue(TransDataResult result ,Long lenderApplyId){
    	List<LenderApply> applys = lenderApplyDaoImpl.queryContinue();
    	for(LenderApply apply : applys){
    		if(Assert.equals(lenderApplyId, apply.getParentId())){
    			result.setIsContinue(Boolean.TRUE);
    			result.setContinueInvestAmount(apply.getLenderAmount());
    			return ;
    		}
    	}
    }
}