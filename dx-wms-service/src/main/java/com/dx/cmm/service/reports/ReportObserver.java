package com.dx.cmm.service.reports;

import java.util.List;

import com.dx.cmm.service.observer.DataObserver;

/**
 * 
 * 报告观察者
 *
 * @author tony
 */
public interface ReportObserver<S, P, R> extends DataObserver<S> {

    /**
     * 
     * 查询
     *
     * @param param
     */
    R query(P param);

    /**
     * 
     * 查询
     *
     * @param param
     */
    List<R> queryList(P param);

}
