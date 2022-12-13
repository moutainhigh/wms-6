package com.dx.wms.web.select.controller.vo;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.IdType;
import com.dx.wms.enums.Sex;
import com.dx.wms.selector.ResultSelector;
import com.dx.wms.web.vo.BaseAttrVo;

/**
 * 
 * 结果选择器Vo
 *
 * @author tony
 */
public class ResultSelectorVo extends BaseAttrVo {

    /**
     */
    private static final long serialVersionUID = 4572764287435689685L;

    /**
     * 证件类型
     */
    private Integer idType;

    /**
     * 证件类型
     */
    private String idTypeView;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 性别
     */
    private String sexView;

    /**
     * 编号
     */
    private Long id;

    /**
     * 编码
     */
    private String code;

    public ResultSelectorVo() {

    }

    public ResultSelectorVo(ResultSelector base) {
        BeanUtils.copyProperties(base, this);
        setIdCard().setSexView().setIdTypeView();
    }

    public ResultSelectorVo setIdCard() {
        setIdCard(Assert.checkParam(getIdCard()) ? getIdCard() : WMSConstants.NULL);
        return this;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdTypeView() {
        return idTypeView;
    }

    public void setIdTypeView(String idTypeView) {
        this.idTypeView = idTypeView;
    }

    public ResultSelectorVo setIdTypeView(Integer idType) {
        this.idTypeView = IdType.getInfo(idType, true);
        return this;
    }

    public ResultSelectorVo setIdTypeView() {
        return setIdTypeView(getIdType());
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexView() {
        return sexView;
    }

    public void setSexView(String sexView) {
        this.sexView = sexView;
    }

    public ResultSelectorVo setSexView(Integer sex) {
        this.sexView = Sex.getInfo(sex, true);
        return this;
    }

    public ResultSelectorVo setSexView() {
        return setSexView(getSex());
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
