package com.dx.wms.service.changer;

import java.util.List;
import java.util.Map;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.observer.QueryObserver;

/**
 * 变更观察者
 * 
 * @author yangbao
 *
 */
public interface ChangerObserver<S, P, R, T> extends QueryObserver<S, P, R> {

    /**
     * 变更悬浮窗界面 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String changePage(P param);

    /**
     * 
     * 功能描述: 变更日志悬浮窗 〈功能详细描述〉
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String recordView(P param);

    /**
     * 
     * 功能描述: 查询变更日志 〈功能详细描述〉
     *
     * @param param
     * @param page
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<R>> queryRecord(P param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    T getDto(P param);

    /**
     * 
     * 功能描述: 变更保存 〈功能详细描述〉
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> save(P param);
}
