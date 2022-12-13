/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: BooleanUtil.java
 * Author:   蔡登勇
 * Date:     2015年8月28日 下午6:05:30
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.utils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BooleanUtil {

    public static Boolean getBoolean(Integer i){
        boolean flag = false;
        if(i==1){
            flag = true;
        }
        return flag;
    }
}
