package com.dx.cmm.service;

import com.dx.cmm.dto.ResultReport;
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
public interface IBillViewService {

    /**
     * 
     * 功能描述: <br>
     * 根据业务编号及业务编码获取视图对象
     *
     * @param bizCode 业务编号
     * @param code 业务编码
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultReport query(String bizCode, ReportType code) throws ViewException;

}
