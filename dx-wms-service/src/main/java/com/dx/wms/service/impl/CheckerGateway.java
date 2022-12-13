/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: CustInfoServiceImpl.java
 * Author:   王蕊
 * Date:     2015年7月22日 下午8:30:59
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.service.account.dao.ICustAccountDao;
import com.dx.wms.service.apply.dao.ILenderApplyDao;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.checker.Checker;
import com.dx.wms.service.checker.ParamChecker;
import com.google.gson.Gson;

@Service
public class CheckerGateway implements Checker {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CheckerGateway.class);

    @Autowired
    private ILenderApplyDao applyDao;
    /**
     * dalClient
     */
    @Autowired
    private PaginationDalClient dalClient;

    @Autowired
    private ICustAccountDao custAccountDao;

    @Override
    public Boolean check(ParamChecker check) {
        Assert.notNull("Check must not be null", check);
        LOG.info("Check[{}]", new Gson().toJson(check));
        if (!Assert.checkParam(check.getIdCard()) && !Assert.checkParam(check.getMobile())) {
            return true;
        }
        return !Assert.checkParam(dalClient.queryForMap("custBase.checkCustInfo", MapUtils.obj2Map(check)));
    }

    @Override
    public Boolean checkContractCode(ParamChecker check) {
        Assert.notNull("**checkContractCode() CustInfoCheckDto can not be null**", check);
        LOG.info("**checkContractCode() CustInfoCheckDto={}", new Gson().toJson(check));
        return !Assert.checkParam(dalClient.queryForMap("lenderApply.checkLenderInfo", MapUtils.obj2Map(check)));
    }

    @Override
    public Map<String, Object> checkCustFullInfo(Long custId, String mobile, String idCard) {
        LOG.info("**checkCustFullInfo() custId={},mobile={},idCard={}**", custId, mobile, idCard);
        if (!Assert.checkParam(mobile) && !Assert.checkParam(idCard)) {
            throw new BaseException("**checkCustFullInfo() mobile,idCard can not both null**");
        }
        Map<String, Object> result = new HashMap<String, Object>();
        ParamChecker custInfoCheckDto = new ParamChecker();
        custInfoCheckDto.setCustId(Assert.checkParam(custId) ? custId : null);
        if (Assert.checkParam(mobile)) {
            custInfoCheckDto.setMobile(mobile);
            if (!check(custInfoCheckDto)) {
                result.put(WMSConstants.CODE, false);
                result.put(WMSConstants.MSG, "您填写的手机号码重复");
                return result;
            }
        }
        if (Assert.checkParam(idCard)) {
            custInfoCheckDto.setMobile("");
            custInfoCheckDto.setIdCard(idCard);
            if (!check(custInfoCheckDto)) {
                result.put(WMSConstants.CODE, false);
                result.put(WMSConstants.MSG, "您填写的证件号码重复");
                return result;
            }
        }
        result.put(WMSConstants.CODE, true);
        return result;
    }

    @Override
    public Boolean checkLenderCustCode(String lenderCustCode) {
        return Assert.checkParam(custAccountDao.queryByParam(lenderCustCode));
    }

    @Override
    public Map<String, Object> checkContractCode(String contractCode) {
        LOG.info("**checkContractCode() contractCode={}**", contractCode);
        if (!Assert.checkParam(contractCode)) {
            throw new BaseException("**checkContractCode() contractCode can not  null**");
        }
        Map<String, Object> result = new HashMap<String, Object>();
        ParamChecker custInfoCheckDto = new ParamChecker();
        custInfoCheckDto.setContractCode(Assert.checkParam(contractCode) ? contractCode : null);
        if (Assert.checkParam(contractCode)) {
            custInfoCheckDto.setContractCode(contractCode);
            if (!checkContractCode(custInfoCheckDto)) {
                result.put(WMSConstants.CODE, false);
                result.put(WMSConstants.MSG, "您填写的合同编号重复");
                return result;
            }
        }
        result.put(WMSConstants.CODE, true);
        return result;
    }

    @Override
    public Boolean checkLenderAmountExceed(Long parentId, String lenderAmount) {
        LOG.info("**checkLenderAmountExceed() parentId={}**", parentId);
        // 查询出原理财申请单
        LenderApply lenderApply = applyDao.queryById(LenderApply.class, parentId);
        Assert.notNull("理财申请单为空", lenderApply);
        BigDecimal maxAmount = lenderApply.getLenderAmount();
        BigDecimal amount = new BigDecimal(lenderAmount);
        Assert.notNull("理财申请单出借金额为空", maxAmount);
        LOG.info("**checkLenderAmountExceed() lenderApply={},maxAmount={}**", new Gson().toJson(lenderApply),
                maxAmount);
        if (maxAmount.compareTo(amount) == -1) {
            return true;
        }
        return false;

    }

    @Override
    public Boolean checkCustCodeExist(String custCode) {
        Assert.notNull("**checkCustCodeExist() custAccountId can not be null**", custCode);
        LOG.info("**checkCustCodeExist() custCode={}**", custCode);
        return Assert.checkParam(Integer.valueOf(dalClient.queryForList("custAccount.checkCustCodeExist",
                MapUtils.getParamMap("custCode", custCode), String.class).get(0)));
    }
}
