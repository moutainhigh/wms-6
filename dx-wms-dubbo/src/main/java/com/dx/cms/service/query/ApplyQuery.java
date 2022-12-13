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
public class ApplyQuery extends QueryRegister {

    @Override
    public List<FileResultDto> query(Condition param) {
        LOG.info("*** ApplyQuery   query()  param={}", new Gson().toJson(param));
        if (!Assert.checkParam(param.getLenderApplyId())) {
            return new ArrayList<>();
        }
        // 申请显示开户生效的和投资申请id 的影像件
        List<String> openCodes = new ArrayList<String>();
        openCodes.add(param.getLenderCustCode());
        openCodes.add(param.getAppCode() + param.getRes().getInfo() + param.getLenderApplyId());
        if (Assert.checkParam(param.getLenderCode())) {
            openCodes.add(param.getLenderCode());
        }
        param.setOpenCodes(openCodes);
        return dalClient.queryForList(SQL, param(param), FileResultDto.class);
    }

    @Override
    public Boolean supports(Condition param) {
        return Assert.checkParam(param.getRes()) && Assert.equals(param.getRes(), ResKey.WMS_APPLY)
                && Assert.equals(CMSConstants.CMS_CMACTION_QUERY_FILES, param.getCmAction());
    }

}
