package com.dx.wms.service.scheduler;

public interface ILenderDestoryService {
    /**
     * 
     * 功能描述: 处理续投单子 过期作废的数据
     * 〈功能详细描述〉
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void destoryContinue();
    
    /**
     * 
     * 功能描述: 推送需要作废的数据给还款 〈功能详细描述〉
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void destory();
}
