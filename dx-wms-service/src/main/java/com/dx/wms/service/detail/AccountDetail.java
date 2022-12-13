package com.dx.wms.service.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.wrapper.Wrapper;

@Service
public class AccountDetail extends DetailRegister {

    @Autowired
    private Wrapper<BaseEntitys> accountWrapper;

    @Override
    public Boolean supports(ParamDetail param) {
        return Assert.equals(param.getDetail(), DetailType.ACCOUNT);
    }

    @Override
    public void wrapper(ParamDetail param, ResultDetail result) {
        super.wrapper(param, result);
        accountWrapper.put(param.getId(), result);
        result.setFolders(fileService.queryByCode(result.getAccount().getLenderCustCode(),
                result.getAccount().getCustAccountId(), null, null, ResKey.WMS_OPEN));
    }

}
