package com.dx.op.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.manager.Router;
import com.dx.common.service.utils.Assert;
import com.dx.op.dto.AccountInfoDto;
import com.dx.op.service.IAccountInfoService;

@Service
public class AccountInfoServiceImpl extends Router<AccountInfoDto> implements IAccountInfoService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(AccountInfoServiceImpl.class);

    @Override
    public AccountInfoDto query(String custCode, String version) {
        Assert.notNull("Cust code must not be null", custCode);
        LOG.info("Cust code[{}]", custCode);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("custCode", custCode);
        param.put("version", version);
        return dalClient.queryForObject("accountInfo.queryByCustCode", param, AccountInfoDto.class);
    }

}
