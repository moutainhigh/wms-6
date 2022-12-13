/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: TrainedExperienceVo.java
 * Author:   yangbao
 * Date:     2016年1月15日 下午2:49:09
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
import com.dx.hr.service.dto.TrainedExperienceDto;
import com.dx.wms.constant.WMSConstants;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TrainedExperienceVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    
    /** 
     * trainedId 培训经历ID
     */
    private Long trainedId;
    
    /** 
     *  培训机构
     */
    private String trainingOrg;
    
    private String trainingDate;

    /** 
     *  开始日期
     */
    private Date startDate;
    
    /** 
     *  开始日期
     */
    private String startDateView;

    /** 
     *  结束日期
     */
    private Date endDate;
    
    /** 
     *  结束日期
     */
    private String endDateView;

    /** 
     *  培训项目
     */
    private String trainingProject;

    /** 
     *  获得证书
     */
    private String certificate;
    
    public TrainedExperienceVo(){
        
    }
    
    public TrainedExperienceVo(TrainedExperienceDto trainedExperienceDto,Integer type){
    	BeanUtils.copyProperties(trainedExperienceDto, this);
    	String time = MessageFormat.format("{0} 至 {1}", DateUtils.formatForDay(getStartDate(), ""),
                DateUtils.formatForDay(getEndDate(), ""));
    	setTrainingDate(Assert.equals(time.trim(), "至") ? WMSConstants.NULL : time);
    } 
    
    public TrainedExperienceVo(TrainedExperienceDto base){
        BeanUtils.copyProperties(base, this);
        setStartDateView(DateUtils.formatForDay(base.getStartDate(),""));
        setEndDateView(DateUtils.formatForDay(base.getEndDate(),""));
        String time = MessageFormat.format("{0} 至 {1}", DateUtils.formatForDay(getStartDate(), ""),
                DateUtils.formatForDay(getEndDate(), ""));
        setTrainingDate(Assert.equals(time.trim(), "至") ? WMSConstants.NULL : time);
    }

    public Long getTrainedId() {
        return trainedId;
    }

    public void setTrainedId(Long trainedId) {
        this.trainedId = trainedId;
    }

    public String getTrainingOrg() {
        return trainingOrg;
    }

    public void setTrainingOrg(String trainingOrg) {
        this.trainingOrg = trainingOrg;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartDateView() {
        return startDateView;
    }

    public void setStartDateView(String startDateView) {
        this.startDateView = startDateView;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEndDateView() {
        return endDateView;
    }

    public void setEndDateView(String endDateView) {
        this.endDateView = endDateView;
    }

    public String getTrainingProject() {
        return trainingProject;
    }

    public void setTrainingProject(String trainingProject) {
        this.trainingProject = trainingProject;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

	public String getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
	}

    
}
