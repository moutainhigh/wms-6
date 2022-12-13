package com.dx.wms.service.saver;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.dx.common.service.utils.Assert;
import com.dx.wms.common.BaseEntitys;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.detail.ResultDetail;

/**
 * 
 * 结果存储器
 *
 * @author tony
 */
public class ResultSaver extends BaseEntitys {

    /**
     */
    private static final long serialVersionUID = -7412724901881545588L;

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
    
    /**
     * 错误代码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;

    public ResultSaver(){
        
    }
    
    public ResultSaver(CustAccount account) {
        setAccount(account);
    }

    public ResultSaver(CustComm comm) {
        setComm(comm);
    }

    public ResultSaver(CustLinkman linkMan) {
        setLinkman(linkman);
    }

    public void put(ResultDetail detail) {
        BeanUtils.copyProperties(detail, this);
    }

    public String getTitle() {
        return title;
    }

    public ResultSaver setTitle(String title) {
        this.title = title;
        return this;
    }

    public ResultSaver setTitle(ParamSaver param) {
        return setTitle(param.getType().getTitle());
    }

    public List<TabSaver> getTabs() {
        return tabs;
    }

    public ResultSaver setTabs(List<TabSaver> tabs) {
        this.tabs = tabs;
        return this;
    }

    public ResultSaver setTabs(ParamSaver param) {
        return setTabs(param.getType().getTabs());
    }

    public Integer getWidth() {
        return width;
    }

    public ResultSaver setWidth(ParamSaver param) {
        if (!Assert.checkParam(getTabs())) {
            setTabs(param);
        }
        this.width = 12 / getTabs().size();
        return this;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
