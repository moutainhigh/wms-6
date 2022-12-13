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

import com.dx.wms.web.vo.ParamVo;

/**
 * 转移参数Vo
 *
 * @author huangjian
 */
public class TransParamVo extends ParamVo {

    /**
     */
    private static final long serialVersionUID = -2387847802911821642L;

    /**
     * 客户编号
     */
    private String custCode;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 营业部
     */
    private Long orgId;

    /**
     * 大团编号
     */
    private Long cluster;

    /**
     * 小团编号
     */
    private Long teamId;

    /**
     * 客户经理编号
     */
    private Long custManagerId;

    /**
     * 待转移客户
     */
    private String custIds;

    /**
     * 客户编号
     */
    public String getLenderCustCode() {
        return lenderCustCode;
    }

    /**
     * 客户编号
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

}
