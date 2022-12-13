///*
// * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
// * FileName: HRDataController.java
// * Author:   黄健
// * Date:     2016年3月7日 上午11:21:15
// * Description: //模块目的、功能描述      
// * History: //修改记录
// * <author>      <time>      <version>    <desc>
// * 修改人姓名             修改时间            版本号                  描述
// */
//package com.dx.wms.web.hr.controller;
//
//import java.io.InputStream;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import com.dx.common.service.utils.Assert;
//import com.dx.common.service.utils.DateUtils;
//import com.dx.framework.dal.pagination.Pagination;
//import com.dx.framework.exception.BaseException;
//import com.dx.hr.enums.CertType;
//import com.dx.hr.enums.EmployeeStatus;
//import com.dx.hr.enums.JobCategory;
//import com.dx.hr.enums.PageType;
//import com.dx.hr.enums.SexType;
//import com.dx.hr.service.api.IPositionService;
//import com.dx.hr.service.dto.EmployeeDto;
//import com.dx.hr.service.dto.EmployeeEntryResultDTO;
//import com.dx.hr.service.dto.EmployeeListQueryDto;
//import com.dx.hr.service.dto.EmployeeListResultDto;
//import com.dx.hr.service.dto.LevelDto;
//import com.dx.hr.service.dto.OrgDto;
//import com.dx.hr.service.dto.PositionDto;
//import com.dx.hr.service.dto.PositionRequestDto;
//import com.dx.wms.service.ICommonService;
//import com.dx.wms.utils.MapResultUtil;
//import com.dx.wms.web.page.DataTableObj;
//import com.google.gson.Gson;
//
///**
// * 〈一句话功能简述〉<br> 
// * 〈功能详细描述〉
// *
// * @author huangjian
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Controller
//@RequestMapping("/dataDeal")
//public class HRDataDealController {
//
//    /**
//     * 日志组件
//     */
//    private static final Logger LOGGER = LoggerFactory.getLogger(HRDataDealController.class);
//    
//    @Autowired
//    private ICommonService commonService;
//    
//    @Autowired
//    private IPositionService positionService;
//    
//    private HSSFWorkbook book = null;
//    private POIFSFileSystem fileSystem = null;
//    private HSSFSheet sheet = null;
//    private Row row = null;
//    private Row titleRow = null;
//    private Cell cell = null;
//    
//    private static final String FLAG = "flag";
//    
//    private static final String VALUE = "value";
//    
//    @RequestMapping(value = "importHRData.json", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> importHRData(@RequestParam("file") CommonsMultipartFile file,
//            HttpServletRequest request,DataTableObj dTable) {
//            InputStream is = null;
//        try {
//            is = file.getInputStream();
//            Map<String, String> result = importData(commonService.getUserId(request), is);
//            if("1".equals(result.get("code"))){
//            	return MapResultUtil.getMapResult("101", "");
//            }else{
//            	return MapResultUtil.getMapResult("102",result.get("msg"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return MapResultUtil.getMapResult("102", "");
//        } finally {
//            try {
//                is.close();
//            } catch (Exception e2) {}
//        }
//    }
//    
//    private Map<String, String> importData(Long userId, InputStream is) throws Exception {
//    	Map<String, String> resultMap = new HashMap<>();
//        List<EmployeeDto> result = new ArrayList<EmployeeDto>();
//        String fileType;
//        fileSystem = new POIFSFileSystem(is);
//        book = new HSSFWorkbook(fileSystem);
//        sheet = book.getSheetAt(0);
//        EmployeeDto employeeDto = null;
//        String title = null;// excel中的标题行
//        String value = null;// cell value(string)
//        boolean flag = false;// data error flag
//        titleRow = sheet.getRow(0);
//        if(!Assert.checkParam(titleRow)) {
//            throw new BaseException("title is missing.");
//        }
//        if(sheet.getPhysicalNumberOfRows() < 2) {
//            throw new BaseException("there is nothing.");
//        }
//        PositionRequestDto positionRequestDto = new PositionRequestDto();
//        positionRequestDto.setUserId(userId);
//        positionRequestDto.setPageType(PageType.RZ_GL.getCode());
//        List<PositionDto> list = positionService.queryPositionDtosByCondition(positionRequestDto);
//        Map<String, Long> postions = new HashMap<String, Long>();
//        for(PositionDto dto : list) {
//            postions.put(dto.getName(), dto.getPositionId());
//        }
//        Map<String, Long> levels = new HashMap<String, Long>();
//        Map<String, Long> orgs = new HashMap<String, Long>();
//        
//        for (int i = sheet.getFirstRowNum()+1; i < sheet.getPhysicalNumberOfRows() && !flag; i++) {
//            employeeDto = new EmployeeDto();
//            employeeDto.setUserId(userId);
//            row = sheet.getRow(i);
//            for (int j = row.getFirstCellNum() + 1; j <= row.getPhysicalNumberOfCells() && !flag; j++) {
//                cell = row.getCell(j-1);
//                title = titleRow.getCell(j-1).getStringCellValue();
//                Map<String, Object> cellMap = isEmpty(cell);
//                if(!(Boolean) cellMap.get(FLAG)) {
//                    flag = true;
//                    break;
//                }
//                value = ""+cellMap.get(VALUE);
//                String reg = "";
//                if (value.contains(".")) {
//                    reg = "(P.\\d{7})|(S.\\d{7})";
//                } else {
//                    reg = "(P\\d{7})|(G\\d{8})|(S\\d{7})|(E\\d{8})|(14\\d{7})|(15\\d{7})";
//                }
//                Pattern pattern = Pattern.compile(reg);
//                
//                String regId = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
//                Pattern patternId = Pattern.compile(regId);
//                
//                String basicSalaryReg = "^[1-9]\\d*$";
//                Pattern basicSalary = Pattern.compile(basicSalaryReg);
//                
//                
//                String perfSalaryReg = "^\\+?(0|[1-9][0-9]*)$";
//                Pattern perfSalary = Pattern.compile(perfSalaryReg);
//                
//                
//                switch (title) {
//                    case "营业部":
//                        
//                        break;
//                    case "员工姓名":
//                    	if(Assert.checkParam(value)){
//                        employeeDto.setName(value);
//                    	}else{
//                    		flag=true;
//                    		fileType="第"+i+"行"+"姓名没填写";
//                    		resultMap.put("code", "0");
//                    		resultMap.put("msg",fileType);
//                    		return resultMap;
//                    	}
//                        break;
//                    case "性别":
//                        if(Assert.checkParam(SexType.getEunm(value))) {
//                            employeeDto.setSex(SexType.getEunm(value).getCode());
//                        } else {
//                            flag = true;
//                            fileType="第"+i+"行"+"性别没填写";
//                            resultMap.put("code", "0");
//                    		resultMap.put("msg",fileType);
//                    		return resultMap;
//                        }
//                        break;
//                    case "证件类型":
//                        if(Assert.checkParam(CertType.getEunm(value))) {
//                            employeeDto.setCertType(CertType.getEunm(value).getCode()); 
//                        } else {
//                            flag = true;
//                            fileType="第"+i+"行"+"证件类型没填写";
//                            resultMap.put("code", "0");
//                    		resultMap.put("msg",fileType);
//                    		return resultMap;
//                        }
//                        break;
//                    case "证件号码":
//                        Matcher matcher = pattern.matcher(value);
//                        Matcher matcherId = patternId.matcher(value);
//                    	if(!Assert.checkParam(value)){
//                    		flag=true;
//                    		fileType="第"+i+"行"+"证件号码没填写";
//                    		resultMap.put("code", "0");
//                    		resultMap.put("msg",fileType);
//                    		return resultMap;
//                    	}else if(employeeDto.getCertType() == 1 && !matcherId.matches()){
//                    	    fileType = "第" + i   + "行身份证格式不正确";
//                    	    flag=true;
//                    	    resultMap.put("code", "0");
//                            resultMap.put("msg",fileType);
//                            return resultMap;
//                    	}else if (employeeDto.getCertType() == 2 && !matcher.matches()) {
//                    	    fileType = "第" + i  + "行护照号码格式不正确！";
//                    	    flag=true;
//                    	    resultMap.put("code", "0");
//                            resultMap.put("msg",fileType);
//                            return resultMap;
//                        }else {
//                            EmployeeListQueryDto ee =  new EmployeeListQueryDto();
//                            List<String> ls = new ArrayList<String>();
//                            ls.add(EmployeeStatus.PLAN_ENTRY.getCode());
//                            ls.add(EmployeeStatus.REFUSE.getCode());
//                            ls.add(EmployeeStatus.ON_JOB.getCode());
//                            ls.add("S");
//                            ee.setDataStatusList(ls);
//                            Pagination page = new Pagination();
//                            page.setCurrentPage(0);
//                            page.setPagesize(-1);
//                            ee.setPagination(page);
//                            List<EmployeeListResultDto> le = commonService.queryEmployeeListByCondition(ee).getR();
//                            for(int k=0;k<le.size();k++){
//                                if(Assert.equals(le.get(k).getCertNo(),value.toString())){
//                                    flag=true;
//                                    fileType="第"+i+"行"+"证件号码重复";
//                                    resultMap.put("code", "0");
//                                    resultMap.put("msg",fileType);
//                                    return resultMap;
//                                }
//                            }
//                            }
//                            if(!flag){
//                            employeeDto.setCertNo(value);
//                        }
//                        break;
//                    case "岗位职务":
//                        employeeDto.setPositionId(postions.get(value));
//                        if(Assert.checkParam(employeeDto.getPositionId()) && !Assert.checkParam(levels)) {
//                            List<LevelDto> dtoes = positionService.queryLevelsByPositionId(employeeDto.getPositionId());
//                            for(LevelDto dto : dtoes) {
//                                levels.put(dto.getLevelName(), dto.getLevelId());
//                            }
//                        } 
//                        if(Assert.checkParam(employeeDto.getPositionId()) && !Assert.checkParam(orgs)) {
//                            positionRequestDto.setPageType(null);
//                            positionRequestDto.setPositionId(employeeDto.getPositionId());
//                            List<OrgDto> dtoes = positionService.queryPowerOrgsByPositionId(positionRequestDto);
//                            for(OrgDto dto : dtoes) {
//                                orgs.put(dto.getOrgName(), dto.getOrgId());
//                            }
//                        }
//                        if(!Assert.checkParam(employeeDto.getPositionId())) {
//                            flag = true;
//                        }
//                        break;
//                    case "级别":
//                        Long levelId = levels.get(value);
//                        if(Assert.checkParam(levelId)) {
//                            employeeDto.setLevelId(levelId+"");
//                        } else {
//                            flag = true;
//                        }
//                        break;
//                    case "任职部门":
//                        Long orgId = null;
//                        if(value.indexOf("/") == -1) {
//                            orgId = orgs.get(value);
//                        } else {
//                            orgId = orgs.get(value.substring(value.lastIndexOf("/")+1));
//                        }
//                        if(Assert.checkParam(orgId)) {
//                            employeeDto.setOrgId(orgId);
//                        } else {
//                            flag = true;
//                        }
//                        break;
//                    case "工作性质":
//                        if(Assert.checkParam(JobCategory.getEunm(value))) {
//                            employeeDto.setJobCategory(JobCategory.getEunm(value).getCode()); 
//                        } else {
//                            flag = true;
//                        }
//                        break;
//                    case "试用期基本工资":
//                    	if(!value.contains(".") && Integer.parseInt(value)>0){
//                    	    Matcher matcherBasic1 = basicSalary.matcher(value);
//                    	    if (matcherBasic1.matches()) {
//                    	        employeeDto.setProBasicSalary(new BigDecimal(value));
//                            }else {
//                                flag=true;
//                                fileType="第"+i+"行"+"试用期基本工资应为大于0的整数,且最大位数不能为0";
//                                resultMap.put("code", "0");
//                                resultMap.put("msg",fileType);
//                                return resultMap;
//                            }
//                    	}else{
//                    		flag=true;
//                			fileType="第"+i+"行"+"试用期基本工资应为大于0的整数,且最大位数不能为0";
//                			resultMap.put("code", "0");
//                    		resultMap.put("msg",fileType);
//                    		return resultMap;
//                    	}
//                        break;
//                    case "试用期绩效工资":
//                        Matcher matcherPerf1 = perfSalary.matcher(value);
//                        if (matcherPerf1.matches()) {
//                            employeeDto.setProPerformanceSalary(new BigDecimal(value));
//                        }else {
//                            flag=true;
//                            fileType="第"+i+"行"+"试用期绩效工资应为大于等于0的整数,且最大位数不能为0";
//                            resultMap.put("code", "0");
//                            resultMap.put("msg",fileType);
//                            return resultMap;
//                        }
//                        break;
//                    case "转正后基本工资":
//                        if(!value.contains(".") && Integer.parseInt(value)>0){
//                            Matcher matcherBasic2 = basicSalary.matcher(value);
//                            if (matcherBasic2.matches()) {
//                                employeeDto.setRegularBasicSalary(new BigDecimal(value));
//                            }else {
//                                flag=true;
//                                fileType="第"+i+"行"+"转正后基本工资格应为大于0的整数,且最大位数不能为0";
//                                resultMap.put("code", "0");
//                                resultMap.put("msg",fileType);
//                                return resultMap;
//                            }
//                    	}else{
//                    		flag=true;
//                			fileType="第"+i+"行"+"转正后基本工资应为大于0的整数,且最大位数不能为0";
//                			resultMap.put("code", "0");
//                    		resultMap.put("msg",fileType);
//                    		return resultMap;
//                    	}
//                        break;
//                    case "转正后绩效工资":
//                        Matcher matcherPerf2 = perfSalary.matcher(value);
//                        if (matcherPerf2.matches()) {
//                            employeeDto.setRegularPerformanceSalary(new BigDecimal(value));
//                        }else {
//                            flag=true;
//                            fileType="第"+i+"行"+"转正后绩效工资应为大于等于0的整数,且最大位数不能为0";
//                            resultMap.put("code", "0");
//                            resultMap.put("msg",fileType);
//                            return resultMap;
//                        }
//                        break;    
//                    case "计划入职日期":
//                        employeeDto.setPlannedEntryDate(DateUtils.parse(value, "yyyy/MM/dd"));
//                        break;    
//                    default:
//                        break;
//                }
//            }
//            result.add(employeeDto);
//        }
//        if(flag) {
//            throw new BaseException("data error.");
//        }
//        Map<String,EmployeeEntryResultDTO> dto=commonService.pushPlannedEntryData(result);
//        LOGGER.info("***EmployeeEntryResultDTO() dto:{}***",new Gson().toJson(dto));
//        resultMap.put("code", "1");
//		resultMap.put("msg","上传成功");
//        return resultMap;
//    }
//    
//    private Map<String,Object> isEmpty(Cell cell) {
//        Map<String,Object> paramMap = new HashMap<String,Object>();
//        switch (cell.getCellType()) {
//            case Cell.CELL_TYPE_STRING:
//                paramMap.put(FLAG, Assert.checkParam(cell.getStringCellValue()));
//                paramMap.put(VALUE, cell.getStringCellValue());
//                break;
//            case Cell.CELL_TYPE_NUMERIC:
//                paramMap.put(FLAG, Assert.checkParam(cell.getNumericCellValue()));
//                paramMap.put(VALUE, cell.getNumericCellValue());
//                break;
//            case Cell.CELL_TYPE_FORMULA:
//                paramMap.put(FLAG, Assert.checkParam(cell.getDateCellValue()));
//                paramMap.put(VALUE, cell.getDateCellValue());
//                break;
//            default:
//                break;
//        }
//        return paramMap;
//    }
//    
//}
