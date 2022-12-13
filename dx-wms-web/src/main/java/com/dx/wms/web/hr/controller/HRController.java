//package com.dx.wms.web.hr.controller;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dx.ccs.vo.RoleVo;
//import com.dx.cms.dto.ContentDto;
//import com.dx.cms.dto.FileDto;
//import com.dx.common.service.utils.Assert;
//import com.dx.framework.dal.pagination.Pagination;
//import com.dx.framework.dal.pagination.PaginationResult;
//import com.dx.hr.enums.EmployeeStatus;
//import com.dx.hr.enums.PageType;
//import com.dx.hr.enums.PositionProcess;
//import com.dx.hr.service.api.IOrgService;
//import com.dx.hr.service.api.IPositionService;
//import com.dx.hr.service.dto.CommentResultDto;
//import com.dx.hr.service.dto.EmployeeDto;
//import com.dx.hr.service.dto.EmployeeEntryDto;
//import com.dx.hr.service.dto.EmployeeEntryResultDTO;
//import com.dx.hr.service.dto.EmployeeListQueryDto;
//import com.dx.hr.service.dto.EmployeeListResultDto;
//import com.dx.hr.service.dto.EmployeeLogDto;
//import com.dx.hr.service.dto.EmployeeVideoDto;
//import com.dx.hr.service.dto.LevelDto;
//import com.dx.hr.service.dto.OrgDto;
//import com.dx.hr.service.dto.OrgRequestDto;
//import com.dx.hr.service.dto.PositionRequestDto;
//import com.dx.wms.constant.RoleConstant;
//import com.dx.wms.constant.WMSConstants;
//import com.dx.wms.service.ICommonService;
//import com.dx.wms.service.detail.ResultDetail;
//import com.dx.wms.service.model.Model_;
//import com.dx.wms.web.detail.vo.ResultDetailVo;
//import com.dx.wms.web.hr.service.IHRResultService;
//import com.dx.wms.web.hr.vo.EmployeeEntryVo;
//import com.dx.wms.web.hr.vo.HRParamVo;
//import com.dx.wms.web.hr.vo.ResultHRVo;
//import com.dx.wms.web.page.DataTableObj;
//import com.dx.wms.web.util.AreaFullNameUtil;
//import com.dx.wms.web.util.WebCommonUtil;
//
//@Controller
//@RequestMapping("/hr")
//public class HRController {
//    private static final String INFO_LIST = "hr/info_list";
//    private static final String INFO_TREE_LIST = "hr/info_tree_list";
//    private static final String ENTRY_LIST = "hr/entry_list";
//    private static final String IN_SERVICE_LIST = "hr/in_service_list";
//    private static final String IN_SERVICE_TREE_LIST = "hr/in_service_tree_list";
//    private static final String ENTRY_APPROVE_LIST = "hr/entry_approve_list";
//    private static final String MOVE_APPROVE_LIST = "hr/move_approve_list";
//    private static final String DEST_LIST_URL = "hr/record_list";
//    private static final String DEST_TREE_LIST_URL = "hr/record_tree_list";
//
//    /**
//     * 日志组件
//     */
//    static final Logger LOG = LoggerFactory.getLogger(HRController.class);
//
//    /**
//     * 通用服务
//     */
//    @Autowired
//    ICommonService commonService;
//
//
//    @Autowired
//    IPositionService positionService;
//    
//    @Autowired
//    IOrgService orgService;
//
//    @Autowired
//    private IHRResultService HRResultService;
//
//    /**
//     * model服务
//     */
//    @Autowired
//    private Model_ view;
//
//    // 初始化界面
//    String init(String biz, Long userId, ModelMap model) {
//        LOG.info("**init() biz:{},userId:{}**", biz, userId);
//        List<RoleVo> roleVos = commonService.findRolesByUserId(userId);
//        model.addAttribute("position", commonService.trans2Position(getRequestDto(biz, userId)));
//        view.putListModel(biz, userId, roleVos, model);
//        return getUrl(biz, roleVos);
//    }
//
//    // 根据登录角色获取相应权限岗位
//    private PositionRequestDto getRequestDto(String biz, Long userId) {
//        PositionRequestDto dto = new PositionRequestDto();
//        dto.setUserId(userId);
//        switch (biz) {
//            case "list":
//                dto.setPageType(PageType.RY_XXCX.getCode());
//                break;
//            case "entry":
//                dto.setPageType(PageType.RZ_GL.getCode());
//                break;
//            case "entryApprove":
//                dto.setPageType(PageType.RZ_SP.getCode());
//                break;
//            case "inService":
//                dto.setPageType(PageType.ZZ_GL.getCode());
//                break;
//            case "moveApprove":
//                dto.setPageType(PageType.YD_SP.getCode());
//                break;
//            case "approveLog":
//                dto.setPageType(PageType.SP_JL.getCode());
//                break;
//        }
//        return dto;
//    }
//
//    // 获取URL
//    private String getUrl(String biz, List<RoleVo> roleVos) {
//        String url = WMSConstants.EMPTY;
//        switch (biz) {
//            case "list":
//                // 人员信息list的URL
//                return getInfoUrl(roleVos);
//            case "entry":
//                // 入职管理list的URL
//                url = ENTRY_LIST;
//                break;
//            case "inService":
//                // 在职管理list的URL
//                return getInServiceUrl(roleVos);
//            case "entryApprove":
//                // 入职审批list的URL
//                url = ENTRY_APPROVE_LIST;
//                break;
//            case "moveApprove":
//                // 异动审批list的URL
//                url = MOVE_APPROVE_LIST;
//                break;
//            case "approveLog":
//                return getApproveLogUrl(roleVos);
//        }
//        return url;
//    }
//
//    // 人员信息查询URL
//    private String getInfoUrl(List<RoleVo> roleVos) {
//        if (commonService.hasRoleExist(roleVos, RoleConstant.YYBJLZL)
//                || commonService.hasRoleExist(roleVos, RoleConstant.RSZG)) {
//            return INFO_TREE_LIST;
//        }
//        return INFO_LIST;
//    }
//
//    // 在职管理list的URL
//    private String getInServiceUrl(List<RoleVo> roleVos) {
//        if (commonService.hasRoleExist(roleVos, RoleConstant.YYBJLZL)
//                || commonService.hasRoleExist(roleVos, RoleConstant.RSZG)) {
//            return IN_SERVICE_TREE_LIST;
//        }
//        return IN_SERVICE_LIST;
//    }
//
//    // 根据角色判断是否带树的审批日志ftl路径
//    private String getApproveLogUrl(List<RoleVo> roleVos) {
//        if (commonService.hasRoleExist(roleVos, RoleConstant.YYBJLZL)
//                || commonService.hasRoleExist(roleVos, RoleConstant.RSZG)) {
//            return DEST_TREE_LIST_URL;
//        }
//        return DEST_LIST_URL;
//    }
//
//    // 员工预入职model
//    void put(Long userId, ModelMap model) {
//        List<RoleVo> roleVos = commonService.findRolesByUserId(userId);
//        // 分公司经理无级别
//        model.addAttribute("isLevel", commonService.hasRoleExist(roleVos, RoleConstant.QYJL));
//        model.addAttribute("position", commonService.trans2Position(getRequestDto("entry", userId)));
//        view.put(model, Model_.CERT_TYPE, Model_.SEX_TYPE, Model_.JOB_CATEGORY);
//    }
//
//    private String getDepartmentView(Long positionId, Long orgId) {
//        List<OrgDto> lg = commonService.queryOrgsByPositionId(positionId);
//        String orgName = "";
//        for (int i = 0; i < lg.size(); i++) {
//            if (lg.get(i).getOrgPath().indexOf("/") >= 0) {
//                String[] orgIds = lg.get(i).getOrgPath().split("/");
//                for (int j = 0; j < orgIds.length; j++) {
//                    if (orgId.toString().equals(orgIds[j])) {
//                        orgName = lg.get(i).getOrgGroupName();
//                    }
//                }
//            } else if (orgId == Long.valueOf(lg.get(i).getOrgPath())) {
//                orgName = lg.get(i).getOrgGroupName();
//            }
//        }
//        return orgName;
//
//    }
//
//    // 员工在职管理model
//    void put(HttpServletRequest request, ModelMap model, Long employeeId, Long positionId, String biz) {
//        Long userId = commonService.getUserId(request);
//        EmployeeEntryDto employeeDetailInfoDto = commonService.queryEmployeeDetailByEmployeeId(employeeId);
//        model.addAttribute("position", commonService.trans2Position(getRequestDto(biz, userId)));
//        model.addAttribute("employeeId", employeeId);
//        model.addAttribute("employeeInfo", employeeDetailInfoDto.getEmployeeDto());
//        model.addAttribute("departmentView",
//                getDepartmentView(positionId, employeeDetailInfoDto.getEmployeeDto().getOrgId()));
//        model.addAttribute("positionView", commonService.putAllPositionDtos().get(positionId.toString()));
//        model.addAttribute("pushAdjustResultDtos", commonService.queryAjustRecords(employeeId));
//    }
//
//    /**
//     * 员工入职，加载员工影像文件以及员工入职审批记录
//     *
//     * @param model
//     * @param employeeId
//     * @see [相关类/方法](可选)
//     * @since [产品/模块版本](可选)
//     */
//    void put(ModelMap model, Long employeeId, Long userId, String taskId, String procInsId) {
//        put(model, employeeId, taskId, procInsId);
//        // 办理预入职的员工，在入职时将信息带出
//        EmployeeEntryDto infoDto = commonService.queryEmployeeDetailByEmployeeId(employeeId);
//        EmployeeEntryVo entryVo = param(infoDto, userId);
//        // 存放市区
//        view.putEmployee(model, infoDto);
//        // 入职枚举类
//        view.put(model, Model_.SEX_TYPE, Model_.CERT_TYPE, Model_.MARRIAGE, Model_.COUNTRY, Model_.NATION,
//                Model_.WORKUNIT, Model_.POLITICAL_STATUS, Model_.HR_EDUCTION, Model_.JOB_CATEGORY, Model_.CENSUS,
//                Model_.AREAS, Model_.ENTRY_SOURCE, Model_.RELATION_SHIP, Model_.GRADUATE_TYPE, Model_.INSURED_CITY);
//        model.addAttribute("emDetailVo", entryVo);
//    }
//
//    /**
//     * 员工入职审批
//     *
//     * @param model
//     * @param employeeId
//     * @see [相关类/方法](可选)
//     * @since [产品/模块版本](可选)
//     */
//    void put(ModelMap model, Long employeeId, HttpServletRequest request, String procInsId, String taskId) {
//        put(model, employeeId, taskId, procInsId);
//        ResultDetail result = new ResultDetail();
//        result.setEmployeeEntryDto(commonService.queryEmployeeDetailByEmployeeId(employeeId));
//        Long userId = commonService.getUserId(request);
//        // 办理预入职的员工，在入职时将信息带出
//        ResultDetailVo resultDetailVo = result(result, userId);
//        resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().setBankCity(
//                AreaFullNameUtil.getValue(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getBankCityCode()));
//        resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().setBankProvince(
//                AreaFullNameUtil.getValue(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getBankProvinceCode()));
//        Long orgId = resultDetailVo.getEmployeeEntryDto().getEmployeeDto().getOrgId();
//        OrgRequestDto rdto = new OrgRequestDto();
//        rdto.setOrgId(orgId);
//        OrgDto oDto = orgService.queryOrgByCondition(rdto);
//        resultDetailVo.getEmployeeEntryVo().getEmployeeVo().setOrgName(oDto.getOrgName());
//        model.addAttribute("detail", resultDetailVo);
//        //户籍地址全名+邮编
//        model.addAttribute("hj_pca", AreaFullNameUtil.getPca(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusProvinceCode(),
//                resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusCityCode(), 
//                resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusAreaCode())+
//                resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusAddress()+"-"+
//                resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusZipCode());
//        //居住地全名+邮编
//        model.addAttribute("jzd_pca", AreaFullNameUtil.getPca(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeProvinceCode(),
//                resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeCityCode(),
//                resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeAreaCode())+
//                resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeAddress()+"-"+
//                resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeZipCode());
//    }
//
//    // 存放影像件和审批日志
//    private void put(ModelMap model, Long employeeId, String taskId, String procInsId) {
//        model.addAttribute("procInsId", procInsId);
//        model.addAttribute("taskId", taskId);
//        EmployeeEntryDto detail = commonService.queryEmployeeDetailByEmployeeId(employeeId);
//        model.addAttribute("empFiles", detail.getEmployeeVideoDtos());
//        model.addAttribute("employeeId", employeeId);
//        List<CommentResultDto> approveLogs = HRResultService.getApproves(employeeId);
//        model.addAttribute("approveLogs", approveLogs);
//        if (Assert.checkParam(approveLogs)) {
//            model.addAttribute("applicant", approveLogs.get(0).getUserId());
//        }  
//    }
//
//    // 员工入职审批页面dto转vo
//    private ResultDetailVo result(ResultDetail result, Long userId) {
//        Map<String, String> addrMap = new HashMap<String, String>();
//        List<CommentResultDto> approves = new ArrayList<CommentResultDto>();
//        Map<String, String> orgs = new HashMap<String, String>();
//        List<EmployeeLogDto> logs = new ArrayList<EmployeeLogDto>();
//        Long parentId = null;
//        HRResultService.getResult(result, userId, addrMap, orgs, approves, logs, parentId);
//        return new ResultDetailVo(result,
//                new EmployeeEntryVo(result.getEmployeeEntryDto(), orgs, parentId, addrMap, approves, logs));
//    }
//
//    // 通过查询员工详细信息接口获取办理入职员工信息
//    private EmployeeEntryVo param(EmployeeEntryDto infoDto, Long userId) {
//        String censusArea = commonService.trans2Address(infoDto.getEmployeeDetailInfo().getCensusProvinceCode(),
//                infoDto.getEmployeeDetailInfo().getCensusCityCode(),
//                infoDto.getEmployeeDetailInfo().getCensusAreaCode());
//        String homeArea = commonService.trans2Address(infoDto.getEmployeeDetailInfo().getHomeProvinceCode(),
//                infoDto.getEmployeeDetailInfo().getHomeCityCode(), infoDto.getEmployeeDetailInfo().getHomeAreaCode());
//        String bankArea = commonService.trans2Address(infoDto.getEmployeeDetailInfo().getBankProvinceCode(),
//                infoDto.getEmployeeDetailInfo().getBankCityCode());
//        List<OrgDto> orgDtos = new ArrayList<OrgDto>();
//        String orgName = WMSConstants.EMPTY;
//        Long positionId = infoDto.getEmployeeDto().getPositionId();
//        orgDtos = commonService.queryPowerOrgsByPositionId(positionId, userId);
//        for (OrgDto orgDot : orgDtos) {
//            if (Assert.equals(orgDot.getOrgId(), infoDto.getEmployeeDto().getOrgId())) {
//                orgName = orgDot.getOrgGroupName();
//            }
//        }
//        return new EmployeeEntryVo(infoDto, orgName, censusArea, homeArea, bankArea);
//
//    }
//
//    // 入职管理和在职管理查询条件vo转dto
//    private EmployeeListQueryDto convertQuery(String biz, HRParamVo param, Long userId, DataTableObj dTable) {
//        LOG.info("**convertQuery() biz:{},userId:{},param:{}**", biz, userId, param);
//        EmployeeListQueryDto queryDto = new EmployeeListQueryDto();
//        Pagination page = WebCommonUtil.initPage(dTable);
//        queryDto.setPagination(page);
//        BeanUtils.copyProperties(param, queryDto);
//        queryDto.setEmployeeNo(Assert.checkParam(param.getEmployeeNo()) ? param.getEmployeeNo() : null);
//        queryDto.setMobilePhone(Assert.checkParam(param.getMobilePhone()) ? param.getMobilePhone() : null);
//        queryDto.setName(Assert.checkParam(param.getName()) ? param.getName() : null);
//        queryDto.setPositionId(!Assert.checkParam(queryDto.getPositionId()) ? null : queryDto.getPositionId());
//        queryDto.setJobCategory(!Assert.checkParam(queryDto.getJobCategory()) ? null : queryDto.getJobCategory());
//        // 请选择时，value为-1，如果-1传送过去，人事系统数据库查询不到数据，工作性质和岗位为查询页面共用
//        // page，userId，app，pageType,状态为必传
//        queryDto.setApp(WMSConstants.WMS);
//        queryDto.setUserId(userId);
//        // 1表示升序，2表示降序，orderParam表示根据什么参数排列
//        queryDto.setOrderType(1);
//        queryDto.setOrderParam("entry_date");
//        List<String> dataStatusList = new ArrayList<String>();
//        return getQueryDto(biz, queryDto, param, dataStatusList);
//    }
//
//    private EmployeeListQueryDto getQueryDto(String biz, EmployeeListQueryDto queryDto, HRParamVo param,
//            List<String> dataStatusList) {
//        switch (biz) {
//            // 入职管理员工信息查询
//            case "entry":
//                return getEmployeeEntry(queryDto, param, dataStatusList);
//            // 人员信息查询
//            case "list":
//                return getEmployeeList(queryDto, param, dataStatusList);
//            case "inService":
//                queryDto.setPageType(3);
//                return getInServiceEmployee(queryDto, param);
//            case "move_approve_list":
//                queryDto.setPageType(6);
//                return getInServiceEmployee(queryDto, param);
//            case "approveLog":
//                queryDto.setPageType(4);
//                queryDto.setDataStatusList(null);
//                break;
//        }
//        return queryDto;
//    }
//
//    // 入职管理员工信息查询
//    private EmployeeListQueryDto getEmployeeEntry(EmployeeListQueryDto dto, HRParamVo param,
//            List<String> dataStatusList) {
//        // 如果是入职管理页面传2
//        dto.setPageType(PageType.RZ_GL.getCode());
//        // 入职页面传A表示预入职R表示拒绝入职必传
//        dataStatusList.add(EmployeeStatus.PLAN_ENTRY.getCode());
//        dataStatusList.add(EmployeeStatus.REFUSE.getCode());
//        dto.setDataStatusList(dataStatusList);
//        // 按照计划入职日期升序排序
//        dto.setOrderParam("planned_entry_date");
//        return dto;
//    }
//
//    // 人员信息查询条件vo转dto
//    private EmployeeListQueryDto getEmployeeList(EmployeeListQueryDto dto, HRParamVo param,
//            List<String> dataStatusList) {
//        if (Assert.equals(param.getFormStatus(), "-1")) {
//            dataStatusList.add(EmployeeStatus.ON_JOB.getCode());
//            dataStatusList.add(EmployeeStatus.QUIT.getCode());
//        } else {
//            dataStatusList.add(param.getFormStatus());
//        }
//        dto.setDataStatusList(dataStatusList);
//        // 1表示升序，2表示降序，orderParam表示根据什么参数排列
//        dto.setPageType(PageType.RY_XXCX.getCode());
//        return dto;
//    }
//
//    // 在职信息
//    private EmployeeListQueryDto getInServiceEmployee(EmployeeListQueryDto dto, HRParamVo param) {
//        List<String> dataStatusList = new ArrayList<String>();
//        // E为必传
//        dataStatusList.add(EmployeeStatus.ON_JOB.getCode());
//        dto.setDataStatusList(dataStatusList);
//        return dto;
//    }
//
//    // 人员信息，入职，在职查询数据
//    PaginationResult<List<EmployeeListResultDto>> getResults(String biz, HRParamVo param, Long userId,
//            DataTableObj dTable) {
//        EmployeeListQueryDto dto = convertQuery(biz, param, userId, dTable);
//        switch (biz) {
//            case "list":
//                return commonService.queryEmployeeInfoByCondition(dto);
//            case "entry":
//            case "inService":
//            case "approveLog":
//                return commonService.queryEmployeeListByCondition(dto);
//        }
//        return new PaginationResult<List<EmployeeListResultDto>>(new ArrayList<EmployeeListResultDto>(),
//                dto.getPagination());
//    }
//
//    // 人员信息dto转vo
//    PaginationResult<List<ResultHRVo>> convertResults(PaginationResult<List<EmployeeListResultDto>> dtos, Long userId) {
//        List<ResultHRVo> results = new ArrayList<ResultHRVo>();
//        for (int i = 0; i < dtos.getR().size(); i++) {
//            results.add(new ResultHRVo(dtos.getR().get(i), commonService.putAllPositionDtos(),
//                    commonService.getMyOrgs(), getParentId(dtos.getR().get(i))));
//        }
//        return new PaginationResult<List<ResultHRVo>>(results, dtos.getPagination());
//    }
//
//    // 岗位职务父节点有大团，获取父id,满足条件的传值
//    private Long getParentId(EmployeeListResultDto dto) {
//        OrgDto orgDto = commonService.queryOrgByOrgId(dto.getOrgId());
//        Long parentId = orgDto.getParentId();
//        if (!Assert.checkParam(parentId)) {
//            return -1L;
//        }
//        orgDto = commonService.queryOrgByOrgId(parentId);
//        if (!orgDto.getOrgName().startsWith("Cluster")) {
//            return -1L;
//        }
//        return parentId;
//    }
//
//    // 根据登录角色获取不同角色发起的流程
//    PositionProcess getProcess(Long userId) {
//        List<RoleVo> roles = commonService.findRolesByUserId(userId);
//        if (commonService.hasRoleExist(roles, RoleConstant.YYBJLZL)) {
//            return PositionProcess.DEPARTMENT_ASSISTANT;
//        } else if (commonService.hasRoleExist(roles, RoleConstant.YYBJL)) {
//            return PositionProcess.DEPARTMENT_MANAGER;
//        } else if (commonService.hasRoleExist(roles, RoleConstant.FGSJL)) {
//            return PositionProcess.BRANCH_MANAGER;
//        } else if (commonService.hasRoleExist(roles, RoleConstant.QYJL)) {
//            return PositionProcess.AREA_MANAGER;
//        } else if (commonService.hasRoleExist(roles, RoleConstant.RSZG)) {
//            return PositionProcess.HR_LEADER;
//        } else {
//            return null;
//        }
//    }
//
//    // 根据岗位查询其级别
//    @RequestMapping("/queryLevel.json")
//    @ResponseBody
//    public List<LevelDto> queryLevel(Long positionId) {
//        LOG.info("**queryLevel() orgId:{}**", positionId);
//        return commonService.queryLevelsByPositionId(positionId);
//    }
//
//    // 根据岗位获取组织
//    @RequestMapping("/queryDepart.json")
//    @ResponseBody
//    public List<OrgDto> query(Long positionId) {
//        return commonService.queryOrgsByPositionId(positionId);
//    }
//
//    // 组织树
//    @RequestMapping(value = "treevalue.json")
//    @ResponseBody
//    public List<OrgDto> treevalue(HttpServletRequest request) {
//        return commonService.queryOrgListByUserId(commonService.getUserId(request));
//    }
//
//    // 预入职根据岗位和登录人权限获取组织
//    @RequestMapping("/queryOrg.json")
//    @ResponseBody
//    public List<OrgDto> queryOrg(Long positionId, HttpServletRequest request) {
//        return commonService.queryPowerOrgsByPositionId(positionId, commonService.getUserId(request));
//    }
//    
//    // 部门总称  
//    public void getOrgFullName(ModelMap model, ResultDetailVo resultDetailVo){
//    String orgFullName = "";
//    Long orgId = resultDetailVo.getEmployeeEntryDto().getEmployeeDto().getOrgId();
//    while (orgId != null) {  
//        OrgRequestDto rdto = new OrgRequestDto();
//        rdto.setOrgId(orgId);
//        OrgDto oDto = orgService.queryOrgByCondition(rdto);
//        orgFullName = oDto.getOrgName()+"/"+orgFullName;
//        orgId = oDto.getParentId();
//    }
//    String orgFullName1 = orgFullName.substring(orgFullName.indexOf("/")+1, orgFullName.lastIndexOf("/"));
//    String orgFullName2 = orgFullName1.substring(orgFullName.indexOf("/")+1);
//    resultDetailVo.getEmployeeEntryVo().getEmployeeVo().setOrgName(orgFullName2);
//    }
//    
//    protected Integer insertFile(ContentDto contentDto,Long employeeId,String despath) {
//    	List<EmployeeVideoDto> videoes = new ArrayList<EmployeeVideoDto>();
//         EmployeeVideoDto dto = null;
//         for (FileDto fileDto : contentDto.getFileValidationDto().getFileDtoes()) {
//         dto = new EmployeeVideoDto();
//         dto.setSourceFileName(fileDto.getName());
//         dto.setFileType(fileDto.getType());
//         dto.setSaveFileName(fileDto.getSaveName());
//         dto.setFilePath(StringUtils.remove(fileDto.getSavePath(), despath));
//         videoes.add(dto);
//         }
//         EmployeeEntryDto employeeEntryDto = new EmployeeEntryDto();
//         employeeEntryDto.setEmployeeVideoDtos(videoes);
//         employeeEntryDto.setStep(3);// 保存影像件信息
//         employeeEntryDto.setUserId(contentDto.getFileQueryDto().getUserId());
//         EmployeeDto employeeDto = new EmployeeDto();
//         employeeDto.setEmployeeId(employeeId);
//         employeeEntryDto.setEmployeeDto(employeeDto);
//    	EmployeeEntryResultDTO ret = commonService.saveHrInfo(employeeEntryDto);
//    	return ret.getIsSuccess();
//	}
//    
//    protected String fileNameValidation(Collection<String> fileNames,Long employeeId) {
//    	EmployeeEntryDto detail = commonService.queryEmployeeDetailByEmployeeId(employeeId);
//    	for (int i = 0; i < detail.getEmployeeVideoDtos().size(); i++) {
//			for (String fileName : fileNames) {
//				if(Assert.equals(fileName, detail.getEmployeeVideoDtos().get(i).getSourceFileName())){
//					return "105";
//				}
//			}
//		}
//    	return "201";
//	}
//}
