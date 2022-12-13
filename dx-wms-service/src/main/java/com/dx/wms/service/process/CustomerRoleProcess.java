package com.dx.wms.service.process;

public abstract class CustomerRoleProcess extends ProcessRegister {

    public Boolean supports(ParamProcess param) {
        // 判断销售客服角色角色
        return false;
    }
}
