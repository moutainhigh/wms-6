/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: Student.java
 * Author:   朱道灵
 * Date:     2015年7月22日 下午2:23:10
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.test.dao;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 朱道灵
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Student {

    /** 主键ID */
    private Long custId;

    /** 客户编号 */
    private String custCode;

    /** 客户姓名 */
    private String custName;

    /** 证件类型 */
    private Integer idType;

    /** 证件号码 */
    private String IdCard;

    /** 手机号码 */
    private String mobile;

    /** 性别 */
    private Integer sex2;

    /** 客户来源 */
    private Integer custSource;

    /** 客户来源其他 */
    private String custSourceOther;

    /** 创建时间 */
    private Date createTime;

    /** 创建人 */
    private Long createUser;

    /** 更新时间 */
    private Date updateTime;

    /** 更新人 */
    private Long updateUser;

    /** 数据状态 */
    private String dataStatus;
    
    private String dateStatus2;

    private Integer aa ;
    public Integer getAa() {
        return aa;
    }

    public void setAa(Integer aa) {
        this.aa = aa;
    }

    public String getDateStatus2() {
        return dateStatus2;
    }

    public void setDateStatus2(String dateStatus2) {
        this.dateStatus2 = dateStatus2;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
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

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    

    public Integer getSex2() {
        return sex2;
    }

    public void setSex2(Integer sex2) {
        this.sex2 = sex2;
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

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }
}
