/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: CodeRuleVersionDetailDto.java
 * Author:   蔡登勇
 * Date:     2015年7月16日 下午9:29:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dto;

import org.apache.commons.lang3.StringUtils;

import com.dx.wms.constant.CodeRuleConstants;
import com.dx.wms.service.exception.CodeRuleIPIsErrorException;

/**
 * 编号规则明细DTO
 *
 * @author 蔡登勇
 */
public class CodeRuleVersionDetailDto {
    /** codeRuleDetailId 主键 */
    private Long codeRuleDetailId;

    /** codeRuleDetailName 编号规则明细-名称 */
    private String codeRuleDetailName;

    /** codeRuleDetailFormat 编号规则明细-格式 */
    private String codeRuleDetailFormat;

    /**
     * codeRuleDetailType 编号规则明细类型
     * 
     * :{"1":"静态值","2":"对象属性","3":"时间","4":"随机数"}
     */
    private Integer codeRuleDetailType;

    /** codeRuleDetailSize 编号规则明细-长度 */
    private Integer codeRuleDetailSize;

    /** codeRuleDetailVal 编号规则明细-值 */
    private String codeRuleDetailVal;

    /** codeRuleDetailDesc 编号规则明细-描述 */
    private String codeRuleDetailDesc;

    /** codeVersionDetailIndex 编号规则版本明细-顺位 */
    private Integer codeVersionDetailIndex;

    public Long getCodeRuleDetailId() {
        return codeRuleDetailId;
    }

    public void setCodeRuleDetailId(Long codeRuleDetailId) {
        this.codeRuleDetailId = codeRuleDetailId;
    }

    public String getCodeRuleDetailName() {
        return codeRuleDetailName;
    }

    public void setCodeRuleDetailName(String codeRuleDetailName) {
        this.codeRuleDetailName = codeRuleDetailName;
    }

    public String getCodeRuleDetailFormat() {
        return codeRuleDetailFormat;
    }

    public void setCodeRuleDetailFormat(String codeRuleDetailFormat) {
        this.codeRuleDetailFormat = codeRuleDetailFormat;
    }

    public Integer getCodeRuleDetailType() {
        return codeRuleDetailType;
    }

    public void setCodeRuleDetailType(Integer codeRuleDetailType) {
        this.codeRuleDetailType = codeRuleDetailType;
    }

    public Integer getCodeRuleDetailSize() {
        return codeRuleDetailSize;
    }

    public void setCodeRuleDetailSize(Integer codeRuleDetailSize) {
        this.codeRuleDetailSize = codeRuleDetailSize;
    }

    public String getCodeRuleDetailVal() {
        return codeRuleDetailVal;
    }

    public void setCodeRuleDetailVal(String codeRuleDetailVal) {
        this.codeRuleDetailVal = codeRuleDetailVal;
    }

    public String getCodeRuleDetailDesc() {
        return codeRuleDetailDesc;
    }

    public void setCodeRuleDetailDesc(String codeRuleDetailDesc) {
        this.codeRuleDetailDesc = codeRuleDetailDesc;
    }

    public Integer getCodeVersionDetailIndex() {
        return codeVersionDetailIndex;
    }

    public void setCodeVersionDetailIndex(Integer codeVersionDetailIndex) {
        this.codeVersionDetailIndex = codeVersionDetailIndex;
    }

    public static CodeRuleVersionDetailDto checkCodeRuleVersionDetailDto(
            CodeRuleVersionDetailDto codeRuleVersionDetailDto) {
        if (codeRuleVersionDetailDto.getCodeRuleDetailType() <= 0
                || codeRuleVersionDetailDto.getCodeRuleDetailType() > 5) {
            throw new CodeRuleIPIsErrorException("规则类型有误");
        }
        if (codeRuleVersionDetailDto.getCodeVersionDetailIndex() <= 0) {
            throw new CodeRuleIPIsErrorException("排序信息错误");
        }
        if (codeRuleVersionDetailDto.getCodeRuleDetailType() == CodeRuleConstants.DATE_TYPE
                && StringUtils.isBlank(codeRuleVersionDetailDto.getCodeRuleDetailFormat())) {
            throw new CodeRuleIPIsErrorException("日期型 数据格式错误");
        }
        if (StringUtils.isBlank(codeRuleVersionDetailDto.getCodeRuleDetailVal())) {
            throw new CodeRuleIPIsErrorException("编号规则明细-值 不能为空");
        }
        if (codeRuleVersionDetailDto.getCodeRuleDetailType() == CodeRuleConstants.RANDOM_TYPE
                && codeRuleVersionDetailDto.getCodeRuleDetailSize() > 9) {
            throw new CodeRuleIPIsErrorException("随机数最大支持9位");
        }
        if (codeRuleVersionDetailDto.getCodeRuleDetailSize() <= 0) {
            throw new CodeRuleIPIsErrorException("编号规则明细-值 不能为空");
        }

        if (codeRuleVersionDetailDto.getCodeRuleDetailType() == CodeRuleConstants.OBJECT_TYPE
                && !codeRuleVersionDetailDto.getCodeRuleDetailVal().contains(
                        CodeRuleConstants.OBJECT_TYPE_DETAIL_VALUE_SEPARATOR)) {
            throw new CodeRuleIPIsErrorException("对象类型配置信息有误");
        }
        return codeRuleVersionDetailDto;
    }
}
