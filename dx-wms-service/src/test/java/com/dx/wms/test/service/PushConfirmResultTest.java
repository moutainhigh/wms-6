package com.dx.wms.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.fms.service.api.IFinanceBankInfoService;
import com.dx.fms.service.dto.BankInfoDTO;
import com.dx.fms.service.dto.BankParamDTO;
import com.dx.fms.service.dto.ProcessResultDTO;
import com.dx.framework.constant.service.IRegionNewService;
import com.dx.wms.common.test.BaseTest;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.dto.PushResultDto;
import com.dx.wms.service.ILenderManagermentService;
import com.dx.wms.service.log.ILenderApplyLogService;

public class PushConfirmResultTest extends BaseTest {
    @Autowired
    private ILenderManagermentService lenderManagermentService;

    @Autowired
    private IFinanceBankInfoService IFinanceBankInfoService;
    /**
     * 支行接口
     */
    @Autowired
    IFinanceBankInfoService financeBankInfoService;

    @Autowired
    private ILenderApplyLogService lenderApplyLogService;

    /**
     * 区域服务
     */
    @Autowired
    private IRegionNewService regionService;

    @Test
    public void test_1() {

        List<BankInfoDTO> bankInfoDTOList = new ArrayList<BankInfoDTO>();
        BankInfoDTO bankInfoDTO = new BankInfoDTO();
        bankInfoDTO.setBankCode("ABC");
        bankInfoDTO.setBankName("中国农业银行");
        bankInfoDTO.setProvinceCode("370000");
        bankInfoDTO.setProvinceName(regionService.getRegionNameByCode("370000"));
        System.out.println(regionService.getRegionNameByCode("370000"));
        bankInfoDTO.setCityName(regionService.getRegionNameByCode("370200"));
        bankInfoDTO.setCityCode("370200");
        System.out.println(regionService.getRegionNameByCode("370200"));
        bankInfoDTO.setSubBankName("青岛支行");
        bankInfoDTOList.add(bankInfoDTO);
        Map<String, ProcessResultDTO> map = financeBankInfoService.saveBankInfo(bankInfoDTOList);
        System.out.println(map.get("青岛支行").getIsSuccess());
        System.out.println(map);
        BankParamDTO bankParamDTO = new BankParamDTO();
        bankParamDTO.setBankCode("ABC");
        bankParamDTO.setProvinceCode("370000");
        bankParamDTO.setCityCode("370200");
        List<BankInfoDTO> lists = financeBankInfoService.querySubBankNameByCode(bankParamDTO);
        System.out.println("查询结果" + lists.size());
    }

    // @Autowired
    // private LenderManagermentService lenderManagermentService;
    //
    // 测试 数据集合为空 抛异常
    // @Test
    // public void test_1(){
    // List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
    // lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
    // }

    // 测试 业务流水号为空 抛异常
    // @Test
    // public void test_2(){
    // List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
    // PushDataDto pushDataDto1 = new PushDataDto();
    // pushDataDtos.add(pushDataDto1);
    // lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
    // }

    // 测试 业务处理结果不能为空
    // @Test
    // public void test_3() {
    // List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
    // PushDataDto pushDataDto1 = new PushDataDto();
    // pushDataDto1.setBizCode("FT1509091133506494147");
    // pushDataDtos.add(pushDataDto1);
    // Map<String, PushResultDTO> resultMap = lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
    // System.out.println(resultMap.get("FT1509091133506494147").getResult()
    // + resultMap.get("FT1509091133506494147").getRemark());
    //
    // }
    //
    // // 测试 业务处理操作人不能为空
    // @Test
    // public void test_4() {
    // List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
    // PushDataDto pushDataDto1 = new PushDataDto();
    //
    // pushDataDto1.setBizCode("FT1509091133468184522");
    // pushDataDto1.setResult(1);
    // pushDataDtos.add(pushDataDto1);
    // Map<String, PushResultDTO> resultMap = lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
    // System.out.println(resultMap.get("FT1509091133468184522").getResult()
    // + resultMap.get("FT1509091133468184522").getRemark());
    // }
    //
    // // 测试 业务处理流水号不存在
    // @Test
    // public void test_5() {
    // List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
    // PushDataDto pushDataDto1 = new PushDataDto();
    // pushDataDto1.setBizCode("FT1509091133468184521");
    // pushDataDto1.setResult(1);
    // pushDataDto1.setCreateUser(11l);
    // pushDataDtos.add(pushDataDto1);
    // Map<String, PushResultDTO> resultMap = lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
    // System.out.println(resultMap.get("FT1509091133468184521").getResult()
    // + resultMap.get("FT1509091133468184521").getRemark());
    //
    // }

    // 多条数据 有正常的 有异常的
    // @Test
    // public void test_6() {
    // List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
    // PushDataDto pushDataDto1 = new PushDataDto();
    // pushDataDto1.setBizCode("FT1509091733219755881");
    // pushDataDto1.setResult(0);
    // pushDataDto1.setCreateUser(11l);
    // pushDataDtos.add(pushDataDto1);
    // PushDataDto pushDataDto2 = new PushDataDto();
    // pushDataDto2.setBizCode("FT1509091742579225683");
    // pushDataDto2.setResult(1);
    // pushDataDto2.setCreateUser(11l);
    // pushDataDtos.add(pushDataDto2);
    // PushDataDto pushDataDto3 = new PushDataDto();
    // pushDataDto3.setBizCode("FT1509091133506494147");
    // pushDataDto3.setResult(0);
    // pushDataDto3.setCreateUser(11l);
    // pushDataDtos.add(pushDataDto3);
    // Map<String, PushResultDTO> resultMap = lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
    // System.out.println(resultMap.get("FT1509091733219755881").getResult()
    // + resultMap.get("FT1509091733219755881").getRemark());
    // System.out.println(resultMap.get("FT1509091742579225683").getResult()
    // + resultMap.get("FT1509091742579225683").getRemark());
    // System.out.println(resultMap.get("FT1509091133506494147").getResult()
    // + resultMap.get("FT1509091133506494147").getRemark());
    // }

    // 一条数据 出资成功 状态投资完成
    @Test
    public void test_7() {
        List<PushDataDto> pushDataDtos = new ArrayList<PushDataDto>();
        PushDataDto pushDataDto1 = new PushDataDto();
        pushDataDto1.setBizId(12982L);
        pushDataDto1.setBizCode("L0533011605060001-008");
        pushDataDto1.setResult(1);
        pushDataDto1.setDataType(3);
        pushDataDto1.setCreateUser(-1l);
        pushDataDto1.setRemark("222222222");
        pushDataDto1.setSettlementDate(new Date());
        pushDataDtos.add(pushDataDto1);
        Map<String, PushResultDto> resultMap = lenderManagermentService.pushContributiveConfirmResult(pushDataDtos);
        System.out.println("~!!!!!!!!!!!!!!!!!!" + resultMap.get("L0533011605060001-008").getResult()
                + resultMap.get("L0533011605060001-008").getRemark());
    }

    // 匹配好的数据推送回来
    @Test
    public void test_8() {
//        lenderApplyLogService.addLenderApplyLogSetDate(379L, 12784L, 16, new Date());
//        lenderApplyLogService.addLenderApplyLogSetDate(379L, 12785L, 16, new Date());
//        lenderApplyLogService.addLenderApplyLogSetDate(379L, 12786L, 16, new Date());
 //       lenderApplyLogService.addLenderApplyLogSetDate(379L, 12869L, 16, new Date());
//        lenderApplyLogService.addLenderApplyLogSetDate(379L, 12735L, 16, new Date());
    }
}
