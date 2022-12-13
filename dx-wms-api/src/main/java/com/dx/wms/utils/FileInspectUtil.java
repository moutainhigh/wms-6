/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileInspectUtil.java
 * Author:   黄健
 * Date:     2015年8月17日 下午3:08:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.cms.dto.FileDto;
import com.dx.cms.dto.FileValidationDto;
import com.dx.cms.enums.AllowFileTypes;
import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.WMSConstants;

import de.innosystec.unrar.Archive;
import de.innosystec.unrar.rarfile.FileHeader;

/**
 * 上传文件校验
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FileInspectUtil {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(FileInspectUtil.class);

    public static final String UPLOAD_FILE = "uploadFile";

    public static final String FILEDTOES = "fileDtoes";

    public static final String FILENAMES = "fileNames";

    /**
     * 文件基础校验 1.文件格式 2.文件大小 3.压缩包中文件是否有重复
     *
     * @param file 上传文件
     * @param rarPass 解压密码
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static FileValidationDto inspectFile(File file, String rarPass,String tempPath) {
        // 校验上传的文件格式是否支持
        List<FileDto> fileDtoes = new ArrayList<FileDto>();
        FileDto uploadFile = new FileDto();
        Set<String> fileNames = new HashSet<String>();
        FileValidationDto fileValidationDto = new FileValidationDto();
        LOG.info(" *** inspectFileRealName() *** fileName={},path={},tempPath={}", file.getName(),file.getPath(),tempPath);
        uploadFile = getFileBaseInfo(tempPath);
        if (!Assert.checkParam(uploadFile)
                || !AllowFileTypes.checkFileType(AllowFileTypes.ALL_FILE_TYPES, uploadFile.getType())) {
            fileValidationDto.setActionCode("105");
            return fileValidationDto;
        }
        // 校验上传文件大小,压缩包文件不得大于20M,其他文件不得大于1M
        if (!checkFileSize(uploadFile.getType(), file.length())) {
            fileValidationDto.setActionCode("107");
            return fileValidationDto;
        }
        uploadFile.setFullName(file.getName());
        uploadFile.setFile(file);
        try {
            fileDtoes = parseFile(uploadFile, rarPass);
        } catch (Exception e) {
            LOG.info("parseFile e.message = ", e.getMessage());
            fileValidationDto.setActionCode("102");
            return fileValidationDto;
        }
        for (FileDto fileDto : fileDtoes) {
            // 校验上传的文件格式是否支持
            if (!AllowFileTypes.checkFileType(AllowFileTypes.OTHER_FILE_TYPES, fileDto.getType())) {
                fileValidationDto.setActionCode("105");
                return fileValidationDto;
            }
            // 校验上传文件大小,单个文件不得大于1M
            if (!checkFileSize(fileDto.getType(), fileDto.getSize())) {
                fileValidationDto.setActionCode("107");
                return fileValidationDto;
            }
            // 校验压缩包文件是否包含重复文件
            if (fileNames.contains(fileDto.getName())) {
                fileValidationDto.setActionCode("110");
                return fileValidationDto;
            } else {
                fileNames.add(fileDto.getName());
            }
        }
        fileValidationDto.setFileNames(fileNames);
        fileValidationDto.setFileDtoes(fileDtoes);
        fileValidationDto.setUploadFile(uploadFile);
        fileValidationDto.setActionCode("201");
        return fileValidationDto;
    }

    /**
     * 获取上传文件的基本信息
     *
     * @param fileName
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static FileDto getFileBaseInfo(String fileName) {
        Assert.notNull("fileName cannot be null", fileName);
        LOG.info(" *** getFileBaseInfo() *** fileName={}", fileName);
        String[] fn = fileName.split("\\.");
        if (fn.length < 2) {
            return null;
        }
        fileName = "";
        for (int i = 0; i < fn.length - 1; i++) {
            if (i == fn.length - 2) {
                fileName += fn[i];
            } else {
                fileName += fn[i] + WMSConstants.POINT;
            }
        }
        LOG.info(" *** getFileBaseInfo() *** fileName={},fn={}", fileName, fn[fn.length - 1]);
        return new FileDto(fileName, fn[fn.length - 1]);
    }

    /**
     * 校验上传文件大小 压缩包文件不得大于20M,其他文件不得大于1M
     *
     * @param fileType 文件格式
     * @param fileSize 文件大小
     * @return true--校验通过 false--校验不通过
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static Boolean checkFileSize(String fileType, Long fileSize) {
        if (AllowFileTypes.checkFileType(AllowFileTypes.RAR_FILE_TYPES, fileType)) {
            // 压缩包大小不得超过20M
            return (Long.compare(fileSize, 1024 * 1024 * 20) > 0) ? Boolean.FALSE : Boolean.TRUE;
        } else if (AllowFileTypes.checkFileType(AllowFileTypes.OTHER_FILE_TYPES, fileType)) {
            // 单个文件大小不得超过1M
            return (Long.compare(fileSize, 1024 * 1024) > 0) ? Boolean.FALSE : Boolean.TRUE;
        }
        throw new BaseException("file'type is wrong.");
    }

    public static List<FileDto> parseFile(FileDto fileDto, String rarPass) {
        List<FileDto> fileDtoes = new ArrayList<FileDto>();
        Archive archive = null;
        if (AllowFileTypes.checkFileType(AllowFileTypes.RAR_FILE_TYPES, fileDto.getType())) {
            try {
                archive = new Archive(fileDto.getFile(), rarPass, false);
                FileHeader fileHeader = archive.nextFileHeader();
                if (null == fileHeader) {
                    throw new BaseException("解析上传文件失败,压缩包数据解析失败");
                }
                while (null != fileHeader) {
                    // 源影像名称+类型
                    String sFileName = WMSConstants.EMPTY;
                    if (fileHeader.isUnicode()) {
                        sFileName = fileHeader.getFileNameW().trim();
                    } else {
                        sFileName = fileHeader.getFileNameString().trim();
                    }
                    fileDto = FileInspectUtil.getFileBaseInfo(sFileName);
                    if (!Assert.checkParam(fileDto)) {
                        throw new BaseException("上传文件格式错误");
                    }
                    fileDto.setFullName(sFileName);
                    fileDto.setSize(fileHeader.getUnpSize());
                    fileDtoes.add(fileDto);
                    fileHeader = archive.nextFileHeader();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    archive.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (AllowFileTypes.checkFileType(AllowFileTypes.OTHER_FILE_TYPES, fileDto.getType())) {
            fileDto.setSize(fileDto.getFile().length());
            fileDto.setFullName(fileDto.getFile().getName());
            fileDtoes.add(fileDto);
        } else {
            throw new BaseException("上传文件类型错误");
        }
        return fileDtoes;
    }

}
