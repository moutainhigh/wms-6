package com.dx.cmm.service.pools;

import java.util.List;
import java.util.Set;

import com.dx.cmm.enums.MatchStatus;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 债权池Dao
 *
 * @author tony
 */
public interface ICreditorPoolDao extends IBaseDao<CreditorPool> {

    /**
     * 
     * 功能描述: <br>
     * 根据基础业务编号筛选
     *
     * @param baseId
     * @return
     */
    CreditorPool query(Long baseId);

    /**
     * 
     * 功能描述: <br>
     * 根据端口及状态筛选
     *
     * @param port
     * @param matchStatus
     * @return
     */
    List<CreditorPool> queryArray(Integer port, MatchStatus... matchStatus);
    
    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号集合筛选
     *
     * @param ids
     * @return
     */
    List<CreditorPool> queryArray(Set<Long> ids);

}
