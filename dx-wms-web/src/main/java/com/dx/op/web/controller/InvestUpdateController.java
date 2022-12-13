/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: InvestUpdateController.java
 * Author:   朱道灵
 * Date:     2016年5月8日 下午12:28:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.invest.IInvestService;
import com.dx.cmm.service.invest.InvestUpdateParam;
import com.dx.cmm.service.invest.InvestUpdateResult;
import com.dx.cmm.service.match.MatchException;
import com.dx.cmm.web.controller.BaseController;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.op.web.vo.InvestUpdateResultVo;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

/**
 * 投资变更Controller
 *
 * @author 朱道灵
 */
@Controller
@RequestMapping("/op/invest/update")
public class InvestUpdateController extends BaseController{
    
    @Autowired
    private IInvestService investService;

    private static final String FTL = "op/invest/update/list";
    
    @RequestMapping("/list.htm")
    public String init(Model model) {
        return FTL;
    }
    
    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<InvestUpdateResultVo> init(InvestUpdateParam param, DataTableObj dTable) {     
        return parse(investService.queryProduct(param, init(dTable)),dTable);     
    }
    private  AjaxDataTableObj<InvestUpdateResultVo> parse(PaginationResult<List<InvestUpdateResult>> page, DataTableObj dTable){ 
        List<InvestUpdateResultVo> results = new ArrayList<InvestUpdateResultVo>();
        Map<Long, String> product = productService.query(INVEST);
        for (InvestUpdateResult result : page.getR()){
            results.add(new InvestUpdateResultVo(result,product));
        }
       return new AjaxDataTableObj<InvestUpdateResultVo>(dTable,
               new PaginationResult<List<InvestUpdateResultVo>>(results, page.getPagination()));
                            
    }
    
    @RequestMapping("/update.json")
    @ResponseBody
    public Map<String, Object> update(Long poolId, HttpServletRequest request) {
        Map<String, Object> result = result();
        try {
            investService.updateProduct(poolId);
        } catch (MatchException e) {
            LOG.error("Update productName[{}] error", poolId);
            error(result, e);
        }
        return result;
    }

    private void error(Map<String, Object> result, MatchException e) {
        result.put("result", false);
        result.put("msg", e.getMessage());
    }
    
}
