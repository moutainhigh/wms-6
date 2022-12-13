package com.dx.cms.service.util;

import java.util.List;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;

public interface FileUtil {
	
	List<FileResultDto> action(Condition param,List<FileResultDto> pList,Long fileDirId);
    
    Boolean supports(Condition param);
    
    void join();

}
