package com.dx.wms.web.detail.vo;

import java.io.Serializable;
import java.text.MessageFormat;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.account.entity.CustComm;

/**
 * 
 * 联系
 * 
 * @author tony
 */
public class CustCommVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2373291779200925534L;

    /**
     * 通讯地址
     */
    private String address;

    /**
     * 通讯地址-邮政编码
     */
    private String zipCode;

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

    public CustCommVo() {

    }

    
    public CustCommVo(CustComm base, String area) {
        String address = area.concat(base.getStreetInfo());
        setAddress(Assert.checkParam(address) ? address : WMSConstants.NULL);
        setZipCode(Assert.checkParam(base.getZipCode()) ? base.getZipCode() : WMSConstants.NULL);
        String telNum = Assert.checkParam(base.getAreaCode())
                ? MessageFormat.format("{0}-{1}", base.getAreaCode(), base.getTelNum()) : WMSConstants.NULL;
        setTelNum(telNum);
        setEmail(Assert.checkParam(base.getEmail()) ? base.getEmail() : WMSConstants.NULL);
        setWechat(Assert.checkParam(base.getWechat()) ? base.getWechat() : WMSConstants.NULL);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

}
