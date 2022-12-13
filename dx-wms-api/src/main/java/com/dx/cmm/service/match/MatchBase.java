package com.dx.cmm.service.match;

import java.io.Serializable;

public class MatchBase implements Serializable {

    /**
     */
    private static final long serialVersionUID = -8375805261305273519L;
    
    /**
     * 产品类型
     */
    private Long productId;
    
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
