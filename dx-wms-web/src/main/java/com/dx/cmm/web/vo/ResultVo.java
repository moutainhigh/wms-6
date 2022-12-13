package com.dx.cmm.web.vo;

import java.io.Serializable;

public class ResultVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6959545428085237489L;

    private Boolean result;

    private String msg;

    public ResultVo() {
        
    }
    public ResultVo(String msg) {
        setResult(false);
        setMsg(msg);
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
