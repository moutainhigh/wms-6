//package com.dx.op.web.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.impl.cookie.DateUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dx.ccs.service.IAMService;
//import com.dx.ccs.service.flow.IFlowService;
//import com.dx.ccs.service.op.IBlackListService;
//import com.dx.ccs.service.op.dto.BlackListQueryDto;
//import com.dx.ccs.service.op.dto.BlackListResultDto;
//import com.dx.ccs.vo.OrgVo;
//import com.dx.ccs.vo.UserVo;
//import com.dx.cmm.service.intf.IProductService;
//import com.dx.common.service.utils.Assert;
//import com.dx.framework.dal.pagination.Pagination;
//import com.dx.framework.dal.pagination.PaginationResult;
//import com.dx.framework.web.escape.StringEscapeSupportController;
//import com.dx.op.web.vo.BlackListExcelVo;
//import com.dx.op.web.vo.BlackListQueryVo;
//import com.dx.op.web.vo.BlackListResultVo;
//import com.dx.wms.constant.RoleConstant;
//import com.dx.wms.web.page.AjaxDataTableObj;
//import com.dx.wms.web.page.DataTableObj;
//import com.dx.wms.web.util.ExportExcelUtil;
//import com.google.gson.Gson;
//
//@Controller
//@RequestMapping("/blackListOp")
//public class BlackListOpController extends StringEscapeSupportController {
//    /**
//     * 日志组件
//     */
//    private static final Logger LOG = LoggerFactory.getLogger(BlackListOpController.class);
//
//    /**
//     * 导出excel表头
//     */
//    private final String[] EXCEL_HEAD = { "借贷部", "区域", "营业部", "交单日期", "客户姓名", "身份证号码", "贷款种类", "申请额度", "审核人员", "业务团队",
//            "客户经理", "备注", "拒绝理由", "是否欺诈" };
//
//    /**
//     * 权限服务
//     */
//    @Autowired
//    private IAMService amService;
//
//    @Autowired
//    private IBlackListService blacklistService;
//
//    @Autowired
//    private IFlowService flowService;
//    /**
//     * 产品服务
//     */
//    @Autowired
//    private IProductService productService;
//
//    @RequestMapping(value = "/list.htm")
//    public String initPage(ModelMap model, HttpServletRequest request) {
//
//        // 营业部
//        List<OrgVo> orgVos = amService.queryAllSubCompanyOrgs();
//        Map<String, String> orgView = new LinkedHashMap<String, String>();
//        if (orgVos != null && orgVos.size() > 0) {
//            for (OrgVo orgVo : orgVos) {
//                orgView.put(orgVo.getOrgId().toString(), orgVo.getName());
//            }
//        }
//        model.addAttribute("orgs", orgView);
//
//        // 申请产品类型
//        model.addAttribute("productType", productService.getProductByApp("ccs")); // 产品类型枚举
//
//        return "/operation/black_list/blacklist";
//    }
//
//    @RequestMapping("list_do.json")
//    @ResponseBody
//    public AjaxDataTableObj<BlackListResultVo> listByPage(
//            @ModelAttribute("blackListQueryVo") BlackListQueryVo blackListQueryVo, HttpServletRequest request,
//            DataTableObj dTable) {
//        LOG.info("进入黑名单管理数据请求");
//        Pagination pagination = new Pagination();
//        if (dTable.getCurrentPage() > 0) {
//            pagination.setCurrentPage(dTable.getCurrentPage());
//        }
//        pagination.setPagesize(dTable.getiDisplayLength());
//        LOG.info("pagination{}", new Gson().toJson(pagination));
//        PaginationResult<List<BlackListResultDto>> results = blacklistService.queryByPage(
//                convertQuery(blackListQueryVo), pagination);
//        List<BlackListResultVo> blackListResultVos = convertResults(results.getR());
//        return new AjaxDataTableObj<BlackListResultVo>(dTable.getsEcho(),
//                new PaginationResult<List<BlackListResultVo>>(blackListResultVos, pagination));
//    }
//
//    private BlackListQueryDto convertQuery(BlackListQueryVo blackListQueryVo) {
//        BlackListQueryDto blackListQueryDto = new BlackListQueryDto();
//        blackListQueryDto.setName(blackListQueryVo.getName());
//        blackListQueryDto.setIdCard(blackListQueryVo.getIdCard());
//        blackListQueryDto.setSalesDepartment(blackListQueryVo.getSalesDepartment());
//        blackListQueryDto.setCustomerManagerId(blackListQueryVo.getCustomerManagerId());
//        blackListQueryDto.setProdType(blackListQueryVo.getProdType());
//        blackListQueryDto.setApplyTimeBegin(blackListQueryVo.getApplyTimeBegin());
//        blackListQueryDto.setApplyTimeEnd(blackListQueryVo.getApplyTimeEnd());
//        if (blackListQueryVo.getApplyTimeBegin() == null && blackListQueryVo.getApplyTimeEnd() == null
//                && blackListQueryVo.getProdType() == null && blackListQueryVo.getSalesDepartment() == null
//                && StringUtils.isBlank(blackListQueryVo.getCustomerManagerId())
//                && StringUtils.isBlank(blackListQueryVo.getName()) && StringUtils.isBlank(blackListQueryVo.getIdCard())) {
//            blackListQueryDto.setApplyTimeBegin(new Date());
//            blackListQueryDto.setApplyTimeEnd(new Date());
//        }
//        return blackListQueryDto;
//    }
//
//    private List<BlackListResultVo> convertResults(List<BlackListResultDto> dtos) {
//        List<BlackListResultVo> results = new ArrayList<BlackListResultVo>();
//        if (dtos != null && dtos.size() > 0) {
//            Map<String, String> products = productService.getProductByApp("ccs");
//            for (BlackListResultDto dto : dtos) {
//                BlackListResultVo vo = new BlackListResultVo();
//                vo.setName(dto.getName());
//                vo.setIdCard(dto.getIdCard());
//                // 客服
//                String customerUserId = dto.getCreater();
//                if (StringUtils.isNotBlank(customerUserId)) {
//                    UserVo manager = amService.queryUserById(Long.valueOf(customerUserId));
//                    vo.setCustomerUser(manager.getName());
//                }
//                // 质检
//                Long serviceQualityUserId = flowService.queryByParam(dto.getLoanApplyId(), 1).getUserId();
//                if (Assert.checkParam(serviceQualityUserId)) {
//                    UserVo manager = amService.queryUserById(serviceQualityUserId);
//                    vo.setServiceQualityUser(manager.getName());
//                }
//                // 初审
//                Long loanStartUserId = flowService.queryByParam(dto.getLoanApplyId(), 2).getUserId();
//                if (Assert.checkParam(loanStartUserId)) {
//                    UserVo manager = amService.queryUserById(loanStartUserId);
//                    vo.setLoanStartUser(manager.getName());
//                }
//                // 终审
//                Long loanFinalUserId = flowService.queryByParam(dto.getLoanApplyId(), 3).getUserId();
//                if (Assert.checkParam(loanFinalUserId)) {
//                    UserVo manager = amService.queryUserById(loanFinalUserId);
//                    vo.setLoanFinalUser(manager.getName());
//                }
//
//                vo.setApplyAmount(dto.getApplyAmount());
//                vo.setRefuseReason(dto.getRefuseReason());
//                vo.setApplyTime(DateUtils.formatDate(dto.getApplyTime(), ""));
//                vo.setAreaInfo("");
//                String managerId = dto.getCustomerManagerId();
//                vo.setCustomerManagerId(managerId);
//                if (StringUtils.isNotBlank(managerId)) {
//                    UserVo manager = amService.queryUserById(Long.valueOf(managerId));
//                    vo.setCustomerManagerInfo(manager == null ? "" : manager.getName());
//                    OrgVo team = amService.queryOrgByUserId(Long.valueOf(managerId));
//                    if (team != null) {
//                        vo.setTeam(team.getOrgId());
//                        vo.setTeamInfo(team.getName());
//                        List<UserVo> teamManagers = amService.queryUserByOrgAndRole(team.getOrgId(),
//                                RoleConstant.CCS_YWZR);
//                        if (teamManagers != null && teamManagers.size() > 0) {
//                            for (UserVo teamManager : teamManagers) {
//                                vo.setTeamManager(teamManager.getUserId());
//                                vo.setTeamManagerInfo(teamManager.getName());
//                                break;
//                            }
//                        }
//                    }
//
//                }
//
//                vo.setLoanDepartmentInfo("");
//
//                Integer prodType = dto.getProdType();
//                if (prodType != null) {
//                    vo.setProdTypeInfo(products.get(prodType.toString()));
//                }
//
//                // 审批产品类型
//                if (dto.getApproveProdType() != null) {
//                    vo.setApproveProdType(products.get(dto.getApproveProdType()));
//                }
//
//                Long salesDepartmentId = dto.getSalesDepartment();
//                vo.setSalesDepartment(salesDepartmentId);
//                vo.setLoanDepartment(salesDepartmentId);
//                if (salesDepartmentId != null) {
//                    OrgVo salesDepartment = amService.queryOrgById(salesDepartmentId);
//                    vo.setSalesDepartmentInfo(salesDepartment == null ? "" : salesDepartment.getName());
//                    vo.setLoanDepartmentInfo(salesDepartment == null ? "" : salesDepartment.getName());
//                }
//                String remark = dto.getRemark();
//                // blackListResultVo.setRemark(remark);
//                if (remark != null) {
//                    vo.setRemark(remark);
//                }
//                String refuseReason = dto.getApproveContentFirst() + ", " + dto.getApproveContentSecond();
//                if (refuseReason != null) {
//                    vo.setRefuseReason(refuseReason);
//                    ;
//                }
//                results.add(vo);
//                String cheat = dto.getCheat();
//                vo.setCheat(cheat);
//            }
//        }
//        return results;
//    }
//
//    private List<BlackListExcelVo> convertExcel(List<BlackListResultDto> dtos) {
//        List<BlackListExcelVo> results = new ArrayList<BlackListExcelVo>();
//        if (dtos != null && dtos.size() > 0) {
//            Map<String, String> products = productService.getProductByApp("ccs");
//            for (BlackListResultDto dto : dtos) {
//                BlackListExcelVo vo = new BlackListExcelVo();
//                vo.setApplyAmount(dto.getApplyAmount());
//                vo.setRemark(dto.getRemark());
//                vo.setApplyTime(DateUtils.formatDate(dto.getApplyTime(), ""));
//                vo.setAreaInfo("");
//
//                String managerId = dto.getCustomerManagerId();
//                if (StringUtils.isNotBlank(managerId)) {
//                    UserVo manager = amService.queryUserById(Long.valueOf(managerId));
//                    vo.setCustomerManagerInfo(manager == null ? "" : manager.getName());
//                    OrgVo team = amService.queryOrgByUserId(Long.valueOf(managerId));
//                    if (team != null) {
//                        vo.setTeamInfo(team.getName());
//                    }
//                }
//
//                String refuseReason = dto.getApproveContentFirst() + ", " + dto.getApproveContentSecond();
//                if (refuseReason != null) {
//                    vo.setRefuseReason(refuseReason);
//                }
//                vo.setIdCard(dto.getIdCard());
//
//                vo.setName(dto.getName());
//
//                if (dto.getProdTypeInfo() != null) {
//                    vo.setProdTypeInfo(dto.getProdTypeInfo());
//                }
//
//                Integer prodType = dto.getProdType();
//                if (prodType != null) {
//                    vo.setProdTypeInfo(products.get(prodType.toString()));
//                }
//                Long salesDepartmentId = dto.getSalesDepartment();
//                if (salesDepartmentId != null) {
//                    OrgVo salesDepartment = amService.queryOrgById(salesDepartmentId);
//                    vo.setSalesDepartmentInfo(salesDepartment == null ? "" : salesDepartment.getName());
//                    vo.setLoanDepartmentInfo(salesDepartment == null ? "" : salesDepartment.getName());
//                }
//                results.add(vo);
//            }
//        }
//        return results;
//    }
//
//    /**
//     * 
//     * Excel导出
//     *
//     * @param taskId
//     * @param request
//     * @return
//     * @see [相关类/方法](可选)
//     * @since [产品/模块版本](可选)
//     */
//    @RequestMapping("excelExoprt.json")
//    public void excelExoprt(HttpServletRequest request, HttpServletResponse response) {
//        BlackListQueryDto blackListQueryDto = new BlackListQueryDto();
//        String name = request.getParameter("custName");
//        String idCard = request.getParameter("custIdcard");
//        String salesDepartment = request.getParameter("salesDepartment");
//        String customerManagerId = request.getParameter("customerManagerId");
//        String prodType = request.getParameter("prodType");
//        String applyTimeBegin = request.getParameter("applyTimeBegin");
//        String applyTimeEnd = request.getParameter("applyTimeEnd");
//        if (StringUtils.isNotBlank(name)) {
//            try {
//                blackListQueryDto.setName(URLDecoder.decode(name, "UTF-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//        if (StringUtils.isNotBlank(idCard)) {
//            blackListQueryDto.setIdCard(idCard);
//        }
//        if (StringUtils.isNotBlank(salesDepartment)) {
//            blackListQueryDto.setSalesDepartment(Long.valueOf(salesDepartment));
//        }
//        if (StringUtils.isNotBlank(customerManagerId)) {
//            blackListQueryDto.setCustomerManagerId(customerManagerId);
//        }
//        if (StringUtils.isNotBlank(prodType)) {
//            blackListQueryDto.setProdType(Integer.valueOf(prodType));
//        }
//
//        if (StringUtils.isBlank(name) && StringUtils.isBlank(idCard) && StringUtils.isBlank(salesDepartment)
//                && StringUtils.isBlank(customerManagerId) && StringUtils.isBlank(prodType)
//                && StringUtils.isBlank(applyTimeBegin) && StringUtils.isBlank(applyTimeEnd)) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String startTime = sdf.format(new Date());
//            blackListQueryDto.setApplyTimeBeginStr(startTime);
//            blackListQueryDto.setApplyTimeEndStr(startTime);
//        }
//        List<BlackListResultDto> results = blacklistService.exportReport(blackListQueryDto);
//        ExportExcelUtil.excelExoprt(EXCEL_HEAD, null, convertExcel(results), null, "黑名单管理", response, "yyyy-mm-dd");
//
//    }
//}
