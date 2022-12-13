package com.dx.cms.service.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cms.bean.FileDirRelation;
import com.dx.cms.dao.IFileDao;
import com.dx.cms.dao.IFileDirRelationDao;
import com.dx.cms.dto.ContentDto;
import com.dx.cms.dto.FileDirRelationDto;
import com.dx.cms.dto.FileDto;
import com.dx.cms.enums.AllowFileTypes;
import com.dx.cms.exception.FileException;
import com.dx.framework.dal.transaction.annotation.Transactional;
@Service("fileInsert")
public class FileInsert extends ActionRouter<ContentDto, String>{
	
	@Autowired 
	private IFileDirRelationDao fileDirRelationDao;
	
	@Autowired
	private IFileDao fileDao;
	

	@Override
	@Transactional
	public String execute(ContentDto param) throws FileException {
      if (AllowFileTypes.checkFileType(AllowFileTypes.RAR_FILE_TYPES, param.getFileValidationDto().getUploadFile().getType())) {
      // 解压上传的压缩包
       // 影像文件数据保存
       insertFiles(getFile(param.getUploadFiles()),getFileDir(param.getUploadFileDirs()));
       return "101";
  } else {
       insertFile(param.getUploadFile(),param.getUploadFileDir());
       return "101";
  }
}
	
	private void insertFiles(List<com.dx.cms.bean.File> uploadFiles,
			Map<String, FileDirRelation> uploadFileDirs){
		    for(int i=0;i<uploadFiles.size();i++){
            long fileId = fileDao.insert(uploadFiles.get(i));
            FileDirRelation fileDirRelation = uploadFileDirs.get(uploadFiles.get(i).getFileSaveName());
            fileDirRelation.setFileId(fileId);
            fileDirRelationDao.insert(fileDirRelation);
		    }
	}
	
	
	private void insertFile(FileDto fileDto,FileDirRelationDto fileDirRelationDto){
		com.dx.cms.bean.File uploadFileOne = new com.dx.cms.bean.File();
        BeanUtils.copyProperties(fileDto, uploadFileOne);
        FileDirRelation fdr = new FileDirRelation();
        BeanUtils.copyProperties(fileDirRelationDto,fdr);
        fdr.setFileId(fileDao.insert(uploadFileOne));
        fileDirRelationDao.insert(fdr);
	}
	
	private List<com.dx.cms.bean.File> getFile(List<FileDto> fileDtos){
		List<com.dx.cms.bean.File> files = new ArrayList<com.dx.cms.bean.File>();
		for(int i=0;i<fileDtos.size();i++){
			com.dx.cms.bean.File file = new com.dx.cms.bean.File();
			BeanUtils.copyProperties(fileDtos.get(i), file);
			files.add(file);
		}
		return files;
	}
	
	private Map<String, FileDirRelation> getFileDir(Map<String, FileDirRelationDto> fileDirRelationDtos){
		Map<String, FileDirRelation> fileDirRelationMap = new HashMap<String, FileDirRelation>();
		@SuppressWarnings("rawtypes")
		Iterator it=fileDirRelationDtos.keySet().iterator();    
		while(it.hasNext()){    
			FileDirRelation fileDirRelation = new FileDirRelation();
		     String key = it.next().toString();
		     FileDirRelationDto fileDirRelationDto = fileDirRelationDtos.get(key);
		     BeanUtils.copyProperties(fileDirRelationDto, fileDirRelation);
		     fileDirRelationMap.put(key, fileDirRelation);
		}
		return fileDirRelationMap;
	}

}
