/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICreditDetailService.java
 * Author:   蔡登勇
 * Date:     2015年8月4日 下午10:29:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.intf;

import java.util.Date;
import java.util.List;

import com.dx.wms.vo.CreditorDetailVo;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ICreditorDetailService {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param investmentId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<CreditorDetailVo> getByInvestmentId(Long investmentId, Integer currentPeriod, Date matchDate);
}
