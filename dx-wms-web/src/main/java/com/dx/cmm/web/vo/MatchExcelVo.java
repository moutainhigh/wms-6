package com.dx.cmm.web.vo;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.dx.cmm.service.dto.MatchExcelDto;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.enums.BaseAccountCategory;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
public class MatchExcelVo {

    /**
     * 序号
     */
    private Integer index;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 出借方式
     */
    private String lenderWay;

    /**
     * 封闭期（月）
     */
    private Integer initPeriod;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 支付方式
     */
    private String payWay;

    /**
     * 划扣银行
     */
    private String bank;

    /**
     * 划扣账号
     */
    private String account;

    /**
     * 付款日期
     */
    private String payDateView;

    public MatchExcelVo() {

    }

    public MatchExcelVo(MatchExcelDto dto, Map<String, String> productMap, Integer index) {
        try {
            PropertyUtils.copyProperties(this, dto);
            setLenderWay(productMap.get(dto.getProductId().toString()));
            setPayWay(BaseAccountCategory.getInfo(Integer.valueOf(dto.getPayway())));
            setBank(dto.getBank() + dto.getSubbank());
            setPayDateView(DateUtils.formatForDay(dto.getPayDate(), ""));
            setIndex(index);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

        }
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

    public String getLenderWay() {
        return lenderWay;
    }

    public void setLenderWay(String lenderWay) {
        this.lenderWay = lenderWay;
    }

    public Integer getInitPeriod() {
        return initPeriod;
    }

    public void setInitPeriod(Integer initPeriod) {
        this.initPeriod = initPeriod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPayDateView() {
        return payDateView;
    }

    public void setPayDateView(String payDateView) {
        this.payDateView = payDateView;
    }

}
