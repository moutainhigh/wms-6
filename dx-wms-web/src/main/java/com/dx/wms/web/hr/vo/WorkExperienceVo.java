/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: WorkExperienceVo.java
 * Author:   yangbao
 * Date:     2016年1月15日 下午2:46:59
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.hr.service.dto.WorkExperienceDto;
import com.dx.wms.constant.WMSConstants;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WorkExperienceVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    
    /**
     *  employeeWorkExperienceId 工作经历ID
     */
    private Long employeeWorkExperienceId;
    
    /** 
     * 单位名称
     */
    private String companyName;
    
    /** 
     * 工作时间
     */
    private String workTime;
    
    /** 
     * 入职日期
     */
    private Date entryDate;
    
    /** 
     * 入职日期
     */
    private String entryDateView;
    
    /** 
     * 离职日期
     */
    private Date quitDate;
    
    /** 
     * 离职日期
     */
    private String quitDateView;
    
    /** 
     *  部门
     */
    private String department;
    
    /** 
     * 职务
     */
    private String duties;
    
    public WorkExperienceVo(){
        
    }
    
    public WorkExperienceVo(WorkExperienceDto workExperienceDto,Integer type){
    	BeanUtils.copyProperties(workExperienceDto, this);
    	String time = MessageFormat.format("{0} 至 {1}", DateUtils.formatForDay(getEntryDate(), ""),
                DateUtils.formatForDay(getQuitDate(), ""));
        setWorkTime(Assert.equals(time.trim(), "至") ? WMSConstants.NULL : time);
    }
    
    public WorkExperienceVo(WorkExperienceDto base){
        BeanUtils.copyProperties(base, this);
        setEntryDateView(DateUtils.formatForDay(base.getEntryDate(),""));
        setQuitDateView(DateUtils.formatForDay(base.getQuitDate(),""));
        String time = MessageFormat.format("{0} 至 {1}", DateUtils.formatForDay(getEntryDate(), ""),
                DateUtils.formatForDay(getQuitDate(), ""));
        setWorkTime(Assert.equals(time.trim(), "至") ? WMSConstants.NULL : time);
    }

    public Long getEmployeeWorkExperienceId() {
        return employeeWorkExperienceId;
    }

    public void setEmployeeWorkExperienceId(Long employeeWorkExperienceId) {
        this.employeeWorkExperienceId = employeeWorkExperienceId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    public String getQuitDateView() {
        return quitDateView;
    }

    public void setQuitDateView(String quitDateView) {
        this.quitDateView = quitDateView;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
    
    

}
