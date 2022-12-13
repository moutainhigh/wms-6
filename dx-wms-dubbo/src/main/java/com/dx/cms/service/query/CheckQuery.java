package com.dx.cms.service.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

@Service
public class CheckQuery extends QueryRegister {

    @Override
    public List<FileResultDto> query(Condition param) {
        LOG.info("*** CheckQuery   query()  param={}", new Gson().toJson(param));
        if (!Assert.checkParam(param.getLenderApplyId())) {
            return new ArrayList<>();
        }
        List<String> openCodes = new ArrayList<String>();
        openCodes.add(param.getLenderCustCode());
        openCodes.add(param.getLenderCode());
        param.setOpenCodes(openCodes);
        return dalClient.queryForList(SQL, param(param), FileResultDto.class);
    }

    @Override
    public Boolean supports(Condition param) {
        return Assert.checkParam(param.getRes()) && Assert.equals(param.getRes(), ResKey.WMS_CHECK)
                && Assert.equals(CMSConstants.CMS_CMACTION_QUERY_FILES, param.getCmAction());
    }

}
