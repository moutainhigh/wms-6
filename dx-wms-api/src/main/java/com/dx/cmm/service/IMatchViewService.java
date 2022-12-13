package com.dx.cmm.service;

import com.dx.cmm.dto.ResultReport;
import com.dx.cmm.dto.ViewInvestDetailDto;
import com.dx.cmm.enums.ReportType;
import com.dx.cmm.exception.ViewException;

/**
 * 
 * 匹配视图接口<br>
 * 匹配视图接口
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
     * @param custCode
     * @param bizCode
     * @param code
     * @return
     * @throws ViewException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultReport query(String custCode, String bizCode, ReportType code) throws ViewException;

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param bizCode
     * @param code
     * @return
     * @throws ViewException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ViewInvestDetailDto query(String bizCode, ReportType code) throws ViewException;

}
