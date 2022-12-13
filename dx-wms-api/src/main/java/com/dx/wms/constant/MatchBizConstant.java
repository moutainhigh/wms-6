/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: MatchBizConstant.java
 * Author:   蔡登勇
 * Date:     2015年7月28日 下午3:42:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.constant;

/**
 * 匹配业务常量
 *
 * @author 蔡登勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class MatchBizConstant {

    /** 业务类别 CCS系统 */
    public static final Integer CCS_SYSTEM = 1;

    /** 业务类别 WMS系统 */
    public static final Integer WMS_SYSTEM = 2;

    /** 有效状态 */
    public static final String NORMAL_STATUS = "A";

    /** 结清状态 */
    public static final String SETTLE_STATUS = "E";

    /** 删除状态 */
    public static final String DELETED_STATUS = "D";

    /** 已加入队列 */
    public static final String MATCHED_STATUS = "C";
}
