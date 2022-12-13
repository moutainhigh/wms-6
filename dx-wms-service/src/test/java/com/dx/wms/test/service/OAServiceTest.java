package com.dx.wms.test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.hr.enums.App;
import com.dx.hr.enums.PositionProcess;
import com.dx.hr.service.api.IEmployeeProcessService;
import com.dx.hr.service.api.IEmployeeService;
import com.dx.hr.service.api.IOrgService;
import com.dx.hr.service.api.IPositionService;
import com.dx.hr.service.dto.EducationDto;
import com.dx.hr.service.dto.EmployeeDetailInfo;
import com.dx.hr.service.dto.EmployeeDto;
import com.dx.hr.service.dto.EmployeeEntryDto;
import com.dx.hr.service.dto.EmployeeEntryResultDTO;
import com.dx.hr.service.dto.EmployeeListQueryDto;
import com.dx.hr.service.dto.EmployeeListResultDto;
import com.dx.hr.service.dto.EmployeeSalaryDto;
import com.dx.hr.service.dto.EmployeeVideoDto;
import com.dx.hr.service.dto.FamilyDto;
import com.dx.hr.service.dto.OrgDto;
import com.dx.hr.service.dto.OrgRequestDto;
import com.dx.hr.service.dto.PositionDto;
import com.dx.hr.service.dto.PositionRequestDto;
import com.dx.hr.service.dto.ProcessParamDto;
import com.dx.hr.service.dto.TrainedExperienceDto;
import com.dx.hr.service.dto.WorkExperienceDto;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.enums.CodeRuleType;
import com.dx.wms.service.ICommonService;
import com.google.gson.Gson;

public class OAServiceTest extends BaseTest {
    @Autowired
    private IPositionService positionService;

    @Autowired
    private IOrgService orgService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEmployeeProcessService employeeProcessService;
    
    @Autowired
    private ICommonService commonService;
    
    @Test
    public void test_14() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("lenderCustCode", "L0533011604100001");
        String code = commonService.getCode(CodeRuleType.LENDER_CODE.getInfo(), 259L, map);
        System.out.println("!!!!!!!!!!!!!!!"+code);
    }
    @Test
    public void test_13() {
        
        EmployeeEntryDto dto = new EmployeeEntryDto();
        dto.setUserId(572L);
        dto.setEmployeeId(243L);
        dto.setApproveType(1);
        dto.setFormStatus(1);
        dto.setApproveMsg("我同意啦 ");
        ProcessParamDto param = new ProcessParamDto(App.WMS, PositionProcess.DEPARTMENT_ASSISTANT, dto);
        EmployeeEntryResultDTO result = employeeProcessService.executeStart(param);
        System.out.println("******test13***" + new Gson().toJson(result));
        
    }
    
    
    @Test
    public void test_1() {
        OrgRequestDto dto = new OrgRequestDto();
        dto.setOrgId(259l);
        OrgDto results = orgService.queryOrgByCondition(dto);
        System.out.println("******test1***" + new Gson().toJson(results));
    }

    @Test
    public void test_2() {
        List<OrgDto> results = orgService.queryOrgsByOrgId(258l);
        System.out.println("******test2***" + results.size());
        for (OrgDto dto : results) {
            System.out.println("******test2***" + new Gson().toJson(dto));
        }
    }

    @Test
    public void test_3() {
        List<OrgDto> results = orgService.queryOrgListByUserId(1111l);
        System.out.println("******test3***" + results.size());
        for (OrgDto dto : results) {
            System.out.println("******test3***" + new Gson().toJson(dto));
        }
    }

    @Test
    public void test_5() {
        PositionRequestDto dto = new PositionRequestDto();
        dto.setUserId(572l);
        List<PositionDto> results = positionService.queryPositionsByCondition(dto);
        for (PositionDto p : results) {
            System.out.println("******test5***" + new Gson().toJson(p));
        }
        System.out.println("******test5***" + new Gson().toJson(results));
    }

    @Test
    public void test_6() {
        List<EmployeeDto> dtos = new ArrayList<EmployeeDto>();
        EmployeeDto dto = new EmployeeDto();
        dto.setUserId(392l);
        dto.setName("杨宝河");
        dto.setSex(1);
        dto.setCertType(1);
        dto.setCertNo("350722197901010096");
        dto.setOrgId(235l);
        dto.setPositionId(14l);
        dto.setLevelId("2");
        dto.setPlannedEntryDate(new Date());
        dto.setProBasicSalary(new BigDecimal(1000l));
        dto.setProPerformanceSalary(new BigDecimal(1200l));
        dto.setRegularBasicSalary(new BigDecimal(1500l));
        dto.setRegularPerformanceSalary(new BigDecimal(3000l));
        dtos.add(dto);
        Map<String, EmployeeEntryResultDTO> map = employeeService.pushPlannedEntryData(dtos);
        System.out.println("**证件号码**" + map.get("350722197901010096").getIsSuccess()
                + map.get("350722197901010096").getMsg());

    }

     @Test
     public void test_7(){
     EmployeeEntryDto dto1 = new EmployeeEntryDto();
     //个人信息
     dto1.setStep(1);
     dto1.setUserId(572L);
     EmployeeDto emDto = new EmployeeDto();
     emDto.setEmployeeId(243L);
     emDto.setName("杨宝宝");
     emDto.setSex(1);
     emDto.setMobilePhone("13916077521");
     emDto.setCertType(1);
     emDto.setCertNo("370628196611270027");
     emDto.setEntryDate(new Date());
     emDto.setJobCategory(1);
     dto1.setEmployeeDto(emDto);
     EmployeeDetailInfo deDto = new EmployeeDetailInfo();
     deDto.setEntrySource(1);
     deDto.setCertValidStart(new Date());
     deDto.setCertValidEnd(new Date());
     deDto.setBirthDate(new Date());
     deDto.setEmail("789132@qq.com");
     deDto.setPoliticalStatus(1);
     deDto.setDegree(1);
     deDto.setCountry(1);
     deDto.setNation(1);
     deDto.setWorkUnit(1);
     deDto.setMaritalStatus(1);
     deDto.setCensusRegister(1);
     deDto.setCensusProvinceCode("370000");  
     deDto.setCensusCityCode("370200");
     deDto.setCensusAreaCode("370203");
     deDto.setCensusAddress("住在黄土高坡");
     deDto.setCensusZipCode("200010");
     deDto.setHomeProvinceCode("370000");  
     deDto.setHomeCityCode("370200");
     deDto.setHomeAreaCode("370203");
     deDto.setHomeAddress("住在松花江");
     deDto.setHomeZipCode("200020");
     dto1.setEmployeeDetailInfo(deDto);
     EmployeeSalaryDto saDto = new EmployeeSalaryDto();
     saDto.setProBasicSalary(new BigDecimal(11100));
     saDto.setProPerformanceSalary(new BigDecimal(11200));
     saDto.setRegularBasicSalary(new BigDecimal(11300));
     saDto.setRegularPerformanceSalary(new BigDecimal(11400));
     dto1.setEmployeeSalaryDto(saDto);
     dto1.setEducationDtos(new ArrayList<EducationDto>());
     FamilyDto ff = new FamilyDto();
     ff.setName("杨一一");
     ff.setRelationShip(1);
     ff.setMobilePhone("13916077521");
     ff.setWorkUnit("111");
     List<FamilyDto> familys = new ArrayList<FamilyDto>();
     familys.add(ff);
     dto1.setFamilyDtos(familys);
     dto1.setWorkExperienceDtos(new ArrayList<WorkExperienceDto>());
     dto1.setTrainedExperienceDtos(new ArrayList<TrainedExperienceDto>());
     dto1.setEmployeeVideoDtos(new ArrayList<EmployeeVideoDto>());
     //dto1.setSocialDto(new SocialDto());
     
     EmployeeEntryResultDTO result=employeeService.pushEmployeeEntryData(dto1);
     System.out.println("******test7***" + new Gson().toJson(result));
     }

    @Test
    public void test_9() {
        EmployeeListQueryDto dto = new EmployeeListQueryDto();
        Pagination page = new Pagination();
        // dto.setOrgId(259l);
        dto.setPagination(page);
        List<EmployeeListResultDto> results = employeeService.queryEmployeeListByCondition(dto).getR();
        System.out.println("******test9***" + new Gson().toJson(results));
    }

    @Test
    public void test_10() {
        String code = "CFTZGL";
        List<PositionDto> positionDtos = positionService.queryPositionDtosByOrgId(245l);
        for (PositionDto dto : positionDtos) {
            System.out.println("******test10***" + new Gson().toJson(dto));
        }

    }

    @Test
    public void test_11() {
        PositionRequestDto positionRequestDto = new PositionRequestDto();
        positionRequestDto.setUserId(571L);
        positionRequestDto.setPageType(1);
        List<PositionDto> positionDtos = positionService.queryPositionDtosByCondition(positionRequestDto);
        for (PositionDto dto : positionDtos) {
            System.out.println("******test10***" + new Gson().toJson(dto));
        }
    }
}
