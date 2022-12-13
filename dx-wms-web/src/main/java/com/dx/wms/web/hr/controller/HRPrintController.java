///*
// * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
// * FileName: HRPrintController.java
// * Author:   FlaTa
// * Date:     2016年4月14日 上午9:48:58
// * Description: //模块目的、功能描述      
// * History: //修改记录
// * <author>      <time>      <version>    <desc>
// * 修改人姓名             修改时间            版本号                  描述
// */
//package com.dx.wms.web.hr.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.dx.hr.enums.SexType;
//import com.dx.hr.service.api.IEmployeeService;
//import com.dx.hr.service.api.IOrgService;
//import com.dx.hr.service.dto.EmployeeEntryDto;
//import com.dx.hr.service.dto.OrgDto;
//import com.dx.hr.service.dto.OrgRequestDto;
//import com.dx.wms.service.ICommonService;
//
///**
// * 〈一句话功能简述〉<br> 
// * 〈功能详细描述〉
// *
// * @author FlaTa
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Controller
//@RequestMapping("/hrPrint")
//public class HRPrintController {
//
//    @Autowired
//    ICommonService commonService;
//
//    @Autowired
//    IOrgService orgService;
//    
//    @Autowired
//    IEmployeeService employeeService;
//    
//    @RequestMapping("/print.json")
//    public String printPage(HttpServletRequest request ,ModelMap model ,@ModelAttribute("employeeId") Long employeeId){
//        EmployeeEntryDto employeeEntrydto = employeeService.queryEmployeeDetailByEmployeeId(employeeId);
//        // 员工编号
//        model.addAttribute("employeeNo", employeeEntrydto.getEmployeeDto().getEmployeeNo());
//        // 员工姓名
//        model.addAttribute("employeeName", employeeEntrydto.getEmployeeDto().getName());
//        // 员工部门
//        model.addAttribute("employeeOrg", employeeEntrydto.getEmployeeDto().getOrgName());
//        // 员工服务单位
//        model.addAttribute("workUnit", employeeEntrydto.getWorkUnit());
//        // 员工性别
//        model.addAttribute("employeeAgenda",SexType.getInfo(Integer.valueOf(employeeEntrydto.getEmployeeDto().getSex().toString())));
//        // 户籍地址
//        model.addAttribute("censusAddress", employeeEntrydto.getEmployeeDetailInfo().getCensusAddress());
//        // 员工身份证号
//        model.addAttribute("employeeIdCard", employeeEntrydto.getEmployeeDto().getCertNo());
//        // 出生日期
//        model.addAttribute("birthDate", employeeEntrydto.getEmployeeDetailInfo().getBirthDate());
//        // 家庭住址
//        model.addAttribute("homeAddress", employeeEntrydto.getEmployeeDetailInfo().getHomeAddress());
//        // 家庭邮政编码
//        model.addAttribute("homeZipCode", employeeEntrydto.getEmployeeDetailInfo().getHomeZipCode());
//        // 联系电话
//        model.addAttribute("mobilePhone", employeeEntrydto.getEmployeeDto().getMobilePhone());
//        // 岗位名称
//        model.addAttribute("positionName", employeeEntrydto.getEmployeeDto().getPositionName());
//        // 入职日期
//        model.addAttribute("entryDate", employeeEntrydto.getEmployeeDto().getEntryDate());
//        // 部门总称
//        String orgFullName = "";
//        Long orgId = employeeEntrydto.getEmployeeDto().getOrgId();
//        while (orgId != null) {  
//            OrgRequestDto rdto = new OrgRequestDto();
//            rdto.setOrgId(orgId);
//            OrgDto oDto = orgService.queryOrgByCondition(rdto);
//            orgFullName = oDto.getOrgName()+"/"+orgFullName;
//            orgId = oDto.getParentId();
//        }
//        String oFullName = orgFullName.substring(orgFullName.indexOf("/")+1, orgFullName.lastIndexOf("/"));
//        model.addAttribute("orgFullName", oFullName);
//        model.addAttribute("orgFullName2", oFullName.substring(oFullName.indexOf("/")+1));
//        return "hr/print/laborContract";
//    }
//}
