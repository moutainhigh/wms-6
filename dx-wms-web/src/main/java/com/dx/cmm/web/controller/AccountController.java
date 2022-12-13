package com.dx.cmm.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dx.cmm.dto.AccountDetailDto;
import com.dx.cmm.dto.AccountParamDto;
import com.dx.cmm.dto.AccountResultDto;
import com.dx.cmm.enums.AccountLevel;
import com.dx.cmm.service.IAccountService;
import com.dx.cmm.web.vo.AccountDetailVo;
import com.dx.cmm.web.vo.AccountParamVo;
import com.dx.cmm.web.vo.AccountResultVo;
import com.dx.cmm.web.vo.ResultVo;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.ExecelUtils;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.op.service.intf.IProductService;
import com.dx.wms.web.page.AjaxDataTableObj;
import com.dx.wms.web.page.DataTableObj;
import com.dx.wms.web.process.vo.ProcessResultVo;
import com.dx.wms.web.util.ExportExcelUtil;
import com.dx.wms.web.util.WebCommonUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IProductService productService;
    
    /*
     * 导出excel表头
     */
    private static final String[] ACCOUNT_DATA_HEAD={"客户姓名","身份证","当前账户金额","投资数量","账户级别"};

    @RequestMapping("/list.htm")
    public String init(Model model, HttpServletRequest request) {
        Map<String, Object> param = initMap(request);
        param.put("accountLevel", AccountLevel.getMap());
        WebCommonUtil.putModel(model, param);
        return "/account/list";
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxDataTableObj<AccountResultVo> queryByPage(AccountParamVo param, DataTableObj dTable) {
        LOG.info("queryByPage() param:{}", new Gson().toJson(param));
        Pagination page = WebCommonUtil.initPage(dTable);
        return new AjaxDataTableObj<AccountResultVo>(dTable, trans2Array(accountService.query(trans2Obj(param), page)));
    }

    @RequestMapping("/detail.json")
    @ResponseBody
    public List<AccountDetailVo> detail(Long matchUserId) {
        return trans2Array(accountService.query(matchUserId));
    }

    @RequestMapping(value = "import.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        LOG.info("fileUpload() file:{}", new Gson().toJson(file));
        if (file.isEmpty()) {
            return new ResultVo("无法读取文件");
        }
        if (file.getSize() > 20971520) {
            return new ResultVo("上传文件最大限制为20M");
        }
        if (!ExecelUtils.isExcel(file.getName())) {
            return new ResultVo("文件类型必须为xlsx、xls");
        }
        InputStream stream = null;
        try {
            stream = file.getInputStream();
            Workbook book = ExecelUtils.init(file.getName(), stream);
        } catch (IOException e) {
            return new ResultVo(e.getMessage());
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {

                }
            }
        }
        return new ResultVo();
    }
    
    
    @RequestMapping("excelExport.json")
    public void excelExport(HttpServletRequest request, HttpServletResponse response){
    	Pagination pagination = new Pagination();
        pagination.setCurrentPage(0);
        pagination.setPagesize(-1);
        List<ExportExcelAccountResult> excelResult = trans2ExcelVo(accountService.query(trans2Obj(trans2Query(request)), pagination));
        List<String> requirements = new ArrayList<String>();
        ExportExcelUtil.excelExoprt(requirements, ACCOUNT_DATA_HEAD, null, excelResult, null, "账户级别数据导出", response,
                "yyyy-mm-dd");
    }
    

    private List<AccountDetailVo> trans2Array(List<AccountDetailDto> dtos) {
        List<AccountDetailVo> vos = new ArrayList<AccountDetailVo>();
        Map<String, String> productMap = productService.getProductByApp("wms");
        for (AccountDetailDto dto : dtos) {
            vos.add(new AccountDetailVo(dto, productMap));
        }
        return vos;
    }

    private AccountParamDto trans2Obj(AccountParamVo vo) {
        AccountParamDto dto = new AccountParamDto();
        try {
            PropertyUtils.copyProperties(dto, vo);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOG.error("trans2Obj() vo:{} exception:{}", new Gson().toJson(vo), e.getMessage());
        }
        return dto;
    }
    
    private AccountParamVo trans2Query(HttpServletRequest request) {
        AccountParamVo param = new AccountParamVo();
        String custName=null;
		try {
			custName = new String(request.getParameter("custName").getBytes("iso8859-1"),"utf-8");
			param.setCustName(Assert.checkParam(custName) ? custName : null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String accountLevelId = request.getParameter("accountLevelId");
        param.setAccountLevelId(Assert.checkParam(accountLevelId) ? Long.parseLong(accountLevelId) : null);
        return  param;
    }

    private PaginationResult<List<AccountResultVo>> trans2Array(PaginationResult<List<AccountResultDto>> result) {
        List<AccountResultVo> vos = new ArrayList<AccountResultVo>();
        for (AccountResultDto dto : result.getR()) {
            vos.add(new AccountResultVo(dto));
        }
        return new PaginationResult<List<AccountResultVo>>(vos, result.getPagination());
    }
    
    private List<ExportExcelAccountResult> trans2ExcelVo(PaginationResult<List<AccountResultDto>> result) {
        List<ExportExcelAccountResult> excelVoList = new ArrayList<ExportExcelAccountResult>();
        for (AccountResultDto dto : result.getR()) {
        	excelVoList.add(new ExportExcelAccountResult(dto));
        }
        return excelVoList;
    }
}
