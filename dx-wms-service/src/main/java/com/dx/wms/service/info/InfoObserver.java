package com.dx.wms.service.info;

import org.springframework.ui.ModelMap;

import com.dx.wms.service.observer.QueryObserver;

/**
 * 
 * 理财信息管理观察者容器
 *
 * @author 王蕊
 */
public interface InfoObserver<S, P, R> extends QueryObserver<S, P, R> {

    /**
     * 
     * 功能描述: 理财信息管理页面分页model<br>
     * 〈功能详细描述〉
     *
     * @param param
     * @return view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void put(P param, ModelMap view);

}
