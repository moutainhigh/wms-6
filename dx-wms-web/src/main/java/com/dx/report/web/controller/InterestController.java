package com.dx.report.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.interest.InterestParam;
import com.dx.cmm.service.interest.InterestResult;
import com.dx.cmm.service.interest.InterestService;
import com.dx.cmm.service.ports.Port;
import com.dx.cmm.web.controller.BaseController;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.report.web.vo.InterestParamVo;
import com.dx.report.web.vo.InterestVo;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.service.apply.LenderApplyDto;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;

@Controller
@RequestMapping("/report/interest")
public class InterestController extends BaseController{

	@Autowired
	private InterestService interestGateway;
	
	@Autowired
	private ILenderApplyService lenderApplyService;
	
    /**
     * 导出业务数据excel表头
     */
    private static final String[] POOL_DATA_HEAD = { "出借编号","客户姓名","身份证号","账户级别","资金出借及回收方式","账单日","本报告日出借人实际回收利息","开户银行", "账号","账户名",
            "营业部","统计日期"};
	
    private static final String HTM = "report/interest/list";
    
    private static final String FORMAT = "yyyy/MM";
    
    @RequestMapping(INIT_HTM)
    public String init(Model model) {
    	model.addAttribute(PORT, Port.PORT);
        return HTM;
    }
    
    @RequestMapping(INIT_URL)
    @ResponseBody
    public AjaxDataTableObj<InterestVo> init(InterestParamVo param, DataTableObj dTable) {
    	LOG.info("**Init() param={}",param);
    	setReportDay(param);
    	InterestParam params = new InterestParam();
    	BeanUtils.copyProperties(param, params);
        return parse(interestGateway.queryInterest(params, init(dTable)),dTable); 
    }
    
    private AjaxDataTableObj<InterestVo> parse(PaginationResult<List<InterestResult>> page,
            DataTableObj dTable) {
        List<InterestVo> invests = new ArrayList<InterestVo>();
        for (InterestResult result : page.getR()) {
        	InterestVo resultVo = new InterestVo();
        	BeanUtils.copyProperties(result,resultVo);
        	LenderApplyDto apply = lenderApplyService.query(resultVo.getLenderCode());
        	resultVo.set(apply, amService);
        	invests.add(resultVo);
        }
        return new AjaxDataTableObj<InterestVo>(dTable,
                new PaginationResult<List<InterestVo>>(invests, page.getPagination()));
    }
    
    private void setReportDay(InterestParamVo param){
    	if(Assert.checkParam(param.getBillDay()) && Assert.checkParam(param.getCountTime())){
    		Date date = DateUtils.parse(param.getCountTime(), FORMAT);
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(date);
    		calendar.set(Calendar.DAY_OF_MONTH, param.getBillDay());
    		param.setReportDayTimeBegin(calendar.getTime());
    	}
    }
    
    
    @RequestMapping("excelExoprt.json")          
    public void excelExoprt(HttpServletRequest request, HttpServletResponse response) {
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(0);
        pagination.setPagesize(-1);
        PaginationResult<List<InterestResult>> page = interestGateway.queryInterest(getParam(request), pagination);
        List<ExcInterestResult> excResults = new ArrayList<ExcInterestResult>();
        for (InterestResult result : page.getR()) {
        	InterestVo resultVo = new InterestVo();
        	BeanUtils.copyProperties(result,resultVo);
        	LenderApplyDto apply = lenderApplyService.query(resultVo.getLenderCode());
        	resultVo.set(apply, amService);
        	ExcInterestResult interestResult = new ExcInterestResult();
        	BeanUtils.copyProperties(resultVo,interestResult);
        	excResults.add(interestResult);
        }
        List<String> headTitle = new ArrayList<String>();
        ExportExcelUtil.excelExoprt(headTitle, POOL_DATA_HEAD, null, excResults, null, "月回收利息明细", response,
                "yyyy-mm-dd");
    }
    
    private InterestParam getParam(HttpServletRequest request) {
    	InterestParam param = new InterestParam();
        String lenderCode = request.getParameter("lenderCode");
        param.setLenderCode(Assert.checkParam(lenderCode) ? lenderCode : null);
        String billDay = request.getParameter("billDay");
        String countTime = request.getParameter("countTime");
        InterestParamVo paramVo = new InterestParamVo();
        paramVo.setBillDay(Assert.checkParam(billDay) ? Integer.valueOf(billDay) : null);
        paramVo.setCountTime(Assert.checkParam(countTime) ? countTime : null);
        setReportDay(paramVo);
        param.setReportDayTimeBegin(Assert.checkParam(paramVo.getReportDayTimeBegin()) ? paramVo.getReportDayTimeBegin() : null);
        return  param;
    }
}
