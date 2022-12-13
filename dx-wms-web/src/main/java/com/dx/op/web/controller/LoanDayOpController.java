//package com.dx.op.web.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.InvocationTargetException;
//import java.math.BigDecimal;
//import java.net.URLDecoder;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
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
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dx.ccs.bean.ProductType;
//import com.dx.ccs.dto.ProductTypeQueryDto;
//import com.dx.ccs.dto.operation.OperationByDayQueryDto;
//import com.dx.ccs.dto.operation.OperationByDayResultDto;
//import com.dx.ccs.enums.PeriodInfo;
//import com.dx.ccs.enums.ProjectPeriod;
//import com.dx.ccs.enums.Purpose;
//import com.dx.ccs.enums.WorkSituation;
//import com.dx.ccs.service.IProductTypeService;
//import com.dx.ccs.service.intf.ICommonService;
//import com.dx.ccs.service.operation.IOperationService;
//import com.dx.ccs.service.util.RepayDeadlineCount;
//import com.dx.ccs.util.CalculatorUtil;
//import com.dx.ccs.util.DateUtil;
//import com.dx.ccs.web.page.AjaxDataTableObj;
//import com.dx.ccs.web.page.DataTableObj;
//import com.dx.ccs.web.util.ExportExcelUtil;
//import com.dx.common.dto.CalculatorDto;
//import com.dx.common.service.utils.AmountUtils;
//import com.dx.common.service.utils.CalculatorUtils;
//import com.dx.common.service.utils.DateUtils;
//import com.dx.framework.dal.pagination.Pagination;
//import com.dx.framework.dal.pagination.PaginationResult;
//import com.dx.op.web.vo.LoanDayExcelVo;
//import com.dx.op.web.vo.LoanDayQueryVo;
//import com.dx.op.web.vo.LoanDayResultVo;
//import com.google.gson.Gson;
//
///**
// * 
// * 〈一句话功能简述〉<br>
// * 〈功能详细描述〉
// *
// * @author tonys
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Controller
//@RequestMapping("/loanDayOp")
//public class LoanDayOpController {
//    /**
//     * 日志组件
//     */
//    private static final Logger LOG = LoggerFactory.getLogger(LoanDetailOpController.class);
//
//    /**
//     * 导出excel表头
//     */
//    private final String[] EXCEL_HEAD = { "借款人", "身份证号", "初始借款金额", "本次转让债权价值", "需支付对价", "借款职业情况", "借款用途", "还款起始月",
//            "还款期限（月）", "剩余还款月数", "预计债权收益率（年）", "审批产品类型", "每期还款", "还款起止日", "划拨金额", "月利率", "还款日", "签约日期", "职业原始" };
//
//    @Autowired
//    private ICommonService commonService;
//
//    @Autowired
//    private IOperationService operationService;
//
//    @Autowired
//    private IProductTypeService productTypeService;
//
//    @RequestMapping(value = "/list.htm")
//    public String initPage(ModelMap model, HttpServletRequest request) {
//        // 营业部
//        model.addAttribute("orgs", commonService.queryAllSubCompanyOrgs());
//        // 审批产品类型
//        model.addAttribute("productType", productTypeService.getProductView()); // 产品类型枚举
//        return "/operation/loan_day/list";
//    }
//
//    @RequestMapping("list_do.json")
//    @ResponseBody
//    public AjaxDataTableObj<LoanDayResultVo> listByPage(
//            @ModelAttribute("loanDayQueryVo") LoanDayQueryVo loanDayQueryVo, HttpServletRequest request,
//            DataTableObj dTable) {
//        Pagination pagination = new Pagination();
//        if (dTable.getCurrentPage() > 0) {
//            pagination.setCurrentPage(dTable.getCurrentPage());
//        }
//        pagination.setPagesize(dTable.getiDisplayLength());
//        LOG.info("pagination{}", new Gson().toJson(pagination));
//        PaginationResult<List<OperationByDayResultDto>> results = operationService.queryByPageForLoanDay(
//                convertQuery(loanDayQueryVo), pagination);
//        List<LoanDayResultVo> loanDayResultVo = convertResults(results.getR());
//
//        return new AjaxDataTableObj<LoanDayResultVo>(dTable.getsEcho(), new PaginationResult<List<LoanDayResultVo>>(
//                loanDayResultVo, pagination));
//    }
//
//    private OperationByDayQueryDto convertQuery(LoanDayQueryVo queryVo) {
//        OperationByDayQueryDto queryDto = new OperationByDayQueryDto();
//        queryDto.setSalesDepartment(queryVo.getSalesDepartment());
//        queryDto.setCustomerManagerId(queryVo.getCustomerManagerId());
//        queryDto.setProdType(queryVo.getProdType());
//        queryDto.setRepaymentDay(queryVo.getRepaymentDay());
//        queryDto.setIdCard(queryVo.getIdCard());
//        queryDto.setLoanPayTimeBegin(queryVo.getLoanPayTimeBegin());
//        queryDto.setLoanPayTimeEnd(queryVo.getLoanPayTimeEnd());
//        queryDto.setName(queryVo.getName());
//        if (queryVo.getLoanPayTimeBegin() == null && queryVo.getLoanPayTimeEnd() == null
//                && queryVo.getProdType() == null && queryVo.getSalesDepartment() == null
//                && StringUtils.isBlank(queryVo.getCustomerManagerId()) && queryVo.getRepaymentDay() == null
//                && StringUtils.isBlank(queryVo.getIdCard()) && StringUtils.isBlank(queryVo.getName())) {
//            queryDto.setLoanPayTimeBegin(new Date());
//            queryDto.setLoanPayTimeEnd(new Date());
//        }
//        return queryDto;
//    }
//
//    private CalculatorDto getCalculatorDto(OperationByDayResultDto dto, Map<String, BigDecimal> rates) {
//        CalculatorDto calculatorDto = new CalculatorDto();
//        if (dto.getApproveAmount() != null && dto.getApproveDeadline() != null) {
//            BigDecimal amount = dto.getApproveAmount();
//            Integer approveDeadline = PeriodInfo.getInfo(dto.getApproveDeadline());
//            BigDecimal rate = productTypeService.getRate(dto.getLoanApplyId(), rates, "L");
//            LOG.info("getCalculatorDto() loanApplyId:{} , amount:{} , approveDeadline:{} , rate:{}",
//                    dto.getLoanApplyId(), amount, approveDeadline, rate);
//            calculatorDto = CalculatorUtils.calculate(amount, approveDeadline, rate);
//        }
//        return calculatorDto;
//    }
//
//    private List<LoanDayResultVo> convertResults(List<OperationByDayResultDto> dtos) {
//        List<LoanDayResultVo> results = new ArrayList<LoanDayResultVo>();
//        if (dtos != null && dtos.size() > 0) {
//            Map<String, String> products = productTypeService.getProductView(true);
//            Map<String, BigDecimal> rates = productTypeService.getProductRate();
//            try {
//                for (OperationByDayResultDto dto : dtos) {
//                    LoanDayResultVo vo = new LoanDayResultVo();
//                    CalculatorDto calculatorDto = getCalculatorDto(dto, rates);
//                    PropertyUtils.copyProperties(vo, dto);
//                    vo.setProfessionStatusInfo(dto.getProfessionStatus() != null ? WorkSituation.getInfo(dto
//                            .getProfessionStatus()) : "-");
//                    // 借款用途
//                    vo.setLoanTypeInfo(Purpose.getInfoAd(dto.getLoanType()));
//                    // 首次还款日
//                    vo.setRefundFirstTimeInfo(DateUtils.formatForDay(dto.getRefundFirstTime(), "-"));
//                    // 还款期限（月）
//                    vo.setApproveDeadlineInfo(dto.getApproveDeadline() != null
//                            && Integer.compare(dto.getApproveDeadline(), 0) >= 0 ? PeriodInfo.getInfo(
//                            dto.getApproveDeadline()).toString() : "-");
//                    Integer overplusDeadline = PeriodInfo.getInfo(dto.getApproveDeadline())
//                            - RepayDeadlineCount.getRepayDeadlineCount(DateUtils.formatForDay(dto.getRefundFirstTime(),
//                                    ""));
//                    vo.setOverplusDeadline(overplusDeadline.toString());
//                    vo.setContractAmountInfo(AmountUtils.format(dto.getContractAmount(), "-"));
//                    vo.setPayAmountInfo(AmountUtils.format(dto.getContractAmount(), "-"));
//                    vo.setCreditorValueInfo(AmountUtils.format(dto.getContractAmount(), "-"));
//                    // 预计债权年收益率
//                    double a1 = 1;
//                    double a2 = CalculatorUtil.add(a1, calculatorDto.getRealRate());
//                    double pow = CalculatorUtil.sub(CalculatorUtil.power(a2, 12), a1);
//                    vo.setPow(pow + "");
//                    // 月利率
//                    vo.setRealRate(calculatorDto.getRealRate() + "");
//                    Integer eliteItem = 0;
//                    ProductTypeQueryDto productTypeQueryDto = new ProductTypeQueryDto();
//                    productTypeQueryDto.setLoanApplyId(dto.getLoanApplyId());
//                    productTypeQueryDto.setOperateProcess("L");
//                    List<ProductType> productTypes = productTypeService.queryByParam(productTypeQueryDto);
//                    for (ProductType productTypeI : productTypes) {
//                        if (!productTypeI.getLastProductType().equals(Long.valueOf(0))) {
//                            eliteItem = Integer.valueOf(productTypeI.getProductType());
//                        }
//                    }
//
//                    // 审批产品类型
//                    if (dto.getApproveProdType() != null) {
//                        if (dto.getApproveProdType().equals(1) && !eliteItem.equals(0)) {
//                            vo.setApproveProdTypeInfo(products.get(eliteItem.toString()));
//                        } else {
//                            vo.setApproveProdTypeInfo(products.get(dto.getApproveProdType().toString()));
//
//                        }
//                    }
//                    // 还款起止日
//                    if (dto.getRefundFirstTime() != null && dto.getApproveDeadline() != null) {
//                        vo.setRefundLastTime(DateUtils.formatForDay(dto.getRefundFirstTime(), "")
//                                + "至"
//                                + CalculatorUtils.getEndBackDay(DateUtils.formatForDay(dto.getRefundFirstTime(), ""),
//                                        PeriodInfo.getInfo(dto.getApproveDeadline())));
//                    }
//                    // 签约日期
//                    vo.setSignTimeInfo(DateUtils.formatForFull(dto.getSignTime(), "-"));
//                    // 月偿还本息数额
//                    vo.setBackMoneyPer(AmountUtils.format(new BigDecimal(calculatorDto.getBackMoneyPer()), "-"));
//                    vo.setLoanAmountInfo(AmountUtils.format(dto.getLoanAmount(), "-"));
//                    results.add(vo);
//                }
//            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//                LOG.error("error:{}", e.getMessage());
//            }
//        }
//        return results;
//    }
//
//    /**
//     * 
//     * 查询总计金额
//     *
//     * @param queryLoanApplyVo
//     * @param request
//     * @param dTable
//     * @return
//     * @see [相关类/方法](可选)
//     * @since [产品/模块版本](可选)
//     */
//    @RequestMapping("total.json")
//    @ResponseBody
//    public Map<String, Object> total(@RequestBody OperationByDayQueryDto operatiionByDayQueryDto) {
//        return operationService.queryByPageForLoanDayTotal(operatiionByDayQueryDto);
//    }
//
//    private List<LoanDayExcelVo> convertExcel(List<OperationByDayResultDto> dtos) {
//        List<LoanDayExcelVo> results = new ArrayList<LoanDayExcelVo>();
//        if (dtos != null && dtos.size() > 0) {
//            Map<String, String> products = productTypeService.getProductView(true);
//            Map<String, BigDecimal> rates = productTypeService.getProductRate();
//            for (OperationByDayResultDto dto : dtos) {
//                CalculatorDto calculatorDto = getCalculatorDto(dto, rates);
//                LoanDayExcelVo vo = new LoanDayExcelVo();
//                // 姓名
//                vo.setName(dto.getName());
//                // 证件号码
//                vo.setIdCard(dto.getIdCard());
//                // 初始借款金额应为合同金额
//                vo.setContractAmount(dto.getContractAmount());
//                // 本次转让债权价值
//                vo.setCreditorValue(dto.getContractAmount());
//                // 需支付对价
//                vo.setPayAmount(dto.getContractAmount());
//                // 借款职业情况
//                Integer professionStatus = dto.getProfessionStatus();
//                if (professionStatus != null) {
//                    vo.setProfessionStatusInfo(WorkSituation.getInfo(professionStatus));
//                }
//                // 借款用途
//                Integer loanType = dto.getLoanType();
//                if (loanType != null) {
//                    if (loanType == 1) {
//                        vo.setLoanTypeInfo("周转");
//                    } else if (loanType == 2) {
//                        vo.setLoanTypeInfo("扩营");
//                    } else if (loanType == 3) {
//                        vo.setLoanTypeInfo("购买");
//                    } else if (loanType == 4) {
//                        vo.setLoanTypeInfo("教育");
//                    } else if (loanType == 5) {
//                        vo.setLoanTypeInfo("装修");
//                    } else if (loanType == 6) {
//                        vo.setLoanTypeInfo("医疗");
//                    } else if (loanType == 7) {
//                        vo.setLoanTypeInfo("旅行");
//                    } else {
//                        vo.setLoanTypeInfo(Purpose.getInfo(loanType));
//                    }
//                }
//                // 首次还款日
//                vo.setRefundFirstTime(DateUtils.formatForDay(dto.getRefundFirstTime(), ""));
//                // 还款期限（月）
//                Integer approveDeadline = dto.getApproveDeadline();
//                if (approveDeadline != null) {
//                    vo.setApproveDeadlineInfo(ProjectPeriod.getInfo(approveDeadline).replace("期", ""));
//                }
//
//                int iApproveDeadline = 0;
//                if (vo.getApproveDeadlineInfo() != null) {
//                    iApproveDeadline = Integer.parseInt(vo.getApproveDeadlineInfo());
//                }
//                // 剩余还款月数
//                int repayDeadlineCount = 0;
//                repayDeadlineCount = RepayDeadlineCount.getRepayDeadlineCount(vo.getRefundFirstTime());
//                int overplusDeadline = iApproveDeadline - repayDeadlineCount;
//                vo.setOverplusDeadline(overplusDeadline + "");
//                // 预计债权年收益率
//                double a1 = 1;
//                double a2 = CalculatorUtil.add(a1, calculatorDto.getRealRate());
//                double pow = CalculatorUtil.sub(CalculatorUtil.power(a2, 12), a1);
//                vo.setPow(pow + "");
//                // 月利率
//                vo.setRealRate(calculatorDto.getRealRate() + "");
//                // 审批产品类型
//                Integer eliteItem = 0;
//                ProductTypeQueryDto productTypeQueryDto = new ProductTypeQueryDto();
//                productTypeQueryDto.setLoanApplyId(dto.getLoanApplyId());
//                productTypeQueryDto.setOperateProcess("L");
//                List<ProductType> productTypes = productTypeService.queryByParam(productTypeQueryDto);
//                for (ProductType productTypeI : productTypes) {
//                    if (!productTypeI.getLastProductType().equals(Long.valueOf(0))) {
//                        eliteItem = Integer.valueOf(productTypeI.getProductType());
//                    }
//                }
//
//                // 审批产品类型
//                if (dto.getApproveProdType() != null) {
//                    if (dto.getApproveProdType().equals(1) && !eliteItem.equals(0)) {
//                        vo.setApproveProdTypeInfo(products.get(eliteItem.toString()));
//                    } else {
//                        vo.setApproveProdTypeInfo(products.get(dto.getApproveProdType().toString()));
//                    }
//                }
//                // 还款起止日
//                if (dto.getRefundFirstTime() != null && approveDeadline != null) {
//                    Integer months = PeriodInfo.getInfo(approveDeadline);
//                    vo.setRefundLastTime(DateUtils.formatForDay(dto.getRefundFirstTime(), "")
//                            + "至"
//                            + CalculatorUtils.getEndBackDay(DateUtils.formatForDay(dto.getRefundFirstTime(), ""),
//                                    months));
//                }
//                // 划款金额（元）
//                vo.setLoanAmount(dto.getLoanAmount());
//                // 还款日
//                vo.setRepaymentDay(dto.getRepaymentDay());
//
//                // 签约日期
//                vo.setSignTime(DateUtils.formatForFull(dto.getSignTime(), ""));
//                // 职业原始
//                vo.setPosition(dto.getPosition());
//
//                // 月偿还本息数额
//                vo.setBackMoneyPer(calculatorDto.getBackMoneyPer());
//
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
//        OperationByDayQueryDto operationByDayQueryDto = new OperationByDayQueryDto();
//        String salesDepartment = request.getParameter("salesDepartment");
//        String customerManagerId = request.getParameter("customerManagerId");
//        String prodType = request.getParameter("prodType");
//        String repaymentDay = request.getParameter("repaymentDay");
//        String idCard = request.getParameter("idCard");
//        String name = request.getParameter("name");
//        String loanPayTimeBegin = request.getParameter("loanPayTimeBegin");
//        String loanPayTimeEnd = request.getParameter("loanPayTimeEnd");
//
//        if (StringUtils.isNotBlank(salesDepartment)) {
//            operationByDayQueryDto.setSalesDepartment(Long.valueOf(salesDepartment));
//        }
//        if (StringUtils.isNotBlank(customerManagerId)) {
//            operationByDayQueryDto.setCustomerManagerId(customerManagerId);
//        }
//        if (StringUtils.isNotBlank(prodType)) {
//            operationByDayQueryDto.setProdType(Integer.valueOf(prodType));
//        }
//        if (StringUtils.isNotBlank(repaymentDay)) {
//            operationByDayQueryDto.setRepaymentDay(Integer.valueOf(repaymentDay));
//        }
//
//        if (StringUtils.isNotBlank(idCard)) {
//            operationByDayQueryDto.setIdCard(idCard);
//        }
//        if (StringUtils.isNotBlank(loanPayTimeBegin)) {
//            try {
//                operationByDayQueryDto.setLoanPayTimeBeginStr(DateUtil.splitDate(URLDecoder.decode(loanPayTimeBegin,
//                        "UTF-8")));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//        if (StringUtils.isNotBlank(loanPayTimeEnd)) {
//            try {
//                operationByDayQueryDto.setLoanPayTimeEndStr(DateUtil.splitDate(URLDecoder.decode(loanPayTimeEnd,
//                        "UTF-8")));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//        if (StringUtils.isNotBlank(name)) {
//            try {
//                operationByDayQueryDto.setName(URLDecoder.decode(name, "UTF-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (StringUtils.isBlank(salesDepartment) && StringUtils.isBlank(customerManagerId)
//                && StringUtils.isBlank(prodType) && StringUtils.isBlank(repaymentDay) && StringUtils.isBlank(idCard)
//                && StringUtils.isBlank(loanPayTimeBegin) && StringUtils.isBlank(loanPayTimeEnd)
//                && StringUtils.isBlank(name)) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String startTime = sdf.format(new Date());
//            operationByDayQueryDto.setLoanPayTimeBeginStr(startTime);
//            operationByDayQueryDto.setLoanPayTimeEndStr(startTime);
//        }
//
//        List<OperationByDayResultDto> results = operationService.createReportForLoanDay(operationByDayQueryDto);
//        ExportExcelUtil.excelExoprt(EXCEL_HEAD, null, convertExcel(results), null, "放款管理（每日）", response, "yyyy-mm-dd");
//
//    }
//}
