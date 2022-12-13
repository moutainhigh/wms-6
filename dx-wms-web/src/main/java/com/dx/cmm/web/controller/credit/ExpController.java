package com.dx.cmm.web.controller.credit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.credit.CreditExpResult;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

@Controller("creditExpController")
@RequestMapping("/credit/exp")
public class ExpController extends CreditController {

    private static final String FTL = "/credit/exp/list";

    @RequestMapping("/init.json")
    public String init(Integer port, Model model) {
        model.addAttribute("port", port);
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<ExpResult> init(Integer port, DataTableObj dTable) {
        return parse(creditService.queryExp(port), dTable);
    }

    private AjaxDataTableObj<ExpResult> parse(List<CreditExpResult> credits, DataTableObj dTable) {
        List<ExpResult> results = new ArrayList<ExpResult>();
        Map<Long, String> product = productService.query(APP);
        for (CreditExpResult credit : credits) {
            results.add(new ExpResult(credit, product));
        }
        Pagination page = new Pagination(results.size(), 1);
        page.setTotalRows(results.size());
        return new AjaxDataTableObj<ExpResult>(dTable, new PaginationResult<List<ExpResult>>(results, page));
    }
}
