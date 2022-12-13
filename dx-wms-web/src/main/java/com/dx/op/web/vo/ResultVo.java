package com.dx.op.web.vo;

import java.io.Serializable;

/**
 * 
 * 执行结果vo<br>
 * 执行结果vo
 *
 * @author tony
 */
public class ResultVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4136054444322080875L;

    /**
     * 执行结果
     */
    private Boolean result;

    /**
     * 执行信息
     */
    private String msg;

    public ResultVo() {
        setResult(true);
        setMsg("操作成功");
    }

    public ResultVo(String msg) {
        setResult(false);
        this.msg = msg;
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
