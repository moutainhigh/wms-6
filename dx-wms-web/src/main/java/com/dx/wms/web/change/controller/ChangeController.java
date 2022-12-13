package com.dx.wms.web.change.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.changer.Changer;
import com.dx.wms.service.changer.ChangerObserver;
import com.dx.wms.service.changer.IChangeInfoService;
import com.dx.wms.service.changer.InfoChangeDto;
import com.dx.wms.service.changer.ItemChanger;
import com.dx.wms.service.changer.ParamChanger;
import com.dx.wms.service.changer.ResultChanger;
import com.dx.wms.service.model.Model_;
import com.dx.wms.web.account.vo.CustAccountApplyVo;
import com.dx.wms.web.change.vo.ParamChangeVo;
import com.dx.wms.web.change.vo.ResultChangeVo;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.WebCommonUtil;
import com.google.gson.Gson;

@RequestMapping("/infoChange")
@Controller
public class ChangeController {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ChangeController.class);
    /**
     * 变更观察者
     */
    @Autowired
    private ChangerObserver<Changer<ParamChanger, ResultChanger, ItemChanger>, ParamChanger, ResultChanger, ItemChanger> infoObserver;
    /**
     * 变更model
     */
    @Autowired
    private Model_ commonModelService;
    /**
     * 公共服务
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 变更服务
     */
    @Autowired
    private IChangeInfoService changeInfoService;

    /**
     * 
     * 功能描述: 客户信息和投资信息变更list页面 〈功能详细描述〉
     *
     * @param biz
     * @param model
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/{biz}.htm")
    public String initPage(@PathVariable("biz") String biz, ModelMap model, HttpServletRequest request) {
        commonModelService.putChange(model);
        return infoObserver.init(transParam(biz));
    }

    private ParamChanger transParam(String biz) {
        return new ParamChanger(biz);
    }

    /**
     * 
     * 功能描述: 客户信息变更和投资信息变更分页查询 〈功能详细描述〉
     *
     * @param biz
     * @param dTable
     * @param request
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/{biz}_do.json")
    @ResponseBody
    public AjaxDataTableObj<ResultChangeVo> queryForPage(@PathVariable("biz") String biz, DataTableObj dTable,
            HttpServletRequest request, ParamChangeVo param) {
        LOG.info("**queryForPage() biz:{}**", biz);
        Pagination page = WebCommonUtil.initPage(dTable);
        PaginationResult<List<ResultChangeVo>> result = convertResult(
                infoObserver.query(convertQuery(biz, param), page));
        return new AjaxDataTableObj<ResultChangeVo>(dTable, result);
    }

    private ParamChanger convertQuery(String biz, ParamChangeVo queryVo) {
        LOG.info("**convertQuery biz={},queryVo={}**", new Gson().toJson(biz), new Gson().toJson(queryVo));
        ParamChanger queryDto = new ParamChanger(biz);
        BeanUtils.copyProperties(queryVo, queryDto);
        return queryDto;
    }

    private PaginationResult<List<ResultChangeVo>> convertResult(PaginationResult<List<ResultChanger>> dtos) {
        Assert.notNull("**convertResult() dtos can be not null**", dtos);
        LOG.info("**convertResult() dtos**", new Gson().toJson(dtos));
        List<ResultChangeVo> results = new ArrayList<ResultChangeVo>();
        if (Assert.checkParam(dtos.getR())) {
            for (ResultChanger result : dtos.getR()) {
                InfoChangeDto infoChangeDto = changeInfoService.getInfoChangeDto(result);
                results.add(new ResultChangeVo(result, infoChangeDto));
            }
        }
        return new PaginationResult<List<ResultChangeVo>>(results, dtos.getPagination());
    }

    /**
     * 
     * 功能描述:变更内容悬浮窗 〈功能详细描述〉
     *
     * @param biz
     * @param custAccountId
     * @param lenderApplyId
     * @param request
     * @param model
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{biz}_change.json")
    public String changePage(@PathVariable("biz") String biz, @ModelAttribute("changeId") Long changeId,
            HttpServletRequest request, ModelMap model) {
        LOG.info("**changePage() biz ={},custAccountId={},LenderApplyId={}**", biz, changeId);
        ItemChanger findDto = infoObserver.getDto(convertQuery(biz, changeId));
        CustAccountApplyVo applyVo = getApplyVo(findDto, model);
        ParamChanger infoChangeQueryDto = new ParamChanger();
        model.addAttribute("custAccountApplyVo", applyVo);
        LOG.info("**changePage() applyVo:{}**", new Gson().toJson(applyVo));
        infoChangeQueryDto.setCustAccountApplyDto(findDto.getApplyDto());
        return infoObserver.changePage(trans2Param(biz, infoChangeQueryDto));
    }

    private ParamChanger convertQuery(String biz, Long changeId) {
        return new ParamChanger(biz, changeId);
    }

    private CustAccountApplyVo getApplyVo(ItemChanger findDto, ModelMap model) {
        LOG.info("**getApplyVo() findDto:{}**", new Gson().toJson(findDto));
        CustAccountApplyDto applyDto = findDto.getApplyDto();
        CustAccountApplyVo applyVo = new CustAccountApplyVo();
        BeanUtils.copyProperties(applyDto, applyVo);
        if (Assert.checkParam(applyDto.getLenderApply().getLenderApplyId())) {
            commonModelService.putCustAccountApply(applyDto, model);
            applyVo.setBiglenderAmount(Assert.checkParam(applyDto.getLenderApply().getLenderAmount())
                    ? AmountUtils.toChinese(applyDto.getLenderApply().getLenderAmount().toString()) : "零");
        } else {
            commonModelService.putCustAccount(applyDto, model);
        }
        return applyVo;
    }

    private ParamChanger trans2Param(String biz, ParamChanger infoChangeQueryDto) {
        LOG.info("**trans2Param() biz={},infoChangeQueryDto={}**", biz, new Gson().toJson(infoChangeQueryDto));
        return new ParamChanger(biz, infoChangeQueryDto);
    }

    /**
     * 
     * 功能描述: 变更信息保存 〈功能详细描述〉
     *
     * @param biz
     * @param applyVo
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{biz}_save.json")
    @ResponseBody
    public Map<String, Object> saveCustInfo(@PathVariable("biz") String biz, @RequestBody CustAccountApplyVo applyVo,
            HttpServletRequest request) {
        LOG.info("**saveCustInfo() biz:{},custAccountApplyVo{}**", biz, new Gson().toJson(applyVo));
        Long userId = commonService.getUserId(request);
        CustAccountApplyDto applyDto = getApplyDto(applyVo);
        return infoObserver.save(trans2Param(biz, applyDto, userId));
    }

    private CustAccountApplyDto getApplyDto(CustAccountApplyVo applyVo) {
        CustAccountApplyDto applyDto = new CustAccountApplyDto();
        BeanUtils.copyProperties(applyVo, applyDto);
        return applyDto;
    }

    private ParamChanger trans2Param(String biz, CustAccountApplyDto applyDto, Long userId) {
        return new ParamChanger(biz, applyDto, userId);
    }

    /**
     * 
     * 功能描述: 变更日志悬浮窗 〈功能详细描述〉
     *
     * @param biz
     * @param custAccountId
     * @param lenderApplyId
     * @param request
     * @param model
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{biz}_record.json")
    public String recordView(@PathVariable("biz") String biz, @ModelAttribute("custAccountId") Long custAccountId,
            Long lenderApplyId, HttpServletRequest request, ModelMap model) {
        LOG.info("**recordView() biz:{},custAccountId:{},lenderApplyId:{}**", biz, custAccountId, lenderApplyId);
        model.addAttribute("pkId", getPkId(custAccountId, lenderApplyId));
        return infoObserver.recordView(transParam(biz));
    }

    private Long getPkId(Long custAccountId, Long lenderApplyId) {
        return Assert.checkParam(custAccountId) ? custAccountId : lenderApplyId;
    }

    /**
     * 
     * 功能描述: 变更内容 〈功能详细描述〉
     *
     * @param biz
     * @param request
     * @param dTable
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/{biz}_record_do.json")
    @ResponseBody
    public AjaxDataTableObj<ResultChangeVo> queryRecord(@PathVariable("biz") String biz, HttpServletRequest request,
            DataTableObj dTable, ParamChangeVo param) {
        LOG.info("**queryRecord biz:{},param:{}**", biz, new Gson().toJson(param));
        Pagination page = WebCommonUtil.initPage(dTable);
        PaginationResult<List<ResultChangeVo>> result = convertRecordResult(
                infoObserver.queryRecord(convertQuery(biz, param), page));
        return new AjaxDataTableObj<ResultChangeVo>(dTable, result);
    }

    public PaginationResult<List<ResultChangeVo>> convertRecordResult(PaginationResult<List<ResultChanger>> resultDto) {
        LOG.info("**convertRecordResult() resultDto={}**", new Gson().toJson(resultDto));
        List<ResultChangeVo> results = new ArrayList<ResultChangeVo>();
        for (ResultChanger result : resultDto.getR()) {
            results.add(new ResultChangeVo(result));
        }
        return new PaginationResult<List<ResultChangeVo>>(results, resultDto.getPagination());
    }
}
