/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: LenderApplyDao.java
 * Author:   朱道灵
 * Date:     2015年7月20日 下午6:58:02
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.dao;

import java.util.List;

import com.dx.wms.base.IBaseDao;
import com.dx.wms.bean.LenderApply;
import com.dx.wms.service.exception.UpdateException;

/**
 * 出借申请表 dao层 接口
 *
 * @author 朱道灵
 */
public interface ILenderApplyDao extends IBaseDao<LenderApply> {

    /**
     * 
     * 通过理财客户Id查询出借申请单列表
     *
     * @param custAccontId 理财客户Id
     * @return 出借申请单列表
     */
    List<LenderApply> queryAccountId(Long custAccontId);

    /**
     * 
     * 通过理财客户编号查询出借申请单列表
     *
     * @param lenderCustCode 财客户编号
     * @return 出借申请单列表
     */
    List<LenderApply> queryByLenderCustCode(String lenderCustCode);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param lenderCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    LenderApply query(String lenderCode);

    void sync(Long applyId, String status) throws UpdateException;

    void sync(Long applyId, Long status) throws UpdateException;

    void sync(LenderApply apply, Long status) throws UpdateException;
}
