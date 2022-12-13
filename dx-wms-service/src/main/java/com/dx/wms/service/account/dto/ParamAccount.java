package com.dx.wms.service.account.dto;

import java.util.Date;

import com.dx.wms.common.BaseAttrDto;

/**
 * 账户参数
 *
 * @author 王蕊
 */
public class ParamAccount extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = 1929988277731276870L;

    /**
     * 开户日期-起
     */
    private Date openDateBegin;

    /**
     * 开户日期-止
     */
    private Date openDateEnd;

    /**
     * 客户经理编号
     */
    private Long managerId;

    public ParamAccount() {

    }

    public ParamAccount(Long managerId) {
        setManagerId(managerId);
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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

}
