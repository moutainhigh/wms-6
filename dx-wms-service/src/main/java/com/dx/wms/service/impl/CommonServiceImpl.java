/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CommonServiceImpl.java
 * Author:   朱道灵
 * Date:     2015年7月30日 下午11:22:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.RoleVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.fms.enums.BankCode;
import com.dx.fms.service.api.IFinanceBankInfoService;
import com.dx.fms.service.api.IFinanceCustomerInfoService;
import com.dx.fms.service.api.IFinanceDataProcessService;
import com.dx.fms.service.dto.BankInfoDTO;
import com.dx.fms.service.dto.BankParamDTO;
import com.dx.fms.service.dto.CustomerInfoDTO;
import com.dx.fms.service.dto.DealRecordDTO;
import com.dx.fms.service.dto.ParamRecordDTO;
import com.dx.fms.service.dto.ProcessResultDTO;
import com.dx.fms.service.dto.QueryRecordDTO;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.framework.exception.BaseException;
import com.dx.hr.service.api.IEmployeeProcessService;
import com.dx.hr.service.api.IEmployeeService;
import com.dx.hr.service.api.IOrgService;
import com.dx.hr.service.api.IPositionService;
import com.dx.hr.service.dto.CommentRequestDto;
import com.dx.hr.service.dto.CommentResultDto;
import com.dx.hr.service.dto.EmployeeDto;
import com.dx.hr.service.dto.EmployeeEntryDto;
import com.dx.hr.service.dto.EmployeeEntryResultDTO;
import com.dx.hr.service.dto.EmployeeListQueryDto;
import com.dx.hr.service.dto.EmployeeListResultDto;
import com.dx.hr.service.dto.EmployeeLogDto;
import com.dx.hr.service.dto.HandleResultDto;
import com.dx.hr.service.dto.LevelDto;
import com.dx.hr.service.dto.OrgDto;
import com.dx.hr.service.dto.OrgRequestDto;
import com.dx.hr.service.dto.PositionDto;
import com.dx.hr.service.dto.PositionRequestDto;
import com.dx.hr.service.dto.ProcessParamDto;
import com.dx.hr.service.dto.ProcessRequestDto;
import com.dx.hr.service.dto.PushAdjustResultDto;
import com.dx.rule.service.ICodeRuleService;
import com.dx.wms.bean.PostCode;
import com.dx.wms.constant.ProductConstant;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.dto.ProductDto;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.ILinkActionService;
import com.dx.wms.service.IPostCodeService;
import com.dx.wms.service.IProductService;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;
import com.google.gson.Gson;

/**
 * 
 * 公共服务
 *
 * @author tony
 */
@Service
public class CommonServiceImpl implements ICommonService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CommonServiceImpl.class);

    /**
     * 权限服务
     */
    @Autowired
    private IAMService amService;

    /**
     * 产品类型服务
     */
    @Autowired
    private IProductService productService;

    /**
     * 财务客户信息接口服务
     */
    @Autowired
    private IFinanceCustomerInfoService financeCustomerInfoService;

    /**
     * 财务数据 推送接口
     */
    @Autowired
    private IFinanceDataProcessService financeDataProcessService;

    /**
     * 编号服务 观察者接口
     */
    @Autowired(required = false)
    private ICodeRuleService codeRuleService;

    /**
     * 环节行为服务
     */
    @Autowired
    private ILinkActionService linkActionService;

    /**
     * 区域服务
     */
    @Autowired
    private IRegionNewService regionService;

    /**
     * 人事组织接口
     */
    @Autowired
    private IOrgService orgService;

    /**
     * 人事岗位接口
     */
    @Autowired
    private IPositionService positionService;

    /**
     * 员工服务
     */
    @Autowired
    private IEmployeeService employeeService;

    /**
     * 人事流程服务
     */
    @Autowired
    private IEmployeeProcessService employeeProcessService;

    /**
     * 财务接口
     */
    @Autowired
    private IFinanceBankInfoService financeBankInfoService;

    /**
     * pos接口
     */
    @Autowired
    private IPostCodeService iPostCodeService;

    /**
     * 
     */
    @Autowired
    private ILenderApplyDao applyDao;

    @Override
    public Boolean hasRoleExist(List<RoleVo> roleVos, String roleCode) {
        LOG.info("hasRoleExist() roleVos{} roleCode{}", new Gson().toJson(roleVos), roleCode);
        if (!Assert.checkParam(roleVos)) {
            LOG.error("hasRoleExist() roleVos{} is null", new Gson().toJson(roleVos));
            return false;
        }
        if (StringUtils.isBlank(roleCode)) {
            LOG.error("hasRoleExist() roleCode{} is null", roleCode);
            return false;
        }
        for (RoleVo role : roleVos) {
            if (StringUtils.contains(role.getCode(), roleCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserVo queryUserCache(Long userId, Map<Long, UserVo> userMap) {
        if (Assert.checkParam(userId)) {
            if (userMap.containsKey(userId)) {
                return userMap.get(userId);
            } else {
                UserVo userVo = amService.queryUserById(Long.valueOf(userId));
                userMap.put(userId, Assert.checkParam(userVo) ? userVo : new UserVo());
                return Assert.checkParam(userVo) ? userVo : new UserVo();
            }
        }
        userMap.put(userId, new UserVo());
        return new UserVo();
    }

    @Override
    public OrgVo queryOrgCache(Long orgId, Map<Long, OrgVo> orgMap) {
        if (Assert.checkParam(orgId)) {
            if (orgMap.containsKey(orgId)) {
                return orgMap.get(orgId);
            } else {
                OrgVo orgVo = amService.queryOrgById(orgId);
                orgMap.put(orgId, Assert.checkParam(orgVo) ? orgVo : new OrgVo());
                return Assert.checkParam(orgVo) ? orgVo : new OrgVo();
            }
        }
        orgMap.put(orgId, new OrgVo());
        return new OrgVo();
    }

    @Override
    public Long getUserId(HttpServletRequest request) {
        return getUserInfo(request).getUserId();
    }

    @Override
    public Long getTeamIdByUserId(Long userId) {
        return getOrgInfo(userId).getOrgId();
    }

    @Override
    public Long getOrgIdByUserId(Long userId) {
        return amService.queryOrgByOrgCode(getCode(userId)).getOrgId();
    }

    private String getCode(Long userId) {
        String code = getOrgInfo(userId).getCode();
        String orgName = getOrgInfo(userId).getName();
        return orgName.startsWith("Cluster") || orgName.startsWith("Team") || orgName.startsWith("综合部")
                || orgName.startsWith("直属团队") ? code.substring(0, 7) : code;
    }

    @Override
    public OrgVo getOrgInfo(Long userId) {
        Assert.notNull("**getOrgInfo() userId can be not null**", userId);
        LOG.info("**getOrgInfo() userId:{}**", userId);
        return amService.queryOrgByUserId(userId);
    }

    private UserVo getUserInfo(HttpServletRequest request) {
        HttpSession session = (HttpSession) request.getSession();
        Assert.notNull("**getUserIdByRequest() session not found**", session);
        UserVo user = (UserVo) session.getAttribute("user");
        Assert.notNull("**getUserIdByRequest() user not found**", user);
        LOG.info("user{}", new Gson().toJson(user));
        return user;
    }

    @Override
    public Map<String, String> getProductByProductId(Long productId) {
        return productService.getProductByAppAndProductId(WMSConstants.WMS, productId);
    }

    @Override
    public ProductDto queryByProductId(Long productId) {
        if (!Assert.checkParam(productId)) {
            return new ProductDto();
        }
        return productService.queryByProductId(ProductConstant.WMS_SYSTEM, productId);
    }

    @Override
    public List<RoleVo> findRolesByRequest(HttpServletRequest request) {
        return amService.findRolesByUserId(getUserId(request));
    }

    @Override
    public List<RoleVo> findRolesByUserId(Long userId) {
        return Assert.checkParam(userId) ? amService.findRolesByUserId(userId) : new ArrayList<RoleVo>();
    }

    @Override
    public Map<String, String> getOrgVos(Integer orgType) {
        Assert.notNull("orgType is null", orgType);
        LOG.info("***getOrgVosuser() orgType={}", orgType);
        List<OrgVo> orgVos = amService.queryOrgsByType(orgType);
        Map<String, String> orgView = new LinkedHashMap<String, String>();
        if (Assert.checkParam(orgVos)) {
            for (OrgVo orgVo : orgVos) {
                orgView.put(orgVo.getOrgId().toString(), orgVo.getName());
            }
        }
        return orgView;
    }

    @Override
    public Map<String, String> getUserVos(Long userId) {
        Assert.notNull("userId is null", userId);
        if (Assert.checkParam(userId)) {
            Long orgId = amService.queryOrgByOrgCode(amService.queryOrgByUserId(userId).getCode().substring(0, 7))
                    .getOrgId();
            // 查询子组织
            Assert.notNull("orgId is null", orgId);
            if (Assert.checkParam(orgId)) {
                List<OrgVo> org = amService.queryOrgsByParentRecursion(orgId);
                List<Long> orgs = new ArrayList<>();
                for (OrgVo orgVo : org) {
                    if (Assert.checkParam(orgVo.getOrgId())) {
                        orgs.add(orgVo.getOrgId());
                    }
                }
                // 查询子组织下的客户经理
                List<UserVo> userVos = amService.queryUsersByOrgAndRole(orgs, RoleConstant.KHJL);
                Map<String, String> custManagers = new HashMap<String, String>();
                for (UserVo userVo : userVos) {
                    if (Assert.checkParam(userVo.getUserId())) {
                        custManagers.put(userVo.getUserId().toString(), userVo.getName());
                    }
                }
                return custManagers;
            }
        }
        return null;
    }

    @Override
    public List<UserVo> queryUsersByCode(String code) {
        Assert.notNull("code is null", code);
        LOG.info("***queryUsersByCode() code={}", code);
        Long orgId = amService.queryOrgByOrgCode(code).getOrgId();
        return amService.queryUserByOrg(orgId);
    }

    @Override
    public Map<String, ProcessResultDTO> pushCustInfoDealData(List<CustomerInfoDTO> customerInfoDTOs) {
        LOG.info("**pushCustInfoDealData() push info customerInfoDTOs ={}**", new Gson().toJson(customerInfoDTOs));
        return financeCustomerInfoService.pushDealDatas(customerInfoDTOs);
    }

    @Override
    public Map<String, ProcessResultDTO> pushCreditorDealData(List<DealRecordDTO> records) {
        Map<String, ProcessResultDTO> result = new HashMap<String, ProcessResultDTO>();
        try {
            Assert.notNull("Records must not be null", records);
            LOG.info("Push records to finance[{}]", new Gson().toJson(records));
            result = financeDataProcessService.pushDealData(records);
        } catch (BaseException e) {
            result.put("error", null);
        }
        return result;
    }

    @Override
    public List<QueryRecordDTO> queryDealDetail(ParamRecordDTO paramRecordDTO) {
        LOG.info("**queryDealDetail() push info paramRecordDTO ={}**", new Gson().toJson(paramRecordDTO));
        return financeDataProcessService.queryDealDetail(paramRecordDTO);
    }

    @Override
    public OrgVo queryClusterCache(OrgVo team, Map<Long, OrgVo> orgMap) {
        return Assert.checkParam(team) ? queryOrgCache(team.getParentId(), orgMap) : new OrgVo();

    }

    @Override
    public List<OrgVo> queryOrgsByParentId(Long pId) {
        LOG.info("**queryOrgsByParentId() pId ={}**", pId);
        return Assert.checkParam(pId) ? amService.queryOrgsByParentId(pId) : new ArrayList<OrgVo>();
    }

    @Override
    public List<UserVo> queryUserByOrgAndRole(Long orgId, String role) {
        return Assert.checkParam(orgId) ? amService.queryUserByOrgAndRole(orgId, role) : new ArrayList<UserVo>();
    }

    @Override
    public void nullifyDealData(List<ParamRecordDTO> paramRecordDTODTOList) {
        financeDataProcessService.nullifyDealData(paramRecordDTODTOList);
    }

    @Override
    public String getCode(String ruleKey, Long orgId, Map<String, Object> objectParam) {
        Assert.notNull("当前操作人组织orgId为空", orgId);
        return codeRuleService.getCode(WMSConstants.WMS, ruleKey, orgId, objectParam);
    }

    @Override
    public Map<String, String> queryStatus() {
        return linkActionService.queryForMap();
    }

    @Override
    public String queryStatus(Long statusId) {
        return linkActionService.queryById(statusId).getDescription();
    }

    @Override
    public Map<String, String> getProductByProductId() {
        return getProductByProductId(-1L);
    }
    

	@Override
	public Map<String, String> getAllProduct(Boolean isOperant) {
		return productService.getAllProductByApp(WMSConstants.WMS, isOperant);
	}

	@Override
    public void putUserCache(Map<Long, UserVo> userMap, Long... ids) {
        for (Long id : ids) {
            queryUserCache(id, userMap);
        }

    }

    @Override
    public void putOrgCache(Map<Long, OrgVo> orgMap, Long... ids) {
        for (Long id : ids) {
            queryOrgCache(id, orgMap);
        }

    }

    @Override
    public Map<String, String> queryForAreas(String... areaCodes) {
        Map<String, String> result = new HashMap<>();
        for (String areaCode : areaCodes) {
            result.put(areaCode, regionService.getRegionNameByCode(areaCode));
        }
        return result;
    }

    @Override
    public String trans2Address(String... areaCodes) {
        Assert.notEquals("Code size must be in (2,3)", areaCodes.length, 2, 3);
        StringBuffer result = new StringBuffer();
        for (String areaCode : areaCodes) {
            String area = regionService.getRegionNameByCode(areaCode);
            if (!Assert.equals(area, result.toString().trim())) {
                result.append(area).append(" ");
            }
        }
        return result.toString();
    }

    @Override
    public List<OrgDto> queryOrgListByUserId(Long userId) {
        Assert.notNull("userId must not be null", userId);
        LOG.info("***queryOrgListByUserId() userId = {}", userId);
        return orgService.queryOrgListByUserId(userId);
    }

    @Override
    public List<PositionDto> queryPositionDtosByOrgId(Long orgId) {
        return positionService.queryPositionDtosByOrgId(orgId);
    }

    @Override
    public List<PositionDto> queryPositionsByCondition(Long userId) {
        Assert.notNull("userId must not be null", userId);
        LOG.info("***queryPositionsByCondition() userId = {}", userId);
        PositionRequestDto dto = new PositionRequestDto();
        dto.setUserId(userId);
        return positionService.queryPositionsByCondition(dto);
    }

    @Override
    public Map<String, String> putAllPositionDtos() {
        Map<String, String> map = new HashMap<String, String>();
        Long orgId = amService.queryOrgByOrgCode("CFTZGL").getOrgId();
        List<PositionDto> results = positionService.queryPositionDtosByOrgId(orgId);
        if (Assert.checkParam(results)) {
            for (PositionDto dto : results) {
                map.put(dto.getPositionId().toString(), dto.getName());
            }
        }
        return map;
    }

    @Override
    public Map<String, EmployeeEntryResultDTO> pushPlannedEntryData(List<EmployeeDto> employeeDtos) {
        Assert.notNull("**employeeDtos must not be not null**", employeeDtos);
        return employeeService.pushPlannedEntryData(employeeDtos);
    }

    @Override
    public List<LevelDto> queryLevelsByPositionId(Long positionId) {
        Assert.notNull("positionId must not be null", positionId);
        LOG.info("queryLevelsByPositionId() positionId = {}", positionId);
        return positionService.queryLevelsByPositionId(positionId);
    }

    @Override
    public Map<String, String> getAllOrgDtos(Long userId) {
        Map<String, String> map = new HashMap<String, String>();
        List<OrgDto> results = queryOrgListByUserId(userId);
        if (Assert.checkParam(results)) {
            for (OrgDto dto : results) {
                Long orgId = dto.getOrgId();
                if (!map.containsKey(orgId)) {
                    map.put(dto.getOrgId().toString(), dto.getOrgName());
                }
            }
        }
        return map;
    }

    @Override
    public List<OrgDto> queryOrgsByPositionId(Long positionId) {
        Assert.notNull("positionId missing...", positionId);
        LOG.info("***positionId:{}***", positionId);
        return positionService.queryOrgsByPositionId(positionId);
    }

    @Override
    public Map<String, String> getMyOrgs() {
        Map<String, String> map = new HashMap<String, String>();
        Long orgId = amService.queryOrgByOrgCode("CFTZGL").getOrgId();
        List<OrgDto> lo = orgService.queryOrgsByOrgId(orgId);
        if (Assert.checkParam(lo)) {
            for (OrgDto dto : lo) {
                map.put(dto.getOrgId().toString(), dto.getOrgName());
            }
        }
        return map;
    }

    @Override
    @Transactional
    public EmployeeEntryResultDTO saveHrInfo(EmployeeEntryDto employeeEntryDto) {
        Assert.notNull("employeeEntryDto cannot be null.", employeeEntryDto);
        if (Assert.checkParam(employeeEntryDto.getEmployeeDetailInfo())) {
            saveSubBankInfo(employeeEntryDto);
        }
        return employeeService.pushEmployeeEntryData(employeeEntryDto);
    }

    private void saveSubBankInfo(EmployeeEntryDto employeeEntryDto) {
        // 此处保存支行信息
        List<BankInfoDTO> bankInfoDTOList = new ArrayList<BankInfoDTO>();
        BankInfoDTO bankInfoDTO = new BankInfoDTO();
        String bankCode = "CMB";
        bankInfoDTO.setBankCode(bankCode);
        bankInfoDTO.setBankName(BankCode.getEunm(bankCode).getInfo());
        bankInfoDTO.setProvinceCode(employeeEntryDto.getEmployeeDetailInfo().getBankProvinceCode());
        bankInfoDTO.setProvinceName(
                regionService.getRegionNameByCode(employeeEntryDto.getEmployeeDetailInfo().getBankProvinceCode()));
        bankInfoDTO.setCityName(
                regionService.getRegionNameByCode(employeeEntryDto.getEmployeeDetailInfo().getBankCityCode()));
        bankInfoDTO.setCityCode(employeeEntryDto.getEmployeeDetailInfo().getBankCityCode());
        bankInfoDTO.setSubBankName(employeeEntryDto.getEmployeeDetailInfo().getOtherAddress());
        bankInfoDTOList.add(bankInfoDTO);
        Map<String, ProcessResultDTO> map = financeBankInfoService.saveBankInfo(bankInfoDTOList);
        Assert.notNull("**save() 支行信息保存异常   **", map.get(employeeEntryDto.getEmployeeDetailInfo().getOtherAddress()));
    }

    @Override
    public HandleResultDto deleteVideo(Long deleteId, Long userId, Integer infoType) {
        Assert.notNull("params missing...", userId, deleteId);
        LOG.info("*** userId = {} ,employeeVideoId = {} ***", userId, deleteId);
        return employeeService.deleteEmployeeMessage(deleteId, userId, infoType);
    }

    @Override
    public EmployeeEntryDto queryEmployeeDetailByEmployeeId(Long employeeId) {
        Assert.notNull("employeeId must not be null", employeeId);
        LOG.info("queryEmployeeDetailByEmployeeId() employeeId = {}", employeeId);
        return employeeService.queryEmployeeDetailByEmployeeId(employeeId);
    }

    @Override
    public EmployeeEntryResultDTO executeComplete(EmployeeEntryDto employeeEntryDto) {
        return employeeProcessService.executeComplete(employeeEntryDto);
    }

    @Override
    public EmployeeEntryResultDTO executeStart(ProcessParamDto param) {
        return employeeProcessService.executeStart(param);
    }

    @Override
    public PaginationResult<List<EmployeeListResultDto>> query(ProcessRequestDto processRequestDto) {
        Assert.notNull("employeeEntryDto must not be null", processRequestDto);
        Assert.notNull("userId,businessType,taskKey must not be null", processRequestDto.getUserId(),
                processRequestDto.getBusinessType(), processRequestDto.getTaskKey());
        return employeeProcessService.query(processRequestDto);
    }

    @Override
    public List<CommentResultDto> queryLog(String taskId) {
        Assert.notNull("taskId must not be null", taskId);
        LOG.info("*** taskId = {} ***", taskId);
        return employeeProcessService.queryLog(taskId);
    }

    @Override
    public PaginationResult<List<EmployeeListResultDto>> businessApplyQuery(EmployeeListQueryDto employeeListQueryDto) {
        return employeeService.businessApplyQuery(employeeListQueryDto);
    }

    @Override
    public List<PositionDto> queryPositionDtosByCondition(PositionRequestDto positionRequestDto) {
        return positionService.queryPositionDtosByCondition(positionRequestDto);
    }

    @Override
    public Map<String, String> trans2Position(PositionRequestDto positionRequestDto) {
        List<PositionDto> positions = queryPositionDtosByCondition(positionRequestDto);
        Map<String, String> map = new HashMap<String, String>();
        if (Assert.checkParam(positions)) {
            for (PositionDto dto : positions) {
                if (!map.containsKey(dto.getPositionId())) {
                    map.put(dto.getPositionId().toString(), dto.getName());
                }
            }
        }
        return map;
    }

    @Override
    public List<CommentResultDto> queryEmployeeEntryApproveMsg(CommentRequestDto commentRequestDto) {
        Assert.notNull("commentRequestDto cannot be null", commentRequestDto);
        return employeeService.queryEmployeeEntryApproveMsg(commentRequestDto);
    }

    @Override
    public OrgDto queryOrgByOrgId(Long orgId) {
        Assert.notNull("*** orgId must not be null ***", orgId);
        LOG.info("*** orgId = {} ***", orgId);
        OrgRequestDto dto = new OrgRequestDto();
        dto.setOrgId(orgId);
        return orgService.queryOrgByCondition(dto);
    }

    @Override
    public OrgDto queryOrgByCode(String orgCode) {
        Assert.notNull("*** orgCode must not be null ***", orgCode);
        LOG.info("*** orgCode = {} ***", orgCode);
        OrgRequestDto dto = new OrgRequestDto();
        dto.setOrgCode(orgCode);
        return orgService.queryOrgByCondition(dto);
    }

    @Override
    public List<OrgDto> queryPowerOrgsByPositionId(Long positionId, Long userId) {
        Assert.notNull("*** positionId must not be null ***", positionId);
        Assert.notNull("*** userId must not be null ***", userId);
        LOG.info("*** queryPowerOrgsByPositionId() positionId:{},userId:{} ***", positionId, userId);
        PositionRequestDto dto = new PositionRequestDto();
        dto.setPositionId(positionId);
        dto.setUserId(userId);
        return positionService.queryPowerOrgsByPositionId(dto);
    }

    @Override
    public List<OrgDto> getMyOrgs(Long orgId) {
        return orgService.queryOrgsByOrgId(orgId);
    }

    @Override
    public List<PushAdjustResultDto> queryAjustRecords(Long employeeId) {
        return employeeService.queryAjustRecords(employeeId);
    }

    @Override
    public List<BankInfoDTO> querySubBankNameByCode(BankParamDTO bankParamDTO) {
        Assert.notNull("*** bankParamDTO must not be null ***", bankParamDTO);
        LOG.info("*** querySubBankNameByCode() bankParamDTO:{},userId:{} ***", new Gson().toJson(bankParamDTO));
        return financeBankInfoService.querySubBankNameByCode(bankParamDTO);
    }

    @Override
    public PaginationResult<List<EmployeeListResultDto>> queryEmployeeListByCondition(
            EmployeeListQueryDto employeeListQueryDto) {
        return employeeService.queryEmployeeListByCondition(employeeListQueryDto);
    }

    @Override
    public PaginationResult<List<EmployeeListResultDto>> queryEmployeeInfoByCondition(
            EmployeeListQueryDto employeeListQueryDto) {
        return employeeService.queryEmployeeInfoByCondition(employeeListQueryDto);
    }

    @Override
    public List<EmployeeLogDto> queryEmployeeLogs(Long employeeId) {
        return employeeService.queryEmployeeLogs(employeeId);
    }

    @Override
    public List<BankInfoDTO> subBank(String bankCode, String paycityRegionCode, String payprovinceRegionCode) {
        BankParamDTO bankParamDTO = new BankParamDTO();
        bankParamDTO.setBankCode(getbankCode(Integer.parseInt(bankCode)));
        bankParamDTO.setProvinceCode(payprovinceRegionCode);
        bankParamDTO.setCityCode(paycityRegionCode);
        return financeBankInfoService.querySubBankNameByCode(bankParamDTO);
    }

    @Override
    public String getbankCode(Integer bank) {
        String bankCode = "";
        switch (bank) {
            case 1:
                // 11,"工商银行" ICBC
                bankCode = "ICBC";
                break;
            case 2:
                // 12,"农业银行" ABC
                bankCode = "ABC";
                break;
            case 3:
                // 13,"建设银行" CCB
                bankCode = "CCB";
                break;
            case 4:
                // 14,"中国银行 " BOC
                bankCode = "BOC";
                break;
            case 5:
                // 15,"邮政储蓄银行"PSBC
                bankCode = "PSBC";
                break;
            case 6:
                // 16,"招商银行" CMB
                bankCode = "CMB";
                break;
            case 7:
                // 17,"兴业银行" CIB
                bankCode = "CIB";
                break;
            case 8:
                // 18,"广发银行" GDB
                bankCode = "GDB";
                break;
            case 9:
                // 19,"平安银行" PAB
                bankCode = "PAB";
                break;
            case 10:
                // 20,"中信银行"CITIC
                bankCode = "CITIC";
                break;
            case 11:
                // 21,"华夏银行" HXB
                bankCode = "HXB";
                break;
            case 12:
                // 22,"中国光大银行"CEB
                bankCode = "CEB";
                break;
            case 13:
                // 23,"浦发银行" SPDB
                bankCode = "SPDB";
                break;
            case 14:
                // 24,"民生银行" CMBC
                bankCode = "CMBC";
                break;
            case 15:
                // 25,"上海银行" BOC
                bankCode = "BOS";
                break;
            case 16:
                // 26,"交通银行" BCM
                bankCode = "BCM";
                break;
        }
        return bankCode;
    }

    @Override
    public Map<String, ProcessResultDTO> saveBankInfo(List<BankInfoDTO> bankInfoDTOList) {
        return financeBankInfoService.saveBankInfo(bankInfoDTOList);
    }

    @Override
    public PostCode getPostCode(Long orgId) {
        return iPostCodeService.queryByOrgId(orgId);
    }

    @Override
    public LenderApply getDueDate(LenderApply lenderApply) {
        return applyDao.queryById(LenderApply.class, lenderApply.getLenderApplyId());
    }
}
