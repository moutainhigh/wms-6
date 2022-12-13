package com.dx.cmm.service.results;

import java.util.Date;
import java.util.List;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.dto.TransferTotalDto;
import com.dx.wms.common.IBaseDao;

/**
 * 
 * 匹配结果表Dao
 *
 * @author tony
 */
public interface IMatchResultDao extends IBaseDao<MatchResult> {

    /**
     *
     * 获取收益汇总
     *
     * @param poolId
     * @param period
     * @return
     */
    TransferTotalDto getTotalIncome(Long poolId, Integer period);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号、类型及期限筛选
     *
     * @param poolId
     * @param type
     * @param period
     * @return
     */
    List<MatchResult> queryArray(Long poolId, Class<?> type, Integer period);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号及类型筛选
     *
     * @param poolId
     * @param type
     * @return
     */
    List<MatchResult> queryArray(Long poolId, Class<?> type);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号、类型及报告日筛选
     *
     * @param poolId
     * @param type
     * @param reportDay
     * @return
     */
    List<MatchResult> queryArray(Long poolId, Class<?> type, Date reportDay);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号及源状态同步
     *
     * @param poolId
     * @param type
     * @param source
     * @param target
     * @throws SaveException
     */
    void sync(Long poolId, Class<?> type, BizBaseStatus source, BizBaseStatus target) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 剩余债权计算
     *
     * @param results
     */
    void remain(List<MatchResult> results);

    /**
     * 
     * 功能描述: <br>
     * 获取异常数据
     *
     * @return
     */
    List<MatchResult> queryError();

    /**
     * 
     * 功能描述: <br>
     * 根据sql筛选
     *
     * @param sqlId
     * @return
     */
    List<MatchResult> queryArray(String sqlId);

    /**
     * 
     * 功能描述: <br>
     * 根据债权池编号及报告日汇总
     *
     * @param poolId
     * @param reportDate
     * @return
     */
    StatResult sum(Long poolId, Date reportDate, Class<?> type);

}
