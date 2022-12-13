package com.dx.cms.service.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cms.constant.CMSConstants;
import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.dto.FolderResultDto;
import com.dx.cms.exception.FileException;
import com.dx.cms.service.query.FileQueryGateway;
import com.dx.cms.service.util.FileUtilGateway;
import com.dx.common.service.utils.Assert;
import com.dx.common.service.utils.MapUtils;
import com.google.gson.Gson;

@Service("queryFolders")
public class QueryFolders extends ActionRouter<Condition, List<FolderResultDto>> {

    @Autowired
    private FileQueryGateway gateway;

    @Autowired
    private FileUtilGateway util;

    private Boolean validate(Condition param) {
        return Assert.checkParam(param) || Assert.checkParam(param.getAppCode()) || Assert.checkParam(param.getRes());
    }

    @Override
    public List<FolderResultDto> execute(Condition param) throws FileException {
        LOG.info("**start**queryFolders**execute() param={}", new Gson().toJson(param));
        if (!validate(param)) {
            return new ArrayList<FolderResultDto>();
        }
        List<FolderResultDto> dirsDto = dalClient.queryForList("contentManagement.queryForFolders",
                MapUtils.obj2Map(param), FolderResultDto.class);
        if (null == dirsDto) {
            return new ArrayList<FolderResultDto>();
        }
        param.setCmAction(CMSConstants.CMS_CMACTION_QUERY_FILES);
        List<FileResultDto> fileList = gateway.query(param);
        for (int i = 0; i < dirsDto.size(); i++) {
            List<FileResultDto> files = util.fileUtil(param, fileList, dirsDto.get(i).getFileDirId());
            dirsDto.get(i).setFileNumber(files.size());
        }
        return dirsDto;
    }
}
