package com.dx.wms.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.common.service.utils.Assert;
import com.dx.fms.service.api.IFinanceDataProcessService;
import com.dx.fms.service.dto.DealRecordDTO;
import com.dx.fms.service.dto.ProcessResultDTO;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.dto.PushRecordDto;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.google.gson.Gson;

public class IFinanceDataProcessServiceTest extends BaseTest{
    @Autowired
    private IFinanceDataProcessService financeDataProcessService;
    /**
     * 理财申请
     */
    @Autowired
    private ILenderApplyDao lenderApplyDao;
    
    @Test
    public void test_1(){
        DealRecordDTO dealRecordDTO = getPushRecordById(27l);
        List<DealRecordDTO> dealRecordDTOList = new ArrayList<DealRecordDTO>();
        dealRecordDTOList.add(dealRecordDTO);
        
        Map<String, ProcessResultDTO> result = financeDataProcessService.pushDealData(dealRecordDTOList);
        System.out.println("-------------------result"+result);
        System.out.println(new Gson().toJson(result.get(dealRecordDTO.getOrderNo())));
    }
    
    private PushRecordDto getPushRecordDto(Long lenderApplyId){
        return lenderApplyDao.queryPushRecord(lenderApplyId);
    }
    
    private DealRecordDTO getPushRecordById(Long lenderApplyId) {
        DealRecordDTO dealRecordDTO = new DealRecordDTO();
        PushRecordDto pushRecordDto = getPushRecordDto(lenderApplyId);
        Assert.notNull("**getPushRecordById() pushRecordDto not found**", pushRecordDto);
        BeanUtils.copyProperties(pushRecordDto, dealRecordDTO);
        dealRecordDTO.setBizId(lenderApplyId);
        // 业务流水号
        dealRecordDTO.setOrderNo("2015091621481234567");
        // 业务来源(1:理财系统,2:信贷系统)
      //  dealRecordDTO.setBizSource(1);
        // 业务类型 1-理财出资
        dealRecordDTO.setBizType(1);
        // 证件类型转换
        dealRecordDTO.setCertType(1);
        dealRecordDTO.setTradeWay(1);
        if (dealRecordDTO.getTradeWay().equals(2)) {
            // 交易平台编码 “POSS划扣”时，必传
            dealRecordDTO.setTradePlatformCode("FUYOU");
        }
        dealRecordDTO.setBankCode("ICBC");
        // 交易类型 1-扣款
        dealRecordDTO.setTradeType(1);
       
        dealRecordDTO.setCreateUser(1l);
//        if (!checkDealRecordDTO(dealRecordDTO)) {
//            throw new BaseException("**推送的数据有异常*** dealRecordDTO ={}", new Gson().toJson(dealRecordDTO));
//        }
        return dealRecordDTO;
    }
}
