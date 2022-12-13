package com.dx.wms.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dx.wms.common.BaseDaoImpl;
import com.dx.wms.dao.IVersionDao;
import com.dx.wms.dto.VersionNoticeDto;

@Component
public class VersionDaoImpl  extends BaseDaoImpl<VersionNoticeDto> implements IVersionDao{


    @Override
    public Long queryVersion() {
        Map<String, Object> params = new HashMap<String, Object>();
        Long versionId = dalClient.queryForObject("versionNotice.queryVersion", params, Long.class);
        System.out.println("执行查询，结果为"+versionId);
        return versionId;
    }

    @Override
    public VersionNoticeDto queryVersionNotice(Long userId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        VersionNoticeDto dto = dalClient.queryForObject("versionNotice.queryVersionNotice", params, VersionNoticeDto.class);
        return dto;
    }

    
    @Override
    public void addVersionNotice(Long userId, Long versionId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        params.put("versionId", versionId);
        dalClient.execute("versionNotice.addVersionNotice", params);
        return;
    }

    @Override
    public void updateVersionNotice(Long userId, Long versionId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        params.put("versionId", versionId);
        dalClient.execute("versionNotice.updateVersionNotice", params);
        return;
    }

    
}