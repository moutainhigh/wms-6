package com.dx.cmm.service.cache;

import java.util.List;
import java.util.Set;

/**
 * 
 * 缓存服务
 *
 * @author tony
 */
public interface ICacheService<T> {

    /**
     * 
     * 功能描述: <br>
     * 获取缓存
     *
     * @param key
     * @param type
     * @return
     */
    List<T> getArray(String key, Class<T> type);

    /**
     * 
     * 功能描述: <br>
     * 获取缓存
     *
     * @param key
     * @param type
     * @return
     */
    T getObject(String key, Class<T> type);

    /**
     * 
     * 功能描述: <br>
     * 封装缓存
     *
     * @param key
     * @param times
     * @param val
     */
    void set(String key, Integer times, String val);

    /**
     * 
     * 功能描述: <br>
     * 封装缓存
     *
     * @param key
     * @param val
     */
    void set(String key, String val);

    /**
     * 
     * 功能描述: <br>
     * 封装缓存
     *
     * @param key
     * @param times
     * @param t
     */
    void set(String key, Integer times, T t);

    /**
     * 
     * 功能描述: <br>
     * 封装缓存
     *
     * @param key
     * @param t
     */
    void set(String key, T t);

    /**
     * 
     * 功能描述: <br>
     * 封装缓存
     *
     * @param key
     * @param t
     */
    void set(String key, List<T> t);

    /**
     * 
     * 功能描述: <br>
     * 封装缓存
     *
     * @param key
     * @param times
     * @param t
     */
    void set(String key, Integer times, List<T> t);

    /**
     * 
     * 功能描述: <br>
     * 初始化key
     *
     * @param arg0
     * @param arg1
     * @return
     */
    String initKey(String arg0, Object... arg1);

    /**
     * 
     * 功能描述: <br>
     * 清除缓存
     *
     * @param key
     */
    void del(String key);

    /**
     * 
     * 功能描述: <br>
     * 清除缓存
     *
     * @param arg0
     * @param args
     */
    void del(String arg0, Object... args);

    /**
     * 
     * 功能描述: <br>
     * 是否存在
     *
     * @param key
     * @return
     */
    Boolean exists(String key);

    /**
     * 
     * 功能描述: <br>
     * 根据模式筛选
     *
     * @param pattern
     * @return
     */
    Set<String> keys(String pattern);
}
