package com.dx.wms.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.service.apply.LenderApply;
import com.dx.wms.service.apply.LenderApplyBase;
import com.dx.wms.service.apply.LenderApplyDto;

public class LenderApplyServiceImpl implements ILenderApplyService {

    protected static final Logger LOG = LoggerFactory.getLogger(LenderApplyServiceImpl.class);

    @Autowired
    protected PaginationDalClient dalClient;

    /**
     * 缓存服务
     */
    @Autowired
    private ICacheService<LenderApplyDto> cacheService;
    
    /**
     * 缓存服务
     */
    @Autowired
    private ICacheService<LenderApplyBase> applyCacheService;

    private static final String KEY = "lenderApplyQuery:";

    @Override
    public LenderApplyDto query(String lenderCode) {
        if (!Assert.checkParam(lenderCode)) {
            LOG.error("lenderCode must not be null");
            return new LenderApplyDto();
        }
        String key = KEY.concat(lenderCode);
        LenderApplyDto apply = cacheService.getObject(key, LenderApplyDto.class);
        if (Assert.checkParam(apply)) {
            return apply;
        }
        apply = dalClient.queryForObject("lenderApply.query", MapUtils.getParamMap("lenderCode", lenderCode),
                LenderApplyDto.class);
        cacheService.set(key, apply);
        return apply;
    }

    @Override
    public void syncProduct(String lenderCode, Long productId) {
        Assert.notNull("Lender code or product id must not be null", lenderCode, productId);
        Map<String, Object> param = MapUtils.getParamMap("lenderCode", lenderCode);
        param.put("productId", productId);
        Assert.notNull("Sync product error", dalClient.execute("lenderApply.syncProduct", param));
    }

   
    @Override
    public LenderApplyBase queryBackBank(Long lenderApplyId) {
        if (!Assert.checkParam(lenderApplyId)) {
            LOG.error("parentId must not be null");
            return new LenderApplyBase();
        }
        String key = KEY.concat(String.valueOf(lenderApplyId));
        LenderApplyBase apply = applyCacheService.getObject(key, LenderApplyBase.class);
        if (Assert.checkParam(apply)) {
            return apply;
        }
        apply = dalClient.queryForObject("lenderApply.queryBackBank", MapUtils.getParamMap("lenderApplyId", lenderApplyId),
                LenderApplyBase.class);
        applyCacheService.set(key, apply);
        return apply;
    }

	@Override
	public LenderApply queryContinue(String lenderCode) {
        Assert.notNull("Lender code  must not be null", lenderCode);
		return dalClient.queryForObject("lenderApply.queryContinue", MapUtils.getParamMap("lenderCode", lenderCode), LenderApply.class);
	}
}
