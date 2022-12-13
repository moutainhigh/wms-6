package com.dx.wms.service.account.dto;

import java.util.Date;

import com.dx.wms.common.BaseAttrDto;

/**
 * 账户结果
 *
 * @author 王蕊
 */
public class ResultAccount extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = 4085691508638423576L;

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
     * 状态
     */
    private String dataStatus;

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

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

}
