/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: DetailInfoVo.java
 * Author:   yangbao
 * Date:     2016年2月1日 下午3:01:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.hr.enums.CensusType;
import com.dx.hr.enums.CountryType;
import com.dx.hr.enums.Education;
import com.dx.hr.enums.EntrySourceType;
import com.dx.hr.enums.Marriage;
import com.dx.hr.enums.NationType;
import com.dx.hr.enums.PoliticalStatus;
import com.dx.hr.enums.WorkUnit;
import com.dx.hr.service.dto.EmployeeDetailInfo;
import com.dx.wms.constant.WMSConstants;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DetailInfoVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -4988065489050705960L;

    /**
     * employeeDetailId 员工详细ID
     */
    private Long employeeDetailId;

    /**
     * employeeId 员工ID
     */
    private Long employeeId;

    /**
     * certValidStart 证件有效期起
     */
    private Date certValidStart;
    
    private String certValidStartView;

    /**
     * certValidEnd 证件有效期止
     */
    private Date certValidEnd;
    
    private String certValidEndView;

    /**
     * 身份证号有效时间
     */
    private String certValidView;

    /**
     * birthDate 出生日期
     */
    private Date birthDate;
    
    /**
     * birthDateView 出生日期
     */
    private String birthDateView;

    /**
     * email 邮箱
     */
    private String email;

    /**
     * companyEmail 公司邮箱
     */
    private String companyEmail;

    /**
     * entrySource 入职来源:外部聘用：1；内部推荐：2
     */
    private Integer entrySource;
    
    private String entrySourceView;

    /**
     * politicalStatus 政治面貌
     */
    private Integer politicalStatus;
    
    private String politicalStatusView;
    
    /**
     * degree 文化程度
     */
    private Integer degree;
    
    private String degreeView;
    
    /**
     * country 国籍
     */
    private Integer country;
    
    /**
     * countryView 国籍
     */
    private String countryView;

    /**
     * nation 民族
     */
    private Integer nation;
    
    /**
     * nation 民族
     */
    private String nationView;
    
    /** 
     * workUnit 服务单位 1:达信财富；2：达信卓惠；3：达信恒泽
     */
    private Integer workUnit;
    
    private String workUnitView;
    
    /**
     * maritalStatus 婚姻状况
     */
    private Integer maritalStatus;

    /**
     * maritalStatusView 婚姻状况
     */
    private String maritalStatusView;

    /**
     * firstWorkDate 首次参加工作年月
     */
    private Date firstWorkDate;
    
    private String firstWorkDateView;
    
    /**
     * 为空时，有待完善
     */
    private String firstWorkView;
    

	/**
     * censusRegister 户籍性质
     */
    private Integer censusRegister;
    
    private String censusRegisterView;

    /**
     * censusProvinceCode 户籍省
     */
    private String censusProvinceCode;

    /**
     * censusCityCode 户籍市
     */
    private String censusCityCode;
    
    /**
     * censusAreaCode 户籍区
     */
    private String censusAreaCode;

    /**
     * censusAddress 户籍详细地址
     */
    private String censusAddress;
    
    /**
     * 将户籍地址拼接
     */
    private String censusDetail;

    /**
     * censusZipCode 户籍地址邮政编码
     */
    private String censusZipCode;

    /**
     * homeProvinceCode 家庭住址省
     */
    private String homeProvinceCode;

    /**
     * homeCityCode 家庭住址市
     */
    private String homeCityCode;

    /**
     * homeAreaCode 家庭住址区
     */
    private String homeAreaCode;

    /**
     * homeAddress 家庭详细地址
     */
    private String homeAddress;
    
    /**
     * 将现居之地址拼接一起
     */
    private String homeDetail;

    /**
     * homeZipCode 家庭住址邮编
     */
    private String homeZipCode;
    
    /** 
     * bankProvinceCode 开户行省
     */
    private String bankProvinceCode;
        
    private String bankProvince;
    
    /** 
     * bankCityCode 开户行城市
     */
    private String bankCityCode;
    
    private String bankCity;
    
    /**
     *  otherAddress 其他支行
     */
    private String otherAddress;

    /**
     * bankCardNo 银行卡号
     */
    private String bankCardNo;
    
    /**
     * openAddress 开户行地址
     */
    private String openAddress;
    
    /**
     * 拼接开户地址
     */
    private String bankDetail;

    /**
     * createTime 创建时间
     */
    private Date createTime;

    /**
     * createUser 创建人
     */
    private Long createUser;

    /**
     * updateTime 更新时间
     */
    private Date updateTime;

    /**
     * updateUser 更新人
     */
    private Long updateUser;

    /**
     * rowStatus 删除D；草稿F；生效A；
     */
    private String rowStatus;

    public DetailInfoVo() {

    }

    public DetailInfoVo(EmployeeDetailInfo base,String censusArea,String homeArea,String bankArea) {
        BeanUtils.copyProperties(base, this);
        setCertValidStartView(DateUtils.formatForDay(getCertValidStart(),""));
        setFirstWorkDateView(DateUtils.formatForDay(getFirstWorkDate(),""));
        setCertValidEndView(DateUtils.formatForDay(getCertValidEnd(),""));
        String certValidView = MessageFormat.format("{0} 至 {1}", DateUtils.formatForDay(getCertValidStart(), ""),
                DateUtils.formatForDay(getCertValidEnd(), ""));
        setCertValidView(Assert.equals(certValidView.trim(), "至") ? WMSConstants.NULL : certValidView);
        setBirthDateView(DateUtils.formatForDay(getBirthDate(), ""));
        setMaritalStatusView(Assert.checkParam(getMaritalStatus()) ? Marriage.getInfo(getMaritalStatus())
                : WMSConstants.NULL);
        setCountryView(Assert.checkParam(getCountry())?CountryType.getInfo(getCountry()):WMSConstants.NULL);
        setNationView(Assert.checkParam(getNation())? NationType.getInfo(getNation()):WMSConstants.NULL);
        setPoliticalStatusView(Assert.checkParam(getPoliticalStatus())?PoliticalStatus.getInfo(getPoliticalStatus()):WMSConstants.NULL);
        setDegreeView(Assert.checkParam(getDegree())?Education.getInfo(getDegree()):WMSConstants.NULL);
        setWorkUnitView(Assert.checkParam(getWorkUnit())?WorkUnit.getInfo(getWorkUnit()):WMSConstants.NULL);
        setEntrySourceView(Assert.checkParam(getEntrySource())?EntrySourceType.getInfo(getEntrySource()):WMSConstants.NULL);
        setCensusRegisterView(Assert.checkParam(getCensusRegister())?CensusType.getInfo(getCensusRegister()):WMSConstants.NULL);
        if(Assert.checkParam(base.getCensusProvinceCode())&&Assert.checkParam(base.getCensusCityCode())){
            setCensusDetail(censusArea.concat(base.getCensusAddress()));
        }
        if(Assert.checkParam(base.getHomeProvinceCode())&&Assert.checkParam(base.getHomeCityCode())){
            setHomeDetail(homeArea.concat(base.getHomeAddress()));
        }
    }
    
    public DetailInfoVo(EmployeeDetailInfo base,Integer type) {
        BeanUtils.copyProperties(base, this);
        String certValidView = MessageFormat.format("{0} 至 {1}", DateUtils.formatForDay(getCertValidStart(), ""),
                DateUtils.formatForDay(getCertValidEnd(), ""));
        setCertValidView(Assert.equals(certValidView.trim(), "至") ? WMSConstants.NULL : certValidView);
        setBirthDateView(DateUtils.formatForDay(getBirthDate(), WMSConstants.NULL));
        setMaritalStatusView(Assert.checkParam(getMaritalStatus()) ? Marriage.getInfo(getMaritalStatus())
                : WMSConstants.NULL);
        setCountryView(Assert.checkParam(getCountry())?CountryType.getInfo(getCountry()):WMSConstants.NULL);
        setNationView(Assert.checkParam(getNation())? NationType.getInfo(getNation()):WMSConstants.NULL);
        setPoliticalStatusView(Assert.checkParam(getPoliticalStatus())?PoliticalStatus.getInfo(getPoliticalStatus()):WMSConstants.NULL);
        setDegreeView(Assert.checkParam(getDegree())?Education.getInfo(getDegree()):WMSConstants.NULL);
        setWorkUnitView(Assert.checkParam(getWorkUnit())?WorkUnit.getInfo(getWorkUnit()):WMSConstants.NULL);
        setFirstWorkDateView(DateUtils.formatForDay(getFirstWorkDate(),WMSConstants.NULL));
        setCensusRegisterView(Assert.checkParam(getCensusRegister())? CensusType.getMap().get(getCensusRegister().toString()):WMSConstants.NULL);
        setEntrySourceView(Assert.checkParam(getEntrySource())?EntrySourceType.getInfo(getEntrySource()):WMSConstants.NULL);
        setEmail(Assert.checkParam(getEmail())?getEmail():WMSConstants.NULL);
        setHomeAddress(Assert.checkParam(getHomeAddress())?getHomeAddress():WMSConstants.NULL);
        setCensusAddress(Assert.checkParam(getCensusAddress())?getCensusAddress():WMSConstants.NULL);
        setOpenAddress(Assert.checkParam(getOpenAddress())?getOpenAddress():"招商银行");
        setOtherAddress(Assert.checkParam(getOtherAddress())?getOtherAddress():WMSConstants.NULL);
        setHomeZipCode(Assert.checkParam(getHomeZipCode())?getHomeZipCode():WMSConstants.NULL);
        setCensusZipCode(Assert.checkParam(getCensusZipCode())?getCensusZipCode():WMSConstants.NULL);
        setBankCardNo(Assert.checkParam(getBankCardNo())?getBankCardNo():WMSConstants.NULL);
    }


    public String getFirstWorkView() {
        return firstWorkView;
    }

    public void setFirstWorkView(String firstWorkView) {
        this.firstWorkView = firstWorkView;
    }

    public String getCensusDetail() {
        return censusDetail;
    }

    public void setCensusDetail(String censusDetail) {
        this.censusDetail = censusDetail;
    }

    public String getHomeDetail() {
        return homeDetail;
    }

    public void setHomeDetail(String homeDetail) {
        this.homeDetail = homeDetail;
    }

    public String getBankDetail() {
        return bankDetail;
    }

    public void setBankDetail(String bankDetail) {
        this.bankDetail = bankDetail;
    }

    public String getCertValidStartView() {
        return certValidStartView;
    }

    public void setCertValidStartView(String certValidStartView) {
        this.certValidStartView = certValidStartView;
    }

    public String getCertValidEndView() {
        return certValidEndView;
    }

    public void setCertValidEndView(String certValidEndView) {
        this.certValidEndView = certValidEndView;
    }

	public Long getEmployeeDetailId() {
		return employeeDetailId;
	}

	public void setEmployeeDetailId(Long employeeDetailId) {
		this.employeeDetailId = employeeDetailId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getCertValidStart() {
		return certValidStart;
	}

	public void setCertValidStart(Date certValidStart) {
		this.certValidStart = certValidStart;
	}

	public Date getCertValidEnd() {
		return certValidEnd;
	}

	public void setCertValidEnd(Date certValidEnd) {
		this.certValidEnd = certValidEnd;
	}

	public String getCertValidView() {
		return certValidView;
	}

	public void setCertValidView(String certValidView) {
		this.certValidView = certValidView;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthDateView() {
		return birthDateView;
	}

	public void setBirthDateView(String birthDateView) {
		this.birthDateView = birthDateView;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public Integer getEntrySource() {
		return entrySource;
	}

	public void setEntrySource(Integer entrySource) {
		this.entrySource = entrySource;
	}

	public String getEntrySourceView() {
		return entrySourceView;
	}

	public void setEntrySourceView(String entrySourceView) {
		this.entrySourceView = entrySourceView;
	}

	public Integer getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getPoliticalStatusView() {
		return politicalStatusView;
	}

	public void setPoliticalStatusView(String politicalStatusView) {
		this.politicalStatusView = politicalStatusView;
	}

	public String getDegreeView() {
		return degreeView;
	}

	public void setDegreeView(String degreeView) {
		this.degreeView = degreeView;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getCountryView() {
		return countryView;
	}

	public void setCountryView(String countryView) {
		this.countryView = countryView;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public String getNationView() {
		return nationView;
	}

	public void setNationView(String nationView) {
		this.nationView = nationView;
	}

	public Integer getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(Integer workUnit) {
		this.workUnit = workUnit;
	}

	public String getWorkUnitView() {
		return workUnitView;
	}

	public void setWorkUnitView(String workUnitView) {
		this.workUnitView = workUnitView;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalStatusView() {
		return maritalStatusView;
	}

	public void setMaritalStatusView(String maritalStatusView) {
		this.maritalStatusView = maritalStatusView;
	}

	public Date getFirstWorkDate() {
		return firstWorkDate;
	}

	public void setFirstWorkDate(Date firstWorkDate) {
		this.firstWorkDate = firstWorkDate;
	}

	public String getFirstWorkDateView() {
		return firstWorkDateView;
	}

	public void setFirstWorkDateView(String firstWorkDateView) {
		this.firstWorkDateView = firstWorkDateView;
	}

	public String getCensusRegisterView() {
		return censusRegisterView;
	}

	public void setCensusRegisterView(String censusRegisterView) {
		this.censusRegisterView = censusRegisterView;
	}

	public Integer getCensusRegister() {
		return censusRegister;
	}

	public void setCensusRegister(Integer censusRegister) {
		this.censusRegister = censusRegister;
	}

	public String getCensusProvinceCode() {
		return censusProvinceCode;
	}

	public void setCensusProvinceCode(String censusProvinceCode) {
		this.censusProvinceCode = censusProvinceCode;
	}

	public String getCensusCityCode() {
		return censusCityCode;
	}

	public void setCensusCityCode(String censusCityCode) {
		this.censusCityCode = censusCityCode;
	}

	public String getCensusAreaCode() {
		return censusAreaCode;
	}

	public void setCensusAreaCode(String censusAreaCode) {
		this.censusAreaCode = censusAreaCode;
	}

	public String getCensusAddress() {
		return censusAddress;
	}

	public void setCensusAddress(String censusAddress) {
		this.censusAddress = censusAddress;
	}

	public String getCensusZipCode() {
		return censusZipCode;
	}

	public void setCensusZipCode(String censusZipCode) {
		this.censusZipCode = censusZipCode;
	}

	public String getHomeProvinceCode() {
		return homeProvinceCode;
	}

	public void setHomeProvinceCode(String homeProvinceCode) {
		this.homeProvinceCode = homeProvinceCode;
	}

	public String getHomeCityCode() {
		return homeCityCode;
	}

	public void setHomeCityCode(String homeCityCode) {
		this.homeCityCode = homeCityCode;
	}

	public String getHomeAreaCode() {
		return homeAreaCode;
	}

	public void setHomeAreaCode(String homeAreaCode) {
		this.homeAreaCode = homeAreaCode;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomeZipCode() {
		return homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode) {
		this.homeZipCode = homeZipCode;
	}

	public String getBankProvinceCode() {
		return bankProvinceCode;
	}

	public void setBankProvinceCode(String bankProvinceCode) {
		this.bankProvinceCode = bankProvinceCode;
	}

	public String getBankCityCode() {
		return bankCityCode;
	}

	public void setBankCityCode(String bankCityCode) {
		this.bankCityCode = bankCityCode;
	}

	public String getOtherAddress() {
		return otherAddress;
	}

	public void setOtherAddress(String otherAddress) {
		this.otherAddress = otherAddress;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getOpenAddress() {
		return openAddress;
	}

	public void setOpenAddress(String openAddress) {
		this.openAddress = openAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public String getRowStatus() {
		return rowStatus;
	}

	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}

    /**
     * 获取 bankProvince
     * @return bankProvince  
     */
    public String getBankProvince() {
        return bankProvince;
    }

    /**
     * 设置 bankProvince
     * @param bankProvince 
     */
    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    /**
     * 获取 bankCity
     * @return bankCity  
     */
    public String getBankCity() {
        return bankCity;
    }

    /**
     * 设置 bankCity
     * @param bankCity 
     */
    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    
    
    

}
