package com.dx.op.service.intf;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * 
 * 产品服务
 *
 * @author tony
 */
public interface IProductService {
    /**
     * 
     * 功能描述: 根据应用Code 查询所属的产品列表
     *
     * @param appCode 应用Code
     * @return Map<productId,productName> 产品列表map
     */
    Map<String, String> getProductByApp(String appCode);

    /**
     * 
     * 是否为固定产品
     *
     * @param productId
     * @return
     */
    Boolean isFix(Long productId);

    BigDecimal getRateYear(Long productId, Date refDate,BigDecimal money);

    BigDecimal getRateMonth(Long productId, Date refDate,BigDecimal money);
}
