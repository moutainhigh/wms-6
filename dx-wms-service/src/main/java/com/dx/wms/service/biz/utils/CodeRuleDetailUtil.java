/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CodeRuleDetailUtil.java
 * Author:   蔡登勇
 * Date:     2015年7月20日 下午8:06:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.biz.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.dx.common.service.utils.StringSplitUtils;
import com.dx.wms.constant.CodeRuleConstants;
import com.dx.wms.dto.CodeRuleVersionDetailDto;
import com.dx.wms.service.exception.CodeRuleIPIsErrorException;

/**
 * 编号规则 对象类型 map重用
 *
 * @author 蔡登勇
 */
public class CodeRuleDetailUtil {
    // 规则明细类型为对象类型时，尝试中Map取出指定的对象Map,如果取到从Map取值，否则走监听者调用对应方法
    public static Map<String, Object> resuleReusing(Map<String, Object> param) {
        CodeRuleVersionDetailDto codeRuleVersionDetailDto = (CodeRuleVersionDetailDto) param
                .get("codeRuleVersionDetailDto");
        if (codeRuleVersionDetailDto.getCodeRuleDetailType() == CodeRuleConstants.OBJECT_TYPE) {
            String classname = StringSplitUtils.getStringValue(codeRuleVersionDetailDto.getCodeRuleDetailVal(),
                    CodeRuleConstants.OBJECT_TYPE_DETAIL_VALUE_SEPARATOR, 0);
            String keyname = StringSplitUtils.getStringValue(codeRuleVersionDetailDto.getCodeRuleDetailVal(),
                    CodeRuleConstants.OBJECT_TYPE_DETAIL_VALUE_SEPARATOR, 1);
            String value = "";
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) param.get(classname);
            if (map != null) {
                value = (String) map.get(keyname);
                if (StringUtils.isBlank(value)) {
                    throw new CodeRuleIPIsErrorException("对象类型明细值配置错误");
                }
                param.put(codeRuleVersionDetailDto.getCodeVersionDetailIndex().toString(), value);
            }
        } else {
            throw new CodeRuleIPIsErrorException("Map重用使用场景错误");
        }
        return param;
    }
}
