/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileParsingUtil.java
 * Author:   黄健
 * Date:     2015年8月24日 下午4:17:16
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.service.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.dx.cms.bean.FileDirRelation;
import com.dx.cms.bean.FileType;
import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.ContentDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.client.support.PaginationDalClient;

import de.innosystec.unrar.Archive;
import de.innosystec.unrar.rarfile.FileHeader;

/**
 * 影像文件解析
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FileParsingUtil {
    
    private static String ACTION_CODE = "actioncode";
    
    private static String ACTION_MESSAGE = "actionmessage";
    
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(FileParsingUtil.class);

    /**
     * 
     * 解析上传文件
     *
     * @param dalClient
     * @param file      上传的影像文件
     * @param rarPass   压缩包文件解压密码
     * @param appCode   "wms":"理财管理","rms":"还款管理","ccs":"信贷管理"
     * @param resKey    资源-标示
     * @param openCodes
     * @param destPath  影像文件服务器端保存路径
     * @param contentDto  解析文件后保存数据的对象
     * @param userId    当前登陆用户
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String , Object> parseFile(PaginationDalClient dalClient, File file, 
            String rarPass, String appCode, String resKey, String[] openCodes,String destPath,ContentDto contentDto,Long userId) {
        Map<String , Object> parseStatus = new HashMap<String, Object>();
        Assert.notNull("** parseFile() 解析数据保存对象不能空",contentDto);
        LOG.info("isExistForWMS() param destPath={},appCode={},resKey={},userId={}", 
                destPath,appCode,resKey,userId);
        
        if(null == file || !file.exists() || !file.isFile()) {
            parseStatus.put(ACTION_CODE, "102");
            parseStatus.put(ACTION_MESSAGE, "上传文件未找到,文件解析失败");
            addResultInfoToLog("parseFile", LOG, parseStatus);
            return parseStatus;
        }
        String fileName = file.getName();
        String[] fn = fileName.split("\\.");
        String fileType = fn[fn.length - 1];
//        String filePath = file.getPath();
        
        Archive archive = null;
        if (CMSConstants.RAR.equalsIgnoreCase(fileType)) {
            try {
                List<com.dx.cms.bean.File> uploadFiles = new ArrayList<com.dx.cms.bean.File>();
                Map<String, FileDirRelation> uploadFileDirs = new HashMap<String, FileDirRelation>();
                Map<String,String> fileSaveNames = new HashMap<String, String>();
                archive = new Archive(file, rarPass, false);
                FileHeader fileHeader = archive.nextFileHeader();
                if(null == fileHeader) {
                    parseStatus.put(ACTION_CODE, "402");
                    parseStatus.put(ACTION_MESSAGE, "解析上传文件失败,压缩包数据解析失败");
                    addResultInfoToLog("parseFile", LOG, parseStatus);
                    return parseStatus;
                }
                while (null != fileHeader) {
                    // 影像文件保存名
                    String saveFileName = UUID.randomUUID().toString();
                    // 源影像名称+类型
                    String sFileName = CMSConstants.EMPTY_STRING;
                    if (fileHeader.isUnicode()) {
                        sFileName = fileHeader.getFileNameW().trim();
                    } else {
                        sFileName = fileHeader.getFileNameString().trim();
                    }
                    fileSaveNames.put(sFileName, saveFileName);
                    fn = sFileName.split("\\.");
                    // 源影像类型
                    fileType = fn[fn.length - 1];
                    // 源影像名称
                    String sourceFileName = CMSConstants.EMPTY_STRING;
                    for (int i = 0; i < fn.length - 1; i++) {
                        if (i == fn.length - 2) {
                            sourceFileName += fn[i];
                        } else {
                            sourceFileName += fn[i] + CMSConstants.POINT;
                        }
                    }

//                    String destDirName = WMSConstants.EMPTY_STRING;
                    String destFileName = CMSConstants.EMPTY_STRING;
                    if (!fileHeader.isDirectory()) {
                        // 1 根据不同的操作系统拿到相应的 destDirName 和 destFileName
                        LOG.info("***unrar**File.separator:" + File.separator);
                        if (File.separator.equals("/")) { // 非windows系统
                            destFileName = (destPath + (saveFileName + CMSConstants.POINT + fileType)).replaceAll("\\\\", "/");
//                            destDirName = destFileName.substring(0, destFileName.lastIndexOf("/"));
                        } else { // windows系统
                            destFileName = (destPath + (saveFileName + CMSConstants.POINT + fileType)).replaceAll("/","\\\\");
//                            destDirName = destFileName.substring(0, destFileName.lastIndexOf("\\"));
                        }
                    }
//                    String fileSaveDir = destDirName;
                    LOG.info("***parseFile**destFileName:" + destFileName);
//                    if (StringUtils.isNotBlank(destDirName) && !destDirName.endsWith(File.separator)) {
//                        destDirName += File.separator;
//                    }
//                    LOG.info("***parseFile**destDirName:" + destDirName);
                    
                    com.dx.cms.bean.File uploadFile = new com.dx.cms.bean.File();
                    Map<String, Object> reqs = new HashMap<String, Object>();
                    // 保存文件记录信息
                    reqs.put("fileTypeKey", fileType);
                    List<FileType> list = dalClient.queryForList("fileType.queryFileTypeByKey", reqs, FileType.class);
                    if (null != list && list.size() > 0) {
                        uploadFile.setFileTypeId(list.get(0).getFileTypeId());
                    } else {
                        uploadFile.setFileTypeId(-1L);
                    }
                    uploadFile.setFileSourceName(sourceFileName);
                    uploadFile.setFileSaveName(saveFileName);
                    uploadFile.setFileSize(fileHeader.getUnpSize()); // ??????
                    uploadFile.setCreateUser(Long.valueOf(userId));
                    uploadFiles.add(uploadFile);

                    // 保存文件目录关系记录
                    FileDirRelation fdr = new FileDirRelation();
                    Long fileDirId = getFileDirIdByName(dalClient,sourceFileName, appCode, resKey);
                    if (-1L == fileDirId) {
                        parseStatus.put(ACTION_CODE, "108");
                        parseStatus.put(ACTION_MESSAGE, "上传文件记录信息保存失败");
                        LOG.error("exception[{}]", "根据文件名来查找文件目录失败");
                        return parseStatus;
                    }
                    fdr.setFileDirId(fileDirId);
                    fdr.setFileSaveDir(StringUtils.remove(destPath, "/var/www/wmsres"));
                    fdr.setFileNickname(saveFileName);
                    fdr.setAppCode(appCode);
                    fdr.setCreateUser(Long.valueOf(userId));
                    fdr.setOpenCode(openCodes[0]);
                    uploadFileDirs.put(saveFileName, fdr);
                    
                    fileHeader = archive.nextFileHeader();
                }
//                contentDto.setUploadFiles(uploadFiles);
//                contentDto.setUploadFileDirs(uploadFileDirs);
                contentDto.setFileSaveNames(fileSaveNames);
            } catch (Exception e) {
                e.printStackTrace();
                parseStatus.put(ACTION_CODE, "402");
                parseStatus.put(ACTION_MESSAGE, "文件解析出现异常");
                addResultInfoToLog("parseFile", LOG, parseStatus);
            } finally {
                try {
                    if (archive != null) {
                        archive.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (CMSConstants.JPG.equalsIgnoreCase(fileType) 
                || CMSConstants.PDF.equalsIgnoreCase(fileType)
                || CMSConstants.PNG.equalsIgnoreCase(fileType)) {
            Map<String,String> fileSaveNames = new HashMap<String, String>();
            String saveFileName = UUID.randomUUID().toString();
            
            fn = fileName.split("\\.");
            // 源影像类型
            fileType = fn[fn.length - 1];
            // 源影像名称
            String sourceFileName = CMSConstants.EMPTY_STRING;
            for (int i = 0; i < fn.length - 1; i++) {
                if (i == fn.length - 2) {
                    sourceFileName += fn[i];
                } else {
                    sourceFileName += fn[i] + CMSConstants.POINT;
                }
            }
            fileSaveNames.put(fileName, saveFileName);
            com.dx.cms.bean.File uploadFile = new com.dx.cms.bean.File();
            Map<String, Object> reqs = new HashMap<String, Object>();
            // 保存文件记录信息
            reqs.put("fileTypeKey", fileType);
            List<FileType> list = dalClient.queryForList("fileType.queryFileTypeByKey", reqs, FileType.class);
            if (null != list && list.size() > 0) {
                uploadFile.setFileTypeId(list.get(0).getFileTypeId());
            } else {
                uploadFile.setFileTypeId(-1L);
            }
            uploadFile.setFileSourceName(sourceFileName);
            uploadFile.setFileSaveName(saveFileName);
            uploadFile.setFileSize(file.length());

            // 保存文件目录关系记录
            FileDirRelation fdr = new FileDirRelation();
            Long fileDirId = getFileDirIdByName(dalClient,sourceFileName, appCode, resKey);
            if (-1L == fileDirId) {
                parseStatus.put(ACTION_CODE, "108");
                parseStatus.put(ACTION_MESSAGE, "上传文件记录信息保存失败");
                LOG.error("exception[{}]", "根据文件名来查找文件目录失败");
                return parseStatus;
            }
            fdr.setFileDirId(fileDirId);
            uploadFile.setCreateUser(Long.valueOf(userId));
//            long fileId = fileDao.insert(uploadFile);
//            fdr.setFileId(fileId);
            fdr.setFileSaveDir(StringUtils.remove(destPath, "/var/www/wmsres"));

            fdr.setFileNickname(saveFileName);
            fdr.setAppCode(appCode);
            fdr.setOpenCode(openCodes[0]);
            fdr.setCreateUser(Long.valueOf(userId));
//            fileDirRelationDao.insert(fdr);
//            contentDto.setUploadFile(uploadFile);
//            contentDto.setUploadFileDir(fdr);
            contentDto.setFileSaveNames(fileSaveNames);
        } else {
            parseStatus.put(ACTION_CODE, "105");
            parseStatus.put(ACTION_MESSAGE, "上传文件类型错误");
            addResultInfoToLog("parseFile", LOG, parseStatus);
            return parseStatus;
        }
        
        parseStatus.put(ACTION_CODE, "401");
        parseStatus.put(ACTION_MESSAGE, "文件解析成功");
        return parseStatus;
    }
    
    private static void addResultInfoToLog(String functionName,Logger log,Map<String,Object> map){
        if(null != log && null != map && map.size() > 0 && StringUtils.isNotBlank(functionName)) {
            log.info("****FileParsingUtil****addResultInfoToLog() param functionName = {} , ACTION_CODE = {} , ACTION_MESSAGE = {}",
                    functionName,map.get(ACTION_CODE) , map.get(ACTION_MESSAGE));
        } 
    }
    
    /**
     * 根据文件名来判断文件所属的目录
     *
     * @param sourceFileName 文件名
     * @return 所属目录的编号
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static Long getFileDirIdByName(PaginationDalClient dalClient, String sourceFileName, String appCode, String resKey) {
        LOG.info("**Start**getFileDirIdByName()**");
        LOG.info("getFileDirIdByName() file sourceFileName={},appCode={},resKey={}", sourceFileName, appCode, resKey);
        Assert.notNull("** getFileDirIdByName() 文件名/appCode/resKey不能为空",sourceFileName,appCode,resKey);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appCode", appCode);
        param.put("resKey", resKey);
        List<FolderResultDto> dirsDto = dalClient.queryForList("contentManagement.queryForFolders", param,
                FolderResultDto.class);
        if (CollectionUtils.isEmpty(dirsDto)) {
            LOG.info("**end**getFileDirIdByName()**");
            return -1L;
        } else {
            for (FolderResultDto dto : dirsDto) {
                if (sourceFileName.startsWith(dto.getFileDirKey())) {
                    LOG.info("**end**getFileDirIdByName()**");
                    return dto.getFileDirId();
                }
            }
        }
        LOG.info("**end**getFileDirIdByName()**");
        return -1L;
    }
    
}
