package com.dx.wms.service.changer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.observer.ObserverUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.google.gson.Gson;

@Service
public class ChangerRouter<P, R, T> implements ChangerObserver<Changer<P, R, T>, P, R, T> {

    private static final Logger LOG = LoggerFactory.getLogger(ChangerRouter.class);

    private List<Changer<P, R, T>> changers = new ArrayList<Changer<P, R, T>>();

    @Override
    public PaginationResult<List<R>> query(P param, Pagination page) {
        for (Changer<P, R, T> service : changers) {
            if (service.supports(param)) {
                LOG.info("**query() service:{}**", service.getClass());
                return service.query(param, page);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public String init(P param) {
        LOG.info("param:{}", new Gson().toJson(param));
        for (Changer<P, R, T> service : changers) {
            if (service.supports(param)) {
                return service.init(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public void regist(Changer<P, R, T> service) {
        changers.add(service);
    }

    @Override
    public String changePage(P param) {
        for (Changer<P, R, T> service : changers) {
            if (service.supports(param)) {
                LOG.info("**changePage() service:{}**", service.getClass());
                return service.changePage(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public String recordView(P param) {
        for (Changer<P, R, T> service : changers) {
            if (service.supports(param)) {
                LOG.info("**recordView() service:{}**", service.getClass());
                return service.view(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public PaginationResult<List<R>> queryRecord(P param, Pagination page) {
        for (Changer<P, R, T> service : changers) {
            if (service.supports(param)) {
                LOG.info("**queryRecord() service:{}**", service.getClass());
                return service.queryRecord(param, page);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public T getDto(P param) {
        for (Changer<P, R, T> service : changers) {
            if (service.supports(param)) {
                LOG.info("**getDto() service:{}**", service.getClass());
                return service.getDto(param);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public Map<String, Object> save(P param) {
        for (Changer<P, R, T> service : changers) {
            if (service.supports(param)) {
                LOG.info("**save() service:{}**", service.getClass());
                return service.save(param);
            }
        }
        throw ObserverUtils.error();
    }

}
