package com.dx.cmm.service.ports;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 端口号
 *
 * @author tony
 */
public class Port implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6578635858983278754L;

    /**
     * 1号端口
     */
    public static final Integer ONE = 1;

    /**
     * 16号端口
     */
    public static final Integer SIXTEEN = 16;

    /**
     * 全部端口
     */
    public static final Integer ALL = 99;

    public static final Map<String, String> PORT = new HashMap<String, String>() {
        private static final long serialVersionUID = -228724867842014405L;

        {
            put("1", "1");
            put("16", "16");
        }
    };

    /**
     * 报告日
     */
    Date reportDate;

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

}
