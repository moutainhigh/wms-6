package com.dx.cmm.web.controller.credit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.credit.CreditStatDetailResult;
import com.dx.cmm.service.credit.CreditStatParam;
import com.dx.cmm.service.credit.CreditStatResult;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

@Controller("creditStatController")
@RequestMapping("/credit/stat")
public class StatController extends CreditController {

    private static final String STAT = "/credit/stat/list";

    private static final String CUR = "/credit/current/list";

    private static final String DETAIL = "/credit/stat/detail";

    @RequestMapping("/list.htm")
    public String init() {
        return STAT;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<StatResult> init(CreditStatParam param, DataTableObj dTable) {
        return parse(creditService.queryStat(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<StatResult> parse(PaginationResult<List<CreditStatResult>> page, DataTableObj dTable) {
        List<StatResult> results = new ArrayList<StatResult>();
        for (CreditStatResult result : page.getR()) {
            results.add(new StatResult(result));
        }
        return new AjaxDataTableObj<StatResult>(dTable,
                new PaginationResult<List<StatResult>>(results, page.getPagination()));
    }

    @RequestMapping("/current.json")
    public String current(Model model) {
        model.addAttribute("stats", parse(creditService.queryCurrent()));
        return CUR;
    }

    private List<StatDetailResult> parse(List<CreditStatDetailResult> results) {
        List<StatDetailResult> stats = new ArrayList<StatDetailResult>();
        for (CreditStatDetailResult result : results) {
            stats.add(new StatDetailResult(result));
        }
        return stats;
    }

    @RequestMapping("/detail.json")
    public String detail(Long dateId, Model model) {
        model.addAttribute("stats", parse(creditService.queryDetail(new Date(dateId))));
        return DETAIL;
    }

}
