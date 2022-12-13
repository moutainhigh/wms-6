package com.dx.cms.service.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;

@Service
public class VoucherQuery extends QueryRegister {

    @Override
    public List<FileResultDto> query(Condition param) {
        if (!Assert.checkParam(param.getLenderApplyId())) {
            return new ArrayList<FileResultDto>();
        }
        List<String> openCodes = new ArrayList<String>();
        openCodes.add(param.getAppCode() + param.getRes().getInfo() + param.getLenderApplyId());
        openCodes.add(param.getLenderCode());
        param.setOpenCodes(openCodes);
        return dalClient.queryForList(SQL, param(param), FileResultDto.class);
    }

    @Override
    public Boolean supports(Condition param) {
        return Assert.checkParam(param.getRes()) && Assert.equals(param.getRes(), ResKey.WMS_VOUCHERS)
                || Assert.checkParam(param.getRes()) && Assert.equals(param.getRes(), ResKey.WMS_REFUSE);
    }

}
