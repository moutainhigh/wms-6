package com.dx.wms.service.process;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.ccs.vo.RoleVo;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.model.Model_;

public abstract class ProcessRegister implements Process<ParamProcess, ResultProcess> {

    @Autowired
    private ProcessObserver<Process<ParamProcess, ResultProcess>, ParamProcess, ResultProcess> observer;

    @Autowired
    public PaginationDalClient dalClient;

    @Autowired
    public ICommonService commonService;

    /**
     * 通用的Model服务
     */
    @Autowired
    public Model_ model;

    @Override
    @PostConstruct
    public void join() {
        observer.regist(this);
    }

    public Boolean hasRole(String role, Long userId) {
        List<RoleVo> roleVos = commonService.findRolesByUserId(userId);
        return commonService.hasRoleExist(roleVos, role);
    }
}
