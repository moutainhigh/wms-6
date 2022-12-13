package com.dx.wms.service.builder;

/**
 * 
 * 建造者
 *
 * @author tony
 */
public interface Builder<T> {

    void build(Long id, T t);

}
