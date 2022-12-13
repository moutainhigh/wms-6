/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustAccountApplyVo.java
 * Author:   王蕊
 * Date:     2015年7月20日 下午5:34:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.web.account.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.AmountUtils;
import com.dx.common.service.utils.Assert;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.apply.entity.LenderCondition;
import com.dx.wms.service.changer.ChangeLog;
import com.dx.wms.web.detail.vo.CustAccountVo;
import com.dx.wms.web.detail.vo.CustCommVo;
import com.dx.wms.web.detail.vo.CustFinanceVo;
import com.dx.wms.web.detail.vo.CustLinkmanVo;
import com.dx.wms.web.detail.vo.CustProfessionVo;
import com.dx.wms.web.detail.vo.LenderApplyVo;
import com.dx.wms.web.detail.vo.LenderConditionVo;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 王蕊
 */
public class CustAccountApplyVo implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 7301980375335576835L;

    /**
     * 客户账户表 实体类
     */
    private CustAccount custAccount;
    
    /**
     * 客户账户VO
     */
    private CustAccountVo custAccountVo;
    
    /**
     * 客户职业表 实体表
     */
    private CustProfession custProfession;
    
    /**
     * 客户职业VO
     */
    private CustProfessionVo custProfessionVo;

    /**
     * 客户通讯表 实体表
     */
    private CustComm custComm;
    
    /**
     * 客户通讯表 实体表
     */
    private CustCommVo custCommVo;

    /**
     * 客户联系人 实体表
     */
    private CustLinkman custLinkman;
    
    /**
     * 客户联系人VO
     */
    private CustLinkmanVo custLinkmanVo;

    /**
     * 客户金融表 实体表 汇款
     */
    private List<CustFinance> custFinances;
    
    /**
     * 客户金融VO 汇款
     */
    private List<CustFinanceVo> custFinanceVos;

    /**
     * 理财申请特殊情况表
     */
    private List<LenderCondition> lenderConditions;
    
    /**
     * 理财申请特殊情况表
     */
    private List<LenderConditionVo> lenderConditionVos;

    /**
     * 操作人信息
     */
    private Long actionUserId;

    /**
     * 理财申请
     */
    private LenderApply lenderApply;
    
    /**
     * 理财申请VO
     */
    private LenderApplyVo lenderApplyVo;

    /**
     * 账户信息
     */
    private Integer bankInfo;

    /**
     * 是否有特殊收益
     */
    private Integer isIncome;

    /**
     * 最新状态
     */
    private String currentStepKey;

    /**
     * 大写金额
     */
    private String biglenderAmount;

    /**
     * 日志
     */
    private List<ChangeLog> logs;
    
    /**
     * 支行状态
     */
    private Integer subBankStatus;

    public CustAccountApplyVo() {

    }

    public CustAccountApplyVo(CustAccount custAccount, CustProfession custProfession, CustComm custComm,
            CustLinkman custLinkman, Long actionUserId, List<CustFinance> custFinances, LenderApply lenderApply,
            Integer bankInfo, Integer isIncome, List<LenderCondition> lenderConditions) {
        super();
        this.setCustAccount(custAccount);
        this.setCustProfession(custProfession);
        this.setCustComm(custComm);
        this.setCustLinkman(custLinkman);
        this.actionUserId = actionUserId;
        this.lenderApply = lenderApply;
        this.bankInfo = bankInfo;
        this.isIncome = isIncome;
        this.lenderConditions = lenderConditions;
    }

    public CustAccountApplyVo(CustAccountApplyDto dto) {
        BeanUtils.copyProperties(dto, this);
        // 大写金额
        if (Assert.checkParam(dto.getLenderApply().getLenderAmount())) {
            setBiglenderAmount(AmountUtils.toChinese(dto.getLenderApply().getLenderAmount().toString()));
        } else {
            setBiglenderAmount("零");
        }
    }
    
    public CustAccountApplyVo(CustAccountApplyDto dto,String area,Map<Integer, String> bank,String product,IRegionNewService regionNewService) {
        BeanUtils.copyProperties(dto, this);
        // 大写金额
        if (Assert.checkParam(dto.getLenderApply().getLenderAmount())) {
            setBiglenderAmount(AmountUtils.toChinese(dto.getLenderApply().getLenderAmount().toString()));
            setLenderApplyVo(new LenderApplyVo(dto.getLenderApply(), product));
        } else {
            setBiglenderAmount("零");
        }
        if(Assert.checkParam(dto.getCustAccount())){
    		setCustAccountVo(new CustAccountVo(dto.getCustAccount()));
    	}
        if(Assert.checkParam(dto.getCustProfession())){
        	setCustProfessionVo(new CustProfessionVo(dto.getCustProfession()));
        }
        if(Assert.checkParam(dto.getCustLinkman())){
        	setCustLinkmanVo(new CustLinkmanVo(dto.getCustLinkman()));
        }
        
        if(Assert.checkParam(dto.getCustComm())){
        	setCustCommVo(new CustCommVo(dto.getCustComm(),area));
        }
        
        if(Assert.checkParam(dto.getCustFinances())){
        	custFinanceVos=new ArrayList<CustFinanceVo>();
        	for(CustFinance custFinance:dto.getCustFinances()){
        	    if(null != custFinance.getBankCategory()){
        	        custFinanceVos.add(new CustFinanceVo(custFinance, bank,regionNewService));
        	    }
        	}
        	setCustFinanceVos(custFinanceVos);
        }
        
        if(Assert.checkParam(dto.getLenderConditions())){
        	lenderConditionVos=new ArrayList<LenderConditionVo>();
        	for(LenderCondition lenderCondition:dto.getLenderConditions()){
        		lenderConditionVos.add(new LenderConditionVo(lenderCondition));
        	}
        	setLenderConditionVos(lenderConditionVos);
        }
    }
    

    
    /**
     * 客户账户表
     */
    public CustAccount getCustAccount() {
        return custAccount;
    }

    /**
     * 客户账户表
     */
    public void setCustAccount(CustAccount custAccount) {
        this.custAccount = custAccount;
    }

    public CustAccountVo getCustAccountVo() {
		return custAccountVo;
	}

	public void setCustAccountVo(CustAccountVo custAccountVo) {
		this.custAccountVo = custAccountVo;
	}

	/**
     * 职业表
     */
    public CustProfession getCustProfession() {
        return custProfession;
    }

    /**
     * 职业表
     */
    public void setCustProfession(CustProfession custProfession) {
        this.custProfession = custProfession;
    }
    
    
    /**
     * 职业VO
     */
    public CustProfessionVo getCustProfessionVo() {
		return custProfessionVo;
	}
    
    /**
     * 职业VO
     */
	public void setCustProfessionVo(CustProfessionVo custProfessionVo) {
		this.custProfessionVo = custProfessionVo;
	}

	/**
     * 客户通讯表
     */
    public CustComm getCustComm() {
        return custComm;
    }

    /**
     * 客户通讯表
     */
    public void setCustComm(CustComm custComm) {
        this.custComm = custComm;
    }
    
    /**
     * 客户通讯VO
     */
    public CustCommVo getCustCommVo() {
		return custCommVo;
	}
    
    /**
     * 客户通讯VO
     */
	public void setCustCommVo(CustCommVo custCommVo) {
		this.custCommVo = custCommVo;
	}

	/**
     * 紧急联系人
     */
    public CustLinkman getCustLinkman() {
        return custLinkman;
    }

    /**
     * 紧急联系人
     */
    public void setCustLinkman(CustLinkman custLinkman) {
        this.custLinkman = custLinkman;
    }
    
    
    /**
     * 紧急联系人VO
     */
    public CustLinkmanVo getCustLinkmanVo() {
		return custLinkmanVo;
	}
    
    /**
     * 紧急联系人VO
     */
	public void setCustLinkmanVo(CustLinkmanVo custLinkmanVo) {
		this.custLinkmanVo = custLinkmanVo;
	}

	/**
     * 出借申请表
     */
    public LenderApply getLenderApply() {
        return lenderApply;
    }

    /**
     * 出借申请表
     */
    public void setLenderApply(LenderApply lenderApply) {
        this.lenderApply = lenderApply;
    }
    
    /**
     * 出借申请VO
     */
    public LenderApplyVo getLenderApplyVo() {
		return lenderApplyVo;
	}

    /**
     * 出借申请VO
     */
	public void setLenderApplyVo(LenderApplyVo lenderApplyVo) {
		this.lenderApplyVo = lenderApplyVo;
	}

	/**
     * 是否有特殊收益
     */
    public Integer getIsIncome() {
        return isIncome;
    }

    /**
     * 是否有特殊收益
     */
    public void setIsIncome(Integer isIncome) {
        this.isIncome = isIncome;
    }

    /**
     * 账户信息
     */
    public Integer getBankInfo() {
        return bankInfo;
    }

    /**
     * 账户信息
     */
    public void setBankInfo(Integer bankInfo) {
        this.bankInfo = bankInfo;
    }

    /**
     * 当前行为标示
     */
    public String getCurrentStepKey() {
        return currentStepKey;
    }

    /**
     * 当前行为标示
     */
    public void setCurrentStepKey(String currentStepKey) {
        this.currentStepKey = currentStepKey;
    }

    /**
     * 出借金额
     */
    public String getBiglenderAmount() {
        return biglenderAmount;
    }

    /**
     * 出借金额
     */
    public void setBiglenderAmount(String biglenderAmount) {
        this.biglenderAmount = biglenderAmount;
    }

    /**
     * 客户金融表
     */
    public List<CustFinance> getCustFinances() {
        return custFinances;
    }

    /**
     * 客户金融表
     */
    public void setCustFinances(List<CustFinance> custFinances) {
        this.custFinances = custFinances;
    }
    
    /**
     * 客户金融VO
     */
    public List<CustFinanceVo> getCustFinanceVos() {
		return custFinanceVos;
	}

    /**
     * 客户金融VO
     */
	public void setCustFinanceVos(List<CustFinanceVo> custFinanceVos) {
		this.custFinanceVos = custFinanceVos;
	}

	/**
     * 理财申请特殊情况表
     */
    public List<LenderCondition> getLenderConditions() {
        return lenderConditions;
    }

    /**
     * 理财申请特殊情况表
     */
    public void setLenderConditions(List<LenderCondition> lenderConditions) {
        this.lenderConditions = lenderConditions;
    }
    
    /**
     * 理财申请特殊情况VO
     */
    public List<LenderConditionVo> getLenderConditionVos() {
		return lenderConditionVos;
	}

    /**
     * 理财申请特殊情况VO
     */
	public void setLenderConditionVos(List<LenderConditionVo> lenderConditionVos) {
		this.lenderConditionVos = lenderConditionVos;
	}

	/**
     * 操作人Id
     */
    public Long getActionUserId() {
        return actionUserId;
    }

    /**
     * 操作人Id
     */
    public void setActionUserId(Long actionUserId) {
        this.actionUserId = actionUserId;
    }

    /**
     * 日志
     */
    public List<ChangeLog> getLogs() {
        return logs;
    }

    /**
     * 日志
     */
    public void setLogs(List<ChangeLog> logs) {
        this.logs = logs;
    }
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *支行状态
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public Integer getSubBankStatus() {
		return subBankStatus;
	}

	public void setSubBankStatus(Integer subBankStatus) {
		this.subBankStatus = subBankStatus;
	}
    
    

}
