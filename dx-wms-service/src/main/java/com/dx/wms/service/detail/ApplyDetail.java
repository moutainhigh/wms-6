package com.dx.wms.service.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.log.ILenderApplyLogService;
import com.dx.wms.service.wrapper.Wrapper;

@Service
public class ApplyDetail extends DetailRegister {

    @Autowired
    private Wrapper<BaseEntitys> applyWrapper;

    @Autowired
    private ILenderApplyLogService lenderApplyLogService;

    @Override
    public Boolean supports(ParamDetail param) {
        return Assert.equals(param.getDetail(), DetailType.APPLY);
    }

    @Override
    public void wrapper(ParamDetail param, ResultDetail result) {
        super.wrapper(param, result);
        applyWrapper.put(param.getId(), result);
        result.setLogs(lenderApplyLogService.queryByParam(param.getId()));
        result.setFolders(
                fileService.queryByCode(result.getAccount().getLenderCustCode(), result.getAccount().getCustAccountId(),
                        result.getApply().getLenderCode(), result.getApply().getLenderApplyId(), ResKey.WMS_APPLY));
    }
}
