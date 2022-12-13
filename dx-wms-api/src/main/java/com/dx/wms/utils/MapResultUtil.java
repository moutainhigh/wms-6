/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileParsingUtil.java
 * Author:   黄健
 * Date:     2015年8月24日 下午4:17:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.cms.constant.CMSConstants;

/**
 * 影像文件解析
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MapResultUtil {
    
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(MapResultUtil.class);
    
    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMapResult(String code, String message, Object... mapResult) {
        Map<String, Object> param = null;
        if(null == mapResult || mapResult.length == 0) {
            param = new HashMap<String, Object>();
        } else {
            param = (Map<String, Object>) mapResult[0];
        }
        param.put(CMSConstants.ACTION_CODE, code);
        param.put(CMSConstants.ACTION_MESSAGE, message);
        LOG.info("**getMapResult() param ACTION_CODE = {} , ACTION_MESSAGE = {}", code, message);
        return param;
    }
}
