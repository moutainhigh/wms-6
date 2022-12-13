package com.dx.wms.web.detail.vo;



import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.AccountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.enums.AccountCategery;
import com.dx.wms.enums.BankCategery;
import com.dx.wms.service.apply.entity.CustFinance;

/**
 * 
 * 金融信息
 *
 * @author tony
 */
public class CustFinanceVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -8388746160017392374L;

    /**
     * 客户金融-编号
     */
    private Long custFinanceId;
    
    /**
     * 户名
     */
    private String accountName;

    /**
     * 开户银行
     */
    private String bankCategory;

    /**
     * 支行
     */
    private String subBank;

    /**
     * 账号
     */
    private String accountNum;

    /**
     * 账号类别
     */
    private String accountCategory;

    /**
     * 通讯地址-省区域-编码:{"NNNNNN"}
     */
    private String provinceRegionCode;
    
    /*
     * 省
     */
    private String provinceRegionView;
    
    /**
     * 通讯地址-市区域-编码:{"NNNNNN"}
     */
    private String cityRegionCode;
    
    /*
     * 市
     */
    private String cityRegionView;
    
    public CustFinanceVo(CustFinance base, Map<Integer, String> bank,IRegionNewService regionNewService) {
        setAccountCategory(AccountCategery.getTitle(base.getAccountCategory()));
        setAccountName(Assert.checkParam(base.getAccountName()) ? base.getAccountName() : WMSConstants.NULL);
        setBankCategory(BankCategery.getInfo(Assert.checkParam(base.getBankCategory())?Integer.parseInt(base.getBankCategory()):null));
        String subBank = Assert.checkParam(base.getSubBank())
                ? MessageFormat.format("{0}{1}", bank.get(base.getAccountCategory()), base.getSubBank())
                : WMSConstants.NULL;
        setSubBank(subBank);
        setAccountNum(AccountUtils.formate(base.getAccountNum(), WMSConstants.NULL));
        setProvinceRegionView(Assert.checkParam(base.getProvinceRegionCode()) ? regionNewService.getRegionNameByCode(base.getProvinceRegionCode()) : WMSConstants.NULL);
        setCityRegionView(Assert.checkParam(base.getCityRegionCode()) ? regionNewService.getRegionNameByCode(base.getCityRegionCode()) : WMSConstants.NULL);
	}
    
    public CustFinanceVo(CustFinance base) {
        BeanUtils.copyProperties(base, this);
    }

    public CustFinanceVo() {
        
    }

    public Long getCustFinanceId() {
        return custFinanceId;
    }

    public void setCustFinanceId(Long custFinanceId) {
        this.custFinanceId = custFinanceId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankCategory() {
        return bankCategory;
    }

    public void setBankCategory(String bankCategory) {
        this.bankCategory = bankCategory;
    }

    public String getSubBank() {
        return subBank;
    }

    public void setSubBank(String subBank) {
        this.subBank = subBank;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(String accountCategory) {
        this.accountCategory = accountCategory;
    }

    public String getProvinceRegionCode() {
        return provinceRegionCode;
    }

    public void setProvinceRegionCode(String provinceRegionCode) {
        this.provinceRegionCode = provinceRegionCode;
    }

    public String getCityRegionCode() {
        return cityRegionCode;
    }

    public void setCityRegionCode(String cityRegionCode) {
        this.cityRegionCode = cityRegionCode;
    }

	public String getProvinceRegionView() {
		return provinceRegionView;
	}

	public void setProvinceRegionView(String provinceRegionView) {
		this.provinceRegionView = provinceRegionView;
	}

	public String getCityRegionView() {
		return cityRegionView;
	}

	public void setCityRegionView(String cityRegionView) {
		this.cityRegionView = cityRegionView;
	}
}

