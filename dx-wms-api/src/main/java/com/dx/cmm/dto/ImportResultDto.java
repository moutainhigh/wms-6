package com.dx.cmm.dto;

import java.io.Serializable;

public class ImportResultDto implements Serializable {

    /**
     */
    private static final long serialVersionUID = 2856450591990183105L;

    private Integer total;

    private Integer error;

    private Integer success;

    private String msg;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
