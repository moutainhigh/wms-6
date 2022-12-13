/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: FamilyVo.java
 * Author:   yangbao
 * Date:     2016年1月15日 下午2:44:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.io.Serializable;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.hr.enums.RelationShip;
import com.dx.hr.service.dto.FamilyDto;
import com.dx.wms.constant.WMSConstants;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FamilyVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;
    
    /**
     *  employeeFamilyId 家庭信息ID
     */
    private Long employeeFamilyId;
    
    /**
     * 姓名
     */
    private String name;

    /** 
     * 关系
     */
    private Integer relationShip;
    
    /** 
     * 关系
     */
    private String relationShipView;

    /** 
     *  联系电话
     */
    private String mobilePhone;

    /** 
     *  工作单位(联系地址)
     */
    private String workUnit;
    
    /**
     * 
     * 删除信息id保存
     */
    private Set<Long> deleteId;
    
    public FamilyVo(FamilyDto base){
        BeanUtils.copyProperties(base, this);
        setRelationShipView(Assert.checkParam(getRelationShip())?
                RelationShip.getInfo(getRelationShip()):WMSConstants.NULL);
    }
    
    public FamilyVo(){
        
    }
    
    public FamilyVo(FamilyDto familyDto,Integer type){
    	BeanUtils.copyProperties(familyDto, this);
    	setRelationShipView(Assert.checkParam(getRelationShip())?
    			RelationShip.getInfo(getRelationShip()):WMSConstants.NULL);
    }

    public Set<Long> getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Set<Long> deleteId) {
        this.deleteId = deleteId;
    }

    public Long getEmployeeFamilyId() {
        return employeeFamilyId;
    }

    public void setEmployeeFamilyId(Long employeeFamilyId) {
        this.employeeFamilyId = employeeFamilyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(Integer relationShip) {
        this.relationShip = relationShip;
    }

    public String getRelationShipView() {
        return relationShipView;
    }

    public void setRelationShipView(String relationShipView) {
        this.relationShipView = relationShipView;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }


}
