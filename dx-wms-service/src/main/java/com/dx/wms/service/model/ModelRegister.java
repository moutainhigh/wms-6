package com.dx.wms.service.model;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.dx.common.service.utils.Assert;
import com.dx.framework.constant.service.IRegionNewService;

public abstract class ModelRegister implements Model {

    @Autowired
    private ModelObserver model;

    /**
     * 区域服务
     */
    @Autowired
    protected IRegionNewService regionService;
    
    @Override
    @PostConstruct
    public void join() {
        model.regist(this);
    }

    public ModelMap init(ParamModel param, ModelMap map) {
        if (Assert.checkParam(param.getParam())) {
            for (Map.Entry<String, Object> entry : param.getParam().entrySet()) {
                map.addAttribute(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }
}
