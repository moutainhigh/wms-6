package com.dx.cmm.service.users;

import com.dx.wms.common.IBaseDao;

/**
 * 
 * 匹配用户Dao<br>
 * 匹配用户Dao
 *
 * @author tony
 */
public interface IMatchUserDao extends IBaseDao<MatchUser> {

    /**
     * 
     * 根据身份证筛选〉
     *
     * @param idCard
     * @return
     */
    MatchUser query(String idCard);

    /**
     * 
     * 根据主键筛选
     *
     * @param id
     * @return
     */
    MatchUser query(Long id);

}
