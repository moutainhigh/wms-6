/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileVo.java
 * Author:   黄健
 * Date:     2015年7月19日 下午4:20:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.web.vo;

import java.io.File;
import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.FileResultDto;
import com.dx.wms.enums.VideoTypeName;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FileVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    /** 文件编号 */
    private Long fileId;

    /** 文件全名 */
    private String fileName;

    /** 文件存储地址 */
    private String fileUrl;

    /** 文件存储名 */
    private String fileSaveName;

    /** 文件原名 */
    private String fileSourceName;

    /** 文件类型 */
    private String fileType;

    /** 文件存储路径 */
    private String filePath;

    /** 文件状态 */
    private String fileStatus;

    /** 同一目录文件夹文件数 */
    private String fileNum;

    public FileVo(FileResultDto file, String address) {
        BeanUtils.copyProperties(file, this);
        if (StringUtils.isNotBlank(file.getFileSaveDir())) {
            setFileUrl(address
                    + (StringUtils.isNotBlank(file.getFileSaveDir()) && file.getFileSaveDir().endsWith(File.separator)
                            ? file.getFileSaveDir() : (file.getFileSaveDir() + File.separator))
                    + file.getFileSaveName() + CMSConstants.SWF_TYPE);
        }
        if (StringUtils.isNotBlank(file.getFileSourceName())) {
            setFileName(new StringBuffer().append(VideoTypeName.getInfo((int) file.getFileSourceName().charAt(0)))
                    .append("  ").append(file.getFileSourceName()).append(CMSConstants.POINT)
                    .append(file.getFileTypeKey()).toString());

        } else {
            setFileName(new StringBuffer().append(file.getFileSourceName()).append(CMSConstants.POINT)
                    .append(file.getFileTypeKey()).toString());
        }
        setFileType(file.getFileTypeKey());
        if (StringUtils.isNotBlank(file.getFileSaveDir()) && file.getFileSaveDir().endsWith(File.separator)) {
            setFilePath(file.getFileSaveDir().substring(0, file.getFileSaveDir().length() - 1));
        } else {
            setFilePath(file.getFileSaveDir());
        }
        setFileStatus(file.getDataStatus());
    }

    /**
     * @return 文件状态 A：生效 D：已删除
     */
    public String getFileStatus() {
        return fileStatus;
    }

    /**
     * @param fileStatus 文件状态 A：生效 D：已删除
     */
    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    /**
     * @return 文件存储名
     */
    public String getFileSaveName() {
        return fileSaveName;
    }

    /**
     * @param fileSaveName 文件存储名
     */
    public void setFileSaveName(String fileSaveName) {
        this.fileSaveName = fileSaveName;
    }

    /**
     * @return 文件原名
     */
    public String getFileSourceName() {
        return fileSourceName;
    }

    /**
     * @param fileSourceName 文件原名
     */
    public void setFileSourceName(String fileSourceName) {
        this.fileSourceName = fileSourceName;
    }

    /**
     * @return 文件类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType 文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * @return 文件存储路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath 文件存储路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return 同一目录文件夹文件数
     */
    public String getFileNum() {
        return fileNum;
    }

    /**
     * @param fileNum 同一目录文件夹文件数
     */
    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }

    /**
     * @return 文件全名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName 文件全名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return 文件存储地址
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * @param fileUrl 文件存储地址
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * @return 文件编号
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * @param fileId 文件编号
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

}
