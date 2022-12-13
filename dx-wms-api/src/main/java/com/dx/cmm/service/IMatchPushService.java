package com.dx.cmm.service;

import java.util.List;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;

/**
 * 
 * 匹配推送服务
 *
 * @author tony
 */
public interface IMatchPushService {

    /**
     * 
     * 推送数据
     *
     * @param datas 数据
     * @param pushCode 推送规则
     */
    void push(List<PushData> datas, MatchPushCode pushCode) throws PushException;

    /**
     * 
     * 推送数据
     *
     * @param pushCode 推送规则
     * @param datas 数据
     * @throws PushException
     */
    void push(MatchPushCode pushCode, PushData... datas) throws PushException;
}
