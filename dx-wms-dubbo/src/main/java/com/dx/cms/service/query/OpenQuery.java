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
public class OpenQuery extends QueryRegister {

    @Override
    public List<FileResultDto> query(Condition param) {

        LOG.info("*** OpenQuery   query()  param={}", new Gson().toJson(param));
        if (!Assert.checkParam(param.getCustAccountId())) {
            return new ArrayList<FileResultDto>();
        }
        // 开户的时候可以看到上传的影像件，是否生效的都可以看到
        List<String> openCodes = new ArrayList<String>();
        openCodes.add(param.getAppCode() + param.getRes().getInfo() + param.getCustAccountId());
        if (Assert.checkParam(param.getLenderCustCode())) {
            openCodes.add(param.getLenderCustCode());
        }
        param.setOpenCodes(openCodes);
        return dalClient.queryForList(SQL, param(param), FileResultDto.class);
    }

    @Override
    public Boolean supports(Condition param) {
        return Assert.checkParam(param.getRes()) && Assert.equals(param.getRes(), ResKey.WMS_OPEN)
                && Assert.equals(CMSConstants.CMS_CMACTION_QUERY_FILES, param.getCmAction());
    }

}
