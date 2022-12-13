package com.dx.cmm.service.pools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.service.ports.Port;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;

@Service
public class CreditorPoolDaoImpl extends BaseDaoImpl<CreditorPool> implements ICreditorPoolDao {

    private static final String QUERY_ARRAY = "creditorPool.queryArray";

    private static final String QUERY = "creditorPool.query";

    @Override
    public CreditorPool query(Long baseId) {
        if (!Assert.checkParam(baseId)) {
            LOG.error("Base id must not be null");
            return new CreditorPool();
        }
        return dalClient.queryForObject(QUERY, MapUtils.getParamMap("baseId", baseId), CreditorPool.class);
    }

    @Override
    public List<CreditorPool> queryArray(Integer port, MatchStatus... status) {
        Assert.notNull("Status or port must not be null", port, status);
        if (!Assert.checkParam(port) || null == status || status.length == 0) {
            LOG.error("Port or status must not be null");
            return new ArrayList<CreditorPool>();
        }
        if (!Assert.equals(port, Port.ONE) && !Assert.equals(port, Port.SIXTEEN) && !Assert.equals(port, Port.ALL)) {
            LOG.error("Port[{}] must in one sixteen all", port);
            return new ArrayList<CreditorPool>();
        }
        Map<String, Object> param = MapUtils.getParamMap("status", MatchStatus.getList(status));
        param.put("port", port);
        return dalClient.queryForList(QUERY_ARRAY, param, CreditorPool.class);
    }

    @Override
    public List<CreditorPool> queryArray(Set<Long> ids) {
        if (!Assert.checkParam(ids)) {
            LOG.error("Ids must not be null");
            return new ArrayList<CreditorPool>();
        }
        return dalClient.queryForList(QUERY_ARRAY, MapUtils.getParamMap("ids", ids), CreditorPool.class);
    }

}
