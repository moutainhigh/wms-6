/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICommonService.java
 * Author:   朱道灵
 * Date:     2015年7月30日 下午10:36:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.RoleVo;
import com.dx.ccs.vo.UserVo;
import com.dx.fms.service.dto.BankInfoDTO;
import com.dx.fms.service.dto.BankParamDTO;
import com.dx.fms.service.dto.CustomerInfoDTO;
import com.dx.fms.service.dto.DealRecordDTO;
import com.dx.fms.service.dto.ParamRecordDTO;
import com.dx.fms.service.dto.ProcessResultDTO;
import com.dx.fms.service.dto.QueryRecordDTO;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.exception.BaseException;
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
import com.dx.hr.service.dto.PositionDto;
import com.dx.hr.service.dto.PositionRequestDto;
import com.dx.hr.service.dto.ProcessParamDto;
import com.dx.hr.service.dto.ProcessRequestDto;
import com.dx.hr.service.dto.PushAdjustResultDto;
import com.dx.hr.service.exception.ProcessException;
import com.dx.wms.bean.PostCode;
import com.dx.wms.dto.ProductDto;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 
 * 通用服务
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ICommonService {

    /**
     * 
     * 功能描述: 判断是否存在该角色 〈功能详细描述〉
     *
     * @param roleVos
     * @param roleCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean hasRoleExist(List<RoleVo> roleVos, String roleCode);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param userId
     * @param userMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    UserVo queryUserCache(Long userId, Map<Long, UserVo> userMap);

    void putUserCache(Map<Long, UserVo> userMap, Long... ids);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param orgId
     * @param orgMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    OrgVo queryOrgCache(Long orgId, Map<Long, OrgVo> orgMap);

    void putOrgCache(Map<Long, OrgVo> orgMap, Long... ids);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param team
     * @param orgMap
     * @return
     */
    OrgVo queryClusterCache(OrgVo team, Map<Long, OrgVo> orgMap);

    /**
     * 
     * 功能描述: 通过request中取出userId
     *
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Long getUserId(HttpServletRequest request);

    /**
     * 
     * 功能描述: 通过userId获取组织Id
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Long getTeamIdByUserId(Long userId);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Long getOrgIdByUserId(Long userId);

    /**
     * 
     * 功能描述: 通过userId获取角色列表
     *
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<RoleVo> findRolesByRequest(HttpServletRequest request);

    /**
     * 
     * 功能描述: 通过userId获取角色列表
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<RoleVo> findRolesByUserId(Long userId);

    /**
     * 
     * 功能描述: 通过userId获取所属组织对象
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    OrgVo getOrgInfo(Long userId);

    /**
     * 
     * 功能描述: 根据组织类型查询组织 〈功能详细描述〉
     *
     * @param orgType
     * @return Map<String, String>
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, String> getOrgVos(Integer orgType);

    /**
     * 
     * 功能描述: 根据人员Id查询子组织内的成员 〈功能详细描述〉
     * 
     * @param userId
     * @return Map<String, String>
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, String> getUserVos(Long userId);

    /**
     * 
     * 功能描述: 根据code查询组织内的成员 〈功能详细描述〉
     * 
     * @param code
     * @return List<UserVo>
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<UserVo> queryUsersByCode(String code);

    /**
     * 
     * 功能描述: 调用财务推送接口，推送客户信息给财务系统 〈功能详细描述〉
     *
     * @param customerInfoDTOs
     * @return
     */
    Map<String, ProcessResultDTO> pushCustInfoDealData(List<CustomerInfoDTO> customerInfoDTOs);

    /**
     * 
     * 功能描述: 调用财务接口 推送债权确认数据 〈功能详细描述〉
     *
     * @param dealRecordDTOList
     * @return
     * @throws BaseException
     */
    Map<String, ProcessResultDTO> pushCreditorDealData(List<DealRecordDTO> dealRecordDTOList);

    /**
     * 
     * 根据传入的参数记录DTO 查询多个流水信息集合 <br>
     *
     * @param paramRecordDTO
     * @return List<QueryRecordDTO>
     * @since v1.0
     */
    List<QueryRecordDTO> queryDealDetail(ParamRecordDTO paramRecordDTO);

    /**
     * 功能描述: 根据ID查询下级组织<br>
     *
     * @param Long pId 组织ID
     * @return List<OrgVo> 组织信息
     * @since v1.0
     */
    List<OrgVo> queryOrgsByParentId(Long pId);

    /**
     * 功能描述: 查询部门下某个角色的所有用户<br>
     * 
     * @orgId 部门组织ID
     * @roleCode 角色Code
     * @return List<UserVo> 用户信息
     * @since v1.0
     */
    List<UserVo> queryUserByOrgAndRole(Long orgId, String role);

    /**
     * 
     * 根据传入的业务流水号，将交易数据失效。
     *
     * @param List<ParamRecordDTO> 参数记录DTO集合
     * @throws BaseException
     * @since v1.0
     */
    void nullifyDealData(List<ParamRecordDTO> paramRecordDTODTOList);

    /**
     * 
     * 按用户设置的编码规范获取编号
     *
     * @param ruleKey 规则号
     * @param orgId 组织Id
     * @param objectParam 引用对象信息
     * @return
     */
    String getCode(String ruleKey, Long orgId, Map<String, Object> objectParam);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param areaCode
     * @return
     */
    Map<String, String> queryForAreas(String... areaCodes);

    String trans2Address(String... areaCodes);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     */
    Map<String, String> queryStatus();

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param statusId
     * @return
     */
    String queryStatus(Long statusId);

    /**
     * 
     * 功能描述: 根据应用Code 父产品Id查询所属的产品列表 〈功能详细描述〉
     *
     * @param appCode 应用Code
     * @param productId 父产品Id 传-1代表查询1级产品
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, String> getProductByProductId(Long productId);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     */
    Map<String, String> getProductByProductId();
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @return
     */
    Map<String, String> getAllProduct(Boolean isOperant);

    /**
     * 
     * 功能描述: 通过产品Id查询产品对象
     * 
     * @param appCode 应用Code
     * @param productId 产品Id
     * @return 产品对象
     */
    ProductDto queryByProductId(Long productId);

    /**
     * 
     * 根据登录系统的用户ID查找组织树集合
     * 
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<OrgDto> queryOrgListByUserId(Long userId);

    /**
     * 
     * 功能描述: 查询登录人所在组织下的所有岗位 〈功能详细描述〉
     *
     * @param orgId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<PositionDto> queryPositionDtosByOrgId(Long orgId);

    /**
     * 查询登录人所在组织下父节点下的所有岗位信息(分级别)
     *
     * @param orgId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<PositionDto> queryPositionsByCondition(Long userId);

    /**
     * 
     * 查询理财系统所有的职位 <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, String> putAllPositionDtos();

    /**
     * 
     * 预入职员工数据
     * 
     * @param employeeEntryDtos
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, EmployeeEntryResultDTO> pushPlannedEntryData(List<EmployeeDto> employeeDtos);

    /**
     * 
     * 功能描述: 查询岗位职务对应的级别 〈功能详细描述〉
     *
     * @param positionId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<LevelDto> queryLevelsByPositionId(Long positionId);

    /**
     * 
     * 功能描述: 查询岗位职务对应的组织 〈功能详细描述〉
     *
     * @param positionId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<OrgDto> queryOrgsByPositionId(Long positionId);

    /**
     * 
     * 功能描述: 预入职，根据登录人的权限查询出相关组织 〈功能详细描述〉
     *
     * @param positionId
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<OrgDto> queryPowerOrgsByPositionId(Long positionId, Long userId);

    /**
     * 
     * 功能描述: 获取任职部门 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, String> getAllOrgDtos(Long userId);

    /**
     * 张祥韵 功能描述: 取得所有组织 〈功能详细描述〉
     * 
     * @param orgId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, String> getMyOrgs();

    /**
     * 张祥韵 功能描述: 根据orgId取得所有组织 〈功能详细描述〉
     * 
     * @param orgId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<OrgDto> getMyOrgs(Long orgId);

    /**
     * 张祥韵 功能描述: 人事通过employeeId查询人员详细信息 〈功能详细描述〉
     * 
     * @param employeeId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    EmployeeEntryDto queryEmployeeDetailByEmployeeId(Long employeeId);

    /**
     * 员工入职接口
     *
     * @param employeeEntryDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    EmployeeEntryResultDTO saveHrInfo(EmployeeEntryDto employeeEntryDto);

    /**
     * 删除影像件
     *
     * @param userId
     * @param employeeId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    HandleResultDto deleteVideo(Long employeeVideoId, Long userId, Integer infoType);

    /**
     * 杨宝河 功能描述: 查询某组织信息 可传orgId〈功能详细描述〉
     *
     * @param orgRequestDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    OrgDto queryOrgByOrgId(Long orgId);

    /**
     * 杨宝河 功能描述: 查询某组织信息 可传orgCode 〈功能详细描述〉
     *
     * @param orgRequestDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    OrgDto queryOrgByCode(String orgCode);

    /**
     * 
     * 功能描述: 入职流程启动 启动流程
     *
     * @param param
     * @throws ProcessException
     */
    EmployeeEntryResultDTO executeStart(ProcessParamDto param);

    /**
     * 
     * 功能描述: 员工入职审批接口 执行流程
     *
     * @param param
     * @throws ProcessException
     */
    EmployeeEntryResultDTO executeComplete(EmployeeEntryDto employeeEntryDto);

    /**
     * 
     * 功能描述:查询待办 查询当前任务
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<EmployeeListResultDto>> query(ProcessRequestDto processRequestDto);

    /**
     * 
     * 查询日志
     * 
     * @param param
     * @param page
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<CommentResultDto> queryLog(String taskId);

    /**
     * 
     * 入职申请查询
     * 
     * @param employeeListQueryDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<EmployeeListResultDto>> businessApplyQuery(EmployeeListQueryDto employeeListQueryDto);

    /**
     * 根据不同角色登陆不同页面查询不同岗位list
     *
     * @param positionRequestDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<PositionDto> queryPositionDtosByCondition(PositionRequestDto positionRequestDto);

    Map<String, String> trans2Position(PositionRequestDto positionRequestDto);

    /**
     * 查询员工的入职审批记录或者异动审批记录
     *
     * @param commentRequestDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<CommentResultDto> queryEmployeeEntryApproveMsg(CommentRequestDto commentRequestDto);

    /**
     * 张祥韵 查询员工异动记录
     *
     * @param PushAdjustResultDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<PushAdjustResultDto> queryAjustRecords(Long employeeId);

    /**
     * 杨宝河 功能描述: 根据开户省份和市区查询支行 〈功能详细描述〉
     *
     * @param bankParamDTO 银行code，开户省份code，开户市code必传
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<BankInfoDTO> querySubBankNameByCode(BankParamDTO bankParamDTO);

    /**
     * 
     * 功能描述: 人员信息、入职管理、在职管理查询接口 〈功能详细描述〉
     *
     * @param employeeListQueryDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<EmployeeListResultDto>> queryEmployeeInfoByCondition(
            EmployeeListQueryDto employeeListQueryDto);

    /**
     * 根据条件查询员工集合
     * 
     * @param employeeListQueryDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<EmployeeListResultDto>> queryEmployeeListByCondition(
            EmployeeListQueryDto employeeListQueryDto);

    // 根据员工id查询审批日志
    List<EmployeeLogDto> queryEmployeeLogs(Long employeeId);

    /**
     * 
     * 功能描述: 根据银行，省，地区的code获得支行信息 〈功能详细描述〉
     *
     * @param bankCode
     * @param paycityRegionCode
     * @param payprovinceRegionCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<BankInfoDTO> subBank(String bankCode, String paycityRegionCode, String payprovinceRegionCode);

    /**
     * 
     * 功能描述: 获取 银行 CODE 〈功能详细描述〉
     *
     * @param bank
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String getbankCode(Integer bank);
    
    /**
     * 
     * 功能描述: 调用财务接口保存支行信息
     * 〈功能详细描述〉
     *
     * @param bankInfoDTOList
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, ProcessResultDTO> saveBankInfo(List<BankInfoDTO> bankInfoDTOList);
    
    /**
     * 
     * 功能描述: 根据 营业部ID查询出对应营业部的固定pos终端信息
     * 〈功能详细描述〉
     *
     * @param orgId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PostCode getPostCode(Long orgId);
    
    /**
     * 
     * 功能描述: 根据lenderApplyId获取到期日
     * 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApply getDueDate(LenderApply lenderApply);
}
