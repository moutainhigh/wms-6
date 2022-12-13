/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: IBaseObserverService.java
 * Author:   黄健
 * Date:     2015年7月24日 下午1:35:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

/**
 * 观察者 功能service接口
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IBaseObserverService<F , T> {

    /**
     * 注入监听者到容器中
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void join();
    
    /**
     * 判断某监听者是否需要执行相关操作并向容器反馈信息
     *
     * @param param     观察者筛选条件
     * @return          true -- 执行该service的操作
     *                  false -- 跳过该service（观察者）
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    boolean isNeedAction(T param);
    
    /**
     * 所有监听者功能实现统一调用方法
     *
     * @param param
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    F execute(T param);
    
    
}
