//package com.dx.wms.web.hr.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dx.common.service.utils.Assert;
//import com.dx.hr.enums.App;
//import com.dx.hr.service.dto.EmployeeEntryDto;
//import com.dx.hr.service.dto.EmployeeEntryResultDTO;
//import com.dx.hr.service.dto.ProcessParamDto;
//import com.dx.hr.service.dto.PushAdjustDataDto;
//
//@Controller
//@RequestMapping("/inService")
//public class HRInServiceController extends HRController{
//	
//	//异动审批发起流程
//	@RequestMapping("/approveto.json")
//    @ResponseBody
//    public EmployeeEntryResultDTO approveto(Long employeeId, HttpServletRequest request, Long orgId, Long positionId,
//            Long levelId) {
//		Assert.notNull("员工Id不能为空", employeeId);
//        EmployeeEntryDto dto = new EmployeeEntryDto();
//        dto.setUserId(commonService.getUserId(request));
//        dto.setApproveType(2);
//        dto.setEmployeeId(employeeId);
//        dto.setFormStatus(1);
//        PushAdjustDataDto pushDto = new PushAdjustDataDto();
//        pushDto.setBusinessType(1);
//        pushDto.setNewOrgId(orgId);
//        pushDto.setNewPositionId(positionId);
//        pushDto.setNewLevelId(levelId.toString());
//        dto.setPushAdjustDataDto(pushDto);
//        return commonService.executeStart(new ProcessParamDto(App.WMS, getProcess(dto.getUserId()), dto));
//    }
//
// // 在职异动审批流发起的页面{biz:inService,biz:moveApprove}
//    @RequestMapping(value = "{biz}_start.json")
//    public String transaction(HttpServletRequest request, ModelMap model, Long employeeId, Long positionId,
//            @PathVariable("biz") String biz) {
//        put(request, model, employeeId, positionId, biz);
//        return "hr/in_service/create";
//    }
//
//}
