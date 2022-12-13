package com.dx.cmm.service.interests;

/**
 * 
 * 利息
 *
 * @author tony
 */
public interface Interest<P, R> {

    R calc(P param);
    
}
