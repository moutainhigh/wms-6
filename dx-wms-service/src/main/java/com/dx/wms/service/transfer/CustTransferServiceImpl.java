/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustTransferServiceImpl.java
 * Author:   黄健
 * Date:     2015年10月15日 下午4:34:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.transfer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.account.dao.ICustAccountDao;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.apply.IApplyService;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.base.CustBase;
import com.dx.wms.service.base.ICustBaseDao;
import com.dx.wms.service.log.CustTransferLog;
import com.dx.wms.service.log.ICustTransferLogDao;
import com.dx.wms.service.log.ILenderApplyLogDao;
import com.dx.wms.service.log.LenderApplyLog;
import com.google.gson.Gson;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class CustTransferServiceImpl implements ICustTransferService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustTransferServiceImpl.class);

    /**
     * 带分页的客户端
     */
    @Autowired
    public PaginationDalClient dalClient;

    /**
     * 客户基本信息dao接口
     */
    @Autowired
    private ICustBaseDao custBaseDao;
    /**
     * 公共服务
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 理财申请服务
     */
    @Autowired
    private IApplyService lenderApplyService;

    /**
     * 调用日志服务
     */
    @Autowired
    private ICustTransferLogDao custTransferLogDao;

    /**
     * 出借申请日志服务
     */
    @Autowired
    private ILenderApplyLogDao lenderApplyLogDao;

    @Autowired
    private ICustAccountDao accountDao;

    @Autowired
    private ILenderApplyDao applyDao;

    @Override
    public PaginationResult<List<ResultTransfer>> queryForPage(ParamTransfer param) {
        return dalClient.queryForList("custBase.queryForCustTransfer", MapUtils.obj2Map(param), ResultTransfer.class,
                param.getPagination());
    }

    @Override
    @Transactional
    public Boolean transferCustsToCustManager(ParamTransfer queryDto, Long userId) {
        Assert.notNull("custTransferQueryDto/userId cannot be null", queryDto, userId);
        LOG.info("** transferCustsToCustManager() ** queryDto={},userId={}", new Gson().toJson(queryDto), userId);
        List<ResultTransfer> list = queryCustBase(queryDto.getCustIds());
        for (ResultTransfer dto : list) {
            if (dto.getCustManagerId().compareTo(queryDto.getCustManagerId()) == 0) {
                LOG.info("target custmanager is not difference");
                throw new BaseException("修改理财单信息失败");
            }
            custTransfer(queryDto, dto, userId);
        }
        return Boolean.TRUE;
    }

    // 转移客户基本信息和客户账户信息
    private void custTransfer(ParamTransfer queryDto, ResultTransfer dto, Long userId) {
        queryDto.setCustId(dto.getCustId());
        // t_cust_base
        if (!updateBaseCust(queryDto, userId)) {
            LOG.info("update custbase info error");
            throw new BaseException("修改潜客信息失败");
        }
        if (Assert.checkParam(dto.getCustAccountId())) {
            // t_cust_account
            queryDto.setCustAccountId(dto.getCustAccountId());
            if (!updateCustAccount(queryDto, userId)) {
                LOG.info("update custAccount info error");
                throw new BaseException("修改开户用户信息失败");
            }
            changeLenderApply(queryDto, dto, userId);
        }
    }

    // 修改出借申请信息和修改理财日志信息
    private void changeLenderApply(ParamTransfer queryDto, ResultTransfer dto, Long userId) {
        List<LenderApply> lenders = lenderApplyService.queryByCustAccount(dto.getCustAccountId());
        for (LenderApply la : lenders) {
            // t_lender_apply
            if (!updateLenderApply(queryDto, la, userId)) {
                LOG.info("update lenderApply info error");
                throw new BaseException("修改理财单信息失败");
            }
            if (Assert.checkParam(la.getLenderCode())) {
                // t_lender_apply_log
                if (!updateLenderApplyLog(queryDto, la)) {
                    LOG.info("update lenderApplyLog info error");
                    throw new BaseException("修改理财单日志信息失败");
                }
            }
        }
    }

    /**
     * 转移潜客信息
     *
     * @param custTransferResultDto
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Boolean updateBaseCust(ParamTransfer custTransferQueryDto, Long userId) {
        Assert.notNull("custTransferQueryDto cannot be null", custTransferQueryDto);
        LOG.info("** updateBaseCust() **custTransferQueryDto={}", new Gson().toJson(custTransferQueryDto));
        CustTransferLog custTransferLog = saveCustTransferLog(custTransferQueryDto, userId, 1);
        if (!Assert.checkParam(custTransferLog)) {
            return Boolean.FALSE;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("custId", custTransferQueryDto.getCustId());
        paramMap.put("createUser", custTransferQueryDto.getCustManagerId());
        paramMap.put("orgId", custTransferQueryDto.getOrgId());
        paramMap.put("teamId", custTransferQueryDto.getTeamId());
        Integer updateNum = dalClient.execute("custBase.updateCreateUser", paramMap);
        return Assert.checkParam(updateNum) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 转移已开户用户信息
     *
     * @param custTransferResultDto
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Boolean updateCustAccount(ParamTransfer param, Long userId) {
        Assert.notNull("Param must not be null", param);
        LOG.info("Param[{}]", new Gson().toJson(param));
        CustTransferLog custTransferLog = saveCustTransferLog(param, userId, 2);
        if (!Assert.checkParam(custTransferLog)) {
            return Boolean.FALSE;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("custAccountId", param.getCustAccountId());
        paramMap.put("createUser", param.getCustManagerId());
        paramMap.put("orgId", param.getOrgId());
        paramMap.put("teamId", param.getTeamId());
        Integer updateNum = dalClient.execute("custAccount.updateCreateUserAndOrg", paramMap);
        return Assert.checkParam(updateNum) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 转移开户用户的理财申请信息
     *
     * @param custTransferResultDto
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Boolean updateLenderApply(ParamTransfer custTransferQueryDto, LenderApply lenderApply, Long userId) {
        Assert.notNull("custTransferResultDto/lenderApply cannot be null", lenderApply, custTransferQueryDto);
        LOG.info("** updateLenderApply() **custTransferQueryDto={},lenderApply={}",
                new Gson().toJson(custTransferQueryDto), new Gson().toJson(lenderApply));
        Long lenderApplyId = lenderApply.getLenderApplyId();
        custTransferQueryDto.setLenderApplyId(lenderApplyId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("createUser", custTransferQueryDto.getCustManagerId());
        paramMap.put("lenderApplyId", lenderApplyId);
        Integer updateNum = null;
        if (Assert.checkParam(lenderApply.getLenderCode())) {
            // 该理财申请已提交销售客服
            LenderApplyLog log = getLenderApplyLog(lenderApplyId);
            Assert.notNull("lenderAppplyLog cannot be found", log);
            // 如果当前行为是投资生效或失效，则根据更新者更新出借申请表
            if (WMSConstants.INVESTMENT_SUCCESS.equalsIgnoreCase(log.getCurrentStepKey())
                    || WMSConstants.INVESTMENT_FAIL.equalsIgnoreCase(log.getCurrentStepKey())) {
                CustTransferLog custTransferLog = getCustTransferLog(custTransferQueryDto, userId, 3);
                if (!Assert.checkParam(custTransferLog)) {
                    return Boolean.FALSE;
                }
                paramMap.put("updateUser", userId);
                updateNum = dalClient.execute("lenderApply.updateCreateUser", paramMap);
            } else {
                // 如果当前行为不是投资生效或失效，则根据营业部id，团队id，更新者更新出借申请表
                return updateCustTransferLog(custTransferQueryDto, userId, paramMap, updateNum);
            }
        } else {
            // 如果出借编号为空，则根据营业部id，团队id，更新者更新出借申请表
            return updateCustTransferLog(custTransferQueryDto, userId, paramMap, updateNum);
        }
        return Assert.checkParam(updateNum) ? Boolean.TRUE : Boolean.FALSE;
    }

    // 查询最新日志表
    private LenderApplyLog getLenderApplyLog(Long lenderApplyId) {
        return lenderApplyLogDao.queryByParam(lenderApplyId);
    }

    // 获取转移日志
    private CustTransferLog getCustTransferLog(ParamTransfer custTransferQueryDto, Long userId, Integer type) {
        return saveCustTransferLog(custTransferQueryDto, userId, type);
    }

    // 将组织id，团队id和更新者id存入集合
    private Map<String, Object> getMap(ParamTransfer custTransferQueryDto, Long userId,Map<String, Object> paramMap) {
        paramMap.put("orgId", custTransferQueryDto.getOrgId());
        paramMap.put("teamId", custTransferQueryDto.getTeamId());
        paramMap.put("updateUser", userId);
        return paramMap;
    }

    // 出借申请表是否更新成功
    private Boolean updateCustTransferLog(ParamTransfer custTransferQueryDto, Long userId, Map<String, Object> paramMap,
            Integer updateNum) {
        CustTransferLog custTransferLog = getCustTransferLog(custTransferQueryDto, userId, 4);
        if (!Assert.checkParam(custTransferLog)) {
            return Boolean.FALSE;
        }
        // 该理财申请尚处于编辑状态，尚未提交销售客服
        updateNum = dalClient.execute("lenderApply.updateCreateUserAndOrg", getMap(custTransferQueryDto, userId,paramMap));
        return Assert.checkParam(updateNum) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 转移理财审核日志
     *
     * @param custTransferResultDto
     * @param userId
     * @param lenderApply
     * @param paramMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Boolean updateLenderApplyLog(ParamTransfer custTransferQueryDto, LenderApply lenderApply) {
        Assert.notNull("lenderApply/custTransferQueryDto cannot be null", lenderApply, custTransferQueryDto);
        LOG.info("** updateLenderApplyLog() **custTransferQueryDto={},lenderApply={}",
                new Gson().toJson(custTransferQueryDto), new Gson().toJson(lenderApply));
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("createUser", custTransferQueryDto.getCustManagerId());
        paramMap.put("lenderApplyId", lenderApply.getLenderApplyId());
        Integer updateNum = dalClient.execute("lenderApplyLog.updateCreateUser", paramMap);
        return Assert.checkParam(updateNum) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public List<ResultTransfer> queryCustBase(String custIds) {
        Assert.notNull("Cust ids must be not null", custIds);
        LOG.info("Cust ids[{}]", new Gson().toJson(custIds));
        return dalClient.queryForList("custBase.queryForCustTransfer",
                MapUtils.getParamMap("custIds", Arrays.asList(custIds.split(","))), ResultTransfer.class);
    }

    @Override
    public List<UserVo> queryCustManagers(String custIds, Long orgId) {
        Assert.notNull("**queryCustManagers() orgId cannot be null**", orgId);
        List<ResultTransfer> result = queryCustBase(custIds);
        Assert.notNull("list cannot be null", result);
        LOG.info("**queryCustManagers() orgId={} ,list={}**", orgId, new Gson().toJson(result));
        Set<Long> custManagerIds = new HashSet<Long>();
        for (ResultTransfer dto : result) {
            custManagerIds.add(dto.getCustManagerId());
        }
        List<UserVo> vos = commonService.queryUserByOrgAndRole(orgId, RoleConstant.KHJL);
        List<UserVo> ret = new ArrayList<UserVo>();
        for (UserVo vo : vos) {
            if (!custManagerIds.contains(vo.getUserId())) {
                ret.add(vo);
            }
        }
        return ret;
    }

    @Override
    public CustTransferLog saveCustTransferLog(ParamTransfer custTransferQueryDto, Long userId, Integer type) {
        Assert.notNull("**saveCustTransferLog() custTransferQueryDto can not be null**", custTransferQueryDto);
        Assert.notNull("**saveCustTransferLog() userId can not be null**", userId);
        Assert.notNull("**saveCustTransferLog() type can not be null**", type);
        LOG.info("**saveCustTransferLog()  custTransferQueryDto={},userId={},type={}",
                new Gson().toJson(custTransferQueryDto), userId, type);
        CustTransferLog custTransferLog = new CustTransferLog();

        switch (type) {
            case 1:
                // type =1 修改潜客 t_cust_base
                return getCustBaseTransfer(custTransferQueryDto, userId);
            case 2:
                // type =2 开户信息表 t_cust_account
                return getCustAccountTransfer(custTransferQueryDto, userId);
            case 3:
            case 4:
                // type =3 理财信息表 t_lenderApply 已经结束的单子（投资生效，投资失效）
                return getLenderApplyTransfer(custTransferQueryDto, userId, type);
        }
        return custTransferLog;

    }

    private CustTransferLog getCustBaseTransfer(ParamTransfer custTransferQueryDto, Long userId) {
        CustTransferLog custTransferLog = new CustTransferLog();
        Long custId = custTransferQueryDto.getCustId();
        Assert.notNull("**getCustBaseTransfer() custId can not be null**", custId);
        CustBase custBase = custBaseDao.queryById(CustBase.class, custId);
        Assert.notNull("**getCustBaseTransfer() custBase can not be null**", custBase);
        LOG.info("**getCustBaseTransfer()  custId={},custBase={}", custId, new Gson().toJson(custBase));
        Long fromCreateUser = custBase.getCreateUser();
        Long toCreateUser = custTransferQueryDto.getCustManagerId();
        custTransferLog.setTableName("t_cust_base");
        custTransferLog.setPkId(custId);
        custTransferLog.setPkCode(custBase.getCustCode());
        custTransferLog.setFromUser(fromCreateUser);
        custTransferLog.setToUser(toCreateUser);
        custTransferLog.setCreateUser(userId);
        custTransferLog.setUpdateUser(userId);
        custTransferLog.setDataStatus(WMSConstants.DATE_STATUS_A);
        custTransferLog.setCustTransferLogId(custTransferLogDao.insert(custTransferLog));
        LOG.info("**getCustBaseTransfer()  custTransferLog={}", new Gson().toJson(custTransferLog));
        return custTransferLog;
    }

    private CustTransferLog getCustAccountTransfer(ParamTransfer custTransferQueryDto, Long userId) {
        CustTransferLog custTransferLog = new CustTransferLog();
        Long custAccountId = custTransferQueryDto.getCustAccountId();
        // 转移前开户信息
        CustAccount custAccount = accountDao.queryById(CustAccount.class, custAccountId);
        String lenderCustCode = custAccount.getLenderCustCode();
        Long fromCreateUser = custAccount.getCreateUser();
        Long fromTeamId = custAccount.getTeamId();
        Long fromOrgId = custAccount.getOrgId();
        Assert.notNull("**getCustAccountTransfer() fromCreateUser can not be null**", fromCreateUser);
        Assert.notNull("**getCustAccountTransfer() fromTeamId can not be null**", fromTeamId);
        Assert.notNull("**getCustAccountTransfer() fromOrgId can not be null**", fromOrgId);
        LOG.info("**getCustAccountTransfer()  custAccount={}", new Gson().toJson(custAccount));
        // 转移到的信息
        Long toCreateUser = custTransferQueryDto.getCustManagerId();
        Long toTeamId = custTransferQueryDto.getTeamId();
        Long toOrgId = custTransferQueryDto.getOrgId();
        Assert.notNull("**getCustAccountTransfer() toCreateUser can not be null**", toCreateUser);
        Assert.notNull("**getCustAccountTransfer() toTeamId can not be null**", toTeamId);
        Assert.notNull("**getCustAccountTransfer() toOrgId can not be null**", toOrgId);
        LOG.info("**getCustAccountTransfer()  toCreateUser={},userId={},toTeamId={},toOrgId={}", toCreateUser, userId,
                toTeamId, toOrgId);

        custTransferLog.setTableName("t_cust_account");
        custTransferLog.setPkId(custAccountId);
        if (Assert.checkParam(lenderCustCode)) {
            custTransferLog.setPkCode(lenderCustCode);
        }
        custTransferLog.setFromUser(fromCreateUser);
        custTransferLog.setFromTeamId(fromTeamId);
        custTransferLog.setFromOrgId(fromOrgId);

        custTransferLog.setToUser(toCreateUser);
        custTransferLog.setToTeamId(toTeamId);
        custTransferLog.setToOrgId(toOrgId);
        custTransferLog.setCreateUser(userId);
        custTransferLog.setUpdateUser(userId);
        custTransferLog.setDataStatus(WMSConstants.DATE_STATUS_A);
        custTransferLog.setCustTransferLogId(custTransferLogDao.insert(custTransferLog));
        LOG.info("**getCustAccountTransfer()  custTransferLog={}", new Gson().toJson(custTransferLog));
        return custTransferLog;
    }

    private CustTransferLog getLenderApplyTransfer(ParamTransfer custTransferQueryDto, Long userId, Integer type) {
        CustTransferLog custTransferLog = new CustTransferLog();
        Long lenderApplyId = custTransferQueryDto.getLenderApplyId();
        Assert.notNull("**getLenderApplyTransfer() lenderApplyId can not be null**", lenderApplyId);
        LenderApply lenderApply = applyDao.queryById(LenderApply.class, lenderApplyId);
        String lenderCode = lenderApply.getLenderCode();
        Long fromCreateUser = lenderApply.getCreateUser();
        Long fromTeamId = lenderApply.getTeamId();
        Long fromOrgId = lenderApply.getOrgId();
        Assert.notNull("**getLenderApplyTransfer() fromCreateUser can not be null**", fromCreateUser);
        Assert.notNull("**getLenderApplyTransfer() fromTeamId can not be null**", fromTeamId);
        Assert.notNull("**getLenderApplyTransfer() fromOrgId can not be null**", fromOrgId);
        LOG.info("**getLenderApplyTransfer()  lenderApply={}", new Gson().toJson(lenderApply));
        // 转移到的信息
        Long toCreateUser = custTransferQueryDto.getCustManagerId();
        Long toTeamId = custTransferQueryDto.getTeamId();
        Long toOrgId = custTransferQueryDto.getOrgId();
        Assert.notNull("**getLenderApplyTransfer() toCreateUser can not be null**", toCreateUser);
        Assert.notNull("**getLenderApplyTransfer() toTeamId can not be null**", toTeamId);
        Assert.notNull("**getLenderApplyTransfer() toOrgId can not be null**", toOrgId);
        LOG.info("**getLenderApplyTransfer()  toCreateUser={},userId={},toTeamId={},toOrgId={}", toCreateUser, userId,
                toTeamId, toOrgId);

        custTransferLog.setTableName("t_lender_apply");
        custTransferLog.setPkId(lenderApplyId);
        if (Assert.checkParam(lenderCode)) {
            custTransferLog.setPkCode(lenderCode);
        }
        custTransferLog.setFromUser(fromCreateUser);
        if (type == 4) {
            custTransferLog.setFromTeamId(fromTeamId);
            custTransferLog.setFromOrgId(fromOrgId);
            custTransferLog.setToTeamId(toTeamId);
            custTransferLog.setToOrgId(toOrgId);
        }
        custTransferLog.setToUser(toCreateUser);
        custTransferLog.setCreateUser(userId);
        custTransferLog.setUpdateUser(userId);
        custTransferLog.setDataStatus(WMSConstants.DATE_STATUS_A);
        custTransferLog.setCustTransferLogId(custTransferLogDao.insert(custTransferLog));
        LOG.info("**getLenderApplyTransfer()  custTransferLog={}", new Gson().toJson(custTransferLog));
        return custTransferLog;
    }

	@Override
	public PaginationResult<List<ResultTransLog>> queryTransLog(String lenderCustCode, Pagination page) {
	    if (!Assert.checkParam(lenderCustCode)) {
	        LOG.error("lenderCustCode is null");
	        return new PaginationResult<List<ResultTransLog>>();
	    }
	    Map<String, String> param = new HashMap<String, String>();
	    param.put("lenderCustCode",lenderCustCode);
	    return dalClient.queryForList("custBase.queryTransLog", param, ResultTransLog.class, page);
	}
	

}
