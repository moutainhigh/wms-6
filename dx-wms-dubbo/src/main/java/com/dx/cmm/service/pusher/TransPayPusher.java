package com.dx.cmm.service.pusher;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

@Service
public class TransPayPusher extends InvestPusher {

    @Override
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push invest trans data:{}", new Gson().toJson(data));
            MatchBizBase base = matchBizBaseDao.query(data.getBizCode());
            validate(base);
            base.trans(data.getTradeTime());
            super.save(base);
        }
    }

    @Override
    public Boolean supports(ParamPusher param) {
        return Assert.equals(param.getPushCode(), MatchPushCode.TRANS_PAY);
    }

    @Override
    void validate(PushData data) throws PushException {
        Assert.notNull(error("Biz code or valid date must not be null"), data.getBizCode(), data.getTradeTime());
    }
    
    void validate(MatchBizBase base) {
        super.validate(base);
        if (Assert.equals(base.getDataStatus(), BizBaseStatus.TRANS.getCode())) {
            throw error("is trans", base.getBizCode());
        }
    }
}
