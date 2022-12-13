package com.dx.wms.service.changer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;
import com.dx.wms.service.log.LogJsonDto;
import com.google.gson.Gson;

@Service
public class ChangeInfoSaveServiceImpl implements IChangeInfoSaveService {
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(ChangeInfoSaveServiceImpl.class);

    /**
     * 日志dao
     */
    @Autowired
    private IChangeLogDao changeLogDao;

    @Override
    public void save(ChangeLog log, Long userId) {
        LOG.info("**变更日志保存 save() log={},userId={}**", new Gson().toJson(log), userId);
        Assert.notNull("**save() log can be not null**", log);
        LogJsonDto dto = log.getLogJsonDto();
        dto.setModifyDate(new Date().toString());
        log.setContent(new Gson().toJson(dto));
        log.setCreateUser(userId);
        log.setCreateTime(new Date());
        log.setUpdateUser(userId);
        log.setDataStatus("A");
        changeLogDao.insert(log);
    }
}
