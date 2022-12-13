package com.dx.cmm.service.users;

import java.util.List;

import com.dx.cmm.exception.SaveException;
import com.dx.cmm.service.base.MatchBizBase;

/**
 * 
 * 用户
 *
 * @author tony
 */
public interface User<T> {

    /**
     * 
     * 功能描述: <br>
     * 根据基础筛选
     *
     * @param base
     * @return
     */
    MatchUser query(MatchBizBase base);

    /**
     * 
     * 功能描述: <br>
     * 根据主键筛选
     *
     * @param id
     * @return
     */
    MatchUser query(Long id);

    /**
     * 
     * 功能描述: <br>
     * 根据身份证筛选
     *
     * @param idCard
     * @return
     */
    MatchUser query(String idCard);

    /**
     * 
     * 功能描述: <br>
     * 根据用户筛选已匹配用户
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Long> queryArray(Long user);

    /**
     * 
     * 功能描述: <br>
     * 保存用户关系
     *
     * @param one
     * @param another
     * @throws SaveException
     */
    void save(Long one, Long another) throws SaveException;
}
