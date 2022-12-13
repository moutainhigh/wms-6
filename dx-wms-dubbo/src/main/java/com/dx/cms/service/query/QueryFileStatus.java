package com.dx.cms.service.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

@Service
public class QueryFileStatus extends QueryRegister {

    /**
     * 查询关于生效与否的影像 的sqlid
     */
    private static final String SQLID_WITH_STATUS = "contentManagement.queryForFilesByOpenCodeAndStatus";

    @Override
    public List<FileResultDto> query(Condition param) {
        LOG.info("*** ApplyQuery   query()  param={}", new Gson().toJson(param));
        if (validate(param)) {
            return new ArrayList<>();
        }
        return dalClient.queryForList(SQLID_WITH_STATUS, param(param), FileResultDto.class);
    }

    @Override
    public Boolean supports(Condition param) {
        // return Assert.equals("getFoldersStatus", param.getCmAction());
        return false;
    }

    private Boolean validate(Condition param) {
        return Assert.checkParam(param.getRes())
                && ((Assert.equals(param.getRes(), ResKey.WMS_OPEN) && !Assert.checkParam(param.getCustAccountId()))
                        || (Assert.equals(param.getRes(), ResKey.WMS_APPLY)
                                && !Assert.checkParam(param.getLenderApplyId()))
                        || (Assert.equals(param.getRes(), ResKey.WMS_VOUCHERS)
                                && !Assert.checkParam(param.getLenderApplyId())));
    }

}
