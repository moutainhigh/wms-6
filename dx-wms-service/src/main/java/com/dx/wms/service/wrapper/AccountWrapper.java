package com.dx.wms.service.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.builder.Builder;

@Service("accountWrapper")
public class AccountWrapper implements Wrapper<BaseEntitys> {

    @Autowired
    private Builder<BaseEntitys> accountBuilder;

    @Autowired
    private Builder<BaseEntitys> commBuilder;

    @Autowired
    private Builder<BaseEntitys> linkmanBuilder;

    @Autowired
    private Builder<BaseEntitys> professionBuilder;

    @Override
    public void put(Long id, BaseEntitys base) {
        accountBuilder.build(id, base);
        commBuilder.build(id, base);
        linkmanBuilder.build(id, base);
        professionBuilder.build(id, base);
    }

}
