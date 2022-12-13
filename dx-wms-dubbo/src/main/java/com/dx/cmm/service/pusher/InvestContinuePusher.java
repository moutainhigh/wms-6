package com.dx.cmm.service.pusher;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.google.gson.Gson;

/**
 * 
 * 续投推送
 *
 * @author tony
 */
@Service
public class InvestContinuePusher extends InvestInitPusher {

    @Override
    @Transactional
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push invest continue data[{}]", new Gson().toJson(data));
            MatchBizBase base = init(data);
            base.doContinue();
            save(base);
        }

    }

    @Override
    public Boolean supports(ParamPusher data) {
        return Assert.equals(data.getPushCode(), MatchPushCode.INVEST_CONTINUE);
    }

    @Override
    void validate(PushData data) throws PushException {
        super.validate(data.getBizBase());
        if (!Assert.checkParam(data.getIsContinue()) || !data.getIsContinue()) {
            LOG.error("Date[{}] continue must not be null and is true", new Gson().toJson(data));
            throw error(" continue must not be null and is true", data.getBizCode());
        }

    }

}
