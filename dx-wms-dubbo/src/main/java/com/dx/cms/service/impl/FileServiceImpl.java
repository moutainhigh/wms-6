package com.dx.cms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.Condition;
import com.dx.cms.dto.ContentDto;
import com.dx.cms.dto.FileQueryDto;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.cms.enums.ResKey;
import com.dx.cms.service.IFileService;
import com.dx.cms.service.action.FileAction;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.client.support.PaginationDalClient;
import com.dx.framework.exception.BaseException;
import com.google.gson.Gson;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author huangjian
 */
public class FileServiceImpl implements IFileService {

    /**
     * 日志组件
     */
    private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private PaginationDalClient dalClient;

    @Autowired
    private FileAction<Condition, List<FileResultDto>> queryFiles;

    @Autowired
    private FileAction<Condition, List<FileResultDto>> queryFileUrl;
    
    @Autowired
    private FileAction<Condition, Boolean> deleteFile;

    @Override
    public void delete(Condition condition, Long userId) {
        Assert.notNull("Condtion must not be null", condition);
        Assert.notNull("User must not be null", userId);
        condition.setUser(userId);
        deleteFile.execute(condition);
    }

    @Autowired
    private FileAction<Condition, List<FolderResultDto>> queryFolders;

    @Override
    public List<FileResultDto> folderContain(Condition condition) {
        Assert.notNull("** folderContain() conditionsDto must not be null", condition);
        LOG.info("** folderContain() conditionsDto:{}", new Gson().toJson(condition));
        return queryFileUrl.execute(condition);
    }

    @Override
    public List<FolderResultDto> queryFolders(Condition condition) {
        Assert.notNull("** queryFolders() conditionsDto must not be null", condition);
        LOG.info("** queryFolders() conditionsDto:{}", new Gson().toJson(condition));
        condition.setCmAction(CMSConstants.CMS_CMACTION_QUERY_FOLDERS);
        return queryFolders.execute(condition);
    }

    @Autowired
    private FileAction<Condition, Boolean> effectiveFiles;

    @Override
    public Boolean effectiveFiles(Condition condition, Long userId) {
        Assert.notNull("** effectiveFiles() condition must not be null", condition);
        Assert.notNull("** effectiveFiles() userId must not be null", userId);
        LOG.info("** effectiveFiles() condition:{},userId:{}", new Gson().toJson(condition), userId);
        condition.setCmAction(CMSConstants.CMS_CMACTION_EFFECTIVE_FILES);
        condition.setUser(userId);
        return effectiveFiles.execute(condition);
    }

    @Autowired
    private FileAction<FileQueryDto, ContentDto> uploadService;

    @Override
    public ContentDto uploadFiles(FileQueryDto fileQueryDto) {
        return uploadService.execute(fileQueryDto);
    }

    @Override
    public List<FileResultDto> queryFilesByIds(Long... fileIds) {
        List<Long> ids = new ArrayList<>();
        for (Long fileId : fileIds) {
            ids.add(fileId);
        }
        return folderContain(new Condition(ids, "getFileURLsByIds"));
    }

    @Override
    public List<FolderResultDto> queryByCode(String lenderCustCode, Long custAccountId, String lenderCode,
            Long lenderApplyId, ResKey... resKey) {
        Assert.notNull("custAccountId can not be null", custAccountId);
        if (null == resKey || resKey.length == 0) {
            throw new BaseException("resKey cannot be null");
        }
        Set<String> openCodes = new HashSet<String>();
        // 根据resKey返回相应的文件夹
        Set<Integer> fileDirIds = new HashSet<Integer>();
        for (ResKey res : resKey) {
            fileDirIds.addAll(res.getDirs());
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("appCode", CMSConstants.APP_CODE_WMS);
        paramMap.put("fileDirIds", fileDirIds);
        List<FolderResultDto> folders = dalClient.queryForList("contentManagement.queryFoldersByDirIds", paramMap,
                FolderResultDto.class);
        paramMap.remove("fileDirIds");
        for (ResKey res : resKey) {
            if (CMSConstants.WMS_CUST_OPEN_APPLY.equals(res)) {
                if (!Assert.checkParam(lenderCustCode)) {
                    openCodes.add(CMSConstants.APP_CODE_WMS + CMSConstants.WMS_CUST_OPEN_APPLY + custAccountId);
                } else {
                    openCodes.add(lenderCustCode);
                }
            } else if (CMSConstants.WMS_CUST_LENDER_APPLY.equals(res)) {
                openCodes.add(lenderCustCode);
                if (!Assert.checkParam(lenderCustCode)) {
                    openCodes.add(CMSConstants.APP_CODE_WMS + CMSConstants.WMS_CUST_LENDER_APPLY + lenderApplyId);
                } else {
                    openCodes.add(lenderCode);
                }
            } else {
                openCodes.add(lenderCustCode);
                openCodes.add(lenderCode);
                openCodes.add(CMSConstants.APP_CODE_WMS + res + lenderApplyId);
            }
        }
        paramMap.put("openCodes", openCodes);
        for (FolderResultDto folder : folders) {
            paramMap.put("fileDirId", folder.getFileDirId());
            List<FileResultDto> files = dalClient.queryForList("contentManagement.queryForFiles", paramMap,
                    FileResultDto.class);
            folder.setFileResultDtoes(files);
            folder.setFileNumber(files.size());
        }
        LOG.info("************folders=[{}]***", new Gson().toJson(folders));
        return folders;
    }

    @Override
    public List<FileResultDto> queryFilesByIds(List<Long> fileIds) {
        Assert.notNull("fileIds cannot be null.", fileIds);
        return folderContain(new Condition(fileIds, "getFileURLsByIds"));
    }

    @Autowired
    FileAction<Condition, List<Long>> queryPayMent;

    @Override
    public List<Long> queryPayMentFile(Condition condition) {
        return queryPayMent.execute(condition);
    }

    @Autowired
    FileAction<ContentDto, String> fileInsert;

    @Override
    public String FileInsert(ContentDto contentDto) {
        return fileInsert.execute(contentDto);
    }

}
