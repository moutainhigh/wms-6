package com.dx.cmm.service.pusher;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.CreditAttr;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.dx.op.service.entity.Product;

/**
 * 
 * 债权推送器
 *
 * @author tony
 */
abstract class CreditPusher extends PusherRegister<CreditAttr> {

    @Override
    CreditAttr get(MatchBizBase base) {
        return base.credit();
    }

    @Override
    String get(CreditAttr attr) {
        return Assert.checkParam(attr) ? JSON.toJSONString(attr) : "";
    }

    @Override
    void validate(BizBase base) throws PushException {
        super.validate(base);
        if (!base.getBizCode().startsWith("DX")) {
            throw error("Biz code is illegal", base.getBizCode());
        }
        if (!productDao.validate(Product.CCS, base.getBizProductId())) {
            throw error("product must be ccs product", base.getBizCode());
        }
        Assert.notNull(error("attr must be not null", base.getBizCode()), base.getCreditAttr());
    }

    @Override
    void validate(PushData data) throws PushException {
        Assert.checkParam(error("Biz code must not be null"), data.getBizCode());
    }
}
