package com.dx.cmm.service.pusher;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchPushCode;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 债券回滚推送器
 *
 * @author tony
 */
@Service
public class CreditRollbackPusher extends CreditDestoryPusher {

    @Override
    public Boolean supports(ParamPusher param) {
        return Assert.equals(param.getPushCode(), MatchPushCode.CREDIT_ROLLBACK);
    }

}
