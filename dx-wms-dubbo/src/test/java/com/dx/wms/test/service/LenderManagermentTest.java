package com.dx.wms.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.dto.LenderApplyQueryDto;
import com.dx.wms.dto.LenderApplyResultDto;
import com.dx.wms.dto.LenderManagermentDataDto;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.dto.PushResultDto;
import com.dx.wms.service.ILenderManagermentService;
import com.google.gson.Gson;

public class LenderManagermentTest extends BaseTest {

    @Autowired
    private ILenderManagermentService lenderManagermentService;

    @Test
    public void pushContributiveConfirmResult() {//根据参数出资确认成功失败修改状态
        List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
        PushDataDto pushDataDto1 = new PushDataDto();
        //业务ID
        pushDataDto1.setBizId(15865L);
        //业务流水号
        pushDataDto1.setBizCode("L0533011610110001-002");
        //出资结果 (0:成功 1:失败 2：部分划扣)
        pushDataDto1.setResult(0);
        //dataType 数据类型 1.出资 2.到帐
        pushDataDto1.setDataType(1);
        pushDataDto1.setCreateUser(-1l);
        //备注
        pushDataDto1.setRemark("222222222");
        pushDataDto1.setSettlementDate(new Date());
        pushDataDtos.add(pushDataDto1);
        Map<String, PushResultDto> resultMap = lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
        System.out.println("~!!!!!!!!!!!!!!!!!!" + resultMap.get("L0533011610110001-002").getResult()
                + resultMap.get("L0533011610110001-002").getRemark());
    }

    @Test
    public void queryLendersInfo() {//理财单信息查询
        LenderApplyQueryDto dto = new LenderApplyQueryDto();
        //产品ID
        dto.setProductId(16l);
        dto.setPagination(new Pagination());
        //理财客户编号
        dto.setLenderCode("L05351505180003-001");
        //身份证
        dto.setIdCard("370602196205091820");
        //姓名
        dto.setCustName("刘春芳");
        //状态
        dto.setCurrentStepKey("success");
        PaginationResult<List<LenderApplyResultDto>> resultDtos = lenderManagermentService.queryLendersInfo(dto);
        System.out.println(new Gson().toJson(resultDtos));
    }

    @Test
    public void queryAccountByLenderCustCode() {//理财客户编号查询客户账户
    	//理财客户编号
        LenderManagermentDataDto dto = lenderManagermentService.queryAccountByLenderCustCode("L05351505180004");
        System.out.println(new Gson().toJson(dto));
    }

    @Test
    public void queryByOrgIdAndToday() {//查询某门店当天开户列表
    	//orgId 门店ID
        List<LenderManagermentDataDto> dtos = lenderManagermentService.queryByOrgIdAndToday(294l);
        System.out.println(new Gson().toJson(dtos));
    }

    @Test
    public void queryLendersByLenderCustCode() {//通过理财客户编号查询出借申请单列表
    	//财客户编号
        List<LenderManagermentDataDto> dtos = lenderManagermentService
                .queryLendersByLenderCustCode("L05351505180004");
        System.out.println(new Gson().toJson(dtos));
    }

    @Test
    	public void queryByCustAccountId() {//通过理财客户Id查询出借申请单列表
    	//理财客户Id
        List<LenderManagermentDataDto> dtos = lenderManagermentService.queryByCustAccountId(10025l);
        System.out.println(new Gson().toJson(dtos));
    }
    
    
}
