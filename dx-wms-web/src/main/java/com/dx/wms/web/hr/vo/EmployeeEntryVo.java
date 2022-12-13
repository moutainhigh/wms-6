/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: EmployeeEntryVo.java
 * Author:   yangbao
 * Date:     2016年1月15日 下午2:16:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.Trans2Birthday;
import com.dx.hr.service.dto.CommentResultDto;
import com.dx.hr.service.dto.EducationDto;
import com.dx.hr.service.dto.EmployeeDetailInfo;
import com.dx.hr.service.dto.EmployeeDto;
import com.dx.hr.service.dto.EmployeeEntryDto;
import com.dx.hr.service.dto.EmployeeLogDto;
import com.dx.hr.service.dto.EmployeeSalaryDto;
import com.dx.hr.service.dto.EmployeeVideoDto;
import com.dx.hr.service.dto.FamilyDto;
import com.dx.hr.service.dto.SocialDto;
import com.dx.hr.service.dto.TrainedExperienceDto;
import com.dx.hr.service.dto.WorkExperienceDto;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.web.util.AreaFullNameUtil;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EmployeeEntryVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * userId 操作人Id
     */
    private Long userId;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 步骤 保存个人信息：1；保存公积金信息：2；保存影像件信息：3
     */
    private Integer step;

    /**
     * 审批类型 入职审批：1; 异动审批：2
     */
    private Integer approveType;
    /**
     * 审批意见
     */
    private String approveMsg;

    /**
     * 审批状态 1：同意 2：拒绝
     */
    private Integer formStatus;

    private String formStatusView;

    /**
     * 员工相关信息
     */
    private EmployeeDto employeeDto;

    /**
     * 员工相关信息
     */
    private EmployeeVo employeeVo;

    /**
     * 员工详细信息
     */
    private EmployeeDetailInfo employeeDetailInfo;

    /**
     * 员工详细信息
     */
    private DetailInfoVo detailInfoVo;

    /**
     * 薪资信息
     */
    private EmployeeSalaryDto employeeSalaryDto;

    /**
     * 薪资信息
     */
    private EmployeeSalaryVo employeeSalaryVo;

    /**
     * 教育背景
     */
    private List<EducationDto> educationDtos;

    /**
     * 教育背景
     */
    private List<EducationVo> educationVos;

    /**
     * 家庭背景
     */
    private List<FamilyDto> familyDtos;

    /**
     * 家庭背景
     */
    private List<FamilyVo> familyVos;

    /**
     * 工作经历
     */
    private List<WorkExperienceDto> workExperienceDtos;

    /**
     * 工作经历
     */
    private List<WorkExperienceVo> workExperienceVos;

    /**
     * 培训经历
     */
    private List<TrainedExperienceDto> trainedExperienceDtos;

    /**
     * 培训经历
     */
    private List<TrainedExperienceVo> trainedExperienceVos;

    /**
     * 影像件
     */
    private List<EmployeeVideoDto> employeeVideoDtos;

    /**
     * 影像件
     */
    private List<EmployeeVideoVo> employeeVideoVos;

    /**
     * 社保信息
     */
    private SocialVo socialVo;

    private SocialDto socialDto;
    /**
     * 流程实例Id
     */
    private String procInsId;

    /**
     * 流程定义
     */
    private String businessType;

    /**
     * 当前环节ID
     */
    private String taskId;

    /**
     * 当前环节定义
     */
    private String taskKey;

    /**
     * 审批日志
     */
    private List<CommentResultDto> commentResultDtos;

    private List<CommentResultVo> commentResultVos;

    /**
     * 员工日志
     */
    private List<EmployeeLogDto> logDtos;

    /**
     * 银行省
     */
    private String province;

    /**
     * 银行市
     */
    private String bankCity;

    /**
     * 公积金省市
     */
    private String insured;

    /**
     * 删除添加信息的id
     */
    private Long deleteId;

    /**
     * 删除（家庭、学校、工作、培训）各信息的枚举
     */
    private Integer infoType;

    public EmployeeEntryVo(EmployeeEntryDto result, String orgName, String censusArea, String homeArea,
            String bankArea) {
        BeanUtils.copyProperties(result, this);
        setEmployeeVo(new EmployeeVo(getEmployeeDto(), orgName));

        setDetailInfoVo(new DetailInfoVo(getEmployeeDetailInfo(), censusArea, homeArea, bankArea));
        getDetailInfoVo().setBirthDateView(!Assert.checkParam(getDetailInfoVo().getBirthDateView())
                && Assert.checkParam(Trans2Birthday.ageByIdCard(getEmployeeVo().getCertNo()))
                        ? Trans2Birthday.ageByIdCard(getEmployeeVo().getCertNo())
                        : getDetailInfoVo().getBirthDateView());
        setFamilyVo(result);
        setEducationVo(result);
        setWorkExperienceVo(result);
        setTrainedExperienceVo(result);
        setSocialVo(new SocialVo(result.getSocialDto()));
    }

    // 将从数据库查询出的家庭信息转为vo
    private void setFamilyVo(EmployeeEntryDto result) {
        List<FamilyVo> familyVos = new ArrayList<FamilyVo>();
        List<FamilyDto> familyDtos = result.getFamilyDtos();
        for (FamilyDto familyDto : familyDtos) {
            familyVos.add(new FamilyVo(familyDto));
        }
        setFamilyVos(familyVos);
    }

    // 将从数据库查询出的学校信息转为vo
    private void setEducationVo(EmployeeEntryDto result) {
        List<EducationVo> educationVos = new ArrayList<EducationVo>();
        List<EducationDto> educationDtos = result.getEducationDtos();
        for (EducationDto educationDto : educationDtos) {
            educationVos.add(new EducationVo(educationDto));
        }
        setEducationVos(educationVos);
    }

    // 将从数据库查询出的工作信息转为vo
    private void setWorkExperienceVo(EmployeeEntryDto result) {
        List<WorkExperienceVo> workVos = new ArrayList<WorkExperienceVo>();
        List<WorkExperienceDto> workDtos = result.getWorkExperienceDtos();
        for (WorkExperienceDto workDto : workDtos) {
            workVos.add(new WorkExperienceVo(workDto));
        }
        setWorkExperienceVos(workVos);
    }

    // 将从数据库查询出的培训信息转为vo
    private void setTrainedExperienceVo(EmployeeEntryDto result) {
        List<TrainedExperienceVo> trainVos = new ArrayList<TrainedExperienceVo>();
        List<TrainedExperienceDto> trainDtos = result.getTrainedExperienceDtos();
        for (TrainedExperienceDto trainDto : trainDtos) {
            trainVos.add(new TrainedExperienceVo(trainDto));
        }
        setTrainedExperienceVos(trainVos);
    }

    public EmployeeEntryVo(EmployeeEntryDto dto, Map<String, String> orgMap, Long parentId, Map<String, String> addrMap,
            List<CommentResultDto> commentResultDtos, List<EmployeeLogDto> logDtos) {
        BeanUtils.copyProperties(dto, this);
        setEmployeeVo(new EmployeeVo(dto.getEmployeeDto(), orgMap, parentId));

        setDetailInfoVo(new DetailInfoVo(dto.getEmployeeDetailInfo(), 1));
        List<FamilyVo> familyVos = new ArrayList<FamilyVo>();
        for (int i = 0; i < familyDtos.size(); i++) {
            familyVos.add(new FamilyVo(familyDtos.get(i), 1));
        }
        if (familyVos.size() > 0) {
            setFamilyVos(familyVos);
        }
        List<EducationVo> educationVos = new ArrayList<EducationVo>();
        for (int i = 0; i < educationDtos.size(); i++) {
            educationVos.add(new EducationVo(educationDtos.get(i), 1));
        }
        if (educationVos.size() > 0) {
            setEducationVos(educationVos);
        }
        List<WorkExperienceVo> workExperienceVos = new ArrayList<WorkExperienceVo>();
        for (int i = 0; i < workExperienceDtos.size(); i++) {
            workExperienceVos.add(new WorkExperienceVo(workExperienceDtos.get(i), 1));
        }
        if (workExperienceVos.size() > 0) {
            setWorkExperienceVos(workExperienceVos);
        }
        List<TrainedExperienceVo> trainedExperienceVos = new ArrayList<TrainedExperienceVo>();
        for (int i = 0; i < trainedExperienceDtos.size(); i++) {
            trainedExperienceVos.add(new TrainedExperienceVo(trainedExperienceDtos.get(i), 1));
        }
        if (trainedExperienceVos.size() > 0) {
            setTrainedExperienceVos(trainedExperienceVos);
        }
        setSocialVo(new SocialVo(getSocialDto(), 1));
        setProvince((Assert.checkParam(dto.getEmployeeDetailInfo().getBankProvinceCode()))
                ? addrMap.get(dto.getEmployeeDetailInfo().getBankProvinceCode()) : WMSConstants.NULL);
        setBankCity((Assert.checkParam(dto.getEmployeeDetailInfo().getBankCityCode()))
                ? addrMap.get(dto.getEmployeeDetailInfo().getBankCityCode()) : WMSConstants.NULL);
        String inProvCode = dto.getSocialDto().getInsuredProvinceCode();
        String inCityCode = dto.getSocialDto().getInsuredCityCode();
//        String insured = (Assert.checkParam(inProvCode) && Assert.checkParam(inCityCode))
//                ? addrMap.get(inProvCode) + " " + addrMap.get(inCityCode) : WMSConstants.NULL;
        setInsured(AreaFullNameUtil.getValue(inProvCode)+AreaFullNameUtil.getValue(inCityCode));
        List<CommentResultVo> commentResultVos = new ArrayList<CommentResultVo>();
        for (int i = 0; i < commentResultDtos.size(); i++) {
            commentResultVos.add(new CommentResultVo(commentResultDtos.get(i)));
        }
        if (commentResultVos.size() > 0) {
            setCommentResultVos(commentResultVos);
        }
        setLogDtos(logDtos);
    }

    public void put(EmployeeEntryVo base) {
        if (Assert.checkParam(base.getStep())) {
            switch (base.getStep()) {
                case 1:
                    // 个人详情
                    setEmployeeDetail(base);
                    // 个人基本信息
                    EmployeeDto dto = new EmployeeDto();
                    BeanUtils.copyProperties(base.getEmployeeVo(), dto);
                    setEmployeeDto(dto);
                    // 个人学习经历
                    setEducationDto(base);
                    // 个人家庭情况
                    setFamilyDto(base);
                    // 个人工作经历
                    setWorkExperienceDto(base);
                    // 个人培训经历
                    setTrainedExperienceDto(base);
                    break;

                case 2:
                    setSocialDtos(base);
                    break;
            }
        }
    }

    private void setSocialDtos(EmployeeEntryVo base) {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployeeId(base.getEmployeeId());
        setEmployeeDto(dto);
        SocialDto socialDto = new SocialDto();
        BeanUtils.copyProperties(base.getSocialVo(), socialDto);
        setSocialDto(socialDto);
    }

    // 个人详情dto
    private void setEmployeeDetail(EmployeeEntryVo base) {
        EmployeeDetailInfo detailInfo = new EmployeeDetailInfo();
        BeanUtils.copyProperties(base.getDetailInfoVo(), detailInfo);
        setEmployeeDetailInfo(detailInfo);
    }

    // 个人学习经历
    private void setEducationDto(EmployeeEntryVo base) {
        List<EducationDto> eduDtos = new ArrayList<EducationDto>();
        List<EducationVo> eduVos = base.getEducationVos();
        for (EducationVo eduVo : eduVos) {
            EducationDto eduDto = new EducationDto();
            BeanUtils.copyProperties(eduVo, eduDto);
            eduDtos.add(eduDto);
        }
        setEducationDtos(eduDtos);
    }

    // 个人家庭情况
    private void setFamilyDto(EmployeeEntryVo base) {
        List<FamilyDto> famDtos = new ArrayList<FamilyDto>();
        List<FamilyVo> famVos = base.getFamilyVos();
        for (FamilyVo famVo : famVos) {
            FamilyDto famDto = new FamilyDto();
            BeanUtils.copyProperties(famVo, famDto);
            famDtos.add(famDto);
        }
        setFamilyDtos(famDtos);
    }

    // 个人工作经历
    private void setWorkExperienceDto(EmployeeEntryVo base) {
        List<WorkExperienceDto> workDtos = new ArrayList<WorkExperienceDto>();
        List<WorkExperienceVo> workVos = base.getWorkExperienceVos();
        for (WorkExperienceVo workVo : workVos) {
            WorkExperienceDto workDto = new WorkExperienceDto();
            BeanUtils.copyProperties(workVo, workDto);
            workDtos.add(workDto);
        }
        setWorkExperienceDtos(workDtos);
    }

    // 个人培训经历
    private void setTrainedExperienceDto(EmployeeEntryVo base) {
        List<TrainedExperienceDto> trainDtos = new ArrayList<TrainedExperienceDto>();
        List<TrainedExperienceVo> trainVos = base.getTrainedExperienceVos();
        for (TrainedExperienceVo trainVo : trainVos) {
            TrainedExperienceDto trainDto = new TrainedExperienceDto();
            BeanUtils.copyProperties(trainVo, trainDto);
            trainDtos.add(trainDto);
        }
        setTrainedExperienceDtos(trainDtos);
    }

    public EmployeeEntryVo() {
    }

    public List<EmployeeLogDto> getLogDtos() {
        return logDtos;
    }

    public void setLogDtos(List<EmployeeLogDto> logDtos) {
        this.logDtos = logDtos;
    }

    public Long getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Long deleteId) {
        this.deleteId = deleteId;
    }

    public Integer getInfoType() {
        return infoType;
    }

    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public EmployeeDetailInfo getEmployeeDetailInfo() {
        return employeeDetailInfo;
    }

    public void setEmployeeDetailInfo(EmployeeDetailInfo employeeDetailInfo) {
        this.employeeDetailInfo = employeeDetailInfo;
    }

    public EmployeeSalaryDto getEmployeeSalaryDto() {
        return employeeSalaryDto;
    }

    public void setEmployeeSalaryDto(EmployeeSalaryDto employeeSalaryDto) {
        this.employeeSalaryDto = employeeSalaryDto;
    }

    public EmployeeSalaryVo getEmployeeSalaryVo() {
        return employeeSalaryVo;
    }

    public void setEmployeeSalaryVo(EmployeeSalaryVo employeeSalaryVo) {
        this.employeeSalaryVo = employeeSalaryVo;
    }

    public List<EducationDto> getEducationDtos() {
        return educationDtos;
    }

    public void setEducationDtos(List<EducationDto> educationDtos) {
        this.educationDtos = educationDtos;
    }

    public List<FamilyDto> getFamilyDtos() {
        return familyDtos;
    }

    public void setFamilyDtos(List<FamilyDto> familyDtos) {
        this.familyDtos = familyDtos;
    }

    public List<WorkExperienceDto> getWorkExperienceDtos() {
        return workExperienceDtos;
    }

    public void setWorkExperienceDtos(List<WorkExperienceDto> workExperienceDtos) {
        this.workExperienceDtos = workExperienceDtos;
    }

    public List<TrainedExperienceDto> getTrainedExperienceDtos() {
        return trainedExperienceDtos;
    }

    public void setTrainedExperienceDtos(List<TrainedExperienceDto> trainedExperienceDtos) {
        this.trainedExperienceDtos = trainedExperienceDtos;
    }

    public List<EmployeeVideoDto> getEmployeeVideoDtos() {
        return employeeVideoDtos;
    }

    public void setEmployeeVideoDtos(List<EmployeeVideoDto> employeeVideoDtos) {
        this.employeeVideoDtos = employeeVideoDtos;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getApproveType() {
        return approveType;
    }

    public void setApproveType(Integer approveType) {
        this.approveType = approveType;
    }

    public DetailInfoVo getDetailInfoVo() {
        return detailInfoVo;
    }

    public void setDetailInfoVo(DetailInfoVo detailInfoVo) {
        this.detailInfoVo = detailInfoVo;
    }

    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getApproveMsg() {
        return approveMsg;
    }

    public void setApproveMsg(String approveMsg) {
        this.approveMsg = approveMsg;
    }

    public Integer getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(Integer formStatus) {
        this.formStatus = formStatus;
    }

    public String getFormStatusView() {
        return formStatusView;
    }

    public void setFormStatusView(String formStatusView) {
        this.formStatusView = formStatusView;
    }

    public EmployeeVo getEmployeeVo() {
        return employeeVo;
    }

    public void setEmployeeVo(EmployeeVo employeeVo) {
        this.employeeVo = employeeVo;
    }

    public List<EducationVo> getEducationVos() {
        return educationVos;
    }

    public void setEducationVos(List<EducationVo> educationVos) {
        this.educationVos = educationVos;
    }

    public List<FamilyVo> getFamilyVos() {
        return familyVos;
    }

    public void setFamilyVos(List<FamilyVo> familyVos) {
        this.familyVos = familyVos;
    }

    public List<WorkExperienceVo> getWorkExperienceVos() {
        return workExperienceVos;
    }

    public void setWorkExperienceVos(List<WorkExperienceVo> workExperienceVos) {
        this.workExperienceVos = workExperienceVos;
    }

    public List<TrainedExperienceVo> getTrainedExperienceVos() {
        return trainedExperienceVos;
    }

    public void setTrainedExperienceVos(List<TrainedExperienceVo> trainedExperienceVos) {
        this.trainedExperienceVos = trainedExperienceVos;
    }

    public List<EmployeeVideoVo> getEmployeeVideoVos() {
        return employeeVideoVos;
    }

    public void setEmployeeVideoVos(List<EmployeeVideoVo> employeeVideoVos) {
        this.employeeVideoVos = employeeVideoVos;
    }

    public SocialVo getSocialVo() {
        return socialVo;
    }

    public void setSocialVo(SocialVo socialVo) {
        this.socialVo = socialVo;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public SocialDto getSocialDto() {
        return socialDto;
    }

    public void setSocialDto(SocialDto socialDto) {
        this.socialDto = socialDto;
    }

    public List<CommentResultDto> getCommentResultDtos() {
        return commentResultDtos;
    }

    public void setCommentResultDtos(List<CommentResultDto> commentResultDtos) {
        this.commentResultDtos = commentResultDtos;
    }

    public List<CommentResultVo> getCommentResultVos() {
        return commentResultVos;
    }

    public void setCommentResultVos(List<CommentResultVo> commentResultVos) {
        this.commentResultVos = commentResultVos;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getInsured() {
        return insured;
    }

    public void setInsured(String insured) {
        this.insured = insured;
    }

}
