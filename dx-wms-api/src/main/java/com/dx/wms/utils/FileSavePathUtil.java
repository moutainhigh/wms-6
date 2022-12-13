/*
 * Copyright (C), 2015-2016, 达信财富投资管理（上海）有限公司
 * FileName: FileSavePathUtil.java
 * Author:   黄健
 * Date:     2016年1月16日 下午8:35:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.wms.utils;

import java.io.File;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dx.cms.constant.CMSConstants;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.DateUtils;
import com.dx.common.utils.JavaEnvUtil;
import com.dx.framework.exception.BaseException;

/**
 * 上传影像存储路径
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FileSavePathUtil {
    
    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(FileSavePathUtil.class);
    
    public static String getFileBasePath(String appCode) {
        switch (appCode) {
            case CMSConstants.APP_CODE_WMS:
                return CMSConstants.WMS_FILE_PATH;
            case CMSConstants.APP_CODE_HR:
                return CMSConstants.HR_FILE_PATH;    
            default:
                throw new BaseException("File Source unknown.");
        }
    }
    
    public static String getFileSavePath(String appCode, Object... params) {
        Assert.notNull("appCode cannot be null or empty.", appCode);
        if(null == params || params.length == 0) {
            throw new BaseException("condition is missing.");
        }
        switch (appCode) {
            case CMSConstants.APP_CODE_WMS:
                return getWmsPath((String)params[0], (Long)params[1], (String)params[2], (String)params[3],(Boolean)params[4]);
            case CMSConstants.APP_CODE_HR:
                return getHrPath((String)params[0],(String)params[3],(Boolean)params[4]);    
            default:
                throw new BaseException("File Source unknown.");
        }
    }
    
    /**
     * 理财端 影像文件存储路径
     *
     * @param orgName
     * @param lenderCustId
     * @param openCodes
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getWmsPath(String orgName , Long lenderCustId, String openCode, String tempPath,Boolean pathIsWin){
        Assert.notNull("** getFileSavePath() orgName不能为空",orgName);
        Assert.notNull("** getFileSavePath() lenderCustId不能为空",lenderCustId);
        Assert.notNull("** getFileSavePath() openCode不能为空",openCode);
        LOG.info("getFileSavePath param orgName={},lenderCustId={},openCodes={},tempPath={},pathIsWin={}", orgName, lenderCustId, openCode,tempPath,pathIsWin);
        StringBuffer buf = new StringBuffer();
        String pathSeparator = pathIsWin?"\\":File.separator;
        buf.append(pathIsWin?tempPath:(tempPath+File.separator))
            .append(orgName).append(pathSeparator)
            .append(DateUtils.format(new Date(), "yyyy-MM-dd")).append(pathSeparator)
            .append(lenderCustId).append(pathSeparator)
            .append(openCode).append(pathSeparator);
        LOG.info("getFileSavePath return : "+buf.toString());
        return buf.toString();
    }
    
    /**
     * 判断当前系统是否是Windows
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static Boolean isWindow() {
        return StringUtils.startsWith(JavaEnvUtil.getEnvOsVersion(), "Windows");
    }
    
    /**
     * 人事端 影像存储路径
     *
     * @param orgName
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getHrPath(String orgName, String tempPath,Boolean pathIsWin) {
        Assert.notNull("** getFileSavePath() orgName不能为空",orgName);
        Boolean isWin = isWindow();
        if(!isWin) {
            Assert.notNull("destPath cannot be null.",tempPath);
        }
        LOG.info("getFileSavePath param orgName={} ", orgName);
        String pathSeparator = pathIsWin?"\\":File.separator;
        StringBuffer buf = new StringBuffer()
                        .append(pathIsWin ? tempPath : (tempPath+File.separator))
                        .append(orgName).append(pathSeparator)
                        .append(DateUtils.format(new Date(), "yyyy-MM-dd")).append(pathSeparator)
                        .append(System.currentTimeMillis()).append(pathSeparator);
        LOG.info("getFileSavePath return : "+buf.toString());
        return buf.toString();
    }
    
//    private static String dealPath(Boolean isWindow,String path) {
//        if(isWindow) { // windows系统
//             return path.replaceAll("/","\\\\");
//        } else { // 非windows系统
//            return path.replaceAll("\\\\", "/");
//        }
//    }
    
    
}
