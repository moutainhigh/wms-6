package com.dx.cmm.service.pusher;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.InvestAttr;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.dx.op.service.entity.Product;

/**
 * 
 * 投资推送器
 *
 * @author tony
 */
abstract class InvestPusher extends PusherRegister<InvestAttr> {

    @Override
    InvestAttr get(MatchBizBase base) {
        return base.invest();
    }

    @Override
    String get(InvestAttr attr) {
        return Assert.checkParam(attr) ? JSON.toJSONString(attr) : "";
    }

    String get(MatchBizBase base, InvestAttr attr) {
        InvestAttr source = get(base);
        source.update(attr);
        return get(source);
    }

    @Override
    void validate(BizBase base) throws PushException {
        super.validate(base);
        if (!base.getBizCode().startsWith("L0")) {
            throw error("Biz code is illegal", base.getBizCode());
        }
        Assert.notNull(error("cust code must not be null"), base.getCustCode());
        Assert.notNull(error("biz cust code must not be null"), base.getBizCustCode());
        if (!productDao.validate(Product.WMS, base.getBizProductId())) {
            throw error("product must be wms product", base.getBizCode());
        }
        Assert.notNull(error("email must not be null", base.getBizCode()), base.getEmail());
        Assert.notNull(error("Attr must be not null", base.getBizCode()), base.getInvestAttr());
    }

    @Override
    void validate(PushData data) throws PushException {
        Assert.checkParam(error("Biz code must not be null"), data.getBizCode());
    }
}
