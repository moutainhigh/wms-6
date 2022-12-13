package com.dx.wms.service;

import java.util.List;
import java.util.Map;

import com.dx.wms.dto.ProductDto;
import com.dx.wms.dto.ProductQueryDto;

/**
 * 
 * 产品服务
 *
 * @author tony
 */
public interface IProductService {

    /**
     * 
     * 功能描述: 根据应用Code 父产品Id查询所属的产品列表
     *
     * @param appCode 应用Code
     * @param productId 父产品Id 传-1代表查询1级产品
     * @throws ObjectIsNullException 对象为空
     * @return Map<productId,productName> 产品列表map
     */
    Map<String, String> getProductByAppAndProductId(String appCode, Long productId);
    

   
    Map<String, String> getAllProductByApp(String appCode,Boolean isOperant);
    
    Map<String, String> getUsualProductByApp(String appCode);
    
    Map<String, String> getTransProductByApp(String appCode);

    /**
     * 
     * 功能描述: <br>
     * 根据应用筛选
     *
     * @param app
     * @return
     */
    Map<Long, String> query(String app);

    /**
     * 
     * 功能描述: <br>
     * 全部
     *
     * @return
     */
    Map<Long, String> queryAll();

    /**
     * 
     * 功能描述: 通过产品Id查询产品对象
     * 
     * @param appCode 应用Code
     * @param productId 产品Id
     * @return 产品对象
     */
    ProductDto queryByProductId(String appCode, Long productId);

    /**
     * 
     * 功能描述:根据应用Code 查询所属的产品列表
     *
     * @param appCode 应用Code
     * @return 产品列表
     */
    List<ProductDto> queryByApp(String appCode);

    /**
     * 
     * 功能描述: 根据QueryDto查询所属的产品列表
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<ProductDto> queryByDtos(ProductQueryDto productQueryDto);

}
