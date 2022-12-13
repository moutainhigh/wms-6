package com.dx.cmm.service.base;

import java.util.List;

import com.dx.wms.common.IBaseDao;

public interface IMatchBizBaseAccountDao extends IBaseDao<MatchBizBaseAccount> {

    List<MatchBizBaseAccount> query(Long baseId);
}
