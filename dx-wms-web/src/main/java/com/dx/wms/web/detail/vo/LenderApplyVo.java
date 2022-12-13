package com.dx.wms.web.detail.vo;

import java.io.Serializable;
import java.text.MessageFormat;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.PayWay;
import com.dx.wms.enums.RecoveryMode;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 
 * 申请
 * 
 * @author tony
 */
public class LenderApplyVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = 977419700336135500L;

    /**
     * 出借编号-规则
     */
    private String lenderCode;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 出借方式
     */
    private String product;

    /**
     * 预计出借日期
     */
    private String expectLenderDate;

    /**
     * 出借金额
     */
    private String lenderAmount;

    /**
     * 出借金额
     */
    private String lenderAmountCn;

    /**
     * 支付方式
     */
    private String payWay;

    /**
     * 签单日期
     */
    private String signDate;

    /**
     * 回收方式
     */
    private String recovery;

    /**
     * 签约手机
     */
    private String signMobile;

    public LenderApplyVo() {

    }

    public LenderApplyVo(LenderApply base, String product) {
        setLenderCode(Assert.checkParam(base.getLenderCode()) ? base.getLenderCode() : WMSConstants.NULL);
        setContractCode(Assert.checkParam(base.getContractCode()) ? base.getContractCode() : WMSConstants.NULL);
        setProduct(Assert.checkParam(product) ? product : WMSConstants.NULL);
        String expectLenderDate = MessageFormat.format("{0} 至 {1}",
                DateUtils.formatForDay(base.getExpectLenderDateBegin(), ""),
                DateUtils.formatForDay(base.getExpectLenderDateEnd(), ""));
        setExpectLenderDate(Assert.equals(expectLenderDate.trim(), "至") ? WMSConstants.NULL : expectLenderDate);
        setLenderAmount(AmountUtils.format(base.getLenderAmount(), WMSConstants.NULL));
        String lenderAmountCn = AmountUtils.toChinese(base.getLenderAmount().toString());
        setLenderAmountCn(Assert.checkParam(lenderAmountCn) ? lenderAmountCn : WMSConstants.NULL);
        if(Assert.checkParam(base.getPayWayId())){
            setPayWay(PayWay.getInfo(base.getPayWayId().intValue(), true));
        }
        setSignDate(DateUtils.formatForDay(base.getSignDate(), WMSConstants.NULL));
        setRecovery(RecoveryMode.getInfo(base.getRecovery(), true));
        setSignMobile(Assert.checkParam(base.getSignMobile()) ? base.getSignMobile() : WMSConstants.NULL);
    }

    public LenderApplyVo(LenderApply base) {
        if(Assert.checkParam(base.getLenderAmount())){
            setLenderAmount(AmountUtils.format(base.getLenderAmount(), WMSConstants.NULL));
            String lenderAmountCn = AmountUtils.toChinese(base.getLenderAmount().toString());
            setLenderAmountCn(Assert.checkParam(lenderAmountCn) ? lenderAmountCn : WMSConstants.NULL);
        }
    }
    
    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getExpectLenderDate() {
        return expectLenderDate;
    }

    public void setExpectLenderDate(String expectLenderDate) {
        this.expectLenderDate = expectLenderDate;
    }

    public String getLenderAmount() {
        return lenderAmount;
    }

    public void setLenderAmount(String lenderAmount) {
        this.lenderAmount = lenderAmount;
    }

    public String getLenderAmountCn() {
        return lenderAmountCn;
    }

    public void setLenderAmountCn(String lenderAmountCn) {
        this.lenderAmountCn = lenderAmountCn;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }

    public String getSignMobile() {
        return signMobile;
    }

    public void setSignMobile(String signMobile) {
        this.signMobile = signMobile;
    }

}
