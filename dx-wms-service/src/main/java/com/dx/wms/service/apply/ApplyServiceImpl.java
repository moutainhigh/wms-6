package com.dx.wms.service.apply;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.wms.dto.PushRecordDto;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.exception.UpdateException;
import com.dx.wms.service.process.ParamProcess;
import com.dx.wms.service.process.ResultProcess;

/**
 * 出借申请单Service实现
 *
 * @author 蔡登勇
 */
@Service
public class ApplyServiceImpl implements IApplyService {

    @Autowired
    private ILenderApplyDao applyDao;

    @Autowired
    private PaginationDalClient dalClient;

    @Override
    public List<LenderApply> getLenderApplyByProcInsId(List<String> procInsIds) {
        return applyDao.queryByProcess(procInsIds);
    }

    @Override
    public LenderApply getLenderApplyByParentId(Long parentId) {
        return applyDao.queryByParent(parentId);
    }

    @Override
    public List<LenderApply> getLenderApplyByFormStatus(Long formStatus) {
        return applyDao.queryByStatus(formStatus);
    }

    @Override
    public List<LenderApply> getAllParentIdLenderApply() {
        return applyDao.queryContinue();
    }

    @Override
    public List<LenderApply> getLenderByIdAndParentId(Long lenderApplyId, Long parentId) {
        return applyDao.getLenderByIdAndParentId(lenderApplyId, parentId);
    }

    @Override
    public PushRecordDto getPushRecordById(Long lenderApplyId) {
        return applyDao.queryPushRecord(lenderApplyId);
    }

    @Override
    public List<LenderApply> queryByCustAccountId(Long custAccountId) {
        return applyDao.queryByCustAccountId(custAccountId);
    }

    @Override
    public List<LenderApply> queryByCustAccount(Long custAccountId) {
        return applyDao.queryByCustAccount(custAccountId);
    }

    @Override
    public void updateForStatus(Long lenderApplyId, String dataStatus) {
        applyDao.updateForStatus(lenderApplyId, dataStatus);
    }

    @Override
    public void update(Long lenderApplyId) {
        // 续投申请单
        LenderApply conLenderApply = applyDao.queryById(LenderApply.class, lenderApplyId);
        Long parentId = conLenderApply.getParentId();
        // 原申请单
        LenderApply lenderApply = applyDao.queryById(LenderApply.class, parentId);
        // 原申请单的到期日+1 就是续投申请单的到账日
        Date dueDate = lenderApply.getDueDate();
        Assert.notNull("dueDate is null", dueDate);
        Date settlementDate = DateUtils.getNextWorkday(dueDate, 1);
        applyDao.updateForSettle(lenderApplyId, settlementDate);
    }

    @Override
    public void updateForCode(Long id, String code) throws UpdateException {
        applyDao.updateForCode(id, code);
    }

    @Override
    public void updateStatus(Long lenderApplyId, Long formStatus) {
        applyDao.updateForStatus(lenderApplyId, formStatus);
    }

    @Override
    public void updateForProcess(Long lenderApplyId, String procInsId) {
        applyDao.updateForProcess(lenderApplyId, procInsId);
    }

    @Override
    public List<ResultProcess> get(ParamProcess param) {
        return dalClient.queryForList("custApply.queryForPage", new HashMap<String, Object>(), ResultProcess.class);
    }

    @Override
    public LenderApply queryByLenderCode(String lenderCode) {
        return applyDao.getLenderApplyByCode(lenderCode);
    }

    @Override
    public void destory(Long lenderApplyId, String dueStatus) {
        applyDao.updateDueApplyStatus(lenderApplyId, dueStatus);
    }

    @Override
    public void updateFormStatusByIds(List<Long> ids, Long formStatus) {
        applyDao.updateFormStatusByIds(ids, formStatus);
    }

    @Override
    public List<LenderApply> queryApplyByIds(List<Long> ids) {
        return applyDao.queryApplyByIds(ids);
    }
}
