/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: FileConvertUtil.java
 * Author:   黄健
 * Date:     2015年8月20日 下午5:31:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.FileDto;
import com.dx.common.fileUpload.utils.ImgConverterUtil;
import com.dx.common.fileUpload.utils.Jpg2Pdf;
import com.dx.common.fileUpload.utils.Pdf2Swf;
import com.dx.common.service.utils.Assert;
import com.google.gson.Gson;

/**
 * 文件类型转化
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FileConvertUtils {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(FileConvertUtils.class);

    /**
     * 上传影像文件格式转化
     *
     * @param destPath 影像文件存储目录
     * @param fileSaveName 影像文件保存名
     * @param fileType 影像文件类型
     * @return 301 -- 转换成功 302 -- 转换出现异常 303 -- 上传文件类型转换失败,参数存在空值 304 -- 上传文件类型转换失败,转换文件不存在 305 -- 上传文件类型转换失败,转换文件格式不支持
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Map<String, Object> convertFileType(String destPath, String fileSaveName, String fileType) {
        Assert.notNull("影像文件存储目录不能为空", destPath);
        Assert.notNull("影像文件保存名不能为空", fileSaveName);
        Assert.notNull("影像文件类型不能为空", fileType);
        LOG.info("destPath[{}],fileSaveName[{}],fileType[{}]", destPath, fileSaveName, fileType);
        if (!destPath.endsWith(File.separator)) {
            destPath = new StringBuffer().append(destPath).append(File.separator).toString();
        }
        StringBuffer buf = new StringBuffer();
        buf.append(destPath);
        buf.append(fileSaveName);
        buf.append(".");
        buf.append(fileType);
        LOG.info("buf[{}]", buf.toString());
        File destFile = new File(buf.toString());
        if (!destFile.exists()) {
            buf = new StringBuffer();
            buf.append(destPath);
            buf.append(fileSaveName);
            buf.append(".");
            buf.append(fileType.toLowerCase());
            destFile = new File(buf.toString());
            LOG.info(" ***convertFileType() buf.toString()={}***", buf.toString());
            if (!destFile.exists()) {
                return MapResultUtil.getMapResult("304", "上传文件类型转换失败,转换文件不存在");
            }
        }
        try {
            if ("jpg".equalsIgnoreCase(fileType)) {
                ArrayList<String> imageUrllist = new ArrayList<String>();
                imageUrllist.add(buf.toString());
                File file = Jpg2Pdf.Pdf(imageUrllist, destPath + fileSaveName + ".pdf");
                LOG.info("***jpg to pdf success**");
                file.createNewFile();
                boolean parseToSWF = Pdf2Swf.pdf2swf(destPath + fileSaveName + ".pdf",
                        destPath + fileSaveName + ".swf");
                LOG.info("*** pdf to swf **" + parseToSWF);
            } else if ("png".equalsIgnoreCase(fileType)) {
                String jpgUrl = new StringBuffer().append(destPath).append(fileSaveName).append(".jpg").toString();
                ImgConverterUtil.convert(buf.toString(), "jpg", jpgUrl);
                ArrayList<String> imageUrllist = new ArrayList<String>();
                imageUrllist.add(jpgUrl);
                String pdfUrl = new StringBuffer().append(destPath).append(fileSaveName).append(".pdf").toString();
                File file = Jpg2Pdf.Pdf(imageUrllist, pdfUrl);
                LOG.info("***jpg to pdf success**");
                file.createNewFile();
                LOG.info("***create pdf success**");
                String swfUrl = new StringBuffer().append(destPath).append(fileSaveName).append(".swf").toString();
                boolean parseToSWF = Pdf2Swf.pdf2swf(pdfUrl, swfUrl);
                LOG.info("*** pdf to swf **" + parseToSWF);
            } else if ("pdf".equalsIgnoreCase(fileType)) {
                boolean parseToSWF = Pdf2Swf.pdf2swf(buf.toString(), destPath + fileSaveName + ".swf");
                LOG.info("*** pdf to swf **" + parseToSWF);
            } else {
                return MapResultUtil.getMapResult("305", "上传文件类型转换失败,转换文件格式不支持");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MapResultUtil.getMapResult("302", "上传文件类型转换失败");
        }
        LOG.info(" *** convertFileType()   上传文件类型转换成功**** ");
        return MapResultUtil.getMapResult("301", "上传文件类型转换成功");
    }

    public static Map<String, Object> convertFiles(List<FileDto> files) {
        Assert.notNull("fileDtoes cannot be null", files);
        LOG.info("  *** convertFiles() fileDtoes={} ***", new Gson().toJson(files));
        Map<String, Object> convertStatus = null;
        String convertResult = null;
        for (FileDto fileDto : files) {
            convertStatus = convertFileType(fileDto.getSavePath(), fileDto.getSaveName(), fileDto.getType());
            convertResult = (String) convertStatus.get(CMSConstants.ACTION_CODE);
            if (!"301".equals(convertResult)) {
                return convertStatus;
            }
        }
        return MapResultUtil.getMapResult("301", "上传文件类型转换成功");
    }

}
