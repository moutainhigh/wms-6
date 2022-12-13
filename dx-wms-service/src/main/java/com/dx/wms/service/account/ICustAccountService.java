package com.dx.wms.service.account;

import java.util.List;
import java.util.Map;

import com.dx.cms.dto.Condition;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;
import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.account.dto.ParamAccount;
import com.dx.wms.service.account.dto.ResultAccount;
import com.dx.wms.service.account.entity.CustAccount;
import com.dx.wms.service.account.entity.CustComm;
import com.dx.wms.service.account.entity.CustLinkman;
import com.dx.wms.service.account.entity.CustProfession;
import com.dx.wms.service.base.CustViewDto;
import com.dx.wms.service.save.HandlerDto;
import com.dx.wms.service.saver.ResultSaver;

/**
 * 客户账户表 service
 *
 * @author 王蕊
 */
public interface ICustAccountService {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    CustAccount queryById(Long id);

    /**
     * 
     * 功能描述: 根据条件查询开户信息关联账户级别表
     *
     * @param custAccountApplyQuerytDto 客户账户申请数据库查询DTO
     * @param pagination 页面数据
     * @return
     */
    PaginationResult<List<ResultAccount>> queryForPage(ParamAccount param, Pagination page);

    /**
     * 
     * 根据custAccountId查询客户开户管理信息以及理财信息
     *
     * @param custAccountId
     * @return
     */
    CustAccountApplyDto queryCustAccountDtoById(Long custAccountId);

    /**
     * 
     * 功能描述: 根据理财编号查询客户开户管理信息以及理财信息 根据lenderApplyId 查询 投资信息
     *
     * @param lenderApplyId
     * @return
     */
    CustAccountApplyDto queryCustAccountDtoByLenderApplyId(Long lenderApplyId);

    /**
     * 
     * 功能描述: 根据潜在客户ID和 开户客户ID 获取客户开户信息 〈功能详细描述〉
     *
     * @param custId潜在客户ID
     * @param custAccountId开户客户ID
     * @return 客户开户信息
     */
    CustAccountApplyDto getCustAccountApplyDto(Long custId, Long custAccountId);

    /**
     * 
     * 功能描述: 根据客户开户ID查询客户状态
     *
     * @param custAccountId
     * @return
     */
    int getAccountStatusByCustAccountId(Long custAccountId);

    /**
     * 
     * 功能描述: 开户 〈功能详细描述〉
     *
     * @param custAccountId
     * @param userId
     * @param conditionsDto
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean createUserAccount(Long userId, Condition conditionsDto);

    /**
     * 
     * 功能描述: 根据业务编号查询客户账户表信息 〈功能详细描述〉
     *
     * @param lenderApplyId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    CustAccount queryByLenderApplyId(Long lenderApplyId);

    /**
     * 
     * 保存客户开户信息
     *
     * @param custAccountApplyDto
     * @return
     */
    CustAccountApplyDto saveCustAccount(CustAccountApplyDto custAccountApplyDto);

    /**
     * 
     * 功能描述: 保存客户变更及变更数据推送运营匹配系统 〈功能详细描述〉
     *
     * @param custViewDto
     * @param custAccountApplyVo
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> save(CustViewDto custViewDto, CustAccountApplyDto custAccountApplyDto, Long userId);

    /**
     * 
     * 功能描述: 保存客户开户信息 〈功能详细描述〉
     *
     * @param paramSaver
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void saveAccount(CustAccount account, HandlerDto dto, ResultSaver result);

    /**
     * 
     * 功能描述: 保存客户通信信息 〈功能详细描述〉
     *
     * @param paramSaver
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void saveComm(CustComm comm, HandlerDto dto, ResultSaver result);

    /**
     * 
     * 功能描述:保存联系人信息 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void saveLinkman(CustLinkman linkman, HandlerDto dto, ResultSaver result);

    /**
     * 
     * 功能描述: 保存职业信息 〈功能详细描述〉
     *
     * @param profession
     * @param dto
     * @param result
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void saveProfession(CustProfession profession, HandlerDto dto, ResultSaver result);
}
