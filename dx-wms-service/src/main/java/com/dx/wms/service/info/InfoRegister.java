package com.dx.wms.service.info;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.ccs.vo.RoleVo;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.model.Model_;

public abstract class InfoRegister implements Info<ParamInfo, ResultInfo> {

    /**
     * 日志组件
     */
    public static final Logger LOG = LoggerFactory.getLogger(InfoRegister.class);

    @Autowired
    private InfoObserver<Info<ParamInfo, ResultInfo>, ParamInfo, ResultInfo> infoObserver;

    @Autowired
    public Model_ model;

    @Autowired
    public PaginationDalClient dalClient;

    @Autowired
    public ICommonService commonService;

    @Override
    @PostConstruct
    public void join() {
        infoObserver.regist(this);
    }

    public Boolean hasRole(String role, Long userId) {
        List<RoleVo> roleVos = commonService.findRolesByUserId(userId);
        return commonService.hasRoleExist(roleVos, role);
    }

}
