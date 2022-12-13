/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ConditionsForQueryFilesVo.java
 * Author:   黄健
 * Date:     2015年8月5日 下午5:49:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.web.vo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ConditionsVo {

    /** 系统-编码:{"wms":"理财管理","rms":"还款管理","ccs":"信贷管理"} */
    private String appCode;
    
    /** 资源-标示 */
    private String resKey;
    
    /** 客户账户-编号 */
    private Long custAccountId;
    
    /** 出借申请-编号 */
    private Long lenderApplyId;
    
    /** 理财-客户-编码-规则 */
    private String lenderCustCode;
    
    /** 出借编号-规则 */
    private String lenderCode;
    
    /** 请求标示 */
    private String cmAction;
    
    /** 目录主键 */
    private Long fileDirId;
    
    /** 文件主键 */
    private Long fileId;
    
    /** 1.开户 2.提交销售客服  3.提交执委会 */
    private String type;
    
    /** 影像记录生效对象标志  用户影像 或是 业务影像 */
    private String action;
    
    /** 文件显示模式 */
    private String fileShowModel;
    
    /**
     * @return the fileShowModel
     */
    public String getFileShowModel() {
        return fileShowModel;
    }

    /**
     * @param fileShowModel the fileShowModel to set
     */
    public void setFileShowModel(String fileShowModel) {
        this.fileShowModel = fileShowModel;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the fileId
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * @param fileId the fileId to set
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * @return the fileDirId
     */
    public Long getFileDirId() {
        return fileDirId;
    }

    /**
     * @param fileDirId the fileDirId to set
     */
    public void setFileDirId(Long fileDirId) {
        this.fileDirId = fileDirId;
    }

    /**
     * @return the cmAction
     */
    public String getCmAction() {
        return cmAction;
    }

    /**
     * @param cmAction the cmAction to set
     */
    public void setCmAction(String cmAction) {
        this.cmAction = cmAction;
    }

    /**
     * @return the appCode
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * @param appCode the appCode to set
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * @return the resKey
     */
    public String getResKey() {
        return resKey;
    }

    /**
     * @param resKey the resKey to set
     */
    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    /**
     * @return the custAccountId
     */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * @param custAccountId the custAccountId to set
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /**
     * @return the lenderApplyId
     */
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * @param lenderApplyId the lenderApplyId to set
     */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * @return the lenderCustCode
     */
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    /**
     * @param lenderCustCode the lenderCustCode to set
     */
    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    /**
     * @return the lenderCode
     */
    public String getLenderCode() {
        return lenderCode;
    }

    /**
     * @param lenderCode the lenderCode to set
     */
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    @Override
    public String toString() {
        return "ConditionsVo [appCode=" + appCode + ", resKey=" + resKey + ", custAccountId=" + custAccountId
                + ", lenderApplyId=" + lenderApplyId + ", lenderCustCode=" + lenderCustCode + ", lenderCode="
                + lenderCode + ", cmAction=" + cmAction + ", fileDirId=" + fileDirId + ", fileId=" + fileId + ", type="
                + type + ", action=" + action + "]";
    }
    
    
}
