package com.dx.wms.test.file;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.cms.service.IFileInspectService;
import com.dx.cms.service.IFileService;
import com.google.gson.Gson;

public class FileQueryTest extends FileDubboTest {
	
	/**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(FileQueryTest.class);

    @Autowired
    private IFileService fileService;

    @Autowired
    private IFileInspectService fileInspectService;

    //文件夹展开查询文件
    @Test
    public void testFolderContain() {
        Condition condition = new Condition();
        condition.setAppCode("wms");
        condition.setResKey("wmsCustOpenApply");
        condition.setRes(ResKey.WMS_OPEN);
        condition.setCustAccountId(12687L);
        condition.setLenderCustCode("L0533011610100001");
        condition.setCmAction("getFileStoreFile");
        condition.setFileDirId(3l);
        List<FileResultDto> ls = fileService.folderContain(condition);
        LOG.info("***testFolderContain={}***", new Gson().toJson(ls));
    }
    //根据用户编号 和 理财申请编号来查询影像文件夹 
    @Test
    public void testQueryByCode(){
    	List<FolderResultDto> ls = fileService.queryByCode("L0533011610100001", 10509l, null, null, ResKey.WMS_OPEN);
    	LOG.info("***testQueryByCode={}***", new Gson().toJson(ls));
    }
    //查询支付结果文件,执委会提交运营时调用
    @Test
    public void testQueryPayMentFile(){
    	Condition condition = new Condition();
    	condition.setCmAction("ddd");
    	condition.setLenderCode("L0533011610110001-001");
    	condition.setType(1);
    	List<Long> fileIds = fileService.queryPayMentFile(condition);
    	LOG.info("***testQueryPayMentFile={}***", new Gson().toJson(fileIds));
    }
    //查询存放影像文件的文件夹
    @Test
    public void testQueryFolders(){
    	Condition condition = new Condition();
        condition.setAppCode("wms");
        condition.setResKey("wmsCustOpenApply");
        condition.setRes(ResKey.WMS_OPEN);
        condition.setCustAccountId(12687L);
        condition.setLenderCustCode(null);
        List<FolderResultDto> ls = fileService.queryFolders(condition);
        LOG.info("***testQueryFolders={}***", new Gson().toJson(ls));
    }
    
    //根据影像的ids来查询所有的影像数据
    @Test
    public void testQueryFilesByIds(){
    	List<Long> lg = new ArrayList<Long>();
    	lg.add(90l);
    	lg.add(91l);
    	List<FileResultDto> fileResultDtos = fileService.queryFilesByIds(lg);
    	LOG.info("***testQueryFilesByIds={}***", new Gson().toJson(fileResultDtos));
    }
    
    //根据影像的ids来查询所有的影像数据
    @Test
    public void testQueryFilesByIds2(){
    	List<FileResultDto> fileResultDtos = fileService.queryFilesByIds(90l);
    	LOG.info("***testQueryFilesByIds2={}***", new Gson().toJson(fileResultDtos));
    }
    
    
}
