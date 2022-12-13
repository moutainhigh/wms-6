package com.dx.cmm.service.log;

import java.util.List;

import com.dx.wms.common.IBaseDao;

public interface IMatchLogDao extends IBaseDao<MatchLog> {


	
	List<MatchLog> query(String tableName,Long id);

    

}
