package com.dx.wms.service;

import java.util.List;
import java.util.Map;

import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.dto.LenderApplyQueryDto;
import com.dx.wms.dto.LenderApplyResultDto;
import com.dx.wms.dto.LenderManagermentDataDto;
import com.dx.wms.dto.PushDataDto;
import com.dx.wms.dto.PushResultDto;

/**
 * 
 * 〈一句话功能简述〉理财信息管理服务 〈功能详细描述〉
 *
 * @author 王蕊
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ILenderManagermentService {

    /**
     * 功能描述: 出资确认成功失败 修改状态
     *
     * @param pushDataDtos
     * @return
     */
    Map<String, PushResultDto> pushContributiveConfirmResult(List<PushDataDto> pushDataDtos);

    /**
     * 理财单信息查询
     *
     * @param lenderApplyQueryDto 条件封装dto对象
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    PaginationResult<List<LenderApplyResultDto>> queryLendersInfo(LenderApplyQueryDto lenderApplyQueryDto);

    /**
     * 
     * 理财客户编号查询客户账户
     *
     * @param lenderCustCode 理财客户编号
     * @return 客户账户
     */
    LenderManagermentDataDto queryAccountByLenderCustCode(String lenderCustCode);

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
     * 通过理财客户编号查询出借申请单列表
     *
     * @param lenderCustCode 财客户编号
     * @return 出借申请单列表
     */
    List<LenderManagermentDataDto> queryLendersByLenderCustCode(String lenderCustCode);

    /**
     * 
     * 通过理财客户Id查询出借申请单列表
     *
     * @param custAccontId 理财客户Id
     * @return 出借申请单列表
     */
    List<LenderManagermentDataDto> queryByCustAccountId(Long custAccontId);

}
