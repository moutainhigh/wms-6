package com.dx.cmm.service.users;

import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class MatchUserDaoImpl extends BaseDaoImpl<MatchUser> implements IMatchUserDao {

    @Override
    public MatchUser query(String idCard) {
        Assert.notNull("Id card must not be null", idCard);
        return dalClient.queryForObject("matchUser.queryByIdCard", MapUtils.getParamMap("idCard", idCard),
                MatchUser.class);
    }

    @Override
    public MatchUser query(Long id) {
        Assert.notNull("Id must not be null", id);
        return super.queryById(MatchUser.class, id);
    }
}
