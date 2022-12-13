/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BackUsualParam.java
 * Author:   朱道灵
 * Date:     2016年5月9日 下午1:04:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.back;

/**
 * 往期回款查询
 *
 * @author 朱道灵
 */
public class BackUsualParam extends BackBaseParam{

    /**
     */
    private static final long serialVersionUID = -3008056859964789177L;

    /**
     * 出借方式
     */
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
   
}
