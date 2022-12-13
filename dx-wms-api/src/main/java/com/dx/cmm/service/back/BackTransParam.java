/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BackTransParam.java
 * Author:   朱道灵
 * Date:     2016年5月9日 下午12:26:37
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.back;

import java.util.Date;

import javax.xml.crypto.Data;

/**
 * 到期回款查询
 *
 * @author 朱道灵
 */
public class BackTransParam extends BackBaseParam {

    /**
     */
    private static final long serialVersionUID = -1440338618108174613L;

    /**
     * 出借方式
     */
    private Long productId;
    
    /*
     * 转让日期-起
     */
    private Date transTimeBegin;
    
    /*
     * 转让日期-止
     */
    private Date transTimeEnd;
    
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

	public Date getTransTimeBegin() {
		return transTimeBegin;
	}

	public void setTransTimeBegin(Date transTimeBegin) {
		this.transTimeBegin = transTimeBegin;
	}

	public Date getTransTimeEnd() {
		return transTimeEnd;
	}

	public void setTransTimeEnd(Date transTimeEnd) {
		this.transTimeEnd = transTimeEnd;
	}

}
