/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IReportService.java
 * Author:   张祥韵
 * Date:     2015年11月19日 上午11:56:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.form;

import java.util.List;
import java.util.Map;

import com.dx.wms.service.common.QueryService;

/**
 * 报表
 * 
 * @author zhangxiangyun
 */
public interface Form<P, R> extends QueryService<P, R> {

    List<R> getExcelVos(P param);

    void queryExcel(P param);

    Map<String, Object> getRequestMap(P param);

    FormParamVo getManagementQueryVo(P param);

    R queryallLenderAmount(P param);

    Map<String, String> getAttributeMap(P param);

}
