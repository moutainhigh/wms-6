package com.dx.wms.service.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.builder.Builder;

@Service("employeeWrapper")
public class EmployeeWrapper implements Wrapper<BaseEntitys> {

    @Autowired
    private Builder<BaseEntitys> employeeDetailBuilder;

    @Override
    public void put(Long id, BaseEntitys base) {
        employeeDetailBuilder.build(id, base);
    }

}
