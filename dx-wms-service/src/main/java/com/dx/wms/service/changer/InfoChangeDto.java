/*
 * Copyright (C), 2014-2015, 达信财富投资管理（上海）有限公司
 * FileName: InfoChangeDto.java
 * Author:   yangbao
 * Date:     2015年12月30日 下午8:55:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.changer;

import com.dx.ccs.vo.OrgVo;

/**
 * 变更Dto
 *
 * @author yangbao
 */
public class InfoChangeDto {
    
    /**
     * 出借方式
     */
    private String productName;

    private Long productId;
    /**
     * 营业部
     */
    private String department;
    /**
     * 客户经理
     */
    private String custManager;
    /**
     * 团队
     */
    private OrgVo teamVo;
    /**
     * 大团
     */
    private OrgVo clusterVo;
    /**
     * 当前状态
     */
    private String currentStep;

    public InfoChangeDto(Long productId,String productName, String department, String custManager, OrgVo teamVo, OrgVo clusterVo,
            String currentStep) {
    	setProductId(productId);
        setProductName(productName);
        setDepartment(department);
        setCustManager(custManager);
        setClusterVo(clusterVo);
        setCurrentStep(currentStep);
        setTeamVo(teamVo);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 出借方式
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 出借方式
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 营业部
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 营业部
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 客户经理
     */
    public String getCustManager() {
        return custManager;
    }

    /**
     * 客户经理
     */
    public void setCustManager(String custManager) {
        this.custManager = custManager;
    }

    /**
     * 团队
     */
    public OrgVo getTeamVo() {
        return teamVo;
    }

    /**
     * 团队
     */
    public void setTeamVo(OrgVo teamVo) {
        this.teamVo = teamVo;
    }

    /**
     * 大团
     */
    public OrgVo getClusterVo() {
        return clusterVo;
    }

    /**
     * 大团
     */
    public void setClusterVo(OrgVo clusterVo) {
        this.clusterVo = clusterVo;
    }

    /**
     * 当前状态
     */
    public String getCurrentStep() {
        return currentStep;
    }

    /**
     * 当前状态
     */
    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

}
