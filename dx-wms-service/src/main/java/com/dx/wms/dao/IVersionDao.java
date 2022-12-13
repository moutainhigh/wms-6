package com.dx.wms.dao;

import com.dx.wms.common.IBaseDao;
import com.dx.wms.dto.VersionNoticeDto;

public interface IVersionDao extends IBaseDao<VersionNoticeDto> {
    
    /**
     * 
     * 功能描述: 验证本次登录的版本<br>
     * 〈功能详细描述〉
     *
     * @return long 版本id
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Long queryVersion();
    
    /**
     * 
     * 功能描述: 验证用户上次登录版本<br>
     * 〈功能详细描述〉
     *
     * @param user 用户对象
     * @return long 版本id
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    VersionNoticeDto queryVersionNotice(Long userId);
    
    /**
     * 
     * 功能描述: 新增用户信息<br>
     * 〈功能详细描述〉
     *
     * @param user 用户对象
     * @return 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void addVersionNotice(Long userId, Long versionId);
    
    /**
     * 
     * 功能描述: 更新用户登录信息<br>
     * 〈功能详细描述〉
     *
     * @param user 用户对象
     * @param versionId 版本id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateVersionNotice(Long userId, Long versionId);
}


