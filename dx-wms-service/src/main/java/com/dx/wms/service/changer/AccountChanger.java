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
import com.dx.wms.service.apply.LenderApplyDto;
import com.dx.wms.service.base.CustViewDto;
import com.dx.wms.service.base.ICustViewService;
import com.google.gson.Gson;

@Service
public class AccountChanger extends ChangerRegister {

    private static final Logger LOG = LoggerFactory.getLogger(AccountChanger.class);
    
    /**
     * 客户账户服务
     */
    @Autowired
    private ICustAccountService custAccountService;
    /**
     * 潜在客户服务
     */
    @Autowired
    private ICustViewService custViewService;
    
    @Override
    public PaginationResult<List<ResultChanger>> query(ParamChanger param, Pagination page) {
        LOG.info("**query() param:{} **", new Gson().toJson(param));
        if (!Assert.checkParam(param.getAccountStatus()) && !Assert.checkParam(param.getCustName())
                && !Assert.checkParam(param.getIdCard()) && !Assert.checkParam(param.getMobile())
                && !Assert.checkParam(param.getLenderCustCode())) {
            page.setTotalRows(0);
            return new PaginationResult<List<ResultChanger>>(new ArrayList<ResultChanger>(), page);
        }
        return dalClient.queryForList("custAccountApply.queryChangeInfoForPage", MapUtils.obj2Map(param),
                ResultChanger.class, page);
    }

    @Override
    public String init(ParamChanger param) {
        return "custInfoChange/list";
    }

    @Override
    public Boolean supports(ParamChanger param) {
        return Assert.equals(param.getBiz(), ApplyBiz.INFO_CHANGE);
    }

    @Override
    public String changePage(ParamChanger param) {
        return "custInfoChange/changeInfo";
    }

    @Override
    public String view(ParamChanger param) {
        return "custInfoChange/changeRecord";
    }

    @Override
    public PaginationResult<List<ResultChanger>> queryRecord(ParamChanger param, Pagination page) {
        Assert.notNull("**queryRecord() param can be not null **", param);
        LOG.info("**queryRecord() param:{} **", new Gson().toJson(param));
        return dalClient.queryForList("custInfoRecord.queryForPage", MapUtils.obj2Map(param), ResultChanger.class,
                page);
    }

    @Override
    public ItemChanger getDto(ParamChanger param) {
        Assert.notNull("**getDto() param can be not null **", param);
        LOG.info("start getDto() param:{}", new Gson().toJson(param));
        CustAccountApplyDto applyDto = custAccountService.queryCustAccountDtoById(param.getChangeId());
        LOG.info("end getDto()");
        return new ItemChanger(applyDto);
    }

    @Override
    public Map<String, Object> save(ParamChanger param) {
        Assert.notNull("**save() param can be not null**");
        LOG.info("**save() param:{}**", new Gson().toJson(param));
        CustAccountApplyDto applyDto = param.getCustAccountApplyDto();
        CustViewDto custViewDto = getCustViewDto(applyDto);
        Map<String, Object> result = custAccountService.save(custViewDto, applyDto, param.getCreateUser());
        return result;
    }

    private CustViewDto getCustViewDto(CustAccountApplyDto applyDto) {
        Assert.notNull("**getCustViewDto() applyDto can be not null**", applyDto);
        LOG.info("**getCustViewDto() applyDto**", new Gson().toJson(applyDto));
        String custCode = applyDto.getCustAccount().getCustCode();
        CustViewDto custViewDto = custViewService.queryByCustCode(custCode);
        return custViewDto;
    }

}
