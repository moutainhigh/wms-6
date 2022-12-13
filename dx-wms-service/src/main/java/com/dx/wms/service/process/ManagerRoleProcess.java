package com.dx.wms.service.process;

public abstract class ManagerRoleProcess extends ProcessRegister {

    public Boolean supports(ParamProcess param) {
        // 判断客户经理角色
        return false;
    }

}
