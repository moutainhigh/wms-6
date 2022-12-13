package com.dx.wms.service.apply;

import java.util.List;
import java.util.Map;

import com.dx.wms.service.account.dto.CustAccountApplyDto;
import com.dx.wms.service.apply.entity.CustFinance;
import com.dx.wms.service.apply.entity.LenderApply;
import com.dx.wms.service.apply.entity.LenderCondition;
import com.dx.wms.service.save.HandlerDto;
import com.dx.wms.service.saver.ResultSaver;

public interface ILenderApplySaveService {

    /**
     * 
     * 保存客户理财申请信息
     *
     * @param custAccountApplyDto
     * @return
     */
    CustAccountApplyDto saveLenderApply(CustAccountApplyDto custAccountApplyDto);

    /**
     * 
     * 功能描述: 投资信息变更保存 〈功能详细描述〉
     *
     * @param lenderApply
     * @param custAccountApplyDto
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Map<String, Object> save(LenderApply lenderApply, CustAccountApplyDto custAccountApplyDto, Long userId);

    /**
     * 
     * 功能描述: 理财申请信息保存 〈功能详细描述〉
     *
     * @param apply
     * @param dto
     * @param result
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void saveAppy(LenderApply apply, HandlerDto dto, ResultSaver result);

    /**
     * 
     * 功能描述: 金融信息表保存 〈功能详细描述〉
     *
     * @param apply
     * @param dto
     * @param result
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void saveFinances(List<CustFinance> finances, HandlerDto dto, ResultSaver result);

    /**
     * 
     * 功能描述: 特殊情况信息保存 〈功能详细描述〉
     *
     * @param condition
     * @param dto
     * @param result
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void saveConditions(List<LenderCondition> conditions, HandlerDto dto, ResultSaver result);
    
    /**
     *保存自定义的支行
     */
    void saveSubBank(List<CustFinance> list);
}
