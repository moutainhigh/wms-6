package com.dx.wms.service.process;

public abstract class MainRoleProcess extends ProcessRegister {

    public Boolean supports(ParamProcess param) {
        // 判断执委会的角色
        return false;
    }

}
