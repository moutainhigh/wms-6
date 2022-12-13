package com.dx.cmm.service.restorer;

/**
 * 
 * 修复器
 *
 * @author tony
 */
public interface Restorer<T> {

    void repair(T t) throws RepairException;
}
