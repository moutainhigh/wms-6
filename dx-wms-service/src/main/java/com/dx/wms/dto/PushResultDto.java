package com.dx.wms.dto;

import java.io.Serializable;

public class PushResultDto implements Serializable {

    /** Serial UID */
    private static final long serialVersionUID = 1L;

    /** 数据处理结果 0:成功 1:失败 */
    private Integer result;

    /** 失败原因　 */
    private String remark;

    public PushResultDto(Integer result, String remark) {
        this.result = result;
        this.remark = remark;
    }
    public PushResultDto(Integer result) {
        this.result = result;
    }
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
