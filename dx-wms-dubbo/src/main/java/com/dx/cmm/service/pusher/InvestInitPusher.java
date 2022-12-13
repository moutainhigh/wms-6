package com.dx.cmm.service.pusher;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.BizCategory;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;

abstract class InvestInitPusher extends InvestPusher {

    MatchBizBase init(PushData data) {
        MatchBizBase base = matchBizBaseDao.query(data.getBizCode());
        if (Assert.checkParam(base)) {
            throw error("Base biz code[{0}] exists", base.getBizCode());
        }
        base = new MatchBizBase(data.getBizBase());
        base.setBizCategory(BizCategory.INVEST);
        return base;
    }
}
