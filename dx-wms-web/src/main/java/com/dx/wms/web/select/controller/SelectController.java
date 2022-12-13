package com.dx.wms.web.select.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.selector.ParamSelector;
import com.dx.wms.selector.ResultSelector;
import com.dx.wms.selector.Selector;
import com.dx.wms.selector.SelectorObserver;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.select.controller.vo.ParamSelectorVo;
import com.dx.wms.web.select.controller.vo.ResultSelectorVo;
import com.dx.wms.web.util.WebCommonUtil;

@Controller
@RequestMapping("/select")
public class SelectController {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(SelectController.class);

    @Autowired
    private SelectorObserver<Selector<ParamSelector, ResultSelector>, ParamSelector, ResultSelector> selector;

    //view选择潜在客户   account选择已开户的用户
    @RequestMapping(value = "{biz}.json")
    public String init(@PathVariable("biz") String biz, ModelMap model, HttpServletRequest request) {
        LOG.info("Into {}", biz);
        model.addAttribute("biz", biz);
        return selector.init(param(biz));
    }

    private ParamSelector param(String biz) {
        return new ParamSelector(biz);
    }

    @RequestMapping(value = "{biz}_select.json")
    @ResponseBody
    public AjaxDataTableObj<ResultSelectorVo> query(@PathVariable("biz") String biz, ParamSelectorVo param,
            HttpServletRequest request, DataTableObj dTable) {
        Pagination page = WebCommonUtil.initPage(dTable);
        return new AjaxDataTableObj<ResultSelectorVo>(dTable, result(selector.query(param(biz, param, request), page)));
    }

    private ParamSelector param(String biz, ParamSelectorVo param, HttpServletRequest request) {
        ParamSelector selector = new ParamSelector(biz, WebCommonUtil.getUserId(request));
        BeanUtils.copyProperties(param, selector);
        return selector;
    }

    private PaginationResult<List<ResultSelectorVo>> result(PaginationResult<List<ResultSelector>> result) {
        List<ResultSelectorVo> results = new ArrayList<>();
        for (ResultSelector selector : result.getR()) {
            results.add(new ResultSelectorVo(selector));
        }
        return new PaginationResult<List<ResultSelectorVo>>(results, result.getPagination());
    }

}
