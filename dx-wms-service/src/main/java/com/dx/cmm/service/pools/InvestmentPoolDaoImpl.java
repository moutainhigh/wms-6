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
public class InvestmentPoolDaoImpl extends BaseDaoImpl<InvestmentPool> implements IInvestmentPoolDao {

    private static final String QUERY_ARRAY = "investmentPool.queryArray";

    private static final String QUERY = "investmentPool.query";

    @Override
    public InvestmentPool query(Long baseId) {
        if (!Assert.checkParam(baseId)) {
            LOG.error("Base id must not be null");
            return new InvestmentPool();
        }
        return dalClient.queryForObject(QUERY, MapUtils.getParamMap("baseId", baseId), InvestmentPool.class);
    }

    @Override
    public List<InvestmentPool> queryArray(Integer port, MatchStatus... status) {
        return queryArray(port, null, status);
    }

    @Override
    public List<InvestmentPool> queryArray(Set<Long> ids) {
        if (!Assert.checkParam(ids)) {
            LOG.error("Ids must not be null");
            return new ArrayList<InvestmentPool>();
        }
        return dalClient.queryForList(QUERY_ARRAY, MapUtils.getParamMap("ids", ids), InvestmentPool.class);
    }

	@Override
	public List<InvestmentPool> queryArray(Integer port, Long productId,
			MatchStatus... status) {
		Assert.notNull("Status or port must not be null", port, status);
        if (!Assert.checkParam(port) || null == status || status.length == 0) {
            LOG.error("Port or status must not be null");
            return new ArrayList<InvestmentPool>();
        }
        if (!Assert.equals(port, Port.ONE) && !Assert.equals(port, Port.SIXTEEN) && !Assert.equals(port, Port.ALL)) {
            LOG.error("Port[{}] must in one sixteen all", port);
            return new ArrayList<InvestmentPool>();
        }
        Map<String, Object> param = MapUtils.getParamMap("status", MatchStatus.getList(status));
        param.put("port", port);
        param.put("productId", productId);
        return dalClient.queryForList(QUERY_ARRAY, param, InvestmentPool.class);
	}

}
