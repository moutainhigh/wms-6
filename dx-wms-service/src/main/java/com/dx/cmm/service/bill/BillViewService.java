/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: AbstractSynthesizeCodeRole.java
 * Author:   蔡登勇
 * Date:     2015年8月1日 下午2:07:05
 * Description: //模块目的、功能描述      
 */
package com.dx.cmm.service.bill;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cmm.service.dto.BillViewDto;
import com.dx.cmm.service.intf.IBillViewService;

/**
 * 观察者模式 -- 观察者 抽象类 Service通过继承该抽象类,从而将自身添加到容器中的观察者队列中
 *
 * @author 蔡登勇
 */
public abstract class BillViewService implements IBillViewService<Map<String, Object>> {

    @Autowired
    private IBillViewObserver<Map<String, Object>> billViewObserver;

    

    @Override
    public boolean supports(Map<String, Object> param) {
        if (param == null || param.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    @PostConstruct
    public void join() {
        billViewObserver.regist(this);
    }

    @Override
    public String init(Map<String, Object> parm) {
        return null;
    }

    @Override
    public BillViewDto doQuery(Map<String, Object> parm) {
        return null;
    }
}
