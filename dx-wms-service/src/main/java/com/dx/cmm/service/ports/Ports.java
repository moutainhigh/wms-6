package com.dx.cmm.service.ports;

import java.util.Date;

/**
 * 
 * 端口
 *
 * @author tony
 */
public interface Ports<T> {

    /**
     * 
     * 功能描述: <br>
     * 根据端口号筛选当前报告日
     *
     * @param port
     * @return
     */
    Date current(Integer port);

    /**
     * 
     * 功能描述: <br>
     * 根据端口号筛选下个报告日
     *
     * @param port
     * @return
     */
    Date next(Integer port);

    /**
     * 
     * 功能描述: <br>
     * 根据日期筛选端口号
     *
     * @param param
     * @param rule
     * @return
     */
    Integer query(Date param);

    /**
     * 
     * 功能描述: <br>
     * 更新端口号
     *
     * @param port
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void update(Integer port);

}
