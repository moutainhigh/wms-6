package com.dx.report.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.ports.Port;
import com.dx.cmm.service.report.IFundReportService;
import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.service.view.FundViewResult;
import com.dx.cmm.web.controller.BaseController;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.dcs.api.dto.MissionRequestParam;
import com.dx.dcs.api.dto.MissionResultDto;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.report.web.vo.FundParamVo;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

@Controller
@RequestMapping("/report/fund")
public class FundController extends BaseController{
	
    private static final String HTM = "report/fund/list";
    
    private static final String FORMAT = "yyyy/MM";
    
    private static final String FUNDEXCELKEY = "fundExcelProtocol";
    
    private static final String FUNDPDFKEY = "fundPdfProtocol";
    
    @Autowired
    private IFundReportService fundReportService;

	 
    @RequestMapping(INIT_HTM)
    public String init(Model model) {
    	model.addAttribute(PORT, Port.PORT);
        return HTM;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(INIT_URL)
    @ResponseBody
    public AjaxDataTableObj<FundViewResult> init(FundParamVo param, DataTableObj dTable) {
    	LOG.info("**Init() param={}",param);
    	if(param.getBillDay() == -1 && Assert.equals("", param.getCountTime()) && Assert.equals("", param.getLenderCode()) && Assert.equals("", param.getLenderCustCode())){
    		Pagination page = new Pagination();
    		page.setTotalRows(0);
    		page.setPagesize(0);
    		return new AjaxDataTableObj<FundViewResult>(dTable,new PaginationResult<List<FundViewResult>>(new ArrayList<FundViewResult>(),page));
    	}
    	setReportDay(param);
    	ProtocolParam paramdto = new ProtocolParam();
    	BeanUtils.copyProperties(param, paramdto);
        return new AjaxDataTableObj(dTable,fundReportService.queryFundList(paramdto, init(dTable)));
    }
    
    private void setReportDay(FundParamVo param){
    	if(Assert.checkParam(param.getBillDay()) && Assert.checkParam(param.getCountTime())){
    		Date date = DateUtils.parse(param.getCountTime(), FORMAT);
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(date);
    		calendar.set(Calendar.DAY_OF_MONTH, param.getBillDay());
    		param.setReportDay(calendar.getTime());
    	}
    }
    
    @RequestMapping(value = "{biz}_report.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> excel(@PathVariable("biz") String biz,HttpServletRequest request,@RequestBody FundParamVo param) {
    	Assert.notNull("pdf()** param is null",param);
    	Map<String, Object> result = result();
    	setReportDay(param);
    	ProtocolParam dataParam = new ProtocolParam();
    	set(biz,param,dataParam);
    	MissionRequestParam requestParam = getRequestParam(biz,request, dataParam);
    	MissionResultDto missionResult = missionRequestService.request(requestParam);
    	if(missionResult.isSupport()){
    		result.put("msg", "请于"+DateUtils.formatForMinute(missionResult.getDoneTime())+"后到下载中心下载文件");
    	}
		return missionResult.isSupport() == true ? result : setFail(result);
    }
    
    private void set(String biz , FundParamVo param, ProtocolParam dataParam){
    	if(Assert.equals(biz, PDF)){
    		dataParam.setLenderCodes(param.getLenderCodes());
    		dataParam.setLenderCustCode(param.getLenderCustCode());
        	dataParam.setReportDay(param.getReportDay());
    	}else if(Assert.equals(biz, EXCEL)){
    		dataParam.setLenderCode(param.getLenderCode());
    		dataParam.setLenderCustCode(param.getLenderCustCode());
        	dataParam.setReportDay(param.getReportDay());
    	}
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
