package com.dx.cmm.enums;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.dx.framework.exception.BaseException;

/**
 * 
 * 匹配状态
 *
 * @author tony
 */
public enum MatchStatus {
    /**
     * 待匹配
     */
    WAIT("A", "新增匹配"),

    /**
     * 已删除
     */
    DELETE("D", "已删除"),

    /**
     * 已匹配
     */
    MATCH("M", "已匹配"),

    /**
     * 回款匹配
     */
    PART("P", "回款匹配"),

    /**
     * 重新匹配
     */
    NEW("N", "重新匹配"),

    /**
     * 投资生效
     */
    SUCCESS("S", "投资生效"),

    /**
     * 投资失败
     */
    FAIL("F", "投资失败"),

    /**
     * 线下匹配
     */
    OFF_LINE("O", "线下匹配");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    private MatchStatus(String code, String info) {
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

    public static MatchStatus getEunm(String code) {
        if (StringUtils.isBlank(code)) {
            throw new BaseException("not found code");
        }
        for (MatchStatus status : MatchStatus.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new BaseException("not found code");
    }

    public static String getInfo(String code) {
        return getEunm(code).getInfo();
    }

    public static List<String> getList(MatchStatus... matchStatus) {
        List<String> results = new ArrayList<String>();
        for (MatchStatus status : matchStatus) {
            results.add(status.getCode());
        }
        return results;
    }
}
