/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustViewQueryVo.java
 * Author:   王蕊
 * Date:     2015年7月15日 下午5:42:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.crm.web.vo;

import java.util.Date;

import com.dx.wms.web.vo.ParamVo;

/**
 * 视图参数Vo
 *
 * @author 王蕊
 */
public class ParamViewVo extends ParamVo {

    /**
     */
    private static final long serialVersionUID = 733361006243741643L;

    /**
     * 注册日期-起
     */
    private Date registerTimeBegin;

    /**
     * 注册日期-止
     */
    private Date registerTimeEnd;
    
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

}
