/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: BaseDao.java
 * Author:   朱道灵
 * Date:     2013年11月21日 下午2:37:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */

package com.dx.wms.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类 编号规则明细
 * 
 * @author 朱道灵
 */
@Entity(name = "t_code_rule_detail")
public class CodeRuleDetail implements Serializable {

    /**
     * serial UID
     */
    private static final long serialVersionUID = 1L;

    /** 编号规则明细-编号 主键 */
    private Long codeRuleDetailId;

    /** 编号规则明细-名称 */
    private String codeRuleDetailName;

    /** 编号规则明细-格式 */
    private String codeRuleDetailFormat;

    /**
     * 编号规则明细类型
     * 
     * :{"1":"静态值","2":"对象属性","3":"时间","4":"随机数"}
     */
    private Integer codeRuleDetailType;

    /** 编号规则明细-长度 */
    private Long codeRuleDetailSize;

    /** 编号规则明细-值 */
    private String codeRuleDetailVal;

    /** 编号规则明细-描述 */
    private String codeRuleDetailDesc;

    /** 创建者:{"-1":"系统"} */
    private Long createUser;

    /** 创建时间 */
    private Date createTime;

    /** 更新者:{"-1":"系统"} */
    private Long updateUser;

    /** 更新时间 */
    private Date updateTime;

    /** 数据状态:{"A":"已生效","D":"已删除"}； */
    private String dataStatus;

    /**
     * 功能描述: 编号规则明细编号 主键<br>
     *
     * @return the codeRuleDetailId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "code_rule_detail_id")
    public Long getCodeRuleDetailId() {
        return codeRuleDetailId;
    }

    /**
     * 功能描述: 编号规则明细-编号 <br>
     *
     * @param codeRuleDetailId the codeRuleDetailId to set.
     */
    public void setCodeRuleDetailId(Long codeRuleDetailId) {
        this.codeRuleDetailId = codeRuleDetailId;
    }

    /**
     * 功能描述: 编号规则明细-名称
     *
     * @return the codeRuleDetailName
     */
    @Column(name = "code_rule_detail_name")
    public String getCodeRuleDetailName() {
        return codeRuleDetailName;
    }

    /**
     * 功能描述: 编号规则明细-编号 <br>
     *
     * @param codeRuleDetailName the codeRuleDetailName to set.
     */
    public void setCodeRuleDetailName(String codeRuleDetailName) {
        this.codeRuleDetailName = codeRuleDetailName;
    }

    /**
     * 功能描述: 编号规则明细-格式
     *
     * @return the codeRuleDetailFormat
     */
    @Column(name = "code_rule_detail_format")
    public String getCodeRuleDetailFormat() {
        return codeRuleDetailFormat;
    }

    /**
     * 功能描述: 编号规则明细-格式
     *
     * @param codeRuleDetailFormat the codeRuleDetailFormat to set.
     */
    public void setCodeRuleDetailFormat(String codeRuleDetailFormat) {
        this.codeRuleDetailFormat = codeRuleDetailFormat;
    }

    /**
     * 功能描述: 编号规则明细类型:{"1":"静态值","2":"对象属性","3":"时间","4":"随机数"}
     *
     * @return the codeRuleDetailType
     */
    @Column(name = "code_rule_detail_type")
    public Integer getCodeRuleDetailType() {
        return codeRuleDetailType;
    }

    /**
     * 功能描述: 编号规则明细类型:{"1":"静态值","2":"对象属性","3":"时间","4":"随机数"}
     *
     * @param codeRuleDetailType the codeRuleDetailType to set.
     */
    public void setCodeRuleDetailType(Integer codeRuleDetailType) {
        this.codeRuleDetailType = codeRuleDetailType;
    }

    /**
     * 功能描述: 编号规则明细-长度
     *
     * @return the codeRuleDetailSize
     */
    @Column(name = "code_rule_detail_size")
    public Long getCodeRuleDetailSize() {
        return codeRuleDetailSize;
    }

    /**
     * 功能描述: 编号规则明细-长度
     *
     * @param codeRuleDetailSize the codeRuleDetailSize to set.
     */
    public void setCodeRuleDetailSize(Long codeRuleDetailSize) {
        this.codeRuleDetailSize = codeRuleDetailSize;
    }

    /**
     * 功能描述: 编号规则明细-值
     *
     * @return the codeRuleDetailVal
     */
    @Column(name = "code_rule_detail_val")
    public String getCodeRuleDetailVal() {
        return codeRuleDetailVal;
    }

    /**
     * 功能描述: 编号规则明细-值
     *
     * @param codeRuleDetailVal the codeRuleDetailVal to set.
     */
    public void setCodeRuleDetailVal(String codeRuleDetailVal) {
        this.codeRuleDetailVal = codeRuleDetailVal;
    }

    /**
     * 功能描述: 编号规则明细-描述
     *
     * @return the codeRuleDetailDesc
     */
    @Column(name = "code_rule_detail_desc")
    public String getCodeRuleDetailDesc() {
        return codeRuleDetailDesc;
    }

    /**
     * 功能描述: 编号规则明细-描述
     *
     * @param codeRuleDetailDesc the codeRuleDetailDesc to set.
     */
    public void setCodeRuleDetailDesc(String codeRuleDetailDesc) {
        this.codeRuleDetailDesc = codeRuleDetailDesc;
    }

    /**
     * 功能描述: 创建者:{"-1":"系统"} <br>
     *
     * @return the createUser
     */
    @Column(name = "create_user")
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 功能描述: 创建者:{"-1":"系统"} <br>
     *
     * @param createUser the createUser to set.
     */

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 功能描述: 创建时间 <br>
     *
     * @return the createTime
     */
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 功能描述: 创建时间 <br>
     *
     * @param createTime the createTime to set.
     */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 功能描述: 更新者:{"-1":"系统"}<br>
     *
     * @return the updateUser
     */
    @Column(name = "update_user")
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 功能描述: 更新者:{"-1":"系统"} <br>
     *
     * @param updateUser the updateUser to set.
     */

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 功能描述: updateTime 更新时间 <br>
     *
     * @return the updateTime
     */

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 功能描述: 更新时间 <br>
     *
     * @param updateTime the updateTime to set.
     */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 功能描述: 数据状态:{"A":"已生效","D":"已删除"}；<br>
     *
     * @return the dataStatus
     */
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * 功能描述: 数据状态:{"A":"已生效","D":"已删除"}<br>
     *
     * @param dataStatus the dataStatus to set.
     */

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
