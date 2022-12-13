package com.dx.cms.service.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dx.cms.dto.Condition;
import com.dx.cms.dto.FileResultDto;
import com.dx.cms.exception.FileException;
import com.dx.cms.service.query.FileQueryGateway;
import com.dx.cms.service.util.FileActionUtil;
import com.dx.common.service.utils.Assert;
import com.dx.framework.dal.transaction.annotation.Transactional;
import com.google.gson.Gson;

@Service("effectiveFiles")
public class MakeFileDir extends ActionRouter<Condition, Boolean> {

    @Autowired
    private FileQueryGateway gateway;

    /**
     * 生效表t_file中记录的sqlid
     */
    private static final String EFFECT_T_FILE_SQLID = "contentManagement.makeFileStatusEffective";

    /**
     * 生效表t_file_dir_relation中记录的sqlid
     */
    private static final String EFFECT_T_FILE_DIR_RELATION_SQLID = "contentManagement.makeFileDirRelationStatusEffective";

    @Override
    public Boolean execute(Condition param) throws FileException {
        LOG.info("**start**execute() param={}", new Gson().toJson(param));
        if (!Assert.checkParam(param.getAppCode()) || !Assert.checkParam(param.getRes())) {
            LOG.info("**end**execute()**Parameter is missing**false");
            return false;
        }
        return effectiveFiles(FileActionUtil.getExecuteParam(param), param);
    }

    /**
     * 生效影像文件记录
     *
     * @param oldOpenCode 临时openCode = appCode+resKey+用户主键或业务主键
     * @param newOpenCode 用户编号或业务编号
     * @param userId 生效人
     * @return true -- 文件生效成功 false -- 文件生效失败
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @Transactional
    private boolean effectiveFiles(Map<String, Object> paramMap, Condition param) {
        param.setAppCode((String) paramMap.get("openCode"));
        List<FileResultDto> list = gateway.query(param);
        List<Long> fileIds = new ArrayList<Long>();
        if (Assert.checkParam(list)) {
            for (FileResultDto dto : list) {
                fileIds.add(dto.getFileId());
            }
            paramMap.put("fileIds", fileIds);
            dalClient.execute(EFFECT_T_FILE_SQLID, paramMap);
            dalClient.execute(EFFECT_T_FILE_DIR_RELATION_SQLID, paramMap);
        }
        return true;
    }

}
