/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: IWMSBizService.java
 * Author:   FlaTa
 * Date:     2016年4月5日 上午10:25:29
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service;

import java.math.BigDecimal;
import java.util.List;

import com.dx.cmm.dto.QueryResultDto;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.dto.LenderQueryDto;
import com.dx.wms.dto.LenderResultDto;

/**
 * 〈一句话功能简述〉理财业务数据查询Service<br>
 * 〈功能详细描述〉
 *
 * @author 蒋玉涛
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ILenderQueryService {

    /**
     * 功能描述: 根据状态查询数据，姓名和证件号为可选条件<br>
     * 〈功能详细描述〉
     *
     * @param queryDto 其中formStatus不为null
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<LenderResultDto>> queryResultByDueDate(LenderQueryDto queryDto);

    /**
     * 
     * 功能描述: 根据状态查询申请金额，姓名和证件号为可选条件<br>
     * 〈功能详细描述〉
     *
     * @param queryDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    BigDecimal queryAmountsByDueDate(LenderQueryDto queryDto);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param lenderCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    QueryResultDto queryLenderCode(String lenderCode);

    QueryResultDto queryApplyId(Long applyId);

}
