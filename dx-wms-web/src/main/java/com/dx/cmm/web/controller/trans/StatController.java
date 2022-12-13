package com.dx.cmm.web.controller.trans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.trans.TransStatDetailResult;
import com.dx.cmm.service.trans.TransStatParam;
import com.dx.cmm.service.trans.TransStatResult;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

@Controller("transStatController")
@RequestMapping("/trans/stat")
public class StatController extends TransController {

    private static final String STAT = "/trans/stat/list";

    private static final String DETAIL = "/trans/stat/detail";

    @RequestMapping("/list.htm")
    public String init() {
        return STAT;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<StatResult> init(TransStatParam param, DataTableObj dTable) {
        return parse(transService.queryStat(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<StatResult> parse(PaginationResult<List<TransStatResult>> page, DataTableObj dTable) {
        List<StatResult> results = new ArrayList<StatResult>();
        for (TransStatResult result : page.getR()) {
            results.add(new StatResult(result));
        }
        return new AjaxDataTableObj<StatResult>(dTable,
                new PaginationResult<List<StatResult>>(results, page.getPagination()));
    }

    private List<StatDetailResult> parse(List<TransStatDetailResult> results) {
        List<StatDetailResult> stats = new ArrayList<StatDetailResult>();
        for (TransStatDetailResult result : results) {
            stats.add(new StatDetailResult(result));
        }
        return stats;
    }

    @RequestMapping("/detail.json")
    public String detail(Long dateId, Model model) {
        model.addAttribute("stats", parse(transService.queryDetail(new Date(dateId))));
        return DETAIL;
    }
}
