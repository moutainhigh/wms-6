/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountDaoImpl.java
 * Author:   王蕊
 * Date:     2015年7月20日 下午7:21:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.OrgVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.base.impl.BaseDaoImpl;
import com.dx.wms.bean.CustAccount;
import com.dx.wms.dao.ICustAccountDao;
import com.dx.wms.dto.LenderManagermentDataDto;

/**
 * 客户账户Dao层实现
 *
 * @author 王蕊
 */
@Component
public class CustAccountDaoImpl extends BaseDaoImpl<CustAccount> implements ICustAccountDao {

    /**
     * 权限服务
     */
    @Autowired
    @Qualifier("wmsAmService")
    private IAMService amService;

    @Override
    public List<LenderManagermentDataDto> queryByOrgIdAndToday(Long orgId) {
        Assert.notNull("**queryByOrgIdAndToday() 组织Id不能为空**", orgId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        OrgVo orgVo = amService.queryOrgById(orgId);
        String code = orgVo.getCode();
        paramMap.put("code", code);
        paramMap.put("startTime", DateUtils.formatForBegin(new Date()));
        paramMap.put("endTime", DateUtils.formatForEnd(new Date()));
        LOG.info("**queryByOrgIdAndToday() paramMap={}**", paramMap);
        return dalClient.queryForList("custAccount.queryByOrgIdAndToday", paramMap, LenderManagermentDataDto.class);
    }

    @Override
    public CustAccount queryByLenderCustCode(String lenderCustCode) {
        Assert.notNull("**queryByLenderCustCode() 理财客户编号不能为空**", lenderCustCode);
        LOG.info("**queryByLenderCustCode() lenderCustCode={}**", lenderCustCode);
        return dalClient.queryForObject("custAccount.queryByLenderCustCode",
                MapUtils.getParamMap("lenderCustCode", lenderCustCode), CustAccount.class);
    }
}
