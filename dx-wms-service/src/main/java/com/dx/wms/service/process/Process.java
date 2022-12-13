package com.dx.wms.service.process;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.common.QueryService;

/**
 * 
 * 审批流程服务<br>
 * 审批流程服务
 *
 * @author tony
 */
public interface Process<P, R> extends QueryService<P, R> {

    /**
     * 
     * 功能描述: <br>
     * 加载视图
     *
     * @param param
     * @param view
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
     * 
     * 功能描述: <br>
     * 查询
     *
     * @param param
     * @param page
     * @return
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
