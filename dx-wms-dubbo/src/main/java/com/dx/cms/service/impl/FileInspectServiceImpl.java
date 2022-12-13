/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: FileInspectServiceImpl.java
 * Author:   黄健
 * Date:     2016年1月18日 上午11:42:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.cms.enums.HrFile;
import com.dx.cms.enums.ResKey;
import com.dx.cms.service.IFileInspectService;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.WMSConstants;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class FileInspectServiceImpl implements IFileInspectService {

    @Autowired
    private PaginationDalClient dalClient;

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(FileInspectServiceImpl.class);

    /**
     * 检查上传影像是否是符合规定
     */
    @Override
    public Boolean inpectFileName(String appCode, String fileName, Object... params) {
        Assert.notNull("condition is missing.", appCode, fileName);
        switch (appCode) {
            case CMSConstants.APP_CODE_WMS:
                if (null == params || params.length == 0) {
                    throw new BaseException("condition is missing.");
                }
                return inpectWmsName(appCode, fileName, (String) params[0]);
            case CMSConstants.APP_CODE_HR:
                return inpectHrName(fileName);
            default:
                throw new BaseException("File Source unknown.");
        }
    }

    /**
     * 检查上传的影像文件是否是重复上传
     */
    @Override
    public Boolean isDuplicateFile(String appCode, String fileName, Object... params) {
        Assert.notNull("condition is missing.", appCode, fileName);
        if (null == params || params.length == 0) {
            throw new BaseException("condition is missing.");
        }
        switch (appCode) {
            case CMSConstants.APP_CODE_WMS:
                return isExistsInWMS(Arrays.asList(params).toArray(new String[0]), fileName);
            case CMSConstants.APP_CODE_HR:
                return isExistsInHR();
            default:
                throw new BaseException("File Source unknown.");
        }
    }

    /**
     * 检查理财端上传影像命名
     *
     * @param appCode
     * @param resKey
     * @param fileName
     * @param dalClient
     * @return true--符合规则 false-不符合
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Boolean inpectWmsName(String appCode, String fileName, String resKey) {
        LOG.info("**Start**isInLineWithRuleForWMS()**");
        Assert.notNull("** isInLineWithRuleForWMS() 文件名/appCode/resKey不能为空", fileName, appCode, resKey);
        LOG.info("inpectWmsName() param fileName={},appCode={},resKey={}", fileName, appCode, resKey);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("fileDirKey", fileName.charAt(0) + WMSConstants.EMPTY);
        paramMap.put("appCode", appCode);
        paramMap.put("resKey", resKey);
        List<FolderResultDto> list = dalClient.queryForList("contentManagement.checkFileIsInLineWithRuleForWMS",
                paramMap, FolderResultDto.class);
        if (CollectionUtils.isEmpty(list)) {
            LOG.info("**End**isInLineWithRuleForWMS()****query****false");
            return Boolean.FALSE;
        }
        if (Assert.checkParam(list) && Assert.equals(ResKey.WMS_APPLY.getInfo(), resKey)) {
            if (Assert.equals(fileName.charAt(0) + WMSConstants.EMPTY, "A")
                    || Assert.equals(fileName.charAt(0) + WMSConstants.EMPTY, "B")
                    || Assert.equals(fileName.charAt(0) + WMSConstants.EMPTY, "C")) {
                return Boolean.FALSE;
            }
        }
        Pattern pattern = Pattern.compile("[A-Z]\\s\\((\\d+)\\)");
        if (!pattern.matcher(fileName).matches()) {
            LOG.info("**End**isInLineWithRuleForWMS()***pattern***false");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 检查人事上传影像命名
     *
     * @return true--符合规则 false-不符合
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static Boolean inpectHrName(String fileName) {
        StringBuffer fileNamesBuffer = new StringBuffer();
        for (int j = 0; j < fileName.length(); j++) {
            if (!Character.isDigit(fileName.charAt(j))) {
                fileNamesBuffer.append(fileName.charAt(j));
            }
        }
        for (HrFile hrFile : HrFile.values()) {
            if (Assert.equals(hrFile.getInfo(), fileNamesBuffer.toString())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 判断文件是否重复上传(理财端)
     *
     * @param openCode
     * @param fileName 文件名（不包括格式）
     * @return true -- 之前已经上传过该文件 false -- 未上传过
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Boolean isExistsInWMS(String[] openCodes, String fileName) {
        if (null == openCodes || openCodes.length == 0) {
            throw new BaseException("openCodes cannot be null.");
        }
        Assert.notNull("fileName cannot be null.", fileName);
        LOG.info("isExistsInWMS() param openCodes={},fileName={}", Arrays.toString(openCodes), fileName);
        Map<String, Object> paramMap = MapUtils.getParamMap("fileSourceName", fileName);
        List<FileResultDto> list = null;
        for (String openCode : openCodes) {
            if (Assert.checkParam(openCode)) {
                paramMap.put("openCode", openCode);
                list = dalClient.queryForList("contentManagement.judgeFileIsExist", paramMap, FileResultDto.class);
                if (Assert.checkParam(list)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 判断文件是否重复上传(人事端)
     *
     * @return true -- 之前已经上传过该文件 false -- 未上传过
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Boolean isExistsInHR() {

        return Boolean.FALSE;
    }

    public Boolean inpectFileNames(String appCode, Collection<String> fileNames, Object... params) {
        Assert.notNull("condition is missing.", fileNames);
        for (String fileName : fileNames) {
            if (!inpectFileName(appCode, fileName, params)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean isDuplicateFiles(String appCode, Collection<String> fileNames, Object... params) {
        Assert.notNull("condition is missing.", fileNames);
        for (String fileName : fileNames) {
            if (isDuplicateFile(appCode, fileName, params)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
    
}
