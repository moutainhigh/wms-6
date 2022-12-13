package com.dx.wms.service.changer;

import java.util.List;
import java.util.Map;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.common.QueryService;

/**
 * 变更服务
 * 
 * @author yangbao
 */
public interface Changer<P, R, T> extends QueryService<P, R> {

    /**
     * 
     * 功能描述: 变更悬浮窗 〈功能详细描述〉
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
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String view(P param);

    /**
     * 查询变更日志
     */
    PaginationResult<List<R>> queryRecord(P param, Pagination page);

    /**
     * 
     * 功能描述: 变更获取客户信息，账户信息 〈功能详细描述〉
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
