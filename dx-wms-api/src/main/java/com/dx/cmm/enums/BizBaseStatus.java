package com.dx.cmm.enums;

import java.util.ArrayList;
import java.util.List;

import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;

/**
 * 
 * 业务基础状态
 *
 * @author tony
 */
public enum BizBaseStatus {

    /**
     * 待加入
     */
    WAIT("A", "待匹配"),

    /**
     * 已删除
     */
    DELETE("D", "已删除"),

    /**
     * 已加入
     */
    CREATED("C", "已加入"),

    /**
     * 异常债权
     */
    EXCEPTION("E", "异常债权"),

    /**
     * 已生效
     */
    SUCCESS("S", "已生效"),
    
    /**
     * 已转让
     */
    TRANS("T", "已转让"),
    
    
    /**
     * 重新匹配
     */
    REPEAT("N","重新匹配"),
    
    /**
     * 匹配
     */
    MATCH("M","匹配"),
    
    /**
     * 失效
     */
    FAIL("F","失效"),
    
    /**
     * 续投
     */
    CONTINUE("G","续投");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    private BizBaseStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static BizBaseStatus getEunm(String code) {
        if (!Assert.checkParam(code)) {
            throw new BaseException("not found code");
        }
        for (BizBaseStatus status : BizBaseStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new BaseException("not found code");
    }

    public static String getInfo(String code) {
        return getEunm(code).getInfo();
    }

    public static List<String> getList(BizBaseStatus... baseStatus) {
        List<String> results = new ArrayList<String>();
        for (BizBaseStatus status : baseStatus) {
            results.add(status.getCode());
        }
        return results;
    }
}
