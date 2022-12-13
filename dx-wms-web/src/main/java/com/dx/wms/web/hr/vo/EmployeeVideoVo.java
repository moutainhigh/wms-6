/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: EmployeeVideoVo.java
 * Author:   yangbao
 * Date:     2016年1月15日 下午2:51:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EmployeeVideoVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    
    private Long employeeId;
    
    private Long employeeVideoId;
    
    /** 
     *  源文件名
     */
    private String sourceFileName;

    /** 
     *  文件类型
     */
    private String fileType;

    /** 
     *  存储文件名
     */
    private String saveFileName;

    /** 
     *  文件存放路径
     */
    private String filePath;
    
    public EmployeeVideoVo(){
        
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getSaveFileName() {
        return saveFileName;
    }

    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the employeeId
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the employeeVideoId
     */
    public Long getEmployeeVideoId() {
        return employeeVideoId;
    }

    /**
     * @param employeeVideoId the employeeVideoId to set
     */
    public void setEmployeeVideoId(Long employeeVideoId) {
        this.employeeVideoId = employeeVideoId;
    }

}
