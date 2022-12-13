package com.dx.wms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.exception.BaseException;
import com.dx.wms.bean.CustAccount;
import com.dx.wms.bean.CustBase;
import com.dx.wms.bean.InvokeLog;
import com.dx.wms.bean.LenderApply;
import com.dx.wms.bean.LenderApplyLog;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dao.ICustAccountDao;
import com.dx.wms.dao.ICustBaseDao;
import com.dx.wms.dao.ILenderManagermentDao;
import com.dx.wms.utils.BooleanUtil;
import com.google.gson.Gson;

@Component
public class LenderManagermentDaoImpl implements ILenderManagermentDao {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderManagermentDaoImpl.class);

    /**
     * dalClient
     */
    @Autowired
    public PaginationDalClient dalClient;

    @Autowired
    private ICustBaseDao custBaseDao;

    @Autowired
    private ICustAccountDao custAccountDao;

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
    public int updateLenderLogUpdateUser(Long lenderApplyId, Long updateUser) {
        Assert.notNull("**setSettlementDateById() lenderApplyId can not be null**", lenderApplyId);
        LOG.info("**setSettlementDateById() lenderApplyId={},settlementDate={},updateUser={}***", lenderApplyId,
                updateUser);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", lenderApplyId);
        paramMap.put("updateUser", updateUser);
        paramMap.put("updateTime", new Date());
        LOG.info("**setInvokeLogStatesByCode() paramMap={}**", paramMap);
        return dalClient.execute("lenderManagerment.updateLenderLogUpdateUser", paramMap);
    }

    @Override
    public Boolean changeStatesByLengderApplyId(Long lenderApplyId) {
        Assert.notNull("lenderApplyId can not be null**", lenderApplyId);
        LOG.info("lenderApplyId={}", lenderApplyId);
        LenderApply lenderApply = queryLenderApplyById(lenderApplyId);
        Assert.notNull("lenderApply not found**", lenderApply);
        Long custAccountId = lenderApply.getCustAccountId();
        CustAccount custAccount = custAccountDao.queryById(CustAccount.class, custAccountId);
        Assert.notNull("custAccount not found**", custAccount);
        CustBase custBase = custBaseDao.query(custAccount.getCustCode());
        Assert.notNull("custBase not found**", custBase);
        if (!custBase.getDataStatus().equals(custAccount.getDataStatus())) {
            LOG.info("dataStatus error custBase={},custAccount={}", new Gson().toJson(custBase),
                    new Gson().toJson(custAccount));
            throw new BaseException("客户基本信息与客户账户信息数据状态不一致");
        }
        if (custBase.getDataStatus().equals(WMSConstants.ACCOUNT_CHECK_SUCCEED)
                && custAccount.getDataStatus().equals(WMSConstants.ACCOUNT_CHECK_SUCCEED)) {
            return true;
        }
        String status = getStatus(custAccountId);
        return changeStatus(status, custAccountId, custBase.getCustId());
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

    private Boolean changeStatus(String status, Long custAccountId, Long custId) {
        LOG.info("**custBase() status={},custAccountId={},custId={}**", status, custAccountId, custId);
        int flagCustBase = 0, flagCustAccount = 0;
        flagCustBase = changeStatusByCustAccountId(custAccountId, status);
        flagCustAccount = changeStatusByCustId(custId, status);
        if (BooleanUtil.getBoolean(flagCustBase) && BooleanUtil.getBoolean(flagCustAccount)) {
            return true;
        } else {
            LOG.error("**changeStatesByLengderApplyId() 修改客户状态 失败 flagCustBase={},flagCustAccount={}", flagCustBase,
                    flagCustAccount);
            return false;
        }
    }

    private int changeStatusByCustAccountId(Long custAccountId, String dataStatus) {
        Assert.notNull("**changeStatusByCustAccountId() custAccountId can not be null**", custAccountId);
        Assert.notNull("**changeStatusByCustAccountId() dataStatus can not be null**", dataStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("custAccountId", custAccountId);
        paramMap.put("dataStatus", dataStatus);
        LOG.info("**changeStatusByCustAccountId() custAccountId={},dataStatus={}**", custAccountId, dataStatus);
        return dalClient.execute("lenderManagerment.changeStatusByCustAccountId", paramMap);

    }

    private int changeStatusByCustId(Long custId, String dataStatus) {
        Assert.notNull("**changeStatusByCustId() custId can not be null**", custId);
        Assert.notNull("**changeStatusByCustId() dataStatus can not be null**", dataStatus);
        LOG.info("**changeStatusByCustId() custViewQueryDto={},pagination={}**", custId, dataStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("custId", custId);
        paramMap.put("dataStatus", dataStatus);
        LOG.info("**changeStatusByCustId() paramMap={}**", paramMap);
        return dalClient.execute("lenderManagerment.changeStatusByCustId", paramMap);
    }

    public int getAccountStatusByCustAccountId(Long custAccountId) {
        Assert.notNull("**getAccountStatusByCustAccountId() custAccountId can not be null**", custAccountId);
        LOG.info("**getAccountStatusByCustAccountId() custAccountId={}", custAccountId);
        CustAccount custAccount = custAccountDao.queryById(CustAccount.class, custAccountId);
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
        if (flag > 0) {
            return WMSConstants.CHECKING;
        }
        if (resubmitFlag > 0) {
            return WMSConstants.CHECK_FAILED;
        }
        if (failFlag > 0) {
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

    private LenderApply queryLenderApplyById(long lenderApplyId) {
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

    @Override
    public Boolean updateLenderApplyFormStatus(Long lenderApplyId, Long formStatus) {
        Assert.notNull("lenderApplyId can not be null**", lenderApplyId);
        Assert.notNull("formStatus can not be null**", formStatus);
        LOG.info("lenderApplyId={},formStatus={}**", lenderApplyId, formStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderApplyId", lenderApplyId);
        paramMap.put("formStatus", formStatus);
        LOG.info("lenderApplyId={}**,formStatus={}", lenderApplyId, formStatus);
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

    @Override
    public int setInvokeLogInfoByCode(String lenderCode, String dataStatus, String approve) {
        Assert.notNull("**setInvokeLogStatesByCode() lenderCode can not be null**", lenderCode);
        Assert.notNull("**setInvokeLogStatesByCode() dataStatus can not be null**", dataStatus);
        LOG.info("**setInvokeLogStatesByCode() lenderCode={},dataStatus={},approve={}***", lenderCode, dataStatus,
                approve);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderCode", lenderCode);
        paramMap.put("dataStatus", dataStatus);
        if (Assert.checkParam(approve)) {
            paramMap.put("approve", approve);
        }
        LOG.info("**setInvokeLogStatesByCode() paramMap={}**", paramMap);
        return dalClient.execute("lenderManagerment.setInvokeLogStatusByCode", paramMap);
    }

    @Override
    public LenderApply queryByCode(String lenderCode) {
        Assert.notNull("**getLenderApplyByCode() lenderCode can not be null**", lenderCode);
        LOG.info("*getLenderApplyByCode() lenderCode = {}", lenderCode);
        return dalClient.queryForObject("lenderManagerment.getLenderApplyByCode",
                MapUtils.getParamMap("lenderCode", lenderCode), LenderApply.class);
    }

    @Override
    public int updateForState(String lenderCode, Integer statementDate, Date matchDate) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("lenderCode", lenderCode);
        paramMap.put("statementDate", statementDate);
        paramMap.put("matchDate", matchDate);
        paramMap.put("formStatus", 15);
        return dalClient.execute("lenderManagerment.setLenderStatementDate", paramMap);
    }

    @Override
    public void updateDueApplyStatus(Long lenderApplyId, String dueStatus) {
        Assert.notNull(" lenderApplyId can not be null**", lenderApplyId);
        Assert.notNull("dueStatus can not be null**", dueStatus);
        LOG.info("lenderApplyId,dueStatus = {}", lenderApplyId + "," + dueStatus);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", lenderApplyId);
        paramMap.put("dueStatus", dueStatus);
        dalClient.execute("lenderManagerment.updateDueApplyStatus", paramMap);
    }

}
