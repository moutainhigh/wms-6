package com.dx.report.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.cmm.service.ports.Port;
import com.dx.cmm.service.report.IMaturityService;
import com.dx.cmm.service.report.dto.MaturityParamDto;
import com.dx.cmm.service.report.dto.MaturityResult;
import com.dx.cmm.web.controller.BaseController;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.report.web.vo.MaturityParamVo;
import com.dx.report.web.vo.MaturityResultVo;
import com.dx.wms.service.IProductService;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;


@Controller
@RequestMapping("/report/maturity")
public class MaturityController extends BaseController{
	
	@Autowired
	IMaturityService maturityReportService;
	@Autowired
    protected IProductService productService;
	
	private static final Logger LOG = LoggerFactory.getLogger(MaturityController.class);
	
	private static final String LIST = "/report/maturity/list";
	
	@RequestMapping("/list.htm")
    public String init(Model model) {
        model.addAttribute(PORT, Port.PORT);
        model.addAttribute("products", productService.getProductByAppAndProductId(INVEST, -1L));
        return LIST;
    }
	
	@RequestMapping(INIT_URL)
    @ResponseBody
    public AjaxDataTableObj<MaturityResultVo> init(MaturityParamVo vo, DataTableObj dTable) {
    	MaturityParamDto dto = new MaturityParamDto();
    	BeanUtils.copyProperties(vo, dto);
		return parse(maturityReportService.queryMaturityList(dto, init(dTable)),dTable);
    }
	
	private AjaxDataTableObj<MaturityResultVo> parse(PaginationResult<List<MaturityResult>> page,DataTableObj dTable) {
        List<MaturityResultVo> maturityList = new ArrayList<MaturityResultVo>();
        for (MaturityResult result : page.getR()) {
        	MaturityResultVo resultVo = new MaturityResultVo(result);
        	maturityList.add(resultVo);
        }
        return new AjaxDataTableObj<MaturityResultVo>(dTable,
                new PaginationResult<List<MaturityResultVo>>(maturityList, page.getPagination()));
    }
}
