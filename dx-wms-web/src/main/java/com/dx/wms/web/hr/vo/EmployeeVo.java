/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: EmployeeVo.java
 * Author:   yangbao
 * Date:     2016年1月15日 下午2:20:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.hr.enums.CertType;
import com.dx.hr.enums.JobCategory;
import com.dx.hr.enums.SexType;
import com.dx.hr.service.dto.EmployeeDto;
import com.dx.wms.constant.WMSConstants;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EmployeeVo implements Serializable {

	/**
     */
	private static final long serialVersionUID = 1L;

	/**
	 * 操作人Id
	 */
	private Long userId;

	/**
	 * 员工编号
	 */
	private String employeeNo;

	/**
	 * 员工Id
	 */
	private Long employeeId;

	/**
	 * 组织Id
	 */
	private Long orgId;

	/**
	 * 组织Id
	 */
	private String orgName;

	/**
	 * 岗位Id
	 */
	private Long positionId;

	/**
	 * 岗位名称
	 */
	private String positionName;

	/**
	 * 级别Id
	 */
	private String levelId;

	/**
	 * 岗位级别Id
	 */
	private Long positionLevelId;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * mobilePhone 手机号码
	 */
	private String mobilePhone;

	/**
	 * 性别
	 */
	private Integer sex;

	private String sexView;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 用户名
	 */
	private String userNameView;

	/**
	 * 工作性质: 全职：1；兼职：2；实习：3
	 */
	private Integer jobCategory;

	private String jobCategoryView;

	/**
	 * 入职日期
	 */
	private Date entryDate;

	private String entryDateView;

	/**
	 * 计划入职日期
	 */
	private Date plannedEntryDate;

	private String plannedEntryDateView;

	/**
	 * 证件类型
	 */
	private Integer certType;

	private String certTypeView;

	/**
	 * 证件号码
	 */
	private String certNo;

	/**
	 * 试用期基本工资
	 */
	private BigDecimal proBasicSalary;

	private String proBasicSalaryView;

	/**
	 * 试用期绩效工资
	 */
	private BigDecimal proPerformanceSalary;

	private String proPerformanceSalaryView;

	/**
	 * 转正后基本工资
	 */
	private BigDecimal regularBasicSalary;

	private String regularBasicSalaryView;

	/**
	 * 转正后绩效工资
	 */
	private BigDecimal regularPerformanceSalary;

	private String regularPerformanceSalaryView;

	public EmployeeVo(EmployeeDto base, String orgName) {
		BeanUtils.copyProperties(base, this);
		setEntryDateView(DateUtils.formatForDay(getEntryDate(), ""));
		//setPlannedEntryDateView(DateUtils.formatForDay(getPlannedEntryDate(), ""));
		setSexView(SexType.getInfo(base.getSex()));
		setOrgName(orgName);
		setCertTypeView(Assert.checkParam(base.getCertType()) ? CertType
				.getInfo(base.getCertType()) : WMSConstants.NULL);
		setJobCategoryView(Assert.checkParam(base.getJobCategory()) ? JobCategory
				.getInfo(base.getJobCategory()) : WMSConstants.NULL);
		setEmployeeNo(Assert.checkParam(base.getEmployeeNo()) ? base
				.getEmployeeNo() : WMSConstants.NULL);
		setUserNameView(Assert.checkParam(base.getUserName()) ? base
				.getUserName() : WMSConstants.NULL);
	}

	public EmployeeVo(EmployeeDto base, Map<String, String> orgMap,
			Long parentId) {
		BeanUtils.copyProperties(base, this);
		setUserName(Assert.checkParam(getUserName()) ? getUserName()
				: WMSConstants.NULL);
		setEmployeeNo(Assert.checkParam(getEmployeeNo()) ? getEmployeeNo()
				: WMSConstants.NULL);
		setMobilePhone(Assert.checkParam(getMobilePhone()) ? getMobilePhone()
				: WMSConstants.NULL);
		setSexView(Assert.checkParam(base.getSex()) ? SexType.getInfo(base
				.getSex()) : WMSConstants.NULL);
		String departmentView = Assert.checkParam(parentId)
				&& Assert.checkParam(orgMap.get(parentId.toString())) ? MessageFormat
				.format("{0} {1}", orgMap.get(parentId.toString()),
						orgMap.get(base.getOrgId().toString())) : Assert
				.checkParam(orgMap.get(base.getOrgId().toString())) ? orgMap
				.get(base.getOrgId().toString()) : WMSConstants.NULL;
		setOrgName(departmentView);
		setCertTypeView(Assert.checkParam(base.getCertType()) ? CertType
				.getInfo(base.getCertType()) : WMSConstants.NULL);
		setJobCategoryView(Assert.checkParam(base.getJobCategory()) ? JobCategory
				.getInfo(base.getJobCategory()) : WMSConstants.NULL);
		setEntryDateView(DateUtils.formatForDay(base.getEntryDate(),
				WMSConstants.NULL));
	}

	public EmployeeVo() {

	}

	public String getUserNameView() {
		return userNameView;
	}

	public void setUserNameView(String userNameView) {
		this.userNameView = userNameView;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public Long getPositionLevelId() {
		return positionLevelId;
	}

	public void setPositionLevelId(Long positionLevelId) {
		this.positionLevelId = positionLevelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSexView() {
		return sexView;
	}

	public void setSexView(String sexView) {
		this.sexView = sexView;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryDateView() {
		return entryDateView;
	}

	public void setEntryDateView(String entryDateView) {
		this.entryDateView = entryDateView;
	}

	public Date getPlannedEntryDate() {
		return plannedEntryDate;
	}

	public void setPlannedEntryDate(Date plannedEntryDate) {
		this.plannedEntryDate = plannedEntryDate;
	}

	public String getPlannedEntryDateView() {
		return plannedEntryDateView;
	}

	public void setPlannedEntryDateView(String plannedEntryDateView) {
		this.plannedEntryDateView = plannedEntryDateView;
	}

	public Integer getCertType() {
		return certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}

	public String getCertTypeView() {
		return certTypeView;
	}

	public void setCertTypeView(String certTypeView) {
		this.certTypeView = certTypeView;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public BigDecimal getProBasicSalary() {
		return proBasicSalary;
	}

	public void setProBasicSalary(BigDecimal proBasicSalary) {
		this.proBasicSalary = proBasicSalary;
	}

	public String getProBasicSalaryView() {
		return proBasicSalaryView;
	}

	public void setProBasicSalaryView(String proBasicSalaryView) {
		this.proBasicSalaryView = proBasicSalaryView;
	}

	public BigDecimal getProPerformanceSalary() {
		return proPerformanceSalary;
	}

	public void setProPerformanceSalary(BigDecimal proPerformanceSalary) {
		this.proPerformanceSalary = proPerformanceSalary;
	}

	public String getProPerformanceSalaryView() {
		return proPerformanceSalaryView;
	}

	public void setProPerformanceSalaryView(String proPerformanceSalaryView) {
		this.proPerformanceSalaryView = proPerformanceSalaryView;
	}

	public BigDecimal getRegularBasicSalary() {
		return regularBasicSalary;
	}

	public void setRegularBasicSalary(BigDecimal regularBasicSalary) {
		this.regularBasicSalary = regularBasicSalary;
	}

	public String getRegularBasicSalaryView() {
		return regularBasicSalaryView;
	}

	public void setRegularBasicSalaryView(String regularBasicSalaryView) {
		this.regularBasicSalaryView = regularBasicSalaryView;
	}

	public BigDecimal getRegularPerformanceSalary() {
		return regularPerformanceSalary;
	}

	public void setRegularPerformanceSalary(BigDecimal regularPerformanceSalary) {
		this.regularPerformanceSalary = regularPerformanceSalary;
	}

	public String getRegularPerformanceSalaryView() {
		return regularPerformanceSalaryView;
	}

	public void setRegularPerformanceSalaryView(
			String regularPerformanceSalaryView) {
		this.regularPerformanceSalaryView = regularPerformanceSalaryView;
	}

}
