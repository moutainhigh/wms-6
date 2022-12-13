package com.dx.cmm.service.log;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.common.service.utils.Assert;

@Service
public class MatchLogServiceImpl<T> implements MatchLogService<T> {

    private static final Logger LOG = LoggerFactory.getLogger(MatchLogServiceImpl.class);

    @Autowired
    private IMatchLogDao matchLogDao;

    @Override
    public boolean update(Long id, String msg, Class<T> type) {
        MatchLog ml = new MatchLog();
        ml.setRelationId(id);
        ml.setRelationTable(type.toString());
        ml.setLogMsg(msg);
        return matchLogDao.update(ml);
    }

    private Boolean isTable(Class<T> type) {
        return Assert.checkParam(type.getAnnotation(Entity.class));
    }

    @Override
    public Boolean insert(Long relationId, String msg, Class<T> type) {
        if (!isTable(type)) {
            return false;
        }
        MatchLog matchLog = new MatchLog();
        matchLog.setRelationId(relationId);
        matchLog.setLogMsg(msg);
        matchLog.setRelationTable(getTableName(type));
        matchLogDao.insert(matchLog);
        return true;
    }

    private String getTableName(Class<T> type) {
        Entity entity = type.getAnnotation(Entity.class);
        String tableName = entity.name();
        return tableName;
    }
    
    @Override
    public List<MatchLog> queryByTable(Class<T> type) {
        if (!isTable(type)) {
            return new ArrayList<>();
        }
        return matchLogDao.query(getTableName(type),null);
    }
   
      
    
    @Override
    public List<MatchLog> queryByTable(Class<T> type, Long id) {
        if (!isTable(type)) {
            return new ArrayList<>();
           
    }
        return matchLogDao.query(getTableName(type),id);
        
}
   
    
}
 
    
    

