/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: DetailController.java
 * Author:   王蕊
 * Date:     2015年7月30日 下午8:57:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.detail.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dx.common.service.utils.Assert;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.hr.service.api.IOrgService;
import com.dx.hr.service.dto.CommentResultDto;
import com.dx.hr.service.dto.EmployeeLogDto;
import com.dx.hr.service.dto.OrgDto;
import com.dx.hr.service.dto.OrgRequestDto;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.detail.DetailObserver;
import com.dx.wms.service.detail.DetailType;
import com.dx.wms.service.detail.ParamDetail;
import com.dx.wms.service.detail.ResultDetail;
import com.dx.wms.web.detail.vo.FileResultVo;
import com.dx.wms.web.detail.vo.FileVo;
import com.dx.wms.web.detail.vo.FolderVo;
import com.dx.wms.web.detail.vo.ResultDetailVo;
import com.dx.wms.web.hr.service.IHRResultService;
import com.dx.wms.web.hr.vo.EmployeeEntryVo;
import com.dx.wms.web.util.AreaFullNameUtil;

/**
 * 详情
 *
 * @author 王蕊
 */
@Controller
@RequestMapping(value = "/detail")
public class DetailController {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(DetailController.class);

    private static final String DETAIL = "/detail.htm";
    
    private static final String LIST_DETAIL = "infoManage/detail";
    
    private static final String SPOT = ".";
    
    @Value("${wms.file.ipAddress}")
    private String ipAdress = "";
    
    @Autowired
    private ICommonService commonService;

    @Autowired
    private IHRResultService HRResultService;

    @Autowired
    private IOrgService orgService;

    @Autowired
    private DetailObserver detail;
    
    @Autowired
    private IRegionNewService regionNewService;

    @RequestMapping(value = "/{biz}_detail.json")
    public String detail(@PathVariable("biz") String biz, @RequestParam("id") Long id, ModelMap model,
            HttpServletRequest request) {
        LOG.info("Biz[{}]", biz);
        ParamDetail param = param(biz, id);
        Long userId = commonService.getUserId(request);
        ResultDetailVo resultVo = result(detail.query(param), userId);
        if ("employee".equals(biz)) {
            putAddressInfo(resultVo, model);
            putApproveLogs(resultVo.getEmployeeEntryVo().getEmployeeVo().getEmployeeId(), model);
        }
        model.addAttribute("detail", resultVo);
        model.addAttribute("biz", biz);
        if (Assert.checkParam(resultVo.getApply()) && Assert.checkParam(resultVo.getApply().getParentId())) {
            resultVo.setTitle("续投申请");
        }
        return detail.init(param);
    }

    private ParamDetail param(String biz, Long id) {
        return new ParamDetail(DetailType.get(biz), id);

    }

    private ResultDetailVo result(ResultDetail result, Long userId) {
        if (Assert.equals("个人信息", result.getTitle())) {
            result.setTitle("员工信息");
            Map<String, String> addrMap = new HashMap<String, String>();
            List<CommentResultDto> approves = new ArrayList<CommentResultDto>();
            Map<String, String> orgs = new HashMap<String, String>();
            List<EmployeeLogDto> logs = new ArrayList<EmployeeLogDto>();
            Long parentId = null;
            HRResultService.getResult(result, userId, addrMap, orgs, approves, logs, parentId);
            logs = commonService.queryEmployeeLogs(result.getEmployeeEntryDto().getEmployeeDto().getEmployeeId());
            return new ResultDetailVo(result,
                    new EmployeeEntryVo(result.getEmployeeEntryDto(), orgs, parentId, addrMap, approves, logs));
        }

        if (!Assert.checkParam(result.getComm()) && !Assert.checkParam(result.getLinkman())) {
            return new ResultDetailVo(result);
        }

        String area = Assert.checkParam(result.getComm())
                ? commonService.trans2Address(result.getComm().getProvinceRegionCode(),
                        result.getComm().getCityRegionCode(), result.getComm().getDistrictRegionCode())
                : "";
        Map<Integer, String> bank = new HashMap<Integer, String>();
        if (Assert.checkParam(result.getFinances())) {
            for (CustFinance finance : result.getFinances()) {
                if (Assert.checkParam(finance.getAccountCategory())) {
                    bank.put(finance.getAccountCategory(),
                            commonService.trans2Address(finance.getProvinceRegionCode(), finance.getCityRegionCode()));
                }
            }
        }
        String product = Assert.checkParam(result.getApply())
                ? commonService.queryByProductId(result.getApply().getProductId()).getProductName() : "";
        return new ResultDetailVo(result, area, product, bank, regionNewService);
    }

    // 存入开户行信息
    void putAddressInfo(ResultDetailVo resultDetailVo, ModelMap model) {
        // 户籍地址全名+邮编
        model.addAttribute("hj_pca",
                AreaFullNameUtil.getPca(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusProvinceCode(),
                        resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusCityCode(),
                        resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusAreaCode())
                        + resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusAddress() + "-"
                        + resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getCensusZipCode());
        // 居住地全名+邮编
        model.addAttribute("jzd_pca",
                AreaFullNameUtil.getPca(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeProvinceCode(),
                        resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeCityCode(),
                        resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeAreaCode())
                        + resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeAddress() + "-"
                        + resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getHomeZipCode());

        // 银行地址信息
        resultDetailVo.getEmployeeEntryVo().getDetailInfoVo()
                .setBankCity(Assert.checkParam(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getBankCityCode())
                        ? (AreaFullNameUtil
                                .getValue(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getBankCityCode()))
                        : WMSConstants.NULL);
        resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().setBankProvince(
                Assert.checkParam(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getBankProvinceCode())
                        ? AreaFullNameUtil
                                .getValue(resultDetailVo.getEmployeeEntryVo().getDetailInfoVo().getBankProvinceCode())
                        : WMSConstants.NULL);
        Long orgId = resultDetailVo.getEmployeeEntryDto().getEmployeeDto().getOrgId();
        OrgRequestDto rdto = new OrgRequestDto();
        rdto.setOrgId(orgId);
        OrgDto oDto = orgService.queryOrgByCondition(rdto);
        resultDetailVo.getEmployeeEntryVo().getEmployeeVo().setOrgName(oDto.getOrgName());

    }

    void putApproveLogs(Long employeeId, ModelMap model) {
        List<CommentResultDto> approveLogs = HRResultService.getApproves(employeeId);
        model.addAttribute("approveLogs", approveLogs);
        if (Assert.checkParam(approveLogs)) {
            model.addAttribute("applicant", approveLogs.get(0).getUserId());
        }
    }

    @RequestMapping(value = "/lenderApply.json")
    @ResponseBody
    public LenderApply getLenderApply(@RequestParam Long lenderApplyId, HttpServletRequest request) {
        LenderApply lenderApply = new LenderApply();
        lenderApply.setLenderApplyId(lenderApplyId);
        return commonService.getDueDate(lenderApply);
    }
    
    @RequestMapping(DETAIL)
    public String initPage(ModelMap model,Long lenderApplyId, HttpServletRequest request) {
    	 Assert.notNull("initPage lenderApplyId is null",lenderApplyId);
    	 ParamDetail param = param("synthesize", lenderApplyId);
         Long userId = commonService.getUserId(request);
         ResultDetailVo resultVo = result(detail.query(param), userId);
         model.addAttribute("detail", resultVo);
         set(resultVo.getFolderVos(),model);
        return LIST_DETAIL;
    }
    
    private void set(List<FolderVo> folderVos ,ModelMap model){
    	Map<String, String> dirs = new TreeMap<>();
        List<Map<String, String>> urls = new ArrayList<>();
        List<String> ids =  new ArrayList<>();
        for(FolderVo folder : folderVos){
       	 dirs.put(folder.getId(), folder.getName());
       	 ids.add(folder.getId());
       	 Map<String, String> fileUrls = new TreeMap<>();
       	 for(FileVo fileVo : folder.getFiles()){
       		 fileUrls.put(getFileUrl(fileVo),getFileName(fileVo,folder.getName()));
       	 }
       	 urls.add(fileUrls);
        }
        FileResultVo vo = new FileResultVo();
        vo.setFileIds(ids);
        vo.setFiles(dirs);
        vo.setUrls(urls);
        model.addAttribute("file",vo);
    }
    
    private String getFileUrl(FileVo fileVo){
    	StringBuffer fineUrl = new StringBuffer();
    	return fineUrl.append(ipAdress).append(File.separator).append(fileVo.getDir()).append(fileVo.getSaveName()).append(SPOT).append("swf").toString();
    }
    
    private String getFileName(FileVo fileVo , String parentName){
    	StringBuffer fineName = new StringBuffer();
    	return fineName.append(parentName).append(fileVo.getSourceName()).append(SPOT).append(fileVo.getType()).toString();
    }
}