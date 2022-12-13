/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustComm.java
 * Author:   朱道灵
 * Date:     2015年7月19日 下午2:58:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 客户通讯表
 *
 * @author 朱道灵
 */
@Entity(name = "t_cust_comm")
public class CustComm extends BaseAccount {

    /**
     */
    private static final long serialVersionUID = 4038217473002785247L;

    /**
     * 客户通讯-编号 主键
     */
    private Long custCommId;

    /**
     * 通讯地址-省区域-编码:{"NNNNNN"}
     */
    private String provinceRegionCode;

    /**
     * 通讯地址-市区域-编码:{"NNNNNN"}
     */
    private String cityRegionCode;

    /**
     * 通讯地址-区区域-编码:{"NNNNNN"}
     */
    private String districtRegionCode;

    /**
     * 通讯地址-街道信息
     */
    private String streetInfo;

    /**
     * 通讯地址-邮政编码
     */
    private String zipCode;

    /**
     * 通讯-固定电话-区号:{"0NN","0NNN"}
     */
    private String areaCode;

    /**
     * 通讯-固定电话-号码客户联系人-固定电话-号码:{"NNNNNNNN","NNNNNNN"}
     */
    private String telNum;

    /**
     * 电子邮箱:{"TT@TT.TT"}
     */
    private String email;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 功能描述: 客户通讯-编号 主键<br>
     *
     * @return the custCommId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_comm_id")
    public Long getCustCommId() {
        return custCommId;
    }

    /**
     * 功能描述: 客户通讯-编号 主键<br>
     *
     * @param custCommId the custCommId to set.
     * 
     */
    public CustComm setCustCommId(Long custCommId) {
        this.custCommId = custCommId;
        return this;
    }

    /**
     * 功能描述: 通讯地址-省区域-编码:{"NNNNNN"}
     *
     * @return the provinceRegionCode
     */
    @Column(name = "province_region_code")
    public String getProvinceRegionCode() {
        return provinceRegionCode;
    }

    /**
     * 功能描述: 通讯地址-省区域-编码:{"NNNNNN"}
     *
     * @param provinceRegionCode the provinceRegionCode to set.
     * 
     */
    public void setProvinceRegionCode(String provinceRegionCode) {
        this.provinceRegionCode = provinceRegionCode;
    }

    /**
     * 功能描述: 通讯地址-市区域-编码:{"NNNNNN"}
     *
     * @return the cityRegionCode
     */
    @Column(name = "city_region_code")
    public String getCityRegionCode() {
        return cityRegionCode;
    }

    /**
     * 功能描述: 通讯地址-市区域-编码:{"NNNNNN"}
     *
     * @param cityRegionCode the cityRegionCode to set.
     * 
     */
    public void setCityRegionCode(String cityRegionCode) {
        this.cityRegionCode = cityRegionCode;
    }

    /**
     * 功能描述: 通讯地址-区区域-编码:{"NNNNNN"}'
     *
     * @return the districtRegionCode
     */
    @Column(name = "district_region_code")
    public String getDistrictRegionCode() {
        return districtRegionCode;
    }

    /**
     * 功能描述:通讯地址-区区域-编码:{"NNNNNN"}'
     *
     * @param districtRegionCode the districtRegionCode to set.
     * 
     */
    public void setDistrictRegionCode(String districtRegionCode) {
        this.districtRegionCode = districtRegionCode;
    }

    /**
     * 功能描述: 通讯地址-街道信息'
     *
     * @return the streetInfo
     */
    @Column(name = "street_Info")
    public String getStreetInfo() {
        return streetInfo;
    }

    /**
     * 功能描述: 通讯地址-街道信息'
     *
     * @param streetInfo the streetInfo to set.
     * 
     */
    public void setStreetInfo(String streetInfo) {
        this.streetInfo = streetInfo;
    }

    /**
     * 功能描述: 通讯地址-邮政编码'
     *
     * @return the zipCode
     */
    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 功能描述: 通讯地址-邮政编码'
     *
     * @param zipCode the zipCode to set.
     * 
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 功能描述: 通讯-固定电话-区号:{"0NN","0NNN"}
     *
     * @return the areaCode
     */
    @Column(name = "area_code")
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 功能描述: 通讯-固定电话-区号:{"0NN","0NNN"}
     *
     * @param areaCode the areaCode to set.
     * 
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 功能描述: 通讯-固定电话-号码客户联系人-固定电话-号码:{"NNNNNNNN","NNNNNNN"}
     *
     * @return the telNum
     */
    @Column(name = "tel_Num")
    public String getTelNum() {
        return telNum;
    }

    /**
     * 功能描述: 通讯-固定电话-号码客户联系人-固定电话-号码:{"NNNNNNNN","NNNNNNN"}
     *
     * @param telNum the telNum to set.
     * 
     */
    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    /**
     * 功能描述: 电子邮箱:{"TT@TT.TT"}
     *
     * @return the email
     */
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    /**
     * 功能描述: 电子邮箱:{"TT@TT.TT"}
     *
     * @param email the email to set.
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 功能描述: 微信
     *
     * @return the wechat
     */
    @Column(name = "wechat")
    public String getWechat() {
        return wechat;
    }

    /**
     * 功能描述: 微信
     *
     * @param wechat the wechat to set.
     * 
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    
    /**
     * 功能描述: 客户账户-编号<br>
     *
     * @param custAccountId the custAccountId to set.
     * 
     */
    public CustComm setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
        return this;
    }

}
