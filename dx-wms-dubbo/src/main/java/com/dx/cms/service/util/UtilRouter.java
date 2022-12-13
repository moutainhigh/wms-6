package com.dx.cms.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
@Service
public class UtilRouter implements FileUtilGateway{
	
	private List<FileUtil> fileutil = new ArrayList<>();

	@Override
	public void regist(FileUtil util) {
		fileutil.add(util);
	}

	@Override
	public List<FileResultDto> fileUtil(Condition param,
			List<FileResultDto> pList,Long fileDirId) {
		for (FileUtil util : fileutil) {
            if (util.supports(param)) {
               return util.action(param, pList,fileDirId);
            }
        }
		return new ArrayList<>();
		
	}
	
	

}
