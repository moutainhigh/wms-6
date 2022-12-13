package com.dx.wms.web.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dx.common.service.utils.Assert;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderCondition;
import com.dx.wms.web.detail.vo.CustAccountVo;
import com.dx.wms.web.detail.vo.CustCommVo;
import com.dx.wms.web.detail.vo.CustFinanceVo;
import com.dx.wms.web.detail.vo.CustLinkmanVo;
import com.dx.wms.web.detail.vo.CustProfessionVo;
import com.dx.wms.web.detail.vo.LenderApplyVo;
import com.dx.wms.web.detail.vo.LenderConditionVo;

/**
 * 
 * 基础实体Vo
 *
 * @author tony
 */
public class BaseEntityVo extends BaseEntitys {

    /**
     */
    private static final long serialVersionUID = 4841617696094660449L;

    /**
     * 账户信息
     */
    protected CustAccountVo accountVo;

    /**
     * 联系信息
     */
    protected CustCommVo commVo;

    /**
     * 联系人信息
     */
    protected CustLinkmanVo linkmanVo;

    /**
     * 职业信息
     */
    protected CustProfessionVo professionVo;

    /**
     * 申请信息
     */
    protected LenderApplyVo applyVo;

    /**
     * 特殊情况
     */
    protected List<LenderConditionVo> conditionVos;

    /**
     * 金融信息
     */
    protected List<CustFinanceVo> financesVos;

    /**
     * 支付信息
     */
    protected CustFinanceVo payFinanceVo;

    /**
     * 回款信息
     */
    protected CustFinanceVo refundFinanceVo;

    /**
     * 特殊额度
     */
    protected LenderConditionVo limitVo;

    /**
     * 特殊收益
     */
    protected LenderConditionVo benefitVo;
    
    public CustAccountVo getAccountVo() {
        return accountVo;
    }

    public BaseEntityVo setAccountVo(CustAccountVo accountVo) {
        this.accountVo = accountVo;
        return this;
    }

    public BaseEntityVo setAccountVo() {
        return setAccountVo(new CustAccountVo(getAccount()));
    }

    public CustCommVo getCommVo() {
        return commVo;
    }

    public BaseEntityVo setCommVo(CustCommVo commVo) {
        this.commVo = commVo;
        return this;
    }

    public BaseEntityVo setCommVo(String area) {
        if(!Assert.checkParam(getComm())){
            return setCommVo(new CustCommVo());
        }
        return setCommVo(new CustCommVo(getComm(), area));
    }

    public CustLinkmanVo getLinkmanVo() {
        return linkmanVo;
    }

    public BaseEntityVo setLinkmanVo(CustLinkmanVo linkmanVo) {
        this.linkmanVo = linkmanVo;
        return this;
    }

    public BaseEntityVo setLinkmanVo() {
        if(!Assert.checkParam(getLinkman())){
            return setLinkmanVo(new CustLinkmanVo());
        }
        return setLinkmanVo(new CustLinkmanVo(getLinkman()));
    }

    public CustProfessionVo getProfessionVo() {
        return professionVo;
    }

    public BaseEntityVo setProfessionVo(CustProfessionVo professionVo) {
        this.professionVo = professionVo;
        return this;
    }

    public BaseEntityVo setProfessionVo() {
        if(!Assert.checkParam(getProfession())){
            return setProfessionVo(new CustProfessionVo());
        }
        return setProfessionVo(new CustProfessionVo(getProfession()));
    }

    public LenderApplyVo getApplyVo() {
        return applyVo;
    }

    public BaseEntityVo setApplyVo(LenderApplyVo applyVo) {
        this.applyVo = applyVo;
        return this;
    }

    public BaseEntityVo setApplyVo(String product) {
        if (Assert.checkParam(getApply())) {
            return setApplyVo(new LenderApplyVo(getApply(), product));
        }
        return this;
    }

    public BaseEntityVo setApplyVo() {
        if (Assert.checkParam(getApply())) {
            return setApplyVo(new LenderApplyVo(getApply()));
        }
        return this;
    }

    public List<LenderConditionVo> getConditionVos() {
        return conditionVos;
    }

    public BaseEntityVo setConditionVos(List<LenderConditionVo> conditionVos) {
        this.conditionVos = conditionVos;
        return this;
    }

    public BaseEntityVo setConditionVos() {
        if (Assert.checkParam(getConditions())) {
            List<LenderConditionVo> conditionVos = new ArrayList<>();
            for (LenderCondition condition : getConditions()) {
                if (Assert.checkParam(condition.getLenderConditionCategory())) {
                    conditionVos.add(new LenderConditionVo(condition));
                }
            }
            setConditionVos(conditionVos);
        }
        return this;
    }

    public List<CustFinanceVo> getFinancesVos() {
        return financesVos;
    }

    public BaseEntityVo setFinancesVos(List<CustFinanceVo> financesVos) {
        this.financesVos = financesVos;
        return this;
    }

    public BaseEntityVo setFinancesVos(Map<Integer, String> bank,IRegionNewService regionNewService) {
        if (Assert.checkParam(getFinances())) {
            List<CustFinanceVo> financesVos = new ArrayList<>();
            for (CustFinance finance : getFinances()) {
                if (Assert.checkParam(finance.getAccountCategory())) {
                    financesVos.add(new CustFinanceVo(finance, bank,regionNewService));
                }
            }
            setFinancesVos(financesVos);
        }
        return this;
    }

    public CustFinanceVo getPayFinanceVo() {
        return payFinanceVo;
    }

    public BaseEntityVo setPayFinanceVo() {
        if (Assert.checkParam(getFinances())) {
            for (CustFinance finance : getFinances()) {
                if (Assert.equals(finance.getAccountCategory(), 1)) {
                    this.payFinanceVo = new CustFinanceVo(finance);
                }
            }
        } 
        if(!Assert.checkParam(this.payFinanceVo)){
        	this.payFinanceVo=new CustFinanceVo();
        }
        return this;
    }

    public void setPayFinanceVo(CustFinanceVo payFinanceVo) {
        this.payFinanceVo = payFinanceVo;
    }

    public CustFinanceVo getRefundFinanceVo() {
        return refundFinanceVo;
    }

    public void setRefundFinanceVo(CustFinanceVo refundFinanceVo) {
        this.refundFinanceVo = refundFinanceVo;
    }

    public BaseEntityVo setRefundFinanceVo() {
        if (Assert.checkParam(getFinances())) {
            for (CustFinance finance : getFinances()) {
                if (Assert.equals(finance.getAccountCategory(), 2)) {
                    this.refundFinanceVo = new CustFinanceVo(finance);
                }
            }
        } 
        if(!Assert.checkParam(this.refundFinanceVo)){
        	this.refundFinanceVo=new  CustFinanceVo();
        }
        return this;
    }

    public LenderConditionVo getLimitVo() {
        return limitVo;
    }

    public void setLimitVo(LenderConditionVo limitVo) {
        this.limitVo = limitVo;
    }

    public BaseEntityVo setLimitVo() {
        if (Assert.checkParam(getConditions())) {
            for (LenderCondition condition : getConditions()) {
                if (Assert.equals(condition.getLenderConditionCategory(), 2)) {
                    this.limitVo = new LenderConditionVo(condition);
                }
            }
        } 
        if(!Assert.checkParam(this.limitVo)){
        	this.limitVo=new LenderConditionVo();
        }
        return this;
    }

    public LenderConditionVo getBenefitVo() {
        return benefitVo;
    }

    public void setBenefitVo(LenderConditionVo benefitVo) {
        this.benefitVo = benefitVo;
    }

    public BaseEntityVo setBenefitVo() {
        if (Assert.checkParam(getConditions())) {
            for (LenderCondition condition : getConditions()) {
                if (Assert.equals(condition.getLenderConditionCategory(), 1)) {
                    this.benefitVo = new LenderConditionVo(condition);
                }
            }
        } 
        if(!Assert.checkParam(this.benefitVo)){
        	this.benefitVo=new LenderConditionVo();
        }
        return this;
    }
       
}
