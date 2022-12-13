package com.dx.wms.service.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.builder.Builder;

@Service("custApplyWrapper")
public class CustApplyWrapper implements Wrapper<BaseEntitys> {

    @Autowired
    private Builder<BaseEntitys> accountBuilder;

    @Autowired
    private Builder<BaseEntitys> commBuilder;

    @Autowired
    private Builder<BaseEntitys> linkmanBuilder;

    @Autowired
    private Builder<BaseEntitys> professionBuilder;

    @Autowired
    private Builder<BaseEntitys> applyBuilder;

    @Autowired
    private Builder<BaseEntitys> conditionBuilder;

    @Autowired
    private Builder<BaseEntitys> financeBuilder;

    @Override
    public void put(Long id, BaseEntitys base) {
        applyBuilder.build(id, base);
        financeBuilder.build(id, base);
        conditionBuilder.build(id, base);
        Long accountId = base.getApply().getCustAccountId();
        accountBuilder.build(accountId, base);
        commBuilder.build(accountId, base);
        linkmanBuilder.build(accountId, base);
        professionBuilder.build(accountId, base);

    }

}
