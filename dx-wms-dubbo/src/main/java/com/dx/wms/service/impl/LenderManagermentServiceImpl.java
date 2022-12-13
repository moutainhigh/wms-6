package com.dx.wms.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.framework.exception.BaseException;
import com.dx.wms.bean.CustAccount;
import com.dx.wms.bean.LenderApply;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.ICustAccountDao;
import com.dx.wms.dao.ILenderApplyDao;
import com.dx.wms.dao.ILenderManagermentDao;
import com.dx.wms.dto.LenderApplyQueryDto;
import com.dx.wms.dto.LenderApplyResultDto;
import com.dx.wms.dto.LenderManagermentDataDto;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.dto.PushResultDto;
import com.dx.wms.service.ILenderLogService;
import com.dx.wms.service.ILenderManagermentService;
import com.dx.wms.service.exception.LenderLogException;
import com.google.gson.Gson;

public class LenderManagermentServiceImpl implements ILenderManagermentService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderManagermentServiceImpl.class);

    /**
     * 理财管理服务
     */
    @Autowired
    private ILenderManagermentDao lenderManagermentDao;

    @Autowired
    public PaginationDalClient dalClient;

    /**
     * 客户账户Dao层
     */
    @Autowired
    public ICustAccountDao custAccountDao;

    /**
     * 理财申请dao层服务
     */
    @Autowired
    private ILenderApplyDao lenderApplyDao;

    @Autowired
    private ILenderLogService lenderLogService;

    @Override
    public Map<String, PushResultDto> pushContributiveConfirmResult(List<PushDataDto> pushDataDtos) {
        Assert.notNull("推送数据集为空", pushDataDtos);
        LOG.info("**pushContributiveConfirmResult() pushDataDtos ={} ", new Gson().toJson(pushDataDtos));
        return pushData(pushDataDtos);
    }

    /**
     * 
     * 功能描述:空值校验 〈功能详细描述〉
     *
     * @param pushDataDto
     * @param result
     */
    private void checkPushData(PushDataDto pushDataDto) {
        Assert.notNull("业务ID不能为空", pushDataDto.getBizId());
        Assert.notNull("业务编号不能为空", pushDataDto.getBizCode());
        // Assert.notNull("业务处理操作人不能为空", pushDataDto.getCreateUser());
        Assert.notNull("业务数据类型不能为空", pushDataDto.getDataType());
        if (!pushDataDto.getDataType().equals(1) && !pushDataDto.getDataType().equals(2)
                && !pushDataDto.getDataType().equals(3)) {
            throw new BaseException("业务数据类型超出范围");
        }
        if (pushDataDto.getResult() == null
                && (pushDataDto.getDataType().equals(1) || pushDataDto.getDataType().equals(3))) {
            throw new BaseException("业务处理结果不能为空");
        }

        if ((pushDataDto.getDataType().equals(1) || pushDataDto.getDataType().equals(3))
                && !pushDataDto.getResult().equals(1) && !pushDataDto.getResult().equals(2)
                && !pushDataDto.getResult().equals(0)) {
            throw new BaseException("业务处理结果超出范围");
        }
        if (pushDataDto.getDataType().equals(2) || pushDataDto.getDataType().equals(3)) {
            Assert.notNull("到账日期不能为空", pushDataDto.getSettlementDate());
        }
    }

    private void hasInvokeLenderApplyId(Long lenderApplyId) {
        Assert.notNull(" lenderApplyId 理财申请编号不存在", lenderManagermentDao.queryByLenderApplyId(lenderApplyId));
    }

    private Map<String, PushResultDto> pushData(List<PushDataDto> pushDataDtos) {
        Map<String, PushResultDto> resultMap = new HashMap<String, PushResultDto>();
        for (PushDataDto pushDataDto : pushDataDtos) {
            try {
                // 空值校验
                checkPushData(pushDataDto);
                hasInvokeLenderApplyId(pushDataDto.getBizId());
                // 插入交易数据
                save(pushDataDto);
            } catch (BaseException | IllegalAccessException | InvocationTargetException e) {
                resultMap.put(pushDataDto.getBizCode(), new PushResultDto(1, e.getMessage()));
                continue;
            }
            resultMap.put(pushDataDto.getBizCode(), new PushResultDto(0));
        }
        return resultMap;
    }

    @Transactional
    private void save(PushDataDto pushDataDto) throws IllegalAccessException, InvocationTargetException, BaseException {
        LOG.info("** save()  pushDataDto={}", new Gson().toJson(pushDataDto));
        // 1,出资结果 2，到账结果 3,续投
        switch (pushDataDto.getDataType()) {
            case 1:
                saveContributive(pushDataDto);
                break;
            case 2:
                saveSettlement(pushDataDto);
                break;
            case 3:
                saveContinueApply(pushDataDto);
                break;
        }

    }

    private void saveContributive(PushDataDto pushDataDto) {
        switch (pushDataDto.getResult()) {
            case 0:
                // 出资成功 到 等待投资确认
                contributiveSuccess(pushDataDto);
                break;
            case 1:
            case 2:
                // 出资失败 到 等待债权确认
                contributiveFail(pushDataDto);
                break;
        }
    }

    private void contributiveFail(PushDataDto pushDataDto) {
        try {
            lenderLogService.add(WMSConstants.CONTRIBUTIVE_CONFIRM, pushDataDto.getCreateUser(), pushDataDto.getBizId(),
                    pushDataDto.getRemark(), WMSConstants.REFUSE);
        } catch (LenderLogException e) {
            throw new BaseException("日志记录失败，原因: " + e.getMessage());
        }
        if (!lenderManagermentDao.updateLenderApplyFormStatus(pushDataDto.getBizId(), 18L)) {
            throw new BaseException("修改理财申请单状态异常");
        }
        if (!Assert.equals(1,
                lenderManagermentDao.setInvokeLogInfoByCode(pushDataDto.getBizCode(), "D", pushDataDto.getRemark()))) {
            throw new BaseException("调用日志记录状态修改失败");
        }
    }

    private void investmentFail(PushDataDto pushDataDto) {
        try {
            lenderLogService.add(WMSConstants.INVESTMENT_FAIL, pushDataDto.getCreateUser(), pushDataDto.getBizId(),
                    pushDataDto.getRemark(), WMSConstants.REFUSE);
        } catch (LenderLogException e) {
            throw new BaseException("日志记录失败，原因: " + e.getMessage());
        }

        if (!lenderManagermentDao.updateLenderApplyFormStatus(pushDataDto.getBizId(), 20l)) {
            throw new BaseException("修改理财申请单状态异常");
        }
        if (!Assert.equals(1,
                lenderManagermentDao.setInvokeLogInfoByCode(pushDataDto.getBizCode(), "D", pushDataDto.getRemark()))) {
            throw new BaseException("调用日志记录状态修改失败");
        }
    }

    private void contributiveSuccess(PushDataDto pushDataDto) {
        try {
            lenderLogService.add(WMSConstants.CONTRIBUTIVE_CONFIRM, pushDataDto.getCreateUser(), pushDataDto.getBizId(),
                    pushDataDto.getRemark(), WMSConstants.APPROVED);
        } catch (LenderLogException e) {
            throw new BaseException("日志记录失败，原因: " + e.getMessage());
        }
        if (!lenderManagermentDao.updateLenderApplyFormStatus(pushDataDto.getBizId(), 19L)) {
            throw new BaseException("修改理财申请单状态异常");
        }
    }

    private void saveSettlement(PushDataDto pushDataDto) {
        Date settlementDate = pushDataDto.getSettlementDate();
        if (!Assert.checkParam(settlementDate)) {
            throw new BaseException("到账日期为空");
        }
        // 修改到账日时间
        if ((lenderManagermentDao.setSettlementDateById(pushDataDto.getBizId(), pushDataDto.getSettlementDate(),
                pushDataDto.getCreateUser())) != 1) {
            throw new BaseException("修改到账日失败");
        }

        // 修改理财申请日志等待投资确认时间和操作人
        if ((lenderManagermentDao.updateLenderLogUpdateUser(pushDataDto.getBizId(),
                pushDataDto.getCreateUser())) != 1) {
            throw new BaseException("修改等待投资确认日志失败");
        }
    }

    private void saveContinueApply(PushDataDto pushDataDto) {
        switch (pushDataDto.getResult()) {
            case 0:
                // 可正常续投
                saveContributive(pushDataDto);
                getSettlement(pushDataDto);
                saveSettlement(pushDataDto);
                break;
            case 1:
            case 2:
                // 续投资金不够
                investmentFail(pushDataDto);
                break;
        }
    }

    private void getSettlement(PushDataDto pushDataDto) {
        LenderApply apply = lenderApplyDao.queryById(LenderApply.class, pushDataDto.getBizId());
        LenderApply sourApply = lenderApplyDao.queryById(LenderApply.class, apply.getParentId());
        Date date = DateUtils.getNextWorkday(sourApply.getDueDate(), 1);
        pushDataDto.setSettlementDate(date);
    }

    @Override
    public PaginationResult<List<LenderApplyResultDto>> queryLendersInfo(LenderApplyQueryDto query) {
        Assert.notNull("queryLendersInfo() query is null", query);
        LOG.info("queryLendersInfo() lenderApplyQueryDto={}", new Gson().toJson(query));
        return dalClient.queryForList("lenderApply.queryLendersInfo", MapUtils.obj2Map(query),
                LenderApplyResultDto.class, query.getPagination());
    }

    @Override
    public LenderManagermentDataDto queryAccountByLenderCustCode(String lenderCustCode) {
        LenderManagermentDataDto lenderManagermentDataDto = new LenderManagermentDataDto();
        CustAccount custAccount = custAccountDao.queryByLenderCustCode(lenderCustCode);
        BeanUtils.copyProperties(custAccount, lenderManagermentDataDto);
        return lenderManagermentDataDto;
    }

    @Override
    public List<LenderManagermentDataDto> queryByOrgIdAndToday(Long orgId) {
        return custAccountDao.queryByOrgIdAndToday(orgId);
    }

    @Override
    public List<LenderManagermentDataDto> queryLendersByLenderCustCode(String lenderCustCode) {
        List<LenderManagermentDataDto> dtos = new ArrayList<LenderManagermentDataDto>();
        List<LenderApply> lenderApplys = lenderApplyDao.queryByLenderCustCode(lenderCustCode);
        for (LenderApply apply : lenderApplys) {
            LenderManagermentDataDto dto = new LenderManagermentDataDto();
            BeanUtils.copyProperties(apply, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<LenderManagermentDataDto> queryByCustAccountId(Long custAccontId) {
        List<LenderManagermentDataDto> dtos = new ArrayList<LenderManagermentDataDto>();
        List<LenderApply> lenderApplys = lenderApplyDao.queryAccountId(custAccontId);
        for (LenderApply apply : lenderApplys) {
            LenderManagermentDataDto dto = new LenderManagermentDataDto();
            BeanUtils.copyProperties(apply, dto);
            dtos.add(dto);
        }
        return dtos;
    }

}
