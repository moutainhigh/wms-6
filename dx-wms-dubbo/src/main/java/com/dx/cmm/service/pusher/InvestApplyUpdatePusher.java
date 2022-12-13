package com.dx.cmm.service.pusher;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

/**
 * 
 * 理财数据变更推送器
 *
 * @author tony
 */
@Service
public class InvestApplyUpdatePusher extends InvestPusher {

    @Override
    public Boolean supports(ParamPusher data) {
        return Assert.equals(data.getPushCode(), MatchPushCode.INVEST_APPLY_UPDATE);
    }

    @Override
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push credit join data:{}", new Gson().toJson(data));
            MatchBizBase base = matchBizBaseDao.query(data.getBizCode());
            super.validate(base);
            base.apply(data.getBizBase());
            save(base);

        }

    }

    @Override
    void validate(PushData data) throws PushException {
        Assert.notNull(error("Biz cust code must not be null"), data.getBizCode());
        Assert.notNull(error("biz base must not be null", data.getBizCode()), data.getBizBase());
        Assert.notNull(error("biz contract code must not be null", data.getBizCustCode()),
                data.getBizBase().getBizContractCode());
    }

}
