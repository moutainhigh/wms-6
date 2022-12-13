package com.dx.wms.service.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.builder.Builder;

@Service("baseWrapper")
public class BaseWrapper implements Wrapper<BaseEntitys> {

    @Autowired
    private Builder<BaseEntitys> baseBuilder;

    @Override
    public void put(Long id, BaseEntitys base) {
        baseBuilder.build(id, base);
        base.setComm().setLinkman().setProfession();
    }

}
