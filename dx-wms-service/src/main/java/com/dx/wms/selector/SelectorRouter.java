package com.dx.wms.selector;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.service.observer.ObserverUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

@Service
public class SelectorRouter<P, R> implements SelectorObserver<Selector<P, R>, P, R> {

    private List<Selector<P, R>> selectors = new ArrayList<>();

    @Override
    public void regist(Selector<P, R> selector) {
        selectors.add(selector);
    }

    @Override
    public PaginationResult<List<R>> query(P param, Pagination page) {
        for (Selector<P, R> selector : selectors) {
            if (selector.supports(param)) {
                return selector.query(param, page);
            }
        }
        throw ObserverUtils.error();
    }

    @Override
    public String init(P param) {
        for (Selector<P, R> selector : selectors) {
            if (selector.supports(param)) {
                return selector.init(param);
            }
        }
        throw ObserverUtils.error();
    }

}
