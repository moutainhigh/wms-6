package com.dx.cmm.service.pools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.KGitextpdf.text.pdf.PdfStructTreeController.returnType;
import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.base.MatchBizBase;
import com.dx.cmm.service.invest.InvestAbs;
import com.dx.common.service.utils.Assert;

@Service("investPool")
public class InvestPool extends InvestAbs<InvestmentPool> implements Pools<InvestmentPool> {

    @Override
    public Boolean exists(MatchBizBase base) {
        return Assert.checkParam(query(base));
    }

    @Override
    public InvestmentPool query(MatchBizBase base) {
        return investmentPoolDao.query(base.getMatchBizBaseId());
    }

    @Override
    public void save(InvestmentPool pool) throws SaveException {
        Assert.notNull(new SaveException("Pool must not be null"), pool);
        if (Assert.checkParam(pool.getInvestmentPoolId())) {
            if (!investmentPoolDao.update(pool)) {
                LOG.error("Pool id[{}] update error", pool.getInvestmentPoolId());
                throw new SaveException("Pool id[{0}] update error", pool.getInvestmentPoolId());
            }
            return;
        }
        Assert.notNull(new SaveException("Pool insert error"), investmentPoolDao.insert(pool));
    }

    @Override
    public InvestmentPool query(Long id) {
        return investmentPoolDao.queryById(InvestmentPool.class, id);
    }

    @Override
    public List<InvestmentPool> queryArray(Integer port, MatchStatus... status) {
        return investmentPoolDao.queryArray(port, status);
    }

    @Override
    public List<InvestmentPool> queryAll() {
        return investmentPoolDao.queryAll(InvestmentPool.class);
    }

    @Override
    public List<InvestmentPool> queryArray(Set<Long> ids) {
        return investmentPoolDao.queryArray(ids);
    }

    @Override
    public Map<Long, InvestmentPool> group(List<InvestmentPool> pools) {
        Map<Long, InvestmentPool> group = new HashMap<Long, InvestmentPool>();
        if (Assert.checkParam(pools)) {
            for (InvestmentPool pool : pools) {
                group.put(pool.getInvestmentPoolId(), pool);
            }
        }
        return group;
    }

	@Override
	public List<InvestmentPool> queryArray(Integer port, Long productId,
			MatchStatus... status) {
		return investmentPoolDao.queryArray(port, productId, status);
	}

}
