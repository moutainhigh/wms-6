/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ReportExecutorServiceImpl.java
 * Author:   张祥韵
 * Date:     2015年11月19日 上午11:56:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.form;

/**
 * 报表观察者实现类
 * 
 * @author zhangxiangyun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

@Service
public class FormRouter<P, R> implements FormObserver<Form<P, R>, P, R> {

    private List<Form<P, R>> services = new ArrayList<>();

    @Override
    public String init(P param) {
        for (Form<P, R> service : services) {
            if (service.supports(param)) {
                return service.init(param);
            }
        }
        return null;
    }

    @Override
    public void regist(Form<P, R> service) {
        services.add(service);

    }

    @Override
    public PaginationResult<List<R>> query(P param, Pagination page) {
        for (Form<P, R> service : services) {
            if (service.supports(param)) {
                return service.query(param, page);
            }
        }
        return null;
    }

    @Override
    public List<R> getExcel(P param) {
        for (Form<P, R> service : services) {
            if (service.supports(param)) {
                return service.getExcelVos(param);
            }
        }
        return null;
    }

    @Override
    public void queryExcel(P param) {
        for (Form<P, R> service : services) {
            if (service.supports(param)) {
                service.queryExcel(param);
            }
        }

    }

    @Override
    public Map<String, Object> getRequestMap(P param) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Form<P, R> service : services) {
            if (service.supports(param)) {
                map = service.getRequestMap(param);
            }
        }
        return map;
    }

    @Override
    public FormParamVo getManagementQueryVo(P param) {
        FormParamVo reportManagementQueryVo = new FormParamVo();
        for (Form<P, R> service : services) {
            if (service.supports(param)) {
                reportManagementQueryVo = service.getManagementQueryVo(param);
            }
        }
        return reportManagementQueryVo;
    }

    @Override
    public Map<String, String> getAttributeMap(P param) {
        Map<String, String> map = new HashMap<String, String>();
        for (Form<P, R> service : services) {
            if (service.supports(param)) {
                map = service.getAttributeMap(param);
            }
        }
        return map;
    }

    @Override
    public R queryallLenderAmount(P param) {
        for (Form<P, R> service : services) {
            if (service.supports(param)) {
                return service.queryallLenderAmount(param);
            }
        }
        return null;
    }

}
