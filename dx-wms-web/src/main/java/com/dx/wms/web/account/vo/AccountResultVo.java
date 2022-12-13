/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountApplyResultVo.java
 * Author:   王蕊
 * Date:     2015年7月19日 下午4:18:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.account.vo;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.DateUtils;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.AccountStatus;
import com.dx.wms.service.account.dto.ResultAccount;
import com.dx.wms.web.vo.ResultVo;

/**
 * 账户结果Vo
 *
 * @author 王蕊
 */
public class AccountResultVo extends ResultVo {

    /**
     */
    private static final long serialVersionUID = -660964283870013574L;

    /**
     * 客户账户-编号
     */
    private Long custAccountId;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 开户日期
     */
    private Date openDate;

    /**
     * 开户日期
     */
    private String openDateView;

    /**
     * 状态
     */
    private String dataStatus;

    /**
     * 账户状态
     */
    private String dataStatusView;

    public AccountResultVo() {

    }

    public AccountResultVo(ResultAccount result) {
        BeanUtils.copyProperties(result, this);
        setOpenDateView().setDataStatusView();
    }

    public Long getCustAccountId() {
        return custAccountId;
    }

    public void setCustAccountId(Long custAccountId) {
        this.custAccountId = custAccountId;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getOpenDateView() {
        return openDateView;
    }

    public AccountResultVo setOpenDateView(Date openDate) {
        this.openDateView = DateUtils.formatForDay(openDate, WMSConstants.NULL);
        return this;
    }

    public AccountResultVo setOpenDateView() {
        return setOpenDateView(getOpenDate());
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDataStatusView() {
        return dataStatusView;
    }

    public AccountResultVo setDataStatusView(String dataStatus) {
        this.dataStatusView = AccountStatus.getView(dataStatus, true);
        return this;
    }

    public AccountResultVo setDataStatusView() {
        return setDataStatusView(getDataStatus());
    }

}
