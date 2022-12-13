/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: SynthesizeCodeRole.java
 * Author:   黄健
 * Date:     2015年7月14日 下午5:57:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cmm.service.bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dx.cmm.service.dto.BillViewDto;
import com.dx.cmm.service.intf.IBillViewService;
import com.dx.framework.exception.BaseException;

/**
 * 观察者模式 -- 容器 实现类 具体描述该容器需具备的功能
 *
 * @author huangjian
 */
@Service
@Transactional
public class BillViewObserver implements IBillViewObserver<Map<String, Object>> {

    private List<IBillViewService<Map<String, Object>>> services = new ArrayList<IBillViewService<Map<String, Object>>>();

    @Override
    public void regist(IBillViewService<Map<String, Object>> service) {
        services.add(service);
    }

    @Override
    public String doInit(Map<String, Object> param) {
        checkInputParam(param);
        for (IBillViewService<Map<String, Object>> abstractService : services) {
            if (abstractService.supports(param)) {
                return abstractService.init(param);
            }
        }
        return "redirect:/index.htm";
    }

    @Override
    public BillViewDto doQuery(Map<String, Object> param) {
        checkInputParam(param);
        BillViewDto billViewDto = new BillViewDto();

        for (IBillViewService<Map<String, Object>> abstractService : services) {
            if (abstractService.supports(param)) {
                return abstractService.doQuery(param);
            }
        }
        return billViewDto;
    }

    private void checkInputParam(Map<String, Object> param) {
        if ((String) param.get(BillViewConstant.BILL_VIEW_CODE) == null) {
            throw new BaseException("视图编号不能为空");
        }
        if ((String) param.get(BillViewConstant.LENDER_CODE) == null
                && (String) param.get(BillViewConstant.LENDER_CUST_CODE) == null) {
            throw new BaseException("出借客户编号  出借编号不能都为空");
        }
    }

}
