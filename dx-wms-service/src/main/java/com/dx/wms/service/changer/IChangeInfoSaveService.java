package com.dx.wms.service.changer;

public interface IChangeInfoSaveService {
    /**
     * 
     * 功能描述: 保存变更日志
     * 〈功能详细描述〉
     *
     * @param log
     * @param userId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void save(ChangeLog changeLog, Long userId) ;
    
}
