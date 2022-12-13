package com.dx.cms.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.common.service.utils.Assert;
@Service
public class LenderCheckSet extends UtilRegister{

	@Override
	public List<FileResultDto> action(Condition param,List<FileResultDto> pList,Long fileDirId) {
		List<FileResultDto> list = new ArrayList<FileResultDto>();
			if (Assert.checkParam(param.getLenderCustCode())) {
				// 查询 客户的基础影像文件
				spliceList(
						list,
						getFileList(pList, param.getAppCode(),param.getLenderCustCode(),
								fileDirId));
			}
			if (Assert.checkParam(param.getLenderCode())) {
				// 查询 上次提交的申请中上传的文件
				spliceList(list,
						getFileList(pList,param.getAppCode(),param.getLenderCode(), fileDirId));
			}
		return list;
	}

	@Override
	public Boolean supports(Condition param) {
		return Assert.equals(param.getRes(), ResKey.WMS_CHECK);
	}

}
