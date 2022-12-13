package com.dx.cmm.service.pusher;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.exception.PushException;
import com.dx.common.service.utils.Assert;

/**
 * 
 * 推送Dto
 *
 * @author tony
 */
public class ParamPusher implements Serializable {

    /**
     */
    private static final long serialVersionUID = 7381387518207174205L;

    /**
     * 推送对象集合
     */
    private List<PushData> datas;

    /**
     * 推送编码
     */
    private MatchPushCode pushCode;

    public ParamPusher(List<PushData> datas, MatchPushCode code) throws PushException {
        Assert.notNull(new PushException("Datas or code must not be null"), datas, code);
        Assert.hasRepeat(datas, new PushException("Biz code must not be repeated"));
        setDatas(datas);
        setPushCode(code);
    }

    public ParamPusher(MatchPushCode code, PushData... datas) throws PushException {
        Assert.notNull(new PushException("Datas or code must not be null"), datas, code);
        setDatas(Arrays.asList(datas));
        Assert.hasRepeat(getDatas(), new PushException("Biz code must not be repeated"));
        setPushCode(code);
    }

    public List<PushData> getDatas() {
        return datas;
    }

    public void setDatas(List<PushData> datas) {
        this.datas = datas;
    }

    public MatchPushCode getPushCode() {
        return pushCode;
    }

    public void setPushCode(MatchPushCode pushCode) {
        this.pushCode = pushCode;
    }

}
