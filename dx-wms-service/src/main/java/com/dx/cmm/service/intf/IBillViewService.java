/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ISynthesizeCodeRoleService.java
 * Author:   黄健
 * Date:     2015年7月14日 下午6:39:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cmm.service.intf;

import com.dx.cmm.service.dto.BillViewDto;

/**
 * 观察者模式 -- 观察者 接口
 *
 * @author 黄健
 */
public interface IBillViewService<T> {

    /**
     * 添加观察者（即相应的Service）
     *
     */
    void join();

    /**
     * 
     * 获取跳转路径
     */
    String init(T param);
    
    /**
     * 
     * 返回视图Dto
     */
    BillViewDto doQuery(T param);

    /**
     * 判断在某Service（某观察者）是否需要获取该Service对应编码
     *
     * @param param 判断条件
     * @return true -- 需要 false -- 不需要
     */
    boolean supports(T param);


}
