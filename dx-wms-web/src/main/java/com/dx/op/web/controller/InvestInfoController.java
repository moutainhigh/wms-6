package com.dx.op.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.web.controller.BaseController;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.op.service.intf.IProductService;
import com.dx.op.web.vo.InvestInfoQueryVo;
import com.dx.op.web.vo.InvestInfoResultVo;
import com.dx.op.web.vo.ResultVo;
import com.dx.wms.dto.LenderApplyQueryDto;
import com.dx.wms.dto.LenderApplyResultDto;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.enums.PushCode;
import com.dx.wms.enums.StatusStep;
import com.dx.wms.service.ILenderManagermentService;
import com.dx.wms.service.push.ILenderPushService;
import com.dx.wms.service.push.LenderPushException;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.util.WebCommonUtil;

/**
 * 
 * 理财信息管理
 *
 * @author tony
 */
@Controller
@RequestMapping("/op/invest")
public class InvestInfoController extends BaseController {

    private static final String FTL = "/op/invest/info/list";

    @Autowired
    private ILenderManagermentService lenderManagermentService;

    @Autowired
    private ILenderPushService lenderPushService;

    @Autowired
    private IProductService productService;

    @RequestMapping("/list.htm")
    public String initPage(Model model, HttpServletRequest request) {
        model.addAttribute("userId", WebCommonUtil.getUserId(request));
        model.addAttribute("products", productService.getProductByApp("wms"));
        model.addAttribute("status",
                StatusStep.getMap(StatusStep.MATCH_WAIT, StatusStep.CREDIT_WAIT, StatusStep.FINANCE_WAIT,
                        StatusStep.FINANCE_REJECTED, StatusStep.INVESTMENT_WAIT, StatusStep.INVESTMENT_FAIL,
                        StatusStep.INVESTMENT_EFFECT, StatusStep.REMATCH));
        return FTL;
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<InvestInfoResultVo> queryByPage(InvestInfoQueryVo vo, DataTableObj dTable) {
        Pagination page = WebCommonUtil.initPage(dTable);
        return new AjaxDataTableObj<InvestInfoResultVo>(dTable,
                convert(lenderManagermentService.queryLendersInfo(convert(vo, page))));
    }

    private LenderApplyQueryDto convert(InvestInfoQueryVo vo, Pagination page) {
        LenderApplyQueryDto dto = new LenderApplyQueryDto();
        try {
            PropertyUtils.copyProperties(dto, vo);
            dto.setPagination(page);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOG.error("convert() exception:{}", e.getMessage());
        }
        return dto;
    }

    private PaginationResult<List<InvestInfoResultVo>> convert(PaginationResult<List<LenderApplyResultDto>> result) {
        List<InvestInfoResultVo> vos = new ArrayList<>();
        Map<String, String> productMap = productService.getProductByApp("wms");
        try {
            for (LenderApplyResultDto dto : result.getR()) {
                InvestInfoResultVo vo = new InvestInfoResultVo();
                vo.put(vo, dto, productMap);
                vos.add(vo);
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOG.error("convert() exception:{}", e.getMessage());
        }
        return new PaginationResult<List<InvestInfoResultVo>>(vos, result.getPagination());
    }

    @RequestMapping("/cancel.json")
    @ResponseBody
    public ResultVo cancel(@RequestBody List<String> lenderCodes, HttpServletRequest request) {
        try {
            for (String code : lenderCodes) {
                PushDataDto dto = new PushDataDto();
                dto.giveUp(getUserId(request), code);
                lenderPushService.push(PushCode.GIVE_UP, dto);
            }
        } catch (LenderPushException e) {
            return new ResultVo(e.getMessage());
        }
        return new ResultVo();
    }

}
