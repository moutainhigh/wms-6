package com.dx.cmm.service.pusher;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.BizCategory;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

/**
 * 
 * 债权加入推送器
 *
 * @author tony
 */
@Service
public class CreditJoinPusher extends CreditPusher {

    @Override
    public void push(ParamPusher param) throws PushException {
        for (PushData data : param.getDatas()) {
            validate(data);
            LOG.info("Push credit join data:{}", new Gson().toJson(data));
            MatchBizBase base = matchBizBaseDao.query(data.getBizCode());
            if (Assert.checkParam(base)) {
                LOG.error("Biz code[{}] exists", base.getBizCode());
                continue;
            }
            base = new MatchBizBase(data.getBizBase());
            base.setBizAttr(get(data.getBizBase().getCreditAttr())).setBizCategory(BizCategory.CREDIT);
            save(base);
        }
    }

    @Override
    public Boolean supports(ParamPusher data) {
        return Assert.equals(data.getPushCode(), MatchPushCode.CREDIT_JOIN);
    }

    @Override
    void validate(PushData data) throws PushException {
        super.validate(data.getBizBase());
    }

}
