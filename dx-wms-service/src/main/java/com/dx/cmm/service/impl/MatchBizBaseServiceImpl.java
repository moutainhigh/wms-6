package com.dx.cmm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.base.IMatchBizBaseDao;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.intf.IMatchBizBaseService;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;

@Service
public class MatchBizBaseServiceImpl implements IMatchBizBaseService {

    @Autowired
    private IMatchBizBaseDao matchBizBaseDao;

    @Override
    public MatchBizBase query(String bizCode) {
        return matchBizBaseDao.query(bizCode);
    }

    @Override
    @Transactional
    public void save(Boolean inner, MatchBizBase... bases) throws SaveException {
        for (MatchBizBase base : bases) {
            if (!matchBizBaseDao.update(base)) {
                throw new SaveException("update base id:{0} error", base.getMatchBizBaseId());
            }

        }
    }

    @Override
    public void save(Long id, BizBaseStatus status) throws SaveException {
        MatchBizBase base = matchBizBaseDao.queryById(MatchBizBase.class, id);
        base.setDataStatus(status.getCode());
        if (!matchBizBaseDao.update(base)) {
            throw new SaveException("update base id:{0} status:{1} error", base.getMatchBizBaseId(), status);
        }
    }

    @Override
    public List<MatchBizBase> query(Integer billDay, BizBaseStatus... status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean exists(String bizCode) {
        return Assert.checkParam(matchBizBaseDao.query(bizCode)) ? true : false;
    }

}
