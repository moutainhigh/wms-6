/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyLogServiceImpl.java
 * Author:   黄健
 * Date:     2015年7月31日 下午9:13:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 理财申请日志 记录
 *
 * @author huangjian
 */
@Service
public class LenderApplyLogServiceImpl implements ILenderApplyLogService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LenderApplyLogServiceImpl.class);

    @Autowired
    private PaginationDalClient dalClient;

    /**
     * AM接口服务
     */
    @Autowired
    private IAMService amService;

    /**
     * 通用接口服务
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 理财申请日志Dao层
     */
    @Autowired
    private ILenderApplyLogDao lenderApplyLogDao;

    @Override
    public List<LogResultDto> queryByParam(Long applyId) {
        List<LogResultDto> results = new ArrayList<LogResultDto>();
        LenderApply apply = lenderApplyLogDao.queryById(LenderApply.class, applyId);
        List<LenderApplyLog> logs = lenderApplyLogDao.queryByApply(applyId);
        if (!Assert.checkParam(logs, apply)) {
            return results;
        }
        Map<Long, UserVo> userMap = new HashMap<>();
        for (LenderApplyLog log : logs) {
            if (!Assert.checkParam(log.getCurrentAction())) {
                continue;
            }
            commonService.putUserCache(userMap, log.getUpdateUser(), log.getCreateUser());
            results.add(new LogResultDto(log, apply, userMap));
        }
        return results;
    }

    /**
     * 查询理财申请 质检审核人
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */

    @Override
    public Long getToUserId(Long userId, String toRole) {
        if (!Assert.checkParam(userId)) {
            throw new BaseException("**getToUserId() 当前登陆用户主键不能为空");
        }
        if (!Assert.checkParam(toRole)) {
            throw new BaseException("**getToUserId() 所要传的角色toRole不能为空");
        }
        LOG.info("** start ** getToUserId() param userId:{}", userId);

        if (StringUtils.equalsIgnoreCase(toRole, RoleConstant.XSKF)) {
            String zhCode = amService.queryOrgByUserId(userId).getCode().substring(0, 7) + "ZH";
            if (StringUtils.isBlank(zhCode) || zhCode.length() < 7) {
                throw new BaseException("userId为" + userId + "的用户所在部门的orgCode配置错误");
            }
            Long orgId = amService.queryOrgByOrgCode(zhCode).getOrgId();
            List<UserVo> users = amService.queryUserByOrg(orgId);
            Assert.notNull("** getToUserId() users is empty", users);
            for (UserVo vo : users) {
                if (commonService.hasRoleExist(commonService.findRolesByUserId(vo.getUserId()), RoleConstant.XSKF)) {
                    LOG.info("** end ** getToUserId() ** userId:{}", vo.getUserId());
                    return vo.getUserId();
                }
            }
        }
        if (StringUtils.equalsIgnoreCase(toRole, RoleConstant.TZSH)) {
            OrgVo org = amService.queryOrgByOrgCode(WMSConstants.LCGLZX);
            if (!Assert.checkParam(org)) {
                return -1L;
            }
            List<OrgVo> orgs = amService.queryOrgsByParentId(org.getOrgId());
            for (OrgVo orgVo : orgs) {
                List<UserVo> users = amService.queryUserByOrg(orgVo.getOrgId());
                Assert.notNull("** getToZWHUserId() users is empty", users);
                for (UserVo vo : users) {
                    if (commonService.hasRoleExist(commonService.findRolesByUserId(vo.getUserId()),
                            RoleConstant.TZSH)) {
                        LOG.info("** end ** getToUserId() ** userId:{}", vo.getUserId());
                        return vo.getUserId();
                    }
                }
            }
        }
        LOG.info("** end ** getToUserId() ** userId=-1L");
        return -1L;
    }

    /**
     * 查询某单理财申请最早的质检日志
     *
     * @param lenderApplyId 理财申请主键
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @Override
    public LenderApplyLog queryQualityRecordById(Long lenderApplyId) {
        Assert.notNull("** queryQualityRecordById() 理财主键不能为空", lenderApplyId);
        LOG.info("** queryQualityRecordById() lenderApplyId:{}", lenderApplyId);
        LenderApplyLog applog = dalClient.queryForObject("lenderApplyLog.queryCustManageByLenderApplyId",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), LenderApplyLog.class);
        Assert.notNull("** queryQualityRecordById() 该单理财申请没有质检的日志", applog);
        return applog;
    }

    @Override
    public LenderApplyLog queryByParam(Long applyId, String step) {
        if (!Assert.checkParam(applyId) || !Assert.checkParam(step)) {
            return new LenderApplyLog();
        }
        return lenderApplyLogDao.queryByParam(applyId, step);
    }

    @Override
    public List<ApplyLog> queryCreateTime() {
        return dalClient.queryForList("lenderApplyLog.queryCreateTime", null, ApplyLog.class);
    }

}
