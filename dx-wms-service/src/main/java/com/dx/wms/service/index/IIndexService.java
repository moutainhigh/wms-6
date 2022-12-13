package com.dx.wms.service.index;


/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author tony
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IIndexService<P, R> {

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
    Boolean isSupport(P q);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param t
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String initPage(P q);

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
    R initDate(P q);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void join();
}
