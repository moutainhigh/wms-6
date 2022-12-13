/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: WebCommonController.java
 * Author:   王蕊
 * Date:     2015年7月22日 下午7:56:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.trans.controller;

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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.ccs.constans.AMDubboConstant;
import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.transfer.ICustTransferService;
import com.dx.wms.service.transfer.ParamTransfer;
import com.dx.wms.service.transfer.ResultTransLog;
import com.dx.wms.service.transfer.ResultTransfer;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.trans.vo.TransLogVo;
import com.dx.wms.web.trans.vo.TransParamVo;
import com.dx.wms.web.trans.vo.TransResultVo;
import com.dx.wms.web.util.WebCommonUtil;
import com.google.gson.Gson;

/**
 * 客户转移
 * 
 * @author huangjian
 */
@Controller
@RequestMapping("/custTransfer")
public class CustTransferController {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CustTransferController.class);
    
    static final String TRANS_LOG = "/log.json";
    
    static final String LOG_PAGE = "custTransfer/logMessage";
    
    static final String LOG_QUERY = "queryLog.json";

    /**
     * 通用服务
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 客户转移服务
     */
    @Autowired
    private ICustTransferService custTransferService;

    /**
     * 客户转移管理
     * 
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/list.htm")
    public String initPage(ModelMap model, HttpServletRequest request) {
        model.addAttribute("orgIds", commonService.getOrgVos(AMDubboConstant.ORG_TYPE_WMS));
        return "custTransfer/list";
    }

    /**
     * 
     * 客户转移管理查询数据
     * 
     * @param custViewQueryVo
     * @param request
     * @param dTable
     * @return
     */
    @RequestMapping("list_do.json")
    @ResponseBody
    public AjaxDataTableObj<TransResultVo> listByPage(TransParamVo queryVo, HttpServletRequest request,
            DataTableObj dTable) {
        LOG.info("** listByPage() ** custTransferQueryVo={}**", new Gson().toJson(queryVo));
        Pagination pagination = WebCommonUtil.initPage(dTable);
        	if (!Assert.checkParam(queryVo.getOrgId()) || !Assert.checkParam(queryVo.getCluster())
                || !Assert.checkParam(queryVo.getTeamId()) ||!Assert.checkParam(queryVo.getCustManagerId())) {
        		if(!Assert.checkParam(queryVo.getCustName()) && !Assert.checkParam(queryVo.getLenderCustCode())
                        && !Assert.checkParam(queryVo.getMobile()) && !Assert.checkParam(queryVo.getIdCard())){
        			pagination.setTotalRows(0);
                    return new AjaxDataTableObj<TransResultVo>(dTable,
                            new PaginationResult<List<TransResultVo>>(new ArrayList<TransResultVo>(), pagination));
        		}
        }
        return new AjaxDataTableObj<TransResultVo>(dTable,
                convertResults(custTransferService.queryForPage(convertQuery(queryVo, pagination))));
    }

    private ParamTransfer convertQuery(TransParamVo queryVo, Pagination pagination) {
        ParamTransfer queryDto = new ParamTransfer();
        BeanUtils.copyProperties(queryVo, queryDto);
        queryDto.setPagination(pagination);
        return queryDto;
    }

    private PaginationResult<List<TransResultVo>> convertResults(
            PaginationResult<List<ResultTransfer>> custTransferResultDtoes) {
        List<TransResultVo> results = new ArrayList<TransResultVo>();
        Long orgId = null;
        Long teamId = null;
        for (ResultTransfer dto : custTransferResultDtoes.getR()) {
            Map<Long, OrgVo> orgMap = new HashMap<Long, OrgVo>();
            Map<Long, UserVo> userMap = new HashMap<Long, UserVo>();
            if(!Assert.checkParam(dto.getOrgId())){
            	orgId = commonService.getOrgIdByUserId(dto.getCustManagerId());
            }else{
            	orgId = dto.getOrgId();
            }
            if(!Assert.checkParam(dto.getTeamId())){
            	teamId = commonService.getTeamIdByUserId(dto.getCustManagerId());
            }else{
            	teamId = dto.getTeamId();
            }
            String orgName = commonService.queryOrgCache(orgId, orgMap).getName();//营业部
            OrgVo teamVo = commonService.queryOrgCache(teamId, orgMap);//小团
            OrgVo clusterVo = commonService.queryClusterCache(teamVo, orgMap);//大团信息
            String custManager = commonService.queryUserCache(dto.getCustManagerId(), userMap).getName();//客户经理
            results.add(new TransResultVo(dto, orgName, teamVo, clusterVo, custManager));
        }
        return new PaginationResult<List<TransResultVo>>(results, custTransferResultDtoes.getPagination());
    }

    @RequestMapping(value = "orgs.json")
    @ResponseBody
    public List<OrgVo> queryOrgs(Long orgId, HttpServletRequest request) {
        return commonService.queryOrgsByParentId(orgId);
    }

    @RequestMapping(value = "custManagers.json")
    @ResponseBody
    public List<UserVo> queryCustManagers(Long orgId, String custIds, Boolean isTransfer, HttpServletRequest request) {
        LOG.info("**queryCustManagers() isTransfer:{}**", isTransfer);
        if (isTransfer) {
            return custTransferService.queryCustManagers(custIds, orgId);
        }
        return commonService.queryUserByOrgAndRole(orgId, RoleConstant.KHJL);
    }

    @RequestMapping(value = "transfers.json")
    @ResponseBody
    public Boolean transferCusts(@RequestBody TransParamVo custTransferQueryVo, HttpServletRequest request) {
        Assert.notNull("**transferCusts() custTransferQueryVo cannot be null**", custTransferQueryVo);
        LOG.info("**transferCusts() custTransferQueryVo:{}**", new Gson().toJson(custTransferQueryVo));
        ParamTransfer custTransferQueryDto = new ParamTransfer();
        BeanUtils.copyProperties(custTransferQueryVo, custTransferQueryDto);
        return custTransferService.transferCustsToCustManager(custTransferQueryDto, commonService.getUserId(request));
    }

    
    @RequestMapping(TRANS_LOG)
    public String logRequest(Model model, HttpServletRequest request) {
       String lenderCustCode = request.getParameter("lenderCustCode");
       model.addAttribute("lenderCustCode",lenderCustCode);
       return LOG_PAGE;
       
    }
    @RequestMapping(LOG_QUERY)
    @ResponseBody
    public AjaxDataTableObj<TransLogVo> queryLog(String lenderCustCode, HttpServletRequest request,DataTableObj dTable){
       PaginationResult<List<ResultTransLog>> results = 
    		   custTransferService.queryTransLog(lenderCustCode,transToPagination(dTable));
       List<TransLogVo> transResult = new ArrayList<TransLogVo>();
       Long fromOrgId = null;
       Long fromTeamId = null;
       Long toOrgId = null;
       Long toTeamId = null;
    		   
       for(ResultTransLog dto : results.getR()){
    	   Map<Long, OrgVo> fromOrgMap = new HashMap<Long, OrgVo>();
           Map<Long, UserVo> fromManagerMap = new HashMap<Long, UserVo>();
           Map<Long, OrgVo> toOrgMap = new HashMap<Long, OrgVo>();
           Map<Long, UserVo> toManagerMap = new HashMap<Long, UserVo>();
           
           if(!Assert.checkParam(dto.getFromOrgId())){
        	   fromOrgId = commonService.getOrgIdByUserId(dto.getFromUser());
           }else{
        	   fromOrgId = dto.getFromOrgId();
           }
           if(!Assert.checkParam(dto.getToOrgId())){
        	   toOrgId = commonService.getOrgIdByUserId(dto.getToUser());
           }else{
        	   toOrgId = dto.getToOrgId();
          }
           
           if(!Assert.checkParam(dto.getFromTeamId())){
        	   fromTeamId = commonService.getTeamIdByUserId(dto.getFromUser());
           }else{
        	   fromTeamId = dto.getFromTeamId();
           }
           if(!Assert.checkParam(dto.getToTeamId())){
        	   toTeamId = commonService.getTeamIdByUserId(dto.getFromUser());
           }else{
        	   toTeamId = dto.getToTeamId();
           }
           
           String fromOrgName = commonService.queryOrgCache(fromOrgId, fromOrgMap).getName();//原营业部名字
           OrgVo fromTeamVo = commonService.queryOrgCache(fromTeamId, fromOrgMap);//原小团名字
           OrgVo fromBigTeamVo = commonService.queryClusterCache(fromTeamVo, fromOrgMap);//原大团名字
           String fromManagerName = commonService.queryUserCache(dto.getFromUser(), fromManagerMap).getName();//原客户经理名字
           
           String toOrgName = commonService.queryOrgCache(toOrgId, toOrgMap).getName();//转移后营业部名字
           OrgVo toTeamVo = commonService.queryOrgCache(toTeamId, toOrgMap);//转移后小团名字
           OrgVo toBigTeamVo = commonService.queryClusterCache(toTeamVo, toOrgMap);//转移后大团信息名字
           String toMangerName = commonService.queryUserCache(dto.getToUser(), toManagerMap).getName();//转移后客户经理名字
           
           transResult.add(new TransLogVo(dto,fromOrgName,fromTeamVo,fromBigTeamVo,fromManagerName,
        		   toOrgName,toTeamVo,toBigTeamVo,toMangerName));
           
       }
    	
        return new AjaxDataTableObj<TransLogVo>(dTable,
        		new PaginationResult<List<TransLogVo>>(transResult,results.getPagination()));
    }
    
    protected Pagination transToPagination(DataTableObj dTable) {
        Pagination page = new Pagination();
        if (dTable.getCurrentPage() > 0) {
            page.setCurrentPage(dTable.getCurrentPage());
        }
        page.setPagesize(dTable.getiDisplayLength());
        return page;
    }
}
