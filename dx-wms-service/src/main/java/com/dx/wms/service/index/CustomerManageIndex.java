/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IndexForCustomerManageServiceImpl.java
 * Author:   黄健
 * Date:     2015年7月27日 下午5:00:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 客户经理首页数据查询service实现
 *
 * @author huangjian
 */
@Service
@Transactional
public class CustomerManageIndex extends IndexRegister<IndexDisplayDto> {

    @Autowired
    ILenderApplyDao lenderApplyDao;

    @Autowired
    private IIndexDisplayDao indexDisplayDao;

    @Override
    public boolean isNeedAction(Map<String, Object> param) {
        if (super.isNeedAction(param) && "customerManage".equalsIgnoreCase((String) param.get("indexQuery"))) {
            return true;
        }
        return false;
    }

    @Override
    public IndexDisplayDto execute(Map<String, Object> param) {
        Long createUser = (Long) param.get("createUser");
        IndexDisplayDto dto = new IndexDisplayDto();
        // 客户基数
        dto.setCustNum(indexDisplayDao.queryForCustNumberByCreateUser(createUser));
        // 客户经理
        dto.setCreateUser(createUser);
        LenderApply lenderApply = new LenderApply();
        lenderApply.setCreateUser(createUser);
        List<Long> formStatus = new ArrayList<Long>();
        // 被拒绝申请单数
        dto.setRefusedApplyNum(getRefusedApplyNum(formStatus, lenderApply));
        // 开户基数
        dto.setCustAccountNum(indexDisplayDao.queryCustAccountNumByCreateUser(createUser));
        // 客户到期提醒

        // 投资总额
        dto.setSumLenderAmount(getSumLenderAmount(formStatus, lenderApply));
        // 客户生日提醒

        return dto;
    }

    // 投资总额
    public BigDecimal getSumLenderAmount(List<Long> formStatus, LenderApply lenderApply) {
        formStatus.clear();
        formStatus.add(21L);
        formStatus.add(22L);
        formStatus.add(23L);
        BigDecimal lenderAmount = BigDecimal.ZERO;
        List<LenderApply> lenderApplys = getLenderApplys(formStatus, lenderApply);
        if (Assert.checkParam(lenderApplys)) {
            for (LenderApply custServicelenderApply : lenderApplys) {
                lenderAmount = lenderAmount.add(custServicelenderApply.getLenderAmount());
            }
        }
        return lenderAmount;
    }

    // 拒绝申请单数
    public Integer getRefusedApplyNum(List<Long> formStatus, LenderApply lenderApply) {
        formStatus.add(11L);
        formStatus.add(13L);
        List<LenderApply> lenderApplys = getLenderApplys(formStatus, lenderApply);
        Integer refusedApplyNum = 0;
        if (Assert.checkParam(lenderApplys)) {
            refusedApplyNum = lenderApplys.size();
        }
        return refusedApplyNum;
    }

    // 根据条件获取申请单数
    public List<LenderApply> getLenderApplys(List<Long> formStatus, LenderApply lenderApply) {
        return lenderApplyDao.queryByStatus(formStatus, lenderApply);
    }

}
