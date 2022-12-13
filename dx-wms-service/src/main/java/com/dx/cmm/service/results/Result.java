package com.dx.cmm.service.results;

import java.util.Date;
import java.util.List;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;

/**
 * 
 * 匹配结果
 *
 * @author tony
 */
public interface Result<T> {

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号、期限及状态筛选
     *
     * @param poolId
     * @param period
     * @param status
     * @return
     */
    List<T> queryArray(Long poolId, Integer period, BizBaseStatus status);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号及报告日筛选
     *
     * @param poolId
     * @param reportDay
     * @return
     */
    List<MatchResult> queryArray(Long poolId, Date reportDay);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号及报告日统计
     *
     * @param poolId
     * @param reportDay
     * @return
     */
    StatResult query(Long poolId, Date reportDay);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号及当前期数筛选
     *
     * @param poolId
     * @param currentPeriod
     * @return
     */
    List<MatchResult> queryArray(Long poolId, Integer currentPeriod);

    /**
     * 
     * 功能描述: <br>
     * 根据脚本筛选
     *
     * @param sqlId
     * @return
     */
    List<MatchResult> queryArray(String sqlId);

    /**
     * 
     * 功能描述: <br>
     * 保存
     *
     * @param result
     * @throws SaveException
     */
    void save(MatchResult result) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 全部
     *
     * @return
     */
    List<MatchResult> queryAll();

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号及源状态同步
     *
     * @param poolId
     * @param source
     * @param target
     */
    void sync(Long poolId, Integer period, BizBaseStatus source, BizBaseStatus target) throws SaveException;
}
