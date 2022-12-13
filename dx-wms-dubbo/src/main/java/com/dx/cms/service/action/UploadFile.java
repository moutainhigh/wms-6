package com.dx.cms.service.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.dx.cms.bean.FileType;
import com.dx.cms.dao.IFileTypeDao;
import com.dx.cms.dto.ContentDto;
import com.dx.cms.dto.FileDirRelationDto;
import com.dx.cms.dto.FileDto;
import com.dx.cms.dto.FileQueryDto;
import com.dx.cms.dto.FileValidationDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.cms.exception.FileException;
import com.dx.cms.service.IFileInspectService;
import com.dx.common.service.utils.Assert;
import com.dx.framework.exception.BaseException;
import com.dx.wms.constant.WMSConstants;
import com.dx.wms.utils.FileSavePathUtil;
import com.google.gson.Gson;

@Service("uploadService")
public class UploadFile extends ActionRouter<FileQueryDto, ContentDto> {

    @Autowired
    private IFileTypeDao fileTypeDao;

    @Autowired
    private IFileInspectService fileInspectService;

    @Override
    public ContentDto execute(FileQueryDto param) throws FileException {
        LOG.info("***UploadFile execute() FileQueryDto={}***", new Gson().toJson(param));
        validate(param);
        // 用户主键和业务主键不能同时为空
        ContentDto contentDto = new ContentDto();

        if (Assert.equals(param.getAppCode(), "wms") && !Assert.checkParam(param.getLenderCustId())
                && !Assert.checkParam(param.getLenderId())) {
            contentDto.getFileValidationDto().setActionCode("103");
            return contentDto;
        }

        String[] openCodes = getCode(param);
        try {

            // 校验文件名是否符合要求
            if (!fileInspectService.inpectFileNames(param.getAppCode(), param.getFileValidationDto().getFileNames(),
                    param.getResKey())) {
                contentDto.getFileValidationDto().setActionCode("105");
                return contentDto;
            }
            // 判断该文件是否已经上传,同时检验参数是否完整
            if (fileInspectService.isDuplicateFiles(param.getAppCode(), param.getFileValidationDto().getFileNames(),
                    openCodes[0], openCodes[1])) {
                contentDto.getFileValidationDto().setActionCode("109");
                return contentDto;
            }
            // 获取解压目标路径
            String destDirName = FileSavePathUtil.getFileSavePath(param.getAppCode(), param.getOrgName(),
                    param.getLenderCustId(), openCodes[0], param.getDestPath(), param.getIsWin());
            // 详细解析上传文件
            try {
                return parseFile(param.getFileValidationDto(), param, openCodes, destDirName, param.getUserId());
            } catch (Exception e) {
                contentDto.getFileValidationDto().setActionCode("102");
                return contentDto;
            }
        } catch (Exception e) {
            contentDto.getFileValidationDto().setActionCode("104");
            return contentDto;
        }

    }

    public ContentDto parseFile(FileValidationDto fileValidationDto, FileQueryDto param, String[] openCodes,
            String destPath, Long userId) {
        LOG.info("parseFile() param appCode={},resKey={},destPath={},userId={}", param.getAppCode(), param.getResKey(),
                destPath, userId);
        LOG.info("**uploadJpgOrPdf() param fileDtoes={}", JSON.toJSONString(fileValidationDto.getFileDtoes()));
        LOG.info("**uploadJpgOrPdf() param openCodes={}", JSON.toJSONString(openCodes));
        ContentDto contentDto = new ContentDto();
        String basePath = FileSavePathUtil.getFileBasePath(param.getAppCode());
        Map<String, FileType> fileTypes = getFileTypes();
        Map<String, String> fileSaveNames = new HashMap<String, String>();
        List<FileDto> uploadFiles = new ArrayList<FileDto>();
        Map<String, FileDirRelationDto> uploadFileDirs = new HashMap<String, FileDirRelationDto>();
        for (FileDto fileDto : fileValidationDto.getFileDtoes()) {
            fileDto.setSaveName(UUID.randomUUID().toString());
            fileDto.setSavePath(destPath);
            fileSaveNames.put(fileDto.getFullName(), fileDto.getSaveName());
            FileDto uploadFile = new FileDto();
            // new FileDto();
            FileType fileType = fileTypes.get(fileDto.getType().toLowerCase());
            if (!Assert.checkParam(fileType)) {
                throw new BaseException("上传文件类型不确定.");
            }
            uploadFile.setFileTypeId(fileType.getFileTypeId());
            uploadFile.setFileSourceName(fileDto.getName());
            uploadFile.setSavePath(destPath);
            uploadFile.setFileSaveName(fileDto.getSaveName());
            uploadFile.setFileSize(fileDto.getSize());
            uploadFile.setCreateUser(userId);
            uploadFiles.add(uploadFile);
            // 保存文件目录关系记录
            FileDirRelationDto fdr = new FileDirRelationDto();
            if (Assert.equals(param.getAppCode(), "wms")) {
                Long fileDirId = getFileDirIdByName(fileDto.getName(), param.getAppCode(), param.getResKey());
                if (-1L == fileDirId) {
                    throw new BaseException("上传文件记录所属目录不确定.");
                }
                fdr.setFileDirId(fileDirId);
            }
            fdr.setFileSaveDir(StringUtils.remove(fileDto.getSavePath(), basePath));
            fdr.setFileNickname(fileDto.getSaveName());
            fdr.setAppCode(param.getAppCode());
            fdr.setCreateUser(userId);
            fdr.setOpenCode(openCodes[0]);
            uploadFileDirs.put(fileDto.getSaveName(), fdr);
            contentDto.setUploadFile(uploadFile);
            contentDto.setUploadFileDir(fdr);
        }
        contentDto.setUploadFiles(uploadFiles);
        contentDto.setUploadFileDirs(uploadFileDirs);
        contentDto.setFileSaveNames(fileSaveNames);
        contentDto.setFileQueryDto(param);
        contentDto.setFileValidationDto(fileValidationDto);
        return contentDto;
    }

    private Map<String, FileType> getFileTypes() {
        List<FileType> list = fileTypeDao.queryAll(FileType.class);
        Map<String, FileType> ret = null;
        if (Assert.checkParam(list)) {
            ret = new HashMap<String, FileType>();
            for (FileType type : list) {
                ret.put(type.getFileTypeKey(), type);
            }
            return ret;
        }
        throw new BaseException("file types are empty.");
    }

    private Long getFileDirIdByName(String sourceFileName, String appCode, String resKey) {
        LOG.info("**Start**getFileDirIdByName()**");
        LOG.info("getFileDirIdByName() file sourceFileName={},appCode={},resKey={}", sourceFileName, appCode, resKey);
        Assert.notNull("** getFileDirIdByName() 文件名/appCode/resKey不能为空", sourceFileName, appCode, resKey);
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

    private String[] getCode(FileQueryDto param) {
        LOG.info("*** UploadFile getCode() param={}", new Gson().toJson(param));
        String[] openCodes = new String[2];
        StringBuffer openCode = new StringBuffer();
        if (!Assert.checkParam(param.getResKey())) {
            openCodes[0] = "";
            openCodes[1] = "";
            return openCodes;
        }
        if (Assert.equals(WMSConstants.WMS_CUST_OPEN_APPLY, param.getResKey())) {
            // 开户
            openCodes[0] = openCode.append(param.getAppCode()).append(param.getResKey()).append(param.getLenderCustId())
                    .toString();
            openCodes[1] = StringUtils.isBlank(param.getLenderCustCode()) ? "" : param.getLenderCustCode();
        } else {
            openCodes[0] = openCode.append(param.getAppCode()).append(param.getResKey()).append(param.getLenderId())
                    .toString();
            openCodes[1] = StringUtils.isBlank(param.getLenderCode()) ? "" : param.getLenderCode();
        }
        return openCodes;
    }

    private void validate(FileQueryDto param) {
        Assert.notNull(new FileException("组织Id不能为空"), param.getOrgName());
        Assert.notNull(new FileException("用户Id不能为空"), param.getUserId());
        Assert.notNull(new FileException("系统编码不能为空"), param.getAppCode());
    }

}
