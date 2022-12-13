package com.dx.wms.service.apply;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.observer.ObserverUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

@Service
public class ApplicantRouter<P, R> implements ApplicantObserver<Applicant<P, R>, P, R> {

    private List<Applicant<P, R>> applicants = new ArrayList<Applicant<P, R>>();

    @Override
    public void regist(Applicant<P, R> applicant) {
        applicants.add(applicant);
    }

    @Override
    public PaginationResult<List<R>> query(P param, Pagination page) {
        for (Applicant<P, R> applicant : applicants) {
            if (applicant.supports(param)) {
                return applicant.query(param, page);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public String init(P param) {
        for (Applicant<P, R> applicant : applicants) {
            if (applicant.supports(param)) {
                return applicant.init(param);
            }
        }
        throw ObserverUtils.error();
    }

}
