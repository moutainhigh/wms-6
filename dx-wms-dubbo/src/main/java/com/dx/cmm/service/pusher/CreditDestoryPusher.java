package com.dx.cmm.service.pusher;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.google.gson.Gson;

abstract class CreditDestoryPusher extends CreditPusher {

    @Override
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push credit [{}] data[{}]", param.getPushCode(), new Gson().toJson(data));
            MatchBizBase base = matchBizBaseDao.query(data.getBizCode());
            super.validate(base);
            if (base.isInit()) {
                base.del();
            } else {
                base.exception();
            }
            super.save(base);
        }

    }
}
