/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: BackBaseResult.java
 * Author:   朱道灵
 * Date:     2016年5月9日 上午7:50:27
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.cmm.service.back;

/**
 * 回款查询结果 基类
 *
 * @author 朱道灵
 */
public class BackBaseResult extends BackBase{

    /**
     */
    private static final long serialVersionUID = 1060399301701075077L;
    
    /**
     * 资金池编号
     */
    private Long poolId;
    
    /**
     * 主业务id
     */
    private Long fundId;
    
    /**
     * 客户姓名
     */
    private String  custName;
    
    /**
     * 身份证
     */
    private String idCard;
    
    /**
     * 出借方式
     */
    private Long productId;
    

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

   
    public Long getPoolId() {
        return poolId;
    }

  
    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    /**
     * @return the fundId
     */
    public Long getFundId() {
        return fundId;
    }

    /**
     * @param fundId the fundId to set
     */
    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }
    
}
