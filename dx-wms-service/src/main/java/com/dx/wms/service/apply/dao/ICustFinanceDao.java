/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICustFinance.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午9:17:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply.dao;

import java.util.List;

import com.dx.wms.common.IBaseDao;
import com.dx.wms.service.apply.entity.CustFinance;

/**
 * 客户金融表 dao层 接口
 *
 * @author 朱道灵
 */
public interface ICustFinanceDao extends IBaseDao<CustFinance> {

    /**
     * 通过客户账户编号查询 客户账户表全对象
     * 
     * @param accountId 客户帐户编号
     * @return 客户金融表对象
     *
     */
    CustFinance queryByParam(Long accountId);

    /**
     * 
     * 根据客户账户编号和账户类别查询客户账户表全对象
     *
     * @param custAccountId客户帐户编号
     * @param accountCategory账户类别
     * @return客户金融表对象
     */
    CustFinance queryByParam(Long accountId, Integer category);

    /**
     * 
     * 功能描述: 根据客户账户ID查询客户金融表
     *
     * @param accountId
     * @return
     */
    List<CustFinance> queryByAccount(Long accountId);

    /**
     * 
     * 功能描述: 根据理财申请表ID查询对应的金融表
     *
     * @param applyId
     * @param accountCategory
     * @return
     */
    List<CustFinance> queryByApply(Long applyId);

    /**
     * 
     * 功能描述: 根据客户编号更新客户金融表的户名和更新者 〈功能详细描述〉
     *
     * @param userId
     * @param custAccountId
     * @param accountName
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean updateAccountNameByAccountId(Long userId, Long custAccountId, String accountName);

}
