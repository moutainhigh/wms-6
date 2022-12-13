package com.dx.wms.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.framework.redis.client.IRedisClient;
import com.dx.wms.dao.IVersionDao;
import com.dx.wms.dto.VersionNoticeDto;
import com.dx.wms.service.IVersionService;

@Service
public class VersionServiceImpl implements IVersionService{
    
    /**
     * 一个月时效
     */
    private static final Integer ONE_MONTH_SEC = 2592000;
    
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(VersionServiceImpl.class);

    
    @Autowired
    private IVersionDao versionDao;
    
    @Autowired
    private IRedisClient redisClient;
    
    @Override
    public int validateVersion(Long userId, Long versionId) {
        LOG.info("get() key:{} value:{}", userId, versionId);
        Assert.notNull("param is null", userId, versionId);
        String keyName = "user:"+userId;
        try {
            Map<String, String> redisUser = redisClient.hgetAll(keyName);
            //返回1:弹窗  返回2:不弹窗
            if (redisUser.get("userId") != null){
                //缓存不为空，直接比较
                if (versionId != Long.parseLong(redisUser.get("versionId"))){
                    versionDao.updateVersionNotice(userId, versionId);
                    return 1;
                } else {
                    return 2;
                }          
            } else {
                //缓存为空，查询后比较
                VersionNoticeDto dto = versionDao.queryVersionNotice(userId);
                if (!Assert.checkParam(dto)){
                    versionDao.addVersionNotice(userId, versionId);
                    return 1;
                } else{
                    if (versionId != dto.getVersionId()){
                        versionDao.updateVersionNotice(userId, versionId);
                        return 1;
                    }
                    return 2;
                }
            }
        } catch (Exception e) {
            LOG.error("getAll() error:{}", e);
            return 1;
        } finally {
            LOG.info("set() key:{},field:{},val:{}", keyName, userId.toString(), versionId.toString());
            Assert.notNull("param is null", keyName, userId.toString(), versionId.toString());
            try {
                redisClient.hset(keyName, "userId", userId.toString());
                redisClient.hset(keyName, "versionId", versionId.toString());
                redisClient.expire(keyName, ONE_MONTH_SEC);
            } catch (Exception e) {
                LOG.error("hset() error:{}", e);
            }
        }
    }
   
}
