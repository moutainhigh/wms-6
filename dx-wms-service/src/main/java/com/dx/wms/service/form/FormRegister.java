/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ReportServiceImpl.java
 * Author:   张祥韵
 * Date:     2015年11月19日 上午11:56:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.form;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.ICommonService;

/**
 * 报表总接口实现类，用于观察者实现角色跳转
 * 
 * @author zhangxiangyun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class FormRegister implements Form<Map<String, Object>, FormDto> {

    @Autowired
    private FormObserver<Form<Map<String, Object>, FormDto>, Map<String, Object>, FormDto> executor;

    /**
     * dalClient
     */
    @Autowired
    public PaginationDalClient dalClient;

    /**
     * 通用服务接口
     */
    @Autowired
    public ICommonService commonService;

    @Override
    public PaginationResult<List<FormDto>> query(Map<String, Object> param, Pagination page) {
        return new PaginationResult<List<FormDto>>();
    }

    @Override
    public String init(Map<String, Object> param) {

        return null;
    }

    @Override
    @PostConstruct
    public void join() {
        executor.regist(this);
    }

    @Override
    public List<FormDto> getExcelVos(Map<String, Object> param) {
        return null;

    }

    @Override
    public void queryExcel(Map<String, Object> param) {

    }

    @Override
    public Map<String, Object> getRequestMap(Map<String, Object> param) {
        return null;
    }

    @Override
    public FormParamVo getManagementQueryVo(Map<String, Object> param) {
        return null;

    }

    @Override
    public Map<String, String> getAttributeMap(Map<String, Object> param) {
        return null;

    }

    @Override
    public FormDto queryallLenderAmount(Map<String, Object> param) {
        return null;

    }
}
