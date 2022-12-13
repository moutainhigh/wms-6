/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: UserController.java
 * Author:   柳励
 * Date:     2015年1月27日 下午2:44:53
 * Description: //黑名单客户
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.bpm.constants.ProcessConstans;
import com.dx.bpm.service.IProcessDefinitionService;
import com.dx.ccs.service.IAMService;
import com.dx.ccs.vo.MenuVo;
import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.ResourceVo;
import com.dx.ccs.vo.UserVo;
import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;
import com.dx.framework.web.escape.StringEscapeSupportController;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.web.util.LtpaTokenUtil;
import com.dx.wms.web.util.WebCommonUtil;
import com.dx.wms.web.vo.MenuVO;
import com.google.gson.Gson;

/**
 * 〈一句话功能简述〉<br>
 * 用户Controller
 * 
 * @author v_bjwangxl
 */
@Controller
@RequestMapping("/user")
public class UserController extends StringEscapeSupportController {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    /**
     * 日志组件
     */
    private static final Logger loginLog = LoggerFactory.getLogger("LOGIN");
   
    /**
     * 权限服务
     */
    @Autowired
    private IAMService amService;

    /**
     * 系统服务URL
     */
    @Value("${wms.web.ipAddress}")
    private String BASE_URL = "";

    /**
     * 单点登录的Util
     */
    @Autowired
    private LtpaTokenUtil tokenUtil;

    /**
     * 登录token
     */
    private static final String SSOCOOKIE = "sc_s";

    private static final String AUTH_CODE = "e10adc3949ba59abbe56e057f20f883e";

    @Autowired
    private IProcessDefinitionService processDefinitionService;

    // /**
    // * 用户服务
    // */
    // @Autowired
    // private IUserService userService;

    /**
     * 
     * 功能描述: 登录校验
     *
     * @param user 用户名 密码
     * @param request
     * @return
     */
    @RequestMapping(value = "/validate.do", method = RequestMethod.POST)
    public String loginValidate(@ModelAttribute("user") UserVo user,@RequestParam("versionId") String versionId, HttpServletRequest request,
            HttpServletResponse response) {
        loginLog.info("***start login***userName:{}**", new Object[] { user.getUserName() });
        String result = "redirect:/login.htm";
        UserVo validateUser = null;
        Integer loginRet = 1;
        try {
            validateUser = amService.validatePwd(user);
            loginRet = validateUser.getLoginRet();
        } catch (BaseException e) {
            LOG.error("error:" + e.getFriendlyMessage());
        }
        LOG.info("user{}", new Gson().toJson(validateUser));
        if (validateUser != null && loginRet == 1) {
            loginLog.info("***userId:{}/userName:{}/name:{}***",
                    new Object[] { validateUser.getUserId(), validateUser.getUserName(), validateUser.getName() });
            try {
                // 是否成功生产都不影响正常登录，无需抛出异常
                this.getCookieForRequest(validateUser.getUserId(), request, response);
            } catch (Exception e) {
                LOG.error("***error***" + e.getMessage());
            }
            List<MenuVo> menus = amService.findMenusByUserIdAndApp(validateUser.getUserId(), WMSConstants.WMS);
            LOG.info("menu size{}", menus.size());
            List<MenuVO> menuVos = WebCommonUtil.getAmMenus(menus);
            LOG.info("menuVo size{}", menuVos.size());
            List<ResourceVo> resources = amService.findResourcesByUserIdAndApp(validateUser.getUserId(),
                    WMSConstants.WMS);
            OrgVo org = amService.queryOrgByUserId(validateUser.getUserId());
            OrgVo parentOrg = amService.queryOrgById(org.getParentId());
            OrgVo allOrg = amService.queryOrgById(parentOrg.getParentId());
            request.getSession().setAttribute(WMSConstants.ORG, org);
            request.getSession().setAttribute("parentOrg", parentOrg);
            request.getSession().setAttribute("allOrg",allOrg);
            request.getSession().setAttribute(WMSConstants.USER, validateUser);
            request.getSession().setAttribute(WMSConstants.USER_ID, validateUser.getUserId());
            request.getSession().setAttribute(WMSConstants.MENUS, menuVos);
            request.getSession().setAttribute(WMSConstants.RESOURCES, resources);
            request.getSession().setAttribute(WMSConstants.TITLE, "达信财富");
            //request.getSession().setAttribute(WMSConstants.BASE_URL, BASE_URL);
            request.getSession().setAttribute("version", Long.parseLong(versionId));
            result = "redirect:/index.htm";
        } else {
            loginLog.info("***end login***{}:您输入的用户名或密码不正确!****", new Object[] { user.getUserName() });
            if (loginRet == 2) {
                request.getSession().setAttribute("promptMsg", "您输入的用户名或密码不正确!");
            } else if (loginRet == 3) {
                request.getSession().setAttribute("promptMsg", "您输入密码超过最大错误次数，请3小时后再来!");
            }
        }

        return result;
    }

    // 跳转修改密码页面
    @RequestMapping(value = "/updatePassView.htm", method = RequestMethod.GET)
    public String updatePassView(ModelMap model, HttpServletRequest request) {
        String returnUrl = "login/updatePassWord";

        return returnUrl;
    }

    // 请求修改
    @RequestMapping("updatePassWord.json")
    @ResponseBody
    public boolean updatePassWord(@ModelAttribute("oldPassword") String oldPassword,
            @ModelAttribute("newPassword1") String newPassword1, ModelMap model, HttpServletRequest request,
            HttpServletResponse response) {
        LOG.info("***修改用户密码***");
        HttpSession session = (HttpSession) request.getSession();
        UserVo user = (UserVo) session.getAttribute("user");
        loginLog.info("***updatePassWord***user:{}**", new Gson().toJson(user));
        LOG.info("user{}", new Gson().toJson(user));
        Boolean changeState = false;
        loginLog.info("***updatePassWord***validateUser is not null**");
        String md5NewPassword = DigestUtils.md5Hex(newPassword1);
        String md5OldPassword = DigestUtils.md5Hex(oldPassword);
        changeState = amService.changePassword(md5NewPassword, md5OldPassword, user.getUserName());

        return changeState;
    }

    /**
     * 
     * 注销
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginout.do", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        LOG.info("start loginout");
        String result = "redirect:/login.htm";
        HttpSession session = request.getSession();
        UserVo user = (UserVo) session.getAttribute("user");
        loginLog.info("***loginOut***user:{}**", new Gson().toJson(user));

        session.removeAttribute(WMSConstants.USER);
        session.removeAttribute(WMSConstants.MENUS);
        session.removeAttribute(WMSConstants.RESOURCES);
        session.invalidate();

        // 根据HTTP请求的头域Host决定Cookie的域值
        String host = request.getHeader("Host");
        LOG.info("**host**" + host);
        // 提取HOST
        String decodedHost = "";
        try {
            // 删除cookie不成功不影响注销
            decodedHost = decodeHostFromUrl(host);
        } catch (Exception e) {
            LOG.error("***error**" + e.getMessage());
        }
        LOG.info("**decodedHost**" + decodedHost);
        if (StringUtils.isNotBlank(decodedHost)) {
            Cookie cookie0 = new Cookie(SSOCOOKIE, null);
            cookie0.setDomain(decodedHost);
            cookie0.setMaxAge(0);
            cookie0.setPath("/");
            response.addCookie(cookie0);
        }

        LOG.info("end loginout");
        return result;
    }

    private void getCookieForRequest(Long userId, HttpServletRequest request, HttpServletResponse response) {
        LOG.info("****start getCookieForRequest***" + userId);
        OrgVo org = amService.queryOrgByUserId(userId);
        if (org != null) {
            StringBuffer token = new StringBuffer("");
            token.append(userId).append("|").append(org.getOrgId()).append("|").append(org.getCode()).append("|")
                    .append(org.getOrgType());
            LOG.info("**token***" + token.toString());
            String scs = tokenUtil.createToken(token.toString(), "", new GregorianCalendar());
            LOG.info("**scs***" + scs);
            Cookie cookie = new Cookie(SSOCOOKIE, scs);
            // 根据HTTP请求的头域Host决定Cookie的域值
            String host = request.getHeader("Host");
            LOG.info("***host**" + host);
            // 提取HOST
            String decodedHost = decodeHostFromUrl(host);
            LOG.info("***decodedHost**" + decodedHost);
            cookie.setDomain(decodedHost);
            cookie.setPath("/");
            // 不自动登陆,浏览器关闭cookie无效
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
        }
        LOG.info("****end getCookieForRequest***");
    }

    /**
     * 
     * 功能描述: 解析域名<br>
     * 〈功能详细描述〉从请求中获取域名
     * 
     * @param host 请求
     * @return String 返回域名
     * @see
     * @since
     */
    private static String decodeHostFromUrl(String host) {
        String regexDomain = "(?!h|t|t|p|:|/)[a-z]*.*(com|net|org)";
        Pattern pattern = Pattern.compile(regexDomain);
        Matcher matcher = pattern.matcher(host);
        while (matcher.find()) {
            return matcher.group(0);
        }
        String regexIP = "\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}";
        Pattern p = Pattern.compile(regexIP);
        Matcher m = p.matcher(host);
        while (m.find()) {
            return m.group(0);
        }
        return null;
    }

    @RequestMapping(value = "/initDeployActivitiProcess.htm")
    public String initDeployActivitiProcess(@RequestParam("processType") String processType,
            @RequestParam("authCode") String authCode) {
        LOG.info("****start***initDeployActivitiProcess****processType:{},authCode:{}**", processType, authCode);
        if (StringUtils.equals(authCode, AUTH_CODE)) {
            LOG.info("authCode:" + authCode);
            if (StringUtils.equals(processType, "loanApplication")) {
                processDefinitionService.intiDeployActivitiProcess(ProcessConstans.DEPLOY_BPMN_LOANAPPLICATION);
            } else if (StringUtils.equals(processType, "reconsiderApplication")) {
                processDefinitionService.intiDeployActivitiProcess(ProcessConstans.DEPLOY_BPMN_RECONSIDERAPPLICATION);
            } else if (StringUtils.equals(processType, "reduceApplication")) {
                processDefinitionService
                        .intiDeployActivitiProcess(ProcessConstans.DEPLOY_BPMN_REDUCEPENALTYAPPLICATION);
            } else if (StringUtils.equals(processType, "wealthApplication")) {
                processDefinitionService.intiDeployActivitiProcess(ProcessConstans.DEPLOY_BPMN_LOANWEALTHAPPLICATION);
            } else if (StringUtils.equals(processType, "reconsiderSubApplication")) {
                processDefinitionService
                        .intiDeployActivitiProcess(ProcessConstans.DEPLOY_BPMN_RECONSIDERSUBAPPLICATION);
            }
        }
        LOG.info("****end***initDeployActivitiProcess****");
        return "true";

    }



    /**
     * 
     * 功能描述: 验证码前验证<br>
     * 〈功能详细描述〉登录页面 验证码验证 提示
     * 
     * @param size 请求
     * @return String 验证码
     * @see
     * @since
     */
    @ResponseBody
    @RequestMapping(value = "/checkValidate.json")
    public Map<String, String> checkValidate(@RequestBody String validateCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, String> checkInfo = new HashMap<String, String>();
        String validate = session.getAttribute("validatecode") + "";
        Long codeTime = (Long) session.getAttribute("codeTime");
        Long currentTime = System.currentTimeMillis();
        // 判断验证码是否超时
        if (!Assert.checkParam(codeTime) || (currentTime - codeTime) > 60000) {
            checkInfo.put("checkStatus", "1");
            checkInfo.put("checkInfo", "验证码输入超时");
            return checkInfo;
        }
        // 判断验证码是否正确
        if (validateCode.equalsIgnoreCase(validate)) {
            checkInfo.put("checkStatus", "0");
            checkInfo.put("checkInfo", "验证码输入正确");
            return checkInfo;
        } else {
            checkInfo.put("checkStatus", "2");
            checkInfo.put("checkInfo", "验证码输入错误");
            return checkInfo;
        }
    
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param response
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/validateCode.do")
    public void validateCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 0.创建空白图片
        BufferedImage image = new BufferedImage(95, 30, BufferedImage.TYPE_INT_BGR);
        // 1.获取图片画笔
        Graphics g = image.getGraphics();
        Random r = new Random();
        // 2.设置画笔颜色
        g.setColor(new Color(200, 200, 200));
        // 3.绘制矩形背景
        g.fillRect(0, 0, 95, 30);
        // 4。调用自定义方法，获取长度为4的字母数字组合的字符串
        String number = getNumber(4);
        HttpSession session = request.getSession();
        session.setAttribute("validatecode", number);
        Long sysTime = System.currentTimeMillis();
        session.setAttribute("codeTime", sysTime);
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font(null, Font.ITALIC, 26));
        // 5.设置颜色字体后，绘制字符串
        g.drawString(number, 10, 25);
        // 6.绘制8条干扰线
        for (int i = 0; i < 8; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
        }
        response.setContentType("image/jpeg");
        OutputStream ops = response.getOutputStream();
        ImageIO.write(image, "jpeg", ops);
        ops.close();
    }

    /**
     * 
     * 功能描述: 验证码string生成<br>
     * 〈功能详细描述〉随机生成验证码string工具类
     * 
     * @param size 请求
     * @return String 验证码
     * @see
     * @since
     */
    private String getNumber(int size) {
        String str = "ABCDEFGHIJKLMNOPQRETUVWXYZ0123456789";
        String number = "";
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            number += str.charAt(r.nextInt(str.length()));
        }
        return number;
    }

}

