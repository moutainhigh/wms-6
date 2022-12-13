package com.dx.wms.selector;

import com.dx.wms.common.BaseAttrDto;

/**
 * 
 * 结果选择器
 *
 * @author tony
 */
public class ResultSelector extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = -2710641950016066579L;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 编号
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
