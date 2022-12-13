package com.dx.cmm.web.controller.match;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.match.IMatchService;
import com.dx.cmm.service.match.MatchException;
import com.dx.cmm.service.match.param.BackCreditParam;
import com.dx.cmm.service.match.param.BackInvestParam;
import com.dx.cmm.service.match.result.BackInvestResult;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.cmm.service.ports.Port;
import com.dx.cmm.web.controller.match.result.BackInvest;
import com.dx.cmm.web.controller.match.result.Credit;
import com.dx.cmm.web.controller.match.result.MoreMatchResult;
import com.dx.cmm.web.controller.match.result.OneMatchResult;
import com.dx.cmm.web.controller.match.result.Total;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.exception.BaseException;
import com.dx.framework.redis.client.IRedisClient;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.google.gson.Gson;

@Controller("backMatchController")
@RequestMapping("/match/back")
public class BackController<T> extends MatchController {

    private static final String LIST = "/match/back/list";

    private static final String BIZ = "/match/back";
    
    private static final int ONE_MONTH_SEC = 2678400;


    @Autowired
    private IMatchService<BackInvestParam, BackCreditParam, BackInvestResult> backMatch;

    /**
     * 缓存服务
     */
    @Autowired
    private IRedisClient wmsRedisClient;
    
    @RequestMapping(INIT_HTM)
    public String init(Model model) {
        model.addAttribute(PRODUCT, productService.getProductByAppAndProductId(INVEST, -1L));
        return LIST;
    }

    @RequestMapping(INIT_URL)
    @ResponseBody
    public AjaxDataTableObj<BackInvest> init(BackInvestParam param, DataTableObj dTable) {
        return parseInvest(backMatch.queryInvest(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<BackInvest> parseInvest(PaginationResult<List<BackInvestResult>> page,
            DataTableObj dTable) {
        List<BackInvest> invests = new ArrayList<BackInvest>();
        Map<Long, String> product = productService.query(INVEST);
        for (BackInvestResult invest : page.getR()) {
            invests.add(new BackInvest(invest, product));
        }
        return new AjaxDataTableObj<BackInvest>(dTable,
                new PaginationResult<List<BackInvest>>(invests, page.getPagination()));
    }

    @RequestMapping(MORE)
    public String init(@RequestBody List<InvestResult> invests, Model model, HttpServletRequest request) {
        find(model, BIZ);
        if (verify(getUserId(request), backMatch.current(invests), model)) {
            backMatch.init(getUserId(request), new HashSet<InvestResult>(invests));
        }
        model.addAttribute("total", new Total(backMatch.queryCache(getUserId(request))));
        return MORE_FIND;
    }

    @RequestMapping(ONE)
    public String init(@RequestBody InvestResult invest, Model model, HttpServletRequest request) {
        find(invest, model, BIZ);
        if (verify(getUserId(request), backMatch.current(invest.getPoolId(), InvestResult.class), model)) {
            backMatch.init(getUserId(request), new HashSet<InvestResult>((Arrays.asList(invest))));
        }
        model.addAttribute("total", new Total(backMatch.queryCache(getUserId(request))));
        return ONE_FIND;
    }

    @RequestMapping(CREDIT_URL)
    @ResponseBody
    public AjaxDataTableObj<Credit> init(BackCreditParam param, DataTableObj dTable) {
        return parseCredit(backMatch.queryCredit(param, init(dTable)), dTable);
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
            backMatch.match(getUserId(request), matches);
        } catch (MatchException e) {
            LOG.error("Match matches[{}] error", new Gson().toJson(matches));
            error(result, e);
        }
        
        String key = null;//e.g. key格式 = past_createTime:2017-1:1
        String app = "past_createTime";
        Calendar cal = Calendar.getInstance();//获取当前时间
        SimpleDateFormat miute = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat forkey = new SimpleDateFormat("yyyy-MM");
        
        String day = null;
        if(0<cal.get(GregorianCalendar.DAY_OF_MONTH)&&cal.get(GregorianCalendar.DAY_OF_MONTH)<16){
        	day="16";
        }else if(15<cal.get(GregorianCalendar.DAY_OF_MONTH)&&cal.get(GregorianCalendar.DAY_OF_MONTH)<=31){
        	day="1";
        }
        
        if(null!=day){
        	key = app+":"+forkey.format(cal.getTime())+":"+day;
        }else{
        	LOG.error("create Match key is failed");
        	throw new BaseException("create Match key is failed");
        }
        String valStr = getCache(key);
        if (StringUtils.isBlank(valStr) || StringUtils.equals(valStr, "null")) {
        	String value = miute.format(cal.getTime().getTime()-1200000);//减少20分钟
        	putCache(key,value);
        }
        
        return result;
    }
    
    private void putCache(String key, String value) {
        try {
            wmsRedisClient.setex(key, ONE_MONTH_SEC, value);
        } catch (Exception e) {
            LOG.error("error:{}", e.getMessage());
        }
    }
    
    private String getCache(String key) {
        try {
            return wmsRedisClient.get(key);
        } catch (Exception e) {
            LOG.error("error:{}", e.getMessage());
            return "";
        }
    }

    @RequestMapping(SAVE)
    @ResponseBody
    public Map<String, Object> save(@RequestBody Set<Match> matches, HttpServletRequest request) {
        Map<String, Object> result = result();
        result.put("msg", "保存成功");
        try {
            backMatch.save(getUserId(request), matches);
        } catch (MatchException e) {
            LOG.error("Save credits{} error", new Gson().toJson(matches));
            error(result, e);
        }
        return result;
    }

    @RequestMapping(CLOSE)
    @ResponseBody
    public Boolean remove(HttpServletRequest request) {
        backMatch.remove(getUserId(request), null, null, null);
        return true;
    }

    @RequestMapping(JOIN)
    @ResponseBody
    public Map<String, Object> join(@RequestBody Set<CreditResult> credits, HttpServletRequest request) {
        Map<String, Object> result = result();
        try {
            backMatch.join(getUserId(request), credits);
            result.put("total", new Total(backMatch.queryCache(getUserId(request))));
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
    public String oneNext(Model model, HttpServletRequest request) {
        model.addAttribute("total", new Total(backMatch.queryCache(getUserId(request))));
        return ALL_MATCH;
    }

    @RequestMapping(MORE_NEXT)
    public String moreNext(Model model, HttpServletRequest request) {
        model.addAttribute("total", new Total(backMatch.queryCache(getUserId(request))));
        return PART_MATCH;
    }

    @RequestMapping(ONE_MATCH)
    @ResponseBody
    public AjaxDataTableObj<OneMatchResult> oneMatch(HttpServletRequest request, DataTableObj dTable) {
        return init(backMatch.queryCache(getUserId(request)), dTable);
    }

    @RequestMapping(MORE_MATCH)
    @ResponseBody
    public AjaxDataTableObj<MoreMatchResult> moreMatch(HttpServletRequest request, DataTableObj dTable) {
        return init(backMatch.auto(getUserId(request)), dTable);
    }

    AjaxDataTableObj<MoreMatchResult> init(List<Match> matches, DataTableObj dTable) {
        List<MoreMatchResult> results = new ArrayList<MoreMatchResult>();
        for (Match match : matches) {
            results.add(new MoreMatchResult(match));
        }
        Pagination page = new Pagination(results.size(), 1);
        page.setTotalRows(results.size());
        return new AjaxDataTableObj<MoreMatchResult>(dTable,
                new PaginationResult<List<MoreMatchResult>>(results, page));
    }

    @RequestMapping(REMOVE)
    @ResponseBody
    public Map<String, Object> remove(@RequestBody Set<CreditResult> credits, HttpServletRequest request) {
        Map<String, Object> result = result();
        try {
            backMatch.remove(getUserId(request), null, null, credits);
            result.put("total", new Total(backMatch.queryCache(getUserId(request))));
        } catch (MatchException e) {
            LOG.error("Remove credits{} error", new Gson().toJson(credits));
            error(result, e);
        }
        return result;
    }

}
