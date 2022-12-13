package com.dx.cmm.service.log;

import java.util.List;


public interface MatchLogService<T> {
/**
 * 
 * @param id
 * @param msg
 * @param type
 * @return
 */
	boolean update(Long id, String msg, Class<T> type);
	
	Boolean insert(Long relationId,String msg,Class<T> type);
	
	
	List<MatchLog> queryByTable(Class<T> type);
	
	

    List<MatchLog> queryByTable(Class<T> type,Long id);
	
	
	
}
