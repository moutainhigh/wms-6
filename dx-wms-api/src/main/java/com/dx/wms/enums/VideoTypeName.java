/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: VideoTypeName.java
 * Author:   黄健
 * Date:     2015年7月15日 下午4:53:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 影像分类名枚举类
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum VideoTypeName {

    /**
     * 客户申请书
     */
    CLIENT_APPLICATION(65,"客户申请书"),
    
    /**
     * 理财方案推荐协议书
     */
    REC_RELEASED_FINANCIAL_SOLUTIONS(66,"理财方案推荐协议书"),
    
    /**
     * 身份证
     */
    ID_CARD(67,"身份证"),
    
    /**
     * 银行卡
     */
    BANK_NUMBER(68,"银行卡"),
    
    /**
     * 个人出借咨询服务协议
     */
    PERSONAL_LENDING_CONSULTING_SERVICES_AGREEMENT(69,"个人出借咨询服务协议"),
    
    /**
     * 委托扣款授权书
     */
    PRINCIPAL_DEBIT_AUTHORIZATION(70,"委托扣款授权书"),
    
    /**
     * 变更申请书
     */
    APPLICATION_CHANGE_FILE(71,"变更申请书"),
    
    /**
     * 支付凭证
     */
    PAYMENT_VOUCHERS(72,"支付凭证"),
 
    /**
     * 回执拒绝
     */
    RE_MATCH(73,"回执拒绝");
    /**
     * 常量值
     */
    private int code;

    /**
     * 内容
     */
    private String info;

    /**
     * 
     * @param code 常量值
     * @param value 内容
     */
    VideoTypeName(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取枚举
     *
     * @param code 常量值
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static VideoTypeName getEunm(Integer code) {
        if (code == null) {
            return null;
        }
        for (VideoTypeName clientFrom : VideoTypeName.values()) {
            if (clientFrom.getCode() == (code)) {
                return clientFrom;
            }
        }
        return null;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据常量值获取内容
     *
     * @param code 常量值
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getInfo(Integer code) {
        VideoTypeName clientFrom = getEunm(code);
        return clientFrom == null ? "" : clientFrom.getInfo();
    }

    public static Map<String, String> getMap() {
        Map<String, String> result = new HashMap<String, String>();
        for (VideoTypeName clientFrom : VideoTypeName.values()) {
            result.put(String.valueOf(clientFrom.getCode()), clientFrom.getInfo());
        }
        return result;
    }
    
}
