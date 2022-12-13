package com.dx.cmm.web.controller.credit;

import java.util.Map;

import com.dx.cmm.service.credit.CreditPoolResult;
import com.dx.common.service.utils.Assert;

public class ExpResult extends PoolResult {

    /**
     */
    private static final long serialVersionUID = -1032272019798480418L;

    /**
     * 当前匹配数量
     */
    private Integer num;

    public ExpResult(CreditPoolResult result, Map<Long, String> product) {
        super(result, product);
        setNum(Assert.checkParam(getNum()) ? getNum() : 0);
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
