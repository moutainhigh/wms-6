/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileObservedEventLink.java
 * Author:   黄健
 * Date:     2015年7月16日 下午9:22:17
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

/**
 * 被观察者 base接口 负责添加service到容器以及通知观察者
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IBaseObserverdService<F, E, T> {

    /**
     * 向容器中添加观察者
     *
     * @param observer 观察者
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void addObserver(E observer);

    /**
     * 通知观察者
     *
     * @param param 观察者过滤条件map
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    F informObservers(T param);
}
