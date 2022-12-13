/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: sss.java
 * Author:   王蕊
 * Date:     2015年7月14日 下午5:21:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.base;

import java.util.Date;
import java.util.List;

import com.dx.wms.common.BaseAttrDto;

/**
 * 
 * 视图参数
 * 
 * @author 王蕊
 *
 */
public class ParamView extends BaseAttrDto {

    /**
     */
    private static final long serialVersionUID = 8888841811560730084L;

    /**
     * 注册日期-起
     */
    private Date registerTimeBegin;

    /**
     * 注册日期-止
     */
    private Date registerTimeEnd;

    /**
     * 客户编号集合
     */
    private List<String> custCodes;

    /**
     * 客户经理编号
     */
    private Long managerId;

    public ParamView() {

    }

    public ParamView(Long managerId) {
        setManagerId(managerId);
    }

    public Date getRegisterTimeBegin() {
        return registerTimeBegin;
    }

    public void setRegisterTimeBegin(Date registerTimeBegin) {
        this.registerTimeBegin = registerTimeBegin;
    }

    public Date getRegisterTimeEnd() {
        return registerTimeEnd;
    }

    public void setRegisterTimeEnd(Date registerTimeEnd) {
        this.registerTimeEnd = registerTimeEnd;
    }

    public List<String> getCustCodes() {
        return custCodes;
    }

    public void setCustCodes(List<String> custCodes) {
        this.custCodes = custCodes;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

}
