/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICustAccountDao.java
 * Author:   王蕊
 * Date:     2015年7月20日 下午7:18:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dao;

import java.util.List;

import com.dx.wms.base.IBaseDao;
import com.dx.wms.bean.CustAccount;
import com.dx.wms.dto.LenderManagermentDataDto;

/**
 * 客户账户Dao层
 *
 * @author 王蕊
 */
public interface ICustAccountDao extends IBaseDao<CustAccount> {
    
    /**
     * 
     * 查询某门店当天开户列表
     *
     * @param orgId 门店
     * @return 客户账户
     */
    List<LenderManagermentDataDto> queryByOrgIdAndToday(Long orgId);  
    
    /**
     * 
     * 理财客户编号查询客户账户
     *
     * @param lenderCustCode 理财客户编号
     * @return 客户账户
     */
    CustAccount queryByLenderCustCode(String lenderCustCode);
}
