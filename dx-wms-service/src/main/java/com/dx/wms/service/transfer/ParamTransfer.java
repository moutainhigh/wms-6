/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustTransferQueryDto.java
 * Author:   黄健
 * Date:     2015年10月15日 下午2:48:39
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.transfer;

import java.io.Serializable;

import com.dx.framework.dal.pagination.Pagination;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ParamTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * 潜客编码
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
     * 身份证
     */
    private String idCard;
    
    /**
     * 移动号码
     */
    private String mobile;
    
    /**
     * 营业部
     */
    private Long orgId;
    
    /**
     * 大团
     */
    private Long cluster;
    
    /**
     * 团队
     */
    private Long teamId;
    
    /**
     * 接收-客户经理
     */
    private Long custManagerId;
    /**
     * 客户编号
     */
    private Long custId;
    
    /**
     * 待转移客户
     */
    private String custIds;
    /**
     * 出借申请编号
     */
    private Long lenderApplyId;
    /**
     * 客户账户编号
     */
    private Long custAccountId;
    
    /**
     * 分页信息
     */
    private Pagination pagination;
    
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
     * 待转移客户
     */
    public String getCustIds() {
        return custIds;
    }

    /**
     * 待转移客户
     */
    public void setCustIds(String custIds) {
        this.custIds = custIds;
    }

    /**
     * 潜客编码
     */
    public String getCustCode() {
        return custCode;
    }

    /**
     * 潜客编码
     */
    public void setCustCode(String custCode) {
        this.custCode = custCode;
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
     * 身份证
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证
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
     * 接收-客户经理
     */
    public Long getCustManagerId() {
        return custManagerId;
    }

    /**
     * 接收-客户经理
     */
    public void setCustManagerId(Long custManagerId) {
        this.custManagerId = custManagerId;
    }

    /**
     * 营业部
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 营业部
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 大团
     */
    public Long getCluster() {
        return cluster;
    }

    /**
     * 大团
     */
    public void setCluster(Long cluster) {
        this.cluster = cluster;
    }

    /**
     * 团队
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * 团队
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * 客户编号
     */
    public Long getCustId() {
        return custId;
    }

    /**
     * 客户编号
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    /**
     * 客户账户编号
     */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * 客户账户编号
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /**
     * 出借申请编号
     */
    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    /**
     * 出借申请编号
     */
    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * 分页
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 分页
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
