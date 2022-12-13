package com.dx.cms.service;

import java.util.Collection;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IFileInspectService {

    /**
     * 影像命名方式检查
     *
     * @param appCode 影像来源
     * @param fileName 文件名
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean inpectFileName(String appCode, String fileName, Object... params);

    Boolean inpectFileNames(String appCode, Collection<String> fileNames, Object... params);

    /**
     * 影像是否已经上传过
     *
     * @param appCode 影像来源
     * @param fileName 文件名
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean isDuplicateFile(String appCode, String fileName, Object... params);

    Boolean isDuplicateFiles(String appCode, Collection<String> fileNames, Object... params);

}
