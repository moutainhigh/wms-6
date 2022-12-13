/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BizType.java
 * Author:   LIUQIONG
 * Date:     2016年8月23日 下午2:18:24
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.enums;

import java.util.HashMap;
import java.util.Map;

import com.dx.common.service.utils.Assert;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author LIUQIONG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum BizType {

    REPORT(1, "report");

    private Integer code;

    private String info;

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    private BizType(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public static BizType getEunm(Integer code) {
        if (!Assert.checkParam(code)) {
            return null;
        }
        for (BizType bizType : BizType.values()) {
            if (bizType.getCode().equals(code)) {
                return bizType;
            }
        }
        return null;
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new HashMap<String, String>();
        for (BizType bizType : BizType.values()) {
            result.put(String.valueOf(bizType.getCode()), bizType.getInfo());
        }
        return result;
    }

}
