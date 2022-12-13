package com.dx.cms.service.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.common.service.utils.Assert;

@Service
public class QueryMake extends QueryRegister {

    /**
     * 查询尚未生效的影像文件的sqlid
     */
    private static final String INVALID_FILE_SQL_ID = "contentManagement.queryForFilesByOpenCode";

    @Override
    public List<FileResultDto> query(Condition param) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("openCode", param.getAppCode());
        paramMap.put("updateUser", param.getUser());
        return dalClient.queryForList(INVALID_FILE_SQL_ID, paramMap, FileResultDto.class);
    }

    @Override
    public Boolean supports(Condition param) {
        return (Assert.equals("createUserAccount", param.getAction())
                || Assert.equals("submitToSalesService", param.getAction())
                || Assert.equals("uploadPaymentVouchers", param.getAction()))
                && Assert.equals(CMSConstants.CMS_CMACTION_EFFECTIVE_FILES, param.getCmAction());
    }

}
