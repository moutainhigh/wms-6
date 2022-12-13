package com.dx.cmm.service.match;

import java.util.List;
import java.util.Set;

import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;
import com.dx.cmm.service.match.result.Match;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

/**
 * 
 * 匹配服务
 *
 * @author tony
 */
public interface IMatchService<IP, CP, IR> {

    /**
     * 
     * 功能描述: <br>
     * 根据条件筛选投资
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<IR>> queryInvest(IP param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 根据条件筛选债权
     *
     * @param param
     * @param page
     * @return
     */
    PaginationResult<List<CreditResult>> queryCredit(CP param, Pagination page);

    /**
     * 
     * 功能描述: <br>
     * 根据用户编号筛选
     *
     * @param userId
     * @return
     */
    MatchCache queryCache(Long userId);

    /**
     * 
     * 功能描述: <br>
     * 匹配一对多或多对多
     *
     * @param userId
     * @param matches
     */
    void match(Long userId, Set<Match> matches) throws MatchException;

    /**
     * 
     * 功能描述: <br>
     * 自动推荐
     *
     * @param userId
     * @return
     */
    List<Match> auto(Long userId);

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号筛选
     *
     * @param poolId
     * @return
     */
    IR queryInvest(Long poolId);

    /**
     * 
     * 功能描述: <br>
     * 加入推荐
     *
     * @param userId
     * @param credits
     * @throws MatchException
     */
    void join(Long userId, Set<CreditResult> credits) throws MatchException;

    /**
     * 
     * 功能描述: <br>
     * 保存〉
     *
     * @param userId
     * @param matches
     * @throws MatchException
     */
    void save(Long userId, Set<Match> matches) throws MatchException;

    /**
     * 
     * 功能描述: <br>
     * 初始化缓存
     *
     * @param userId
     * @param invests
     * @throws MatchException
     */
    void init(Long userId, Set<InvestResult> invests) throws MatchException;

    /**
     * 
     * 功能描述: <br>
     * 移除推荐队列
     *
     * @param userId
     * @param matches
     * @param invests
     * @param credits
     * @throws MatchException
     */
    void remove(Long userId, Set<Match> matches, Set<InvestResult> invests, Set<CreditResult> credits)
            throws MatchException;

    /**
     * 
     * 功能描述: <br>
     * 根据资金池编号筛选当前匹配人
     *
     * @param poolId
     * @param type
     * @return
     */
    Long current(Long poolId, Class<?> type);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param targets
     * @return
     */
    Long current(List<InvestResult> targets);
}
