package com.dx.wms.service.info;

import org.springframework.ui.ModelMap;

import com.dx.wms.service.common.QueryService;

/**
 * 
 * 信息
 *
 * @author 王蕊
 * 
 */
public interface Info<P, R> extends QueryService<P, R> {

    /**
     * 
     * 功能描述: <br>
     * 加载视图
     *
     * @param param
     * @param view
     */
    void put(P param, ModelMap view);

}
