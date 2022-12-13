/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: IHRFileService.java
 * Author:   黄健
 * Date:     2016年1月19日 下午7:04:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.service;

import java.util.List;
import java.util.Map;

import com.dx.hr.service.dto.EmployeeVideoDto;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IHRFileService {

    /**
     * 上传影像文件
     *  
     * @param params    101-上传成功
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> upload(Map<String,Object> params);
    
    /**
     * 删除影像
     *
     * @param userId    操作人id
     * @param employeeId    员工id
     * @return      1-删除成功 0-删除失败
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> delete(Long userId, Long employeeId, Long employeeVideoId);
    
    /**
     * 查询员工影像
     *
     * @param employeeId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<EmployeeVideoDto> query(Long employeeId);
    
}
