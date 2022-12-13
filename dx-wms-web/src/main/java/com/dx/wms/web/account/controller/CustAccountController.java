/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: OpenAccountController.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午2:13:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.account.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cms.dto.Condition;
import com.dx.cms.web.vo.ConditionsVo;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.account.ICustAccountService;
import com.dx.wms.service.account.dto.ParamAccount;
import com.dx.wms.service.account.dto.ResultAccount;
import com.dx.wms.web.account.vo.AccountParamVo;
import com.dx.wms.web.account.vo.AccountResultVo;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.WebCommonUtil;
import com.google.gson.Gson;

/**
 * 客户开户管理
 *
 * @author 王蕊
 */
@Controller
@RequestMapping("/custAccountApply")
public class CustAccountController {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustAccountController.class);

    /**
     * 客户账户服务
     */
    @Autowired
    private ICustAccountService accountService;
 

    //开户管理list 初始化页面
    @RequestMapping(value = "/list.htm")
    public String init(ModelMap model, HttpServletRequest request) {
        return "custAccount/list";
    }

    //开户管理list数据查询
    @RequestMapping("list.json")
    @ResponseBody
    public AjaxDataTableObj<AccountResultVo> query(AccountParamVo param, HttpServletRequest request,
            DataTableObj dTable) {
        Pagination page = WebCommonUtil.initPage(dTable);
        return new AjaxDataTableObj<AccountResultVo>(dTable,
                result(accountService.queryForPage(param(param, request), page)));

    }

    //页面取得的查询条件vo转dto
    private ParamAccount param(AccountParamVo vo, HttpServletRequest request) {
        ParamAccount param = new ParamAccount(WebCommonUtil.getUserId(request));
        BeanUtils.copyProperties(vo, param);
        return param;
    }

    //数据库查询的dto转vo
    private PaginationResult<List<AccountResultVo>> result(PaginationResult<List<ResultAccount>> result) {
        List<AccountResultVo> results = new ArrayList<AccountResultVo>();
        for (ResultAccount dto : result.getR()) {
            AccountResultVo vo = new AccountResultVo(dto);
            results.add(vo);
        }
        return new PaginationResult<List<AccountResultVo>>(results, result.getPagination());
    }

    /**
     * 确认开户
     *
     * @param request
     * @return true -- 开户成功 false -- 开户失败
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "createUserAccount.json")
    @ResponseBody
    public boolean createUserAccount(@RequestBody ConditionsVo conditions, HttpServletRequest request) {
        LOG.info("**createUserAccount() conditions={}", new Gson().toJson(conditions));
        if (null == conditions) {
            return false;
        }
        if (StringUtils.isBlank(conditions.getCmAction()) || !Assert.checkParam(conditions.getCustAccountId())) {
            LOG.info("**createUserAccount() conditions.getCmAction() or conditions.getCustAccountId() is empty**false");
            return false;
        }
        Condition conditionsDto = new Condition();
        BeanUtils.copyProperties(conditions, conditionsDto);
        return accountService.createUserAccount(WebCommonUtil.getUserId(request), conditionsDto);
    }
}
