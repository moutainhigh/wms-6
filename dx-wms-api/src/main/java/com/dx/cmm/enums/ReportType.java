package com.dx.cmm.enums;

/**
 * 
 * 报告类型
 *
 * @author tony
 */
public enum ReportType {

    /**
     * 首期债权转让及受让协议
     */
    FISRT_REPORT("", ""),

    /**
     * 非首期债权转让及受让协议
     */
    NOT_FIRST_REPORT("", ""),

    /**
     * 非首期债权转让及受让协议（补）
     */
    NOT_FIRST_ADD_REPORT("", ""),

    /**
     * 客户资金出借情况报告
     */
    FUND_REPORT("", ""),

    /**
     * 客户资金出借情况报告+风险金披露
     */
    RISK_FUND_REPORT("", ""),

    /**
     * 出借人到期债权转让协议
     */
    DUE_REPORT("", "");

    private String sqlId;

    private String ftl;

    ReportType(String sqlId, String ftl) {
        setSqlId(sqlId);
        setFtl(ftl);
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getFtl() {
        return ftl;
    }

    public void setFtl(String ftl) {
        this.ftl = ftl;
    }

}
