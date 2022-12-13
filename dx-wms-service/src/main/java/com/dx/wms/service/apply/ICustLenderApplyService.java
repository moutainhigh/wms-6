/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ICustApplyService.java
 * Author:   王蕊
 * Date:     2015年7月31日 下午1:25:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 */
package com.dx.wms.service.apply;

import java.util.List;

import com.dx.cmm.dto.PushData;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.apply.dto.ParamApplicant;
import com.dx.wms.service.apply.dto.ResultApplicant;
import com.dx.wms.service.apply.entity.LenderApply;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 王蕊
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public interface ICustLenderApplyService {

    /**
     * 
     * 根据条件查询投资变更信息
     *
     * @param convertQuery
     * @param pagination
     * @return
     */
    PaginationResult<List<ResultApplicant>> queryInvestForPage(ParamApplicant custApplyQueryDto, Pagination pagination);

    /**
     * 
     * 功能描述: 根据 理财申请ID查询 当前 步骤
     *
     * @param lenderApplyId
     * @return
     */
    String getCurrentStepKeyByLenderApplyId(Long lenderApplyId);

    /**
     * 
     * 功能描述: 根据理财申请ID查询到 对应的客户基础表和客户开户表，修改状态为认证状态，使此时数据不再能修改
     *
     * @param apply
     * @return
     */
    void update(LenderApply apply);

    /**
     * 
     * 功能描述: 根据客户开户ID获得客户的开户信息 〈功能详细描述〉
     * 
     * @param lenderApplyId 理财申请ID
     * @param custAccountId 客户开户编号
     * @return
     */
    CustAccountApplyDto getCustAccountApplyDto(Long custAccountId, Long lenderApplyId);

    /**
     * 
     * 功能描述: 投资信息变更数据匹配推送 〈功能详细描述〉
     *
     * @param lenderApplyId 理财申请ID
     * @return PushDataDto
     */
    PushData getPushDataDto(LenderApply apply,String contractCode);

}
