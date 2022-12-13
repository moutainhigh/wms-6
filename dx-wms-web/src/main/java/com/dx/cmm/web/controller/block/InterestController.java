package com.dx.cmm.web.controller.block;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.block.BlockInterestResult;
import com.dx.cmm.service.block.IBlockService;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

@Controller("blockInterestController")
@RequestMapping("/block/interest")
public class InterestController extends BlockController {

    private static final String FTL = "/block/interest/list";

    @Autowired
    private IBlockService blockService;

    @RequestMapping("/list.htm")
    public String init() {
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<InterestResult> load(DataTableObj dTable) {
        return parse(blockService.queryInterest(), dTable);
    }

    private AjaxDataTableObj<InterestResult> parse(List<BlockInterestResult> invests, DataTableObj dTable) {
        List<InterestResult> results = new ArrayList<InterestResult>();
        for (BlockInterestResult invest : invests) {
            results.add(new InterestResult(invest));
        }
        Pagination page = new Pagination(results.size(), 1);
        page.setTotalRows(results.size());
        return new AjaxDataTableObj<InterestResult>(dTable, new PaginationResult<List<InterestResult>>(results, page));
    }
}