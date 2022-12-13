package com.dx.cmm.enums;

/**
 * 
 * 匹配推送
 *
 * @author tony
 */
public enum MatchPushCode {

    /**
     * 投资生效
     */
    INVEST_SUCCESS,

    /**
     * 投资失败
     */
    INVEST_FAIL,

    /**
     * 重新匹配
     */
    MATCH_REPEAT,

    /**
     * 投资加入
     */
    INVEST_JOIN,

    /**
     * 债权加入
     */
    CREDIT_JOIN,

    /**
     * 债权回滚
     */
    CREDIT_ROLLBACK,

    /**
     * 债权结清
     */
    CREDIT_SETTLE,

    /**
     * 投资申请变更
     */
    INVEST_APPLY_UPDATE,

    /**
     * 投资账户变更
     */
    INVEST_ACCOUNT_UPDATE,

    /**
     * 线下台账
     */
    OFFLINE_ASSETS,

    /**
     * 产品变更
     */
    PRODUCT_UPDATE,

    /**
     * 转让支付
     */
    TRANS_PAY,

    /**
     * 续投
     */
    INVEST_CONTINUE;
}
