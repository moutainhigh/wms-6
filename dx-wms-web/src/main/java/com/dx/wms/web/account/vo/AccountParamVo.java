/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustViewApplyQueryVo.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午4:50:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.account.vo;

import java.util.Date;

import com.dx.wms.web.vo.ParamVo;

/**
 * 账户参数Vo
 *
 * @author 王蕊
 */
public class AccountParamVo extends ParamVo {
    /**
     */
    private static final long serialVersionUID = 5170466051877235845L;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 开户日期-起
     */
    private Date openDateBegin;

    /**
     * 开户日期-止
     */
    private Date openDateEnd;

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public Date getOpenDateBegin() {
        return openDateBegin;
    }

    public void setOpenDateBegin(Date openDateBegin) {
        this.openDateBegin = openDateBegin;
    }

    public Date getOpenDateEnd() {
        return openDateEnd;
    }

    public void setOpenDateEnd(Date openDateEnd) {
        this.openDateEnd = openDateEnd;
    }

}
