package com.dx.cmm.service.pusher;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

/**
 * 
 * 重新匹配推送器
 *
 * @author tony
 */
@Service
public class MatchRepeatPusher extends InvestPusher {

    @Override
    public Boolean supports(ParamPusher data) {
        return Assert.equals(data.getPushCode(), MatchPushCode.MATCH_REPEAT);
    }

    @Override
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push match repeat data[{}]", new Gson().toJson(data));
            MatchBizBase base = matchBizBaseDao.query(data.getBizCode());
            validate(base);
            base.repeat(data.getCreditIds());
            super.save(base);
        }
    }

    @Override
    void validate(PushData data) throws PushException {
        Assert.notNull(error("Biz code or valid date must not be null"), data.getBizCode(), data.getCreditIds());
    }

    void validate(MatchBizBase base) {
        super.validate(base);
        if (Assert.equals(base.getDataStatus(), BizBaseStatus.REPEAT.getCode())) {
            throw error("is repeating", base.getBizCode());
        }
    }
}
