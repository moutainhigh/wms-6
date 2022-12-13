package com.dx.op.web.vo;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.wms.dto.LenderApplyResultDto;
import com.dx.wms.enums.StatusStep;

/**
 * 
 * 投资信息结果vo<br>
 * 投资信息结果vo
 *
 * @author tony
 */
public class InvestInfoResultVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -3762406428701719419L;

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
     * 出借方式
     */
    private String productView;

    /**
     * 出借金额
     */
    private BigDecimal lenderAmount;

    /**
     * 出借金额
     */
    private String lenderAmountView;

    /**
     * 状态
     */
    private String currentStepKey;

    /**
     * 状态
     */
    private String statusView;

    public void put(InvestInfoResultVo vo, LenderApplyResultDto dto, Map<String, String> productMap)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        PropertyUtils.copyProperties(vo, dto);
        vo.setLenderAmountView(AmountUtils.format(vo.getLenderAmount(), "-"));
        vo.setProductView(productMap.get(vo.getProductId().toString()));
        vo.setCurrentStepKey(String
                .valueOf(StatusStep.getCode(Assert.checkParam(dto.getCurrentStepKey()) ? dto.getCurrentStepKey() : "-",
                        Assert.checkParam(dto.getLastStepKey()) ? dto.getLastStepKey() : "-",
                        Assert.checkParam(dto.getCurrentAction()) ? dto.getCurrentAction() : 0)));
        vo.setStatusView(StatusStep.getInfo(Assert.checkParam(dto.getCurrentStepKey()) ? dto.getCurrentStepKey() : "-",
                Assert.checkParam(dto.getLastStepKey()) ? dto.getLastStepKey() : "-",
                Assert.checkParam(dto.getCurrentAction()) ? dto.getCurrentAction() : 0));
    }

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

    public String getProductView() {
        return productView;
    }

    public void setProductView(String productView) {
        this.productView = productView;
    }

    public BigDecimal getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(BigDecimal lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public String getLenderAmountView() {
        return lenderAmountView;
    }

    public void setLenderAmountView(String lenderAmountView) {
        this.lenderAmountView = lenderAmountView;
    }

    public String getCurrentStepKey() {
        return currentStepKey;
    }

    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    public String getStatusView() {
        return statusView;
    }

    public void setStatusView(String statusView) {
        this.statusView = statusView;
    }

}
