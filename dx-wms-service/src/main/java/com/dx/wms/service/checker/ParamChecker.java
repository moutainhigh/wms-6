/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustInfoCheckDto.java
 * Author:   王蕊
 * Date:     2015年7月22日 下午8:28:29
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.checker;

import com.dx.wms.common.BaseAttrDto;

/**
 * 校验参数
 *
 * @author 王蕊
 */
public class ParamChecker extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = -4298581336543674033L;

    /**
     * 客户编号
     */
    private Long custId;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 续投ID编号
     */
    private Long parentId;

    /** 理财申请ID编号 */
    private Long lenderApplyId;
    
    public ParamChecker(Long custId, String param, Boolean isCard) {
        setCustId(custId);
        if (isCard) {
            setIdCard(param);
        } else {
            setMobile(param);
        }
    }

    public ParamChecker() {

    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /** 合同编号 */
    public String getContractCode() {
        return contractCode;
    }

    /** 合同编号 */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /** 客户编号 */
    public Long getCustId() {
        return custId;
    }

    /** 客户编号 */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(Long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

}
