package com.dx.cmm.web.controller.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.match.IMatchService;
import com.dx.cmm.service.match.MatchException;
import com.dx.cmm.service.match.param.RepeatCreditParam;
import com.dx.cmm.service.match.param.RepeatInvestParam;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.cmm.service.match.result.RepeatInvestResult;
import com.dx.cmm.service.ports.Port;
import com.dx.cmm.service.result.InvestResults;
import com.dx.cmm.web.controller.match.result.Credit;
import com.dx.cmm.web.controller.match.result.InvestMatchResult;
import com.dx.cmm.web.controller.match.result.OneMatchResult;
import com.dx.cmm.web.controller.match.result.RepeatInvest;
import com.dx.cmm.web.controller.match.result.Total;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.google.gson.Gson;

@Controller("repeatMatchController")
@RequestMapping("/match/repeat")
public class RepeatController extends MatchController {

    private static final String LIST = "/match/repeat/list";

    private static final String DETAIL = "/match/repeat/detail";

    private static final String BIZ = "/match/repeat";

    @Autowired
    private IMatchService<RepeatInvestParam, RepeatCreditParam, RepeatInvestResult> repeatMatch;

    @RequestMapping(INIT_HTM)
    public String init(Model model) {
        Map<String, String> product = productService.getProductByAppAndProductId(INVEST, -1L);
        model.addAttribute(PRODUCT, product);
        return LIST;
    }

    @RequestMapping(INIT_URL)
    @ResponseBody
    public AjaxDataTableObj<RepeatInvest> init(RepeatInvestParam param, DataTableObj dTable) {
        return parseInvest(repeatMatch.queryInvest(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<RepeatInvest> parseInvest(PaginationResult<List<RepeatInvestResult>> page,
            DataTableObj dTable) {
        List<RepeatInvest> invests = new ArrayList<RepeatInvest>();
        Map<Long, String> product = productService.query(INVEST);
        for (RepeatInvestResult invest : page.getR()) {
            invests.add(new RepeatInvest(invest, product));
        }
        return new AjaxDataTableObj<RepeatInvest>(dTable,
                new PaginationResult<List<RepeatInvest>>(invests, page.getPagination()));
    }

    @RequestMapping("/detail.json")
    public String init(Long poolId, Model model) {
        RepeatInvestResult invest = repeatMatch.queryInvest(poolId);
        Map<Long, String> product = productService.query(CREDIT);
        List<InvestMatchResult> details = new ArrayList<InvestMatchResult>();
        for (InvestResults results : invest.getResults()) {
            details.add(new InvestMatchResult(results, product));
        }
        model.addAttribute("details", details);
        return DETAIL;
    }

    @RequestMapping(ONE)
    public String init(@RequestBody InvestResult invest, Model model, HttpServletRequest request) {
        find(invest, model, BIZ);
        if (verify(getUserId(request), repeatMatch.current(invest.getPoolId(), InvestResult.class), model)) {
            repeatMatch.init(getUserId(request), new HashSet<InvestResult>((Arrays.asList(invest))));
        }
        model.addAttribute("total", new Total(repeatMatch.queryCache(getUserId(request))));
        return ONE_FIND;
    }

    @RequestMapping(CREDIT_URL)
    @ResponseBody
    public AjaxDataTableObj<Credit> init(RepeatCreditParam param, DataTableObj dTable) {
        return parseCredit(repeatMatch.queryCredit(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<Credit> parseCredit(PaginationResult<List<CreditResult>> page, DataTableObj dTable) {
        List<Credit> credits = new ArrayList<Credit>();
        Map<Long, String> product = productService.query(CREDIT);
        for (CreditResult credit : page.getR()) {
            credits.add(new Credit(credit, product, Port.PORT));
        }
        return new AjaxDataTableObj<Credit>(dTable, new PaginationResult<List<Credit>>(credits, page.getPagination()));
    }

    @RequestMapping(MATCH)
    @ResponseBody
    public Map<String, Object> match(@RequestBody Set<Match> matches, HttpServletRequest request) {
        Map<String, Object> result = result();
        result.put("msg", "匹配成功");
        try {
            repeatMatch.match(getUserId(request), matches);
        } catch (MatchException e) {
            LOG.error("Match matches[{}] error", new Gson().toJson(matches));
            error(result, e);
        }
        return result;
    }

    @RequestMapping(SAVE)
    @ResponseBody
    public Map<String, Object> save(@RequestBody Set<Match> matches, HttpServletRequest request) {
        Map<String, Object> result = result();
        result.put("msg", "保存成功");
        try {
            repeatMatch.save(getUserId(request), matches);
        } catch (MatchException e) {
            LOG.error("Save credits{} error", new Gson().toJson(matches));
            error(result, e);
        }
        return result;
    }

    @RequestMapping(CLOSE)
    @ResponseBody
    public Boolean remove(HttpServletRequest request) {
        repeatMatch.remove(getUserId(request), null, null, null);
        return true;
    }

    @RequestMapping(JOIN)
    @ResponseBody
    public Map<String, Object> join(@RequestBody Set<CreditResult> credits, HttpServletRequest request) {
        Map<String, Object> result = result();
        try {
            repeatMatch.join(getUserId(request), credits);
            result.put("total", new Total(repeatMatch.queryCache(getUserId(request))));
            result.put("msg", "推荐成功");
        } catch (MatchException e) {
            error(result, e);
        }
        return result;
    }

    @RequestMapping(BACK)
    public String back(Model model) {
        return last(model);
    }

    @RequestMapping(ONE_NEXT)
    public String init(Model model, HttpServletRequest request) {
        model.addAttribute("total", new Total(repeatMatch.queryCache(getUserId(request))));
        return ALL_MATCH;
    }

    @RequestMapping(ONE_MATCH)
    @ResponseBody
    public AjaxDataTableObj<OneMatchResult> init(HttpServletRequest request, DataTableObj dTable) {
        return init(repeatMatch.queryCache(getUserId(request)), dTable);
    }

    @RequestMapping(REMOVE)
    @ResponseBody
    public Map<String, Object> remove(@RequestBody Set<CreditResult> credits, HttpServletRequest request) {
        Map<String, Object> result = result();
        try {
            repeatMatch.remove(getUserId(request), null, null, credits);
            result.put("total", new Total(repeatMatch.queryCache(getUserId(request))));
        } catch (MatchException e) {
            LOG.error("Remove credits{} error", new Gson().toJson(credits));
            error(result, e);
        }
        return result;
    }

}
