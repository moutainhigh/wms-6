package com.dx.wms.web.hr.vo;

import java.io.Serializable;
/**
 * 
 * 〈一句话功能简述〉人事查询条件vo
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HRParamVo implements Serializable{

    /**
     */
    private static final long serialVersionUID = -6479672447079169650L;

    /**
     * 操作用户
     */
    private Long userId;
    
    /**
     * 岗位
     */
    private Long positionId;
    
    /**
     * 组织Id
     */
    private Long orgId;
    
    /**
     * 员工姓名
     */
    private String name;
    
    /**
     * 手机
     */
    private String mobilePhone;
    
    /**
     * "E"表示在职状态，"Q"表示离职状态
     */
    private String formStatus;
    
    /**
     * 员工编号
     */
    private String employeeNo;
    
    /**
     *  工作性质: 1:全职; 2:兼职; 3:实习; 4:返聘
     */
    private Integer jobCategory;
    
    /**
     * 证件号码
     */
    private String certNo;
    
    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public Integer getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(String formStatus) {
        this.formStatus = formStatus;
    }

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
    
    
}
