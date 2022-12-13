/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AbstractBaseObserverService.java
 * Author:   黄健
 * Date:     2015年7月27日 下午4:09:32
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @param <F>
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseObserverServiceImpl<F , T> implements IBaseObserverService<F, T> {

    @Override
    public void join() {
        
    }

    @Override
    public boolean isNeedAction(T param) {
        return null != param ? true : false;
    }

    @Override
    public F execute(T param) {
        return null;
    }

}
