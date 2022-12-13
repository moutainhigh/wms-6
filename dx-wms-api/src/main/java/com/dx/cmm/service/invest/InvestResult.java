package com.dx.cmm.service.invest;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 投资结果
 *
 * @author tony
 */
public class InvestResult extends InvestBaseResult {

    /**
     */
    private static final long serialVersionUID = 4306320125895065155L;

    /**
     * 资金池编号
     */
    private Long poolId;

    /**
     * 业务id
     */
    private Long bizId;

    /**
     * 客户编号
     */
    private String lenderCustCode;

    /**
     * 当前期数
     */
    private Integer currentPeriod;

    /**
     * 转让价值
     */
    private BigDecimal transferTotalAmount;

    /**
     * 支付对价
     */
    private BigDecimal payGiveAmount;
    
    /**
     * 支付日期
     */
    private Date payTime;

    /**
     * 支付金额
     */
    private BigDecimal payAmount;

    /**
     * 账单端口
     */
    private Integer billPort;

    /**
     * 到期时间
     */
    private Date dueTime;

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 出借编号
     */
    private String lenderCode;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 产品编号
     */
    private Long productId;
    
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 初始投资金额
     */
    private BigDecimal initTotalAmount;

    /**
     * 客户来源
     */
    private Integer custCategory;

    /**
     * 预计出借日期-起
     */
    private Date bizDateBegin;

    /**
     * 预计出借日期-止
     */
    private Date bizDateEnd;

	/**
     * 投资生效日
     */
    private Date effectTime;

    /**
     * 支付方式
     */
    private Integer payWay;

    /**
     * 划扣银行
     */
    private Integer buckleBankCategory;

    /**
     * 划扣银行支行
     */
    private String buckleSubBank;

    /**
     * 划扣银行账号
     */
    private String buckleAccountNum;

    /**
     * 划扣账户名
     */
    private String buckleAccountName;

    /**
     * 回款银行
     */
    private Integer returnBankCategory;

    /**
     * 回款银行支行
     */
    private String returnSubBank;

    /**
     * 回款银行账号
     */
    private String returnAccountNum;

    /**
     * 回款账户名
     */
    private String returnAccountName;

    /**
     * 客户地址
     */
    private String custAddress;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 团队编号
     */
    private Long teamId;

    /**
     * 客户编号
     */
    private Long managerId;

    /**
     * 营业部编号
     */
    private Long orgId;

    /**
     * 接收文件方式
     */
    private Integer msgWay;

    /**
     * email
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 账单日
     */
    private Integer billDay;

    /**
     * 匹配日期
     */
    private Date initMatchTime;


    public Long getPoolId() {
        return poolId;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public BigDecimal getTransferTotalAmount() {
        return transferTotalAmount;
    }

    public void setTransferTotalAmount(BigDecimal transferTotalAmount) {
        this.transferTotalAmount = transferTotalAmount;
    }

    public BigDecimal getPayGiveAmount() {
        return payGiveAmount;
    }

    public void setPayGiveAmount(BigDecimal payGiveAmount) {
        this.payGiveAmount = payGiveAmount;
    }

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLenderCode() {
        return lenderCode;
    }

    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    public String getLenderCustCode() {
        return lenderCustCode;
    }

    public void setLenderCustCode(String lenderCustCode) {
        this.lenderCustCode = lenderCustCode;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Integer getBillPort() {
        return billPort;
    }

    public void setBillPort(Integer billPort) {
        this.billPort = billPort;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public Date getBizDateBegin() {
        return bizDateBegin;
    }

    public void setBizDateBegin(Date bizDateBegin) {
        this.bizDateBegin = bizDateBegin;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getBillDay() {
        return billDay;
    }

    public void setBillDay(Integer billDay) {
        this.billDay = billDay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
    
    public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getCustCategory() {
		return custCategory;
	}

	public void setCustCategory(Integer custCategory) {
		this.custCategory = custCategory;
	}

	public Date getBizDateEnd() {
		return bizDateEnd;
	}

	public void setBizDateEnd(Date bizDateEnd) {
		this.bizDateEnd = bizDateEnd;
	}

	public Integer getPayWay() {
		return payWay;
	}

	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}

	public Integer getBuckleBankCategory() {
		return buckleBankCategory;
	}

	public void setBuckleBankCategory(Integer buckleBankCategory) {
		this.buckleBankCategory = buckleBankCategory;
	}

	public String getBuckleSubBank() {
		return buckleSubBank;
	}

	public void setBuckleSubBank(String buckleSubBank) {
		this.buckleSubBank = buckleSubBank;
	}

	public String getBuckleAccountNum() {
		return buckleAccountNum;
	}

	public void setBuckleAccountNum(String buckleAccountNum) {
		this.buckleAccountNum = buckleAccountNum;
	}

	public String getBuckleAccountName() {
		return buckleAccountName;
	}

	public void setBuckleAccountName(String buckleAccountName) {
		this.buckleAccountName = buckleAccountName;
	}

	public Integer getReturnBankCategory() {
		return returnBankCategory;
	}

	public void setReturnBankCategory(Integer returnBankCategory) {
		this.returnBankCategory = returnBankCategory;
	}

	public String getReturnSubBank() {
		return returnSubBank;
	}

	public void setReturnSubBank(String returnSubBank) {
		this.returnSubBank = returnSubBank;
	}

	public String getReturnAccountNum() {
		return returnAccountNum;
	}

	public void setReturnAccountNum(String returnAccountNum) {
		this.returnAccountNum = returnAccountNum;
	}

	public String getReturnAccountName() {
		return returnAccountName;
	}

	public void setReturnAccountName(String returnAccountName) {
		this.returnAccountName = returnAccountName;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Integer getMsgWay() {
		return msgWay;
	}

	public void setMsgWay(Integer msgWay) {
		this.msgWay = msgWay;
	}

	public Date getInitMatchTime() {
		return initMatchTime;
	}

	public void setInitMatchTime(Date initMatchTime) {
		this.initMatchTime = initMatchTime;
	}
}
