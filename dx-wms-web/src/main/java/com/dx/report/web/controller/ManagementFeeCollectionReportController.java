package com.dx.report.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.ports.Port;
import com.dx.cmm.service.report.manageFee.IManageFeeService;
import com.dx.cmm.service.report.manageFee.ManageFeeParam;
import com.dx.cmm.service.report.manageFee.ManageFeeResult;
import com.dx.cmm.web.controller.BaseController;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;

@Controller
@RequestMapping(value="/report/manage")
public class ManagementFeeCollectionReportController extends BaseController {
	
	private static final String FTL = "/report/manageFee/list";
	
    /**
     * 导出业务数据excel表头
     */
    private static final String[] MANAGEFEE_DATA_HEAD = { "出借编号", "客户姓名","身份证号","账户级别", "资金出借及回收方式","账单日","服务费","开户银行","账户名","账号","营业部","统计日期"};
	
	@Autowired
	private IManageFeeService manageFeeService;
	
	@RequestMapping(INIT_HTM)
	public String init(Model model){
		model.addAttribute(PORT, Port.PORT);
		return FTL;
	}
	
	@RequestMapping(INIT_URL)
	@ResponseBody
	public AjaxDataTableObj<ManageFeeResult> initPage(ManageFeeParam param, DataTableObj dTable){
		
		PaginationResult<List<ManageFeeResult>> result = manageFeeService.queryAndAssembleManageFee(param, init(dTable));
		return new AjaxDataTableObj<ManageFeeResult>(dTable,result); 
		
	}
	
	@RequestMapping("excelExoprt.json")
	public void excelExoprt(HttpServletRequest request, HttpServletResponse response){
		
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(0);
        pagination.setPagesize(-1);
        
        ManageFeeParam param = getManageFeeParam(request);
        PaginationResult<List<ManageFeeResult>> manageFeePage = manageFeeService.queryAndAssembleManageFee(param, pagination);
        List<ManageFeeExcelResult> excelResultList = new ArrayList<ManageFeeExcelResult>();
        for(ManageFeeResult result : manageFeePage.getR()){
        	ManageFeeExcelResult excelResult = new ManageFeeExcelResult();
        	BeanUtils.copyProperties(result, excelResult);
        	excelResultList.add(excelResult);
        }
        List<String> headTitle = new ArrayList<String>();
        ExportExcelUtil.excelExoprt(headTitle, MANAGEFEE_DATA_HEAD, null, excelResultList, null, "管理费收取明细数据导出", response,
                "yyyy-mm-dd");
	}

	private ManageFeeParam getManageFeeParam(HttpServletRequest request){
		ManageFeeParam param = new ManageFeeParam();
		param.setLenderCode(request.getParameter("lenderCode"));
		param.setBillDay(request.getParameter("billDay"));
		param.setStatisticDate(request.getParameter("statisticDate"));
		return param;
		
	}
}
