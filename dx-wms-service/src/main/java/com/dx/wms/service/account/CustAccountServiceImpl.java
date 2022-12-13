/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountServiceImpl.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午6:28:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.account;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.vo.RoleVo;
import com.dx.cmm.dto.BizBase;
import com.dx.cmm.dto.PushData;
import com.dx.cmm.enums.MatchPushCode;
import com.dx.cmm.service.IMatchPushService;
import com.dx.cmm.service.cache.ICacheService;
import com.dx.cmm.service.view.FirstViewResult;
import com.dx.cms.dto.Condition;
import com.dx.cms.enums.ResKey;
import com.dx.cms.service.IFileService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.service.utils.MapUtils;
import com.dx.common.service.utils.Trans2Birthday;
import com.dx.common.service.utils.Trans2PinYin;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.CodeRuleType;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.account.dao.ICustAccountDao;
import com.dx.wms.service.account.dao.ICustCommDao;
import com.dx.wms.service.account.dao.ICustLinkmanDao;
import com.dx.wms.service.account.dao.ICustProfessionDao;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.account.dto.ParamAccount;
import com.dx.wms.service.account.dto.ResultAccount;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.apply.dao.ICustFinanceDao;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.dao.ILenderConditionDao;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.base.CustBase;
import com.dx.wms.service.base.CustViewDto;
import com.dx.wms.service.base.ICustBaseDao;
import com.dx.wms.service.base.ICustViewService;
import com.dx.wms.service.changer.ChangeLog;
import com.dx.wms.service.changer.IChangeInfoSaveService;
import com.dx.wms.service.checker.Checker;
import com.dx.wms.service.exception.SaveException;
import com.dx.wms.service.save.HandlerDto;
import com.dx.wms.service.saver.ResultSaver;
import com.dx.wms.service.validators.CustAccountValidator;
import com.dx.wms.service.validators.CustCommValidator;
import com.dx.wms.service.validators.CustLinkmanValidator;
import com.dx.wms.service.validators.CustProfessionValidator;
import com.dx.wms.service.validators.ValidatorUtils;
import com.google.gson.Gson;

/**
 * 客户账户表 service层 接口 实现
 *
 * @author 王蕊
 */
@Service
public class CustAccountServiceImpl implements ICustAccountService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustAccountServiceImpl.class);
    
    private static final String MATCH_KEY = "match:view:first:";
    
    private static final String INVEST_KEY = "lenderApplyQuery:";
    
    private static final String EFFECT_KEY = "match:view:first:effect:";
    
    /**
     * dalClient
     */
    @Autowired
    public PaginationDalClient dalClient;

    /**
     * 客户帐户表Dao层
     */
    @Autowired
    private ICustAccountDao custAccountDao;

    /**
     * 客户通讯表Dao层
     */
    @Autowired
    private ICustCommDao custCommDao;
    /**
     * 客户职业表Dao层
     */
    @Autowired
    private ICustProfessionDao custProfessionDao;

    /**
     * 客户联系人表Dao层
     */
    @Autowired
    private ICustLinkmanDao custLinkmanDao;

    /**
     * 客户金融表Dao层
     */
    @Autowired
    private ICustFinanceDao custFinanceDao;

    /**
     * 理财申请特殊情况
     */
    @Autowired
    private ILenderConditionDao lenderConditionDao;

    /**
     * 客户基础表Dao层
     */
    @Autowired
    private ICustBaseDao custBaseDao;
    
    /**
     * 理财申请Dao层
     */
    @Autowired
    private ILenderApplyDao lenderApplyDao;

    /**
     * 客户信息服务
     */
    @Autowired
    private Checker checkInfoService;

    /**
     * 通用服务
     */
    @Autowired
    private ICommonService commonService;

    @Autowired
    private IFileService fileService;
    
    /**
     * 潜客信息保存服务
     */
    @Autowired
    private ICustViewService custViewService;

    /**
     * 保存变更日志
     */
    @Autowired
    private IChangeInfoSaveService changeInfoSaveService;

    @Autowired
    private IMatchPushService matchPushService;
    
    /*
     * 缓存服务
     */
    @Autowired
    private ICacheService<FirstViewResult> cacheService;

    @Override
    public PaginationResult<List<ResultAccount>> queryForPage(ParamAccount param, Pagination page) {
        Assert.notNull("Param must not be null", param);
        LOG.info("Param[{}]", new Gson().toJson(param));
        return dalClient.queryForList("custAccountApply.queryForPage", MapUtils.obj2Map(param), ResultAccount.class,
                page);
    }

    @Override
    public CustAccountApplyDto queryCustAccountDtoById(Long custAccountId) {
        Assert.notNull("**queryCustAccountDtoById() custAccountId can not be null**", custAccountId);
        LOG.info("**queryCustAccountDtoById() custAccountId={}", custAccountId);
        CustAccount custAccount = custAccountDao.queryById(CustAccount.class, custAccountId);
        Assert.notNull("**queryCustAccountDtoById() custAccount can not be null**", custAccount);
        return getCustAccountDtoByCustAccount(custAccount);
    }

    @Override
    public CustAccountApplyDto queryCustAccountDtoByLenderApplyId(Long applyId) {
        Assert.notNull("**queryCustAccountDtoByLenderApplyId() lenderApplyId can not be null**", applyId);
        LOG.info("**queryCustAccountDtoByLenderApplyId() lenderApplyId={}", applyId);
        CustAccountApplyDto custAccountApplyDto = new CustAccountApplyDto();
        custAccountApplyDto.setCustFinances(custFinanceDao.queryByApply(applyId));
        // 查询是否有特殊收益
        custAccountApplyDto.setLenderConditions(lenderConditionDao.queryByParam(applyId));
        // 根据理财申请编号查询理财信息
        LenderApply apply = lenderApplyDao.queryById(LenderApply.class, applyId);
        custAccountApplyDto.setLenderApply(Assert.checkParam(apply) ? apply : new LenderApply());
        return custAccountApplyDto;
    }

    @Override
    public int getAccountStatusByCustAccountId(Long accountId) {
        Assert.notNull("**getAccountStatusByCustAccountId() custAccountId can not be null**", accountId);
        LOG.info("**getAccountStatusByCustAccountId() custAccountId={}", accountId);
        CustAccount custAccount = custAccountDao.queryById(CustAccount.class, accountId);
        Assert.notNull("**getCustAccountById() custAccount not found**", custAccount);
        if (Assert.equals(custAccount.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)) {
            return WMSConstants.CHECK_SUCCEED;
        }
        // 没有理财客户标号的账户为未完成开户的账户，状态未 未认证
        if (!Assert.checkParam(custAccount.getLenderCustCode())) {
            return WMSConstants.UNAUTHERIZED;
        }
        return getAccountStatus(accountId);
    }

    private String checkAccountStatusTerms(LenderApply lenderApply) {
        String currentStepKey = lenderApply.getFormStatus().toString();
        switch (Integer.valueOf(currentStepKey)) {
            case 11:
            case 13:
                // 重新提交R
                return WMSConstants.RESUBMIT;
            case 21:
            case 22:
            case 23:
                // 已认证
                return WMSConstants.ACCOUNT_CHECK_SUCCEED;
            case 20:
                // 投资失效
                return WMSConstants.INVALID;
            case 10:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                return WMSConstants.ACCOUNT_CHECKING;
        }
        return "";
    }

    private int getAccountStatus(Long custAccountId) {
        List<LenderApply> lenderApplys = lenderApplyDao.queryByCustAccountId(custAccountId);
        // 已开户 未理财申请的账户 状态为 未认证
        if (!Assert.checkParam(lenderApplys)) {
            return WMSConstants.UNAUTHERIZED;
        }
        int flag = 0, resubmitFlag = 0, failFlag = 0, authFlag = 0;
        for (LenderApply newLenderApply : lenderApplys) {
            if (Assert.checkParam(newLenderApply)) {
                String statusTerms = checkAccountStatusTerms(newLenderApply);
                switch (statusTerms) {
                    case WMSConstants.ACCOUNT_CHECKING:
                        flag = flag + 1;
                        break;
                    case WMSConstants.RESUBMIT:
                        resubmitFlag = resubmitFlag + 1;
                        break;
                    case WMSConstants.INVALID:
                        failFlag = failFlag + 1;
                        break;
                    case WMSConstants.ACCOUNT_CHECK_SUCCEED:
                        authFlag = authFlag + 1;
                        break;
                    default:
                        break;
                }
            }
        }
        return getAccountStatus(flag, resubmitFlag, failFlag, authFlag);
    }

    private int getAccountStatus(int flag, int resubmitFlag, int failFlag, int authFlag) {
        if (authFlag > 0) {
            // 已认证
            return WMSConstants.CHECK_SUCCEED;
        }
        // 只要有一笔为: 等待质检、等待投资审核、等待匹配、等待匹配确认、等待财务确认,该客户即为认证中状态,不得编辑
        if (flag > 0 && authFlag == 0) {
            // 认证中
            return WMSConstants.CHECKING;
        }
        // 质检拒绝、投资审核拒绝 认证失败
        if (flag == 0 && resubmitFlag > 0) {
            // 认证失败
            return WMSConstants.CHECK_FAILED;
        }
        // 未认证
        if (flag == 0 && failFlag > 0 && resubmitFlag == 0) {
            return WMSConstants.UNAUTHERIZED;
        }
        return WMSConstants.UNAUTHERIZED;
    }

    private String getLenderCustCodeById(Long account, Long orgId) {
        Assert.notNull("**setLenderCustCodeById() custAccountId can not be null**", account);
        Assert.notNull("**setLenderCustCodeById() orgId can not be null**", orgId);
        LOG.info("**setLenderCustCodeById() lenderApplyId={},orgId={}**");
        CustAccount custAccount = custAccountDao.queryById(CustAccount.class, account);
        Assert.notNull("**setLenderCustCodeById() custAccount not found**", custAccount);
        if (Assert.checkParam(custAccount.getLenderCustCode())) {
            return custAccount.getLenderCustCode();
        }
        String lenderCustCode = getCode(orgId);
        if (checkLenderCustCode(lenderCustCode)) {
            lenderCustCode = getCode(orgId);
            if (checkLenderCustCode(lenderCustCode)) {
                throw new BaseException("**setLenderCustCodeById() 编号已存在  客户账户表数据异常** custAccountId={" + account
                        + "},orgId={" + orgId + "},lenderCustCode={}:" + lenderCustCode);
            }
        }
        custAccountDao.update(account, lenderCustCode, null);
        return lenderCustCode;
    }

    @Override
    public CustAccountApplyDto getCustAccountApplyDto(Long custId, Long custAccountId) {
        LOG.info("**getCustAccountApplyDto() custId={},custAccountId={}", custId, custAccountId);
        CustAccountApplyDto custAccountApplyDto = new CustAccountApplyDto();
        CustAccount custAccount = new CustAccount();
        // 选择潜客进入的开户界面
        if (custId > 0 && custAccountId < 0) {
            getCustAccountApplyDto(custAccountApplyDto, custAccount, custId);
        } else {
            // 点击 编辑进入的开户界面
            custAccountApplyDto = queryCustAccountDtoById(custAccountId);
        }
        return custAccountApplyDto;
    }

    private Boolean checkLenderCustCode(String lenderCustCode) {
        Assert.notNull("**setLenderCustCodeById() 编号服务异常**", lenderCustCode);
        return checkInfoService.checkLenderCustCode(lenderCustCode);
    }

    private String getCode(Long orgId) {
        return commonService.getCode(CodeRuleType.LENDER_CUST_CODE.getInfo(), orgId, null);
    }

    private CustAccount getCustAccountByCustBase(Long custId) {
        Assert.notNull("**getCustAccountByCustBase() custId can not be null**", custId);
        CustAccount custAccount = new CustAccount();
        CustBase custBase = custBaseDao.queryById(CustBase.class, custId);
        Assert.notNull("**getCustAccountByCustBase() custBase not found**", custBase);
        BeanUtils.copyProperties(custBase, custAccount);
        return custAccount;
    }

    private CustAccountApplyDto getCustAccountDtoByCustAccount(CustAccount custAccount) {
        Assert.notNull("**getCustAccountDtoByCustAccount() custAccount can not be null**", custAccount);
        Long custAccountId = custAccount.getCustAccountId();
        CustAccountApplyDto custAccountApplyDto = new CustAccountApplyDto();
        CustComm custComm = custCommDao.queryByParam(custAccountId);
        CustProfession custProfession = custProfessionDao.queryByParam(custAccountId);
        CustLinkman custLinkman = custLinkmanDao.queryByParam(custAccountId);
        custAccountApplyDto.setCustAccount(custAccount);
        custAccountApplyDto.setCustComm(Assert.checkParam(custComm) ? custComm : new CustComm());
        custAccountApplyDto
                .setCustProfession(Assert.checkParam(custProfession) ? custProfession : new CustProfession());
        custAccountApplyDto.setCustLinkman(Assert.checkParam(custLinkman) ? custLinkman : new CustLinkman());
        return custAccountApplyDto;
    }

    @Override
    @Transactional
    public Boolean createUserAccount(Long userId, Condition condition) {
        Assert.notNull("conditionsDto不能为空", condition);
        Assert.notNull("操作人不能为空", userId);
        Long custAccountId = condition.getCustAccountId();
        Assert.notNull("客户开户ID不能为空", custAccountId);
        LOG.info("***createUserAccount() custAccountId={},userId={},conditionsDto={}", custAccountId, userId,
                condition);
        Long orgId = commonService.getOrgIdByUserId(userId);
        Assert.notNull("orgId不能为空", orgId);
        LOG.info("***createUserAccount() orgId={}", orgId);
        condition.setLenderCustCode(getLenderCustCodeById(custAccountId, orgId));
        condition.setRes(ResKey.WMS_OPEN);
        LOG.info(" *** createUserAccount() condition={} *** ", new Gson().toJson(condition));
        if (!fileService.effectiveFiles(condition, userId)) {
            throw new BaseException("**end**createUserAccount()**false 影像件修改异常");
        }
        return true;
    }

    @Override
    public CustAccount queryByLenderApplyId(Long lenderApplyId) {
        Assert.notNull("***queryByLenderApplyId() lenderApplyId can be not null**", lenderApplyId);
        LOG.info("***queryByLenderApplyId() lenderApplyId={}**", lenderApplyId);
        return dalClient.queryForObject("custAccount.queryCustAccountByLenderApply",
                MapUtils.getParamMap("lenderApplyId", lenderApplyId), CustAccount.class);
    }

    private void getCustAccountApplyDto(CustAccountApplyDto custAccountApplyDto, CustAccount custAccount, Long custId) {
        custAccount = getCustAccountByCustBase(custId);
        if (StringUtils.isNotBlank(custAccount.getCustName())) {
            custAccount.setCustNameSpell(Trans2PinYin.getPinYin(custAccount.getCustName()));
        }
        if (StringUtils.isNotBlank(custAccount.getIdCard()) && custAccount.getIdType() == 1) {
            custAccount.setBirthDate(DateUtils.parseForDay(Trans2Birthday.ageByIdCard(custAccount.getIdCard())));
        }
        custAccountApplyDto.setCustAccount(custAccount);
        custAccountApplyDto.setCustComm(new CustComm());
        custAccountApplyDto.setCustProfession(new CustProfession());
        custAccountApplyDto.setCustLinkman(new CustLinkman());
    }

    @Override
    public CustAccountApplyDto saveCustAccount(CustAccountApplyDto custAccountApplyDto) {
        Assert.notNull("**save() custAccountApplyDto can not be null**", custAccountApplyDto);
        Long userId = custAccountApplyDto.getActionUserId();
        Assert.notNull("**save() 操作用户对象为空 **", userId);
        LOG.info("**save() custAccountApplyDto={}**", new Gson().toJson(custAccountApplyDto));
        CustAccount entity = custAccountApplyDto.getCustAccount();
        checkCustCodeExist(entity);
        // 保存客户账户信息
        CustAccount custAccount = save(entity, userId);
        updateBase(custAccount,custAccountApplyDto.getActionUserId());
        delCache(custAccount);
        Assert.notNull("**save() save custAccount error**", custAccount);
        return setCustAccountApplyDtoSave(custAccountApplyDto, userId, custAccount.getCustAccountId());
    }
    
    private void delCache(CustAccount custAccount){
    	 List<LenderApply> applys = lenderApplyDao.queryByLenderCustCode(custAccount.getLenderCustCode());
    	 for(LenderApply apply : applys){
    		 cacheService.del(INVEST_KEY.concat(apply.getLenderCode()));
    		 cacheService.del(MATCH_KEY.concat(apply.getLenderCode()));
    		 cacheService.del(EFFECT_KEY.concat(apply.getLenderCode()));
    	 }
    }
    
    private void updateBase(CustAccount custAccount, Long userId){
    	CustBase base = custViewService.queryByCustCode(custAccount.getCustCode()).getCustBase();
    	base.setCustName(custAccount.getCustName());
    	base.setIdType(custAccount.getIdType());
    	base.setIdCard(custAccount.getIdCard());
    	base.setMobile(custAccount.getMobile());
    	base.setSex(custAccount.getSex());
    	base.setCustSource(custAccount.getCustSource());
    	base.setCustSourceOther(custAccount.getCustSourceOther());
    	custViewService.save(base, userId);
    }

    /**
     * 
     * 功能描述: 校验客户账户表 是否存在 相同客户编号 〈功能详细描述〉
     *
     * @param entity
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void checkCustCodeExist(CustAccount entity) {
        Assert.notNull("**save() custaccount can not be null**", entity);
        // 客户账户ID不存在，客户编号存在
        if (!Assert.checkParam(entity.getCustAccountId()) && StringUtils.isNotBlank(entity.getCustCode())
                && checkInfoService.checkCustCodeExist(entity.getCustCode())) {
            // 校验客户账户表 是否存在 相同客户编号
            throw new BaseException("该客户已开户  不能重复开户");
        }
    }

    /**
     * 
     * 功能描述: 保存客户账户信息 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @return CustAccount
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private CustAccount save(CustAccount entity, Long userId) {
        Assert.notNull("**save() entity can be not null", entity);
        LOG.info("**save() entity:{}**", new Gson().toJson(entity));
        Long teamId = commonService.getTeamIdByUserId(userId);
        Long id = entity.getCustAccountId();
        if (!Assert.checkParam(id)) {
            saveCustAccount(entity, userId, teamId);
        } else {
            if (compareDataStatus(id, userId)) {
                CustAccount account = custAccountDao.queryById(CustAccount.class, id);
                // 获取更新后客户账户的数据
                updateCustBase(entity, account, userId);
                updateCustAccount(entity, account, userId);
            } else {
                throw new SaveException("当前客户的信息正在认证中或已认证，无法进行编辑");
            }
        }
        LOG.info("**CustAccount save() entityId={}**", entity.getCustAccountId());
        return entity;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉 比较当前客户的dataStatus与'C'、'S',从而判断是否进行修改信息
     * 
     * @param custAccountId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean compareDataStatus(Long custAccountId, Long userId) {
        List<RoleVo> roleList = commonService.findRolesByUserId(userId);
        if (commonService.hasRoleExist(roleList, RoleConstant.ZWH)) {
            return true;
        }
        CustAccount custAccount = custAccountDao.queryById(CustAccount.class, custAccountId);
        if (!Assert.equals(custAccount.getDataStatus(), WMSConstants.ACCOUNT_CHECKING)
                && !Assert.equals(custAccount.getDataStatus(), WMSConstants.ACCOUNT_CHECK_SUCCEED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * 功能描述: 判断从页面获取的360页面数据是否与更新后的数据相等 〈功能详细描述〉
     *
     * @param entity
     * @param account
     * @param userId
     * @param id
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void updateCustBase(CustAccount entity, CustAccount account, Long userId) {
        // 判断从页面获取的360页面数据是否与更新后的数据相等
        if (!Assert.equals(entity.getCustName(), account.getCustName())
                || !Assert.equals(entity.getIdType(), account.getIdType())
                || !Assert.equals(entity.getIdCard(), account.getIdCard())
                || !Assert.equals(entity.getMobile(), account.getMobile())
                || !Assert.equals(entity.getSex(), account.getSex())
                || !Assert.equals(entity.getCustSource(), account.getCustSource())
                || !Assert.equals(entity.getCustSourceOther(), account.getCustSourceOther())) {
            CustBase custBase = new CustBase();
            BeanUtils.copyProperties(account, custBase);
            // 获取客户关系管理表的custId
            CustBase custBases = custBaseDao.queryByParam(account.getCustCode());
            // 设置客户编号
            custBase.setCustId(custBases.getCustId());
            custViewService.save(custBase, userId);
            // 更新客户金融表的户名
            if (!Assert.equals(entity.getCustName(), account.getCustName())) {
                List<CustFinance> custFinances = custFinanceDao.queryByAccount(account.getCustAccountId());
                if (Assert.checkParam(custFinances)) {
                    custFinanceDao.updateAccountNameByAccountId(userId, account.getCustAccountId(),
                            entity.getCustName());
                }
            }
        }
    }

    /**
     * 
     * 功能描述: 保存或更新客户通讯信息 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param custAccountId
     * @return CustComm
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private CustComm save(CustComm entity, Long userId, Long custAccountId) {
        Assert.notNull("客户联系方式实体为空", entity);
        Long id = entity.getCustCommId();
        if (!Assert.checkParam(id)) {
            saveCustComm(entity, userId, custAccountId);
        } else {
            updateCustComm(entity, userId, custAccountId);
        }
        LOG.info("**CustComm save() entityId={}**", entity.getCustCommId());
        return entity;
    }

    /**
     * 
     * 功能描述: 保存或更新客户职业 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param custAccountId
     * @return CustProfession
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private CustProfession save(CustProfession entity, Long userId, Long custAccountId) {
        Assert.notNull("客户职业信息实体为空", entity);
        Long id = entity.getCustProfessionId();
        if (Assert.checkParam(id)) {
            updateCustProfession(entity, userId, custAccountId);
        } else {
            saveCustProfession(entity, userId, custAccountId);
        }
        LOG.info("**CustProfession save() entityId={}**", entity.getCustProfessionId());
        return entity;
    }

    /**
     * 
     * 功能描述: 保存或更新客户联系人 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param custAccountId
     * @return CustLinkman
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private CustLinkman save(CustLinkman entity, Long userId, Long custAccountId) {
        Assert.notNull("客户联系人实体为空", entity);
        Long id = entity.getCustLinkmanId();
        if (!Assert.checkParam(id)) {
            saveCustLinkman(entity, userId, custAccountId);
        } else {
            if (compareDataStatus(custAccountId, userId)) {
                updateCustLinkman(entity, userId, custAccountId);
            } else {
                throw new SaveException("当前客户的信息正在认证中或已认证，无法进行编辑");
            }
        }
        LOG.info("**CustLinkman save() entityId={}**", entity.getCustLinkmanId());
        return entity;
    }

    @Override
    @Transactional
    public Map<String, Object> save(CustViewDto custViewDto, CustAccountApplyDto custAccountApplyDto, Long userId) {
        Assert.notNull("***userId is null***", userId);
        Assert.notNull("***custViewDto is null***", custViewDto);
        Assert.notNull("***custAccountApplyDto is null***", custAccountApplyDto);
        LOG.info("**save()  custViewDto={},custAccountApplyDto={},userId={}**", new Gson().toJson(custViewDto),
                new Gson().toJson(custAccountApplyDto), userId);
        // 校验手机号码是否重复
        Map<String, Object> result = checkInfoService.checkCustFullInfo(custViewDto.getCustBase().getCustId(),
                custAccountApplyDto.getCustAccount().getMobile(), custAccountApplyDto.getCustAccount().getIdCard());
        if ((Boolean) result.get(WMSConstants.CODE) == false) {
            return result;
        }
        result = saveAccount(userId, custAccountApplyDto);
        pushMatch(custAccountApplyDto.getCustAccount().getCustAccountId(), userId);
        return result;
    }

    /**
     * 
     * 功能描述: 保存开户申请页面信息 〈功能详细描述〉
     *
     * @param userId
     * @param custAccountApplyDto
     * @return Map<String, Object>
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Map<String, Object> saveAccount(Long userId, CustAccountApplyDto custAccountApplyDto) {
        Map<String, Object> result = new HashMap<String, Object>();
        // 保存开户申请页面信息
        custAccountApplyDto.setActionUserId(userId);
        custAccountApplyDto = saveCustAccount(custAccountApplyDto);
        if (custAccountApplyDto != null && Assert.checkParam(custAccountApplyDto.getCustAccount().getCustAccountId())) {
            result.put(WMSConstants.CODE, true);
            result.put(WMSConstants.MSG, "保存成功");
        } else {
            result.put(WMSConstants.CODE, false);
            result.put(WMSConstants.MSG, "保存异常");
        }
        return result;
    }

    /**
     *
     * 功能描述: 推送客户变更数据至运营匹配系统异常判断 〈功能详细描述〉
     *
     * @param accountId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void pushMatch(Long accountId, Long userId) {
        matchPushService.push(MatchPushCode.INVEST_ACCOUNT_UPDATE,
                getPush(custAccountDao.queryById(CustAccount.class, accountId), userId));
    }

    // 封装了每条申请单的推送数据
    private PushData getPush(CustAccount account, Long userId) {
        CustComm comm = custCommDao.queryByParam(account.getCustAccountId());
        Assert.notNull("Comm must not be null", comm);
        Assert.notNull("Comm address must not be null", comm.getProvinceRegionCode(), comm.getCityRegionCode(),
                comm.getDistrictRegionCode());
        String address = commonService.trans2Address(comm.getProvinceRegionCode(), comm.getCityRegionCode(),
                comm.getDistrictRegionCode());
        String addressView = MessageFormat.format("{0}{1}", address,
                Assert.checkParam(comm.getStreetInfo()) ? comm.getStreetInfo() : "");
        PushData push = new PushData(account.getLenderCustCode());
        BizBase base = new BizBase();
        // 出借申请表信息
        putBase(account, base, addressView, comm, userId);
        push.setBizBase(base);
        return push;
    }

    // 获取出借申请表信息
    public void putBase(CustAccount account, BizBase base, String addressView, CustComm comm, Long userId) {
        // 客户姓名
        base.setCustName(account.getCustName());
        // 手机号码
        base.setMobile(account.getMobile());
        // 身份证号
        base.setIdCard(account.getIdCard());
        // 客户邮编
        base.setZipCode(comm.getZipCode());
        // 通讯地址
        base.setCustAddress(addressView);
        // 客户邮箱
        base.setEmail(comm.getEmail());
        // 客户分类
        base.setCustCategory(account.getCustCategory());
        // 操作人
        base.setActionUser(userId);
        LOG.info("Base info[{}]", new Gson().toJson(base));
    }

    /**
     * 
     * 功能描述: 保存开户申请页面信息 〈功能详细描述〉
     *
     * 
     * @param custAccountApplyDto
     * @param userId
     * @param custAccountId
     * @return CustAccountApplyDto
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private CustAccountApplyDto setCustAccountApplyDtoSave(CustAccountApplyDto custAccountApplyDto, Long userId,
            Long custAccountId) {
        // 保存客户联系表
        custAccountApplyDto.setCustComm(save(custAccountApplyDto.getCustComm(), userId, custAccountId));
        // 保存客户职业表
        custAccountApplyDto.setCustProfession(save(custAccountApplyDto.getCustProfession(), userId, custAccountId));
        // 保存客户紧急联系人信息
        custAccountApplyDto.setCustLinkman(save(custAccountApplyDto.getCustLinkman(), userId, custAccountId));

        // 保存变更日志
        if (Assert.checkParam(custAccountApplyDto.getLogs())) {
            for (ChangeLog log : custAccountApplyDto.getLogs()) {
                changeInfoSaveService.save(log, userId);
            }
        }
        return custAccountApplyDto;
    }

    /**
     * 
     * 功能描述: 保存客户职业信息 〈功能详细描述〉
     *
     * 
     * @param entity
     * @param userId
     * @param custAccountId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void saveCustProfession(CustProfession entity, Long userId, Long custAccountId) {
        entity.setCustAccountId(custAccountId);
        entity.setCreateUser(userId);
        entity.setUpdateUser(userId);
        entity.setDataStatus(WMSConstants.DATE_STATUS_A);
        ValidatorUtils.validate(new CustProfessionValidator(), entity);
        entity.setCustProfessionId(custProfessionDao.insert(entity));
    }

    /**
     * 功能描述: 更新客户职业信息 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param custAccountId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void updateCustProfession(CustProfession entity, Long userId, Long custAccountId) {
        CustProfession custProfession = custProfessionDao.queryByParam(custAccountId);
        entity.setCustAccountId(custAccountId);
        entity.setCreateUser(custProfession.getCreateUser());
        entity.setUpdateUser(userId);
        entity.setCreateTime(custProfession.getCreateTime());
        entity.setDataStatus(custProfession.getDataStatus());
        ValidatorUtils.validate(new CustProfessionValidator(), entity);
        custProfessionDao.update(entity);
    }

    /**
     * 功能描述: 保存客户联系人 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param custAccountId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void saveCustLinkman(CustLinkman entity, Long userId, Long custAccountId) {
        entity.setCustAccountId(custAccountId);
        entity.setCreateUser(userId);
        entity.setUpdateUser(userId);
        entity.setDataStatus(WMSConstants.DATE_STATUS_A);
        ValidatorUtils.validate(new CustLinkmanValidator(), entity);
        entity.setCustLinkmanId(custLinkmanDao.insert(entity));
    }

    /**
     * 功能描述: 更新客户联系人 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param custAccountId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void updateCustLinkman(CustLinkman entity, Long userId, Long custAccountId) {
        CustLinkman custLinkman = custLinkmanDao.queryByParam(custAccountId);
        entity.setCustAccountId(custAccountId);
        entity.setCreateUser(custLinkman.getCreateUser());
        entity.setDataStatus(custLinkman.getDataStatus());
        entity.setUpdateUser(userId);
        ValidatorUtils.validate(new CustLinkmanValidator(), entity);
        custLinkmanDao.update(entity);
    }

    /**
     * 功能描述: 保存客户通讯信息 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param custAccountId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void saveCustComm(CustComm entity, Long userId, Long custAccountId) {
        entity.setCustAccountId(custAccountId);
        entity.setCreateUser(userId);
        entity.setUpdateUser(userId);
        entity.setDataStatus(WMSConstants.DATE_STATUS_A);
        ValidatorUtils.validate(new CustCommValidator(), entity);
        entity.setCustCommId(custCommDao.insert(entity));
    }

    /**
     * 功能描述: 更新客户通讯信息 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param custAccountId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void updateCustComm(CustComm entity, Long userId, Long custAccountId) {
        CustComm custComm = custCommDao.queryByParam(custAccountId);
        entity.setCreateUser(custComm.getCreateUser());
        entity.setCustAccountId(custAccountId);
        entity.setUpdateUser(userId);
        entity.setDataStatus(custComm.getDataStatus());
        ValidatorUtils.validate(new CustCommValidator(), entity);
        custCommDao.update(entity);
    }

    /**
     * 功能描述: 保存客户账户信息 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param teamId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void saveCustAccount(CustAccount entity, Long userId, Long teamId) {
        Long orgId = commonService.getOrgIdByUserId(userId);
        entity.setOrgId(orgId);
        entity.setTeamId(teamId);
        entity.setCreateUser(userId);
        entity.setUpdateUser(userId);
        entity.setDataStatus(WMSConstants.DATE_STATUS_A);
        ValidatorUtils.validate(new CustAccountValidator(), entity);
        entity.setCustAccountId(custAccountDao.insert(entity));
    }

    /**
     * 功能描述: 更新客户账户信息 〈功能详细描述〉
     *
     * @param entity
     * @param userId
     * @param id
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void updateCustAccount(CustAccount entity, CustAccount account, Long userId) {
        if (Assert.checkParam(account.getLenderCustCode())) {
            entity.setLenderCustCode(account.getLenderCustCode());
        }
        if (Assert.checkParam(account.getAccountTime())) {
            entity.setAccountTime(account.getAccountTime());
        }
        entity.setCustCode(account.getCustCode());
        entity.setCreateUser(account.getCreateUser());
        entity.setUpdateUser(userId);
        entity.setOrgId(account.getOrgId());
        entity.setTeamId(account.getTeamId());
        entity.setCreateUser(account.getCreateUser());
        entity.setCreateTime(account.getCreateTime());
        entity.setDataStatus(account.getDataStatus());
        ValidatorUtils.validate(new CustAccountValidator(), entity);
        custAccountDao.update(entity);
    }

    @Override
    public CustAccount queryById(Long id) {
        return custAccountDao.queryById(CustAccount.class, id);
    }

    @Override
    public void saveAccount(CustAccount entity, HandlerDto dto, ResultSaver result) {
        Assert.notNull("**save() entity can not be null**", entity);
        Assert.notNull("**save() 操作用户对象为空 **", dto.getUserId());
        LOG.info("**save() paramSaver={}**", new Gson().toJson(entity));
        checkCustCodeExist(entity);
        CustAccount account = save(entity, dto.getUserId());
        result.setAccount(account);
        dto.setId(account.getCustAccountId());
    }

    @Override
    public void saveComm(CustComm entity, HandlerDto dto, ResultSaver result) {
        result.setComm(save(entity, dto.getUserId(), entity.getCustAccountId()));
    }

    @Override
    public void saveLinkman(CustLinkman entity, HandlerDto dto, ResultSaver result) {
        result.setLinkman(save(entity, dto.getUserId(), entity.getCustAccountId()));
    }

    @Override
    public void saveProfession(CustProfession entity, HandlerDto dto, ResultSaver result) {
        result.setProfession(save(entity, dto.getUserId(), dto.getId()));
    }

}
