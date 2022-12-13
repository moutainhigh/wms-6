/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyDaoImpl.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午7:00:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.wms.common.BaseDaoImpl;
import com.dx.wms.dto.PushRecordDto;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.exception.SaveException;
import com.dx.wms.service.exception.UpdateException;
import com.google.gson.Gson;

/**
 * 出借申请表 dao层 接口实现
 *
 * @author 朱道灵
 */

@Service
public class LenderApplyDaoImpl extends BaseDaoImpl<LenderApply> implements ILenderApplyDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderApplyDaoImpl.class);

    @Override
    public List<LenderApply> queryByCustAccountId(Long accountId) {
        Assert.notNull("Account id must not be null", accountId);
        LOG.info("Account id[{}]", accountId);
        return dalClient.queryForList("lenderApply.queryByCustAccountId",
                MapUtils.getParamMap("custAccountId", accountId), LenderApply.class);

    }

    @Override
    public List<LenderApply> queryByCustAccount(Long accountId) {
        Assert.notNull("Account id must not be null", accountId);
        LOG.info("Account id[{}]", accountId);
        return dalClient.queryForList("lenderApply.queryByCustAccount",
                MapUtils.getParamMap("custAccountId", accountId), LenderApply.class);

    }

    @Override
    public List<LenderApply> queryByLenderCustCode(String lenderCustCode) {
        Assert.notNull("Lender cust code must not be null", lenderCustCode);
        LOG.info("Lender cust code[{}]", lenderCustCode);
        return dalClient.queryForList("lenderApply.queryByLenderCustCode",
                MapUtils.getParamMap("lenderCustCode", lenderCustCode), LenderApply.class);
    }

    @Override
    public PushRecordDto queryPushRecord(Long applyId) {
        Assert.notNull("Apply id must not be null", applyId);
        LOG.info("Apply id[{}]", applyId);
        return dalClient.queryForObject("lenderApply.getPushRecordById", MapUtils.getParamMap("lenderApplyId", applyId),
                PushRecordDto.class);
    }

    @Override
    public List<LenderApply> queryByProcess(List<String> procInsIds) {
        Assert.notNull("**getLenderApplyByProcInsId() procInsIds can not be null**", procInsIds);
        LOG.info("**updateLenderApplyProcInsId() procInsIds={}**", procInsIds);
        return dalClient.queryForList("lenderApply.getLenderApplyByProcInsId",
                MapUtils.getParamMap("procInsIds", procInsIds), LenderApply.class);
    }

    @Override
    public LenderApply queryByParent(Long parentId) {
        Assert.notNull("Parent id must not be null", parentId);
        LOG.info("Parent id[{}]", parentId);
        return dalClient.queryForObject("lenderApply.getLenderApplyByParentId",
                MapUtils.getParamMap("parentId", parentId), LenderApply.class);
    }

    @Override
    public List<LenderApply> queryByStatus(List<Long> formStatus, LenderApply lenderApply) {
        Assert.notNull("**getLenderApplyByFormStatus() formStatus can not be null**", formStatus);
        LOG.info("**getLenderApplyByFormStatus() formStatus={}**", formStatus);
        LOG.info("**getLenderApplyByFormStatus() createUser={}**", lenderApply);
        Map<String, Object> paraMap = new HashMap<String, Object>();
        if (Assert.checkParam(lenderApply.getCreateUser())) {
            paraMap.put("createUser", lenderApply.getCreateUser());
        }
        if (Assert.checkParam(lenderApply.getOrgId())) {
            paraMap.put("orgId", lenderApply.getOrgId());
        }
        paraMap.put("formStatus", formStatus);
        return dalClient.queryForList("lenderApply.getLenderApplyByFormStatus", paraMap, LenderApply.class);

    }

    @Override
    public List<LenderApply> queryContinue() {
        return dalClient.queryForList("lenderApply.getAllParentIdLenderApply", null, LenderApply.class);
    }

    @Override
    public List<LenderApply> queryByStatus(Long formStatus) {
        Assert.notNull("**getLenderApplyByFormStatus() formStatus can not be null**", formStatus);
        LOG.info("**getLenderApplyByFormStatus() formStatus={}**", formStatus);
        return dalClient.queryForList("lenderApply.getLenderApplyByFormStatus",
                MapUtils.getParamMap("formStatus", formStatus), LenderApply.class);
    }

    @Override
    public List<LenderApply> getLenderByIdAndParentId(Long lenderApplyId, Long parentId) {
        Assert.notNull("**getLenderByIdAndparentId() parentId can not be null**", parentId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", lenderApplyId);
        paramMap.put("parentId", parentId);
        LOG.info("**getLenderByIdAndParentId() lenderApplyId={}**,parentId={}", lenderApplyId, parentId);
        return dalClient.queryForList("lenderApply.getLenderByIdAndParentId", paramMap, LenderApply.class);
    }

    private LenderApply get(Long id) {
        Assert.notNull("Id must not be null", id);
        return queryById(LenderApply.class, id);
    }

    private void updateApply(LenderApply apply) throws UpdateException {
        if (!super.update(apply)) {
            throw new UpdateException("update apply[{0}] error", apply.getLenderApplyId());
        }
    }

    @Override
    public void updateForStatus(Long id, String status) throws UpdateException {
        LenderApply apply = get(id);
        Assert.notNull("Data status must not be null", status);
        apply.setDataStatus(status);
        updateApply(apply);
    }

    @Override
    public void updateForSettle(Long id, Date settleDate) throws UpdateException {
        LenderApply apply = get(id);
        Assert.notNull("Settle date must not be null", settleDate);
        apply.setSettlementDate(settleDate);
        updateApply(apply);
    }

    @Override
    public void updateForCode(Long id, String code) {
        LenderApply apply = get(id);
        Assert.notNull("Lender code must not be null", code);
        apply.setLenderCode(code);
        updateApply(apply);
    }

    @Override
    public void updateForStatus(Long id, Long status) throws UpdateException {
        LenderApply apply = get(id);
        Assert.notNull("Form status must not be null", status);
        apply.setFormStatus(status);
        apply.setUpdateTime(new Date());
        updateApply(apply);
    }

    @Override
    public void updateForProcess(Long id, String procId) throws UpdateException {
        LenderApply apply = get(id);
        Assert.notNull("Process id must not be null", procId);
        apply.setProcInsId(procId);
        updateApply(apply);
    }

    @Override
    public void updateForState(Long id, Integer stateDate, Date matchDate) throws UpdateException {
        LenderApply apply = queryById(LenderApply.class, id);
        Assert.notNull("State or match date must not be null", stateDate, matchDate);
        apply.setStatementDate(stateDate);
        apply.setMatchDate(matchDate);
        updateApply(apply);
    }

    @Override
    public LenderApply save(LenderApply entity) throws SaveException {
        Assert.notNull(new SaveException("Entity must not be null"), entity);
        if (Assert.checkParam(entity.getLenderApplyId())) {
            if (!update(entity)) {
                entity.setUpdateTime();
                throw new SaveException("Apply id[{0}] update error", entity.getLenderApplyId());
            }
            return entity;
        } else {
            Long id = insert(entity);
            Assert.notNull(new SaveException("Account id[{0}] create error", entity.getCustAccountId()), id);
            return entity.setLenderApplyId(id);
        }
    }

    @Override
    public LenderApply getLenderApplyByCode(String lenderCode) {
        Assert.notNull("**queryByLenderCode() lenderCode can not be null**", lenderCode);
        LOG.info("*queryByLenderCode() lenderCode = {}", lenderCode);
        return dalClient.queryForObject("lenderApply.getLenderApplyByCode",
                MapUtils.getParamMap("lenderCode", lenderCode), LenderApply.class);
    }

    @Override
    public void updateDueApplyStatus(Long applyId, String status) {
        Assert.notNull("Apply id or status must not be null", applyId, status);
        LOG.info("Apply id[{}],Apply[{}]", applyId, status);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", applyId);
        paramMap.put("dueStatus", status);
        Assert.notNull("Update trans status error", dalClient.execute("lenderApply.updateDueApplyStatus", paramMap));
    }

    @Override
    public void updateFormStatusByIds(List<Long> ids, Long formStatus) {
        Assert.notNull("**updateFormStatusByIds() ids can not be null**", ids);
        Assert.notNull("**updateFormStatusByIds() formStatus can not be null**", formStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ids", ids);
        paramMap.put("formStatus", formStatus);
        LOG.info("**getLenderByIdAndParentId() ids={}**,formStatus={}", new Gson().toJson(ids), formStatus);
        dalClient.execute("lenderApply.updateFormStatusByIds", paramMap);
    }

    @Override
    public List<LenderApply> queryApplyByIds(List<Long> ids) {
        return dalClient.queryForList("custApply.queryDueListForPage", MapUtils.getParamMap("dueApplyIds", ids),
                LenderApply.class);
    }
}
