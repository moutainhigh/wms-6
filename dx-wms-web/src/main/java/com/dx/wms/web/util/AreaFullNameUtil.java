/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: AreaFullNameUtil.java
 * Author:   taocheng
 * Date:     2016年4月18日 下午4:29:30
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.util;

import com.dx.framework.constant.service.ConstantCodeService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author taocheng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class AreaFullNameUtil {
    /**
     * 
     * 功能描述: 根据code获取省市区名字<br>
     * 〈功能详细描述〉
     *
     * @param p
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getPca(String codeP, String codeC, String codeA) {
        return getValue(codeP) + getValue(codeC) + getValue(codeA);
    }
    /**
     * 
     * 功能描述: 根据code获取名字<br>
     * 〈功能详细描述〉
     *
     * @param code
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getValue(String code) {
        if (null != code) {
            return ConstantCodeService.getRegionNameByCode(code);
        } else {
            return "";
        }
    }
}
