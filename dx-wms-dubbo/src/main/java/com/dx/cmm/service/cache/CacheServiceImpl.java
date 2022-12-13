package com.dx.cmm.service.cache;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dx.common.service.utils.Assert;
import com.dx.framework.redis.client.IRedisClient;

@Service
public class CacheServiceImpl<T> implements ICacheService<T> {

    /**
     * 一周时效
     */
    private static final Integer ONE_WEEK_SEC = 604800000;

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(CacheServiceImpl.class);

    /**
     * 缓存服务
     */
    @Autowired
    private IRedisClient wmsRedisClient;

    @Override
    public List<T> getArray(String key, Class<T> type) {
        String val = get(key);
        if (Assert.checkParam(val) && !StringUtils.equals(val, "null")) {
            return JSON.parseArray(get(key), type);
        }
        return Collections.emptyList();
    }

    @Override
    public T getObject(String key, Class<T> type) {
        String val = get(key);
        if (Assert.checkParam(val) && !StringUtils.equals(val, "null")) {
            return JSON.parseObject(val, type);
        }
        return null;
    }

    private String get(String key) {
        LOG.info("Read key:{}", key);
        Assert.notNull("param is null", key);
        try {
            return wmsRedisClient.get(key);
        } catch (Exception e) {
            LOG.error("Read error[{}]", e);
            return null;
        }
    }

    @Override
    public void set(String key, Integer times, String val) {
        LOG.info("Write key[{}],times[{}],val[{}]", key, times, val);
        Assert.notNull("param is null", key, times, val);
        try {
            wmsRedisClient.setex(key, times, val);
        } catch (Exception e) {
            LOG.error("Write key[{}],times[{}],val[{}]", key, times, val, e);
        }
    }

    @Override
    public void set(String key, String val) {
        set(key, ONE_WEEK_SEC, val);
    }

    @Override
    public void set(String key, Integer times, T t) {
        set(key, times, JSON.toJSONString(t));
    }

    @Override
    public void set(String key, T t) {
        set(key, ONE_WEEK_SEC, JSON.toJSONString(t));
    }

    @Override
    public void set(String key, List<T> t) {
        set(key, ONE_WEEK_SEC, JSON.toJSONString(t));

    }

    @Override
    public void set(String key, Integer times, List<T> t) {
        set(key, times, JSON.toJSONString(t));
    }

    @Override
    public String initKey(String arg0, Object... args) {
        Assert.notNull("param is null", arg0, args);
        for (Object arg : args) {
            arg0 = arg0.concat(arg.toString());
        }
        return arg0;
    }

    @Override
    public void del(String key) {
        wmsRedisClient.del(key);
    }

    @Override
    public void del(String arg0, Object... arg1) {
        del(initKey(arg0, arg1));
    }

    @Override
    public Boolean exists(String key) {
        return wmsRedisClient.exists(key);
    }

    @Override
    public Set<String> keys(String pattern) {
        return wmsRedisClient.keys(pattern);
    }

}
