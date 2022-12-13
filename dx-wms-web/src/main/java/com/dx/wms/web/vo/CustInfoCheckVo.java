/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustInfoCheckVo.java
 * Author:   王蕊
 * Date:     2015年7月22日 下午8:12:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.vo;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 王蕊
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustInfoCheckVo {
    /** 客户编号 */
    private long custId;

    /** 证件号码 */
    private String idCard;

    /** 手机号 */
    private String mobile;

    /** 姓名 */
    private String custName;

    /** 出借金额 */
    private String lenderAmount;

    /** 合同编号 */
    private String contractCode;

    /** 续投ID编号 */
    private Long parentId;

    /** 理财申请ID编号 */
    private Long lenderApplyId;

    /** 证件号码 */
    public String getIdCard() {
        return idCard;
    }

    /** 证件号码 */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /** 手机号码 */
    public String getMobile() {
        return mobile;
    }

    /** 手机号码 */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /** 客户姓名 */
    public String getCustName() {
        return custName;
    }

    /** 客户姓名 */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /** 出借金额 */
    public String getLenderAmount() {
        return lenderAmount;
    }

    /** 出借金额 */
    public void setLenderAmount(String lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    /** 合同编号 */
    public String getContractCode() {
        return contractCode;
    }

    /** 合同编号 */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /** 客户编号 */
    public long getCustId() {
        return custId;
    }

    /** 客户编号 */
    public void setCustId(long custId) {
        this.custId = custId;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

}
