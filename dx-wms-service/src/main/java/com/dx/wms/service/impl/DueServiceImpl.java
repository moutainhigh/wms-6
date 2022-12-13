/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: DueServiceImpl.java
 * Author:   chenjie
 * Date:     2016年4月15日 下午1:30:15
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.rule.api.dto.BaseDetailDto;
import com.dx.rule.api.dto.RuleSerachParamDto;
import com.dx.rule.service.IRuleInfoService;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.IDueDao;
import com.dx.wms.service.IDueService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author chenjie
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class DueServiceImpl implements IDueService {

    @Autowired
    private IDueDao dao;

    @Autowired(required = false)
    private IRuleInfoService<BaseDetailDto> ruleInfoService;

    @Override
    public List<String> queryDueCustName(List<Long> dueApplyIds, Long userId) {
        List<String> custNames = null;
        if (Assert.checkParam(dueApplyIds)) {
            custNames = dao.queryDueList(dueApplyIds, userId);
        }
        custNames.add("");
        return custNames;
    }

    @Override
    public List<Long> getDueIds(String ruleKey) {
        RuleSerachParamDto dto = new RuleSerachParamDto();
        dto.setAppKey(WMSConstants.WMS);
        dto.setRuleKey(ruleKey);
        BaseDetailDto dtos = ruleInfoService.getRuleInfo(dto, BaseDetailDto.class);
        List<Long> ids = new ArrayList<Long>();
        if (Assert.checkParam(dtos.getIds())) {
            return dtos.getIds();
        }
        return ids;
    }

}
