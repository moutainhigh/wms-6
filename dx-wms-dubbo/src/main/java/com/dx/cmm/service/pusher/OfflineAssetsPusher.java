package com.dx.cmm.service.pusher;

import org.springframework.stereotype.Service;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.common.service.utils.Assert;
/**
 * 
 * 线下资金推送器
 *
 * @author tony
 */
@Service
public class OfflineAssetsPusher extends InvestPusher {

    @Override
    public Boolean supports(ParamPusher data) {
        return Assert.equals(data.getPushCode(), MatchPushCode.OFFLINE_ASSETS);
    }

    @Override
    public void push(ParamPusher data) {
        // TODO Auto-generated method stub
    }

    @Override
    void validate(PushData data) throws PushException {
        // TODO Auto-generated method stub
        
    }

}
