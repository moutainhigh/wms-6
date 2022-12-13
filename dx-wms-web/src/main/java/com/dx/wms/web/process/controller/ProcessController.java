package com.dx.wms.web.process.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.fms.service.dto.BankInfoDTO;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.bean.PostCode;
import com.dx.wms.cla.web.vo.LogResultVo;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.apply.ICustLenderApplyService;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.detail.DetailObserver;
import com.dx.wms.service.detail.DetailType;
import com.dx.wms.service.detail.ParamDetail;
import com.dx.wms.service.log.IInvokeLogService;
import com.dx.wms.service.log.ILenderApplyLogService;
import com.dx.wms.service.log.InvokeLog;
import com.dx.wms.service.log.LenderApplyLog;
import com.dx.wms.service.log.LogResultDto;
import com.dx.wms.service.model.Model_;
import com.dx.wms.service.process.ParamProcess;
import com.dx.wms.service.process.Process;
import com.dx.wms.service.process.ProcessObserver;
import com.dx.wms.service.process.ResultProcess;
import com.dx.wms.web.account.vo.CustAccountApplyVo;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.process.vo.ProcessParamVo;
import com.dx.wms.web.process.vo.ProcessResultVo;
import com.dx.wms.web.util.WebCommonUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/process")
public class ProcessController {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ProcessController.class);

    /**
     * 通用服务
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 质检投资审核观察者服务
     */
    @Autowired
    private ProcessObserver<Process<ParamProcess, ResultProcess>, ParamProcess, ResultProcess> processObserver;

    /**
     * 理财申请服务
     */
    @Autowired
    private ICustLenderApplyService custLenderApplyService;

    @Autowired
    private DetailObserver detail;

    /**
     * 理财申请日志服务
     */
    @Autowired
    private ILenderApplyLogService lenderApplyLogService;

    /**
     * model服务
     */
    @Autowired
    private Model_ commonModelService;
    
    /**
     * 调用日志服务
     */
    @Autowired
    private IInvokeLogService invokeLogService;
    
    @Autowired
    private IRegionNewService regionNewService;

    @RequestMapping(value = "/{biz}.htm")
    public String initPage(@PathVariable("biz") String biz, ModelMap model, HttpServletRequest request) {
        LOG.info("**initPage() biz:{}**", biz);
        processObserver.put(trans2Param(biz), model);
        return processObserver.init(trans2Param(biz));
    }

    private ParamProcess trans2Param(String biz) {
        return new ParamProcess(biz);
    }

    @RequestMapping("/{biz}.json")
    @ResponseBody
    public AjaxDataTableObj<ProcessResultVo> listByPage(@PathVariable("biz") String biz, ProcessParamVo param,
            HttpServletRequest request, DataTableObj dTable) {
        LOG.info("**listByPage**CheckProcessQueryVo={}", new Gson().toJson(param));
        Pagination page = WebCommonUtil.initPage(dTable);
        Long userId = commonService.getUserId(request);
        return new AjaxDataTableObj<ProcessResultVo>(dTable,
                trans2Results(processObserver.query(transParam(biz, param, userId), page)));
    }

    /**
     * 
     * 页面输入的查询信息 VO转DTO
     * 
     * @param custApplyQueryVo
     * @param userId
     * @return custApplyQueryDto
     */
    private ParamProcess transParam(String biz, ProcessParamVo param, Long userId) {
        ParamProcess dto = new ParamProcess(biz, userId);
        BeanUtils.copyProperties(param, dto);
        dto.put(dto, param.getLenderAmountArea());
        return dto;
    }

    /**
     * 
     *
     * 数据库查询出来的DTO转VO 传回页面
     * 
     * @param custApplyQueryDtos
     * @return
     */
    private PaginationResult<List<ProcessResultVo>> trans2Results(PaginationResult<List<ResultProcess>> pageResult) {
        List<ProcessResultVo> results = new ArrayList<ProcessResultVo>();
        Map<Long, OrgVo> orgMap = new HashMap<Long, OrgVo>();
        Map<Long, UserVo> userMap = new HashMap<Long, UserVo>();
        Map<String, String> productMap = commonService.getProductByProductId();
        Map<String, String> statusMap = commonService.queryStatus();
        for (ResultProcess process : pageResult.getR()) {
            Long clusterId = commonService.queryOrgCache(process.getTeamId(), orgMap).getParentId();
            commonService.putOrgCache(orgMap, process.getTeamId(), clusterId, process.getOrgId());
            commonService.putUserCache(userMap, process.getCreateUser());
            InvokeLog invokeLog = new InvokeLog();
            LenderApplyLog lenderApplyLog = new LenderApplyLog();
            if (Assert.checkParam(process.getFormStatus()) && Assert.equals(process.getFormStatus(), 18L)) {
                invokeLog = invokeLogService.getInvokeLogByLenderId(process.getLenderApplyId());
                lenderApplyLog = lenderApplyLogService.queryByParam(process.getLenderApplyId(), "contributiveConfirm");
            }
            results.add(new ProcessResultVo(process, productMap, orgMap, userMap, clusterId, statusMap, invokeLog,lenderApplyLog));
        }
        return new PaginationResult<List<ProcessResultVo>>(results, pageResult.getPagination());
    }

    /**
     * 申请客户apply.htm
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/{biz}_apply.json")
    public String select(@PathVariable("biz") String biz, ModelMap model, HttpServletRequest request) {
        return processObserver.applyInit(trans2Param(biz));
    }

    @RequestMapping("/{biz}_select.json")
    @ResponseBody
    public AjaxDataTableObj<ProcessResultVo> listCustByPage(@PathVariable("biz") String biz, ProcessParamVo param,
            HttpServletRequest request, DataTableObj dTable) {
        LOG.info("**listByPage**CheckProcessQueryVo={}", new Gson().toJson(param));
        Pagination page = WebCommonUtil.initPage(dTable);
        Long userId = commonService.getUserId(request);
        return new AjaxDataTableObj<ProcessResultVo>(dTable,
                trans2Results(processObserver.selectQuery(transParam(biz, param, userId), page)));
    }

    @RequestMapping(value = "/{biz}_create.json")
    public String create(@PathVariable("biz") String biz, @RequestParam("custAccountId") Long custAccountId,
            Long lenderApplyId, ModelMap model, HttpServletRequest request, Long parentId) throws Exception {
        getPrecessModel(custAccountId, lenderApplyId, model);
        List<LogResultVo> logVoes = getLogVoes(lenderApplyId);
        model.addAttribute("lenderApplyLogs", logVoes);
        model.addAttribute("lenderCustCode", request.getParameter("lenderCustCode"));
        if (Assert.checkParam(parentId)) {
            LenderApply lenderApply = detail.query(new ParamDetail(DetailType.APPLY, parentId)).getApply();
            model.addAttribute("parentId", parentId);
            model.addAttribute("maxAmount", lenderApply.getLenderAmount());
        }
        return processObserver.createInit(trans2Param(biz));
    }

    /**
     * 根據lenderApplyId得出日誌結果集
     *
     * @param lenderApplyId
     * @return List<LogResultVo>
     */
    private List<LogResultVo> getLogVoes(Long lenderApplyId) {
        List<LogResultVo> logVoes = new ArrayList<LogResultVo>();
        LOG.info("***getLogVoes() lenderApplyId={}", lenderApplyId);
        if (Assert.checkParam(lenderApplyId)) {
            List<LogResultDto> logDtoes = lenderApplyLogService.queryByParam(lenderApplyId);
            for (LogResultDto dto : logDtoes) {
                logVoes.add(new LogResultVo(dto));
            }
        }
        return logVoes;
    }

    // 开户信息
    @RequestMapping(value = "/applyPersonInfo.json")
    public String applyPersonInfo(@RequestParam("type") Integer type, @RequestParam("custAccountId") Long custAccountId,
            @RequestParam("lenderCode") String lenderCode, ModelMap model, HttpServletRequest request) {
        getPrecessModel(custAccountId, -1L, model);
        model.addAttribute("lenderCode", lenderCode);
        if (Assert.checkParam(type)) {
            model.addAttribute("role", type);
        }
        return "checkProcess/applyPersonInfo";
    }

    // 理财申请信息
    @RequestMapping(value = "/applyInfo.json")
    public String applyInfo(@RequestParam("custAccountId") Long custAccountId,
            @RequestParam("lenderApplyId") Long lenderApplyId, ModelMap model, HttpServletRequest request) {
        Assert.notNull("客户开户ID或者客户理财申请ID为空", custAccountId, lenderApplyId);
        LOG.info("**applyInfo**custAccountId={},lenderApplyId={}", custAccountId, lenderApplyId);
        CustAccountApplyDto custAccountApplyDto = custLenderApplyService.getCustAccountApplyDto(custAccountId,
                lenderApplyId);
        commonModelService.putCustAccountApply(custAccountApplyDto, model);
        getModel(custAccountApplyDto,model);
        if (Assert.checkParam(custAccountApplyDto.getLenderApply().getParentId())) {
            return "checkProcess/conApplyInfo";
        }
        return "checkProcess/applyInfo";
    }

    // 影像件信息
    @RequestMapping(value = "/applyVideoInfo.json")
    public String applyVideoInfo(@RequestParam("custAccountId") Long custAccountId,
            @RequestParam("lenderApplyId") Long lenderApplyId, @RequestParam("lenderCode") String lenderCode,
            ModelMap model, HttpServletRequest request) {
        // 用户编号
        model.addAttribute("custAccountId", custAccountId);
        // 理财申请主键
        model.addAttribute("lenderApplyId", lenderApplyId);
        return "checkProcess/applyVideoInfo";
    }
    
    // 审批信息
    @RequestMapping(value = "/approveInfo.json")
    public String approveInfo(@RequestParam("custAccountId") Long custAccountId,
            @RequestParam("lenderApplyId") Long lenderApplyId, @RequestParam("lenderCode") String lenderCode,
            ModelMap model, HttpServletRequest request) {
        // 用户编号
        model.addAttribute("custAccountId", custAccountId);
        // 审批日志
        List<LogResultDto> logDtoes = lenderApplyLogService.queryByParam(lenderApplyId);
        List<LogResultVo> logVoes = new ArrayList<LogResultVo>();
        LogResultVo vo = null;
        for (LogResultDto dto : logDtoes) {
            vo = new LogResultVo();
            BeanUtils.copyProperties(dto, vo);
            logVoes.add(vo);
        }
        model.addAttribute("lenderApplyLogs", logVoes);
        // 理财申请主键
        model.addAttribute("lenderApplyId", lenderApplyId);
        return "checkProcess/approveInfo";
    }

    /**
     * 获取客户信息
     *
     * @param type
     * @param custAccountId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/account.json")
    public String account(@ModelAttribute("custAccountId") Long custAccountId, ModelMap model,
            HttpServletRequest request) {
        getPrecessModel(custAccountId, -1L, model);
        return "checkProcess/accountInfo";
    }

    private void getPrecessModel(Long custAccountId, Long lenderApplyId, ModelMap model) {
        LOG.info("**applyInfo**custAccountId={},lenderApplyId={}", custAccountId, lenderApplyId);
        CustAccountApplyDto custAccountApplyDto = custLenderApplyService.getCustAccountApplyDto(custAccountId,
                lenderApplyId);
        commonModelService.putCustAccountApply(custAccountApplyDto, model);
        getModel(custAccountApplyDto,model);

    }
    
	private void getModel(CustAccountApplyDto custAccountApplyDto,ModelMap model){
		 String area = commonService.trans2Address(custAccountApplyDto.getCustComm().getProvinceRegionCode(),
	        		custAccountApplyDto.getCustComm().getCityRegionCode(), custAccountApplyDto.getCustComm().getDistrictRegionCode());
	     Map<Integer, String> bank = new HashMap<Integer, String>();
	     if (Assert.checkParam(custAccountApplyDto.getCustFinances())) {
	            for (CustFinance finance : custAccountApplyDto.getCustFinances()) {
	                if (Assert.checkParam(finance.getAccountCategory())) {
	                    bank.put(finance.getAccountCategory(),
	                            commonService.trans2Address(finance.getProvinceRegionCode(), finance.getCityRegionCode()));
	                }
	            }
	        }
	    String product = Assert.checkParam(custAccountApplyDto.getLenderApply())
	                ? commonService.queryByProductId(custAccountApplyDto.getLenderApply().getProductId()).getProductName() : "";
	    model.addAttribute("custAccountApplyVo", new CustAccountApplyVo(custAccountApplyDto,area,bank,product,regionNewService));
    }
	
	@RequestMapping(value = "/subBank.json")
	@ResponseBody
    public List<BankInfoDTO> subBank(@RequestParam("bankCode") String bankCode,@RequestParam("paycityRegionCode") String paycityRegionCode,
    		@RequestParam("payprovinceRegionCode") String payprovinceRegionCode, HttpServletRequest request) {
        return commonService.subBank(bankCode, paycityRegionCode, payprovinceRegionCode);
    }
	
    @RequestMapping(value = "/getLenderApply.json")
    @ResponseBody
    public LenderApply getLenderApply(@RequestParam("lenderApplyId") Long lenderApplyId,HttpServletRequest request) {
        LenderApply lenderApply = detail.query(new ParamDetail(DetailType.APPLY, lenderApplyId)).getApply();
       return lenderApply;
    }
    
    @RequestMapping(value = "/postCode.json")
	@ResponseBody
    public PostCode getPostCode(HttpServletRequest request) {
        return commonService.getPostCode(commonService.getOrgIdByUserId(commonService.getUserId(request)));
    }
    
}


