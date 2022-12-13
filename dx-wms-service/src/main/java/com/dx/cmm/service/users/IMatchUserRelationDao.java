package com.dx.cmm.service.users;

import java.util.List;

import com.dx.wms.common.IBaseDao;

/**
 * 
 * 匹配用户关联Dao<br>
 * 匹配用户关联Dao
 *
 * @author tony
 */
public interface IMatchUserRelationDao extends IBaseDao<MatchUserRelation> {

    /**
     * 
     * 功能描述: <br>
     * 根据用户筛选
     *
     * @param userId
     * @param type
     * @return
     */
    List<MatchUserRelation> queryArray(Long userId, Class<?> type);

}
