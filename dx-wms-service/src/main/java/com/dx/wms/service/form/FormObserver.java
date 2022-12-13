package com.dx.wms.service.form;

import java.util.List;
import java.util.Map;

import com.dx.wms.service.observer.QueryObserver;

public interface FormObserver<S, P, R> extends QueryObserver<S, P, R> {

    /**
     * 根据角色导出excel
     * 
     */
    void queryExcel(P param);

    /**
     * 根据角色设置查询map所必须的值，如：客户经理设置传值createUser，用于excel导出传值
     * 
     */
    Map<String, Object> getRequestMap(P param);

    /**
     * 根据角色设置初始list页面所需要的modelAttribute的值
     * 
     */
    Map<String, String> getAttributeMap(P param);

    /**
     * 根据角色查询所有投资数与投资金额的值
     * 
     */
    R queryallLenderAmount(P param);

    /**
     * 根据角色返回需要查询的值，如：客户经理设置传值createUser
     * 
     */
    FormParamVo getManagementQueryVo(P param);

    /**
     * 根据角色导出excel,不同的角色会有不同的内容
     */
    List<R> getExcel(P param);

}
