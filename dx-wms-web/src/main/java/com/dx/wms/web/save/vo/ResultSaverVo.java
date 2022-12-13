package com.dx.wms.web.save.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.apply.entity.LenderCondition;
import com.dx.wms.service.saver.ResultSaver;
import com.dx.wms.service.saver.TabSaver;
import com.dx.wms.web.detail.vo.CustFinanceVo;
import com.dx.wms.web.detail.vo.LenderConditionVo;
import com.dx.wms.web.vo.BaseEntityVo;

/**
 * 
 * 结果保存器Vo
 *
 * @author tony
 */
public class ResultSaverVo extends BaseEntityVo {

    /**
     */
    private static final long serialVersionUID = 8716724465983692883L;

    /**
     * 标题
     */
    private String title;

    /**
     * 板块信息
     */
    private List<TabSaver> tabs;

    /**
     * 宽度
     */
    private Integer width;
    
    public ResultSaverVo(){
    	
    }

    public ResultSaverVo(ResultSaver result,String area) {
        BeanUtils.copyProperties(result, this);
        setAccountVo();
        if (!Assert.checkParam(result.getProfession())) {
            setProfession(new CustProfession());
        }
        if (!Assert.checkParam(result.getComm())) {
            setComm(new CustComm());
        }
        if (!Assert.checkParam(result.getLinkman())) {
            setLinkman(new CustLinkman());
        }
        if (!Assert.checkParam(result.getApply())) {
            setApply(new LenderApply());
        }
        if (!Assert.checkParam(result.getFinances())) {
            setFinances(new ArrayList<CustFinance>());
            setPayFinanceVo(new CustFinanceVo(new CustFinance()));
            setRefundFinanceVo(new CustFinanceVo(new CustFinance()));
        } 

        if (!Assert.checkParam(result.getConditions())) {
            setConditions(new ArrayList<LenderCondition>());
            setLimitVo(new LenderConditionVo());
            setBenefitVo(new LenderConditionVo());
        }
        // 已开户
        if (Assert.checkParam(result.getAccount().getLenderCustCode())) {
            setProfessionVo();
            setCommVo(area);
            setLinkmanVo();
            setApplyVo();
            setPayFinanceVo();
            setRefundFinanceVo();
            setLimitVo();
            setBenefitVo();
        }
    }
    
	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TabSaver> getTabs() {
        return tabs;
    }

    public void setTabs(List<TabSaver> tabs) {
        this.tabs = tabs;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
