package com.dx.cmm.enums;

/**
 * 
 * 规则
 *
 * @author tony
 */
public enum Rule {
    /**
     * 信贷端-匹配规则
     */
    BORROW_MATCH_RULE("borrowMatchRule", "信贷端-匹配规则", ""),

    /**
     * 理财端-匹配规则
     */
    LENDER_MATCH_RULE("lenderMatchRule", "理财端-匹配规则", ""),

    /**
     * 账单端-匹配规则
     */
    BILL_PORT_RULE("billPortRule", "账单端-匹配规则", "OUTPUT_REPORT_DAY"),

    /**
     * 匹配用户-匹配规则
     */
    MATCH_USER_RULE("matchUserRule", "匹配用户-匹配规则", ""),

    /**
     * 回款匹配-触发规则
     */
    BACK_MATCH_RULE("backMatchRule", "回款匹配-触发规则", "OUTPUT_REPORT_DAY"),

    /**
     * 理财端-账户级别规则
     */
    LENDER_ACCOUNT_RULE("lenderAccountRule", "理财端-账户级别规则", "");

    /**
     * 常量值
     */
    private String code;

    /**
     * 内容
     */
    private String info;

    /**
     * 输出
     */
    private String output;

    private Rule(String code, String info, String output) {
        this.code = code;
        this.info = info;
        this.output = output;
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

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

}
