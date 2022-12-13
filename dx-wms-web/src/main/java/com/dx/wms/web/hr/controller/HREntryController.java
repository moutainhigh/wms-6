///*
// * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
// * FileName: HREntryController.java
// * Author:   yangbao
// * Date:     2016年1月22日 下午5:39:40
// * Description: //模块目的、功能描述      
// * History: //修改记录
// * <author>      <time>      <version>    <desc>
// * 修改人姓名             修改时间            版本号                  描述
// */
//package com.dx.wms.web.hr.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dx.common.service.utils.Assert;
//import com.dx.hr.enums.App;
//import com.dx.hr.service.dto.EmployeeDto;
//import com.dx.hr.service.dto.EmployeeEntryDto;
//import com.dx.hr.service.dto.EmployeeEntryResultDTO;
//import com.dx.hr.service.dto.HandleResultDto;
//import com.dx.hr.service.dto.LevelDto;
//import com.dx.hr.service.dto.OrgDto;
//import com.dx.hr.service.dto.ProcessParamDto;
//import com.dx.wms.constant.WMSConstants;
//import com.dx.wms.web.hr.vo.EmployeeEntryVo;
//import com.dx.wms.web.hr.vo.EmployeeTempletVo;
//import com.dx.wms.web.hr.vo.EmployeeVo;
//import com.dx.wms.web.util.ExportExcelUtil;
//import com.google.gson.Gson;
//
///**
// * 〈一句话功能简述〉入职管理 〈功能详细描述〉
// *
// * @author yangbao
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Controller
//@RequestMapping("/hrEntry")
//public class HREntryController extends HRController {
//
//    /**
//     * 入职管理员工下载模板
//     */
//    private static final String[] LOAN_ENTRY_EXCEL = { "员工姓名", "性别", "证件类型", "证件号码", "岗位职务", "级别", "任职部门", "工作性质", "试用期基本工资",
//            "试用期绩效工资", "转正后基本工资", "转正后绩效工资", "计划入职日期" };
//
//    // 创建人员管理
//    @RequestMapping("/create.json")
//    public String create(ModelMap model, HttpServletRequest request) {
//        put(commonService.getUserId(request), model);
//        return "hr/entry/create";
//    }
//
//    // 员工预入职保存
//    @RequestMapping(value = "save.json", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, EmployeeEntryResultDTO> saveEmployee(@RequestBody EmployeeVo employeeVo,
//            HttpServletRequest request) {
//        LOG.info("**saveEmployee() employeeVo:{}**", new Gson().toJson(employeeVo));
//        EmployeeDto employeeDto = param(employeeVo, commonService.getUserId(request));
//        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
//        employeeDtos.add(employeeDto);
//        LOG.info("**saveEmployee() employeeDtos:{}**", new Gson().toJson(employeeDtos));
//        return commonService.pushPlannedEntryData(employeeDtos);
//    }
//
//    // vo转dto
//    private EmployeeDto param(EmployeeVo employeeVo, Long userId) {
//        EmployeeDto dto = new EmployeeDto();
//        BeanUtils.copyProperties(employeeVo, dto);
//        dto.setUserId(userId);
//        return dto;
//    }
//
//    // 填写员工入职信息
//    @RequestMapping("/entryDetail.json")
//    public String detail(@ModelAttribute("employeeId") Long employeeId, String taskId, String procInsId,
//            ModelMap model, HttpServletRequest request) {
//        LOG.info("**detail() employeeId:{},taskId:{},procInsId:{}**", employeeId, taskId, procInsId);
//        put(model, employeeId, commonService.getUserId(request), taskId, procInsId);
//        return "hr/entry/entry";
//    }
//
//    // 员工入职和重新提交保存
//    @RequestMapping(value = "entrySave.json", method = RequestMethod.POST)
//    @ResponseBody
//    public EmployeeEntryResultDTO entrySave(@RequestBody EmployeeEntryVo entryVo, HttpServletRequest request) {
//        LOG.info("**entrySave() employeeVo:{}**", new Gson().toJson(entryVo));
//        Long userId = commonService.getUserId(request);
//        entryVo.put(entryVo);
//        EmployeeEntryDto entryDto = param(entryVo, userId);
//        return save(entryVo, userId, entryDto);
//    }
//
//    // 个人信息、公积金、启动流程
//    private EmployeeEntryResultDTO save(EmployeeEntryVo employeeEntryVo, Long userId, EmployeeEntryDto entryDto) {
//        if (Assert.checkParam(employeeEntryVo.getApproveType())) {
//            ProcessParamDto param = new ProcessParamDto(App.WMS, getProcess(userId), entryDto);
//            // 入职提交，开始启动流程
//            return commonService.executeStart(param);
//        }
//        LOG.info("**entrySave() entryDto:{}**", new Gson().toJson(entryDto));
//        // 个人信息和公积金保存
//        return commonService.saveHrInfo(entryDto);
//    }
//
//    // 入职vo转dto
//    private EmployeeEntryDto param(EmployeeEntryVo employeeVo, Long userId) {
//        EmployeeEntryDto entryDto = new EmployeeEntryDto();
//        entryDto.setUserId(userId);
//        if (Assert.checkParam(employeeVo.getStep())) {
//            switch (employeeVo.getStep()) {
//                case 1:
//                    setEmployee(employeeVo, entryDto);
//                    break;
//                case 2:
//                    setSocial(employeeVo, entryDto);
//                    break;
//            }
//        } else if (Assert.checkParam(employeeVo.getApproveType())) {
//            // 启动流程
//            setApprove(employeeVo, entryDto);
//        }
//        return entryDto;
//    }
//
//    // 个人信息和个人详情dto
//    private void setEmployee(EmployeeEntryVo employeeVo, EmployeeEntryDto entryDto) {
//        entryDto.setEmployeeDetailInfo(employeeVo.getEmployeeDetailInfo());
//        entryDto.setEmployeeDto(employeeVo.getEmployeeDto());
//        entryDto.setEducationDtos(employeeVo.getEducationDtos());
//        entryDto.setFamilyDtos(employeeVo.getFamilyDtos());
//        entryDto.setWorkExperienceDtos(employeeVo.getWorkExperienceDtos());
//        entryDto.setTrainedExperienceDtos(employeeVo.getTrainedExperienceDtos());
//        entryDto.setStep(1);
//    }
//
//    // 保存公积金
//    private void setSocial(EmployeeEntryVo employeeVo, EmployeeEntryDto entryDto) {
//        entryDto.setSocialDto(employeeVo.getSocialDto());
//        entryDto.setStep(employeeVo.getStep());
//        entryDto.setEmployeeDto(employeeVo.getEmployeeDto());
//    }
//
//    // 入职提交启动流程
//    private void setApprove(EmployeeEntryVo employeeVo, EmployeeEntryDto entryDto) {
//        entryDto.setEmployeeId(employeeVo.getEmployeeId());
//        entryDto.setApproveType(employeeVo.getApproveType());
//        entryDto.setApproveMsg(employeeVo.getApproveMsg());
//        entryDto.setFormStatus(1);
//    }
//
//    // 员工入职添加信息删除
//    @RequestMapping(value = "delete.json", method = RequestMethod.POST)
//    @ResponseBody
//    public HandleResultDto delete(@RequestBody EmployeeEntryVo employeeEntryVo, HttpServletRequest request) {
//        Assert.notNull("**delete() employeeEntryVo must be not null **", employeeEntryVo);
//        LOG.info("**delete() employeeEntryVo:{}**", new Gson().toJson(employeeEntryVo));
//        Long userId = commonService.getUserId(request);
//        return commonService.deleteVideo(employeeEntryVo.getDeleteId(), userId, employeeEntryVo.getInfoType());
//    }
//
//    @RequestMapping("/excelExoprt.json")
//    public void downloadTemplet(@RequestParam("position") Long positionId, String name, HttpServletRequest request,
//            HttpServletResponse response) {
//        LOG.info("**downloadTemplet() positionId:{},name:{}**", positionId, name);
//        Long userId = commonService.getUserId(request);
//        String positionName = WMSConstants.EMPTY;
//        String fileName = "员工模板";
//        try {
//            positionName = new String(name.getBytes("iso8859-1"), "utf8");
//            fileName = new String(fileName.getBytes("gbk"), "iso8859-1");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        List<EmployeeTempletVo> temVos = getTempletVo(userId, positionId, positionName);
//        ExportExcelUtil.excelEmployeeExoprt(null, LOAN_ENTRY_EXCEL, null, temVos, temVos.get(0).getSexList(), temVos
//                .get(0).getCertTypeList(), temVos.get(0).getJobCategory(), null, "员工模板", response, "yyyy/MM/dd", temVos
//                .get(0).getLevelList(), temVos.get(0).getOrgList(), fileName);
//    }
//
//    private List<EmployeeTempletVo> getTempletVo(Long userId, Long positionId, String positionName) {
//        List<EmployeeTempletVo> temVos = new ArrayList<EmployeeTempletVo>();
//        EmployeeTempletVo temVo = new EmployeeTempletVo();
//        temVo.setPositionName(positionName);
//        List<OrgDto> orgDtos = new ArrayList<OrgDto>();
//        orgDtos = commonService.queryPowerOrgsByPositionId(positionId, userId);
//        String[] orgList = new String[] {};
//        String org = "";
//        for (OrgDto orgDto : orgDtos) {
//            org += orgDto.getOrgGroupName() + ",";
//        }
//        orgList = org.split(",");
//        temVo.setOrgList(orgList);
//        List<LevelDto> levelDtos = commonService.queryLevelsByPositionId(positionId);
//        String[] levelList = new String[] {};
//        String level = "";
//        for (LevelDto levelDto : levelDtos) {
//            level += levelDto.getLevelName() + ",";
//        }
//        levelList = level.split(",");
//        temVo.setLevelList(levelList);
//        temVo.put(temVo);
//        temVos.add(temVo);
//        return temVos;
//    };
//
//}
