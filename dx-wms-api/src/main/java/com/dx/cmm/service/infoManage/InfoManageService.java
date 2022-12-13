package com.dx.cmm.service.infoManage;

import java.util.List;

import com.dx.cmm.service.infoManage.dto.InfoManageParamDto;
import com.dx.cmm.service.infoManage.dto.InfoManageResultDto;
import com.dx.framework.dal.pagination.Pagination;
import com.dx.framework.dal.pagination.PaginationResult;

public interface InfoManageService {
	PaginationResult<List<InfoManageResultDto>> queryList(InfoManageParamDto param, Pagination page);
}
