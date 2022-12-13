package com.dx.wms.service.process;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.observer.QueryObserver;

/**
 * 
 * 理财申请流程任务处理 被观察者 容器
 *
 * @author 王蕊
 */
public interface ProcessObserver<S, P, R> extends QueryObserver<S, P, R> {

    /**
     * 
     * 页面model <br>
     * 〈功能详细描述〉
     *
     * @param param
     * @param view
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void put(P param, ModelMap view);

    /**
     * 
     * 功能描述:申请初始化页面<br>
     * 〈功能详细描述〉
     *
     * @param param
     * @return String
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String applyInit(P param);

    /**
     * 功能描述: 查询页面分页<br>
     * 〈功能详细描述〉
     *
     * @param param
     * @return PaginationResult<List<WealthManagementInfoResultDto>>
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<R>> selectQuery(P param, Pagination page);

    /**
     * 
     * 功能描述:创建初始化页面<br>
     * 〈功能详细描述〉
     *
     * @param param
     * @return String
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String createInit(P param);

}
