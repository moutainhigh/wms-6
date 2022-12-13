package com.dx.wms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.LenderManagermentDao;
import com.dx.wms.enums.CurrentStepKey;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.base.CustBase;
import com.dx.wms.service.log.InvokeLog;
import com.dx.wms.service.log.LenderApplyLog;

@Component
public class LenderManagermentDaoImpl implements LenderManagermentDao {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderManagermentDaoImpl.class);

    /**
     * dalClient
     */
    @Autowired
    public PaginationDalClient dalClient;

    @Override
    public Map<String, Object> addLenderApplyProcessLog(String currentStepKey, Long userId, Long lenderApplyId,
            String approveComment, Integer currentAction) {
        Assert.notNull("**addLenderApplyProcessLog() 当前环节不能为空**", currentStepKey);
        Assert.notNull("**addLenderApplyProcessLog() 理财主键不能为空**", lenderApplyId);
        Assert.notNull("**addLenderApplyProcessLog() 当前操作不能为空**", currentAction);
        LOG.info("**addLenderApplyProcessLog() currentStepKey:{},lenderApplyId:{},approveComment:{},currentAction:{}**",
                currentStepKey, lenderApplyId, approveComment, currentAction);
        if (!Assert.equals(currentStepKey, "investmentConfirm") && !Assert.checkParam(userId)) {
            throw new BaseException("**addQualityCheckApplyLog() 登陆用户主键不能为空**");
        }
        Map<String, Object> result = new HashMap<String, Object>();
        if (!Assert.equals(currentAction, 1) && !Assert.checkParam(currentAction, 2)) {
            result.put("code", "106");
            result.put("message", "该单理财申请操作不明确");
            return result;
        }
        LenderApplyLog applyLog = getThisStep(currentStepKey, lenderApplyId);
        Assert.notNull("** addLenderApplyProcessLog() applyLog cannot be null ", applyLog);
        LenderApplyLog log = new LenderApplyLog(userId, lenderApplyId);

        Map<String, Object> map = getNextStep(userId, currentStepKey, currentAction, lenderApplyId);
        Assert.notNull("** addLenderApplyProcessLog() map cannot be null ", map);

        StringBuffer currentStepName = new StringBuffer();
        try {
            if (Assert.checkParam(map)) {
                currentStepName.append(CurrentStepKey.getInfo(currentStepKey));
                updateFileDirRelation(applyLog, userId, 0, currentAction, approveComment);
                addInfoToObject(log, (String) map.get(WMSConstants.NEXT_STEP_NAME),
                        (String) map.get(WMSConstants.NEXT_STEP), (Long) map.get(WMSConstants.TO_USER), currentAction,
                        currentStepKey, (Integer) map.get(WMSConstants.NEXT_STEP_ACTION));
            }
            if (null != applyLog && addCheckApplyLog(applyLog, log)) {
                result.put("code", "101");
                result.put("message", currentStepName.append("成功"));
                result.put("logId", log.getLenderApplyLogId());
            } else {
                result.put("code", "103");
                result.put("message", currentStepName.append("失败"));
            }
        } catch (NumberFormatException e) {
            result.put("code", "102");
            result.put("message", currentStepName.append("失败,出现异常"));
            e.printStackTrace();
        }
        return result;
    }

    private LenderApplyLog getThisStep(String currentStepKey, Long lenderApplyId) {
        LenderApplyLog applyLog = null;
        if (!WMSConstants.INVESTMENT_FAIL.equals(currentStepKey)) {
            // 获取 该条理财申请 currentStepKey 状态的日志
            applyLog = queryByStepKeyAndApplyId(currentStepKey, lenderApplyId);
            LOG.info("** start ** addCheckApplyLog() applyLog:{}", applyLog);
            Assert.notNull("**addLenderApplyProcessLog() 处于" + currentStepKey + "环节的日志未找到", applyLog);
        } else {
            applyLog = dalClient.queryForObject("lenderApplyLog.queryLastLenderApplyLog",
                    MapUtils.getParamMap("lenderApplyId", lenderApplyId), LenderApplyLog.class);
            Assert.notNull("** addLenderApplyProcessLog() 该单理财申请没有最新的日志", applyLog);
        }
        return applyLog;
    }

    private LenderApplyLog queryByStepKeyAndApplyId(String currentStepKey, Long lenderApplyId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", lenderApplyId);
        paramMap.put("currentStepKey", currentStepKey);
        return dalClient.queryForObject("lenderManagerment.queryQualityCheckLenderApplyLogByLenderApplyId", paramMap,
                LenderApplyLog.class);
    }

    /**
     * 将日志数据添加到日志对象中
     *
     * @param applyLog 日志对象
     * @param currentStep 当前环节
     * @param currentStepKey 当前环节标示
     * @param toUser 目标操作人
     * @param lastAction 上一步操作 1--同意 2--拒绝
     * @param lastStepKey 上一环节标示
     * @param currentAction 当前操作 1--同意 2--拒绝
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void addInfoToObject(LenderApplyLog applyLog, String currentStep, String currentStepKey, Long toUser,
            Integer lastAction, String lastStepKey, Integer currentAction) {
        Assert.notNull("** addInfoToObject() 日志对象不能为空", applyLog);
        LOG.info(
                "** updateFileDirRelation() currentStep:{},currentStepKey:{},toUser:{},lastAction:{},lastStepKey:{},currentAction:{}",
                currentStep, currentStepKey, toUser, lastAction, lastStepKey, currentAction);
        applyLog.setCurrentStep(currentStep);
        applyLog.setCurrentStepKey(currentStepKey);
        applyLog.setToUser(toUser);
        applyLog.setLastAction(lastAction);
        applyLog.setLastStepKey(lastStepKey);
        applyLog.setCurrentAction(currentAction);
    }

    private boolean addCheckApplyLog(LenderApplyLog applyLog, LenderApplyLog lenderApplyLog) {
        LOG.info("** start ** addCheckApplyLog() applyLog:{},lenderApplyLog:{}", applyLog, lenderApplyLog);
        try {
            if (Assert.checkParam(applyLog)) {
                dalClient.merge(applyLog);
            }
            if (Assert.checkParam(lenderApplyLog)) {
                dalClient.persist(lenderApplyLog).longValue();
            }
            LOG.info("** end ** addCheckApplyLog() ** true");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.info("** end ** addCheckApplyLog() ** false ** exception:{}", e.getMessage());
            return false;
        }
    }

    private void updateFileDirRelation(LenderApplyLog applyLog, Long userId, Integer isCurrent, Integer currentAction,
            String approveComment) {
        Assert.notNull("** updateFileDirRelation() 日志对象不能为空", applyLog);
        LOG.info("** updateFileDirRelation() userId:{},isCurrent:{},currentAction:{},approveComment:{}", userId,
                isCurrent, currentAction, approveComment);
        if (StringUtils.endsWithIgnoreCase("investmentConfirm", applyLog.getCurrentStepKey())) {
            applyLog.setUpdateTime(applyLog.getUpdateTime());
        } else {
            applyLog.setUpdateUser(userId);
            applyLog.setUpdateTime(new Date());
        }
        applyLog.setToUser(userId);
        applyLog.setIsCurrent(isCurrent);
        applyLog.setCurrentAction(currentAction);
        applyLog.setApproveComment(Assert.checkParam(approveComment) ? approveComment : WMSConstants.EMPTY);

    }

    @Override
    public InvokeLog queryByInvokeLogCode(String invokeLogCode) {
        Assert.notNull("**queryByInvokeLogCode() invokeLogCode can not be null**", invokeLogCode);
        LOG.info("**queryByInvokeLogCode() invokeLogCode={}**", invokeLogCode);
        return dalClient.queryForObject("lenderManagerment.queryByInvokeLogCode",
                MapUtils.getParamMap("invokeLogCode", invokeLogCode), InvokeLog.class);
    }

    @Override
    public InvokeLog queryByLenderApplyId(Long lenderApplyId) {
        Assert.notNull("**queryByLenderApplyId() lenderApplyId can not be null**", lenderApplyId);
        LOG.info("**queryByLenderApplyId() lenderApplyId={}**", lenderApplyId);
        return dalClient.queryForObject("lenderManagerment.queryByLenderApplyId",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), InvokeLog.class);
    }

    @Override
    public int setInvokeLogStatusByCode(String lenderCode, String dataStatus) {
        Assert.notNull("**setInvokeLogStatesByCode() lenderCode can not be null**", lenderCode);
        Assert.notNull("**setInvokeLogStatesByCode() dataStatus can not be null**", dataStatus);
        LOG.info("**setInvokeLogStatesByCode() lenderCode={},dataStatus={}***", lenderCode, dataStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderCode", lenderCode);
        paramMap.put("dataStatus", dataStatus);
        LOG.info("**setInvokeLogStatesByCode() paramMap={}**", paramMap);
        return dalClient.execute("lenderManagerment.setInvokeLogStatusByCode", paramMap);
    }

    @Override
    public int setSettlementDateById(Long lenderApplyId, Date settlementDate, Long updateUser) {
        Assert.notNull("**setSettlementDateById() lenderApplyId can not be null**", lenderApplyId);
        Assert.notNull("**setSettlementDateById() settlementDate can not be null**", settlementDate);
        Assert.notNull("**setSettlementDateById() updateUser can not be null**", updateUser);
        LOG.info("**setSettlementDateById() lenderApplyId={},settlementDate={},updateUser={}***", lenderApplyId,
                settlementDate, updateUser);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", lenderApplyId);
        paramMap.put("settlementDate", settlementDate);
        paramMap.put("updateUser", updateUser);
        LOG.info("**setInvokeLogStatesByCode() paramMap={}**", paramMap);
        return dalClient.execute("lenderManagerment.setSettlementDateById", paramMap);
    }

    @Override
    public int updateLenderLogUpdateUser(Long applyId, Long updateUser) {
        Assert.notNull("**setSettlementDateById() lenderApplyId can not be null**", applyId);
        Assert.notNull("**setSettlementDateById() updateUser can not be null**", updateUser);
        LOG.info("**setSettlementDateById() lenderApplyId={},settlementDate={},updateUser={}***", applyId, updateUser);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", applyId);
        paramMap.put("updateUser", updateUser);
        LOG.info("**setInvokeLogStatesByCode() paramMap={}**", paramMap);
        return dalClient.execute("lenderManagerment.updateLenderLogUpdateUser", paramMap);
    }

    @Override
    public void updateStatus(Long applyId) {
        Assert.notNull("Apply id must not be null", applyId);
        LOG.info("Apply id[{}]", applyId);
        LenderApply apply = queryApplyById(applyId);
        Assert.notNull("Apply must not be null", apply);
        Long accountId = apply.getCustAccountId();
        CustAccount account = queryAccountById(accountId);
        Assert.notNull("Account must not be null", account);
        CustBase base = queryBaseByCode(account.getCustCode());
        Assert.notNull("Base must not null", base);
        if (!Assert.equals(base.getDataStatus(), account.getDataStatus())) {
            LOG.info("Base status[{}] not equals account status[{}]", base.getDataStatus(), account.getDataStatus());
            throw new BaseException("Base status not equals account status");
        }
        if (Assert.equals(base.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)
                && Assert.equals(account.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)) {
        }
        String status = getStatus(accountId);
        updateStatusAccount(accountId, status);
        updateStatusBase(base.getCustId(), status);
    }

    private String getStatus(Long custAccountId) {
        String status = "";
        switch (getAccountStatusByCustAccountId(custAccountId)) {
            case 1:
                status = WMSConstants.ACCOUNT_UNAUTHERIZED;
                break;
            case 2:
                status = WMSConstants.ACCOUNT_CHECKING;
                break;
            case 3:
            case 4:
                status = WMSConstants.ACCOUNT_CHECK_FAIL;
                break;
            case 5:
                status = WMSConstants.ACCOUNT_CHECK_SUCCEED;
                break;
            default:
                status = WMSConstants.ACCOUNT_UNAUTHERIZED;
                break;
        }
        return status;
    }

    private Map<String, Object> param(String status) {
        return MapUtils.getParamMap("dataStatus", status);

    }

    private void updateStatusAccount(Long accountId, String status) {
        Assert.notNull("Account id or status must not be null", accountId, status);
        Map<String, Object> paramMap = param(status);
        paramMap.put("custAccountId", accountId);
        Assert.notNull("Account status error", dalClient.execute("lenderManagerment.updateStatusAccount", paramMap));

    }

    private void updateStatusBase(Long custId, String status) {
        Assert.notNull("CustId or status must not be null", custId, status);
        Map<String, Object> paramMap = param(status);
        paramMap.put("custId", custId);
        Assert.notNull("Base status error", dalClient.execute("lenderManagerment.updateStatusBase", paramMap));
    }

    private CustBase queryBaseByCode(String custCode) {
        Assert.notNull("Cust code must not be null", custCode);
        return dalClient.queryForObject("lenderManagerment.queryByCustCode", MapUtils.getParamMap("custCode", custCode),
                CustBase.class);
    }

    public int getAccountStatusByCustAccountId(Long custAccountId) {
        Assert.notNull("**getAccountStatusByCustAccountId() custAccountId can not be null**", custAccountId);
        LOG.info("**getAccountStatusByCustAccountId() custAccountId={}", custAccountId);
        CustAccount custAccount = queryAccountById(custAccountId);
        Assert.notNull("**getCustAccountById() custAccount not found**", custAccount);
        if (!Assert.checkParam(custAccount.getLenderCustCode())) {
            return WMSConstants.UNAUTHERIZED;
        }
        List<LenderApply> lenderApplys = queryByCustAccountId(custAccountId);
        if (!Assert.checkParam(lenderApplys)) {
            return WMSConstants.UNAUTHERIZED;
        }

        int flag = 0, resubmitFlag = 0, failFlag = 0, authFlag = 0;
        for (LenderApply newLenderApply : lenderApplys) {
            LenderApplyLog lenderApplyLog = getCurrentStepKeyByLenderApplyId(newLenderApply.getLenderApplyId());
            String statusTerms = checkAccountStatusTerms(lenderApplyLog);
            switch (statusTerms) {
                case "C":
                    flag = flag + 1;
                    break;
                case "R":
                    resubmitFlag = resubmitFlag + 1;
                    break;
                case "M":
                    failFlag = failFlag + 1;
                    break;
                case "S":
                    authFlag = authFlag + 1;
                    break;
                default:
                    break;
            }
        }
        if (authFlag > 0) {
            return WMSConstants.CHECK_SUCCEED;
        }
        if (flag > 0 && authFlag == 0) {
            return WMSConstants.CHECKING;
        }
        if (flag == 0 && resubmitFlag > 0) {
            return WMSConstants.CHECK_FAILED;
        }
        if (flag == 0 && failFlag > 0 && resubmitFlag == 0) {
            return WMSConstants.UNAUTHERIZED;
        }
        return WMSConstants.UNAUTHERIZED;
    }

    private String checkAccountStatusTerms(LenderApplyLog lenderApplyLog) {
        String currentStepKey = lenderApplyLog.getCurrentStepKey();
        if (currentStepKey.equals(WMSConstants.RESUBMIT)) {
            return "R";
        }
        if (currentStepKey.equals(WMSConstants.INVESTMENT_SUCCESS)) {
            return "S";
        }
        if ((currentStepKey.equals(WMSConstants.INVESTMENT_FAIL))) {
            return "M";
        }
        if (currentStepKey.equals(WMSConstants.QUALITY_CHECK) || currentStepKey.equals(WMSConstants.INVESTMENT_CHECK)
                || (currentStepKey.equals(WMSConstants.MATCH)) || (currentStepKey.equals(WMSConstants.CREDITOR_CONFIRM))
                || (currentStepKey.equals(WMSConstants.CONTRIBUTIVE_CONFIRM))
                || (currentStepKey.equals(WMSConstants.INVESTMENT_CONFIRM))) {
            return "C";
        }
        return "";
    }

    private CustAccount queryAccountById(long custAccountId) {
        return dalClient.queryForObject("lenderManagerment.queryCustAccountById",
                MapUtils.getParamMap("custAccountId", custAccountId), CustAccount.class);
    }

    private LenderApply queryApplyById(long lenderApplyId) {
        return dalClient.queryForObject("lenderManagerment.queryLenderApplyById",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), LenderApply.class);
    }

    private List<LenderApply> queryByCustAccountId(Long custAccountId) {
        Assert.notNull("**queryByCustAccountId() custAccountId can not be null**", custAccountId);
        LOG.info("**queryByCustAccountId() custAccountId={}**", custAccountId);
        return dalClient.queryForList("lenderManagerment.queryByCustAccountId",
                MapUtils.getParamMap("custAccountId", custAccountId), LenderApply.class);

    }

    private LenderApplyLog getCurrentStepKeyByLenderApplyId(Long lenderApplyId) {
        Assert.notNull("**getCurrentStepKeyByLenderApplyId() lenderApplyId can not be null**", lenderApplyId);
        LOG.info("**getCurrentStepKeyByLenderApplyId() lenderApplyId={}**", lenderApplyId);
        return dalClient.queryForObject("lenderManagerment.getCurrentStepKeyByLenderApplyId",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), LenderApplyLog.class);

    }

    private Map<String, Object> getNextStep(Long userId, String currentStepKey, Integer currentAction,
            Long lenderApplyId) {
        LOG.info("** getCurrentStepAndUser() currentStepKey:{},currentAction:{},lenderApplyId:{}", currentStepKey,
                currentAction, lenderApplyId);
        Assert.notNull("** getCurrentStepAndUser() currentStepKey,currentAction,lenderApplyId", currentStepKey,
                currentAction, lenderApplyId);
        switch (currentStepKey) {
            case WMSConstants.CONTRIBUTIVE_CONFIRM:
                return executeContributiveConfirm(currentAction, lenderApplyId);
            case WMSConstants.INVESTMENT_CONFIRM:
                return executeInvestmentConfirm();
            case WMSConstants.INVESTMENT_FAIL:
                return executeFail(userId);
            default:
                return new HashMap<String, Object>();
        }
    }

    /**
     * 投资失效
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> executeFail(Long userId) {
        return dealInfo(WMSConstants.INVESTMENT_FAIL, userId, 2);
    }

    private Map<String, Object> executeContributiveConfirm(Integer currentAction, Long lenderApplyId) {
        return 1 == currentAction ? dealInfo(WMSConstants.INVESTMENT_CONFIRM, -1L, null)
                : dealInfo(WMSConstants.CREDITOR_CONFIRM, -1L, null);
    }

    private Map<String, Object> dealInfo(String nextStep, Long toUser, Integer nextStepAction) {
        Map<String, Object> result = new HashMap<>();
        result.put(WMSConstants.NEXT_STEP, nextStep);
        result.put(WMSConstants.TO_USER, toUser);
        result.put(WMSConstants.NEXT_STEP_NAME, CurrentStepKey.getInfo((String) result.get(WMSConstants.NEXT_STEP)));
        result.put(WMSConstants.NEXT_STEP_ACTION, nextStepAction);
        return result;
    }

    private Map<String, Object> executeInvestmentConfirm() {
        return dealInfo(WMSConstants.INVESTMENT_SUCCESS, -1L, 1);
    }

    @Override
    public int updateLendersDueDate(String lenderCode, Date dueDate) {
        Assert.notNull("**updateLendersDueDate() lenderCode can not be null**", lenderCode);
        Assert.notNull("**updateLendersDueDate() dueDate can not be null**", dueDate);
        LOG.info("**updateLendersDueDate() lenderCode={},dueDate={}**", lenderCode, dueDate);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderCode", lenderCode);
        paramMap.put("dueDate", dueDate);
        paramMap.put("formStatus", "46");
        LOG.info("**changeStatusByCustId() paramMap={}**", paramMap);
        return dalClient.execute("lenderManagerment.updateLendersDueDate", paramMap);
    }

    @Override
    public Boolean updateLenderApplyFormStatus(Long lenderApplyId, Long formStatus) {
        Assert.notNull("**updateLenderApplyFormStatus() lenderApplyId can not be null**", lenderApplyId);
        Assert.notNull("**updateLenderApplyFormStatus() formStatus can not be null**", formStatus);
        LOG.info("**updateLenderApplyFormStatus() lenderApplyId={},formStatus={}**", lenderApplyId, formStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", lenderApplyId);
        paramMap.put("formStatus", formStatus);
        LOG.info("**updateLenderApplyFormStatus() lenderApplyId={}**,formStatus={}", lenderApplyId, formStatus);
        int i = dalClient.execute("lenderManagerment.updateLenderApplyFormStatus", paramMap);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public LenderApply getLenderApplyById(Long lenderApplyId) {
        Assert.notNull("**getLenderApplyById() lenderApplyId can not be null**", lenderApplyId);
        LOG.info("*getLenderApplyById() lenderApplyId = {}", lenderApplyId);
        return dalClient.queryForObject("lenderManagerment.getLenderApplyById",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), LenderApply.class);
    }

    @Override
    public int updateLenderApplyDataStatus(Long lenderApplyId, String dataStatus) {
        Assert.notNull("**updateLenderApplyDataStatus() lenderApplyId can not be null**", lenderApplyId);
        Assert.notNull("**updateLenderApplyDataStatus() dataStatus can not be null**", dataStatus);
        LOG.info("**updateLenderApplyDataStatus() lenderApplyId={},dataStatus={}**", lenderApplyId, dataStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", lenderApplyId);
        paramMap.put("dataStatus", dataStatus);
        LOG.info("**updateLenderApplyDataStatus() lenderApplyId={}**,formStatus={}", lenderApplyId, dataStatus);
        return dalClient.execute("lenderManagerment.updateLenderApplyDataStatus", paramMap);
    }
}
