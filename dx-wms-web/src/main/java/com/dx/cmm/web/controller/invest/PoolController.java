package com.dx.cmm.web.controller.invest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.ccs.service.IAMService;
import com.dx.cmm.service.invest.InvestPoolParam;
import com.dx.cmm.service.invest.InvestResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;

@Controller("investPoolController")
@RequestMapping("/invest/pool")
public class PoolController extends InvestController {

    /**
     * 导出业务数据excel表头
     */
    private static final String[] POOL_DATA_HEAD = { "申请日期","出借编号", "客户姓名", "性别", "身份证号", "出借方式", "出借金额",  "客户分类",
            "预计出借日期", "支付方式", "划扣银行", "划扣账号", "账户名", "回款银行", "回款账号", "账户名", "联系地址", "邮编", "团队主管", "客户经理", "区域", "营业部",
            "文件接收方式", "电子邮箱", "手机号", "账单日", "匹配日期" };

    @Autowired
    private ILenderApplyService lenderApplyService;

    @Autowired
    private IAMService amService;

    private static final String FTL = "/invest/pool/list";

    @RequestMapping("/list.htm")
    public String init(Model model) {
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<PoolResult> init(InvestPoolParam param, DataTableObj dTable) {
        return parse(investService.queryPool(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<PoolResult> parse(PaginationResult<List<InvestResult>> page, DataTableObj dTable) {
        List<PoolResult> results = new ArrayList<PoolResult>();
        Map<Long, String> product = productService.query(APP);
        for (InvestResult result : page.getR()) {
            results.add(new PoolResult(result, lenderApplyService, amService, product));
        }
        return new AjaxDataTableObj<PoolResult>(dTable, new PaginationResult<List<PoolResult>>(results,
                page.getPagination()));
    }

    @RequestMapping("excelExoprt.json")          
    public void excelExoprt(HttpServletRequest request, HttpServletResponse response) {
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(0);
        pagination.setPagesize(-1);
        PaginationResult<List<InvestResult>> page = investService.queryPool(trans2Query(request), pagination);
        List<ExcPoolResult> excResults = new ArrayList<ExcPoolResult>();
        Map<Long, String> product = productService.query(APP);
        for (InvestResult result : page.getR()) {
            PoolResult pool = new PoolResult(result, lenderApplyService, amService, product);
            excResults.add(new ExcPoolResult(pool));
        }
        List<String> headTitle = new ArrayList<String>();
        ExportExcelUtil.excelExoprt(headTitle, POOL_DATA_HEAD, null, excResults, null, "每日匹配数据导出", response,
                "yyyy-mm-dd");
    }
    
    private InvestPoolParam trans2Query(HttpServletRequest request) {
        InvestPoolParam param = new InvestPoolParam();
        String lenderCode = request.getParameter("lenderCode");
        param.setLenderCode(Assert.checkParam(lenderCode) ? lenderCode : null);
        String idCard = request.getParameter("idCard");
        param.setIdCard(Assert.checkParam(idCard) ? idCard : null);
        String initMatchDateBegin = request.getParameter("initMatchDateBegin");
        param.setInitMatchDateBegin(Assert.checkParam(initMatchDateBegin) ? DateUtils.parseForDay(initMatchDateBegin) : null);
        String initMatchDateEnd = request.getParameter("initMatchDateEnd");
        param.setInitMatchDateEnd(Assert.checkParam(initMatchDateEnd) ? DateUtils.parseForDay(initMatchDateEnd) : null);
        return  param;
    }
}
