/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: EmployeeTempletVo.java
 * Author:   yangbao
 * Date:     2016年1月21日 下午3:50:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.web.hr.vo;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.dx.hr.enums.CertType;
import com.dx.hr.enums.JobCategory;
import com.dx.hr.enums.SexType;

/**
 * 〈一句话功能简述〉下载模板的vo
 * 〈功能详细描述〉
 *
 * @author yangbao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class EmployeeTempletVo {
    

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private String[] sexList;

    /**
     * 证件类型
     */
    private String[] certTypeList;

    /**
     * 证件号码
     */
    private String certNo;

    /**
     * 岗位职务
     */
    private String positionName;
    
    /**
     * 岗位级别
     */
    private String[] levelList;
    
    /**
     * 组织
     */
    private String[] orgList;
    
    /**
     * 工作性质
     */
    private String[] jobCategory;

    /**
     * 试用期基本工资
     */
    private String proBasicSalary;

    /**
     * 试用期绩效工资
     */
    private String proPerformanceSalary;

    /**
     * 转正后基本工资
     */
    private String regularBasicSalary;

    /**
     * 转正后绩效工资
     */
    private String regularPerformanceSalary;

    /**
     * 计划入职日期
     */
    private Date plannedEntryDate;

    public EmployeeTempletVo() {
        
    };

    public void put(EmployeeTempletVo temVo) {
        //性别
        Map<String, String> sexMap = SexType.getMap();
        String[] sexList = new String[] {};
        String sex = "";
        Iterator<Map.Entry<String, String>> it = sexMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            sex += entry.getValue() + ",";
        }
        sexList = sex.split(",");
        temVo.setSexList(sexList);
        temVo.setCertNo("");
        //证件类型
        Map<String, String> certTypeList = CertType.getMap();
        String[] certTypeContent = new String[] {};
        String idType = "";
        Iterator<Map.Entry<String, String>> id = certTypeList.entrySet().iterator();
        while (id.hasNext()) {
            Map.Entry<String, String> entry = id.next();
            idType += entry.getValue() + ",";
        }
        certTypeContent = idType.split(",");
        //工作性质
        Map<String,String> jobMap = JobCategory.getMap();
        String[] jobList = new String[]{};
        String job="";
        Iterator<Map.Entry<String, String>> jobCatagory = jobMap.entrySet().iterator();
        while(jobCatagory.hasNext()){
            Map.Entry<String, String> entry = jobCatagory.next();
            job+=entry.getValue()+",";
        }
        jobList=job.split(",");
        temVo.setJobCategory(jobList);
        temVo.setCertTypeList(certTypeContent);
        temVo.setName("");
        temVo.setProBasicSalary("");
        temVo.setProPerformanceSalary("");
        temVo.setRegularBasicSalary("");
        temVo.setRegularPerformanceSalary("");
        temVo.setPlannedEntryDate(new Date());
    }

    public String[] getLevelList() {
        return levelList;
    }

    public void setLevelList(String[] levelList) {
        this.levelList = levelList;
    }

    public String[] getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String[] jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String[] getOrgList() {
        return orgList;
    }

    public void setOrgList(String[] orgList) {
        this.orgList = orgList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCertTypeList() {
        return certTypeList;
    }

    public void setCertTypeList(String[] certTypeList) {
        this.certTypeList = certTypeList;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getProBasicSalary() {
        return proBasicSalary;
    }

    public void setProBasicSalary(String proBasicSalary) {
        this.proBasicSalary = proBasicSalary;
    }

    public String getProPerformanceSalary() {
        return proPerformanceSalary;
    }

    public void setProPerformanceSalary(String proPerformanceSalary) {
        this.proPerformanceSalary = proPerformanceSalary;
    }

    public String getRegularBasicSalary() {
        return regularBasicSalary;
    }

    public void setRegularBasicSalary(String regularBasicSalary) {
        this.regularBasicSalary = regularBasicSalary;
    }

    public String getRegularPerformanceSalary() {
        return regularPerformanceSalary;
    }

    public void setRegularPerformanceSalary(String regularPerformanceSalary) {
        this.regularPerformanceSalary = regularPerformanceSalary;
    }

    public String[] getSexList() {
        return sexList;
    }

    public void setSexList(String[] sexList) {
        this.sexList = sexList;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Date getPlannedEntryDate() {
        return plannedEntryDate;
    }

    public void setPlannedEntryDate(Date plannedEntryDate) {
        this.plannedEntryDate = plannedEntryDate;
    }

}
