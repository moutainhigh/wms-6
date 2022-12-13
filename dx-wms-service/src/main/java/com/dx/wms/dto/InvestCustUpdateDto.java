/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: InvestCustUpdateDto.java
 * Author:   yangbao
 * Date:     2015年11月25日 下午8:16:29
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉用于变更数据匹配，封装了客户账户表信息和通讯表信息dto
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InvestCustUpdateDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    /**
     * 客户姓名
     */
    public String custName;
    /**
     * 客户编号:{"借款端-客户编号","理财端-客户编号"}
     */
    private String lenderCustCode;

    /**
     * 客户身份证
     */
    private String idCard;

    /**
     * 客户地址
     */
    private String custAddress;

    /**
     * 客户邮编
     */
    private String zipCode;

    /**
     * 客户电子邮箱:{"TT@TT.TT"}
     */
    private String email;

    /**
     * 客户手机号
     */
    private String mobile;

    /**
     * 客户分类:{1:"客户分类",2:"公司员工"}
     */
    private Integer custCategory;
    /**
     * 寄送方式
     */
    private Integer msgWay;

    /**
     * 开户日期
     */
    private Date applyDate;
    /**
     * 客户来源:{1:"内部",2:"委外"}
     */
    private Integer custSource;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getCustCategory() {
        return custCategory;
    }

    public void setCustCategory(Integer custCategory) {
        this.custCategory = custCategory;
    }

    public Integer getMsgWay() {
        return msgWay;
    }

    public void setMsgWay(Integer msgWay) {
        this.msgWay = msgWay;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

}
