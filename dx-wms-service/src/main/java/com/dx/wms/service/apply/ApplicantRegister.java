package com.dx.wms.service.apply;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.service.apply.dto.ParamApplicant;
import com.dx.wms.service.apply.dto.ResultApplicant;

public abstract class ApplicantRegister implements Applicant<ParamApplicant, ResultApplicant> {

    @Autowired
    private ApplicantObserver<Applicant<ParamApplicant, ResultApplicant>, ParamApplicant, ResultApplicant> observer;

    @Autowired
    public PaginationDalClient dalClient;

    @Override
    @PostConstruct
    public void join() {
        observer.regist(this);
    }
}
