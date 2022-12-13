package com.dx.wms.test.file;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.testng.annotations.Test;

import com.dx.ccs.vo.OrgVo;
import com.dx.ccs.vo.UserVo;
import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.Condition;
import com.dx.cms.dto.ContentDto;
import com.dx.cms.dto.FileQueryDto;
import com.dx.cms.dto.FileValidationDto;
import com.dx.cms.enums.ResKey;
import com.dx.cms.service.IFileService;
import com.dx.common.service.utils.Assert;
import com.dx.wms.utils.FileInspectUtil;
import com.dx.wms.utils.UploadUtil;
import com.google.gson.Gson;

public class UploadTest extends FileDubboTest {
	
	/**
     * 日志组件
     */
    static final Logger LOG = LoggerFactory.getLogger(UploadTest.class);

    @Autowired
    private IFileService fileService;

    // @Test
    // public void test(){
    // FileQueryDto fileQueryDto = new FileQueryDto();
    // fileQueryDto.setAppCode("wms");
    // fileQueryDto.setResKey("wmsCustOpenApply");
    // fileQueryDto.setPassword("123");
    // fileQueryDto.setFile(new File("E:\\temp\\1.rar"));
    // fileQueryDto.setLenderCustId(656l);
    // fileQueryDto.setOrgName("265");
    // fileQueryDto.setUserId(392L);
    // fileQueryDto.setLenderCustCode("L0533011604180002");
    // fileQueryDto.setDestPath("E:\\\\");
    // fileQueryDto.setTempPath("1.rar");
    // fileQueryDto.setIsWin(true);
    // FileValidationDto fileValidationDto = FileInspectUtil.inspectFile(fileQueryDto.getFile(),
    // fileQueryDto.getPassword(),
    // fileQueryDto.getTempPath());
    // fileQueryDto.setFileValidationDto(fileValidationDto);
    // ContentDto contentDto= fileService.uploadFiles(fileQueryDto);
    // UploadUtil.uploadAction(contentDto);
    // }

    //影像文件上传
    @Test
    public void test_1() {
        FileQueryDto fileQueryDto = new FileQueryDto();
        fileQueryDto.setAppCode("wms");
        fileQueryDto.setDestPath("E:\\\\");
        File rarFile = null;
        // 临时目录
        File dir = new File(fileQueryDto.getDestPath());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        fileQueryDto.setResKey("wmsCustLenderApply");
        // 压缩包解压密码
        fileQueryDto.setIsWin(true);
        fileQueryDto.setTempPath("E (03).pdf");
        fileQueryDto.setPassword("123");
        fileQueryDto.setFile(new File("C:\\Users\\NTJIMMY98\\Desktop\\file\\file\\E (01).pdf"));
        fileQueryDto.setLenderCustId(677L);
        fileQueryDto.setLenderId(12808L);
        fileQueryDto.setOrgName(265 + CMSConstants.EMPTY_STRING);
        fileQueryDto.setUserId(392L);
        fileQueryDto.setLenderCustCode("L0533011605020001");
        FileValidationDto fileValidationDto = FileInspectUtil.inspectFile(fileQueryDto.getFile(), fileQueryDto.getPassword(),
                "E (03).pdf");
        fileQueryDto.setFileValidationDto(fileValidationDto);
        ContentDto contentDto = fileService.uploadFiles(fileQueryDto);
        LOG.info("***testQueryPayMentFile={}***", new Gson().toJson(fileValidationDto));
        if (Assert.equals(contentDto.getFileValidationDto().getActionCode(), "201")) {
            String uploadcode = UploadUtil.uploadAction(contentDto);
            if (Assert.equals("101", uploadcode)) {
                LOG.info("***testQueryPayMentFile={}***", new Gson().toJson(fileService.FileInsert(contentDto)));
            } else {
                contentDto.getFileValidationDto().setActionCode(uploadcode);
            }
        }

        // 文件大小不能超过20兆

        
    }
    //删除影像文件
    @Test
    public void testDel(){
    	Condition condition = new Condition();
    	condition.setAppCode("wms");
    	condition.setFileDirId(6l);
    	condition.setFileId(95947l);
    	fileService.delete(condition, null);
    }
    
  //删除影像文件
    @Test
    public void testIns(){
//    	ContentDto contentDto = new ContentDto();
//    	contentDto.s
//    	fileService.FileInsert(contentDto);
    }
}
