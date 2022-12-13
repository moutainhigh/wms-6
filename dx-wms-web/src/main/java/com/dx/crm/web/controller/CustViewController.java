package com.dx.crm.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.crm.web.vo.ParamViewVo;
import com.dx.crm.web.vo.ResultViewVo;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.base.CustBase;
import com.dx.wms.service.base.ICustViewService;
import com.dx.wms.service.base.ParamView;
import com.dx.wms.service.base.ResultView;
import com.dx.wms.service.exception.SaveException;
import com.dx.wms.service.model.ModelObserver;
import com.dx.wms.service.model.ModelType;
import com.dx.wms.service.model.ParamModel;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.WebCommonUtil;

/**
 * 客户关系管理
 *
 * @author 王蕊
 */
@Controller
@RequestMapping("/custView")
public class CustViewController {

    private static final Logger LOG = LoggerFactory.getLogger(CustViewController.class);

    @Autowired
    private ICustViewService custViewService;

    @Autowired
    private ModelObserver gateway;


    //客户360视图管理 list
    @RequestMapping(value = "/list.htm")
    public String init() {
        return "custView/list";
    }

    //list数据查询
    @RequestMapping("list.json")
    @ResponseBody
    public AjaxDataTableObj<ResultViewVo> query(ParamViewVo param, HttpServletRequest request, DataTableObj dTable) {
        Pagination page = WebCommonUtil.initPage(dTable);
        return new AjaxDataTableObj<ResultViewVo>(dTable,
                result(custViewService.queryForPage(param(param, request), page)));
    }

    //页面取得的查询条件VO转换成DTO
    private ParamView param(ParamViewVo vo, HttpServletRequest request) {
        ParamView param = new ParamView(WebCommonUtil.getUserId(request));
        BeanUtils.copyProperties(vo, param);
        return param;
    }

    //数据库查询到的数据DTO转VO
    private PaginationResult<List<ResultViewVo>> result(PaginationResult<List<ResultView>> result) {
        List<ResultViewVo> results = new ArrayList<>();
        for (ResultView view : result.getR()) {
            results.add(new ResultViewVo(view));
        }
        return new PaginationResult<List<ResultViewVo>>(results, result.getPagination());
    }

    //360视图开户界面
    @RequestMapping(value = "edit.json")
    public String create(Long custId, ModelMap model, HttpServletRequest request) {
        LOG.info("Cust id[{}]", custId);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("base", custViewService.queryById(custId));
        gateway.init(new ParamModel(ModelType.VIEW, param), model);
        return "custView/edit";
    }

    //360潜客信息保存
    @RequestMapping(value = "save.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody CustBase base, HttpServletRequest request) {
        Map<String, Object> result = WebCommonUtil.init();
        try {
            custViewService.save(base, WebCommonUtil.getUserId(request));
        } catch (SaveException e) {
            LOG.error("Save error[{}]", e.getMessage());
            result.put("result", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }

}
