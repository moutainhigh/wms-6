package com.dx.cms.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;

@Service
public class OpenApplySet extends UtilRegister {

    @Override
    public List<FileResultDto> action(Condition param, List<FileResultDto> pList, Long fileDirId) {
        List<FileResultDto> list = new ArrayList<FileResultDto>();
        String openCode = FileCodeUtils.init(param.getAppCode(), param.getResKey(), param.getCustAccountId());
        if (Assert.checkParam(param.getLenderCustCode())) {
            spliceList(list, getFileList(pList, param.getAppCode(), param.getLenderCustCode(), fileDirId));
        }
        if (Assert.checkParam(openCode)) {
            spliceList(list, getFileList(pList, param.getAppCode(), openCode, fileDirId));
        }
        return list;
    }

    @Override
    public Boolean supports(Condition param) {
        return Assert.equals(param.getRes(), ResKey.WMS_OPEN);
    }

}
