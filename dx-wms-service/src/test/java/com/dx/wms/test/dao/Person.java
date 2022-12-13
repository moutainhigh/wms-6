/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: Person.java
 * Author:   朱道灵
 * Date:     2015年7月22日 下午2:16:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.test.dao;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 朱道灵
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Person {

    /**  主键ID */
    private Long custId;
    
    /**  客户编号 */
    private String custCode;
    
    /**  客户姓名 */
    private String custName;
    
    /**  证件类型 */ 
    private String idType;
    
    /**  证件号码 */ 
    private String IdCard;
    
    /**  手机号码 */ 
    private String mobile;
    
    /**  性别 */ 
    private String sex2;
    
    /**  客户来源 */ 
    private String custSource;
    
    /**  客户来源其他 */ 
    private String custSourceOther;
    
    /**  创建时间 */
    private String createTime;

    /**  创建人 */
    private String createUser;

    /**  更新时间 */
    private String updateTime;

    /**  更新人 */
    private String updateUser;

    /**  数据状态 */
    private String dataStatus;

    private String dateStatus3;
    

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

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
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

    

    public String getSex2() {
        return sex2;
    }

    public void setSex2(String sex2) {
        this.sex2 = sex2;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustSourceOther() {
        return custSourceOther;
    }

    public void setCustSourceOther(String custSourceOther) {
        this.custSourceOther = custSourceOther;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDateStatus3() {
        return dateStatus3;
    }

    public void setDateStatus3(String dateStatus3) {
        this.dateStatus3 = dateStatus3;
    }

}
