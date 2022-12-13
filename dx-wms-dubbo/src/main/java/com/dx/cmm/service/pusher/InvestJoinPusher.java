package com.dx.cmm.service.pusher;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.google.gson.Gson;

/**
 * 
 * 投资加入推送器
 *
 * @author tony
 */
@Service
public class InvestJoinPusher extends InvestInitPusher {

    @Override
    public Boolean supports(ParamPusher data) {
        return Assert.equals(data.getPushCode(), MatchPushCode.INVEST_JOIN);
    }

    @Override
    @Transactional
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push invest join data[{}]", new Gson().toJson(data));
            save(init(data));
        }
    }

    @Override
    void validate(PushData data) throws PushException {
        super.validate(data.getBizBase());
    }

}
