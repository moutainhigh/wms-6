package com.dx.wms.web.detail.vo;

import java.io.Serializable;
import java.text.MessageFormat;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.IdType;
import com.dx.wms.enums.Sex;
import com.dx.wms.service.account.entity.CustLinkman;

public class CustLinkmanVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -3047835470537923580L;

    /**
     * 客户联系人-姓名
     */
    private String name;

    /**
     * 客户联系人-姓名-拼音
     */
    private String nameSpell;

    /**
     * 客户联系人-性别:{1:"男",0:"女"}
     */
    private String sex;

    /**
     * 客户联系人-关系
     */
    private String relation;

    /**
     * 客户联系人-证件类型:{1:"身份证",2:"护照",3:"军官证",4:"港澳台居民往来大陆通行证"}',
     */
    private String idType;

    /**
     * 客户联系人-证件号码'
     */
    private String idCard;

    /**
     * 客户联系人-移动电话''
     */
    private String mobile;

    /**
     * 客户联系人-固定电话-号码:{"NNNNNNNN","NNNNNNN"}'
     */
    private String telNum;

    public CustLinkmanVo() {

    }

    public CustLinkmanVo(CustLinkman base) {
        setName(Assert.checkParam(base.getLinkmanName()) ? base.getLinkmanName() : WMSConstants.NULL);
        setNameSpell(Assert.checkParam(base.getLinkmanNameSpell()) ? base.getLinkmanNameSpell() : WMSConstants.NULL);
        setSex(Sex.getInfo(base.getLinkmanSex(), true));
        setRelation(Assert.checkParam(base.getLinkmanRelation()) ? base.getLinkmanRelation() : WMSConstants.NULL);
        setIdType(IdType.getInfo(base.getLinkmanIdType(), true));
        setIdCard(Assert.checkParam(base.getLinkmanIdCard()) ? base.getLinkmanIdCard() : WMSConstants.NULL);
        setMobile(Assert.checkParam(base.getLinkmanMobile()) ? base.getLinkmanMobile() : WMSConstants.NULL);
        String telNum = Assert.checkParam(base.getAreaCode())
                ? MessageFormat.format("{0}-{1}", base.getAreaCode(), base.getTelNum()) : WMSConstants.NULL;
        setTelNum(telNum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSpell() {
        return nameSpell;
    }

    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

}
