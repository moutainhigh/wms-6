package com.dx.wms.service.apply;

/**
 * 
 * 理财申请服务
 *
 * @author tony
 */
public interface ILenderApplyService {

    /**
     * 
     * 功能描述: <br>
     * 根据出借编号筛选
     *
     * @param lenderCode
     * @return
     */
    LenderApplyDto query(String lenderCode);

    /**
     * 
     * 功能描述: <br>
     * 根据出借编号同步出借方式
     *
     * @param lenderCode
     * @param productId
     */
    void syncProduct(String lenderCode, Long productId);
    
    
    /**
     * 
     * 功能描述: 查询回款银行信息
     *
     * @param parent
     * @return
     */
    LenderApplyBase queryBackBank(Long lenderApplyId);
    
    /**
     * 根据续投出借编号查询原申请单信息
     * 
     * @param lenderCode
     * @return
     */
    LenderApply queryContinue(String lenderCode);

}
