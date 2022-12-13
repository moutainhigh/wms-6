package com.dx.wms.web.hr.vo;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.hr.enums.JobCategory;
import com.dx.hr.enums.SexType;
import com.dx.hr.service.dto.EmployeeListResultDto;
import com.dx.wms.constant.WMSConstants;

/**
 * 
 * 〈一句话功能简述〉人事查询结果vo 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ResultHRVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 790070484044532451L;

    /**
     * employeeId 员工ID
     */
    private Long employeeId;

    /**
     * employeeNo 员工编号
     */
    private String employeeNo;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 性别
     */
    private String sexView;

    /**
     * 部门id
     */
    private Long departmentId;

    /**
     * 部门
     */
    private String departmentView;

    /**
     * 岗位id
     */
    private Long positionId;

    /**
     * 岗位
     */
    private String positionView;

    /**
     * 手机
     */
    private String mobilePhone;

    /**
     * 入职日期
     */
    private String entryDate;

    /**
     * 状态
     */
    private String dataStatus;

    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 计划入职日期
     */
    private String plannedEntryDate;


    /**
     * 工作性质: 1:全职; 2:兼职; 3:实习; 4:返聘
     */
    private Integer jobCategory;

    /**
     * 工作性质: 1:全职; 2:兼职; 3:实习; 4:返聘
     */
    private String jobCategoryView;
    
    /**
     * 流程Id
     */
    private String taskId;
    
    /**
     * 流程实例Id
     */
    private String procInsId;
    
    /**
     * 目标组织
     */
    private String targetOrg;
    
    /**
     * 目标岗位
     */
    private String targetPosition;
    
    /** 
     * isTransaction 是否异动申请中：1：是；2：否 
     * 
     * */
    private Integer isTransaction;

    public ResultHRVo() {

    }
    
    public ResultHRVo(EmployeeListResultDto dto, Map<String, String> positionMap, Map<String, String> orgMap,
            Long parentId) {
        BeanUtils.copyProperties(dto, this);
        setSexView(SexType.getInfo(dto.getSex()));
        setPositionView(positionMap.get(dto.getPositionId().toString())+(dto.getLevelName()==null?"":dto.getLevelName()));
        //判断是否有父组织，如果没有只显示子组织
        String departmentView = Assert.checkParam(parentId) && Assert.checkParam(orgMap.get(parentId.toString())) ? MessageFormat
                .format("{0} {1}", orgMap.get(parentId.toString()), orgMap.get(dto.getOrgId().toString())) : Assert
                .checkParam(orgMap.get(dto.getOrgId().toString())) ? orgMap.get(dto.getOrgId().toString())
                : null;
        setDepartmentView(departmentView);
        setMobilePhone(Assert.checkParam(getMobilePhone()) ? getMobilePhone() : WMSConstants.NULL);
        setJobCategoryView(JobCategory.getInfo(getJobCategory()));
    }

    public Integer getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobCategoryView() {
        return jobCategoryView;
    }

    public void setJobCategoryView(String jobCategoryView) {
        this.jobCategoryView = jobCategoryView;
    }

    public String getPlannedEntryDate() {
        return plannedEntryDate;
    }

    public void setPlannedEntryDate(String plannedEntryDate) {
        this.plannedEntryDate = plannedEntryDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexView() {
        return sexView;
    }

    public void setSexView(String sexView) {
        this.sexView = sexView;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentView() {
        return departmentView;
    }

    public void setDepartmentView(String departmentView) {
        this.departmentView = departmentView;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionView() {
        return positionView;
    }

    public void setPositionView(String positionView) {
        this.positionView = positionView;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public String getTargetOrg() {
		return targetOrg;
	}


	public void setTargetOrg(String targetOrg) {
		this.targetOrg = targetOrg;
	}


	public String getTargetPosition() {
		return targetPosition;
	}


	public void setTargetPosition(String targetPosition) {
		this.targetPosition = targetPosition;
	}


	public String getProcInsId() {
		return procInsId;
	}


	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}

	public Integer getIsTransaction() {
		return isTransaction;
	}

	public void setIsTransaction(Integer isTransaction) {
		this.isTransaction = isTransaction;
	}
    
    

}
