package com.dx.cmm.service.view;

import java.util.Date;

/**
 * 
 * 匹配
 *
 * @author tony
 */
public interface IMatchViewService<T> {

    /**
     * 
     * 功能描述: <br>
     * 根据出借编号筛选
     *
     * @param lenderCode
     * @return
     */
    T query(String lenderCode);
    
    T query(String lenderCode,Boolean isEffect);
    
    T query(String lenderCode, Date reportDay);
    
}
