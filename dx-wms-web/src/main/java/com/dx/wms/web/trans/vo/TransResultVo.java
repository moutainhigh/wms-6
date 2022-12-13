/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustTransferQueryVo.java
 * Author:   黄健
 * Date:     2015年10月15日 下午2:09:19
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.trans.vo;

import org.springframework.beans.BeanUtils;

import com.dx.ccs.vo.OrgVo;
import com.dx.common.service.utils.Assert;
import com.dx.wms.service.transfer.ResultTransfer;
import com.dx.wms.web.vo.ResultVo;

/**
 * 转移结果Vo
 *
 * @author huangjian
 */
public class TransResultVo extends ResultVo {

    /**
     */
    private static final long serialVersionUID = 1810412360093249287L;

    /**
     * 潜客主键
     */
    private Long custId;

    /**
     * 客户主键
     */
    private Long custAccountId;

    /**
     * 客户编号
     */
    private String custCode;

    /**
     * 客户-开户-编号
     */
    private String lenderCustCode;

    /**
     * 账户状态
     */
    private String accountStatus;

    /**
     * 账户状态编码
     */
    private Integer accountStatusCode;

    /**
     * 营业部id
     */
    private Long orgId;

    /**
     * 营业部
     */
    private String orgName;

    /**
     * 大团id
     */
    private Long cluster;

    /**
     * 大团
     */
    private String clusterName;

    /**
     * 小团id
     */
    private Long teamId;

    /**
     * 小团
     */
    private String teamName;

    /**
     * 客户经理id
     */
    private Long custManagerId;

    /**
     * 客户经理
     */
    private String custManagerName;

    public void put(TransResultVo vo, ResultTransfer dto) {

    }

    public TransResultVo() {

    }

    public TransResultVo(ResultTransfer resultDto, String orgName, OrgVo teamVo, OrgVo clusterVo,
            String custManager) {
        BeanUtils.copyProperties(resultDto, this);
        if (Assert.checkParam(resultDto.getCustAccountId())) {
            setAccountStatus(getAccountStatus(resultDto.getDataStatus()));
        } else {
            setAccountStatus("潜客客户");
        }
        setOrgName(orgName);
        setTeamName(teamVo.getName());
        setClusterName(clusterVo.getName());
        setCustManagerName(custManager);
    }

    private String getAccountStatus(String dataStatus) {
        String accountStatus = "";
        switch (dataStatus) {
            case "A":
                accountStatus = "待认证";
                break;
            case "C":
                accountStatus = "认证中";
                break;
            case "F":
                accountStatus = "认证失败";
                break;
            case "S":
                accountStatus = "已认证";
                break;
        }
        return accountStatus;
    }

    /**
     * 账户状态编码
     */
    public Integer getAccountStatusCode() {
        return accountStatusCode;
    }

    /**
     * 账户状态编码
     */
    public void setAccountStatusCode(Integer accountStatusCode) {
        this.accountStatusCode = accountStatusCode;
    }

    /**
     * 客户主键
     */
    public Long getCustAccountId() {
        return custAccountId;
    }

    /**
     * 客户主键
     */
    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    /**
     * 客户-开户-编号
     */
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    /**
     * 客户-开户-编号
     */
    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    /**
     * 账户状态
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * 账户状态
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
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
     * 大团编号
     */
    public Long getCluster() {
        return cluster;
    }

    /**
     * 大团编号
     */
    public void setCluster(Long cluster) {
        this.cluster = cluster;
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
     * 用户编号
     */
    public String getCustCode() {
        return custCode;
    }

    /**
     * 用户编号
     */
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    /**
     * 营业部
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 营业部
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 大团
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * 大团
     */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * 小团
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 小团
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * 客户经理
     */
    public String getCustManagerName() {
        return custManagerName;
    }

    /**
     * 客户经理
     */
    public void setCustManagerName(String custManagerName) {
        this.custManagerName = custManagerName;
    }

}
