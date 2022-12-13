/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ConditionsDto.java
 * Author:   黄健
 * Date:     2015年8月27日 下午10:42:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.dto;

import java.io.Serializable;
import java.util.List;

import com.dx.cms.enums.ResKey;

/**
 * 条件Dto
 *
 * @author huangjian
 */
public class Condition implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6986315851865365121L;

    /**
     * 系统-编码:{"wms":"理财管理","rms":"还款管理","ccs":"信贷管理"}
     */
    private String appCode;

    private String resKey;

    /**
     * 资源-标示
     */
    private ResKey res;

    /**
     * 客户账户-编号
     */
    private Long custAccountId;

    /**
     * 出借申请-编号
     */
    private Long lenderApplyId;

    /**
     * 理财-客户-编码-规则
     */
    private String lenderCustCode;

    /**
     * 出借编号-规则
     */
    private String lenderCode;

    /**
     * 请求标示
     */
    private String cmAction;

    /**
     * 目录主键
     */
    private Long fileDirId;

    /**
     * 文件主键
     */
    private Long fileId;

    private List<Long> fileIds;

    /**
     * 1.开户 2.提交销售客服 3.提交执委会
     */
    private Integer type;

    private String action;

    private Long user;

    /**
     * 文件显示模式
     */
    private String fileShowModel;

    private String openCode;

    private List<String> openCodes;

    public Condition() {

    }

    public Condition(List<Long> fileIds, String action) {
        setFileIds(fileIds);
        setCmAction(action);
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public ResKey getRes() {
        return res;
    }

    public void setRes(ResKey res) {
        this.res = res;
        setResKey(res.getInfo());
    }

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getCmAction() {
        return cmAction;
    }

    public void setCmAction(String cmAction) {
        this.cmAction = cmAction;
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

    public List<Long> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<Long> fileIds) {
        this.fileIds = fileIds;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getFileShowModel() {
        return fileShowModel;
    }

    public void setFileShowModel(String fileShowModel) {
        this.fileShowModel = fileShowModel;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public List<String> getOpenCodes() {
        return openCodes;
    }

    public void setOpenCodes(List<String> openCodes) {
        this.openCodes = openCodes;
    }

}
