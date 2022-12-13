package com.dx.cmm.service.pusher;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

@Service
public class InvestAccountUpdatePusher extends InvestPusher {

    @Override
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push update account data:{}", new Gson().toJson(data));
            List<MatchBizBase> bases = matchBizBaseDao.queryArray(data.getBizCustCode());
            for (MatchBizBase base : bases) {
                base.account(data.getBizBase());
                save(base);
            }
        }
    }

    @Override
    public Boolean supports(ParamPusher param) {
        return Assert.equals(param.getPushCode(), MatchPushCode.INVEST_ACCOUNT_UPDATE);
    }

    @Override
    void validate(PushData data) throws PushException {
        Assert.notNull(error("Biz cust code must not be null"), data.getBizCustCode());
        Assert.notNull(error("biz base must not be null", data.getBizCustCode()), data.getBizBase());
        Assert.notNull(error("cust name must not be null", data.getBizCustCode()), data.getBizBase().getCustName());
        Assert.notNull(error("id card must not be null", data.getBizCustCode()), data.getBizBase().getIdCard());
        Assert.notNull(error("cust address must not be null", data.getBizCustCode()),
                data.getBizBase().getCustAddress());
        Assert.notNull(error("zip code must not be null", data.getBizCustCode()), data.getBizBase().getZipCode());
        Assert.notNull(error("email must not be null", data.getBizCustCode()), data.getBizBase().getEmail());
        Assert.notNull(error("mobile must not be null", data.getBizCustCode()), data.getBizBase().getMobile());
        Assert.notNull(error("cust category must not be null", data.getBizCustCode()),
                data.getBizBase().getCustCategory());
        Assert.notNull(error("action user must not be null", data.getBizCustCode()), data.getBizBase().getActionUser());
    }

}
