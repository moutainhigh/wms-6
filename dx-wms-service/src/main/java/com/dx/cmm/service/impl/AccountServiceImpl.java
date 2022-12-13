package com.dx.cmm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.dto.AccountDetailDto;
import com.dx.cmm.dto.AccountParamDto;
import com.dx.cmm.dto.AccountResultDto;
import com.dx.cmm.service.IAccountService;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.google.gson.Gson;

@Service
public class AccountServiceImpl implements IAccountService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private PaginationDalClient dalClient;

    @Override
    public PaginationResult<List<AccountResultDto>> query(AccountParamDto param, Pagination page) {
        LOG.info("query() param:{}", new Gson().toJson(param));
        return dalClient.queryForList("account.queryParamPage", MapUtils.obj2Map(param), AccountResultDto.class, page);
    }

    @Override
    public List<AccountDetailDto> query(Long custUserId) {
        LOG.info("query() custUserId:{}", custUserId);
        return dalClient.queryForList("account.queryCustUserId", MapUtils.getParamMap("custUserId", custUserId),
                AccountDetailDto.class);
    }

}
