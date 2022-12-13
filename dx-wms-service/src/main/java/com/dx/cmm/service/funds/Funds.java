package com.dx.cmm.service.funds;

import java.util.Date;
import java.util.List;

import com.dx.cmm.exception.SaveException;

/**
 * 
 * 资金
 *
 * @author tony
 */
public interface Funds<T> {

    /**
     * 
     * 功能描述: <br>
     * 保存
     *
     * @param fund
     * @throws SaveException
     */
    void save(T fund) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号及期数筛选
     *
     * @param poolId
     * @param period
     * @return
     */
    T query(Long poolId, Integer period);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号筛选当前资金
     *
     * @param poolId
     * @return
     */
    T query(Long poolId);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号及报告日筛选
     *
     * @param poolId
     * @param reportDay
     * @return
     */
    T query(Long poolId, Date reportDay);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号筛选
     *
     * @param poolId
     * @return
     */
    List<T> queryArray(Long poolId);

    /**
     * 
     * 功能描述: <br>
     * 根据sql筛选〉
     *
     * @param sqlId
     * @return
     */
    List<T> queryArray(String sqlId);

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
     * 根据资金池编号筛选最新期限
     *
     * @param poolId
     * @return
     */
    Integer current(Long poolId);

    /**
     * 
     * 功能描述: <br>
     * 根据主键执行推送
     *
     * @param id
     * @throws SaveException
     */
    void exe(Long id) throws SaveException;

}
