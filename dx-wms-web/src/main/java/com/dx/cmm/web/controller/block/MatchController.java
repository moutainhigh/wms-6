package com.dx.cmm.web.controller.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.match.IMatchResService;
import com.dx.cmm.service.match.MatchCache;
import com.dx.cmm.service.match.MatchException;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.ports.Port;
import com.dx.cmm.web.controller.match.result.Credit;
import com.dx.cmm.web.controller.match.result.Invest;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

@Controller("blockMatchController")
@RequestMapping("/block/match")
public class MatchController extends BlockController {

    private static final String FTL = "/block/match/list";

    private static final String CREDIT_URL = "/block/match/credit/list";

    private static final String INVEST_URL = "/block/match/invest/list";

    @Autowired
    private IMatchResService matchResService;

    @RequestMapping("/list.htm")
    public String init() {
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<MatchResult> load(DataTableObj dTable) {
        return parse(matchResService.queryAll(), dTable);
    }

    private AjaxDataTableObj<MatchResult> parse(List<MatchCache> matches, DataTableObj dTable) {
        List<MatchResult> results = new ArrayList<MatchResult>();
        for (MatchCache match : matches) {
            results.add(new MatchResult(match, amService));
        }
        Pagination page = new Pagination(matches.size(), 1);
        page.setTotalRows(matches.size());
        return new AjaxDataTableObj<MatchResult>(dTable, new PaginationResult<List<MatchResult>>(results, page));
    }

    @RequestMapping("/remove.json")
    @ResponseBody
    public Map<String, Object> remove(Long userId, HttpServletRequest request) {
        Map<String, Object> result = result();
        try {
            matchResService.destory(userId);
        } catch (MatchException e) {
            LOG.error("Remove user[{}] error", userId);
            error(result, e);
        }
        return result;
    }

    private void error(Map<String, Object> result, MatchException e) {
        result.put("result", false);
        result.put("msg", e.getMessage());
    }

    @RequestMapping("/credit/init.json")
    public String creditInit(Long userId, Model model) {
        model.addAttribute("userId", userId);
        return CREDIT_URL;
    }

    @RequestMapping("/credit/list.json")
    @ResponseBody
    public AjaxDataTableObj<Credit> creditInit(Long userId, DataTableObj dTable) {
        return parseCredit(matchResService.queryCredit(userId), dTable);
    }

    private AjaxDataTableObj<Credit> parseCredit(Set<CreditResult> credits, DataTableObj dTable) {
        List<Credit> results = new ArrayList<Credit>();
        Map<Long, String> product = productService.query(CREDIT);
        for (CreditResult credit : credits) {
            results.add(new Credit(credit, product, Port.PORT));
        }
        Pagination page = new Pagination(results.size(), 1);
        page.setTotalRows(results.size());
        return new AjaxDataTableObj<Credit>(dTable, new PaginationResult<List<Credit>>(results, page));
    }

    @RequestMapping("/invest/init.json")
    public String investInit(Long userId, Model model) {
        model.addAttribute("userId", userId);
        return INVEST_URL;
    }

    @RequestMapping("/invest/list.json")
    @ResponseBody
    public AjaxDataTableObj<Invest> investInit(Long userId, DataTableObj dTable) {
        return parseInvest(matchResService.queryInvest(userId), dTable);
    }
    
    private AjaxDataTableObj<Invest> parseInvest(Set<InvestResult> invests, DataTableObj dTable) {
        List<Invest> results = new ArrayList<Invest>();
        for (InvestResult invest : invests) {
            results.add(new Invest(invest));
        }
        Pagination page = new Pagination(results.size(), 1);
        page.setTotalRows(results.size());
        return new AjaxDataTableObj<Invest>(dTable, new PaginationResult<List<Invest>>(results, page));
    }
}
