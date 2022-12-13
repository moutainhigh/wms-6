package com.dx.wms.service.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.cmm.service.observer.ObserverUtils;

@Service
public class ModelRouter implements ModelObserver {

    private List<Model> models = new ArrayList<Model>();

    @Override
    public void regist(Model model) {
        models.add(model);
    }

    @Override
    public ModelMap init(ParamModel param, ModelMap map) {
        for (Model model : models) {
            if (model.supports(param)) {
                return model.init(param, map);
            }
        }
        throw ObserverUtils.error();
    }

}
