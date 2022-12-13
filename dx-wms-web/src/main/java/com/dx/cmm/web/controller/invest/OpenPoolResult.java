package com.dx.cmm.web.controller.invest;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.ccs.service.IAMService;
import com.dx.cmm.service.invest.InvestResult;
import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.enums.CustCategery;
import com.dx.wms.enums.MsgWay;
import com.dx.wms.enums.PayWay;
import com.dx.wms.enums.Sex;
import com.dx.wms.service.apply.ILenderApplyService;
import com.dx.wms.service.apply.LenderApplyBase;
import com.dx.wms.service.apply.LenderApplyDto;

public class OpenPoolResult extends Result {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8073531287572672192L;

	/**
     */
    
    private static final String ZERO = "0.00";

    /**
     * 申请日期
     */
    private Date applyDate;

    /**
     * 申请日视图
     */
    private String applyDateView;

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
    private String sexView;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 出借方式
     */
    private String productName;

    /**
     * 出借id
     */
    private Long productId;

    /**
     * 出借金额
     */
    private BigDecimal initTotalAmount;

    /**
     * 出借金额视图
     */
    private String initTotalAmountView;

    /**
     * 客户分类
     */
    private Integer custCategory;

    /**
     * 客户分类视图
     */
    private String custCategoryView;

    /**
     * 预计出借日期起
     */
    private Date bizDateBegin;

    /**
     * 预计出借日期止
     */
    private Date bizDateEnd;

    /**
     * 预计出借日期视图
     */
    private String lenderDateView;
    
    /**
     * 投资生效日
     */
    private Date effectTime;
    
    /**
     * 投资生效日
     */
    private String effectTimeView;
    
    /**
     * 支付方式
     */
    private Integer payWay;

    /**
     * 支付方式视图
     */
    private String payWayView;

    /**
     * 划扣银行
     */
    private Integer buckleBankCategory;

    /**
     * 划扣银行视图
     */
    private String buckleBankCategoryView;

    /**
     * 划扣支行
     */
    private String buckleSubBank;

    /**
     * 划扣帐户
     */
    private String buckleAccountNum;

    /**
     * 划扣姓名(账户名)
     */
    private String buckleAccountName;

    /**
     * 回款银行
     */
    private Integer returnBankCategory;

    /**
     * 回款银行视图
     */
    private String returnBankCategoryView;

    /**
     * 回款支行
     */
    private String returnSubBank;

    /**
     * 回款帐户
     */
    private String returnAccountNum;

    /**
     * 回款姓名（账户名）
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
     * 团队主管
     */
    private Long teamId;

    /**
     * 团队主管视图
     */
    private String teamView;

    /**
     * 客户经理id
     */
    private Long managerId;

    /**
     * 客户经理视图
     */
    private String managerView;

    /**
     * 区域
     */
    private String area;

    /**
     * 接受文件方式
     */
    private Integer msgWay;

    /**
     * 接受文件方式视图
     */
    private String msgWayView;

    /**
     * 营业部id
     */
    private Long orgId;

    /**
     * 营业部视图
     */
    private String orgIdView;

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
    
    /**
     * 匹配日期视图
     */
    private String initMatchTimeView;

    public OpenPoolResult() {

    }

    public OpenPoolResult(InvestResult invest, ILenderApplyService lenderApplyService, IAMService amService,
            final Map<Long, String> product) {
        BeanUtils.copyProperties(invest, this);
        setInitTotalAmountView(AmountUtils.format(invest.getInitTotalAmount(),ZERO));
        setDateView();
        LenderApplyDto apply = lenderApplyService.query(invest.getLenderCode());
        if (Assert.checkParam(apply)) {
            BeanUtils.copyProperties(apply, this);
            if(Assert.checkParam(apply.getParentId())){
                LenderApplyBase base = lenderApplyService.queryBackBank(apply.getLenderApplyId());
                BeanUtils.copyProperties(base, this);
                setBuckleBankCategoryView(Assert.checkParam(getBuckleBankCategory()) ? MessageFormat.format("{0}{1}", BankCategery.getInfo(getBuckleBankCategory()), getBuckleSubBank()) : "-");
                setPayWayView(PayWay.getInfo(getPayWay(), false));
            }
            setSexView(Sex.getInfo(getSex(), true));
            setCustCategoryView(CustCategery.getInfo(getCustCategory(), true));
            setPayWayView(PayWay.getInfo(getPayWay(), false));
            setOrgIdView(amService.queryOrgById(getOrgId()).getName());
            setTeamView(amService.queryOrgById(getTeamId()).getName());
            setManagerView(Assert.checkParam(amService.queryUserById(getManagerId())) ? amService.queryUserById(getManagerId()).getName() : "-");
            setBuckleBankCategoryView(Assert.checkParam(getBuckleBankCategory()) ? MessageFormat.format("{0}{1}", BankCategery.getInfo(getBuckleBankCategory()), getBuckleSubBank()) : "-");
            setReturnBankCategoryView(MessageFormat.format("{0}{1}", BankCategery.getInfo(getReturnBankCategory()), getReturnSubBank()));
            setMsgWayView(MsgWay.getInfo(getMsgWay(), true));
            setArea(amService.queryOrgById(getOrgId()).getCityRegionName());
            setLenderDateView(MessageFormat.format("{0} 至  {1}", DateUtils.formatForDay(getBizDateBegin()),
                    DateUtils.formatForDay(getBizDateEnd())));
            setApplyDateView(DateUtils.formatForDay(getApplyDate()));
            setEffectTimeView(DateUtils.formatForDay(getEffectTime()));
            setInitMatchTimeView(DateUtils.formatForDay(getInitMatchTime()));
            setBuckleAccountNum(Assert.checkParam(getBuckleAccountNum()) ? getBuckleAccountNum() : "-");
            setBuckleAccountName(Assert.checkParam(getBuckleAccountName()) ? getBuckleAccountName() : "-");
        }
    }

    public String getBuckleAccountName() {
        return buckleAccountName;
    }

    public void setBuckleAccountName(String buckleAccountName) {
        this.buckleAccountName = buckleAccountName;
    }

    public String getReturnAccountName() {
        return returnAccountName;
    }

    public void setReturnAccountName(String returnAccountName) {
        this.returnAccountName = returnAccountName;
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

    public BigDecimal getInitTotalAmount() {
        return initTotalAmount;
    }

    public void setInitTotalAmount(BigDecimal initTotalAmount) {
        this.initTotalAmount = initTotalAmount;
    }

    public String getInitTotalAmountView() {
        return initTotalAmountView;
    }

    public void setInitTotalAmountView(String initTotalAmountView) {
        this.initTotalAmountView = initTotalAmountView;
    }

    public Integer getCustCategory() {
        return custCategory;
    }

    public void setCustCategory(Integer custCategory) {
        this.custCategory = custCategory;
    }

    public Date getBizDateBegin() {
        return bizDateBegin;
    }

    public void setBizDateBegin(Date bizDateBegin) {
        this.bizDateBegin = bizDateBegin;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getMsgWay() {
        return msgWay;
    }

    public void setMsgWay(Integer msgWay) {
        this.msgWay = msgWay;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getSexView() {
        return sexView;
    }

    public void setSexView(String sexView) {
        this.sexView = sexView;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCustCategoryView() {
        return custCategoryView;
    }

    public void setCustCategoryView(String custCategoryView) {
        this.custCategoryView = custCategoryView;
    }

    public String getPayWayView() {
        return payWayView;
    }

    public void setPayWayView(String payWayView) {
        this.payWayView = payWayView;
    }

    public String getOrgIdView() {
        return orgIdView;
    }

    public void setOrgIdView(String orgIdView) {
        this.orgIdView = orgIdView;
    }

    public String getTeamView() {
        return teamView;
    }

    public void setTeamView(String teamView) {
        this.teamView = teamView;
    }

    public String getManagerView() {
        return managerView;
    }

    public void setManagerView(String managerView) {
        this.managerView = managerView;
    }

    public String getReturnBankCategoryView() {
        return returnBankCategoryView;
    }

    public void setReturnBankCategoryView(String returnBankCategoryView) {
        this.returnBankCategoryView = returnBankCategoryView;
    }

    public String getBuckleBankCategoryView() {
        return buckleBankCategoryView;
    }

    public void setBuckleBankCategoryView(String buckleBankCategoryView) {
        this.buckleBankCategoryView = buckleBankCategoryView;
    }

    public String getMsgWayView() {
        return msgWayView;
    }

    public void setMsgWayView(String msgWayView) {
        this.msgWayView = msgWayView;
    }

    public String getApplyDateView() {
        return applyDateView;
    }

    public void setApplyDateView(String applyDateView) {
        this.applyDateView = applyDateView;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getBizDateEnd() {
        return bizDateEnd;
    }

    public void setBizDateEnd(Date bizDateEnd) {
        this.bizDateEnd = bizDateEnd;
    }

    public Integer getBuckleBankCategory() {
        return buckleBankCategory;
    }

    public void setBuckleBankCategory(Integer buckleBankCategory) {
        this.buckleBankCategory = buckleBankCategory;
    }

    public Integer getReturnBankCategory() {
        return returnBankCategory;
    }

    public void setReturnBankCategory(Integer returnBankCategory) {
        this.returnBankCategory = returnBankCategory;
    }

    /**
     * @return the lenderDateView
     */
    public String getLenderDateView() {
        return lenderDateView;
    }

    /**
     * @param lenderDateView the lenderDateView to set
     */
    public void setLenderDateView(String lenderDateView) {
        this.lenderDateView = lenderDateView;
    }

	public Date getInitMatchTime() {
		return initMatchTime;
	}

	public void setInitMatchTime(Date initMatchTime) {
		this.initMatchTime = initMatchTime;
	}

	public String getInitMatchTimeView() {
		return initMatchTimeView;
	}

	public void setInitMatchTimeView(String initMatchTimeView) {
		this.initMatchTimeView = initMatchTimeView;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}

	public String getEffectTimeView() {
		return effectTimeView;
	}

	public void setEffectTimeView(String effectTimeView) {
		this.effectTimeView = effectTimeView;
	}

}
