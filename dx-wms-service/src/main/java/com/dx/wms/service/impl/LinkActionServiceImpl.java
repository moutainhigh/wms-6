package com.dx.wms.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cmm.service.cache.ICacheService;
import com.dx.common.service.utils.Assert;
import com.dx.wms.bean.LinkAction;
import com.dx.wms.dao.ILinkActionDao;
import com.dx.wms.service.ILinkActionService;

@Service
public class LinkActionServiceImpl implements ILinkActionService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(LinkActionServiceImpl.class);

    private static final String ALL = "formStatusKey:all";

    private static final String KEY = "formStatusKey:";

    /**
     * 环节行为DAO层服务
     */
    @Autowired
    private ILinkActionDao linkActionDao;

    @Autowired
    private ICacheService<LinkAction> cacheService;

    @Override
    public Map<String, String> queryForMap() {
        List<LinkAction> actions = cacheService.getArray(ALL, LinkAction.class);
        if (!Assert.checkParam(actions)) {
            actions = linkActionDao.queryAll(LinkAction.class);
            cacheService.set(ALL, actions);
        }
        Map<String, String> resultMap = new LinkedHashMap<String, String>();
        if (Assert.checkParam(actions)) {
            for (LinkAction action : actions) {
                resultMap.put(action.getLinkActionId().toString(), action.getDescription());
            }
        }
        return resultMap;
    }

    @Override
    public LinkAction queryById(Long id) {
        if (!Assert.checkParam(id)) {
            LOG.error("Id must not be null");
            return new LinkAction();
        }
        String key = cacheService.initKey(KEY, String.valueOf(id));
        LinkAction action = cacheService.getObject(key, LinkAction.class);
        if (!Assert.checkParam(action)) {
            action = linkActionDao.queryById(LinkAction.class, id);
            cacheService.set(key, action);
        }
        return action;
    }
}
