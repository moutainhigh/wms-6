package com.dx.wms.web.task.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dx.common.service.utils.Assert;
import com.dx.framework.web.escape.StringEscapeSupportController;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.scheduler.IPushCustInfoService;

@Controller
@RequestMapping("/pushCustInfo")
public class PushCustInfoController extends StringEscapeSupportController {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(PushCustInfoController.class);

    @Autowired
    private IPushCustInfoService pushCustInfoService;

    @RequestMapping(value = "/pushCustInfo.html")
    public void pushCustInfoData(@RequestParam("authCode") String authCode, HttpServletRequest req,
            HttpServletResponse res) {
        LOG.info("开始推送 支付类型为 委托划扣的数据 给财务");
        LOG.info("Auth code[{}]", authCode);
        if (!StringUtils.equals(authCode, WMSConstants.AUTH_CODE)) {
            LOG.error("authCode is not exists!");
            return;
        }
        Map<String, String> retMap = new HashMap<String, String>();
        ServletOutputStream sos = null;
        try {
            res.setCharacterEncoding("UTF-8");
            sos = res.getOutputStream();
            retMap.put("nodeName", "pushCustInfo"); // 成功，返回nodeName
            pushCustInfoService.push();
            ObjectOutputStream objOutputStrm = new ObjectOutputStream(sos);
            objOutputStrm.writeObject(retMap); // 甚至可以发一个null对象，服务端取到后再做判断处理。
            objOutputStrm.flush();
            objOutputStrm.close();
        } catch (Exception e) {
            LOG.error("error:" + e.getMessage());
            retMap.put("errMsg", "pushInvestSuccess"); // 失败，返回nodeName
        } finally {
            if (Assert.checkParam(sos)) {
                try {
                    sos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        LOG.info("结束推送 支付类型为 委托划扣的数据 给财务");
    }
}
