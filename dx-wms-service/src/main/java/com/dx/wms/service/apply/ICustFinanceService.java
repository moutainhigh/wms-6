/*
 * Copyright (C), 2014-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICustFinanceService.java
 * Author:   michelle
 * Date:     2015年8月1日 上午11:39:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.apply;

import java.util.List;

import com.dx.wms.service.apply.entity.CustFinance;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
public interface ICustFinanceService {

    List<CustFinance> queryByApplyId(Long lenderApplyId);

}
