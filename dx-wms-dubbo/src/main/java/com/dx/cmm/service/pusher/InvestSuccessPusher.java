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
 * 投资生效推送器
 *
 * @author tony
 */
@Service
public class InvestSuccessPusher extends InvestPusher {

    @Override
    public Boolean supports(ParamPusher data) {
        return Assert.equals(data.getPushCode(), MatchPushCode.INVEST_SUCCESS);
    }

    @Override
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push invest success data[{}]", new Gson().toJson(data));
            MatchBizBase base = matchBizBaseDao.query(data.getBizCode());
            validate(base);
            base.success(data.getValidDate());
            super.save(base);
        }
    }

    @Override
    void validate(PushData data) throws PushException {
        Assert.checkParam(error("Biz code or valid date must not be null"), data.getBizCode(), data.getValidDate());
    }

    void validate(MatchBizBase base) {
        if (Assert.equals(base.getDataStatus(), BizBaseStatus.SUCCESS.getCode())) {
            LOG.error("Base[{}] is success", new Gson().toJson(base));
            throw error(" is success", base.getBizCode());
        }
        super.validate(base);
    }

}
