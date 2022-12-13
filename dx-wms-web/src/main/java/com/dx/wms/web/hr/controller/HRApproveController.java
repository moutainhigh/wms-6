//package com.dx.wms.web.hr.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dx.bpm.constants.ProcessOnBoardShiftWealthConstans;
//import com.dx.bpm.constants.ProcessOnBoardWealthConstans;
//import com.dx.ccs.vo.RoleVo;
//import com.dx.common.service.utils.Assert;
//import com.dx.framework.dal.pagination.Pagination;
//import com.dx.framework.dal.pagination.PaginationResult;
//import com.dx.hr.enums.ApproveType;
//import com.dx.hr.service.dto.CommentResultDto;
//import com.dx.hr.service.dto.EmployeeEntryDto;
//import com.dx.hr.service.dto.EmployeeEntryResultDTO;
//import com.dx.hr.service.dto.EmployeeListResultDto;
//import com.dx.hr.service.dto.ProcessRequestDto;
//import com.dx.wms.constant.RoleConstant;
//import com.dx.wms.constant.WMSConstants;
//import com.dx.wms.web.hr.vo.CommentResultVo;
//import com.dx.wms.web.hr.vo.EmployeeEntryVo;
//import com.dx.wms.web.hr.vo.HRParamVo;
//import com.dx.wms.web.hr.vo.ResultHRVo;
//import com.dx.wms.web.page.AjaxDataTableObj;
//import com.dx.wms.web.page.DataTableObj;
//import com.dx.wms.web.util.WebCommonUtil;
//import com.google.gson.Gson;
//
//@Controller
//@RequestMapping("/hrApprove")
//public class HRApproveController extends HRController {
//
//    //入职审批和异动审批查询{biz:entry,biz:move}
//    @RequestMapping("/{biz}.htm")
//    public String init(@PathVariable("biz") String biz, ModelMap model, HttpServletRequest request) {
//        return init(biz, commonService.getUserId(request), model);
//    }
//
//    //入职审批和异动审批查询{biz:entry,biz:move}
//    @RequestMapping("/{biz}.json")
//    @ResponseBody
//    public AjaxDataTableObj<ResultHRVo> query(@PathVariable("biz") String biz, HRParamVo param,
//            DataTableObj dTable, HttpServletRequest request) {
//        LOG.info("**query() biz:{}**", biz);
//        Long userId = commonService.getUserId(request);
//        ProcessRequestDto dto = convertParam(biz, param, userId, dTable);
//        PaginationResult<List<EmployeeListResultDto>> results = commonService.query(dto);
//        LOG.info("**query() results:{}**", new Gson().toJson(results));
//        return new AjaxDataTableObj<ResultHRVo>(dTable, convertResults(results, userId));
//    }
//
//    //入职页面数据转换成DTO
//    private ProcessRequestDto convertParam(String biz, HRParamVo param, Long userId, DataTableObj dTable) {
//        ProcessRequestDto processRequestDto = new ProcessRequestDto();
//        BeanUtils.copyProperties(param, processRequestDto);
//        processRequestDto.setUserId(userId);
//        approveBusinessType(biz, processRequestDto, userId);
//        Pagination page = WebCommonUtil.initPage(dTable);
//        processRequestDto.setPagination(page);
//        processRequestDto.setPositionId(!Assert.checkParam(processRequestDto.getPositionId())?null:
//        	processRequestDto.getPositionId());
//        processRequestDto.setJobCategory(!Assert.checkParam(processRequestDto.getJobCategory())?null:
//        	processRequestDto.getJobCategory());
//        return processRequestDto;
//    }
//
//    //入职页面根据biz判断返回processRequestDto的环节定义和环节Id
//    private void approveBusinessType(String biz, ProcessRequestDto processRequestDto, Long userId) {
//        switch (biz) {
//        //根据biz做判断返回不同type的dto
//            case "moveApprove":
//                processRequestDto
//                        .setBusinessType(ProcessOnBoardShiftWealthConstans.PROCESS_DEFINITION_ONBOARDSHIFTWEALTHAPPLICATION);
//                processRequestDto.setTaskKey(moveApproveTaskKey(commonService.findRolesByUserId(userId)));
//                break;
//            case "entryApprove":
//                processRequestDto
//                        .setBusinessType(ProcessOnBoardWealthConstans.PROCESS_DEFINITION_ONBOARDWEALTHAPPLICATION);
//                processRequestDto.setTaskKey(entryApproveTaskKey(commonService.findRolesByUserId(userId)));
//                break;
//        }
//
//    }
//    
//    //异动审批审批页面
//  	@RequestMapping(value = "{biz}_start.json")
//  	public String transaction(HttpServletRequest request,
//  			ModelMap model,Long employeeId,Long positionId,String taskId,
//  			@PathVariable("biz") String biz,String targetOrg,String targetPosition,String procInsId){
//  		put(request,model,employeeId,positionId,biz);
//  		putApprove(model,taskId,targetOrg,targetPosition,procInsId);
//  		return "hr/in_service/approve_create";
//  	}
//
//  	//异动审批加载model
//    private void putApprove(ModelMap model, String taskId,String targetOrg,String targetPosition,String procInsId) {
//    	List<CommentResultDto> commentResultDtos = commonService.queryLog(procInsId);
//    	List<CommentResultVo> commentResultVos = new ArrayList<CommentResultVo>();
//    	for (int i = 0; i < commentResultDtos.size(); i++) {
//    		commentResultVos.add(new CommentResultVo(commentResultDtos.get(i)));
//		}
//    	try {
//    		model.addAttribute("targetOrg", new String(targetOrg.getBytes("iso-8859-1"), "UTF-8"));
//			model.addAttribute("targetPosition",new String(targetPosition.getBytes("iso-8859-1"), "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//    	model.addAttribute("procInsId", procInsId);
//    	model.addAttribute("taskId", taskId);
//    	model.addAttribute("commentResultVos", commentResultVos);
//	}
//
//    //异动审批理财人事根据角色申请定义判断
//	private String moveApproveTaskKey(List<RoleVo> roleVos) {
//        if (commonService.hasRoleExist(roleVos, RoleConstant.YYBJL)
//                || commonService.hasRoleExist(roleVos, RoleConstant.QYJL)
//                || commonService.hasRoleExist(roleVos, RoleConstant.FGSJL)) {
//            return ProcessOnBoardShiftWealthConstans.TASK_ONBOARDCHECK;
//        } else if (commonService.hasRoleExist(roleVos, RoleConstant.RSZG)) {
//            return ProcessOnBoardShiftWealthConstans.TASK_HUMANRESOURCESCHECK;
//        } else if (commonService.hasRoleExist(roleVos, RoleConstant.FZC)) {
//            return ProcessOnBoardShiftWealthConstans.TASK_PRESIDENTCHECK;
//        } else {
//            return null;
//        }
//    }
//
//	//理财入职审批理财人事根据角色申请定义判断
//    private String entryApproveTaskKey(List<RoleVo> roleVos) {
//        if (commonService.hasRoleExist(roleVos, RoleConstant.YYBJL)
//                || commonService.hasRoleExist(roleVos, RoleConstant.QYJL) || commonService.hasRoleExist(roleVos, RoleConstant.FGSJL)) {
//            return ProcessOnBoardWealthConstans.TASK_ONBOARDCHECK;
//        } else if (commonService.hasRoleExist(roleVos, RoleConstant.RSZG)) {
//            return ProcessOnBoardWealthConstans.TASK_HUMANRESOURCESCHECK;
//        } else if (commonService.hasRoleExist(roleVos, RoleConstant.FZC)) {
//            return ProcessOnBoardWealthConstans.TASK_PRESIDENTCHECK;
//        } else {
//            return null;
//        }
//    }
//    //入职审批
//    @RequestMapping(value = "/emp_entry_approve.json")
//    public String approve(@ModelAttribute("employeeId") Long employeeId,String procInsId,String taskId,ModelMap model,HttpServletRequest request){
//        LOG.info("**approve() employeeId:{},procInsId:{}**",employeeId,procInsId);
//        Long userId = (Long) request.getSession().getAttribute(WMSConstants.USER_ID);
//        model.put("userId", userId);
//        put(model,employeeId,request,procInsId,taskId);
//        return "hr/approve/entry_approve";
//    }
//    /**
//     * 审批异动人员,入职审批
//     * @param request
//     * @param employeeEntryDto
//     * @return EmployeeEntryResultDTO
//     */
//    @RequestMapping(value = "{biz}_approve.json")
//    @ResponseBody
//    public EmployeeEntryResultDTO forApprove(@PathVariable("biz") String biz,@RequestBody EmployeeEntryVo entryVo,
//            HttpServletRequest request) {
//        LOG.info("**approve() biz:{},entryVo:{}**",biz,new Gson().toJson(entryVo));
//        Long userId = commonService.getUserId(request);
//        EmployeeEntryDto employeeEntryDto = param(entryVo,userId,biz);
//        LOG.info("**approve() employeeEntryDto:{}**",new Gson().toJson(employeeEntryDto));
//        return commonService.executeComplete(employeeEntryDto);
//    }
//    private EmployeeEntryDto param(EmployeeEntryVo entryVo,Long userId,String biz){
//        EmployeeEntryDto entryDto = new EmployeeEntryDto();
//        BeanUtils.copyProperties(entryVo,entryDto);
//        entryDto.setFormStatus(entryVo.getFormStatus());
//        entryDto.setUserId(userId);
//        //根据biz做判断返回不同type的dto
//        switch (biz) {
//            case "move":
//                entryDto.setApproveType(ApproveType.CHANGE.getCode());
//                return entryDto;
//
//            case "entry":
//                entryDto.setApproveType(ApproveType.ENTRY.getCode());
//                return entryDto;
//        }
//        return entryDto;
//    }
//
//}
