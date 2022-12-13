/*
 * Copyright (C), 2014-2015, 达信财富投资管理（上海）有限公司
 * FileName: CCSConstants.java
 * Author:   chenggang
 * Date:     2015年02月11日 上午11:20:05
 * Description: 流程信息维护   
 * History: 修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.constant;

/**
 * 
 * WMS常量
 * 
 * @author chenggang
 */
public final class WMSConstants {

    public static final String ORG = "org";

    public static final String CODE = "code";

    public static final String MSG = "msg";

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * 逗号
     */
    public static final String COMMA = ",";

    public static final String HYPHEN = "-";

    /**
     * 审核拒绝
     */
    public static final int REFUSE = 2;

    /**
     * 审核通过
     */
    public static final int APPROVED = 1;

    /**
     * 未认证
     */
    public static final int UNAUTHERIZED = 1;

    /**
     * 认证中
     */
    public static final int CHECKING = 2;

    /**
     * 可编辑的认证失败
     */
    public static final int EDIT_CHECK_FAILED = 3;

    /**
     * 认证失败
     */
    public static final int CHECK_FAILED = 4;

    /**
     * 已认证
     */
    public static final int CHECK_SUCCEED = 5;

    /**
     * 账号未认证
     */
    public static final String ACCOUNT_UNAUTHERIZED = "A";

    /**
     * 账号认证中
     */
    public static final String ACCOUNT_CHECKING = "C";

    /**
     * 账号认证失败
     */
    public static final String ACCOUNT_CHECK_FAIL = "F";

    /**
     * 账号已认证
     */
    public static final String ACCOUNT_CHECK_SUCCEED = "S";

    /**
     * 质检
     */
    public static final String QUALITY_CHECK = "qualityCheck";

    /**
     * 投资审核
     */
    public static final String INVESTMENT_CHECK = "investmentCheck";

    /**
     * 匹配
     */
    public static final String MATCH = "match";

    /**
     * 债权确认
     */
    public static final String CREDITOR_CONFIRM = "creditorConfirm";

    /**
     * 出资确认
     */
    public static final String CONTRIBUTIVE_CONFIRM = "contributiveConfirm";

    /**
     * 投资确认
     */
    public static final String INVESTMENT_CONFIRM = "investmentConfirm";

    /**
     * 投资生效
     */
    public static final String INVESTMENT_SUCCESS = "success";

    /**
     * 投资失效
     */
    public static final String INVESTMENT_FAIL = "fail";

    /**
     * 重新提交
     */
    public static final String RESUBMIT = "resubmit";

    /**
     * 客户放弃
     */
    public static final String GIVEUP = "giveUp";

    /**
     * 草稿
     */
    public static final String DRAFT = "draft";

    public static final String DATE_STATUS_A = "A";

    public static final int IS_CURRENT_APPROVED = 1;

    /**
     * 理财申请下一环节的负责人
     */
    public static final String TO_USER = "toUser";

    /**
     * 理财申请下一环节标示
     */
    public static final String NEXT_STEP = "nextStep";

    /**
     * 理财申请下一环节
     */
    public static final String NEXT_STEP_NAME = "nextStepName";

    /**
     * 理财申请下一环节操作结果
     */
    public static final String NEXT_STEP_ACTION = "nextStepAction";

    /**
     * 财富投资管理中心
     */
    public static final String LCGLZX = "LCGLZX";

    public static final String NULL = "<span class='label label-danger'>待完善</span>";

    /**
     * 理财端-客户开户申请
     */
    public static final String WMS_CUST_OPEN_APPLY = "wmsCustOpenApply";

    /**
     * 理财端-客户理财申请
     */
    public static final String WMS_CUST_LENDER_APPLY = "wmsCustLenderApply";

    /**
     * 理财端-理财申请单审核
     */
    public static final String WMS_LENDER_CHECK = "wmsLenderCheck";

    /**
     * 理财端-支付凭证
     */
    public static final String WMS_PAYMENT_VOUCHERS = "wmsPaymentVouchers";

    /**
     * 记录被删除状态
     */
    public static final String DELETED = "D";

    /**
     * 投资失效
     */
    public static final String INVALID = "M";

    /**
     * 记录生效状态
     */
    public static final String EFFECTIVE = "A";

    /**
     * WMS应用代码
     */
    public static final String WMS = "WMS";

    /**
     * 省的父节点代码
     */
    public static final String ROOT = "999999";

    public static final String JPG = "jpg";

    public static final String PDF = "pdf";

    public static final String PNG = "png";

    public static final String RAR = "rar";

    /**
     * 点
     */
    public static final String POINT = ".";

    /**
     * 调用验证码
     */
    public static final String AUTH_CODE = "e10adc3949ba59abbe56e057f20f883e";

    /**
     * 会话的用户id
     */
    public static final String USER_ID = "userId";

    /**
     * 菜单
     */
    public static final String MENUS = "menus";

    /**
     * 用户常量
     */
    public static final String USER = "user";

    /**
     * 资源
     */
    public static final String RESOURCES = "resources";

    /**
     * 标题
     */
    public static final String TITLE = "title";

    /**
     * 域名-上下文
     */
    public static final String BASE_URL = "baseUrl";

    /**
     * 版本号
     */
    public static final String VERSION = "version";

    /**
     * 没有开户
     */
    public static final String NULL_CODE = "未开户";

    /**
     * 构造器
     */
    private WMSConstants() {

    }
}
