/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FolderVo.java
 * Author:   黄健
 * Date:     2015年7月19日 下午3:01:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.web.vo;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FolderVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    
    /** 文件名 */
    private String folderName;
    
    /** 文件编码 */
    private String folderCode;
    
    /** 文件夹下文件数量 */
    private String sunFileNumber;
    
    /** 文件夹下文件是否可以操作标志 */
    private String isEdit;
    
    /** 文件目录编号 */
    private String fileDirId;

    /**
     * @return 文件名
     */
    public String getFolderName() {
        return folderName;
    }

    /**
     * @param folderName 文件名
     */
    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    /**
     * @return 文件编码
     */
    public String getFolderCode() {
        return folderCode;
    }

    /**
     * @param folderCode 文件编码
     */
    public void setFolderCode(String folderCode) {
        this.folderCode = folderCode;
    }

    /**
     * @return 文件夹下文件数量
     */
    public String getSunFileNumber() {
        return sunFileNumber;
    }

    /**
     * @param sunFileNumber 文件夹下文件数量
     */
    public void setSunFileNumber(String sunFileNumber) {
        this.sunFileNumber = sunFileNumber;
    }

    /**
     * @return 文件夹下文件是否可以操作标志
     */
    public String getIsEdit() {
        return isEdit;
    }

    /**
     * @param isEdit 文件夹下文件是否可以操作标志
     */
    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    /**
     * @return 文件目录编号
     */
    public String getFileDirId() {
        return fileDirId;
    }

    /**
     * @param fileDirId 文件目录编号
     */
    public void setFileDirId(String fileDirId) {
        this.fileDirId = fileDirId;
    }
    

}
