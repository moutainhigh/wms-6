package com.dx.cmm.service.reports;

import java.util.List;

import com.dx.cmm.service.common.DataService;

/**
 * 
 * 报告
 *
 * @author tony
 */
public interface Report<P, R> extends DataService<P> {

    /**
     * 
     * 查询
     *
     * @param param
     * @return
     */
    R query(P param);

    /**
     * 
     * 查询
     *
     */
    List<R> queryList(P param);
}
