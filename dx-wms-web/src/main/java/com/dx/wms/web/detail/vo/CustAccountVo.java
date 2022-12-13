package com.dx.wms.web.detail.vo;

import java.io.Serializable;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.CommonLanguage;
import com.dx.wms.enums.CustCategery;
import com.dx.wms.enums.CustSource;
import com.dx.wms.enums.Education;
import com.dx.wms.enums.IdType;
import com.dx.wms.enums.MaritalStatus;
import com.dx.wms.enums.MsgWay;
import com.dx.wms.enums.Sex;
import com.dx.wms.service.account.entity.CustAccount;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
public class CustAccountVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 7988817661819769413L;

    /**
     * 理财-客户-编码
     */
    private String lenderCustCode;

    /**
     * 
     */
    private String custCode;

    /**
     * 客户-姓名
     */
    private String custName;

    /**
     * 客户-姓名-拼音
     */
    private String custNameSpell;

    /**
     * 性别
     */
    private String sex;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 常用语言
     */
    private String commonLanguage;

    /**
     * 证件类型
     */
    private String idType;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 出生日期
     */
    private String birthDate;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 最高学历
     */
    private String education;

    /**
     * 接受文件方式
     */
    private String msgWay;

    /**
     * 客户来源
     */
    private String custSource;

    /**
     * 客户分类
     */
    private String custCategory;

    /**
     * 开户日期
     */
    private String openDate;

    public CustAccountVo() {

    }

    public CustAccountVo(CustAccount base) {
        setLenderCustCode(Assert.checkParam(base.getLenderCustCode()) ? base.getLenderCustCode() : WMSConstants.NULL);
        setCustName(Assert.checkParam(base.getCustName()) ? base.getCustName() : WMSConstants.NULL);
        setCustNameSpell(Assert.checkParam(base.getCustNameSpell()) ? base.getCustNameSpell() : WMSConstants.NULL);
        setSex(Sex.getInfo(base.getSex(), true));
        setNationality(Assert.checkParam(base.getNationality()) ? base.getNationality() : WMSConstants.NULL);
        setMaritalStatus(MaritalStatus.getInfo(base.getMaritalStatus(), true));
        setCommonLanguage(CommonLanguage.getInfo(base.getCommonLanguage(), true));
        setIdType(IdType.getInfo(base.getIdType(), true));
        setIdCard(Assert.checkParam(base.getIdCard()) ? base.getIdCard() : WMSConstants.NULL);
        setBirthDate(DateUtils.formatForDay(base.getBirthDate(), WMSConstants.NULL));
        setMobile(Assert.checkParam(base.getMobile()) ? base.getMobile() : WMSConstants.NULL);
        setEducation(Education.getInfo(base.getEducation(), true));
        setMsgWay(MsgWay.getInfo(base.getMsgWay(), true));
        setCustSource(Assert.checkParam(base.getCustSource())
                && Assert.equals(base.getCustSource(), CustSource.OTHER.getCode())
                        ? Assert.checkParam(base.getCustSourceOther()) ? base.getCustSourceOther() : WMSConstants.NULL
                        : CustSource.getInfo(base.getCustSource(), true));
        setCustCategory(CustCategery.getInfo(base.getCustCategory(), true));
        setOpenDate(DateUtils.formatForDay(base.getOpenDate(), WMSConstants.NULL));
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustNameSpell() {
        return custNameSpell;
    }

    public void setCustNameSpell(String custNameSpell) {
        this.custNameSpell = custNameSpell;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCommonLanguage() {
        return commonLanguage;
    }

    public void setCommonLanguage(String commonLanguage) {
        this.commonLanguage = commonLanguage;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMsgWay() {
        return msgWay;
    }

    public void setMsgWay(String msgWay) {
        this.msgWay = msgWay;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustCategory() {
        return custCategory;
    }

    public void setCustCategory(String custCategory) {
        this.custCategory = custCategory;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

}
