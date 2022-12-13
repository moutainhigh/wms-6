package com.dx.cmm.service.conditions;

/**
 * 
 * 条件
 *
 * @author tony
 */
public interface Condition<P> {

    Boolean judge(P param);
    
}
