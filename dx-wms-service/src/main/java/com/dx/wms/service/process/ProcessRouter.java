package com.dx.wms.service.process;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.dx.cmm.service.observer.ObserverUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

@Service
public class ProcessRouter<P, R> implements ProcessObserver<Process<P, R>, P, R> {

    private List<Process<P, R>> services = new ArrayList<Process<P, R>>();

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ProcessRouter.class);

    @Override
    public String init(P param) {
        for (Process<P, R> service : services) {
            if (service.supports(param)) {
                LOG.info("**init() service:{}**", service.getClass());
                return service.init(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public void regist(Process<P, R> service) {
        services.add(service);

    }

    @Override
    public PaginationResult<List<R>> query(P param, Pagination page) {
        for (Process<P, R> service : services) {
            if (service.supports(param)) {
                return service.query(param, page);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public void put(P param, ModelMap view) {
        for (Process<P, R> service : services) {
            if (service.supports(param)) {
                service.put(param, view);
            }
        }
    }

    @Override
    public String applyInit(P param) {
        for (Process<P, R> service : services) {
            if (service.supports(param)) {
                return service.applyInit(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public PaginationResult<List<R>> selectQuery(P param, Pagination page) {
        for (Process<P, R> service : services) {
            if (service.supports(param)) {
                return service.selectQuery(param, page);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public String createInit(P param) {
        for (Process<P, R> service : services) {
            if (service.supports(param)) {
                return service.createInit(param);
            }
        }
        throw ObserverUtils.error();
    }

}
