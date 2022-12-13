package com.dx.cmm.service;

import java.util.List;

import com.dx.cmm.dto.AccountDetailDto;
import com.dx.cmm.dto.AccountParamDto;
import com.dx.cmm.dto.AccountResultDto;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 投资客户服务<br>
 * 投资客户服务
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IAccountService {

    /**
     * 
     * 功能描述: <br>
     * 根据参数查询账户级别信息
     *
     * @param param 参数
     * @param page 分页
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<AccountResultDto>> query(AccountParamDto param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 根据客户编号查询投资列表(已生效&未到期)
     *
     * @param custUserId 客户编号
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AccountDetailDto> query(Long custUserId);

}
