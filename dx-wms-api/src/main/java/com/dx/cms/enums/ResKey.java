/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: ResKeyEnums.java
 * Author:   黄健
 * Date:     2016年1月11日 下午10:03:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.dx.common.service.utils.Assert;

/**
 * 
 * 资源标示
 *
 * @author tony
 */
public enum ResKey {

    /**
     * 理财端-客户开户申请
     */
    WMS_OPEN("wmsCustOpenApply", new HashSet<Integer>(Arrays.asList(2, 3, 4))),

    /**
     * 理财端-客户理财申请
     */
    WMS_APPLY("wmsCustLenderApply", new HashSet<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7))),

    /**
     * 理财端-理财申请单审核
     */
    WMS_CHECK("wmsLenderCheck", new HashSet<Integer>(Arrays.asList(2, 3, 4, 5, 6, 7))),

    /**
     * 理财端-支付凭证
     */
    WMS_VOUCHERS("wmsPaymentVouchers", new HashSet<Integer>(Arrays.asList(9))),
    /**
     * 理财端-拒绝回执
     */
    WMS_REFUSE("wmsRefuseReceipt", new HashSet<Integer>(Arrays.asList(10)));

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    private Set<Integer> dirs;

    public Set<Integer> getDirs() {
        return dirs;
    }

    public void setDirs(Set<Integer> dirs) {
        this.dirs = dirs;
    }

    private ResKey(String info, Set<Integer> dirs) {
        setInfo(info);
        setDirs(dirs);
    }

    public static ResKey get(String info) {
        for (ResKey key : ResKey.values()) {
            if (Assert.equals(key.getInfo(), info)) {
                return key;
            }
        }
        return null;
    }
}
