/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: TempalteData.java
 * Author:   LIUQIONG
 * Date:     2016年8月23日 下午12:30:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.reportTemplate;

import freemarker.template.Template;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author LIUQIONG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TempalteJudge {
    
    /**bizType 业务类型*/
    private Integer bizType;
    
    /**reportType 报表类型*/
    private Integer reportType;
    
    /**template 报表模板*/
    private Template template;
    
    /**templatePath 模板路径*/
    private String templatePath;

    /**
     * @return the template
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(Template template) {
        this.template = template;
    }

    /**
     * @return the bizType
     */
    public Integer getBizType() {
        return bizType;
    }

    /**
     * @param bizType the bizType to set
     */
    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * @return the reportType
     */
    public Integer getReportType() {
        return reportType;
    }

    /**
     * @param reportType the reportType to set
     */
    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
    
}
