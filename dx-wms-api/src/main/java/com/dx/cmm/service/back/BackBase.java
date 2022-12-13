/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BackBase.java
 * Author:   朱道灵
 * Date:     2016年5月9日 上午7:48:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.back;

import java.io.Serializable;

/**
 * 回款base
 *
 * @author 朱道灵
 */
public class BackBase implements Serializable {

    /**
     */
    private static final long serialVersionUID = 5471560049558963064L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 账单日
     */
    private Integer BillDay;

    public Integer getBillDay() {
        return BillDay;
    }

    public void setBillDay(Integer billDay) {
        BillDay = billDay;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

}
