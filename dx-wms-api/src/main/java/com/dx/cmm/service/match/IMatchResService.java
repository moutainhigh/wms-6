package com.dx.cmm.service.match;

import java.util.List;
import java.util.Set;

import com.dx.cmm.service.match.result.CreditResult;
import com.dx.cmm.service.match.result.InvestResult;

/**
 * 
 * 匹配资源服务
 *
 * @author tony
 */
public interface IMatchResService {

    /**
     * 
     * 功能描述: <br>
     * 全部匹配资源
     * 
     * @return
     */
    List<MatchCache> queryAll();

    /**
     * 
     * 功能描述: <br>
     * 根据用户筛选投资
     *
     * @param userId
     * @return
     */
    Set<InvestResult> queryInvest(Long userId);

    /**
     * 
     * 功能描述: <br>
     * 根据用户筛选债权
     *
     * @param userId
     * @return
     */
    Set<CreditResult> queryCredit(Long userId);

    /**
     * 
     * 功能描述: <br>
     * 根据用户销毁资源
     *
     * @param userId
     * @throws MatchException
     */
    void destory(Long userId) throws MatchException;
    
   
    
    
  
}
