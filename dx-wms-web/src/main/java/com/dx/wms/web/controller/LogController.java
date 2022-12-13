package com.dx.wms.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dx.wms.cla.web.vo.LogResultVo;
import com.dx.wms.service.log.ILenderApplyLogService;
import com.dx.wms.service.log.LogResultDto;
import com.dx.wms.web.detail.vo.ResultDetailVo;

/**
 * 
 * 日志
 * 
 * @author tony
 */
@Controller
@RequestMapping("/log")
public class LogController {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LogController.class);

    /**
     * 客户理财申请日志服务
     */
    @Autowired
    private ILenderApplyLogService logService;

    @RequestMapping(value = "log.json")
    public String log(Long applyId, ModelMap model) {
        LOG.info("Apply id[{}]", applyId);
        model.put("detail", getLogs(applyId));
        return "/log/log";
    }

    private ResultDetailVo getLogs(Long applyId) {
        ResultDetailVo detail = new ResultDetailVo();
        List<LogResultVo> vos = new ArrayList<LogResultVo>();
        List<LogResultDto> dtos = logService.queryByParam(applyId);
        for (LogResultDto dto : dtos) {
            vos.add(new LogResultVo(dto));
        }
        detail.setLogVos(vos);
        return detail;
    }
}
