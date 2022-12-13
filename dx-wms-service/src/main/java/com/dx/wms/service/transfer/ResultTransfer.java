/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustTransferResultDto.java
 * Author:   黄健
 * Date:     2015年10月15日 下午2:48:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.transfer;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ResultTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * 潜客主键
     */
    private Long custId;
    
    /**
     * 开户用户主键
     */
    private Long custAccountId;
    
    /**
     * 客户编码
     */
    private String custCode;
    
    /**
     * 客户编码规则
     */
    private String lenderCustCode;
    
    /**
     * 客户姓名
     */
    private String custName;
    
    /**
     * 证件号码
     */
    private String idCard;
    
    /**
     * 移动号码
     */
    private String mobile;
    
    /**
     * 小团编号
     */
    private Long teamId;
    
    /**
     * 营业部编号
     */
    private Long orgId;
    
    /**
     * 客户经理
     */
    private Long custManagerId;
    
    /** 状态*/
    private String dataStatus;
    
    /**
     * 潜客主键
     */
    public Long getCustId() {
        return custId;
    }

    /**
     * 潜客主键
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * 开户用户主键
     */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * 开户用户主键
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /**
     * 客户编号
     */
    public String getCustCode() {
        return custCode;
    }

    /**
     * 客户编号
     */
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    /**
     * 客户编码规则
     */
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    /**
     * 客户编码规则
     */
    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    /**
     * 客户姓名
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 客户姓名
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * 证件号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     *证件号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 移动号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 移动号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 小团编号
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * 小团编号
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * 营业部
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     *营业部
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 客户经理
     */
    public Long getCustManagerId() {
        return custManagerId;
    }

    /**
     * 客户经理
     */
    public void setCustManagerId(Long custManagerId) {
        this.custManagerId = custManagerId;
    }

    /**
     * 状态
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * 状态
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
