//package com.dx.op.web.controller;
//
//import java.lang.reflect.InvocationTargetException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.beanutils.PropertyUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSON;
//import com.dx.ccs.enums.FormStatus;
//import com.dx.ccs.enums.PeriodInfo;
//import com.dx.ccs.enums.Purpose;
//import com.dx.ccs.enums.WorkSituation;
//import com.dx.ccs.service.IAMService;
//import com.dx.ccs.service.flow.IFlowService;
//import com.dx.ccs.service.op.IOperationService;
//import com.dx.ccs.service.op.dto.OpQueryDto;
//import com.dx.ccs.service.op.dto.OpResultDto;
//import com.dx.ccs.vo.OrgVo;
//import com.dx.ccs.vo.UserVo;
//import com.dx.cmm.service.dto.MatchResultDto;
//import com.dx.cmm.service.enums.MatchStatus;
//import com.dx.cmm.service.intf.IProductService;
//import com.dx.cmm.web.vo.MatchResultVo;
//import com.dx.common.service.utils.AmountUtils;
//import com.dx.common.service.utils.DateUtils;
//import com.dx.framework.dal.pagination.Pagination;
//import com.dx.framework.dal.pagination.PaginationResult;
//import com.dx.framework.web.escape.StringEscapeSupportController;
//import com.dx.op.web.vo.LoanApplyExcelVo;
//import com.dx.op.web.vo.ApplyQueryVo;
//import com.dx.op.web.vo.ApplyResultVo;
//import com.dx.wms.constant.RoleConstant;
//import com.dx.wms.service.ICommonService;
//import com.dx.wms.web.page.AjaxDataTableObj;
//import com.dx.wms.web.page.DataTableObj;
//import com.dx.wms.web.util.ExportExcelUtil;
//import com.dx.wms.web.util.WebCommonUtil;
//import com.google.gson.Gson;
//
///**
// * 
// * 〈一句话功能简述〉<br>
// * 〈功能详细描述〉
// *
// * @author tony
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Controller
//@RequestMapping("/loanApplyOp")
//public class LoanApplyOpController extends StringEscapeSupportController {
//    /**
//     * 日志组件
//     */
//    private static final Logger LOG = LoggerFactory.getLogger(LoanApplyOpController.class);
//
//    /**
//     * 导出excel表头
//     */
//    private final String[] EXCEL_HEAD = { "借贷部", "区域", "营业部", "团队", "团队经理", "客户经理", "团队经理工号", "客户经理工号", "客户姓名", "身份证号",
//            "借款职业情况", "借款用途", "申请产品类型", "纸质申请日期", "申请日期", "申请额度", "申请期限", "审批进度" };
//
//    @Autowired
//    private IOperationService operationService;
//
//    @Autowired
//    private IFlowService flowService;
//
//    @Autowired
//    private IProductService productService;
//
//    @Autowired
//    private ICommonService commonService;
//
//    @RequestMapping(value = "/list.htm")
//    public String initPage(ModelMap model, HttpServletRequest request) {
//        UserVo userVo = WebCommonUtil.getSessionUser(request);
//        initModel(model, userVo.getUserId());
//        return "/operation/loan_apply/list";
//    }
//
//    @RequestMapping("list_do.json")
//    @ResponseBody
//    public AjaxDataTableObj<ApplyResultVo> listByPage(
//            @ModelAttribute("loanApplyQueryVo") ApplyQueryVo loanApplyQueryVo, HttpServletRequest request,
//            DataTableObj dTable) {
//        LOG.info("进入借款申请管理数据请求");
//        Pagination pagination = new Pagination();
//        if (dTable.getCurrentPage() > 0) {
//            pagination.setCurrentPage(dTable.getCurrentPage());
//        }
//        pagination.setPagesize(dTable.getiDisplayLength());
//        LOG.info("pagination{}", new Gson().toJson(pagination));
//        PaginationResult<List<OpResultDto>> results = operationService.queryByPageForApply(
//                convertQuery(loanApplyQueryVo), pagination);
//        List<ApplyResultVo> loanApplyResultVos = convert(results.getR());
//        return new AjaxDataTableObj<ApplyResultVo>(dTable.getsEcho(), new PaginationResult<List<ApplyResultVo>>(
//                loanApplyResultVos, pagination));
//    }
//
//    private OpQueryDto convertQuery(ApplyQueryVo queryVo) {
//        LOG.info("loanApplyQueryVo:{}", new Gson().toJson(queryVo));
//        OpQueryDto queryDto = new OpQueryDto();
//        try {
//            PropertyUtils.copyProperties(queryDto, queryVo);
//            queryDto.setSalesDepartmentIds(commonService.querySalesOrgIds(queryVo.getLoanId(), queryVo.getAreaId(),
//                    queryVo.getSalesDepartmentId()));
//            if (queryVo.getCreateTimeBegin() == null && queryVo.getCreateTimeEnd() == null
//                    && queryVo.getProdType() == null && StringUtils.isBlank(queryVo.getCustomerManagerId())) {
//                queryDto.setCreateTimeBegin(new Date());
//                queryDto.setCreateTimeEnd(new Date());
//            }
//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            LOG.error("convert() exception:{}", e.getMessage());
//        }
//        return queryDto;
//    }
//
//    private List<ApplyResultVo> convert(List<OpResultDto> dtos) {
//        List<ApplyResultVo> results = new ArrayList<ApplyResultVo>();
//        Map<String, String> products = productService.getProductByApp("ccs");
//        Map<String, UserVo> userMap = new HashMap<>();
//        Map<Long, UserVo> leadMap = new HashMap<>();
//        Map<Long, OrgVo> orgMap = new HashMap<>();
//        if (dtos != null && dtos.size() > 0) {
//            for (OpResultDto dto : dtos) {
//                ApplyResultVo vo = new ApplyResultVo();
//                vo.setApplyAmount(dto.getApplyAmount());
//                vo.setApplyTime(DateUtils.formatForFull(dto.getApplyTime(), "-"));
//                vo.setCreateTime(DateUtils.formatForFull(dto.getCreateTime(), "-"));
//                String managerId = dto.getCustomerManagerId();
//                vo.setCustomerManagerId(managerId);
//                vo.setCustomerManagerInfo(commonService.queryUserCache(managerId, userMap).getName());
//                vo.setCustomerManagerWorkerNo(commonService.queryUserCache(managerId, userMap).getEmployeeId());
//                vo.setTeam(dto.getTeamId());
//                vo.setTeamInfo(commonService.queryOrgCache(dto.getTeamId(), orgMap).getName());
//                vo.setTeamManagerInfo(commonService.queryLeaderCache(dto.getTeamId(), leadMap).getName());
//                vo.setTeamManagerWorkerNo(commonService.queryLeaderCache(dto.getTeamId(), leadMap).getEmployeeId());
//                vo.setIdCard(dto.getIdCard());
//                Integer loanType = dto.getLoanType();
//                if (loanType != null) {
//                    if (loanType.equals(8)) {
//                        vo.setLoanTypeInfo(Purpose.getInfo(loanType) + "(" + dto.getLoanTypeOther() + ")");
//                    } else {
//                        vo.setLoanTypeInfo(Purpose.getInfo(loanType));
//                    }
//                }
//                vo.setName(dto.getName());
//                Integer prodType = dto.getProdType();
//                vo.setProdType(prodType);
//                if (prodType != null) {
//                    vo.setProdTypeInfo(products.get(prodType.toString()));
//                }
//                Integer professionStatus = dto.getProfessionStatus();
//                vo.setProfessionStatus(professionStatus);
//                if (professionStatus != null) {
//                    vo.setProfessionStatusInfo(WorkSituation.getInfo(professionStatus));
//                }
//                Long salesDepartmentId = dto.getSalesDepartment();
//                vo.setSalesDepartment(salesDepartmentId);
//                vo.setLoanDepartment(salesDepartmentId);
//                vo.setSalesDepartmentInfo(commonService.queryOrgCache(salesDepartmentId, orgMap).getName());
//                vo.setLoanDepartmentInfo(commonService.queryOrgCache(salesDepartmentId, orgMap).getLoanName());
//                vo.setAreaInfo(commonService.queryOrgCache(salesDepartmentId, orgMap).getAreaName());
//                if (dto.getFormStatus() != null) {
//                    vo.setFormStatus(FormStatus.getInfo(dto.getFormStatus()));
//                }
//
//                Integer applyDeadline = dto.getApplyDeadline();
//                if (applyDeadline != null) {
//                    vo.setApplyDeadline(PeriodInfo.getInfo(applyDeadline).toString());
//                }
//                if (dto.getFormStatus() == 12) {
//                    String abandonStart = flowService.queryByParam(dto.getLoanApplyId()).getTaskName();
//                    if (abandonStart.equals("借贷初审")) {
//                        vo.setFormStatus("客户放弃(初审)");
//                    } else if (abandonStart.equals("借贷终审")) {
//                        vo.setFormStatus("客户放弃(终审)");
//                    }
//
//                }
//
//                results.add(vo);
//            }
//        }
//        return results;
//    }
//
//    private List<LoanApplyExcelVo> convertExcel(List<OpResultDto> dtos) {
//        List<LoanApplyExcelVo> results = new ArrayList<LoanApplyExcelVo>();
//        if (null == dtos || dtos.size() == 0) {
//            return results;
//        }
//        Map<String, UserVo> userMap = new HashMap<>();
//        Map<Long, UserVo> leadMap = new HashMap<>();
//        Map<Long, OrgVo> orgMap = new HashMap<>();
//        Map<String, String> products = productService.getProductByApp("ccs");
//        for (OpResultDto dto : dtos) {
//            LoanApplyExcelVo vo = new LoanApplyExcelVo();
//            vo.setApplyAmount(dto.getApplyAmount());
//            vo.setApplyTime(DateUtils.formatForFull(dto.getApplyTime(), ""));
//            vo.setCreateTime(DateUtils.formatForFull(dto.getCreateTime(), ""));
//            String managerId = dto.getCustomerManagerId();
//            vo.setCustomerManagerInfo(commonService.queryUserCache(managerId, userMap).getName());
//            vo.setCustomerManagerWorkerNo(commonService.queryUserCache(managerId, userMap).getEmployeeId());
//            vo.setTeamManagerInfo(commonService.queryLeaderCache(dto.getTeamId(), leadMap).getName());
//            vo.setTeamManagerWorkerNo(commonService.queryLeaderCache(dto.getTeamId(), leadMap).getEmployeeId());
//            vo.setIdCard(dto.getIdCard());
//            Integer loanType = dto.getLoanType();
//            if (loanType != null) {
//                if (loanType.equals(8)) {
//                    vo.setLoanTypeInfo(Purpose.getInfo(loanType) + "(" + dto.getLoanTypeOther() + ")");
//                } else {
//                    vo.setLoanTypeInfo(Purpose.getInfo(loanType));
//                }
//            }
//
//            vo.setName(dto.getName());
//            Integer prodType = dto.getProdType();
//            if (prodType != null) {
//                vo.setProdTypeInfo(products.get(prodType.toString()));
//            }
//            Integer professionStatus = dto.getProfessionStatus();
//            if (professionStatus != null) {
//                vo.setProfessionStatusInfo(WorkSituation.getInfo(professionStatus));
//            }
//            Long salesDepartmentId = dto.getSalesDepartment();
//            vo.setSalesDepartmentInfo(commonService.queryOrgCache(salesDepartmentId, orgMap).getName());
//            vo.setLoanDepartmentInfo(commonService.queryOrgCache(salesDepartmentId, orgMap).getLoanName());
//            vo.setAreaInfo(commonService.queryOrgCache(salesDepartmentId, orgMap).getAreaName());
//
//            if (dto.getFormStatus() != null) {
//                vo.setFormStatus(FormStatus.getInfo(dto.getFormStatus()));
//            }
//            if (dto.getFormStatus() == 12) {
//                String abandonStart = flowService.queryByParam(dto.getLoanApplyId()).getTaskName();
//                if (abandonStart.equals("借贷初审")) {
//                    vo.setFormStatus("客户放弃(初审)");
//                } else if (abandonStart.equals("借贷终审")) {
//                    vo.setFormStatus("客户放弃(终审)");
//                }
//            }
//            Integer applyDeadline = dto.getApplyDeadline();
//            if (applyDeadline != null) {
//                vo.setApplyDeadline(PeriodInfo.getInfo(applyDeadline).toString());
//            }
//            results.add(vo);
//        }
//
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
//        OpQueryDto queryDto = new OpQueryDto();
//        String loan = request.getParameter("loanId");
//        String area = request.getParameter("areaId");
//        String salesDepartment = request.getParameter("salesDepartmentId");
//
//        String customerManagerId = request.getParameter("customerManagerId");
//        String prodType = request.getParameter("prodType");
//        String createTimeBegin = request.getParameter("createTimeBegin");
//        String createTimeEnd = request.getParameter("createTimeEnd");
//        Long loanId = null;
//        Long areaId = null;
//        Long saleId = null;
//        if (StringUtils.isNotBlank(loan)) {
//            loanId = Long.valueOf(loan);
//        }
//        if (StringUtils.isNotBlank(area)) {
//            areaId = Long.valueOf(area);
//        }
//        if (StringUtils.isNotBlank(salesDepartment)) {
//            saleId = Long.valueOf(salesDepartment);
//        }
//        queryDto.setSalesDepartmentIds(commonService.querySalesOrgIds(loanId, areaId, saleId));
//        if (StringUtils.isNotBlank(customerManagerId)) {
//            queryDto.setCustomerManagerId(customerManagerId);
//        }
//        if (StringUtils.isNotBlank(prodType)) {
//            queryDto.setProdType(Integer.valueOf(prodType));
//        }
//
//        if (StringUtils.isBlank(customerManagerId) && StringUtils.isBlank(prodType)
//                && StringUtils.isBlank(createTimeBegin) && StringUtils.isBlank(createTimeEnd)) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String startTime = sdf.format(new Date());
//            queryDto.setCreateTimeBeginStr(startTime);
//            queryDto.setCreateTimeEndStr(startTime);
//        }
//
//        List<OpResultDto> results = operationService.exportReportForApply(queryDto);
//        ExportExcelUtil.excelExoprt(EXCEL_HEAD, null, convertExcel(results), null, "借款申请管理", response, "yyyy-mm-dd");
//
//    }
//
//    private void initModel(ModelMap model, long userId) {
//        OrgVo orgVo = amService.queryOrgCompanyByUserId(userId);
//        model.addAttribute("orgType", orgVo.getOrgType());
//        // 申请产品类型
//        model.addAttribute("productType", productService.getProductByApp("ccs")); // 产品类型枚举
//        // 根据用户所属，确定 借贷部
//        List<OrgVo> loans = new ArrayList<OrgVo>();
//        if (orgVo.getOrgType() == 1) {
//            // 借贷一部
//            OrgVo loan1 = amService.queryOrgByOrgCode(RoleConstant.ORG_JDYB);
//            loans.add(loan1);
//            LOG.info("***loan1:" + loan1.toString());
//            // 借贷二部
//            OrgVo loan2 = amService.queryOrgByOrgCode(RoleConstant.ORG_JDEB);
//            loans.add(loan2);
//            LOG.info("***loan2:" + loan2.toString());
//            model.addAttribute("loans", loans);
//        } else if (orgVo.getOrgType() == 3
//                && (orgVo.getCode().equals(RoleConstant.ORG_JDYB) || orgVo.getCode().equals(RoleConstant.ORG_JDEB))) {
//            OrgVo loan = amService.queryOrgByOrgCode(orgVo.getCode());
//            loans.add(loan);
//            model.addAttribute("loanOnly", true);
//            model.addAttribute("loans", loans);
//
//        } else if (orgVo.getOrgType() == 2) {
//            List<OrgVo> areas = new ArrayList<OrgVo>();
//            List<OrgVo> sales = new ArrayList<OrgVo>();
//            OrgVo loan = amService.queryOrgById(orgVo.getLoanId());
//            loans.add(loan);
//            OrgVo area = amService.queryOrgById(orgVo.getAreaId());
//            areas.add(area);
//            OrgVo sale = amService.queryOrgById(orgVo.getOrgId());
//            sales.add(sale);
//            model.addAttribute("loanOnly", true);
//            model.addAttribute("loans", loans);
//            model.addAttribute("areaOnly", true);
//            model.addAttribute("areas", areas);
//            model.addAttribute("saleOnly", true);
//            model.addAttribute("sales", sales);
//        }
//
//    }
//}
