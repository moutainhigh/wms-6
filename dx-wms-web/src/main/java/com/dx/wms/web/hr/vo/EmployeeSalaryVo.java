/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: EmployeeSalaryVo.java
 * Author:   yangbao
 * Date:     2016年3月2日 下午5:22:02
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EmployeeSalaryVo implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;

    /** employeeSalaryId 薪资信息ID */
    private Long employeeSalaryId;

    /** employeeId 员工ID */
    private Long employeeId;

    /** proBasicSalary 试用期基本工资 */
    private BigDecimal proBasicSalary;

    /** proPerformanceSalary 试用期绩效工资 */
    private BigDecimal proPerformanceSalary;

    /** regularBasicSalary 转正后基本工资 */
    private BigDecimal regularBasicSalary;

    /** regularPerformanceSalary 转正后绩效工资 */
    private BigDecimal regularPerformanceSalary;

    /** createTime 创建时间 */
    private Date createTime;

    /** createUser 创建人 */
    private Long createUser;

    /** updateTime 更新时间 */
    private Date updateTime;

    /** updateUser 更新人 */
    private Long updateUser;

    /** dataStatus 删除D；草稿F；生效A； */
    private String dataStatus;
    
    public EmployeeSalaryVo(){
        
    }

    public Long getEmployeeSalaryId() {
        return employeeSalaryId;
    }

    public void setEmployeeSalaryId(Long employeeSalaryId) {
        this.employeeSalaryId = employeeSalaryId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getProBasicSalary() {
        return proBasicSalary;
    }

    public void setProBasicSalary(BigDecimal proBasicSalary) {
        this.proBasicSalary = proBasicSalary;
    }

    public BigDecimal getProPerformanceSalary() {
        return proPerformanceSalary;
    }

    public void setProPerformanceSalary(BigDecimal proPerformanceSalary) {
        this.proPerformanceSalary = proPerformanceSalary;
    }

    public BigDecimal getRegularBasicSalary() {
        return regularBasicSalary;
    }

    public void setRegularBasicSalary(BigDecimal regularBasicSalary) {
        this.regularBasicSalary = regularBasicSalary;
    }

    public BigDecimal getRegularPerformanceSalary() {
        return regularPerformanceSalary;
    }

    public void setRegularPerformanceSalary(BigDecimal regularPerformanceSalary) {
        this.regularPerformanceSalary = regularPerformanceSalary;
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
