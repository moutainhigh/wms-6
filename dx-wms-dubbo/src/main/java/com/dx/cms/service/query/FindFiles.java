package com.dx.cms.service.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.common.service.utils.Assert;

@Service
public class FindFiles extends QueryRegister{

	@Override
	public List<FileResultDto> query(Condition param) {
		if(!Assert.checkParam(param.getFileIds())){
			return new ArrayList<>();
		}
		return dalClient.queryForList("contentManagement.queryFileInfoByFileId", param(param), FileResultDto.class);
	}

	@Override
	public Boolean supports(Condition param) {
		return Assert.equals(param.getCmAction(), "getFileURLsByIds");
	}

}
