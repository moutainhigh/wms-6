package com.dx.wms.service.detail;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cms.service.IFileService;

public abstract class DetailRegister implements Detail {

    @Autowired
    private DetailObserver detail;

    @Autowired
    public IFileService fileService;

    @Override
    @PostConstruct
    public void join() {
        detail.regist(this);
    }

    @Override
    public String init(ParamDetail param) {
        return "/detail/detail";
    }

    @Override
    public void wrapper(ParamDetail param, ResultDetail result) {
        result.setTabs(param.getDetail().getDetails());
        result.setTitle(param.getDetail().getTitle());
    }
}
