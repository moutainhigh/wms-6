package com.dx.cmm.service.stats;

import java.io.Serializable;

public class ResultStat implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4229665815809139704L;

    /**
     * 统计名称
     */
    private String statName;

    /**
     * 顺位
     */
    private Integer index;

    public String getStatName() {
        return statName;
    }

    public ResultStat setStatName(String statName) {
        this.statName = statName;
        return this;
    }

    public Integer getIndex() {
        return index;
    }

    public ResultStat setIndex(Integer index) {
        this.index = index;
        return this;
    }

}
