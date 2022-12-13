/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustProfession.java
 * Author:   朱道灵
 * Date:     2015年7月19日 下午2:39:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 客户职业表
 *
 * @author 朱道灵
 */
@Entity(name = "t_cust_profession")
public class CustProfession extends BaseAccount {

    /**
     */
    private static final long serialVersionUID = -7231477968987709321L;

    /**
     * 客户职业-编号 主键
     */
    private Long custProfessionId;

    /**
     * '职业:{1:"自营业主",2:"公司职员",3:"公务员",4:"离/退休人士",5:"自由职业者"}',
     */
    private Integer profession;

    /**
     * '行业'
     */
    private String industry;

    /**
     * '行业单位名称'
     */
    private String companyName;

    /**
     * '职位'
     */
    private String post;

    /**
     * 功能描述: 主键<br>
     *
     * @return the custProfessionId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_profession_id")
    public Long getCustProfessionId() {
        return custProfessionId;
    }

    /**
     * 功能描述: 主键<br>
     *
     * @param custProfessionId the custProfessionId to set.
     * 
     */
    public CustProfession setCustProfessionId(Long custProfessionId) {
        this.custProfessionId = custProfessionId;
        return this;
    }

    /**
     * 功能描述: 职业:{1:"自营业主",2:"公司职员",3:"公务员",4:"离/退休人士",5:"自由职业者"}
     *
     * @return the profession
     */
    @Column(name = "profession")
    public Integer getProfession() {
        return profession;
    }

    /**
     * 功能描述: 职业:{1:"自营业主",2:"公司职员",3:"公务员",4:"离/退休人士",5:"自由职业者"}
     *
     * @param profession the profession to set.
     * 
     */
    public void setProfession(Integer profession) {
        this.profession = profession;
    }

    /**
     * 功能描述: 行业 <br>
     *
     * @return the industry
     */
    @Column(name = "industry")
    public String getIndustry() {
        return industry;
    }

    /**
     * 功能描述: 行业 <br>
     *
     * @param industry the industry to set.
     * 
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 功能描述: 单位名称<br>
     *
     * @return the companyName
     */
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 功能描述: 单位名称<br>
     *
     * @param companyName the companyName to set.
     * 
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 功能描述: 职位<br>
     *
     * @return the post
     */
    @Column(name = "post")
    public String getPost() {
        return post;
    }

    /**
     * 功能描述: 职位<br>
     *
     * @param post the post to set.
     * 
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 功能描述: 客户账户-编号<br>
     *
     * @param custAccountId the custAccountId to set.
     * 
     */
    public CustProfession setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
        return this;
    }
}
