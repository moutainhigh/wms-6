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
 * 投资失败推送器
 *
 * @author tony
 */
@Service
public class InvestFailPusher extends InvestPusher {

    @Override
    public Boolean supports(ParamPusher data) {
        return Assert.equals(data.getPushCode(), MatchPushCode.INVEST_FAIL);
    }

    @Override
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push invest fail data:{}", new Gson().toJson(data));
            MatchBizBase base = matchBizBaseDao.query(data.getBizCode());
            validate(base);
            base.fail();
            super.save(base);
        }
    }

    void validate(MatchBizBase base) {
        super.validate(base);
        if (Assert.equals(base.getDataStatus(), BizBaseStatus.FAIL.getCode())) {
            LOG.error("Base[{}] is fail", new Gson().toJson(base));
            throw error(" is fail", base.getBizCode());
        }
        if (!Assert.equals(base.getDataStatus(), BizBaseStatus.MATCH.getCode())
                && !Assert.equals(base.getDataStatus(), BizBaseStatus.REPEAT.getCode())
                && !Assert.equals(base.getDataStatus(), BizBaseStatus.WAIT.getCode())
                && !Assert.equals(base.getDataStatus(), BizBaseStatus.CREATED.getCode())) {
            LOG.error("Base[{}] has error status", new Gson().toJson(base));
            throw error(" has error status", base.getBizCode());
        }     
    }

}
