/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LoginFilter.java
 * Author:   柳励
 * Date:     2015年1月27日 下午2:44:53
 * Description: 
 * History: 
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.ccs.vo.UserVo;
import com.dx.wms.constant.WMSConstants;
import com.google.gson.Gson;

/**
 * 
 * 登录拦截
 *
 * @author 柳励
 */
public class LoginFilter implements Filter {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * 域名
     */
    private static final String DOMAIN = "/";

    /**
     * 登录链接
     */
    private static final String LOGIN = "/login.htm";

    /**
     * 验证链接
     */
    private static final String USER_VALIDATE = "validate.do";
    /**
     * 验证码
     */
    private static final String CHECK_CODE= "validateCode.do";
    /**
     * 验证码验证
     */
    private static final String CHECK_VALIDATE = "checkValidate.json";


    /**
     * 编码
     */
    private String encoding;

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String reqUrl = request.getRequestURI();
        HttpSession session = (HttpSession) request.getSession();
        UserVo user = (UserVo) session.getAttribute(WMSConstants.USER);
        LOG.info("doFilter() user={}", new Gson().toJson(user));
        if (reqUrl.startsWith(DOMAIN)) {
            if (this.encoding != null) {
                request.setCharacterEncoding(this.encoding);
                response.setCharacterEncoding(this.encoding);
            }
            reqUrl = reqUrl.substring(DOMAIN.length() - 1);
            if (user == null) {
                if (reqUrl.contains(USER_VALIDATE) || reqUrl.contains(CHECK_CODE) || reqUrl.contains(CHECK_VALIDATE)) {
                    request.getRequestDispatcher(reqUrl).forward(request, response);
                    return;
                } else {
                    request.getRequestDispatcher(LOGIN).forward(request, response);
                    return;
                }

            }
            chain.doFilter(request, response);

        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("encoding");
    }

}
