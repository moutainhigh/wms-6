package com.dx.wms.web.hr.service;

import java.util.List;
import java.util.Map;

import com.dx.hr.service.dto.CommentResultDto;
import com.dx.hr.service.dto.EmployeeLogDto;
import com.dx.wms.service.detail.ResultDetail;

public interface IHRResultService {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void getResult(ResultDetail result, Long userId, Map<String, String> addrMap, Map<String, String> orgs,
            List<CommentResultDto> approves, List<EmployeeLogDto> logs, Long parentId);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param result
     * @param approves
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<CommentResultDto> getApproves(Long employeeId);
}
