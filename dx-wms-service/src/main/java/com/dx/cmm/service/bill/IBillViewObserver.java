/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: SynthesizeCodeRole.java
 * Author:   黄健
 * Date:     2015年7月14日 下午5:54:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cmm.service.bill;

import java.util.Map;

import com.dx.cmm.service.dto.BillViewDto;
import com.dx.cmm.service.intf.IBillViewService;

/**
 * 观察者模式 -- 容器 接口
 *
 * @author 黄健
 */
public interface IBillViewObserver<T> {
    
    /**
     * 将Service（即观察者）添加被通知列表
     *
     * @param service   Service（即观察者）
     */
    void regist(IBillViewService<Map<String,Object>> service);

    /**
     * 
     * 获取跳转路径
     */
    String doInit(T param);
    
    /**
     * 
     * 返回视图Dto
     */
    BillViewDto doQuery(T param);
}
