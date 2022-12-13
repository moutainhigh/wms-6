package com.dx.cmm.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.UserVo;
import com.dx.cmm.service.report.dto.ProtocolParam;
import com.dx.cmm.service.report.IFundReportService;
import com.dx.common.service.utils.MapUtils;
import com.dx.dcs.api.dto.MissionRequestParam;
import com.dx.dcs.service.IMissionRequestService;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.IProductService;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.WebCommonUtil;

public class BaseController {

    private Map<String, Object> initMap = new HashMap<>();

    private static final String USER = "user";

    private static final String USER_ID = "userId";

    protected static final String PORT = "port";

    protected static final String INVEST = "wms";

    protected static final String CREDIT = "ccs";
    
    protected static final String PDF = "pdf";
    
    protected static final String EXCEL = "excel";

    protected static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
    
    protected static final String INIT_HTM = "/list.htm";
    
    protected static final String INIT_URL = "/list.json";
    
    protected static final String REPORT = "report";

    @Autowired
    protected IProductService productService;
    
    @Autowired
    protected ICommonService commonService;

    @Autowired
    protected IAMService amService;
    
    @Autowired
    protected IMissionRequestService missionRequestService;
    
    @Autowired
    protected IFundReportService fundReportService;

    protected static final Map<String, String> SORT = new HashMap<String, String>() {
        private static final long serialVersionUID = -228724867842014405L;

        {
            put("ASC", "升序");
            put("DESC", "降序");
        }
    };

    protected Map<String, Object> initMap(HttpServletRequest request) {
        initMap.put(USER_ID, WebCommonUtil.getUserId(request));
        return initMap;
    }

    protected UserVo getUser(HttpServletRequest request) {
        HttpSession session = (HttpSession) request.getSession();
        return (UserVo) session.getAttribute(USER);
    }

    protected Long getUserId(HttpServletRequest request) {
        return getUser(request).getUserId();
    }

    protected Pagination init(DataTableObj dTable) {
        Pagination page = new Pagination();
        if (dTable.getCurrentPage() > 0) {
            page.setCurrentPage(dTable.getCurrentPage());
        }
        page.setPagesize(dTable.getiDisplayLength());
        return page;
    }

    protected Map<String, Object> result() {
        Map<String, Object> result = MapUtils.getParamMap("result", true);
        result.put("msg", "操作成功");
        return result;
    }
    
    protected Map<String, Object> setFail(Map<String, Object> result){
    	result.put("result", Boolean.FALSE);
    	result.put("msg", "任务添加失败");
    	return result;
	}
    
    
    protected MissionRequestParam getRequestParam(String biz , HttpServletRequest request,  ProtocolParam dataParam,
    		String missionKey){
    	MissionRequestParam requestParam = new MissionRequestParam();
    	requestParam.setAppKey(INVEST);
    	requestParam.setMissionKey(missionKey);
    	Long userId = commonService.getUserId(request);
    	requestParam.setUserId(userId);
    	requestParam.setOrgId(commonService.getOrgIdByUserId(userId));
    	requestParam.setClassName(ProtocolParam.class.getName());
    	requestParam.setParamValue(JSON.toJSONString(dataParam));
    	return requestParam;
    }
    
}
