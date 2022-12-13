package com.dx.cmm.web.controller.invest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.invest.InvestStatParam;
import com.dx.cmm.service.invest.InvestStatResult;
import com.dx.cmm.web.controller.invest.StatComparator;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

@Controller("investStatController")
@RequestMapping("/invest/stat")
public class StatController extends InvestController {

    private static final String FTL = "/invest/stat/list";

    @RequestMapping("/list.htm")
    public String initMatch() {
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<StatResult> initMatch(InvestStatParam param, DataTableObj dTable) {
        return parse(investService.queryStat(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<StatResult> parse(PaginationResult<List<InvestStatResult>> page, DataTableObj dTable) {
        List<StatResult> results = new ArrayList<StatResult>();
        for (InvestStatResult result : page.getR()) {
            results.add(new StatResult(result));
        }
        Collections.sort(results, new StatComparator());
        return new AjaxDataTableObj<StatResult>(dTable,
                new PaginationResult<List<StatResult>>(results, page.getPagination()));
    }

}
