/*
 * Copyright (C), 2014-2015, 达信财富投资管理（上海）有限公司
 * FileName: InvestInfoChangeServiceImpl.java
 * Author:   yangbao
 * Date:     2015年12月28日 下午8:38:48
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.changer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.enums.ApplyBiz;
import com.dx.wms.service.account.ICustAccountService;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.apply.ICustLenderApplyService;
import com.dx.wms.service.apply.ILenderApplySaveService;
import com.dx.wms.service.apply.LenderApplyDto;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;
import com.google.gson.Gson;

@Service
public class ApplyChanger extends ChangerRegister {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ApplyChanger.class);

    private static final String MATCH_KEY = "match:view:first:";
    
    private static final String INVEST_KEY = "lenderApplyQuery:";
    
    private static final String EFFECT_KEY = "match:view:first:effect:";
    
    /**
     * 客户账户服务
     */
    @Autowired
    private ICustAccountService custAccountService;
    /**
     * 理财申请单服务
     */
    @Autowired
    private ICustLenderApplyService custLenderApplyService;

    /**
     * 保存投资信息变更保存
     */
    @Autowired
    private ILenderApplySaveService lenderApplySaveService;

    @Autowired
    private ILenderApplyDao applyDao;
    
    /**
     * 缓存服务
     */
    @Autowired
    private ICacheService<LenderApplyDto> cacheService;

    @Override
    public PaginationResult<List<ResultChanger>> query(ParamChanger param, Pagination page) {
        LOG.info("**query param={},page={}**", new Gson().toJson(param), new Gson().toJson(page));
        if (!Assert.checkParam(param.getLenderCode()) && !Assert.checkParam(param.getCustName())
                && !Assert.checkParam(param.getProductId()) && !Assert.checkParam(param.getLenderAmountArea())
                && !Assert.checkParam(param.getOrgId()) && !Assert.checkParam(param.getCurrentStep())
                && !Assert.checkParam(param.getSignDateBegin()) && !Assert.checkParam(param.getSignDateEnd())) {
            page.setTotalRows(0);
            return new PaginationResult<List<ResultChanger>>(new ArrayList<ResultChanger>(), page);
        }
        return dalClient.queryForList("custApply.queryInvestForPage", MapUtils.obj2Map(param), ResultChanger.class,
                page);
    }

    @Override
    public String init(ParamChanger param) {
        return "investInfoChange/list";
    }

    @Override
    public Boolean supports(ParamChanger param) {
        return Assert.equals(param.getBiz(), ApplyBiz.INVEST_CHANGE);
    }

    @Override
    public String changePage(ParamChanger param) {
        if (Assert.checkParam(param) && Assert.checkParam(param.getCustAccountApplyDto())
                && Assert.checkParam(param.getCustAccountApplyDto().getLenderApply())
                && Assert.checkParam(param.getCustAccountApplyDto().getLenderApply().getParentId())) {
            return "investInfoChange/conInvestInfo";
        }
        return "investInfoChange/investInfo";
    }

    @Override
    public String view(ParamChanger param) {
        return "investInfoChange/changeRecord";
    }

    @Override
    public PaginationResult<List<ResultChanger>> queryRecord(ParamChanger param, Pagination page) {
        Assert.notNull("**queryRecord() param can be not null **", param);
        LOG.info("**queryRecord() param:{} **", new Gson().toJson(param));
        return dalClient.queryForList("custInfoRecord.queryInvestForPage", MapUtils.obj2Map(param), ResultChanger.class,
                page);
    }

    @Override
    public ItemChanger getDto(ParamChanger param) {
        Assert.notNull("**getDto() param can be not null **", param);
        LOG.info("**getDto() param:{} **", new Gson().toJson(param));
        LOG.info("**getDto() changeId:{} **", new Gson().toJson(param.getChangeId()));
        CustAccount custAccount = custAccountService.queryByLenderApplyId(param.getChangeId());
        if (Assert.checkParam(custAccount)) {
            CustAccountApplyDto applyDto = custLenderApplyService.getCustAccountApplyDto(custAccount.getCustAccountId(),
                    param.getChangeId());
            return new ItemChanger(applyDto);
        }
        return new ItemChanger();
    }

    @Override
    public Map<String, Object> save(ParamChanger param) {
        Assert.notNull("*Param must be not null", param);
        LOG.info("Param[{}]", new Gson().toJson(param));
        CustAccountApplyDto apply = param.getCustAccountApplyDto();
        Assert.notNull("Apply must not be null", apply);
        LenderApply lenderApply = applyDao.queryById(LenderApply.class, apply.getLenderApply().getLenderApplyId());
        cacheService.del(MATCH_KEY.concat(lenderApply.getLenderCode()));
        cacheService.del(INVEST_KEY.concat(lenderApply.getLenderCode()));
        cacheService.del(EFFECT_KEY.concat(lenderApply.getLenderCode()));
        return lenderApplySaveService.save(lenderApply, apply, param.getCreateUser());
    }

}
