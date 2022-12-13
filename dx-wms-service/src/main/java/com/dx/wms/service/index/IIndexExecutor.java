package com.dx.wms.service.index;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 */
public interface IIndexExecutor<Q, R> {

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param q
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String initPage(Q q);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param q
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    R initDate(Q q);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param matchQueueService
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void regist(IIndexService<Q, R> service);
}
