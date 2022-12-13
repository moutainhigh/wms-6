///*
// * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
// * FileName: HRFiileController.java
// * Author:   黄健
// * Date:     2016年1月19日 下午6:14:16
// * Description: //模块目的、功能描述      
// * History: //修改记录
// * <author>      <time>      <version>    <desc>
// * 修改人姓名             修改时间            版本号                  描述
// */
//package com.dx.wms.web.hr.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.dx.bpm.constants.ProcessOnBoardShiftWealthConstans;
//import com.dx.bpm.constants.ProcessOnBoardWealthConstans;
//import com.dx.hr.service.dto.CommentRequestDto;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈功能详细描述〉
// *
// * @author huangjian
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Controller
//@RequestMapping("/hrApproveLog")
//public class HRApproveLogController extends HRController {
//
//    @RequestMapping("/showLog.json")
//    @ResponseBody
//    public Map<String, Object> showLog(HttpServletRequest request, Long employeeId) {
//        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("employeeId", employeeId);
//        CommentRequestDto commentRequestDto = new CommentRequestDto();
//        commentRequestDto.setEmployeeId(employeeId);
//        commentRequestDto.setBusinessType(ProcessOnBoardWealthConstans.PROCESS_DEFINITION_ONBOARDWEALTHAPPLICATION);
//        model.put("entryRecords", commonService.queryEmployeeEntryApproveMsg(commentRequestDto));
//        commentRequestDto
//                .setBusinessType(ProcessOnBoardShiftWealthConstans.PROCESS_DEFINITION_ONBOARDSHIFTWEALTHAPPLICATION);
//        model.put("moveRecords", commonService.queryEmployeeEntryApproveMsg(commentRequestDto));
//        return model;
//    }
//
//}
