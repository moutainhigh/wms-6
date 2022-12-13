/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: SocialVo.java
 * Author:   yangbao
 * Date:     2016年1月15日 下午2:52:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.hr.enums.InsuredCity;
import com.dx.hr.service.dto.SocialDto;
import com.dx.wms.constant.WMSConstants;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SocialVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    
    /** employeeSocialSecurityId 主键ID */
    private Long employeeSocialSecurityId;
    
    /** 
     * 缴纳地点是否为上海 ： 是：1 否：2
     */
    private Integer isshanghai;
    
    /** 
     * 缴纳地点是否为上海 ： 是：1 否：2
     */
    private String isshanghaiView;

    /** 
     *  公积金账号 ，为上海时必填
     */
    private String fundAccount;

    /** 
     *  缴纳城市
     */
    private String city;

    /** 
     *  是否首次开户(社保) ：是1，否2 
     */
    private Integer firstOpenSocial;
    
    /** 
     *  是否首次开户(社保) ：是1，否2 
     */
    private String firstOpenSocialView;

    /** 
     *  是否已通知上家单位转出(社保)：是1，否2
     */
    private Integer removeSocial;
    
    /** 
     *  是否已通知上家单位转出(社保)：是1，否2
     */
    private String removeSocialVew;

    /** 
     *  是否首次开户(公积金)：是1，否2
     */
    private Integer firstOpenFund;
    
    /** 
     *  是否首次开户(公积金)：是1，否2
     */
    private String firstOpenFundView;

    /** 
     *  是否已通知上家单位转出(公积金)：是1，否2
     */
    private Integer removeFund;
    
    /** 
     *  是否已通知上家单位转出(公积金)：是1，否2
     */
    private String removeFundView;

    /** 
     *  外省市参保类型
     */
    private String insurancetype;

    /** 
     *  外省市社保缴纳省代码
     */
    private String insuredProvinceCode;
    
    /** 
     *  外省市社保缴纳城市代码 
     */
    private String insuredCityCode;
    
    /** 
     *  是否初次在此地参保: 是1，否2 
     */
    private Integer firstInsured;
    
    /** 
     *  是否初次在此地参保: 是1，否2 
     */
    private String firstInsuredView;

    public SocialVo(){
        
    }
    
    public SocialVo(SocialDto socialDto,Integer type){
    	BeanUtils.copyProperties(socialDto, this);
    	setIsshanghaiView(Assert.checkParam(getIsshanghai())?InsuredCity.getInfo(getIsshanghai()):"");
    	setFirstOpenSocialView(Assert.checkParam(getFirstOpenSocial())?getFirstOpenSocial()==1?"是":"否":"");
    	setFirstInsuredView(Assert.checkParam(getFirstInsured())? getFirstInsured()==1?"是":"否":"");
    	setFirstOpenFundView(Assert.checkParam(getFirstOpenFund())? getFirstOpenFund()==1?"是":"否":"");
    	setRemoveFundView(Assert.checkParam(getRemoveFund())? getRemoveFund()==1?"是":"否":"");
    	setRemoveSocialVew(Assert.checkParam(getRemoveSocial())? getRemoveSocial()==1?"是":"否":"");
    }
    
    public SocialVo(SocialDto base){
        BeanUtils.copyProperties(base, this);
        setIsshanghaiView(Assert.checkParam(base.getIsshanghai())?InsuredCity.getInfo(base.getIsshanghai()):WMSConstants.NULL);
    }
    
    public Long getEmployeeSocialSecurityId() {
        return employeeSocialSecurityId;
    }

    public void setEmployeeSocialSecurityId(Long employeeSocialSecurityId) {
        this.employeeSocialSecurityId = employeeSocialSecurityId;
    }

    public Integer getIsshanghai() {
        return isshanghai;
    }

    public void setIsshanghai(Integer isshanghai) {
        this.isshanghai = isshanghai;
    }

    public String getIsshanghaiView() {
        return isshanghaiView;
    }

    public void setIsshanghaiView(String isshanghaiView) {
        this.isshanghaiView = isshanghaiView;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getFirstOpenSocial() {
        return firstOpenSocial;
    }

    public void setFirstOpenSocial(Integer firstOpenSocial) {
        this.firstOpenSocial = firstOpenSocial;
    }

    public String getFirstOpenSocialView() {
        return firstOpenSocialView;
    }

    public void setFirstOpenSocialView(String firstOpenSocialView) {
        this.firstOpenSocialView = firstOpenSocialView;
    }

    public Integer getRemoveSocial() {
        return removeSocial;
    }

    public void setRemoveSocial(Integer removeSocial) {
        this.removeSocial = removeSocial;
    }

    public String getRemoveSocialVew() {
        return removeSocialVew;
    }

    public void setRemoveSocialVew(String removeSocialVew) {
        this.removeSocialVew = removeSocialVew;
    }

    public Integer getFirstOpenFund() {
        return firstOpenFund;
    }

    public void setFirstOpenFund(Integer firstOpenFund) {
        this.firstOpenFund = firstOpenFund;
    }

    public String getFirstOpenFundView() {
        return firstOpenFundView;
    }

    public void setFirstOpenFundView(String firstOpenFundView) {
        this.firstOpenFundView = firstOpenFundView;
    }

    public Integer getRemoveFund() {
        return removeFund;
    }

    public void setRemoveFund(Integer removeFund) {
        this.removeFund = removeFund;
    }

    public String getRemoveFundView() {
        return removeFundView;
    }

    public void setRemoveFundView(String removeFundView) {
        this.removeFundView = removeFundView;
    }

    public String getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(String insurancetype) {
        this.insurancetype = insurancetype;
    }

    public String getInsuredProvinceCode() {
        return insuredProvinceCode;
    }

    public void setInsuredProvinceCode(String insuredProvinceCode) {
        this.insuredProvinceCode = insuredProvinceCode;
    }

    public String getInsuredCityCode() {
        return insuredCityCode;
    }

    public void setInsuredCityCode(String insuredCityCode) {
        this.insuredCityCode = insuredCityCode;
    }

    public Integer getFirstInsured() {
        return firstInsured;
    }

    public void setFirstInsured(Integer firstInsured) {
        this.firstInsured = firstInsured;
    }

    public String getFirstInsuredView() {
        return firstInsuredView;
    }

    public void setFirstInsuredView(String firstInsuredView) {
        this.firstInsuredView = firstInsuredView;
    }

}
