package com.dx.op.service;

import com.dx.op.dto.AccountInfoDto;

/**
 * 
 * 账户信息服务<br>
 * 账户信息服务
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IAccountInfoService {

    /**
     * 
     * 功能描述: <br>
     * 根据客户编号查询账户信息
     *
     * @param custCode 客户编号
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    AccountInfoDto query(String custCode,String version);
}
