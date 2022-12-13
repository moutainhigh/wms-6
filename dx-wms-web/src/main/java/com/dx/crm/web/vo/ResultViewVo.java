/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustViewResultVo.java
 * Author:   王蕊
 * Date:     2015年7月15日 下午5:43:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.crm.web.vo;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.CustSource;
import com.dx.wms.enums.IdType;
import com.dx.wms.enums.Sex;
import com.dx.wms.service.base.CustBase;
import com.dx.wms.service.base.ResultView;
import com.dx.wms.web.vo.ResultVo;

/**
 * 视图结果Vo
 *
 * @author 王蕊
 */
public class ResultViewVo extends ResultVo {

    /**
     */
    private static final long serialVersionUID = 3564953789461863384L;

    /**
     * 客户编号
     */
    private Long custId;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件类型
     */
    private String idTypeView;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 性别
     */
    private String sexView;

    /**
     * 客户来源
     */
    private Integer custSource;

    /**
     * 客户来源
     */
    private String custSourceView;

    /**
     * 客户来源其他
     */
    private String custSourceOther;

    /**
     * 注册日期
     */
    private Date registerTime;

    /**
     * 注册日期
     */
    private String registerTimeView;

    /**
     * 数据状态
     */
    private String dataStatus;

    /**
     * 客户视图对象
     */
    private CustBase base;

    public ResultViewVo() {

    }

    public ResultViewVo(ResultView result) {
        BeanUtils.copyProperties(result, this);
        setIdCard(Assert.checkParam(getIdCard()) ? getIdCard() : WMSConstants.NULL);
        setCustName(Assert.checkParam(getCustName()) ? getCustName() : WMSConstants.NULL);
        setMobile(Assert.checkParam(getMobile()) ? getMobile() : WMSConstants.NULL);
        setIdTypeView().setSexView().setCustSourceView().setRegisterTimeView();
    }

    public void put(CustBase custBase) {
        BeanUtils.copyProperties(custBase, this);
        setIdCard(Assert.checkParam(getIdCard()) ? getIdCard() : WMSConstants.NULL);
        setCustName(Assert.checkParam(getCustName()) ? getCustName() : WMSConstants.NULL);
        setMobile(Assert.checkParam(getMobile()) ? getMobile() : WMSConstants.NULL);
        setIdTypeView().setSexView().setCustSourceView().setRegisterTimeView();
    }

    public String getCustSourceOther() {
        return custSourceOther;
    }

    public void setCustSourceOther(String custSourceOther) {
        this.custSourceOther = custSourceOther;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdTypeView() {
        return idTypeView;
    }

    public ResultViewVo setIdTypeView(Integer idType) {
        this.idTypeView = IdType.getInfo(idType, true);
        return this;
    }

    public ResultViewVo setIdTypeView() {
        return setIdTypeView(getIdType());
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexView() {
        return sexView;
    }

    public ResultViewVo setSexView(Integer sex) {
        this.sexView = Sex.getInfo(sex, true);
        return this;
    }

    public ResultViewVo setSexView() {
        return setSexView(getSex());
    }

    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    public String getCustSourceView() {
        return custSourceView;
    }

    public ResultViewVo setCustSourceView() {
    	if(Assert.checkParam(getCustSource())){
    		this.custSourceView = Assert.equals(getCustSource(), CustSource.OTHER.getCode())
                    ? "其他(" + getCustSourceOther() + ")" : CustSource.getInfo(getCustSource(), true);
    	}
        return this;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterTimeView() {
        return registerTimeView;
    }

    public CustBase getBase() {
        return base;
    }

    public void setBase(CustBase base) {
        this.base = base;
    }

    public ResultViewVo setRegisterTimeView(Date registerTime) {
        this.registerTimeView = DateUtils.formatForDay(registerTime, WMSConstants.NULL);
        return this;
    }

    public ResultViewVo setRegisterTimeView() {
        return setRegisterTimeView(getRegisterTime());
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
