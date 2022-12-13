/*
 * Copyright (C), 2015-2015, 达信财富投资管理（上海）有限公司
 * FileName: ILenderFileService.java
 * Author:   黄健
 * Date:     2015年9月14日 下午5:05:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.dx.cms.service;

import java.util.List;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.ContentDto;
import com.dx.cms.dto.FileQueryDto;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.cms.exception.FileException;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IFileService {

    /**
     * 根据影像的ids来查询所有的影像数据
     *
     * @param fileIds 影像文件id集合
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<FileResultDto> queryFilesByIds(Long... fileIds);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param fileIds
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<FileResultDto> queryFilesByIds(List<Long> fileIds);

    /**
     * 删除影像文件
     *
     * @param conditionDto 包含appCode,fileDIrId,fileId的信息
     * @param userId 操作人工号
     */
    void delete(Condition condition, Long userId) throws FileException;

    /**
     * 文件夹展开 查询文件
     *
     * @param conditionDto 包含appCode,fileDIrId,resKey(用户主键、用户编号、业务主键、业务编号)的信息
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<FileResultDto> folderContain(Condition condition);

    /**
     * 查询存放影像文件的文件夹
     *
     * @param conditionDto 包含appCode,resKey(用户主键、用户编号、业务主键、业务编号)的信息
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<FolderResultDto> queryFolders(Condition condition);

    /**
     * 生效影像文件
     *
     * @param conditionsDto
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Boolean effectiveFiles(Condition condition, Long userId);

    /**
     * 影像文件上传
     *
     * @param paramMap
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ContentDto uploadFiles(FileQueryDto fileQueryDto);

    /**
     * 根据用户编号 和 理财申请编号来查询影像文件夹 注 : 1.影像文件夹中包含该用户的相应影像文件 2.返回值中的集合不会为null
     *
     * @param lenderCustCode 用户编号(选填)
     * @param custAccountId(必填)
     * @param lenderCode 理财申请编号(选填)
     * @param lenderApplyId 理财申请主键(选填)
     * @param resKey 资源标示(必填)
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<FolderResultDto> queryByCode(String lenderCustCode, Long custAccountId, String lenderCode, Long lenderApplyId,
            ResKey... resKey);

    List<Long> queryPayMentFile(Condition condition);

    String FileInsert(ContentDto contentDto);
}
