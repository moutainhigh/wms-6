package com.dx.wms.web.hr.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.bpm.constants.ProcessOnBoardWealthConstans;
import com.dx.common.service.utils.Assert;
import com.dx.hr.service.dto.CommentRequestDto;
import com.dx.hr.service.dto.CommentResultDto;
import com.dx.hr.service.dto.EmployeeDto;
import com.dx.hr.service.dto.EmployeeLogDto;
import com.dx.hr.service.dto.OrgDto;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.detail.ResultDetail;
import com.dx.wms.web.hr.service.IHRResultService;

@Service
public class HRResultServiceImpl implements IHRResultService {

    @Autowired
    private ICommonService commonService;

    @Override
    public void getResult(ResultDetail result, Long userId, Map<String, String> addrMap, Map<String, String> orgs,
            List<CommentResultDto> approves, List<EmployeeLogDto> logs, Long parentId) {
        Assert.notNull("员工信息不能为空", result.getEmployeeEntryDto());
        Assert.notNull("员工详情信息不能为空", result.getEmployeeEntryDto().getEmployeeDetailInfo());
        Assert.notNull("员工社保信息不能为空", result.getEmployeeEntryDto().getSocialDto());
        Long employeeId = result.getEmployeeEntryDto().getEmployeeDto().getEmployeeId();
        approves = getApproves(employeeId);
        orgs = commonService.getAllOrgDtos(userId);
        parentId = getParentId(result.getEmployeeEntryDto().getEmployeeDto());
        addrMap = commonService.queryForAreas(
                result.getEmployeeEntryDto().getEmployeeDetailInfo().getBankProvinceCode(),
                result.getEmployeeEntryDto().getEmployeeDetailInfo().getBankCityCode(),
                result.getEmployeeEntryDto().getSocialDto().getInsuredProvinceCode(),
                result.getEmployeeEntryDto().getSocialDto().getInsuredCityCode());

    }

    private Long getParentId(EmployeeDto dto) {
        OrgDto orgDto = commonService.queryOrgByOrgId(dto.getOrgId());
        Long parentId = orgDto.getParentId();
        if (!Assert.checkParam(parentId)) {
            return -1L;
        }
        orgDto = commonService.queryOrgByOrgId(parentId);
        if (orgDto.getOrgName().indexOf("Cluster") < 0 || orgDto.getOrgName().indexOf("直属团队") < 0) {
            return -1L;
        }
        return parentId;
    }

    @Override
    public List<CommentResultDto> getApproves(Long employeeId) {
        CommentRequestDto dto = new CommentRequestDto();
        dto.setEmployeeId(employeeId);
        dto.setBusinessType(ProcessOnBoardWealthConstans.PROCESS_DEFINITION_ONBOARDWEALTHAPPLICATION);
        return commonService.queryEmployeeEntryApproveMsg(dto);
    }

}
