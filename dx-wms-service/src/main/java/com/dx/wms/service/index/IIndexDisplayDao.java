/*
 * Copyright (C), 2013-2015, 达信财富投资管理（上海）有限公司
 * FileName: BaseDao.java
 * Author:   朱道灵
 * Date:     2013年11月21日 下午2:37:00
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.service.index;

import java.math.BigDecimal;
import java.util.List;

/**
 * 首页数据显示dto
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IIndexDisplayDao {

    /**
     * 1.客户基数(客户经理)
     *
     * @param createUser 客户经理
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryForCustNumberByCreateUser(Long createUser);
    
    /**
     * 
     * 1.客户基数(销售客服)
     *
     * @param createUsers
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryForCustNumberByOrgId(List<Long> createUsers);
    
    /**
     * 1.生效投资数(执委会)
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer querySuccessApplyNum();
    
    /**
     * 2.被拒绝的单数(客户经理/销售客服/执委会)
     *
     * @param createUser 客户经理
     * @param orgId 营业部
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryForRefusedApplyNum(Long createUser,Long orgId);

    /**
     * 3.开户基数(客户经理)
     *
     * @param createUser    客户经理
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryCustAccountNumByCreateUser(Long createUser);
    
    /**
     * 3.待质检申请单数(销售客服)
     *
     * @param orgId 营业部
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryForPendingQualityNum(Long orgId);
    
    /**
     * 3.待投资审核申请单数(执委会)
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryForPendingCheckNum();

    /**
     * 4.开户基数(销售客服)
     *
     * @param orgId 营业部
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryCustAccountNumByOrgId(Long orgId);

    /**
     * 5.投资总额(客户经理)
     *
     * @param createUser 客户经理
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    BigDecimal queryForSumByCreateUser(Long createUser);

    /**
     * 5.投资总额(销售客服)
     *
     * @param orgId 营业部
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    BigDecimal queryForSumByOrgId(Long orgId);

    /**
     * 5.投资总额(执委会)
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    BigDecimal queryForSum();

}
