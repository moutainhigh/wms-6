/*
 * Copyright (C), 2014-2016, 达信财富投资管理（上海）有限公司
 * FileName: WMSBizQueryByStatusDto.java
 * Author:   FlaTa
 * Date:     2016年4月6日 下午3:00:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dx.framework.dal.pagination.Pagination;

/**
 * 〈一句话功能简述〉理财业务查询条件Dto<br>
 * 〈功能详细描述〉
 *
 * @author 蒋玉涛
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LenderQueryDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 10806518368759996L;

    /**
     * 状态
     */
    private List<Long> formStatus;

    /**
     * 姓名
     */
    private String custName;

    /**
     * 证件号
     */
    private String idCard;

    /**
     * 到期日起
     */
    private Date dueDateBegin;

    /**
     * 到期日止
     */
    private Date dueDateEnd;

    /**
     * 分页信息
     */
    private Pagination pagination;

    /**
     * 获取 formStatus
     * 
     * @return formStatus
     */
    public List<Long> getFormStatus() {
        return formStatus;
    }

    /**
     * 设置 formStatus
     * 
     * @param formStatus
     */
    public void setFormStatus(List<Long> formStatus) {
        this.formStatus = formStatus;
    }

    /**
     * 获取 custName
     * 
     * @return custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 设置 custName
     * 
     * @param custName
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * 获取 idCard
     * 
     * @return idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置 idCard
     * 
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getDueDateBegin() {
        return dueDateBegin;
    }

    public void setDueDateBegin(Date dueDateBegin) {
        this.dueDateBegin = dueDateBegin;
    }

    public Date getDueDateEnd() {
        return dueDateEnd;
    }

    public void setDueDateEnd(Date dueDateEnd) {
        this.dueDateEnd = dueDateEnd;
    }

    /**
     * 获取 pagination
     * 
     * @return pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * 设置 pagination
     * 
     * @param pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
