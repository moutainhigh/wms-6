package com.dx.cms.service.util;

import java.util.List;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;

public interface FileUtilGateway {
	
	void regist(FileUtil util);

	List<FileResultDto> fileUtil(Condition param,List<FileResultDto> pList,Long fileDirId);

}
