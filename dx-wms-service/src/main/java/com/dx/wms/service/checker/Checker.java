/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICustInfoService.java
 * Author:   王蕊
 * Date:     2015年7月22日 下午8:27:02
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.checker;

import java.util.Map;

/**
 * 验证器
 *
 * @author 王蕊
 */
public interface Checker {

    /**
     * 校验客户手机号码和身份证和惟一性
     *
     * @param ParamChecker
     * @return
     */
    Boolean check(ParamChecker custInfoCheckDto);

    /**
     * 校验合同编号惟一性
     *
     * @param ParamChecker
     * @return CustInfoCheckVo
     */
    Boolean checkContractCode(ParamChecker custInfoCheckDto);

    /**
     * 
     * 客户 手机号码 身份证号码校验
     *
     * @param custId
     * @param mobile
     * @param idCard
     * @return
     */
    Map<String, Object> checkCustFullInfo(Long custId, String mobile, String idCard);

    /**
     * 校验合同编号惟一性
     *
     * @param contractCode
     * @return
     */
    Map<String, Object> checkContractCode(String contractCode);

    /**
     * 
     * 校验客户编号是否存在 〈功能详细描述〉
     *
     * @param lenderCustCode
     * @return
     */
    Boolean checkLenderCustCode(String lenderCustCode);

    /**
     * 
     * 根据parentId查询判断 申请金额是否超过原有的本金
     *
     * @param parentId
     * @return
     */
    Boolean checkLenderAmountExceed(Long parentId, String lenderAmount);

    /**
     * 
     * 根据客户编号查询 客户账户表中 存在多少条该客户编号的数据 
     *
     * @param custCode
     * @return true 存在 false 不存在
     */
    Boolean checkCustCodeExist(String custCode);
}
