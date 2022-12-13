/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ImgStoreDirectoryResultDto.java
 * Author:   黄健
 * Date:     2015年7月17日 下午2:43:01
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 内容管理 文件目录dto
 *
 * @author huangjian
 */
public class FolderResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = -8055432682662134086L;

    /**
     * 文件目录-编号
     */
    private Long fileDirId;

    /**
     * 文件目录-标示
     */
    private String fileDirKey;

    /**
     * 文件目录-名称
     */
    private String fileDirName;

    /**
     * 文件目录-级别
     */
    private Integer fileDirLevel;

    /**
     * 上级文件目录-编号
     */
    private Integer upFileDirId;

    /**
     * 文件目录-描述
     */
    private String fileDirDesc;

    /**
     * 目录资源-编号
     */
    private Long dirResId;

    /**
     * 目录资源-顺位
     */
    private Integer dirResIndex;

    /**
     * 目录资源-是否编辑
     */
    private Integer isEdit;

    /**
     * 目录资源-标示
     */
    private String dirResKey;

    /**
     * 资源-编号
     */
    private Long resId;

    /**
     * 资源-标示
     */
    private String resKey;

    /**
     * 资源-名称
     */
    private String resName;

    /**
     * 系统-编码
     */
    private String appCode;

    /**
     * 资源-描述
     */
    private String resDesc;

    /**
     * 某一目录下文件数量
     */
    private Integer fileNumber;

    /**
     * 某一目录下所有文件
     */
    private List<FileResultDto> fileResultDtoes;

    public FolderResultDto() {
        this.fileResultDtoes = new ArrayList<FileResultDto>();
    }

    /**
     * @return 某一目录下文件数量
     */
    public Integer getFileNumber() {
        return fileNumber;
    }

    /**
     * @param fileNumber 某一目录下文件数量
     */
    public void setFileNumber(Integer fileNumber) {
        this.fileNumber = fileNumber;
    }

    /**
     * @return 文件目录-编号
     */
    public Long getFileDirId() {
        return fileDirId;
    }

    /**
     * @param fileDirId 文件目录-编号
     */
    public void setFileDirId(Long fileDirId) {
        this.fileDirId = fileDirId;
    }

    /**
     * @return 文件目录-标示
     */
    public String getFileDirKey() {
        return fileDirKey;
    }

    /**
     * @param fileDirKey 文件目录-标示
     */
    public void setFileDirKey(String fileDirKey) {
        this.fileDirKey = fileDirKey;
    }

    /**
     * @return 文件目录-名称
     */
    public String getFileDirName() {
        return fileDirName;
    }

    /**
     * @param fileDirName 文件目录-名称
     */
    public void setFileDirName(String fileDirName) {
        this.fileDirName = fileDirName;
    }

    /**
     * @return 文件目录-级别
     */
    public Integer getFileDirLevel() {
        return fileDirLevel;
    }

    /**
     * @param fileDirLevel 文件目录-级别
     */
    public void setFileDirLevel(Integer fileDirLevel) {
        this.fileDirLevel = fileDirLevel;
    }

    /**
     * @return 上级文件目录-编号
     */
    public Integer getUpFileDirId() {
        return upFileDirId;
    }

    /**
     * @param upFileDirId 上级文件目录-编号
     */
    public void setUpFileDirId(Integer upFileDirId) {
        this.upFileDirId = upFileDirId;
    }

    /**
     * @return 文件目录-描述
     */
    public String getFileDirDesc() {
        return fileDirDesc;
    }

    /**
     * @param fileDirDesc 文件目录-描述
     */
    public void setFileDirDesc(String fileDirDesc) {
        this.fileDirDesc = fileDirDesc;
    }

    /**
     * @return 目录资源-编号
     */
    public Long getDirResId() {
        return dirResId;
    }

    /**
     * @param dirResId 目录资源-编号
     */
    public void setDirResId(Long dirResId) {
        this.dirResId = dirResId;
    }

    /**
     * @return 目录资源-顺位
     */
    public Integer getDirResIndex() {
        return dirResIndex;
    }

    /**
     * @param dirResIndex 目录资源-顺位
     */
    public void setDirResIndex(Integer dirResIndex) {
        this.dirResIndex = dirResIndex;
    }

    /**
     * @return 目录资源-是否编辑
     */
    public Integer getIsEdit() {
        return isEdit;
    }

    /**
     * @param isEdit 目录资源-是否编辑
     */
    public void setIsEdit(Integer isEdit) {
        this.isEdit = isEdit;
    }

    /**
     * @return 目录资源-标示
     */
    public String getDirResKey() {
        return dirResKey;
    }

    /**
     * @param dirResKey 目录资源-标示
     */
    public void setDirResKey(String dirResKey) {
        this.dirResKey = dirResKey;
    }

    /**
     * @return 资源-编号
     */
    public Long getResId() {
        return resId;
    }

    /**
     * @param resId 资源-编号
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * @return 资源-标示
     */
    public String getResKey() {
        return resKey;
    }

    /**
     * @param resKey 资源-标示
     */
    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    /**
     * @return 资源-名称
     */
    public String getResName() {
        return resName;
    }

    /**
     * @param resName 资源-名称
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * @return 系统-编码
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * @param appCode 系统-编码
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * @return 资源-描述
     */
    public String getResDesc() {
        return resDesc;
    }

    /**
     * @param resDesc 资源-描述
     */
    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    /**
     * @return 某一目录下所有文件
     */
    public List<FileResultDto> getFileResultDtoes() {
        return fileResultDtoes;
    }

    /**
     * @param fileResultDtoes 某一目录下所有文件
     */
    public void setFileResultDtoes(List<FileResultDto> fileResultDtoes) {
        this.fileResultDtoes = fileResultDtoes;
    }

    @Override
    public String toString() {
        return "FileStoreDirectoryResultDto [fileDirId=" + fileDirId + ", fileDirKey=" + fileDirKey + ", fileDirName="
                + fileDirName + ", fileDirLevel=" + fileDirLevel + ", upFileDirId=" + upFileDirId + ", fileDirDesc="
                + fileDirDesc + ", dirResId=" + dirResId + ", dirResIndex=" + dirResIndex + ", isEdit=" + isEdit
                + ", dirResKey=" + dirResKey + ", resId=" + resId + ", resKey=" + resKey + ", resName=" + resName
                + ", appCode=" + appCode + ", resDesc=" + resDesc + "]";
    }
}
