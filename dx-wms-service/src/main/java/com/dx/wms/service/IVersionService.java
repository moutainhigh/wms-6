package com.dx.wms.service;


public interface IVersionService {


    /**
     * 
     * 功能描述: 验证用户上次登录的版本<br>
     * 〈功能详细描述〉
     *
     * @param user 用户对象
     * @return int 1:弹出版本更新公告  2:不弹出
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    int validateVersion(Long userId, Long version);

    
}


