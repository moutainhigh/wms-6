/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: BillViewTest.java
 * Author:   蔡登勇
 * Date:     2015年8月4日 下午11:06:48
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.op.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cmm.enums.ReportType;
import com.dx.cmm.service.bill.BillViewConstant;
import com.dx.cmm.service.dto.BillViewDto;
import com.dx.cmm.service.intf.IBillViewService;
import com.dx.cmm.service.reports.ParamReport;
import com.dx.cmm.service.reports.Report;
import com.dx.cmm.service.reports.ReportObserver;
import com.dx.cmm.service.reports.ResultFundReport;
import com.dx.framework.dal.util.DalUtils;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.dto.ReportParamDto;
import com.dx.wms.report.dataClient.DataClientRouters;
import com.dx.wms.report.dataClient.biz.FirstClient;
import com.dx.wms.vo.CreditorDetailVo;
import com.dx.wms.vo.LenderDetailVo;

/**
 * 报告测试
 *
 * @author 蔡登勇
 */
public class ReportTests extends BaseTest {

    @Autowired
    private IBillViewService<Map<String, Object>> synthesizeBillViewService;

    @Autowired
    private ReportObserver<Report<ParamReport, Object>, ParamReport, Object> report;
    
    @Autowired
    private DataClientRouters router;

    @Test
    public void getBillViewDto() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(BillViewConstant.BILL_VIEW_CODE, BillViewConstant.BV001);
        map.put(BillViewConstant.MATCH_BIZ_BASE_ID, 6123l);
        BillViewDto b = synthesizeBillViewService.doQuery(map);
        List<CreditorDetailVo> cdvs = b.getCreditorDetailVos();
        for (CreditorDetailVo c : cdvs) {
            System.out.println(DalUtils.convertToMap(c));
        }
        List<LenderDetailVo> ldvs = b.getLenderDetailVos();
        for (LenderDetailVo l : ldvs) {
            System.out.println(DalUtils.convertToMap(l) + "----" + l.getLenderAmount());
        }
        System.out.println(DalUtils.convertToMap(b));
        System.out.println(b.getTotalCreditorAmount());
        System.out.println(b.getTotalPayConsideration());
    }

  
    @Test
    public void fundReport() {
        List<ResultFundReport> results = (List<ResultFundReport>)report.query(new ParamReport(ReportType.FUND_REPORT, 16));
        
    }
    
    @Test
    public void test(){
//    	ReportParamDto param = new ReportParamDto();
//    	param.setIds(new ArrayList<String>());
//    	param.setReportType(1);
//    	router.execute(param);
    }
}
