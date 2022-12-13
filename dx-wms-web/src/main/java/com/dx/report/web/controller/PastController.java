package com.dx.report.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.alibaba.fastjson.JSON;
import com.dx.cmm.service.ports.Port;
import com.dx.cmm.service.report.IPastReportService;
import com.dx.cmm.service.report.IPastViewService;
import com.dx.cmm.service.report.dto.PastParamDto;
import com.dx.cmm.service.report.dto.PastProtocolViewResult;
import com.dx.cmm.service.report.dto.PastResult;
import com.dx.cmm.web.controller.BaseController;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.dcs.api.dto.MissionRequestParam;
import com.dx.dcs.api.dto.MissionResultDto;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.framework.redis.client.IRedisClient;
import com.dx.report.web.vo.PastParamVo;
import com.dx.report.web.vo.PastPreviewParamVo;
import com.dx.report.web.vo.PastResultVo;
import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.enums.ReportType;
import com.dx.wms.reportTemplate.TempalteJudge;
import com.dx.wms.service.IProductService;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;

@Controller
@RequestMapping("/report/past")
public class PastController extends BaseController{
	
	private static final Logger LOG = LoggerFactory.getLogger(PastController.class);
	
	private static final String LIST = "report/past/list";
	
	private static final String[] PAST_HEAD={"客户姓名","身份证","出借编号","出借金额",
		"回款匹配金额","出借方式","报告日","投资生效日"};
	
	private static final String PASTPDFKEY = "pastPdfProtocol";
	
	private static final String PASTEXCELKEY = "pastExcelProtocol";
	
	private static final String UNUSUAL = "/unusual.htm";
	
	private static final String UNUSAL_PLUS="/list_plus.json";
	
	private static final String UNUSUAL_PAGE="report/past/unusual";
	
	private static final String PAST_PLUSPDFKEY = "pastPlusPdfProtocol";
	
	private static final String PAST_PLUSEXCELKEY = "pastPlusExcelProtocol";
	
	@Autowired
	IPastReportService pastResportService;
	@Autowired
    protected IProductService productService;
	
	@Autowired
	FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Autowired
	IPastViewService pastViewService;
	
	/**
     * 缓存服务
     */
    @Autowired
    private IRedisClient wmsRedisClient;
	
	@RequestMapping(INIT_HTM)
    public String init(Model model) {
    	model.addAttribute(PORT, Port.PORT);
        return LIST;
    }
	
	@RequestMapping(UNUSUAL)
    public String initUnusual(Model model) {
    	model.addAttribute(PORT, Port.PORT);
        return UNUSUAL_PAGE;
    }
	
	@RequestMapping(INIT_URL)
    @ResponseBody
    public AjaxDataTableObj<PastResultVo> init(Model model,PastParamVo vo, DataTableObj dTable) {
    	LOG.info("**Init() param={}",vo);
    	if(!Assert.checkParam(vo.getIdCard())&& !Assert.checkParam(vo.getLenderCode())
    			&& !Assert.checkParam(vo.getReportDay())){
    		//初始化未任何条件，返回空页面
    		Pagination page = new Pagination();
    		page.setTotalRows(0);
    		return new AjaxDataTableObj<PastResultVo>(dTable,
                    new PaginationResult<List<PastResultVo>>(new ArrayList<PastResultVo>(), page));
    	}else{
    		//有查询条件，执行查询任务
    		PastParamDto dto = new PastParamDto();
			try {
				dto = setDto(vo);
				if(null==dto){
					Pagination page = new Pagination();
		    		page.setTotalRows(0);
					return new AjaxDataTableObj<PastResultVo>(dTable,
		                    new PaginationResult<List<PastResultVo>>(new ArrayList<PastResultVo>(), page));
				}
			} catch (ParseException e) {
				LOG.error("Past for query assembling PastParamDto is failed");
				e.printStackTrace();
			}
            return parse(pastResportService.queryPastList(dto, init(dTable)),dTable,dto.getCreateTime(),dto.getReportDate());
    	}
    	 
    }
	
	public PastParamDto setDto(PastParamVo vo) throws ParseException{
		PastParamDto dto = new PastParamDto();
    	if(null!=vo.getIdCard()){
    		dto.setIdCard(vo.getIdCard());
    	}
    	if(null!=vo.getLenderCode()){
    		dto.setLenderCode(vo.getLenderCode());
    	}
    	Calendar cal = Calendar.getInstance();//获取当前时间
        SimpleDateFormat forKey = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat forTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String key ="past_createTime"+":"+forKey.format(cal.getTime())+":"+vo.getReportDay();
        String createTime = getCache(key);
        if(null!=createTime){
        	dto.setCreateTime(createTime);
        }else{
        	LOG.error("Get createTime from cache is null");
        	return null;
        }
    	if(null!=vo.getReportDay()){
    		if(1==vo.getReportDay()){
    			
    			Calendar report = Calendar.getInstance();
    			report.setTime(forTime.parse(dto.getCreateTime()));
    			report.add(Calendar.MONTH, 2);
    			int month = report.get(Calendar.MONTH)+1;
    			String reportDay = report.get(Calendar.YEAR)+"-"+month+"-"+1;
    			dto.setReportDate(reportDay);
    		}else if(16==vo.getReportDay()){
    		
    			Calendar report = Calendar.getInstance();
    			report.setTime(forTime.parse(dto.getCreateTime()));
    			report.add(Calendar.MONTH, 1);
    			int month = report.get(Calendar.MONTH)+1;
    			String reportDay = report.get(Calendar.YEAR)+"-"+month+"-"+16;
    			dto.setReportDate(reportDay);
    		}
    	}
		return dto;
	}
	
	@RequestMapping(UNUSAL_PLUS)
    @ResponseBody
    public AjaxDataTableObj<PastResultVo> initPlus(Model model,PastParamVo vo, DataTableObj dTable) {
    	LOG.info("**Init() param={}",vo);
    	if(!Assert.checkParam(vo.getIdCard())&& !Assert.checkParam(vo.getLenderCode())
    			&& !Assert.checkParam(vo.getReportDay())){
    		//初始化未任何条件，返回空页面
    		Pagination page = new Pagination();
    		page.setTotalRows(0);
    		return new AjaxDataTableObj<PastResultVo>(dTable,
                    new PaginationResult<List<PastResultVo>>(new ArrayList<PastResultVo>(), page));
    	}else{
    		//有查询条件，执行查询任务
    		PastParamDto dto = new PastParamDto();
			try {
				dto = setPlusDto(vo);
				if(null==dto){
					Pagination page = new Pagination();
		    		page.setTotalRows(0);
					return new AjaxDataTableObj<PastResultVo>(dTable,
		                    new PaginationResult<List<PastResultVo>>(new ArrayList<PastResultVo>(), page));
				}
			} catch (ParseException e) {
				LOG.error("PastPlus for query assembling PastParamDto is failed");
				e.printStackTrace();
			}
            return parse(pastResportService.queryPastList(dto, init(dTable)),dTable,dto.getCreateTime(),dto.getReportDate());
    	}
    	 
    }
	
	public PastParamDto setPlusDto(PastParamVo vo) throws ParseException{
		PastParamDto dto = new PastParamDto();
    	if(null!=vo.getIdCard()){
    		dto.setIdCard(vo.getIdCard());
    	}
    	if(null!=vo.getLenderCode()){
    		dto.setLenderCode(vo.getLenderCode());
    	}
    	Calendar cal = Calendar.getInstance();//获取当前时间
        SimpleDateFormat forKey = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat forTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String key ="pastPlus_createTime"+":"+forKey.format(cal.getTime())+":"+vo.getReportDay();
        String createTime = getCache(key);
        if(null!=createTime){
        	dto.setCreateTime(createTime);
        }else{
        	LOG.error("Get createTime from cache is null");
        	return null;
        }
    	if(null!=vo.getReportDay()){
    		if(1==vo.getReportDay()){
    			Calendar report = Calendar.getInstance();
    			report.setTime(forTime.parse(dto.getCreateTime()));
    			report.add(Calendar.MONTH, 1);
    			int month = report.get(Calendar.MONTH)+1;
    			String reportDay = report.get(Calendar.YEAR)+"-"+month+"-"+1;
    			dto.setReportDate(reportDay);
    		}else if(16==vo.getReportDay()){
    			Calendar report = Calendar.getInstance();
    			report.setTime(forTime.parse(dto.getCreateTime()));
    			report.add(Calendar.MONTH, 1);
    			int month = report.get(Calendar.MONTH)+1;
    			String reportDay = report.get(Calendar.YEAR)+"-"+month+"-"+16;
    			dto.setReportDate(reportDay);
    		}
    	}
		return dto;
	}
	
	private AjaxDataTableObj<PastResultVo> parse(PaginationResult<List<PastResult>> page,DataTableObj dTable,
			String createTimePre, String reportDayPre) {
        List<PastResultVo> pastList = new ArrayList<PastResultVo>();
        Map<String, String> productMap = productService.getProductByAppAndProductId("wms", -1L);
        for (PastResult result : page.getR()) {
        	PastResultVo resultVo = new PastResultVo(result);
        	resultVo.setProductName(productMap.get(String.valueOf(resultVo.getProductId())));
        	resultVo.setCreateTimePre(createTimePre);
        	resultVo.setReportDayPre(reportDayPre);
        	pastList.add(resultVo);
        }
        return new AjaxDataTableObj<PastResultVo>(dTable,
                new PaginationResult<List<PastResultVo>>(pastList, page.getPagination()));
    }
	
	
	@RequestMapping(value = "{biz}_report.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> downloadPast(@PathVariable("biz") String biz,HttpServletRequest request,@RequestBody PastParamVo vo) {
    	Assert.notNull("pdf()** vo is null",vo);
    	Map<String, Object> result = result();
    	PastParamDto dto= new PastParamDto();
    	if(null==dto.getCreateTime()){
    		dto.setCreateTime(vo.getCreateTimePre());
    	}
    	if(null==dto.getReportDate()){
    		dto.setReportDate(vo.getReportDayPre());
    	}
    	dto.setLenderCodes(vo.getLenderCodes());
    	if(null!=vo.getIsQuery()){
    		dto.setIsQuery(vo.getIsQuery());
    		if("excel".equals(biz)){
    			try {
        			dto = setDto(vo);
        			if(null==dto){
        				result.put("msg","获取预览数据异常");
        				return result;
        			}
        		} catch (ParseException e) {
        			LOG.error("Past for Downloading assembling PastParamDto is failed");
        			e.printStackTrace();
        		}
    		}
    	}
    	MissionRequestParam requestParam = getRequestParam(biz,request, dto);
    	MissionResultDto missionResult = missionRequestService.request(requestParam);
    	if(missionResult.isSupport()){
    		SimpleDateFormat getLeftTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    		result.put("msg", "请于"+getLeftTime.format(missionResult.getDoneTime())+"后到下载中心下载文件");
    	}
		return missionResult.isSupport() == true ? result : setFail(result);
    }
	
	private MissionRequestParam getRequestParam(String biz , HttpServletRequest request,  PastParamDto dataParam){
        MissionRequestParam requestParam = new MissionRequestParam();
        requestParam.setAppKey(INVEST);
        requestParam.setMissionKey(Assert.equals(biz,PDF) ? PASTPDFKEY : PASTEXCELKEY);
        Long userId = commonService.getUserId(request);
        requestParam.setUserId(userId);
        requestParam.setOrgId(commonService.getOrgIdByUserId(userId));
        requestParam.setClassName(PastParamDto.class.getName());
        requestParam.setParamValue(JSON.toJSONString(dataParam));
        return requestParam;
    }
	
	@RequestMapping(value = "{biz}_report_plus.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> downloadPastPlus(@PathVariable("biz") String biz,HttpServletRequest request,@RequestBody PastParamVo vo) {
    	Assert.notNull("pdf()** vo is null",vo);
    	Map<String, Object> result = result();
    	PastParamDto dto = new PastParamDto();
    	if(null==dto.getCreateTime()){
    		dto.setCreateTime(vo.getCreateTimePre());
    	}
    	if(null==dto.getReportDate()){
    		dto.setReportDate(vo.getReportDayPre());
    	}
    	dto.setLenderCodes(vo.getLenderCodes());
    	if(null!=vo.getIsQuery()){
    		dto.setIsQuery(vo.getIsQuery());
    		if("excel".equals(biz)){
    			try {
        			dto = setPlusDto(vo);
        			if(null==dto){
        				result.put("msg","获取预览数据异常");
        				return result;
        			}
        		} catch (ParseException e) {
        			LOG.error("PastPlus for downloading assembling PastParamDto is failed");
        			e.printStackTrace();
        		}
    		}
    	}
    	MissionRequestParam requestParam = getPastPlusRequestParam(biz,request, dto);
    	MissionResultDto missionResult = missionRequestService.request(requestParam);
    	if(missionResult.isSupport()){
    		SimpleDateFormat getLeftTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    		result.put("msg", "请于"+getLeftTime.format(missionResult.getDoneTime())+"后到下载中心下载文件");
    	}
		return missionResult.isSupport() == true ? result : setFail(result);
    }
	
	private MissionRequestParam getPastPlusRequestParam(String biz , HttpServletRequest request,  PastParamDto dataParam){
		MissionRequestParam requestParam = new MissionRequestParam();
        requestParam.setAppKey(INVEST);
        requestParam.setMissionKey(Assert.equals(biz,PDF) ? PAST_PLUSPDFKEY : PAST_PLUSEXCELKEY);
        Long userId = commonService.getUserId(request);
        requestParam.setUserId(userId);
        requestParam.setOrgId(commonService.getOrgIdByUserId(userId));
        requestParam.setClassName(PastParamDto.class.getName());
        requestParam.setParamValue(JSON.toJSONString(dataParam));
        return requestParam;
    }
	
	@RequestMapping("/preview.json")
    public Object init(@RequestBody PastPreviewParamVo paramVo, Model model) {
		String lenderCode = paramVo.getLenderCode();
		String createTimePre = paramVo.getCreateTimePre();
		String reportDayPre = paramVo.getReportDayPre();
    	Map<String, Object> result = setParam(lenderCode,createTimePre,reportDayPre);//get数据;
    	model.addAttribute(REPORT, result.get("result"));
        return "/view/past/pastReport";
    }
	
	public <P, R> Map<String, Object> setParam(String lenderCode, String createTimePre,String reportDayPre ) {
		ReportParamDto<P, R> param = new ReportParamDto<P, R>();
		param.setView(true);
		//获取模板
		TempalteJudge jude = new TempalteJudge();
		jude.setBizType(1);
		jude.setReportType(ReportType.PAST.getCode());
		try {
			jude.setTemplate(freeMarkerConfigurer.getConfiguration().getTemplate("/view/past/pastResport.ftl"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		param.setTemplate(jude.getTemplate());
		param.setTemplatePath(jude.getTemplatePath());
		
		//获取数据
		PastProtocolViewResult views = pastViewService.getPreData(lenderCode, createTimePre, reportDayPre);
		//PastProtocolViewResultVo views = new PastProtocolViewResultVo();
		views.setIsView(true);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("url", param.getTemplatePath());
		result.put("result", views);
		return result;
	}
	
	@RequestMapping("/preview_plus.json")
    public Object initForPlus(@RequestBody PastPreviewParamVo paramVo, Model model) {
		String lenderCode = paramVo.getLenderCode();
		String createTimePre = paramVo.getCreateTimePre();
		String reportDayPre = paramVo.getReportDayPre();
    	Map<String, Object> result = setPlusParam(lenderCode,createTimePre,reportDayPre);//get数据;
    	model.addAttribute(REPORT, result.get("result"));
        return "/view/past/pastPlusReport";
    }
	
	public <P, R> Map<String, Object> setPlusParam(String lenderCode, String createTimePre,String reportDayPre ) {
		ReportParamDto<P, R> param = new ReportParamDto<P, R>();
		param.setView(true);
		//获取模板
		TempalteJudge jude = new TempalteJudge();
		jude.setBizType(1);
		jude.setReportType(ReportType.PAST.getCode());
		try {
			jude.setTemplate(freeMarkerConfigurer.getConfiguration().getTemplate("/view/past/pastPlusReport.ftl"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		param.setTemplate(jude.getTemplate());
		param.setTemplatePath(jude.getTemplatePath());
		
		//获取数据
		PastProtocolViewResult views = pastViewService.getPreData(lenderCode, createTimePre, reportDayPre);
		//PastProtocolViewResultVo views = new PastProtocolViewResultVo();
		views.setIsView(true);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("url", param.getTemplatePath());
		result.put("result", views);
		return result;
	}

	private String getCache(String key) {
        try {
            return wmsRedisClient.get(key);
        } catch (Exception e) {
            LOG.error("error:{}", e.getMessage());
            return "";
        }
    }

}
