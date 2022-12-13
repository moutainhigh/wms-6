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
 * 执委会首页数据查询service实现
 *
 * @author huangjian
 */
@Service
@Transactional
public class ExecutiveCommitteeIndex extends IndexRegister<IndexDisplayDto> {

    @Autowired
    ILenderApplyDao lenderApplyDao;

    @Override
    public boolean isNeedAction(Map<String, Object> param) {
        if (super.isNeedAction(param) && "executiveCommittee".equalsIgnoreCase((String) param.get("indexQuery"))) {
            return true;
        }
        return false;
    }

    @Override
    public IndexDisplayDto execute(Map<String, Object> param) {
        IndexDisplayDto dto = new IndexDisplayDto();
        List<Long> formStatus = new ArrayList<Long>();
        LenderApply lenderApply = new LenderApply();
        // 投资生效数
        dto.setEffectiveApplyNum(getEffectiveApplyNum(formStatus, lenderApply));
        // 投资总额
        dto.setSumLenderAmount(getSumLenderAmount(formStatus, lenderApply));
        // 被拒绝申请单数
        dto.setRefusedApplyNum(getRefusedApplyNum(formStatus, lenderApply));
        // 待投资审核申请单数
        dto.setPendingCheckApplyNum(getPendingCheckApplyNum(formStatus, lenderApply));
        // 人员迁移
        return dto;
    }

    /**
     * 
     * 功能描述: 投资生效数 〈功能详细描述〉
     *
     * @param formStatus
     * @param lenderApply
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Integer getEffectiveApplyNum(List<Long> formStatus, LenderApply lenderApply) {
        formStatus.add(21L);
        formStatus.add(22L);
        List<LenderApply> lenderApplys = getLenderApplys(formStatus, lenderApply);
        Integer effectiveApplyNum = 0;
        if (Assert.checkParam(lenderApplys)) {
            effectiveApplyNum = lenderApplys.size();
        }
        return effectiveApplyNum;
    }

    // 投资总额
    public BigDecimal getSumLenderAmount(List<Long> formStatus, LenderApply lenderApply) {
        formStatus.add(23L);
        List<LenderApply> lenderApplys = getLenderApplys(formStatus, lenderApply);
        BigDecimal lenderAmount = BigDecimal.ZERO;
        if (Assert.checkParam(lenderApplys)) {
            for (LenderApply executivelenderApply : lenderApplys) {
                lenderAmount = lenderAmount.add(executivelenderApply.getLenderAmount());
            }
        }
        return lenderAmount;
    }

    // 待投资审核申请单数
    public Integer getPendingCheckApplyNum(List<Long> formStatus, LenderApply lenderApply) {
        formStatus.clear();
        formStatus.add(12L);
        Integer pendingCheckApplyNum = 0;
        List<LenderApply> lenderApplys = getLenderApplys(formStatus, lenderApply);
        if (Assert.checkParam(lenderApplys)) {
            pendingCheckApplyNum = lenderApplys.size();
        }
        return pendingCheckApplyNum;
    }

    // 被拒绝申请单数
    public Integer getRefusedApplyNum(List<Long> formStatus, LenderApply lenderApply) {
        formStatus.clear();
        formStatus.add(11L);
        formStatus.add(13L);
        List<LenderApply> lenderApplys = getLenderApplys(formStatus, lenderApply);
        Integer refusedApplyNum = 0;
        if (Assert.checkParam(lenderApplys)) {
            refusedApplyNum = lenderApplys.size();
        }
        return refusedApplyNum;
    }

    // 根据条件获取申请表
    public List<LenderApply> getLenderApplys(List<Long> formStatus, LenderApply lenderApply) {
        return lenderApplyDao.queryByStatus(formStatus, lenderApply);
    }

}
