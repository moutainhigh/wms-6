/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: WealthManagementInfo.java
 * Author:   朱道灵
 * Date:     2015年7月26日 下午2:23:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.info.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.account.ICustAccountService;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.apply.ICustLenderApplyService;
import com.dx.wms.service.info.Info;
import com.dx.wms.service.info.InfoObserver;
import com.dx.wms.service.info.ParamInfo;
import com.dx.wms.service.info.ResultInfo;
import com.dx.wms.service.log.IInvokeLogService;
import com.dx.wms.service.log.ILenderApplyLogService;
import com.dx.wms.service.log.InvokeLog;
import com.dx.wms.service.log.LenderApplyLog;
import com.dx.wms.service.model.Model_;
import com.dx.wms.web.account.vo.CustAccountApplyVo;
import com.dx.wms.web.info.vo.ExcelResultVO;
import com.dx.wms.web.info.vo.ParamInfoVo;
import com.dx.wms.web.info.vo.ResultInfoVo;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;
import com.dx.wms.web.util.WebCommonUtil;

/**
 * 理财信息管理
 *
 * @author 朱道灵
 */
@Controller
@RequestMapping("/wealthManagementInfo")
public class InfoController {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    /**
     * 客户理财申请服务
     */
    @Autowired
    private ICustLenderApplyService custLenderApplyService;

    /**
     * 客户通讯服务
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 客户开户服务
     */
    @Autowired
    private ICustAccountService custAccountService;
    
    /**
     * 调用日志服务
     */
    @Autowired
    private IInvokeLogService invokeLogService;
    
    /**
     * 理财申请日志服务
     */
    @Autowired
    private ILenderApplyLogService lenderApplyLogService;

    /**
     * 理财服务观察者
     */
    @Autowired
    private InfoObserver<Info<ParamInfo, ResultInfo>, ParamInfo, ResultInfo> infoObserver;

    /**
     * 理财信息服务model
     */
    @Autowired
    private Model_ modelExecutor;

    
    private static final String[] EXCEL_DATA_HEAD={"出借编号","客户姓名","证件号码",
    	"出借方式","出借金额(元)","签单日期","生效时间","到期时间","账单日","营业部",
    	"大团","团队","客户经理","状态"};
    
    /**
     * 
     * 理财信息管理
     * 
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/list.htm")
    public String initPage(ModelMap model, HttpServletRequest request) {
        Long userId = commonService.getUserId(request);
        ParamInfo param = trans2Param(userId);
        infoObserver.put(param, model);
        return infoObserver.init(trans2Param(userId));
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     */
    private ParamInfo trans2Param(Long userId) {
        return new ParamInfo(userId);
    }

    /**
     * 
     * 页面输入的查询信息 VO转DTO
     * 
     * @param paramVo
     * @param userId
     * @return
     */
    private ParamInfo trans2Param(ParamInfoVo paramVo, Long userId) {
        ParamInfo paramInfo = new ParamInfo(userId);
        paramVo.put(paramInfo);
        return paramInfo;
    }

    /**
     * 
     * 
     * 〈功能详细描述〉 理财信息查询数据请求
     * 
     * @param param
     * @param request
     * @param dTable
     * @return
     */
    @RequestMapping("list_do.json")
    @ResponseBody
    public AjaxDataTableObj<ResultInfoVo> query(ParamInfoVo param, HttpServletRequest request, DataTableObj dTable) {
        Long userId = commonService.getUserId(request);
        Pagination page = WebCommonUtil.initPage(dTable);
        return new AjaxDataTableObj<ResultInfoVo>(dTable,
                trans2Page(infoObserver.query(trans2Param(param, userId), page)));

    }

    /**
     * 数据库查询出来的DTO转VO 传回页面
     * 
     * @param wealthManagementInfoQueryDtos
     * @return
     */
    private PaginationResult<List<ResultInfoVo>> trans2Page(PaginationResult<List<ResultInfo>> page) {
        List<ResultInfoVo> results = new ArrayList<ResultInfoVo>();
        Map<Long, OrgVo> orgMap = new HashMap<Long, OrgVo>();
        Map<Long, UserVo> userMap = new HashMap<Long, UserVo>();
        Map<String, String> productMap = commonService.getProductByProductId();
        Map<String, String> statusMap = commonService.queryStatus();
        for (ResultInfo dto : page.getR()) {
            Long clusterId = commonService.queryOrgCache(dto.getTeamId(), orgMap).getParentId();
            commonService.putOrgCache(orgMap, dto.getTeamId(), clusterId, dto.getOrgId());
            commonService.putUserCache(userMap, dto.getManagerId());
            InvokeLog invokeLog = null;
            LenderApplyLog lenderApplyLog = null;
            if (Assert.checkParam(dto.getFormStatus()) && Assert.equals(dto.getFormStatus(), 18L)) {
                invokeLog = invokeLogService.getInvokeLogByLenderId(dto.getLenderApplyId());
                lenderApplyLog = lenderApplyLogService.queryByParam(dto.getLenderApplyId(), "contributiveConfirm");
            }
            results.add(new ResultInfoVo(dto, productMap, orgMap, userMap, clusterId, statusMap,invokeLog,lenderApplyLog));
        }
        return new PaginationResult<List<ResultInfoVo>>(results, page.getPagination());
    }

    /**
     * 
     * 理财信息管理
     * 
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/applyInfoDetail.json")
    public String applyInfoDetail(Integer type, @RequestParam("custAccountId") Long custAccountId,
            @RequestParam("lenderApplyId") Long lenderApplyId, @ModelAttribute("lenderCode") String lenderCode,
            ModelMap model, HttpServletRequest request) {
        LOG.info("***理财信息管理***申请单信息查看***");
        model.addAttribute("custAccountId", custAccountId);
        model.addAttribute("lenderApplyId", lenderApplyId);
        model.addAttribute("lenderCode", lenderCode);
        return "lenderApplyDetail/detail";
    }

    @RequestMapping(value = "/applyPersonInfo.json")
    public String applyPersonInfo(Integer type, @RequestParam("custAccountId") Long custAccountId,
            @ModelAttribute("lenderCode") String lenderCode, ModelMap model, HttpServletRequest request) {
        CustAccountApplyVo custAccountApplyVo = new CustAccountApplyVo();
        CustAccountApplyDto custAccountApplyDto = new CustAccountApplyDto();
        if (Assert.checkParam(custAccountId)) {
            // 获取开户申请表对象
            custAccountApplyDto = custAccountService.queryCustAccountDtoById(custAccountId);
        }
        modelExecutor.putCustAccount(custAccountApplyDto, model);
        BeanUtils.copyProperties(custAccountApplyDto, custAccountApplyVo);
        model.addAttribute("custAccountApplyVo", custAccountApplyVo);
        model.addAttribute("lenderCode", lenderCode);
        return "lenderApplyDetail/applyPersonInfo";
    }

    @RequestMapping(value = "/applyInfo.json")
    public String applyInfo(@RequestParam("custAccountId") Long custAccountId,
            @ModelAttribute("lenderApplyId") Long lenderApplyId, @ModelAttribute("lenderCode") String lenderCode,
            ModelMap model, HttpServletRequest request) {
        LOG.info("***applyInfo() lenderApplyId={}, custAccountId={}", lenderApplyId, custAccountId);
        CustAccountApplyDto custAccountApplyDto = custLenderApplyService.getCustAccountApplyDto(custAccountId,
                lenderApplyId);
        modelExecutor.putCustAccountApply(custAccountApplyDto, model);
        model.addAttribute("custAccountApplyVo", putCustAccountApplyVo(custAccountApplyDto));
        if (Assert.checkParam(custAccountApplyDto.getLenderApply().getParentId())) {
            return "lenderApplyDetail/conApplyInfo";
        }
        return "lenderApplyDetail/applyInfo";
    }
    
    @RequestMapping("excelExport.json")
    public void excelExport(HttpServletRequest request, HttpServletResponse response){
	    Pagination pagination = new Pagination();
	    pagination.setCurrentPage(0);
	    pagination.setPagesize(-1);
	    Long userId = commonService.getUserId(request);
	    List<ExcelResultVO> excelResultList = trans2ExcelVo(
	    		infoObserver.query(trans2Param(trans2obj(request), userId), pagination));
	    List<String> requirements = new ArrayList<String>();
        ExportExcelUtil.excelExoprt(requirements, EXCEL_DATA_HEAD, null, excelResultList, null, "理财信息管理数据导出", response,
                "yyyy-mm-dd");
	    

    }
    
    /*
     * 将request请求转化为可查询参数对象
     */
    public ParamInfoVo trans2obj(HttpServletRequest request){
    	ParamInfoVo param = new ParamInfoVo();
    	
    	String custName=null;
    	if(null!=request.getParameter("custNameQuery")){
    		try {
    			custName = new String(request.getParameter("custNameQuery").getBytes("iso8859-1"),"utf-8");
    			param.setCustName(Assert.checkParam(custName) ? custName : null);
    		} catch (UnsupportedEncodingException e) {
    			e.printStackTrace();
    		}
    	}
		
    	String currentStep = request.getParameter("currentStepQuery");
    	param.setCurrentStep(Assert.checkParam(currentStep) ? Integer.parseInt(currentStep) : null);

    	String signDateBegin = request.getParameter("signDateBegin");
    	param.setSignDateBegin(Assert.checkParam(signDateBegin) ? signDateBegin : null);

    	String signDateEnd = request.getParameter("signDateEnd");
    	param.setSignDateEnd(Assert.checkParam(signDateEnd) ? signDateEnd : null);

    	String lenderCode = request.getParameter("lenderCodeQuery");
    	param.setLenderCode(Assert.checkParam(lenderCode) ? lenderCode : null);

    	String lenderAmountArea = request.getParameter("lenderAmountQuery");
    	param.setLenderAmountArea(Assert.checkParam(lenderAmountArea) ? Integer.parseInt(lenderAmountArea) : null);

    	String orgId = request.getParameter("orgIdQuery");
    	param.setOrgId(Assert.checkParam(orgId) ? Long.parseLong(orgId) : null);

    	String productId = request.getParameter("loanWayQuery");
    	param.setProductId(Assert.checkParam(productId) ? Long.parseLong(productId) : null);

    	String mobile = request.getParameter("mobileQuery");
    	param.setMobile(Assert.checkParam(mobile) ? mobile : null);
    	
    	return param;
    }
    
    private List<ExcelResultVO> trans2ExcelVo(PaginationResult<List<ResultInfo>> result) {
    	
        List<ExcelResultVO> excelVoList = new ArrayList<ExcelResultVO>();
        Map<Long, OrgVo> orgMap = new HashMap<Long, OrgVo>();
        Map<Long, UserVo> userMap = new HashMap<Long, UserVo>();
        Map<String, String> productMap = commonService.getProductByProductId();
        Map<String, String> statusMap = commonService.queryStatus();
        for (ResultInfo dto : result.getR()) {
        	Long clusterId = commonService.queryOrgCache(dto.getTeamId(), orgMap).getParentId();
            commonService.putOrgCache(orgMap, dto.getTeamId(), clusterId, dto.getOrgId());
            commonService.putUserCache(userMap, dto.getManagerId());
        	excelVoList.add(new ExcelResultVO(new ResultInfoVo(dto, productMap, orgMap, userMap, clusterId, statusMap)));
        }
        return excelVoList;
    }

    /**
     * dto转vo
     * 
     * @param custAccountApplyDto
     * @return CustAccountApplyVo
     */
    private CustAccountApplyVo putCustAccountApplyVo(CustAccountApplyDto custAccountApplyDto) {
        CustAccountApplyVo custAccountApplyVo = new CustAccountApplyVo();
        BeanUtils.copyProperties(custAccountApplyDto, custAccountApplyVo);
        if (Assert.checkParam(custAccountApplyDto.getLenderApply().getLenderAmount())) {
            custAccountApplyVo.setBiglenderAmount(
                    AmountUtils.toChinese(custAccountApplyDto.getLenderApply().getLenderAmount().toString()));
        } else {
            custAccountApplyVo.setBiglenderAmount("零");
        }
        return custAccountApplyVo;
    }

}