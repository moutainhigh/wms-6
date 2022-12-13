//package com.dx.wms.web.hr.controller;
//
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dx.wms.web.hr.vo.HRParamVo;
//import com.dx.wms.web.hr.vo.ResultHRVo;
//import com.dx.wms.web.page.AjaxDataTableObj;
//import com.dx.wms.web.page.DataTableObj;
//
//@Controller
//@RequestMapping("/hrFlow")
//public class HRFlowController extends HRController {
//
//    // 人员信息查询，入职，在职管理员工信息查询{biz:list员工信息查询,entry入职,inService在职}
//    @RequestMapping("/{biz}.htm")
//    public String init(@PathVariable("biz") String biz, ModelMap model, HttpServletRequest request) {
//        return init(biz, commonService.getUserId(request), model);
//    }
//
//    // 入职和在职管理员工查询结果{biz:list,biz:entry,biz:inService}
//    @RequestMapping("/{biz}.json")
//    @ResponseBody
//    public AjaxDataTableObj<ResultHRVo> query(@PathVariable("biz") String biz, HRParamVo param, DataTableObj dTable,
//            HttpServletRequest request) {
//        Long userId = commonService.getUserId(request);
//        return new AjaxDataTableObj<ResultHRVo>(dTable, convertResults(getResults(biz, param, userId, dTable), userId));
//    }
//
//}
