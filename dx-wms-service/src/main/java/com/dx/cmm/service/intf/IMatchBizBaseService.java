package com.dx.cmm.service.intf;

import java.util.List;

import com.dx.cmm.enums.BizBaseStatus;
import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.base.MatchBizBase;

/**
 * 
 * 匹配业务基础服务
 *
 * @author tony
 */
public interface IMatchBizBaseService {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param inner
     * @param bases
     */
    void save(Boolean inner, MatchBizBase... bases) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param id
     * @param status
     * @throws SaveException
     */
    void save(Long id, BizBaseStatus status) throws SaveException;

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param bizCode
     * @return
     */
    MatchBizBase query(String bizCode);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param billDay
     * @param status
     * @return
     */
    List<MatchBizBase> query(Integer billDay, BizBaseStatus... status);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param bizCode
     * @return
     */
    Boolean exists(String bizCode);
}
