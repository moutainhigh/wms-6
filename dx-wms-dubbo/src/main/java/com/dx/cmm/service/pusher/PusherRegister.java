package com.dx.cmm.service.pusher;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.exception.PushException;
import com.dx.cmm.service.dao.IMatchBizBaseDao;
import com.dx.cmm.service.entity.MatchBizBase;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.op.service.dao.IProductDao;

abstract class PusherRegister<A> implements Pusher<ParamPusher> {

    static final Logger LOG = LoggerFactory.getLogger(PusherRegister.class);

    @Autowired
    private PusherObserver<Pusher<ParamPusher>, ParamPusher> pusher;

    @Autowired
    IMatchBizBaseDao matchBizBaseDao;

    @Autowired
    IProductDao productDao;

    @Override
    @PostConstruct
    public void join() {
        pusher.regist(this);
    }

    PushException error(String msg) {
        return new PushException(msg);
    }

    PushException error(String msg, String code) {
        return error(MessageFormat.format("Code[{0}] {1}", code, msg));
    }

    private void insert(MatchBizBase base) throws PushException {
        base.setMatchBizBaseId(matchBizBaseDao.insert(base));
        Assert.notNull(error("insert base error", base.getBizCode()), base.getMatchBizBaseId());
    }

    private void update(MatchBizBase base) throws PushException {
        if (!matchBizBaseDao.update(base)) {
            throw error("update base error", base.getBizCode());
        }
    }

    @Transactional
    void save(MatchBizBase base) throws PushException {
        if (Assert.checkParam(base.getMatchBizBaseId())) {
            update(base);
            return;
        }
        insert(base);
    }

    abstract void validate(PushData data) throws PushException;

    void validate(MatchBizBase base) {
        Assert.notNull(error("not found", base.getBizCode()), base);
        if (base.isExe()) {
            throw error("has requested", base.getBizCode());
        }

    }

    abstract A get(MatchBizBase base);

    abstract String get(A attr);

    void validate(BizBase base) throws PushException {
        Assert.notNull(error("Biz base must not null"), base);
        String code = base.getBizCode();
        Assert.notNull(error("Biz code must not be null"), code);
        Assert.notNull(error("biz id must not be null", code), base.getBizId());
        Assert.notNull(error("contract code must not be null", code), base.getBizContractCode());
        if (!base.getBizContractCode().startsWith("DX")) {
            throw error("contract code is illegal", code);
        }
        Assert.notNull(error("name must not be null", code), base.getCustName());
        Assert.notNull(error("id card must not be null", code), base.getIdCard());
        Assert.notNull(error("address must not be null", code), base.getCustAddress());
        Assert.notNull(error("zip code must not be null", code), base.getZipCode());
        Assert.notNull(error("product id must not be null", code), base.getBizProductId());
        Assert.notNull(error("total amount must not be null", code), base.getBizTotalAmount());
        Assert.notNull(error("begin date must not be null", code), base.getBizDateBegin());
        Assert.notNull(error("end date must not be null", code), base.getBizDateEnd());
        Assert.notNull(error("cust category must not be null", code), base.getCustCategory());
        Assert.notNull(error("org id must not be null", code), base.getOrgId());
        Assert.notNull(error("sign date must not be null", code), base.getSignDate());
        Assert.notNull(error("apply date must not be null", code), base.getApplyDate());
        Assert.notNull(error("action user must not be null", code), base.getActionUser());

    }
}
