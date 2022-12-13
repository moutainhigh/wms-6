package com.dx.wms.web.save.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.common.service.utils.Assert;
import com.dx.wms.cla.web.vo.LogResultVo;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.log.ILenderApplyLogService;
import com.dx.wms.service.log.LogResultDto;
import com.dx.wms.service.model.ModelObserver;
import com.dx.wms.service.model.ModelType;
import com.dx.wms.service.model.Model_;
import com.dx.wms.service.model.ParamModel;
import com.dx.wms.service.save.HandlerDto;
import com.dx.wms.service.save.ISaveService;
import com.dx.wms.service.saver.ParamSaver;
import com.dx.wms.service.saver.ResultSaver;
import com.dx.wms.service.saver.SaverObserver;
import com.dx.wms.web.save.vo.ParamSaverVo;
import com.dx.wms.web.save.vo.ResultSaverVo;
import com.dx.wms.web.util.WebCommonUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping("/save")
public class SaveController {

    private static final Logger LOG = LoggerFactory.getLogger(SaveController.class);

    @Autowired
    private SaverObserver saver;

    @Autowired
    private ModelObserver gateway;

    @Autowired
    private Model_ view;

    @Autowired
    private ISaveService saveService;

    @Autowired
    private ICommonService commonService;

    /**
     * 理财申请日志服务
     */
    @Autowired
    private ILenderApplyLogService lenderApplyLogService;

    // biz(account开户，apply投资审请)
    @RequestMapping(value = "/{biz}_{action}.json")
    public String init(@PathVariable("biz") String biz, @PathVariable("action") String action,
            @RequestParam("id") Long id, ModelMap model, HttpServletRequest request) {
        LOG.info("Init {}_{} page, id[{}]", biz, action, id);
        ParamSaver param = param(biz, action, id);
        Map<String, Object> map = new HashMap<String, Object>();
        ResultSaver dto = saver.query(param);
        //续投
        if("dueApply".equals(biz)&&!Assert.checkParam(dto.getApply())){
        	LenderApply lenderApply = new LenderApply();
        	lenderApply.setLenderApplyId(id);
        	LenderApply dueLenderApply = new LenderApply();
        	Date dueDate = commonService.getDueDate(lenderApply).getDueDate();
        	Calendar calendar = new GregorianCalendar(); 
        	calendar.setTime(dueDate); 
        	calendar.add(calendar.DATE,1);
        	dueDate=calendar.getTime(); 
        	dueLenderApply.setExpectLenderDateBegin(dueDate);
        	dueLenderApply.setExpectLenderDateEnd(dueDate);
        	dto.setApply(dueLenderApply);
        }
        map.put("saver", new ResultSaverVo(dto, getArea(dto)));
        gateway.init(new ParamModel(ModelType.get(biz), map), model);
        view.putSaveModel(dto, model);
        model.addAttribute("biz", biz);
        model.addAttribute("id", id);
        if (Assert.checkParam(dto.getApply()) && Assert.checkParam(dto.getApply().getLenderApplyId())
                && Assert.checkParam(dto.getApply().getLenderCode())) {
            List<LogResultVo> logVoes = getLogVoes(dto.getApply().getLenderApplyId());
            model.addAttribute("lenderApplyLogs", logVoes);
        }
        return saver.init(param);
    }

    /**
     * 根據lenderApplyId得出日誌結果集
     *
     * @param lenderApplyId
     * @return List<LogResultVo>
     */
    private List<LogResultVo> getLogVoes(Long lenderApplyId) {
        List<LogResultVo> logVoes = new ArrayList<LogResultVo>();
        LOG.info("***getLogVoes() lenderApplyId={}", lenderApplyId);
        if (Assert.checkParam(lenderApplyId)) {
            List<LogResultDto> logDtoes = lenderApplyLogService.queryByParam(lenderApplyId);
            for (LogResultDto dto : logDtoes) {
                logVoes.add(new LogResultVo(dto));
            }
        }
        return logVoes;
    }

    private String getArea(ResultSaver dto) {
        if (!Assert.checkParam(dto.getComm()) || !Assert.checkParam(dto.getComm().getProvinceRegionCode())
                || !Assert.checkParam(dto.getComm().getCityRegionCode())
                || !Assert.checkParam(dto.getComm().getDistrictRegionCode())) {
            return "";
        }
        return commonService.trans2Address(dto.getComm().getProvinceRegionCode(), dto.getComm().getCityRegionCode(),
                dto.getComm().getDistrictRegionCode());
    }

    private ParamSaver param(String biz, String action, Long id) {
        return new ParamSaver(biz, action, id);
    }

    @RequestMapping(value = "{biz}_save.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultSaver save(@PathVariable("biz") String biz, @RequestBody ParamSaverVo paramVo,
            HttpServletRequest request) {
        LOG.info("**save() paramVo:{}**", new Gson().toJson(paramVo));
        ParamSaver param = new ParamSaver();
        BeanUtils.copyProperties(paramVo, param);
        ResultSaver saver = new ResultSaver();
        HandlerDto dto = new HandlerDto(WebCommonUtil.getUserId(request));
        saveService.save(biz, param, dto, saver);
        return saver;
    }

    @RequestMapping(value = "lenderApply.json", method = RequestMethod.POST)
    @ResponseBody
    public LenderApply getLenderApply(@RequestBody LenderApply lenderApply, HttpServletRequest request) {
        return commonService.getDueDate(lenderApply);
    }
}
