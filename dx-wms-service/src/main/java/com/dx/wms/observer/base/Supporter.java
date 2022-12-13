/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: Supporter.java
 * Author:   caidengyong
 * Date:     2016年7月7日 下午1:23:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.observer.base;

/*
 * 支持者
 */
public interface Supporter<P> {
    /**
     * 
     * 业务支持
     *
     * @param param
     * @return
     */
    Boolean supports(P param);
    
}
