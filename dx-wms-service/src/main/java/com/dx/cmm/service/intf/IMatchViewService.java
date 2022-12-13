package com.dx.cmm.service.intf;

import java.util.List;

import com.dx.cmm.service.dto.MatchExcelDto;
import com.dx.cmm.service.dto.MatchViewQueryDto;
import com.dx.cmm.service.dto.MatchViewResultDto;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IMatchViewService {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param query
     * @param page
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<MatchViewResultDto>> queryByPage(MatchViewQueryDto query, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param query
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<MatchExcelDto> export(MatchViewQueryDto query);
}
