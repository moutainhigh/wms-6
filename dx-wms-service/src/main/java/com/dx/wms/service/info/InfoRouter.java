package com.dx.wms.service.info;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.cmm.service.observer.ObserverUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

@Service
public class InfoRouter<P, R> implements InfoObserver<Info<P, R>, P, R> {

    private List<Info<P, R>> infos = new ArrayList<Info<P, R>>();

    @Override
    public String init(P param) {
        for (Info<P, R> info : infos) {
            if (info.supports(param)) {
                return info.init(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public void regist(Info<P, R> info) {
        infos.add(info);
    }

    @Override
    public PaginationResult<List<R>> query(P param, Pagination page) {
        for (Info<P, R> info : infos) {
            if (info.supports(param)) {
                return info.query(param, page);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public void put(P param, ModelMap view) {
        for (Info<P, R> info : infos) {
            if (info.supports(param)) {
                info.put(param, view);
            }
        }
    }

}
