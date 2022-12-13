package com.dx.wms.utils;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.ContentDto;
import com.dx.cms.dto.FileDto;
import com.dx.cms.enums.AllowFileTypes;
import com.dx.common.fileUpload.utils.UnzipFileUtil;
import com.dx.common.service.utils.Assert;

public class UploadUtil {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(UploadUtil.class);

    public static String uploadAction(ContentDto contentDto) {
        java.io.File dir = new java.io.File(contentDto.getUploadFile().getSavePath());
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
        if (AllowFileTypes.checkFileType(AllowFileTypes.RAR_FILE_TYPES,
                contentDto.getFileValidationDto().getUploadFile().getType())) {
            return uploadRar(contentDto.getFileQueryDto().getFile(), contentDto.getFileQueryDto().getPassword(),
                    contentDto, contentDto.getFileValidationDto().getFileDtoes());
        } else {
            return uploadJpgOrPdf(contentDto.getFileValidationDto().getFileDtoes().get(0), contentDto);
        }
    }

    private static String uploadJpgOrPdf(FileDto fileDto, ContentDto contentDto) {
        // 上传文件保存名
        try {
            if (!Assert.checkParam(fileDto.getFile()) || !fileDto.getFile().exists() || !fileDto.getFile().isFile()) {
                return "102";
            }
            String saveFileName = contentDto.getFileSaveNames().get(fileDto.getFullName());
            // 文件复制生成的新文件 路径+新文件名称+文件类型
            String targetUrl = new StringBuffer().append(fileDto.getSavePath()).append(saveFileName)
                    .append(CMSConstants.POINT).append(fileDto.getType()).toString();
            // 生成新的影像文件
            FileMoveUtil.moveFile(fileDto.getFile().getPath(), targetUrl);
            // 影像文件类型转换 文件物理保存
            Map<String, Object> convertFilesResult = FileConvertUtils.convertFileType(fileDto.getSavePath(),
                    saveFileName, fileDto.getType());
            String convertKey = (String) convertFilesResult.get(CMSConstants.ACTION_CODE);
            if (!"301".equals(convertKey)) {
                // 文件类型转换过程出现错误或异常
                return convertKey;
            }
            return "101";
        } catch (Exception e) {
            e.printStackTrace();
            return "108";
        }
    }

    private static String uploadRar(java.io.File file, String password, ContentDto contentDto,
            List<FileDto> fileDtoes) {
        // 解压上传的压缩包
        try {
            Map<String, Object> operationStatus = UnzipFileUtil.unrar(file, password, fileDtoes.get(0).getSavePath(),
                    contentDto.getFileSaveNames());
            String resultCode = (String) operationStatus.get(CMSConstants.ACTION_CODE);
            if (!"101".equals(resultCode)) {
                return resultCode;
            }
            LOG.info("  *** uploadRar() resultCode = {} *** ", resultCode);
            // 文件格式转换
            operationStatus = FileConvertUtils.convertFiles(fileDtoes);
            resultCode = (String) operationStatus.get(CMSConstants.ACTION_CODE);
            if (!"301".equals(resultCode)) {
                return resultCode;
            }
            return "101";

        } catch (Exception e) {
            e.printStackTrace();
            return "108";
        }

    }

}
