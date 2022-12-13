///*
// * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
// * FileName: HRFiileController.java
// * Author:   黄健
// * Date:     2016年1月19日 下午6:14:16
// * Description: //模块目的、功能描述      
// * History: //修改记录
// * <author>      <time>      <version>    <desc>
// * 修改人姓名             修改时间            版本号                  描述
// */
//package com.dx.wms.web.hr.controller;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//import com.dx.cms.dto.ContentDto;
//import com.dx.cms.dto.FileQueryDto;
//import com.dx.cms.dto.FileValidationDto;
//import com.dx.cms.service.IFileService;
//import com.dx.common.service.utils.Assert;
//import com.dx.common.utils.JavaEnvUtil;
//import com.dx.hr.enums.InfoType;
//import com.dx.hr.service.dto.EmployeeEntryDto;
//import com.dx.hr.service.dto.EmployeeVideoDto;
//import com.dx.hr.service.dto.HandleResultDto;
//import com.dx.wms.utils.FileInspectUtil;
//import com.dx.wms.utils.UploadUtil;
//import com.dx.wms.web.hr.vo.EmployeeVideoVo;
//import com.google.gson.Gson;
//
///**
// * 〈一句话功能简述〉<br> 
// * 〈功能详细描述〉
// *
// * @author huangjian
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Controller
//@RequestMapping("/hrFile")
//public class HRFiileController extends HRController{
//	
//	@Autowired
//	private IFileService fileService;
//	
//	@Value("${wms.web.destPath}")
//    private String destPath = "";
//	
//	private static final String CODE = "code";
//
//    private static final String MSG = "msg";
//	
//	/**
//     * RAR解压缩密码
//     */
//    @Value("${wms.web.rarpwd}")
//    private String rarPwd = "";
//
//    /**
//     * 文件上传导入的临时目录
//     */
//    @Value("${wms.web.temppath}")
//    private String TEMP_PATH = "";
//    
//    @RequestMapping(value = "upload.json", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> fileUpload(@RequestParam("file") CommonsMultipartFile file,
//            @RequestParam("employeeId") Long employeeId, HttpServletRequest request) {
//        // 上传文件基本信息
//        LOG.info("**start**fileUpload()");
//        LOG.info("fileUpload() file name={}/type={}/size={}", file.getName(),file.getContentType(),file.getSize());
//        LOG.info("fileUpload() param OriginalFilename={}/employeeId={}", file.getOriginalFilename(), employeeId);
//        Map<String, Object> result = new HashMap<String,Object>();
//        Long userId = commonService.getUserId(request);
//        File rarFile = null;
//        try {
//            // 临时目录
//            File dir = new File(TEMP_PATH);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            CommonsMultipartResolver mutilpartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//            if (mutilpartResolver.isMultipart(request)) {
//                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//                Iterator<String> it = multiRequest.getFileNames();
//                while (it.hasNext()) {
//                    MultipartFile fileDetail = multiRequest.getFile(it.next());
//                    if (fileDetail != null) {
//                        String path = TEMP_PATH + fileDetail.getOriginalFilename();
//                        rarFile = new File(path);
//                        file.transferTo(rarFile);
//                        FileQueryDto fileQueryDto = new FileQueryDto();
////                        paramMap.put("password", RAR_PWD);// 压缩包解压密码
//                        fileQueryDto.setFile(rarFile);
//                        fileQueryDto.setUserId(userId);
//                        fileQueryDto.setAppCode("hr");
//                        fileQueryDto.setTempPath(fileDetail.getOriginalFilename());
//                        fileQueryDto.setOrgName(commonService.getOrgIdByUserId(userId).toString());
//                        fileQueryDto.setDestPath(destPath);
//                        fileQueryDto.setIsWin(isWindow());
//                        fileQueryDto.setPassword(rarPwd);
//                        FileValidationDto fileValidationDto = FileInspectUtil.inspectFile(rarFile, rarPwd, fileDetail.getOriginalFilename());
//                        fileQueryDto.setFileValidationDto(fileValidationDto);
//                        LOG.info("*********uploadFiles*********  fileQueryDto={}",new Gson().toJson(fileQueryDto));
//                        ContentDto contentDto=fileService.uploadFiles(fileQueryDto);
//                        if(Assert.equals(contentDto.getFileValidationDto().getActionCode(),"201")){
//                        	String nameValidation=fileNameValidation(contentDto.getFileValidationDto().getFileNames(),employeeId);
//                        	if(Assert.equals(nameValidation,"201")){
//                        	String uploadcode = UploadUtil.uploadAction(contentDto);
//                        	if(Assert.equals("101", uploadcode)){
//                        		LOG.info("***FileInsert**  contentDto={}",new Gson().toJson(contentDto));
//                        		if (Assert.equals(insertFile(contentDto, employeeId,destPath),1)) {
//                        			contentDto.getFileValidationDto().setActionCode("101");
//								}
//                        	}else{
//                        		contentDto.getFileValidationDto().setActionCode(uploadcode);
//                        	}
//                        }else{
//                        	contentDto.getFileValidationDto().setActionCode(nameValidation);
//                        }
//                        }
//                        
//                        if (Assert.equals("101", contentDto.getFileValidationDto().getActionCode())) {
//                            result.put(CODE, true);
//                            result.put(MSG, "上传文件成功");
//                        } else if (Assert.equals("109",contentDto.getFileValidationDto().getActionCode())) {
//                            result.put(CODE, false);
//                            result.put(MSG, "上传重复文件,请先检查并删除重复文件,再上传");
//                        } else if (Assert.equals("110",contentDto.getFileValidationDto().getActionCode())) {
//                            result.put(CODE, false);
//                            result.put(MSG, "压缩包中存在重复文件,请先检查压缩包文件,再上传");
//                        } else if (Assert.equals("105",contentDto.getFileValidationDto().getActionCode())) {
//                            result.put(CODE, false);
//                            result.put(MSG, "请遵循影像文件命名规则，重新上传文件");
//                        } else {
//                            result.put(CODE, false);
//                            result.put(MSG, "上传文件失败");
//                        }
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rarFile != null) {
//                rarFile.delete();
//            }
//        }
//        LOG.info("**end**fileUpload() result={}", result);
//        return result;
//    }
//    
//    @RequestMapping(value = "deleteFiles.json")
//    @ResponseBody
//    public HandleResultDto deleteFiles(@RequestBody EmployeeVideoVo employeeVideoVo, HttpServletRequest request) {
//        LOG.info("**start**ContentsManageController**deleteFiles()");
//        Assert.notNull("employeeVideoDto cannot be null", employeeVideoVo);
//        Assert.notNull("employeeVideoDto.employeeVideoId cannot be null", employeeVideoVo.getEmployeeVideoId());
//        Assert.notNull("employeeVideoDto.employeeId cannot be null", employeeVideoVo.getEmployeeId());
//        Long userId = commonService.getUserId(request);
//        return commonService.deleteVideo(employeeVideoVo.getEmployeeVideoId(), userId, InfoType.VIDEO.getCode());
//    }
//    
//    /**
//     * 判断当前系统是否是Windows
//     *
//     * @return
//     * @see [相关类/方法](可选)
//     * @since [产品/模块版本](可选)
//     */
//    private Boolean isWindow() {
//        return StringUtils.startsWith(JavaEnvUtil.getEnvOsVersion(), "Windows");
//    }
//    
//    
//    @RequestMapping(value = "queryFile.json", method = RequestMethod.POST)
//    @ResponseBody
//    public List<EmployeeVideoDto> queryFile(@RequestParam("employeeId") Long employeeId ){
//    	EmployeeEntryDto detail = commonService.queryEmployeeDetailByEmployeeId(employeeId);
//    	return detail.getEmployeeVideoDtos();
//    }
//    
//}
