package com.dx.wms.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.ICommonService;

@Service("employeeDetailBuilder")
public class EmployeeDetailBuilder extends EntityBuilder {

    /**
     * 通用服务
     */
    @Autowired
    public ICommonService commonService;
    
    @Override
    public void build(Long id, BaseEntitys base) {
        base.setEmployeeEntryDto(commonService.queryEmployeeDetailByEmployeeId(id));
    }

}
