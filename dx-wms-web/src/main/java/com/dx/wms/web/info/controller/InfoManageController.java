package com.dx.wms.web.info.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.infoManage.InfoManageService;
import com.dx.cmm.service.infoManage.dto.InfoManageParamDto;
import com.dx.cmm.service.infoManage.dto.InfoManageResultDto;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.ICommonService;
import com.dx.wms.web.info.vo.InfoManageParamVo;
import com.dx.wms.web.info.vo.InfoManageResultVo;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.WebCommonUtil;

@Controller
@RequestMapping("/infoManage")
public class InfoManageController {
	/**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(InfoManageController.class);
    
    private static final String LIST = "/list.htm";
    
    private static final String DETAIL = "/detail.htm";
    
    private static final String LIST_PAGE = "infoManage/list";
    
    private static final String LIST_DETAIL = "infoManage/detail";
    
    private static final String PRODUCT = "product";
    
    private static final String CURRENT_STEP = "currentStep";
    
    @Autowired
    private ICommonService commonService;
    
    @Autowired
    private InfoManageService infoManage;
    
    @RequestMapping(LIST)
    public String initPage(ModelMap model, HttpServletRequest request) {
    	model.addAttribute(PRODUCT, commonService.getProductByProductId());
    	model.addAttribute(CURRENT_STEP, commonService.queryStatus());
        return LIST_PAGE;
    }
	
    
    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<InfoManageResultVo> query(InfoManageParamVo param, HttpServletRequest request, DataTableObj dTable) {
         Pagination page = WebCommonUtil.initPage(dTable);
    	return new AjaxDataTableObj<InfoManageResultVo>(dTable,
    			trans2Page(infoManage.queryList(trans2Dto(param), page)));
    }

    
    private InfoManageParamDto trans2Dto(InfoManageParamVo param){
    	InfoManageParamDto dto = new InfoManageParamDto();
    	BeanUtils.copyProperties(param, dto);
    	return dto;
    }
    
    private PaginationResult<List<InfoManageResultVo>> trans2Page(PaginationResult<List<InfoManageResultDto>> page) {
    	Map<String, String> productMap = commonService.getProductByProductId();
        Map<String, String> statusMap = commonService.queryStatus();
        List<InfoManageResultVo> results = new ArrayList<InfoManageResultVo>();
    	for(InfoManageResultDto dto : page.getR()){
    		results.add(new InfoManageResultVo(dto,productMap,statusMap));
    	}
    	return new PaginationResult<List<InfoManageResultVo>>(results, page.getPagination());
    }
}
