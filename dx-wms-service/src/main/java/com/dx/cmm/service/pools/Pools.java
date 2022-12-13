package com.dx.cmm.service.pools;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dx.cmm.enums.MatchStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.base.MatchBizBase;

/**
 * 
 * 资金池
 *
 * @author tony
 */
public interface Pools<T> {

    /**
     * 
     * 功能描述: <br>
     * 保存
     *
     * @param pool
     * @throws SaveException
     */
    void save(T pool) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 根据主键筛选
     *
     * @param id
     * @return
     */
    T query(Long id);

    /**
     * 
     * 功能描述: <br>
     * 根据基础数据筛选
     *
     * @param base
     * @return
     */
    T query(MatchBizBase base);

    /**
     * 
     * 功能描述: <br>
     * 根据端口,产品及状态筛选
     *
     * @param port
     * @param status
     * @return
     */
    List<T> queryArray(Integer port,Long productId, MatchStatus... status);
    
    /**
     * 
     * 功能描述: <br>
     * 根据端口及状态筛选
     *
     * @param port
     * @param status
     * @return
     */
    List<T> queryArray(Integer port, MatchStatus... status);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号集合筛选
     *
     * @param poolIds
     * @return
     */
    List<T> queryArray(Set<Long> ids);

    /**
     * 
     * 功能描述: <br>
     * 筛选全部
     *
     * @return
     */
    List<T> queryAll();

    /**
     * 
     * 功能描述: <br>
     * 基础数据是否存在
     * 
     * @param base
     * @return true:存在 <br>
     *         false:不存在
     */
    Boolean exists(MatchBizBase base);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池集合聚合
     *
     * @param pools
     * @return
     */
    Map<Long, T> group(List<T> pools);

}
