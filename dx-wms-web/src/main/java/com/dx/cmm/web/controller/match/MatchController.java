package com.dx.cmm.web.controller.match;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.dx.ccs.vo.UserVo;
import com.dx.cmm.service.match.MatchCache;
import com.dx.cmm.service.match.MatchException;
import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.ports.Port;
import com.dx.cmm.web.controller.BaseController;
import com.dx.cmm.web.controller.match.result.Credit;
import com.dx.cmm.web.controller.match.result.OneMatchResult;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

/**
 * 
 * 投资匹配管理
 *
 * @author tony
 */
class MatchController extends BaseController {

    static final String INVEST = "wms";

    static final String CREDIT = "ccs";

    static final String PRODUCT = "product";

    static final String MSG = "msg";

    static final String FLAG = "flag";

    static final String ZERO = "0.00";

    private static final String CREDIT_LIST = "/match/find/list";

    static final String ONE_FIND = "/match/find/all/find";

    static final String MORE_FIND = "/match/find/part/find";

    static final String ALL_MATCH = "/match/find/all/match";

    static final String PART_MATCH = "/match/find/part/match";

    static final String ALL_HEAD = "/match/find/all/head.ftl";

    static final String PART_HEAD = "/match/find/part/head.ftl";

    static final String ONE = "/one.json";

    static final String ONE_MATCH = "/one/match.json";

    static final String MORE = "/more.json";

    static final String MORE_MATCH = "/more/match.json";

    static final String CLOSE = "/close.json";

    static final String JOIN = "/join.json";

    static final String BACK = "/back.json";

    static final String CREDIT_URL = "/credit.json";

    static final String SAVE = "/save.json";

    static final String REMOVE = "/remove.json";

    static final String ONE_NEXT = "/one/next.json";
    
    static final String MORE_NEXT = "/more/next.json";

    static final String MATCH = "/match.json";

    static final Map<String, String> CATEGORY = new HashMap<String, String>() {
        /**
         */
        private static final long serialVersionUID = -228724867842014405L;

        {
            put("1", "外部客户");
            put("2", "内部员工");
        }
    };

    String init(Model model, String url) {
        Map<String, String> product = productService.getProductByAppAndProductId(INVEST, -1L);
        model.addAttribute(PRODUCT, product);
        model.addAttribute("category", CATEGORY);
        return url;
    }

    Boolean verify(Long userId, Long current, Model model) {
        if (Assert.checkParam(current) && !Assert.equals(userId, current)) {
            UserVo user = amService.queryUserById(current);
            model.addAttribute(MSG, MessageFormat.format("系统操作人-{0}正在匹配此客户,请稍后。", user.getName()));
            model.addAttribute(FLAG, false);
            return false;
        }
        return true;
    }

    void error(Map<String, Object> result, MatchException e) {
        result.put("result", false);
        result.put("msg", e.getMessage());
    }

    AjaxDataTableObj<OneMatchResult> init(MatchCache cache, DataTableObj dTable) {
        List<OneMatchResult> results = new ArrayList<OneMatchResult>();
        Map<Long, String> product = productService.query(CREDIT);
        for (CreditResult result : cache.getCredits()) {
            results.add(new OneMatchResult(new Credit(result, product, Port.PORT), cache));
        }
        Pagination page = new Pagination(results.size(), 1);
        page.setTotalRows(results.size());
        return new AjaxDataTableObj<OneMatchResult>(dTable, new PaginationResult<List<OneMatchResult>>(results, page));
    }

    void find(InvestResult invest, Model model, String biz) {
        model.addAttribute(FLAG, true);
        model.addAttribute("invest", invest);
        model.addAttribute("custInfo", MessageFormat.format("{0}-{1}", invest.getLenderCode(),
                productService.queryByProductId(INVEST, invest.getProductId()).getProductName()));
        model.addAttribute("sort", SORT);
        model.addAttribute("biz", biz);
        model.addAttribute("findHead", ALL_HEAD);
    }

    void find(Model model, String biz) {
        model.addAttribute(FLAG, true);
        model.addAttribute("sort", SORT);
        model.addAttribute("biz", biz);
        model.addAttribute("findHead", PART_HEAD);
    }

    String last(Model model) {
        model.addAttribute("sort", SORT);
        return CREDIT_LIST;
    }
}
