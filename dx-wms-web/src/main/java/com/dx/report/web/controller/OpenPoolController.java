package com.dx.report.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dx.ccs.service.IAMService;
import com.dx.cmm.service.invest.InvestPoolParam;
import com.dx.cmm.service.invest.InvestResult;
import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.web.controller.invest.ExcOpenPoolResult;
import com.dx.cmm.web.controller.invest.OpenPoolResult;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.dcs.api.dto.MissionRequestParam;
import com.dx.dcs.api.dto.MissionResultDto;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.report.web.vo.EffectParamVo;
import com.dx.report.web.vo.FundParamVo;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.ExportExcelUtil;

@Controller("reportOpenPoolController")
@RequestMapping("/report/pool")
public class OpenPoolController extends InvestController {

    /**
     * 导出业务数据excel表头
     */
    private static final String[] POOL_DATA_HEAD = { "申请日期","出借编号", "客户姓名", "性别", "身份证号", "出借方式", "出借金额",  "客户分类",
            "预计出借日期", "生效日期", "支付方式", "划扣银行", "划扣账号", "账户名", "回款银行", "回款账号", "账户名", "联系地址", "邮编", "团队主管", "客户经理", "区域", "营业部",
            "文件接收方式", "电子邮箱", "手机号", "账单日", "匹配日期" };

    @Autowired
    private ILenderApplyService lenderApplyService;

    @Autowired
    private IAMService amService;

    private static final String FTL = "/report/pool/list";
    
    private static final String FUNDEXCELKEY = "effectExcelProtocol";
    
    private static final String FUNDPDFKEY = "effectPdfProtocol";

    @RequestMapping("/list.htm")
    public String init(Model model) {
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<OpenPoolResult> init(InvestPoolParam param, DataTableObj dTable) {
        return parse(investService.queryMatching(param, init(dTable)), dTable);
    }

    private AjaxDataTableObj<OpenPoolResult> parse(PaginationResult<List<InvestResult>> page, DataTableObj dTable) {
        List<OpenPoolResult> results = new ArrayList<OpenPoolResult>();
        Map<Long, String> product = productService.query(APP);
        for (InvestResult result : page.getR()) {
            results.add(new OpenPoolResult(result, lenderApplyService, amService, product));
        }
        return new AjaxDataTableObj<OpenPoolResult>(dTable, new PaginationResult<List<OpenPoolResult>>(results,
                page.getPagination()));
    }

//    @RequestMapping("excelExoprt.json")          
//    public void excelExoprt(HttpServletRequest request, HttpServletResponse response) {
//        Pagination pagination = new Pagination();
//        pagination.setCurrentPage(0);
//        pagination.setPagesize(-1);
//        PaginationResult<List<InvestResult>> page = investService.queryPool(trans2Query(request), pagination);
//        List<ExcOpenPoolResult> excResults = new ArrayList<ExcOpenPoolResult>();
//        Map<Long, String> product = productService.query(APP);
//        for (InvestResult result : page.getR()) {
//            OpenPoolResult Pool = new OpenPoolResult(result, lenderApplyService, amService, product);
//            excResults.add(new ExcOpenPoolResult(Pool));
//        }
//        List<String> headTitle = new ArrayList<String>();
//        ExportExcelUtil.excelExoprt(headTitle, POOL_DATA_HEAD, null, excResults, null, "每日匹配数据导出", response,
//                "yyyy-mm-dd");
//    }
    
//    private InvestPoolParam trans2Query(HttpServletRequest request) {
//        InvestPoolParam param = new InvestPoolParam();
//        String lenderCode = request.getParameter("lenderCode");
//        param.setLenderCode(Assert.checkParam(lenderCode) ? lenderCode : null);
//        String idCard = request.getParameter("idCard");
//        param.setIdCard(Assert.checkParam(idCard) ? idCard : null);
//        String initMatchDateBegin = request.getParameter("initMatchDateBegin");
//        param.setInitMatchDateBegin(Assert.checkParam(initMatchDateBegin) ? DateUtils.parseForDay(initMatchDateBegin) : null);
//        String initMatchDateEnd = request.getParameter("initMatchDateEnd");
//        param.setInitMatchDateEnd(Assert.checkParam(initMatchDateEnd) ? DateUtils.parseForDay(initMatchDateEnd) : null);
//        return  param;
//    }
    
    @RequestMapping(value = "{biz}_report.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> excel(@PathVariable("biz") String biz,HttpServletRequest request,@RequestBody EffectParamVo param) {
    	Assert.notNull("pdf()** param is null",param);
    	Map<String, Object> result = result();
    	ProtocolParam dataParam = new ProtocolParam();
    	set(biz,param,dataParam);
    	MissionRequestParam requestParam = getRequestParam(biz,request, dataParam);
    	MissionResultDto missionResult = missionRequestService.request(requestParam);
    	if(missionResult.isSupport()){
    		result.put("msg", "请于"+DateUtils.formatForMinute(missionResult.getDoneTime())+"后到下载中心下载文件");
    	}
		return missionResult.isSupport() == true ? result : setFail(result);
    }
    
    private void set(String biz , EffectParamVo param, ProtocolParam dataParam){
    	if(Assert.equals(biz, PDF)){
    		dataParam.setLenderCodes(param.getLenderCodes());
    		
    	}else if(Assert.equals(biz, EXCEL)){
    		dataParam.setLenderCode(param.getLenderCode());
    	}
    	dataParam.setIdCard(param.getIdCard());
    	dataParam.setInitMatchDateBegin(param.getInitMatchDateBegin());
    	dataParam.setInitMatchDateEnd(param.getInitMatchDateEnd());
    }
    
    private MissionRequestParam getRequestParam(String biz , HttpServletRequest request,  ProtocolParam dataParam){
    	MissionRequestParam requestParam = new MissionRequestParam();
    	requestParam.setAppKey(INVEST);
    	requestParam.setMissionKey(Assert.equals(biz,PDF) ? FUNDPDFKEY : FUNDEXCELKEY);
    	Long userId = commonService.getUserId(request);
    	requestParam.setUserId(userId);
    	requestParam.setOrgId(commonService.getOrgIdByUserId(userId));
    	requestParam.setClassName(ProtocolParam.class.getName());
    	requestParam.setParamValue(JSON.toJSONString(dataParam));
    	return requestParam;
    }
}
