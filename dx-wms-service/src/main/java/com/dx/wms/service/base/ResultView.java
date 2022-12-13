/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: sss.java
 * Author:   王蕊
 * Date:     2015年7月14日 下午5:21:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.base;

import java.util.Date;

import com.dx.wms.common.BaseAttrDto;

/**
 * 
 * 视图结果Dto
 * 
 * @author 王蕊
 *
 */
public class ResultView extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = 6383986447309165913L;

    /**
     * 客户编号
     */
    private Long custId;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 客户来源
     */
    private Integer custSource;

    /**
     * 客户来源其他
     */
    private String custSourceOther;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 数据状态
     */
    private String dataStatus;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    public String getCustSourceOther() {
        return custSourceOther;
    }

    public void setCustSourceOther(String custSourceOther) {
        this.custSourceOther = custSourceOther;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
