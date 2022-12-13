package com.dx.cmm.service.pools;

import java.util.List;
import java.util.Set;

import com.dx.cmm.enums.MatchStatus;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 投资资金池Dao
 *
 * @author tony
 */
public interface IInvestmentPoolDao extends IBaseDao<InvestmentPool> {

    /**
     * 
     * 功能描述: <br>
     * 根据基础编号筛选
     *
     * @param baseId
     * @return
     */
    InvestmentPool query(Long baseId);

    /**
     * 
     * 功能描述: <br>
     * 根据端口及状态筛选
     *
     * @param port
     * @param status
     * @return
     */
    List<InvestmentPool> queryArray(Integer port, MatchStatus... status);
    
    /**
     * 
     * 功能描述: <br>
     * 根据端口及状态筛选
     *
     * @param port
     * @param status
     * @return
     */
    List<InvestmentPool> queryArray(Integer port,Long productId, MatchStatus... status);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号集合筛选
     *
     * @param ids
     * @return
     */
    List<InvestmentPool> queryArray(Set<Long> ids);
}
