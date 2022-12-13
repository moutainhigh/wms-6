package com.dx.cmm.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.pusher.ParamPusher;
import com.dx.cmm.service.pusher.Pusher;
import com.dx.cmm.service.pusher.PusherObserver;
import com.google.gson.Gson;

public class PusherGateway implements IMatchPushService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(PusherGateway.class);

    @Autowired
    private PusherObserver<Pusher<ParamPusher>, ParamPusher> pusher;

    @Override
    public void push(List<PushData> datas, MatchPushCode pushCode) throws PushException {
        LOG.info("Push code[{}],datas[{}]", pushCode, new Gson().toJson(datas));
        pusher.push(new ParamPusher(datas, pushCode));
    }

    @Override
    public void push(MatchPushCode pushCode, PushData... datas) throws PushException {
        LOG.info("Push code[{}],datas[{}]", pushCode, new Gson().toJson(datas));
        pusher.push(new ParamPusher(pushCode, datas));
    }

}
