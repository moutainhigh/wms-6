/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustLinkman.java
 * Author:   朱道灵
 * Date:     2015年7月19日 下午3:21:59
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
 * 客户联系人表
 *
 * @author 朱道灵
 */
@Entity(name = "t_cust_linkman")
public class CustLinkman extends BaseAccount {

    /**
     */
    private static final long serialVersionUID = 1530984966235925264L;

    /**
     * 客户联系人-编号 主键
     */
    private Long custLinkmanId;

    /**
     * 客户联系人-姓名
     */
    private String linkmanName;

    /**
     * 客户联系人-姓名-拼音
     */
    private String linkmanNameSpell;

    /**
     * 客户联系人-性别:{1:"男",0:"女"}
     */
    private Integer linkmanSex;

    /**
     * 客户联系人-关系
     */
    private String linkmanRelation;

    /**
     * 客户联系人-证件类型:{1:"身份证",2:"护照",3:"军官证",4:"港澳台居民往来大陆通行证"}',
     */
    private Integer linkmanIdType;

    /**
     * 客户联系人-证件号码'
     */
    private String linkmanIdCard;

    /**
     * 客户联系人-移动电话''
     */
    private String linkmanMobile;

    /**
     * 客户联系人-固定电话-区号:{"0NN","0NNN"}
     */
    private String areaCode;

    /**
     * 客户联系人-固定电话-号码:{"NNNNNNNN","NNNNNNN"}'
     */
    private String telNum;

    /**
     * 功能描述: 主键<br>
     *
     * @return the custLinkmanId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_linkman_id")
    public Long getCustLinkmanId() {
        return custLinkmanId;
    }

    /**
     * 功能描述: 主键<br>
     *
     * @param custLinkmanId the custLinkmanId to set.
     * 
     */
    public CustLinkman setCustLinkmanId(Long custLinkmanId) {
        this.custLinkmanId = custLinkmanId;
        return this;
    }

    /**
     * 功能描述: 客户联系人-姓名 <br>
     *
     * @return the linkmanName
     */
    @Column(name = "linkman_name")
    public String getLinkmanName() {
        return linkmanName;
    }

    /**
     * 功能描述: 客户联系人-姓名<br>
     *
     * @param linkmanName the linkmanName to set.
     * 
     */
    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    /**
     * 功能描述:客户联系人-姓名-拼音',<br>
     *
     * @return the linkmanSpell
     */
    @Column(name = "linkman_name_spell")
    public String getLinkmanNameSpell() {
        return linkmanNameSpell;
    }

    /**
     * 功能描述: 客户联系人-姓名-拼音',<br>
     *
     * @param linkmanSpell the linkmanSpell to set.
     * 
     */
    public void setLinkmanNameSpell(String linkmanNameSpell) {
        this.linkmanNameSpell = linkmanNameSpell;
    }

    /**
     * 功能描述:客户联系人-性别:{1:"男",0:"女"},<br>
     *
     * @return the linkmanSex
     */
    @Column(name = "linkman_sex")
    public Integer getLinkmanSex() {
        return linkmanSex;
    }

    /**
     * 功能描述: 客户联系人-性别:{1:"男",0:"女"},<br>
     *
     * @param linkmanSex the linkmanSex to set.
     * 
     */
    public void setLinkmanSex(Integer linkmanSex) {
        this.linkmanSex = linkmanSex;
    }

    /**
     * 功能描述:客户联系人-关系,<br>
     *
     * @return the linkmanRelation
     */
    @Column(name = "linkman_relation")
    public String getLinkmanRelation() {
        return linkmanRelation;
    }

    /**
     * 功能描述: 客户联系人-关系-,<br>
     *
     * @param linkmanRelation the linkmanRelation to set.
     * 
     */
    public void setLinkmanRelation(String linkmanRelation) {
        this.linkmanRelation = linkmanRelation;
    }

    /**
     * 功能描述:客户联系人-证件类型:{1:"身份证",2:"护照",3:"军官证",4:"港澳台居民往来大陆通行证"}',<br>
     *
     * @return the linkmanIdType
     */
    @Column(name = "linkman_id_type")
    public Integer getLinkmanIdType() {
        return linkmanIdType;
    }

    /**
     * 功能描述: 客户联系人-证件类型:{1:"身份证",2:"护照",3:"军官证",4:"港澳台居民往来大陆通行证"}',<br>
     *
     * @param linkmanIdType the linkmanIdType to set.
     * 
     */
    public void setLinkmanIdType(Integer linkmanIdType) {
        this.linkmanIdType = linkmanIdType;
    }

    /**
     * 功能描述:客户联系人-证件号码'<br>
     *
     * @return the linkmanIdCard
     */
    @Column(name = "linkman_id_card")
    public String getLinkmanIdCard() {
        return linkmanIdCard;
    }

    /**
     * 功能描述::客户联系人-证件号码',<br>
     *
     * @param linkmanIdCard the linkmanIdCard to set.
     * 
     */
    public void setLinkmanIdCard(String linkmanIdCard) {
        this.linkmanIdCard = linkmanIdCard;
    }

    /**
     * 功能描述:客户联系人-移动电话''<br>
     *
     * @return the linkmanMobile
     */
    @Column(name = "linkman_mobile")
    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    /**
     * 功能描述::客户联系人-移动电话'',<br>
     *
     * @param linkmanMobile the linkmanMobile to set.
     * 
     */
    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
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
     * 功能描述: 客户账户-编号<br>
     *
     * @param custAccountId the custAccountId to set.
     * 
     */
    public CustLinkman setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
        return this;
    }
}
