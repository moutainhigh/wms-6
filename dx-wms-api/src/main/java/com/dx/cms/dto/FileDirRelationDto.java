package com.dx.cms.dto;

import java.io.Serializable;
import java.util.Date;

public class FileDirRelationDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5865135949455555310L;

    /** 文件目录关系-编号 主键 */
    private Long fileDirRelationId;

    /** 文件目录-编号 */
    private Long fileDirId;

    /** 文件-编号 */
    private Long fileId;

    /** 文件-存储路径{"/dir1/"} */
    private String fileSaveDir;

    /** 文件-别名 */
    private String fileNickname;

    /** 系统-编码:{"wms":"理财管理","rms":"还款管理","ccs":"信贷管理"} */
    private String appCode;

    /** 开放-编码 */
    private String openCode;

    /** 创建者:{"-1":"系统"} */
    private Long createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新者:{"-1":"系统"} */
    private Long updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 数据状态:{"A":"已生效","D":"已删除"}； */
    private String dataStatus;

    public Long getFileDirRelationId() {
        return fileDirRelationId;
    }

    public void setFileDirRelationId(Long fileDirRelationId) {
        this.fileDirRelationId = fileDirRelationId;
    }

    public Long getFileDirId() {
        return fileDirId;
    }

    public void setFileDirId(Long fileDirId) {
        this.fileDirId = fileDirId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileSaveDir() {
        return fileSaveDir;
    }

    public void setFileSaveDir(String fileSaveDir) {
        this.fileSaveDir = fileSaveDir;
    }

    public String getFileNickname() {
        return fileNickname;
    }

    public void setFileNickname(String fileNickname) {
        this.fileNickname = fileNickname;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
