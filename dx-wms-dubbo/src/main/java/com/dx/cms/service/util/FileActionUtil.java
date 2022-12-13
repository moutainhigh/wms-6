package com.dx.cms.service.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.cms.dto.Condition;
import com.dx.cms.exception.FileException;
import com.dx.common.service.utils.Assert;

public class FileActionUtil {

    /**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(FileActionUtil.class);

    public static Map<String, Object> getExecuteParam(Condition param) {
        Map<String, Object> mapParam = new HashMap<String, Object>();
        String oldOpenCode;
        switch (param.getAction()) {
            case "createUserAccount":
                oldOpenCode = FileCodeUtils
                        .init(param.getAppCode(), param.getRes().getInfo(), param.getCustAccountId());
                validate(oldOpenCode, param.getLenderCustCode(), param.getUser());
                mapParam.put("openCode", oldOpenCode);
                mapParam.put("newOpenCode", param.getLenderCustCode());
                mapParam.put("updateUser", param.getUser());
                return mapParam;
            case "submitToSalesService":
                oldOpenCode = FileCodeUtils
                        .init(param.getAppCode(), param.getRes().getInfo(), param.getLenderApplyId());
                validate(oldOpenCode, param.getLenderCode(), param.getUser());
                mapParam.put("openCode", oldOpenCode);
                mapParam.put("newOpenCode", param.getLenderCode());
                mapParam.put("updateUser", param.getUser());
                return mapParam;
            case "uploadPaymentVouchers":
                oldOpenCode = FileCodeUtils
                        .init(param.getAppCode(), param.getRes().getInfo(), param.getLenderApplyId());
                mapParam.put("openCode", oldOpenCode);
                mapParam.put("newOpenCode", param.getLenderCode());
                mapParam.put("updateUser", param.getUser());
                return mapParam;
            default:
                return null;
        }
    }

    private static void validate(String oldOpenCode, String newOpenCode, Long userId) {
        Assert.notNull(new FileException("oldOpenCode不能为空"), oldOpenCode);
        Assert.notNull(new FileException("newOpenCode不能为空"), newOpenCode);
        Assert.notNull(new FileException("userId不能为空"), userId);
    }

}
