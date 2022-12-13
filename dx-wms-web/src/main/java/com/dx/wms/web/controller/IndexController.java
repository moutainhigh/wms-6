/*
 * Copyright (C), 2014-2018,达信财富投资管理（上海）有限公司
 * FileName: IndexController.java
 * Author:   v_gangchsh
 * Date:     2014年2月10日 上午11:04:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.alibaba.dubbo.common.utils.Log;
import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.MenuVo;
import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.RoleVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.framework.web.escape.StringEscapeSupportController;
import com.dx.wms.constant.RoleConstant;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.IDueService;
import com.dx.wms.service.IVersionService;
import com.dx.wms.service.index.IIndexExecutor;
import com.dx.wms.service.index.IndexQueryDto;
import com.dx.wms.service.index.IndexResultDto;
import com.dx.wms.web.util.WebCommonUtil;
import com.dx.wms.web.vo.MenuVO;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 初始化页面<br>
 *
 * @author 柳励
 */
@Controller
@Qualifier("IndexController")
@RequestMapping("")
public class IndexController extends StringEscapeSupportController {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    /**
     * 权限服务
     */
    @Autowired
    private IAMService amService;

    @Autowired
    private ICommonService commonService;

    /**
     * freeMarkerConfigurer
     */
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private IIndexExecutor<IndexQueryDto, IndexResultDto> indexExecutor;

    @Autowired
    private IVersionService versionService;

    @Autowired
    private IDueService dueService;

    // @RequestMapping(value = "/index.htm")
    public String initIndex(Model model, HttpServletRequest request) {
        HttpSession session = (HttpSession) request.getSession();
        UserVo user = (UserVo) session.getAttribute("user");
        IndexQueryDto queryDto = new IndexQueryDto(amService.findRolesByUserId(user.getUserId()),
                amService.queryOrgByUserId(user.getUserId()), user);
        model.addAttribute("result", indexExecutor.initDate(queryDto));
        return indexExecutor.initPage(queryDto);
    }

    /**
     * 功能描述: 初始化应用列表<br>
     * 
     * @param model 前端返回的参数信息
     * @since V1.0
     * @return String 返回字符串
     */
    @RequestMapping(value = "/index.htm")
    public String initIndex(ModelMap model, HttpServletRequest request) {
        Long userId = commonService.getUserId(request);
        Long versionId = (Long) request.getSession().getAttribute("version");
        int versionStatus = versionService.validateVersion(userId, versionId);
        model.addAttribute("versionStatus", versionStatus);
        model.addAttribute("versionId", versionId);
        // List<RoleVo> roleList = commonService.findRolesByUserId(userId);
        // Long orgId = -1L;
        // if (Assert.checkParam(roleList)) {
        // if (commonService.hasRoleExist(roleList, RoleConstant.XSKF)) {
        // orgId = commonService.getOrgIdByUserId(userId);
        // }
        // for (RoleVo role : roleList) {
        // if (StringUtils.isNotBlank(role.getCode())) {
        // Map<String, Object> paramMap = new HashMap<>();
        // if ("WMS-KHJL".equals(role.getCode())) {
        // paramMap.put("createUser", userId);
        // paramMap.put("indexQuery", "customerManage");
        // IndexDisplayDto dto = indexDisplayObserverdService.informObservers(paramMap);
        // IndexVo idxVo = getCustManagerIndexPage(dto);
        // addInfoToModel(model, idxVo);
        // return "indexPage/index_page";
        // } else if ("WMS-XSKF".equals(role.getCode())) {
        // paramMap.put("orgId", orgId);
        // paramMap.put("indexQuery", "customerService");
        // IndexDisplayDto dto = indexDisplayObserverdService.informObservers(paramMap);
        // IndexVo idxVo = getCustServiceIndexPage(dto);
        // addInfoToModel(model, idxVo);
        // return "indexPage/index_page";
        // } else if ("WMS-ZWH".equals(role.getCode()) || "WMS-ZWH-TZSH".equals(role.getCode())) {
        // paramMap.put("indexQuery", "executiveCommittee");
        // IndexDisplayDto dto = indexDisplayObserverdService.informObservers(paramMap);
        // IndexVo idxVo = getExecutiveCommitteeIndexPage(dto);
        // addInfoToModel(model, idxVo);
        // return "indexPage/index_page";
        // } else if ("WMS-YY".equals(role.getCode())) {
        // addInfoToModel(model, getOperationIndex());
        // return "indexPage/index_page";
        // }
        // }
        // }
        // }
        request.setAttribute("currentUser", userId);
        return "indexPage/index_page";
    }

    @RequestMapping("menu.json")
    @SuppressWarnings("unchecked")
    public void menu(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute(WMSConstants.USER_ID);
        try {
            if (StringUtils.isNotBlank(userId.toString())) {
                List<MenuVO> menus = (List<MenuVO>) session.getAttribute(WMSConstants.MENUS);
                if (menus == null) {
                    List<MenuVo> menusTemp = amService.findMenusByUserIdAndApp(Long.valueOf(userId), WMSConstants.WMS);
                    LOG.info("menu() menusTemp size={}", menusTemp.size());
                    menus = WebCommonUtil.getAmMenus(menusTemp);
                }
                String html = generateMenuHtml(request, menus);
                PrintWriter writer = response.getWriter();
                writer.write(html);
            }
        } catch (IOException e) {
            LOG.error("menu() exception={}", e);
        }
    }

    @RequestMapping("head.json")
    public void head(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, Object> model = new HashMap<String, Object>();
            String domainPath = request.getScheme() + "://" + request.getServerName();
            int port = request.getServerPort();
            if (port != 80) {
                domainPath = domainPath + ":" + port;
            }
            model.put("baseUrl", domainPath + request.getContextPath() + "/");
            LOG.info("ip:"+domainPath);
            model.put("title", "达信财富");
            Template template = this.freeMarkerConfigurer.getConfiguration().getTemplate("/common/head.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            PrintWriter writer = response.getWriter();
            writer.write(html);
        } catch (IOException | TemplateException e) {
            LOG.error("head() exception={}", e);
        }
    }

    /**
     * 功能描述: <br>
     * 生成top
     * 
     * @param request
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("top.json")
    public void top(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Long sessionUserId = (Long) session.getAttribute(WMSConstants.USER_ID);
        try {
            if (StringUtils.isNotBlank(sessionUserId.toString())) {
                Map<String, Object> model = new HashMap<String, Object>();
                String domainPath = request.getScheme() + "://" + request.getServerName();
                int port = request.getServerPort();
                if (port != 80) {
                    domainPath = domainPath + ":" + port;
                }
                List<RoleVo> roleList = commonService
                        .findRolesByUserId((Long) request.getAttribute(WMSConstants.USER_ID));
                if (Assert.checkParam(roleList)) {
                    for (RoleVo roleVo : roleList) {
                        if ("WMS-KHJL".equals(roleVo.getCode())) {
                            List<String> custNames = dueService.queryDueCustName(getDueApplyIds(), sessionUserId);
                            model.put("custNames", custNames);
                            model.put("dueNO", custNames.size() - 1);
                            model.put("dueManager", "到期管理");
                        }
                    }
                }
                model.put("baseUrl", domainPath + request.getContextPath());
                LOG.info("ip:"+domainPath);
                UserVo user = (UserVo) session.getAttribute(WMSConstants.USER);
                model.put("user", user);
                OrgVo org = (OrgVo) session.getAttribute(WMSConstants.ORG);
                OrgVo parentOrg = (OrgVo) session.getAttribute("parentOrg");
                OrgVo allOrg = (OrgVo) session.getAttribute("allOrg");
                model.put("org", org);
                model.put("parentOrg", parentOrg);
                model.put("allOrg", allOrg);
                List<RoleVo> roleVos = amService.findRolesByUserId((Long) request.getAttribute(WMSConstants.USER_ID));
                // 判断当前角色
                int role = 0;
                if (Assert.checkParam(roleVos)) {
                    for (RoleVo roleVo : roleVos) {
                        if (roleVo.getCode().equals(RoleConstant.XSKF)) {
                            role = 1;
                        } else if (roleVo.getCode().equals(RoleConstant.ZWH)
                                || roleVo.getCode().equals(RoleConstant.TZSH)) {
                            role = 2;
                        } else if (roleVo.getCode().equals(RoleConstant.YY)) {
                            role = 3;
                        }
                    }
                }
                model.put("role", role);
                Template template = freeMarkerConfigurer.getConfiguration().getTemplate("/common/top.ftl");
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                PrintWriter writer = response.getWriter();
                writer.write(html);
            }
        } catch (IOException | TemplateException e) {
            LOG.error("top() exception={}", e);
        }
    }

    private List<Long> getDueApplyIds() {
        List<Long> idsList = dueService.getDueIds("RAJ");
        if (Assert.checkParam(idsList)) {
            return idsList;
        }
        idsList.add(-1L);
        return idsList;
    }

    /**
     * 功能描述: <br>
     * 生成footer
     * 
     * @param request request
     * @param response response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("footer.json")
    public void footer(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Long sessionUserId = (Long) session.getAttribute(WMSConstants.USER_ID);
        try {
            if (StringUtils.isNotBlank(sessionUserId.toString())) {
                Map<String, Object> model = new HashMap<String, Object>();
                Template template = freeMarkerConfigurer.getConfiguration().getTemplate("/common/footer.ftl");
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                PrintWriter writer = response.getWriter();
                writer.write(html);
            }
        } catch (IOException | TemplateException e) {
            LOG.error("footer() exception={}", e);
        }
    }

    /**
     * 功能描述: 初始化 登录页面<br>
     * 
     * @param model 前端返回的参数信息
     * @since V1.0
     * @return String 返回字符串
     */
    @RequestMapping(value = "/login.htm")
    public String login() {
        return "login/login3";
    }

    /**
     * 功能描述: <br>
     * 生成菜单
     * 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String generateMenuHtml(HttpServletRequest request, List<MenuVO> menus) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put(WMSConstants.MENUS, menus);
        String domainPath = request.getScheme() + "://" + request.getServerName();
        int port = request.getServerPort();
        if (port != 80) {
            domainPath = domainPath + ":" + port;
        }
        model.put("baseUrl", domainPath + request.getContextPath());
        LOG.info("ip:"+domainPath);
        try {
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("/common/menu.ftl");
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // private IndexVo getCustManagerIndexPage(IndexDisplayDto dto) {
    // Assert.notNull("** getCustManagerIndexPage() dto can not be null", dto);
    // LOG.info("** getCustManagerIndexPage() param dto={} ", dto);
    // IndexVo vo = new IndexVo();
    // vo.setTheFirstModel(dto.getCustNum().toString());
    // vo.setTheSecondModel(dto.getRefusedApplyNum().toString());
    // vo.setTheThirdModel(dto.getCustAccountNum().toString());
    // vo.setTheForthModel(WMSConstants.EMPTY);
    // vo.setTheFifthModel(AmountUtils.format(dto.getSumLenderAmount(), "0"));
    // vo.setTheSixthModel(WMSConstants.EMPTY);
    // return vo;
    //
    // }

    // private IndexVo getCustServiceIndexPage(IndexDisplayDto dto) {
    // Assert.notNull("** getCustServiceIndexPage() dto can not be null", dto);
    // LOG.info("** getCustServiceIndexPage() param dto={} ", dto);
    // IndexVo vo = new IndexVo();
    // vo.setTheFirstModel(dto.getCustNum().toString());
    // vo.setTheSecondModel(dto.getRefusedApplyNum().toString());
    // vo.setTheThirdModel(dto.getPendingQualityApplyNum().toString());
    // vo.setTheForthModel(dto.getCustAccountNum().toString());
    // vo.setTheFifthModel(AmountUtils.format(dto.getSumLenderAmount(), "0"));
    // vo.setTheSixthModel(WMSConstants.EMPTY);
    // return vo;
    // }
    //
    // private IndexVo getExecutiveCommitteeIndexPage(IndexDisplayDto dto) {
    // Assert.notNull("** getExecutiveCommitteeIndexPage() dto can not be null", dto);
    // LOG.info("** getExecutiveCommitteeIndexPage() param dto={} ", dto);
    // IndexVo vo = new IndexVo();
    // vo.setTheFirstModel(dto.getEffectiveApplyNum().toString());
    // vo.setTheSecondModel(dto.getRefusedApplyNum().toString());
    // vo.setTheThirdModel(dto.getPendingCheckApplyNum().toString());
    // vo.setTheForthModel(WMSConstants.EMPTY);
    // vo.setTheFifthModel(AmountUtils.format(dto.getSumLenderAmount(), "0"));
    // vo.setTheSixthModel(WMSConstants.EMPTY);
    // return vo;
    // }

    // private IndexVo getOperationIndex() {
    // IndexVo vo = new IndexVo();
    // return vo;
    // }

    // private void addInfoToModel(ModelMap model, IndexVo idxVo) {
    // Assert.notNull("** addInfoToModel() idxVo can not be null", idxVo);
    // LOG.info("** addInfoToModel() param idxVo={} ", idxVo);
    // model.addAttribute("theFirstValue", idxVo.getTheFirstModel());
    // model.addAttribute("theSecondValue", idxVo.getTheSecondModel());
    // model.addAttribute("theThirdValue", idxVo.getTheThirdModel());
    // model.addAttribute("theForthValue", idxVo.getTheForthModel());
    // model.addAttribute("theFifthValue", idxVo.getTheFifthModel());
    // model.addAttribute("theSixthValue", idxVo.getTheSixthModel());
    // }

}
