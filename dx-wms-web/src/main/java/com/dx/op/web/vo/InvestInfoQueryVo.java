package com.dx.op.web.vo;

import java.io.Serializable;

/**
 * 
 * 投资信息查询vo<br>
 * 投资信息查询vo
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class InvestInfoQueryVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2009920404392924693L;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 出借方式
     */
    private Long productId;

    /**
     * 状态
     */
    private String currentStepKey;

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

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

    public String getCurrentStepKey() {
        return currentStepKey;
    }

    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

}
