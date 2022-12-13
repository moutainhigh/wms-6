package com.dx.cmm.web.controller.credit;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.credit.CreditPoolParam;
import com.dx.cmm.service.credit.CreditPoolResult;
import com.dx.cmm.service.ports.Port;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;

@Controller("creditPoolController")
@RequestMapping("/credit/pool")
public class PoolController extends CreditController {
	
	/*
	 * 导出数据excel表头
	 */
	private static final String[] CREDIT_DATA_HEAD ={"客户姓名","身份证","合同编号",
		"还款日","初始借款金额","还款起始","还款期限","剩余还款月数","年利率","产品类型",
		"每期还款","月利率","已还款期数","当期剩余本金","当期新增资金","当前剩余债权",
		"上期债权总价值","上期已匹配价值","上期未匹配价值","上期应还利息","上期应还本金"};

    private static final String FTL = "/credit/pool/list";

    @RequestMapping("/list.htm")
    public String init(Model model) {
        model.addAttribute(PORT, Port.PORT);
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<PoolResult> init(CreditPoolParam param, DataTableObj dTable) {
        return parse(creditService.queryPool(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<PoolResult> parse(PaginationResult<List<CreditPoolResult>> page, DataTableObj dTable) {
        List<PoolResult> results = new ArrayList<PoolResult>();
        Map<Long, String> product = productService.query(APP);
        for (CreditPoolResult result : page.getR()) {
            results.add(new PoolResult(result, product));
        }
        return new AjaxDataTableObj<PoolResult>(dTable,
                new PaginationResult<List<PoolResult>>(results, page.getPagination()));
    }
    
    @RequestMapping("excelExport.json")
    public void excelExport(HttpServletRequest request, HttpServletResponse response){
    	Pagination pagination = new Pagination();
        pagination.setCurrentPage(0);
        pagination.setPagesize(-1);
        PaginationResult <List<CreditPoolResult>> page = creditService.queryPool(trans2Query(request), pagination);
        List<ExportExcelResult> excelResult = new ArrayList<ExportExcelResult>();
        Map<Long, String> product = productService.query(APP);
        for(CreditPoolResult result : page.getR()){
        	PoolResult pool = new PoolResult(result,product);
        	excelResult.add(new ExportExcelResult(pool));
        }
        List<String> requirements = new ArrayList<String>();
        ExportExcelUtil.excelExoprt(requirements, CREDIT_DATA_HEAD, null, excelResult, null, "债权明细数据导出", response,
                "yyyy-mm-dd");
    }
    
    private CreditPoolParam trans2Query(HttpServletRequest request) {
        CreditPoolParam param = new CreditPoolParam();
        String custName=null;
		try {
			custName = new String(request.getParameter("custName").getBytes("iso8859-1"),"utf-8");
			param.setCustName(Assert.checkParam(custName) ? custName : null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String idCard = request.getParameter("idCard");
        param.setIdCard(Assert.checkParam(idCard) ? idCard : null);
        String contractNo = request.getParameter("contractNo");
        param.setContractNo(Assert.checkParam(contractNo) ? contractNo : null);
        String repayDay =  request.getParameter("repayDay");
        param.setRepayDay(Assert.checkParam(repayDay) ? Integer.parseInt(repayDay) : null);
        String createDateBegin = request.getParameter("createDateBegin");
        param.setCreateDateBegin(Assert.checkParam(createDateBegin) ? DateUtils.parseForDay(createDateBegin) : null);
        String createDateEnd = request.getParameter("createDateEnd");
        param.setCreateDateEnd(Assert.checkParam(createDateEnd) ? DateUtils.parseForDay(createDateEnd) : null);
        return  param;
    }
}
