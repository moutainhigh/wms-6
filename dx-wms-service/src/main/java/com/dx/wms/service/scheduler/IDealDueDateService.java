package com.dx.wms.service.scheduler;

public interface IDealDueDateService {
    
    /**
     * 
     * 功能描述: 处理 到期数据
     * 〈功能详细描述〉
     *
     */
    void dealDueDate();
    
    /**
     * 
     * 功能描述: 处理即将到期数据
     * 〈功能详细描述〉
     *
     */
    void dealSoonDue();
}
