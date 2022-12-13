package com.dx.cmm.service.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dx.common.service.utils.Assert;
import com.dx.wms.common.BaseDaoImpl;

@Component
public class MatchLogDaoImpl extends BaseDaoImpl<MatchLog> implements IMatchLogDao {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(MatchLogDaoImpl.class);


       @Override
    public List<MatchLog> query(String tableName,Long relationId) {
        Map<String, Object> param = new HashMap<>();
        param.put("table", tableName);
       
            param.put("Id", relationId);
     
        return dalClient.queryForList("matchLog.queryByTable", param, MatchLog.class);
       
    }

         
    }

