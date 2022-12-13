/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICustTransferService.java
 * Author:   黄健
 * Date:     2015年10月15日 下午3:00:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.transfer;

import java.util.List;

import com.dx.ccs.vo.UserVo;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.log.CustTransferLog;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ICustTransferService {

    /**
     * 
     * 功能描述: 查询客户转移的客户信息
     * 〈功能详细描述〉
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<ResultTransfer>> queryForPage(ParamTransfer param);
    
    /*
     * 根据客户编号查询转移日志
     */
    PaginationResult<List<ResultTransLog>> queryTransLog(String lenderCustCode, Pagination page);

    /**
     * 
     * 功能描述:客户转移是否成功
     * 〈功能详细描述〉
     *
     * @param param
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean transferCustsToCustManager(ParamTransfer param, Long userId);

    /**
     * 
     * 功能描述: 根据要转移的客户编号查询客户信息
     * 〈功能详细描述〉
     *
     * @param custIds
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<ResultTransfer> queryCustBase(String custIds);
    
    /**
     * 
     * 功能描述: 根据客户编号和组织获取客户经理
     * 〈功能详细描述〉
     *
     * @param custIds
     * @param orgId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<UserVo> queryCustManagers(String custIds,Long orgId);
    
    /**
     * 
     * 功能描述: 保存客户转移记录 〈功能详细描述〉
     *
     * @param custCode
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    CustTransferLog saveCustTransferLog(ParamTransfer param, Long userId, Integer type);
}
