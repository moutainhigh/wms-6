package com.dx.cms.service.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.exception.FileException;
import com.dx.cms.service.query.FileQueryGateway;
import com.dx.common.service.utils.Assert;

@Service("queryFileUrl")
public class QueryFileUrl extends ActionRouter<Condition, List<FileResultDto>> {

    @Autowired
    private FileQueryGateway gateway;

    private Boolean validate(Condition param) {
        return Assert.checkParam(param) || Assert.checkParam(param.getAppCode()) || Assert.checkParam(param.getRes())
                || Assert.checkParam(param.getFileDirId());
    }

    @Override
    public List<FileResultDto> execute(Condition param) throws FileException {
        if (!validate(param)) {
            return new ArrayList<FileResultDto>();
        }

        LOG.info("Condition[{}]", param);
        return gateway.query(param);
    }

}
