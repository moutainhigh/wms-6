/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: EducationVo.java
 * Author:   yangbao
 * Date:     2016年1月15日 下午2:39:37
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
import com.dx.hr.enums.GraduateType;
import com.dx.hr.service.dto.EducationDto;
import com.dx.wms.constant.WMSConstants;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EducationVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    
    /**
     *  employeeEducationId 教育背景ID
     */
    private Long employeeEducationId;
    
    /** 
     * 学校 
     */
    private String school;
    
    private String learnView;

    /** 
     * 学习经历起
     */
    private Date startdate;
    
    /** 
     * 学习经历起
     */
    private String startdateView;

    /** 
     * 学习经历止
     */
    private Date enddate;
    
    /** 
     * 学习经历止
     */
    private String enddateView;

    /** 
     *  是否毕业，1：是；2：否
     */
    private Integer isGraduate;
    
    /** 
     *  是否毕业，1：是；2：否
     */
    private String isGraduateView;

    /** 
     * 专业
     */
    private String major;
    
    public EducationVo(){
        
    }
    
    public EducationVo(EducationDto educationDto,Integer type){
    	BeanUtils.copyProperties(educationDto, this);
    	String learn = MessageFormat.format("{0} 至 {1}", DateUtils.formatForDay(getStartdate(), ""),
                DateUtils.formatForDay(getEnddate(), ""));
        setLearnView(Assert.equals(learn.trim(), "至") ? WMSConstants.NULL : learn);
        setIsGraduateView(GraduateType.getInfo(isGraduate));
    }
    
    public EducationVo(EducationDto base){
        BeanUtils.copyProperties(base, this);
        setStartdateView(DateUtils.formatForDay(base.getStartdate(),""));
        setEnddateView(DateUtils.formatForDay(base.getEnddate(),""));
        String learn = MessageFormat.format("{0} 至 {1}", DateUtils.formatForDay(getStartdate(), ""),
                DateUtils.formatForDay(getEnddate(), ""));
        setLearnView(Assert.equals(learn.trim(), "至") ? WMSConstants.NULL : learn);
        setIsGraduateView(Assert.checkParam(base.getIsGraduate())?GraduateType.getInfo(base.getIsGraduate()):WMSConstants.NULL);
    }

    public Long getEmployeeEducationId() {
        return employeeEducationId;
    }

    public void setEmployeeEducationId(Long employeeEducationId) {
        this.employeeEducationId = employeeEducationId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getStartdateView() {
        return startdateView;
    }

    public void setStartdateView(String startdateView) {
        this.startdateView = startdateView;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getEnddateView() {
        return enddateView;
    }

    public void setEnddateView(String enddateView) {
        this.enddateView = enddateView;
    }

    public Integer getIsGraduate() {
        return isGraduate;
    }

    public void setIsGraduate(Integer isGraduate) {
        this.isGraduate = isGraduate;
    }

    public String getIsGraduateView() {
        return isGraduateView;
    }

    public void setIsGraduateView(String isGraduateView) {
        this.isGraduateView = isGraduateView;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

	public String getLearnView() {
		return learnView;
	}

	public void setLearnView(String learnView) {
		this.learnView = learnView;
	}
    

}
