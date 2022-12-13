package com.dx.wms.web.vo;

import java.util.Set;

public class LenderPushDataVo {
    /** 出借申请单 */
    private long lenderApplyId;

    /** 出借编号-规则 */
    private String lenderCode;

    private String cmAction;

    private String action;

    private String payWay;

    /** 系统-编码:{"wms":"理财管理","rms":"还款管理","ccs":"信贷管理"} */
    private String appCode;

    /** 资源-标示 */
    private String resKey;

    /**
     * 交易时间
     */
    private String tradeTime;

    /**
     * 终端号
     */
    private String terminalCode;

    private Set<Long> poolIds;

    public long getLenderApplyId() {
        return lenderApplyId;
    }

    public void setLenderApplyId(long lenderApplyId) {
        this.lenderApplyId = lenderApplyId;
    }

    /**
     * @return the lenderCode
     */
    public String getLenderCode() {
        return lenderCode;
    }

    /**
     * @param lenderCode the lenderCode to set
     */
    public void setLenderCode(String lenderCode) {
        this.lenderCode = lenderCode;
    }

    /**
     * @return the cmAction
     */
    public String getCmAction() {
        return cmAction;
    }

    /**
     * @param cmAction the cmAction to set
     */
    public void setCmAction(String cmAction) {
        this.cmAction = cmAction;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the appCode
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * @param appCode the appCode to set
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * @return the resKey
     */
    public String getResKey() {
        return resKey;
    }

    /**
     * @param resKey the resKey to set
     */
    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    /**
     * @return the payWay
     */
    public String getPayWay() {
        return payWay;
    }

    /**
     * @param payWay the payWay to set
     */
    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public Set<Long> getPoolIds() {
        return poolIds;
    }

    public void setPoolIds(Set<Long> poolIds) {
        this.poolIds = poolIds;
    }


}
