package com.dx.wms.service.model;

import org.springframework.ui.ModelMap;

import com.dx.wms.service.observer.DataObserver;

/**
 * 
 * 模型观察者
 *
 * @author tony
 */
public interface ModelObserver extends DataObserver<Model> {

    /**
     * 
     * 初始化
     *
     * @param param
     * @param map
     * @return
     */
    ModelMap init(ParamModel param, ModelMap map);
}
