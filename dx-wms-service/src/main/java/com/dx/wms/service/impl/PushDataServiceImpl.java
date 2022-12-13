package com.dx.wms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.enums.ResKey;
import com.dx.cms.service.IFileService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.fms.service.dto.CustomerInfoDTO;
import com.dx.fms.service.dto.DealDetailDTO;
import com.dx.fms.service.dto.DealRecordDTO;
import com.dx.fms.service.dto.ParamRecordDTO;
import com.dx.fms.service.dto.ProcessResultDTO;
import com.dx.fms.service.dto.QueryRecordDTO;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.dx.framework.exception.BaseException;
import com.dx.wms.dto.DealDetailDto;
import com.dx.wms.dto.LenderPushDataDto;
import com.dx.wms.dto.PushRecordDto;
import com.dx.wms.service.ICommonService;
import com.dx.wms.service.IPushDataService;
import com.dx.wms.service.apply.IApplyService;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.log.IInvokeLogSaveService;
import com.dx.wms.service.log.IInvokeLogService;
import com.dx.wms.service.log.InvokeLog;
import com.dx.wms.service.push.LenderPushException;
import com.google.gson.Gson;

@Service
public class PushDataServiceImpl implements IPushDataService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(PushDataServiceImpl.class);

    /**
     * 理财申请服务
     */
    @Autowired
    private IApplyService lenderApplyService;

    @Autowired
    private ILenderApplyDao applyDao;

    /**
     * 调用日志服务
     */
    @Autowired
    private IInvokeLogService invokeLogService;

    /**
     * 调用日志服务
     */
    @Autowired
    private IInvokeLogSaveService invokeLogSaveService;

    /**
     * 通用服务接口
     */
    @Autowired
    private ICommonService commonService;

    /**
     * 文件服务
     */
    @Autowired
    private IFileService fileService;

    @Override
    public void pushFinance(Long userId, LenderPushDataDto push) throws LenderPushException {
        LenderApply apply = applyDao.queryById(LenderApply.class, push.getLenderApplyId());
        LOG.info("Push apply id[{}],user id[{}] to finance", push.getLenderApplyId(), userId);
        if (checkInvokeLogIdExist(push.getLenderApplyId())) {
            LOG.error("Lender code[{}] has pushed", push.getLenderCode());
            throw new LenderPushException("Lender code[{0}] has pushed", push.getLenderCode());
        }
        pushDealData(apply, userId, push);
    }

    private void pushDealData(LenderApply apply, Long userId, LenderPushDataDto push) throws LenderPushException {
        Long lenderApplyId = apply.getLenderApplyId();
        String lenderCode = apply.getLenderCode();
        Assert.notNull(new LenderPushException("Lender code must not be null"), lenderCode);
        // 查询所要推送的数据
        DealRecordDTO recored = getPushRecordById(lenderApplyId, userId, apply.getParentId());
        Assert.notNull("orgID must not be null", apply.getOrgId());
        recored.setOrgId(apply.getOrgId());
        // 直接划扣设置pos终端编号和划扣日期
        if (Assert.checkParam(apply.getPayWayId()) && Assert.equals(apply.getPayWayId(), 3L)) {
            Assert.notNull(new LenderPushException("Trans time or terminal code must not be null"), push.getTradeTime(),
                    push.getTerminalCode());
            recored.setTradeTime(push.getTradeTime());
            recored.setTerminalCode(push.getTerminalCode());
        }
        List<DealRecordDTO> records = new ArrayList<DealRecordDTO>();
        records.add(recored);
        Map<String, ProcessResultDTO> result = commonService.pushCreditorDealData(records);
        if (!result.containsKey(apply.getLenderCode())) {
            throw new LenderPushException("Apply[{0}] push to finance error", apply.getLenderCode());
        }
        ProcessResultDTO process = result.get(lenderCode);
        if (!Assert.checkParam(process)) {
            throw new LenderPushException("Apply[{0}] return result error", apply.getLenderCode());
        }
        Integer isSuccess = process.getIsSuccess();
        if (!Assert.checkParam(isSuccess)) {
            throw new LenderPushException("Finance error msg[{0}]", process.getMsg());
        }
        // 推送数据成功 保存调用日志
        Assert.notNull(new LenderPushException("Apply[{0}] save invoke log error", lenderCode),
                invokeLogSaveService.save(lenderApplyId, lenderCode, userId, 1));
    }

    private DealRecordDTO getPushRecordById(Long lenderApplyId, Long userId, Long parentId) {
        Assert.notNull("*** getPushRecordById () lenderApplyId is null", lenderApplyId);
        Assert.notNull("*** getPushRecordById () userId is null", userId);
        LOG.info("***getPushRecordById()  lenderApplyId= {},userId={},parentId={}***", lenderApplyId, userId, parentId);
        return getPushRecordById(lenderApplyId, userId, Assert.checkParam(parentId) ? 5 : 1);
    }

    @Override
    public DealRecordDTO getPushRecordById(Long lenderApplyId, Long userId, Integer bizType) {
        LOG.info("**getPushRecordById() lenderApplyId:{},userId:{},bizType:{}***", lenderApplyId, userId, bizType);
        DealRecordDTO dealRecordDTO = new DealRecordDTO();
        PushRecordDto pushRecordDto = lenderApplyService.getPushRecordById(lenderApplyId);
        Assert.notNull("**getPushRecordById() pushRecordDto not found**", pushRecordDto);
        BeanUtils.copyProperties(pushRecordDto, dealRecordDTO);
        dealRecordDTO.setBizId(lenderApplyId);
        // 业务流水号
        dealRecordDTO.setOrderNo(pushRecordDto.getLenderCode());
        dealRecordDTO.setSubOrderNo(pushRecordDto.getLenderCode());
        // 业务来源(1:理财系统,2:信贷系统)
        dealRecordDTO.setBizSource(1);
        // 业务类型 1-理财出资 //5续投
        dealRecordDTO.setBizType(bizType);
        // 证件类型转换
        dealRecordDTO.setCertType(getCertType(pushRecordDto.getCertType()));
        if (bizType == 5) {
            Long parentId = pushRecordDto.getParentId();
            LenderApply lenderApply = applyDao.queryById(LenderApply.class, parentId);
            dealRecordDTO.setSubOrderNo(lenderApply.getLenderCode());
        } else {
            dealRecordDTO.setTradeWay(getTradeWay(pushRecordDto.getPayWayId()));
            if ((dealRecordDTO.getTradeWay().equals(2) || dealRecordDTO.getTradeWay().equals(1))) {
                // 交易平台编码 “POSS划扣”时，必传
                dealRecordDTO.setTradePlatformCode("FUYOU");
            }
            dealRecordDTO.setBankCode(getbankCode(pushRecordDto.getBankCategory()));
            // 交易类型 1-扣款
            dealRecordDTO.setTradeType(1);
            dealRecordDTO.setProvinceCode(pushRecordDto.getProvinceRegionCode());
            dealRecordDTO.setCityCode(pushRecordDto.getCityRegionCode());
        }
        dealRecordDTO.setMobileNo(pushRecordDto.getMobileNo());
        if (Assert.checkParam(pushRecordDto.getSignMobile()) && Assert.equals(pushRecordDto.getPayWayId(), 2)) {
            dealRecordDTO.setMobileNo(pushRecordDto.getSignMobile());
        }

        // 获取凭证影像件
        List<Long> fileIds = getFileIds(lenderApplyId);
        dealRecordDTO.setFileIds(fileIds);
        if (Assert.checkParam(userId)) {
            dealRecordDTO.setCreateUser(userId);
        }
        if (!checkDealRecordDTO(dealRecordDTO)) {
            throw new BaseException("**推送的数据有异常*** dealRecordDTO ={}", new Gson().toJson(dealRecordDTO));
        }
        LOG.info("***getPushRecordById() dealRecordDTO ={}", new Gson().toJson(dealRecordDTO));
        return dealRecordDTO;
    }

    private List<Long> getFileIds(Long lenderApplyId) {
        LenderApply lenderApply = applyDao.queryById(LenderApply.class, lenderApplyId);
        Assert.notNull("理财申请单不存在", lenderApply);
        String lenderCode = lenderApply.getLenderCode();
        Assert.notNull("理财出借CODE不存在", lenderCode);
        List<Long> fileIds = new ArrayList<Long>();
        Condition condition = new Condition();
        condition.setRes(ResKey.WMS_VOUCHERS);
        condition.setType(1);
        condition.setLenderCode(lenderCode);
        condition.setCmAction("getVoucherPaymentFiles");
        LOG.info("*** getFileIds() conditionsDto={}", new Gson().toJson(condition));
        fileIds = fileService.queryPayMentFile(condition);
        return fileIds;
    }

    private boolean checkInvokeLogIdExist(Long lenderApplyId) {
        InvokeLog og = invokeLogService.queryByLenderApplyId(lenderApplyId);
        return Assert.checkParam(og);
    }

    // 获取 银行 CODE
    private String getbankCode(Integer bank) {
        String bankCode = "";
        switch (bank) {
            case 1:
                // 11,"工商银行" ICBC
                bankCode = "ICBC";
                break;
            case 2:
                // 12,"农业银行" ABC
                bankCode = "ABC";
                break;
            case 3:
                // 13,"建设银行" CCB
                bankCode = "CCB";
                break;
            case 4:
                // 14,"中国银行 " BOC
                bankCode = "BOC";
                break;
            case 5:
                // 15,"邮政储蓄银行"PSBC
                bankCode = "PSBC";
                break;
            case 6:
                // 16,"招商银行" CMB
                bankCode = "CMB";
                break;
            case 7:
                // 17,"兴业银行" CIB
                bankCode = "CIB";
                break;
            case 8:
                // 18,"广发银行" GDB
                bankCode = "GDB";
                break;
            case 9:
                // 19,"平安银行" PAB
                bankCode = "PAB";
                break;
            case 10:
                // 20,"中信银行"CITIC
                bankCode = "CITIC";
                break;
            case 11:
                // 21,"华夏银行" HXB
                bankCode = "HXB";
                break;
            case 12:
                // 22,"中国光大银行"CEB
                bankCode = "CEB";
                break;
            case 13:
                // 23,"浦发银行" SPDB
                bankCode = "SPDB";
                break;
            case 14:
                // 24,"民生银行" CMBC
                bankCode = "CMBC";
                break;
            case 15:
                // 25,"上海银行" BOC
                bankCode = "BOS";
                break;
            case 16:
                // 26,"交通银行" BCM
                bankCode = "BCM";
                break;
        }
        return bankCode;
    }

    // 获取交易方式
    private Integer getTradeWay(Integer payWay) {
        // 交易方式 1-委托代扣、2-POSS划扣、3-金账户充值、4-汇款
        // payWay 1,"汇款" 2,"委托划扣"3,"直接划扣"
        Integer tradeWay = 0;
        switch (payWay) {
            case 1:
                tradeWay = 4;
                break;
            case 2:
                tradeWay = 1;
                break;
            case 3:
                tradeWay = 2;
                break;
        }
        return tradeWay;
    }

    private Integer getCertType(Integer idType) {
        // idType 1, "身份证" 2, "护照" 3, "军官证" 4, "港澳居民往来大陆通行证"
        // certType 1 身份证 2,军人证 3.护照 6 港澳居民来往内地通行证
        Integer certType = 0;
        switch (idType) {
            case 1:
                certType = 1;
                break;
            case 2:
                certType = 3;
                break;
            case 3:
                certType = 2;
                break;
            case 4:
                certType = 6;
                break;
        }
        return certType;
    }

    private boolean checkDealRecordDTO(DealRecordDTO dealRecordDTO) {
        Assert.notNull("推送数据dealRecordDTO不能为空", dealRecordDTO);
        LOG.info("***checkDealRecordDTO()  dealRecordDTO={}", new Gson().toJson(dealRecordDTO));
        if (!Assert.checkParam(dealRecordDTO.getOrderNo())) {
            LOG.error("***业务流水号不存在***");
            return false;
        }
        if (!dealRecordDTO.getBizSource().equals(1)) {
            LOG.error("***业务来源错误***");
            return false;
        }
        if (!dealRecordDTO.getBizType().equals(1) && !dealRecordDTO.getBizType().equals(2)
                && !dealRecordDTO.getBizType().equals(5)) {
            LOG.error("***业务类型错误***");
            return false;
        }
        if (!dealRecordDTO.getBizType().equals(5)) {
            if (!dealRecordDTO.getTradeWay().equals(1) && !dealRecordDTO.getTradeWay().equals(2)
                    && !dealRecordDTO.getTradeWay().equals(4)) {
                LOG.error("***交易方式错误***");
                return false;
            }
            if (!dealRecordDTO.getTradeType().equals(1)) {
                LOG.error("***交易类型错误***");
                return false;
            }
            if (!Assert.checkParam(dealRecordDTO.getBankCode())) {
                LOG.error("***开户银行编码不能为空***");
                return false;
            }
            if (!Assert.checkParam(dealRecordDTO.getSubBank())) {
                LOG.error("***支行不能为空***");
                return false;
            }
            if (!Assert.checkParam(dealRecordDTO.getBankAccount())) {
                LOG.error("***银行账号不能为空***");
                return false;
            }
        }

        if (!Assert.checkParam(dealRecordDTO.getCustName())) {
            LOG.error("***客户姓名不能为空***");
            return false;
        }
        if (!Assert.checkParam(dealRecordDTO.getCertNo())) {
            LOG.error("***证件号码不能为空***");
            return false;
        }
        if (!Assert.checkParam(dealRecordDTO.getMobileNo())) {
            LOG.error("***手机号码不能为空***");
            return false;
        }
        if (!Assert.checkParam(dealRecordDTO.getTradeAmount())) {
            LOG.error("***交易金额不能为空***");
            return false;
        }

        // if (!Assert.checkParam(dealRecordDTO.getCreateUser())) {
        // LOG.error("***操作人不能为空***");
        // return false;
        // }
        return true;
    }

    @Override
    public List<DealDetailDto> getDealDetailDtoList(Long lenderApplyId, Long userId) {
        Assert.notNull("**getDealDetailDtoList() lenderApplyId can not be null**", lenderApplyId);
        Assert.notNull("**getDealDetailDtoList() userId can not be null**", userId);
        LOG.info("**getDealDetailDtoList() lenderApplyId={},userId={}***", lenderApplyId, userId);
        QueryRecordDTO queryRecordDTO = getRecordByLenderApplyId(lenderApplyId, userId);
        List<DealDetailDTO> dealDetailDTOs = queryRecordDTO.getDealDetailDTOList();
        List<DealDetailDto> result = new ArrayList<DealDetailDto>();
        if (Assert.checkParam(dealDetailDTOs)) {
            for (DealDetailDTO dealDetailDTO : dealDetailDTOs) {
                LOG.info("***交易明细记录  dealDetailDTO={}***", new Gson().toJson(dealDetailDTO));
                DealDetailDto dealDetailDto = new DealDetailDto();
                dealDetailDto.setTradeCommitTime(DateUtils.formatForFull(dealDetailDTO.getTradeCommitTime()));

                dealDetailDto.setTradeAmount(dealDetailDTO.getTradeAmount());
                if (dealDetailDTO.getTradeResult() >= 0) {
                    dealDetailDto.setTradeResult(getTradeResult(dealDetailDTO.getTradeResult()));
                } else {
                    dealDetailDto.setTradeResult("-");
                }
                dealDetailDto.setRemark(dealDetailDTO.getRemark() == null ? "-" : dealDetailDTO.getRemark());
                result.add(dealDetailDto);
            }
        }
        return result;
    }

    private String getTradeResult(Integer tradeResult) {
        String dealTradeResult = "-";
        switch (tradeResult) {
            case 0:
                dealTradeResult = "失败";
                break;
            case 1:
                dealTradeResult = "成功";
                break;
            case 2:
                dealTradeResult = "部分交易";
                break;
            case 3:
                dealTradeResult = "平台处理中";
                break;
        }
        return dealTradeResult;
    }

    private QueryRecordDTO getRecordByLenderApplyId(Long lenderApplyId, Long userId) {
        LOG.info("**getRecordByLenderApplyId lenderApplyId={},userId={}**", lenderApplyId, userId);
        // QueryRecordDTO queryRecordDTO = financeDataProcessService.queryDealDetail(getParamRecordDTO(lenderApplyId,
        // userId));
        // 查询当前ID对应的流水号
        InvokeLog invokeLog = invokeLogService.queryFailByLenderApplyId(lenderApplyId);
        Assert.notNull("调用记录为空", invokeLog);
        String lenderCode = invokeLog.getLenderCode();
        Assert.notNull("lenderCode为空", lenderCode);
        List<QueryRecordDTO> queryRecordDTOs = commonService.queryDealDetail(getParamRecordDTO(lenderApplyId));
        Assert.notNull("查询记录集为空", queryRecordDTOs);
        QueryRecordDTO queryRecordDTO = new QueryRecordDTO();
        for (QueryRecordDTO newQueryRecordDTO : queryRecordDTOs) {
            if (StringUtils.equalsIgnoreCase(newQueryRecordDTO.getBizCode(), lenderCode)) {
                BeanUtils.copyProperties(newQueryRecordDTO, queryRecordDTO);
            }
        }
        LOG.info("**getRecordByLenderApplyId queryRecordDTO={}**", queryRecordDTO);
        Assert.notNull("查询记录为空", queryRecordDTO);
        return queryRecordDTO;
    }

    private ParamRecordDTO getParamRecordDTO(Long lenderApplyId) {
        ParamRecordDTO paramRecordDTO = new ParamRecordDTO();
        paramRecordDTO.setBizId(lenderApplyId);
        paramRecordDTO.setBizSource(1);
        paramRecordDTO.setTradeType(1);
        return paramRecordDTO;
    }

    @Override
    @Transactional
    public Boolean pushDealDataByLenderApplyId(Long lenderApplyId, Long userId) {
        LenderApply lenderApply = applyDao.queryById(LenderApply.class, lenderApplyId);
        if (!Assert.checkParam(lenderApply.getParentId())) {
            Assert.notNull("**pushDealDataByLenderApplyId() lenderApply can not be null**", lenderApply);
            LOG.info("**pushDealDataByLenderApplyId() lenderApplyId={},userId={},lenderApply={}***", lenderApplyId,
                    userId, lenderApply);
            Map<String, ProcessResultDTO> result = new HashMap<String, ProcessResultDTO>();
            List<CustomerInfoDTO> customerInfoDTOs = new ArrayList<CustomerInfoDTO>();
            CustomerInfoDTO customerInfoDTO = getPushDealDate(lenderApplyId, userId);
            if (!Assert.checkParam(customerInfoDTO.getBizSource())) {
                return true;
            }
            customerInfoDTOs.add(customerInfoDTO);
            result = commonService.pushCustInfoDealData(customerInfoDTOs);
            if (!Assert.checkParam(result)) {
                throw new BaseException("***pushDealDataByLenderApplyId 推送数据返回结果集为空***");
            }
            String custName = customerInfoDTO.getCustomerName();
            ProcessResultDTO processResultDTO = result.get(custName);
            if (!Assert.checkParam(processResultDTO) || !Assert.equals(processResultDTO.getIsSuccess(), 1)) {
                throw new BaseException(" pushDealDataByLenderApplyId 推送数据返回结果异常  " + result.get(custName).getMsg());
            }
        }
        return true;
    }

    // 获取客户信息
    private CustomerInfoDTO getPushDealDate(Long lenderApplyId, Long userId) {
        Assert.notNull("**pushDealDataByLenderApplyId() lenderApplyId can not be null**", lenderApplyId);
        Assert.notNull("**pushDealDataByLenderApplyId() userId can not be null**", userId);
        PushRecordDto pushRecordDto = lenderApplyService.getPushRecordById(lenderApplyId);
        if (!Assert.checkParam(pushRecordDto)) {
            return new CustomerInfoDTO();
        }
        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
        BeanUtils.copyProperties(pushRecordDto, customerInfoDTO);
        customerInfoDTO.setCertType(getCertType(pushRecordDto.getCertType()));
        customerInfoDTO.setCustomerName(pushRecordDto.getCustName());
        customerInfoDTO.setBizSource(1);
        customerInfoDTO.setMobileNo(pushRecordDto.getSignMobile());
        customerInfoDTO.setBankCode(getbankCode(pushRecordDto.getBankCategory()));
        // 获取凭证影像件
        List<Long> fileIds = getFileIds(lenderApplyId);
        customerInfoDTO.setFileIds(fileIds);
        customerInfoDTO.setCreateUser(userId);
        return customerInfoDTO;
    }
}
